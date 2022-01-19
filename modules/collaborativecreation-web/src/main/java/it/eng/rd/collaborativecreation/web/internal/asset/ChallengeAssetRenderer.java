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
import it.eng.rd.collaborativecreation.portlet.constants.CollaborativecreationPortletKeys;
import it.eng.rd.collaborativecreation.web.internal.security.permission.resource.ChallengePermission;

public class ChallengeAssetRenderer extends BaseJSPAssetRenderer<Challenge> {
	public ChallengeAssetRenderer(Challenge challenge, ModelResourcePermission<Challenge> modelResourcePermission) {
        _challenge = challenge;
        _challengeModelResourcePermission = modelResourcePermission;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) 
	{
		
		_log.info("ChallengeAssetRenderer, hasEditPermission");
        try {
        	if(_log.isDebugEnabled()){
        		_log.debug("_challenge.getChallengeId "+_challenge.getChallengeId());
        		_log.debug("_challenge.getTitle "+_challenge.getTitle());
        		_log.debug("_challenge.getDescription "+_challenge.getDescription());
        	}
    		boolean permission = ChallengePermission.contains(permissionChecker, _challenge, ActionKeys.UPDATE);
    		_log.info("permission "+permission);
    		return permission;
		} catch (PortalException e) {
			_log.error("Error in ChallengeAssetRenderer, hasEditPermission method: " + e.getMessage());
		}

		return false;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) 
	{
		_log.info("ChallengeAssetRenderer, hasViewPermission");
        try {
        	if(_log.isDebugEnabled()){
        		_log.debug("_challenge.getChallengeId "+_challenge.getChallengeId());
        		_log.debug("_challenge.getTitle "+_challenge.getTitle());
        		_log.debug("_challenge.getDescription "+_challenge.getDescription());
        	}
    		boolean permission = ChallengePermission.contains(permissionChecker, _challenge, "VIEW");
    		_log.info("permission "+permission);
    		return permission;
		} catch (PortalException e) {
			_log.error("Error in ChallengeAssetRenderer, hasViewPermission method: " + e.getMessage());
		}

		return false;
	}
	
	@Override
	public Challenge getAssetObject() {
	  return _challenge;
	}

	@Override
	public long getGroupId() {
	  return _challenge.getGroupId();
	}

	@Override
	public long getUserId() {

	  return _challenge.getUserId();
	}

	@Override
	public String getUserName() {
	  return _challenge.getUserName();
	}

	@Override
	public String getUuid() {
	  return _challenge.getUuid();
	}

	@Override
	public String getClassName() {
	  return Challenge.class.getName();
	}

	@Override
	public long getClassPK() {
	  return _challenge.getChallengeId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse 
	  portletResponse) {
	    return  _challenge.getDescription();
	}

	@Override
	public String getTitle(Locale locale) {
	  return _challenge.getTitle();
	}

	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse 
	  response, String template) throws Exception {
	    request.setAttribute("CHALLENGE", _challenge);
	    request.setAttribute("HtmlUtil", HtmlUtil.getHtml());
	    request.setAttribute("StringUtil", new StringUtil());
	    return super.include(request, response, template);
	}
	
	@Override
	public String getJspPath(HttpServletRequest request, String template) {

	    if (template.equals(TEMPLATE_FULL_CONTENT)) {
	      request.setAttribute("collaborativecreation_challenge", _challenge);

	      return "/asset/challenge/" + template + ".jsp";
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
		portletURL.setParameter("mvcPath", "/challengeDetails.jsp");
		portletURL.setParameter("challengeId", String.valueOf(_challenge.getChallengeId()));
		portletURL.setParameter("showback", Boolean.FALSE.toString());

		return portletURL;
	}
	
	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
	  LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
	    try {
	      long plid = PortalUtil.getPlidFromPortletId(_challenge.getGroupId(),
	    		  CollaborativecreationPortletKeys.COLLABORATIVECREATION);

	      PortletURL portletURL;
	      if (plid == LayoutConstants.DEFAULT_PLID) {
	        portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
	        		CollaborativecreationPortletKeys.COLLABORATIVECREATION, PortletRequest.RENDER_PHASE);
	      } else {
	        portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
	        		CollaborativecreationPortletKeys.COLLABORATIVECREATION, plid, PortletRequest.RENDER_PHASE);
	      }

	      portletURL.setParameter("mvcPath", "/challenges.jsp");
	      portletURL.setParameter("challengeId", String.valueOf(_challenge.getChallengeId()));

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
			ChallengeAssetRenderer.class);
	private Challenge _challenge;
	private final ModelResourcePermission<Challenge> _challengeModelResourcePermission;   
	private Logger logger = Logger.getLogger(this.getClass().getName());
}

