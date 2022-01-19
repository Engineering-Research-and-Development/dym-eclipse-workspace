package it.eng.rd.collaborativecreation.web.internal.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;

import it.eng.rd.collaborativecreation.model.Challenge;
import it.eng.rd.collaborativecreation.model.Cocreation;
import it.eng.rd.collaborativecreation.portlet.constants.CollaborativecreationPortletKeys;
import it.eng.rd.collaborativecreation.service.ChallengeLocalService;
import it.eng.rd.collaborativecreation.service.CocreationLocalService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, 
	property = {"javax.portlet.name=" + CollaborativecreationPortletKeys.COLLABORATIVECREATION}, 
	service = AssetRendererFactory.class
)
public class CocreationAssetRendererFactory extends 
	BaseAssetRendererFactory<Cocreation> {
	
	public CocreationAssetRendererFactory() {
	  setClassName(CLASS_NAME);
	  setLinkable(_LINKABLE);
	  setPortletId(CollaborativecreationPortletKeys.COLLABORATIVECREATION); 
	  setSearchable(true);
	  setSelectable(true); 
	}         
	
	// Add the other methods here
	@Override
	public AssetRenderer<Cocreation> getAssetRenderer(long classPK, int type) 
	throws PortalException {

      Cocreation cocreation = _cocreationLocalService.getCocreation(classPK);

	  CocreationAssetRenderer cocreationAssetRenderer = 
	  new CocreationAssetRenderer(cocreation, _cocreationModelResourcePermission);

	  cocreationAssetRenderer.setAssetRendererType(type);
	  cocreationAssetRenderer.setServletContext(_servletContext);

	  return cocreationAssetRenderer;
	}
	
	@Override
	public String getClassName() {
	    return CLASS_NAME;
	}

	@Override
	public String getType() {
	    return TYPE;
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, 
	long classPK, String actionId) throws Exception {

	  Cocreation cocreation = _cocreationLocalService.getCocreation(classPK);
	  long groupId = cocreation.getGroupId();
	  return true;
	}
	
	@Override
	public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest,
	  LiferayPortletResponse liferayPortletResponse, long classTypeId) {
	    PortletURL portletURL = null;

	    try {
	      ThemeDisplay themeDisplay = (ThemeDisplay) 
	      liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

	      portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(themeDisplay),
	          CollaborativecreationPortletKeys.COLLABORATIVECREATION, PortletRequest.RENDER_PHASE);
	      portletURL.setParameter("mvcPath", "/cocreationDetails.jsp");
	      portletURL.setParameter("showback", Boolean.FALSE.toString());

	      } catch (PortalException e) {

	            logger.log(Level.SEVERE, e.getMessage()); 

	      }

	    return portletURL;
	}

	@Override
	public boolean isLinkable() {
	    return _LINKABLE;
	}

	@Override
	public String getIconCssClass() {
	  return "bookmarks";
	}

	@Reference(target = "(osgi.web.symbolicname=it.eng.rd.collaborativecreation.portlet)",
	    unbind = "-")
	public void setServletContext(ServletContext servletContext) {
	    _servletContext = servletContext;
	}

	@Reference(unbind = "-")
	protected void setCocreationLocalService(CocreationLocalService cocreationLocalService) {
	    _cocreationLocalService = cocreationLocalService; 
	}
	
	private ServletContext _servletContext;
	private CocreationLocalService _cocreationLocalService;
	private static final boolean _LINKABLE = true;
	public static final String CLASS_NAME = Challenge.class.getName();
	public static final String TYPE = "challenge";
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private ModelResourcePermission<Cocreation> _cocreationModelResourcePermission;
}