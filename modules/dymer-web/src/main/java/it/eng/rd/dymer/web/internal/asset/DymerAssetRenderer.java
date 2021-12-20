package it.eng.rd.dymer.web.internal.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.eng.rd.dymer.model.Dymer;
import it.eng.rd.dymer.portlet.constants.DymerPortletKeys;
import it.eng.rd.dymer.web.internal.security.permission.resource.DymerModelPermission;

public class DymerAssetRenderer extends BaseJSPAssetRenderer<Dymer> {
	public DymerAssetRenderer(Dymer dymer, ModelResourcePermission<Dymer> modelResourcePermission) {
        _dymer = dymer;
        _dymerModelResourcePermission = modelResourcePermission;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) 
	{
		
		_log.info("DymerAssetRenderer, hasEditPermission");
        try {
        	if(_log.isDebugEnabled()){
        		_log.debug("_dymer.getDymerId "+_dymer.getDymerId());
        		_log.debug("_dymer.getName "+_dymer.getName());
        	}
    		boolean permission = DymerModelPermission.contains(permissionChecker, _dymer, ActionKeys.UPDATE);
    		_log.info("permission "+permission);
    		return permission;
		} catch (PortalException e) {
			_log.error("Error in DymerAssetRenderer, hasEditPermission method: " + e.getMessage());
		}

		return false;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) 
	{
		_log.info("DymerAssetRenderer, hasViewPermission");
        try {
        	if(_log.isDebugEnabled()){
        		_log.debug("_dymer.getDymerId "+_dymer.getDymerId());
        		_log.debug("_dymer.getName "+_dymer.getName());
        	}
    		boolean permission = DymerModelPermission.contains(permissionChecker, _dymer, "VIEW");
    		_log.info("permission "+permission);
    		return permission;
		} catch (PortalException e) {
			_log.error("Error in DymerAssetRenderer, hasViewPermission method: " + e.getMessage());
		}

		return false;
	}
	
	@Override
	public Dymer getAssetObject() {
	  return _dymer;
	}

	@Override
	public long getGroupId() {
	  return _dymer.getGroupId();
	}

	@Override
	public long getUserId() {

	  return _dymer.getUserId();
	}

	@Override
	public String getUserName() {
	  return _dymer.getUserName();
	}

	@Override
	public String getUuid() {
	  return _dymer.getUuid();
	}

	@Override
	public String getClassName() {
	  return Dymer.class.getName();
	}

	@Override
	public long getClassPK() {
	  return _dymer.getDymerId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse 
	  portletResponse) {
	    return  _dymer.getName();
	}

	@Override
	public String getTitle(Locale locale) {
	  return _dymer.getName();
	}

	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse 
	  response, String template) throws Exception {
	    request.setAttribute("DYMER", _dymer);
	    request.setAttribute("HtmlUtil", HtmlUtil.getHtml());
	    request.setAttribute("StringUtil", new StringUtil());
	    return super.include(request, response, template);
	}
	
	@Override
	public String getJspPath(HttpServletRequest request, String template) {

	    if (template.equals(TEMPLATE_FULL_CONTENT)) {
	      request.setAttribute("dym_dymer", _dymer);

	      return "/asset/dymer/" + template + ".jsp";
	    } else {
	      return null;
	    }
	}
	
	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse) 
			throws Exception {
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			    getControlPanelPlid(liferayPortletRequest), DymerPortletKeys.DYMER,
			    PortletRequest.RENDER_PHASE);
		portletURL.setParameter("mvcPath", "/dymer/edit_dymer.jsp");
		portletURL.setParameter("dymerId", String.valueOf(_dymer.getDymerId()));
		portletURL.setParameter("showback", Boolean.FALSE.toString());

		return portletURL;
	}
	
	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
	  LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
	    try {
	      long plid = PortalUtil.getPlidFromPortletId(_dymer.getGroupId(),
	          DymerPortletKeys.DYMER);

	      PortletURL portletURL;
	      if (plid == LayoutConstants.DEFAULT_PLID) {
	        portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
	            DymerPortletKeys.DYMER, PortletRequest.RENDER_PHASE);
	      } else {
	        portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
	            DymerPortletKeys.DYMER, plid, PortletRequest.RENDER_PHASE);
	      }

	      portletURL.setParameter("mvcPath", "/dymer/view.jsp");
	      portletURL.setParameter("dymerId", String.valueOf(_dymer.getDymerId()));

	      String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

	      portletURL.setParameter("redirect", currentUrl);

	      return portletURL.toString();

	    } catch (PortalException e) {

	        logger.log(Level.SEVERE, e.getMessage());

	    } catch (SystemException e) {

	        logger.log(Level.SEVERE, e.getMessage());

	    }

	    return noSuchEntryRedirect;
	}
	
	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, 
	WindowState windowState) throws Exception {

	    return super.getURLView(liferayPortletResponse, windowState);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
			DymerAssetRenderer.class);
	private Dymer _dymer;
	private final ModelResourcePermission<Dymer> _dymerModelResourcePermission;   
	private Logger logger = Logger.getLogger(this.getClass().getName());
}

