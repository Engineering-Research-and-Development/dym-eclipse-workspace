package it.eng.rd.collaborativecreation.web.internal.asset;

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

import it.eng.rd.collaborativecreation.model.Challenge;
import it.eng.rd.collaborativecreation.model.Cocreation;
import it.eng.rd.collaborativecreation.portlet.constants.CollaborativecreationPortletKeys;
import it.eng.rd.collaborativecreation.web.internal.security.permission.resource.ChallengePermission;
import it.eng.rd.collaborativecreation.web.internal.security.permission.resource.CocreationPermission;

public class CocreationAssetRenderer extends BaseJSPAssetRenderer<Cocreation> {
	public CocreationAssetRenderer(Cocreation cocreation, ModelResourcePermission<Cocreation> modelResourcePermission) {
        _cocreation = cocreation;
        _cocreationModelResourcePermission = modelResourcePermission;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) 
	{
		
		_log.info("CocreationAssetRenderer, hasEditPermission");
        try {
        	if(_log.isDebugEnabled()){
        		_log.debug("_cocreation.getChallengeId "+_cocreation.getCocreationId());
        		_log.debug("_cocreation.getTitle "+_cocreation.getTitle());
        		_log.debug("_cocreation.getDescription "+_cocreation.getDescription());
        	}
    		boolean permission = CocreationPermission.contains(permissionChecker, _cocreation, ActionKeys.UPDATE);
    		_log.info("permission "+permission);
    		return permission;
		} catch (PortalException e) {
			_log.error("Error in CocreationAssetRenderer, hasEditPermission method: " + e.getMessage());
		}

		return false;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) 
	{
		_log.info("CocreationAssetRenderer, hasViewPermission");
        try {
        	if(_log.isDebugEnabled()){
        		_log.debug("_cocreation.getCocreationId "+_cocreation.getCocreationId());
        		_log.debug("_cocreation.getTitle "+_cocreation.getTitle());
        		_log.debug("_cocreation.getDescription "+_cocreation.getDescription());
        	}
    		boolean permission = CocreationPermission.contains(permissionChecker, _cocreation, "VIEW");
    		_log.info("permission "+permission);
    		return permission;
		} catch (PortalException e) {
			_log.error("Error in CocreationAssetRenderer, hasViewPermission method: " + e.getMessage());
		}

		return false;
	}
	
	@Override
	public Cocreation getAssetObject() {
	  return _cocreation;
	}

	@Override
	public long getGroupId() {
	  return _cocreation.getGroupId();
	}

	@Override
	public long getUserId() {

	  return _cocreation.getUserId();
	}

	@Override
	public String getUserName() {
	  return _cocreation.getUserName();
	}

	@Override
	public String getUuid() {
	  return _cocreation.getUuid();
	}

	@Override
	public String getClassName() {
	  return Challenge.class.getName();
	}

	@Override
	public long getClassPK() {
	  return _cocreation.getChallengeId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse 
	  portletResponse) {
	    return  _cocreation.getDescription();
	}

	@Override
	public String getTitle(Locale locale) {
	  return _cocreation.getTitle();
	}

	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse 
	  response, String template) throws Exception {
	    request.setAttribute("COCREATION", _cocreation);
	    request.setAttribute("HtmlUtil", HtmlUtil.getHtml());
	    request.setAttribute("StringUtil", new StringUtil());
	    return super.include(request, response, template);
	}
	
	@Override
	public String getJspPath(HttpServletRequest request, String template) {

	    if (template.equals(TEMPLATE_FULL_CONTENT)) {
	      request.setAttribute("collaborativecreation_cocreation", _cocreation);

	      return "/asset/cocreation/" + template + ".jsp";
	    } else {
	      return null;
	    }
	}
	
	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse) 
			throws Exception {
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			    getControlPanelPlid(liferayPortletRequest), CollaborativecreationPortletKeys.COLLABORATIVECREATION,
			    PortletRequest.RENDER_PHASE);
		portletURL.setParameter("mvcPath", "/cocreationDetails.jsp");
		portletURL.setParameter("cocreationId", String.valueOf(_cocreation.getCocreationId()));
		portletURL.setParameter("showback", Boolean.FALSE.toString());

		return portletURL;
	}
	
	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
	  LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
	    try {
	      long plid = PortalUtil.getPlidFromPortletId(_cocreation.getGroupId(),
	    		  CollaborativecreationPortletKeys.COLLABORATIVECREATION);

	      PortletURL portletURL;
	      if (plid == LayoutConstants.DEFAULT_PLID) {
	        portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
	        		CollaborativecreationPortletKeys.COLLABORATIVECREATION, PortletRequest.RENDER_PHASE);
	      } else {
	        portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
	        		CollaborativecreationPortletKeys.COLLABORATIVECREATION, plid, PortletRequest.RENDER_PHASE);
	      }

	      portletURL.setParameter("mvcPath", "/ongoing-cocreations.jsp");
	      portletURL.setParameter("cocreationId", String.valueOf(_cocreation.getCocreationId()));

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
			CocreationAssetRenderer.class);
	private Cocreation _cocreation;
	private final ModelResourcePermission<Cocreation> _cocreationModelResourcePermission;   
	private Logger logger = Logger.getLogger(this.getClass().getName());
}

