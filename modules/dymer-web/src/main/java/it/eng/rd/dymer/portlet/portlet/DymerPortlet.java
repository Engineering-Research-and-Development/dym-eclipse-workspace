package it.eng.rd.dymer.portlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Cookie;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.dymer.model.Dymer;
import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.portlet.constants.DymerPortletKeys;
import it.eng.rd.dymer.service.DymerEntryLocalService;
import it.eng.rd.dymer.service.DymerLocalService;
import it.eng.rd.dymer.web.util.crypto.AesCrypto;

/**
 * @author ENGRD
 */
@SuppressWarnings("deprecation")
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
		    "javax.portlet.expiration-cache=0",
			"javax.portlet.display-name=Dymer",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/dymer/view.jsp",
			"javax.portlet.name=" + DymerPortletKeys.DYMER,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)

public class DymerPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws IOException, PortletException {
		
	    try {
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(
	            Dymer.class.getName(), renderRequest);

	        long groupId = serviceContext.getScopeGroupId();

	        long dymerId = ParamUtil.getLong(renderRequest, "dymerId");
	        
	        _log.info("DymerPortlet, render method");
	        _log.info("groupId: "+groupId);
	        _log.info("dymerId: "+dymerId);

	        List<Dymer> dymers = _dymerLocalService.getDymers(groupId);
	        
	        if (dymers.isEmpty()) {
	        	_log.info("dymers.isEmpty");
	        	
	            Dymer dymer = _dymerLocalService.addDymer(serviceContext.getUserId(), "default", serviceContext);
	           
	            dymerId = dymer.getDymerId();
	            
	            _log.info("dymers.isEmpty dymerId "+ dymerId);
	        } 
	        
	        if (dymerId == 0) {
	        	_log.info("dymerId == 0");
	            dymerId = dymers.get(0).getDymerId();
	            _log.info("dymerId "+dymerId);
	        }
	        
	        renderRequest.setAttribute("dymerId", dymerId);
	        
	        try {
				setCookies(renderRequest, renderResponse);
				    
			} catch (PortalException e) {
				_log.error(e,e);
			}
	        
	    }
	    catch (Exception e) {
	        throw new PortletException(e);
	    }
	    
	    
	    super.render(renderRequest, renderResponse);
	}
	
	private void setCookies(RenderRequest renderRequest, RenderResponse renderResponse) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User currentUser = themeDisplay.getUser();
		
		String[] jwts = AesCrypto.dymerJwts(currentUser, themeDisplay.getScopeGroupId());
		
		String dymerJwt = AesCrypto.encrypting(jwts[0]);
		if (dymerJwt.equalsIgnoreCase(jwts[0])){	
			dymerJwt = new String (Base64.getEncoder().encode(dymerJwt.getBytes()));
			if (_log.isDebugEnabled())
				_log.debug(" dymerJwt base64: "+dymerJwt);
		}
		
		String dymerExtraJwt = new String (Base64.getEncoder().encode((jwts[1]).getBytes()));
		
		
		Cookie cookie = new Cookie("DYM", dymerJwt);
		cookie.setMaxAge(CookieKeys.MAX_AGE);
		cookie.setPath("/");
		
		Cookie cookieExtra = new Cookie("DYM_EXTRA", dymerExtraJwt);
		cookieExtra.setMaxAge(CookieKeys.MAX_AGE);
		cookieExtra.setPath("/");

		CookieKeys.addCookie(PortalUtil.getHttpServletRequest(renderRequest), PortalUtil.getHttpServletResponse(renderResponse), cookie);
		CookieKeys.addCookie(PortalUtil.getHttpServletRequest(renderRequest), PortalUtil.getHttpServletResponse(renderResponse), cookieExtra);
	}
	
	protected static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
		if (_log.isDebugEnabled()) 
			_log.debug("castList method");
		
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c){
	    	r.add(clazz.cast(o));
	    }
	    return r;
	}
	
	public void deleteEntry(ActionRequest request, ActionResponse response) throws PortalException {
		long entryId = ParamUtil.getLong(request, "entryId");
		deleteEntryId(entryId);
	}
	
	public void deleteByAdminAllEntries(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long[] dymerEntryIds = ParamUtil.getLongValues(
				actionRequest, "deleteDymerEntryIds");
			
		for (long dymerEntryId : dymerEntryIds) {
			_log.info("dymerEntryId: "+dymerEntryId);
			deleteEntryId(dymerEntryId);
		}
	}
	
	private void deleteEntryId(long entryId) throws PortalException {
		try {
			DymerEntry dymerEntry = _dymerEntryLocalService.fetchDymerEntry(entryId);

			if (dymerEntry!=null) {
				
				_log.info("Deleting the following catalogue resource: "+dymerEntry.getTitle());
				_dymerEntryLocalService.deleteDymerEntry(dymerEntry);
			}
			_log.info("Deleted entryId: "+entryId +" catalogue resource.");

		}
		catch (Exception e) {
			_log.error("An error occurred while deleting entryId: "+entryId+", "+e.getMessage());
		}
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
			DymerPortlet.class);
	
	@Reference
	private DymerEntryLocalService _dymerEntryLocalService;

	@Reference
	private DymerLocalService _dymerLocalService;
	
}