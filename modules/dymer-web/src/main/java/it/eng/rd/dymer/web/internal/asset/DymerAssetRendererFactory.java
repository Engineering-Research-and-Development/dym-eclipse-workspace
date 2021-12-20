package it.eng.rd.dymer.web.internal.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import it.eng.rd.dymer.model.Dymer;
import it.eng.rd.dymer.portlet.constants.DymerPortletKeys;
import it.eng.rd.dymer.service.DymerLocalService;
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
	property = {"javax.portlet.name=" + DymerPortletKeys.DYMER}, 
	service = AssetRendererFactory.class
)
public class DymerAssetRendererFactory extends 
	BaseAssetRendererFactory<Dymer> {
	
	public DymerAssetRendererFactory() {
	  setClassName(CLASS_NAME);
	  setLinkable(_LINKABLE);
	  setPortletId(DymerPortletKeys.DYMER); 
	  setSearchable(true);
	  setSelectable(true); 
	}         
	
	// Add the other methods here
	@Override
	public AssetRenderer<Dymer> getAssetRenderer(long classPK, int type) 
	throws PortalException {

	  Dymer dymer = _dymerLocalService.getDymer(classPK);

	  DymerAssetRenderer dymerAssetRenderer = 
	  new DymerAssetRenderer(dymer, _dymerModelResourcePermission);

	  dymerAssetRenderer.setAssetRendererType(type);
	  dymerAssetRenderer.setServletContext(_servletContext);

	  return dymerAssetRenderer;
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

	  Dymer dymer = _dymerLocalService.getDymer(classPK);
	  long groupId = dymer.getGroupId();
	  return true; //DymerPermission.contains(permissionChecker, groupId, actionId);
	}
	
	@Override
	public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest,
	  LiferayPortletResponse liferayPortletResponse, long classTypeId) {
	    PortletURL portletURL = null;

	    try {
	      ThemeDisplay themeDisplay = (ThemeDisplay) 
	      liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

	      portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(themeDisplay),
	          DymerPortletKeys.DYMER, PortletRequest.RENDER_PHASE);
	      portletURL.setParameter("mvcPath", "/dymer/edit_dymer.jsp");
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

	@Reference(target = "(osgi.web.symbolicname=it.eng.rd.dymer.portlet)",
	    unbind = "-")
	public void setServletContext(ServletContext servletContext) {
	    _servletContext = servletContext;
	}

	@Reference(unbind = "-")
	protected void setDymerLocalService(DymerLocalService dymerLocalService) {
	    _dymerLocalService = dymerLocalService; 
	}
	
	private ServletContext _servletContext;
	private DymerLocalService _dymerLocalService;
	private static final boolean _LINKABLE = true;
	public static final String CLASS_NAME = Dymer.class.getName();
	public static final String TYPE = "dymer";
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private ModelResourcePermission<Dymer> _dymerModelResourcePermission;
}