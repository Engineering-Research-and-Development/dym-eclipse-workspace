package it.eng.rd.dymer.web.internal.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.portlet.constants.DymerPortletKeys;
import it.eng.rd.dymer.service.DymerEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {"javax.portlet.name=" + DymerPortletKeys.DYMER},
        service = AssetRendererFactory.class
        )
public class DymerEntryAssetRendererFactory extends BaseAssetRendererFactory<DymerEntry> {

    public DymerEntryAssetRendererFactory() {
        setClassName(CLASS_NAME);
        setLinkable(_LINKABLE);
        setPortletId(DymerPortletKeys.DYMER);
        setSearchable(true);
        setSelectable(true);

    }

    @Override
    public AssetRenderer<DymerEntry> getAssetRenderer(long classPK, int type)
            throws PortalException {

        DymerEntry entry = _dymerEntryLocalService.getDymerEntry(classPK);

        DymerEntryAssetRenderer dymerEntryAssetRenderer = new DymerEntryAssetRenderer(entry, _dymerEntryModelResourcePermission);

        dymerEntryAssetRenderer.setAssetRendererType(type);
        dymerEntryAssetRenderer.setServletContext(_servletContext);

        return dymerEntryAssetRenderer;
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

        DymerEntry entry = _dymerEntryLocalService.getDymerEntry(classPK);
        return true; //DymerEntryPermission.contains(permissionChecker, entry, actionId);
    }

    @Override
    public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse, long classTypeId) {

        PortletURL portletURL = null;

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

            portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(themeDisplay),
                    DymerPortletKeys.DYMER, PortletRequest.RENDER_PHASE);
            portletURL.setParameter("mvcRenderCommandName", "/dymer/edit_entry");
            portletURL.setParameter("showback", Boolean.FALSE.toString());
        } catch (PortalException e) {
        }

        return portletURL;
    }

    @Override
    public PortletURL getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) {

        LiferayPortletURL liferayPortletURL
        = liferayPortletResponse.createLiferayPortletURL(
                DymerPortletKeys.DYMER, PortletRequest.RENDER_PHASE);

        try {
            liferayPortletURL.setWindowState(windowState);
        } catch (WindowStateException wse) {

        }
        return liferayPortletURL;
    }

    @Override
    public boolean isLinkable() {
        return _LINKABLE;
    }

    @Override
    public String getIconCssClass() {
        return "pencil";
    }

    @Reference(target = "(osgi.web.symbolicname=it.eng.rd.dymer.portlet)",
            unbind = "-")
    public void setServletContext (ServletContext servletContext) {
        _servletContext = servletContext;
    }

    @Reference(unbind = "-")
    protected void setDymerEntryLocalService(DymerEntryLocalService dymerEntryLocalService) {
        _dymerEntryLocalService = dymerEntryLocalService;
    }


    private DymerEntryLocalService _dymerEntryLocalService;
    private ServletContext _servletContext;
    private static final boolean _LINKABLE = true;
    public static final String CLASS_NAME = DymerEntry.class.getName();
    public static final String TYPE = "entry";

    private ModelResourcePermission<DymerEntry>
    _dymerEntryModelResourcePermission;


}