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
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.portlet.constants.DymerPortletKeys;
import it.eng.rd.dymer.web.internal.security.permission.resource.DymerEntryPermission;

public class DymerEntryAssetRenderer extends BaseJSPAssetRenderer<DymerEntry> {

    public DymerEntryAssetRenderer(DymerEntry entry, ModelResourcePermission<DymerEntry> modelResourcePermission) {

        _entry = entry;
        _dymerEntryModelResourcePermission = modelResourcePermission;
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker) 
    {
    	_log.info("DymerEntryAssetRenderer, hasViewPermission");
        try {
        	if(_log.isDebugEnabled()){
        		_log.debug("_entry.getEntryId "+_entry.getEntryId());
        		_log.debug("_entry.getDymerId "+_entry.getDymerId());
        		_log.debug("_entry.getTitle "+_entry.getTitle());
        		_log.debug("_entry.getIndex "+_entry.getIndex());
        	}
			
    		boolean permission = DymerEntryPermission.contains(permissionChecker, _entry, "VIEW");
    		_log.info("permission "+permission);
    		return permission;
		} catch (PortalException e) {
			_log.error("Error in DymerEntryAssetRenderer, hasViewPermission method: " + e.getMessage());
		}

        return false;
    }

    @Override
    public DymerEntry getAssetObject() {
        return _entry;
    }

    @Override
    public long getGroupId() {
        return _entry.getGroupId();
    }

    @Override
    public long getUserId() {

        return _entry.getUserId();
    }

    @Override
    public String getUserName() {
        return _entry.getUserName();
    }

    @Override
    public String getUuid() {
        return _entry.getUuid();
    }

    @Override
    public String getClassName() {
        return DymerEntry.class.getName();
    }

    @Override
    public long getClassPK() {
        return _entry.getEntryId();
    }

    @Override
    public String getSummary(PortletRequest portletRequest, 
            PortletResponse portletResponse) {
        return _entry.getExtContent();
    }

    @Override
    public String getTitle(Locale locale) {
        return _entry.getTitle();
    }

    @Override
    public boolean include(HttpServletRequest request, 
            HttpServletResponse response, String template) throws Exception {
        request.setAttribute("ENTRY", _entry);
        request.setAttribute("HtmlUtil", HtmlUtil.getHtml());
        request.setAttribute("StringUtil", new StringUtil());
        return super.include(request, response, template);
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {

        if (template.equals(TEMPLATE_FULL_CONTENT)) {
            request.setAttribute("dym_entry", _entry);

            return "/asset/entry/" + template + ".jsp";
        } else {
            return null;
        }
    }

    @Override
    public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse) throws Exception {
        PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
                getControlPanelPlid(liferayPortletRequest), DymerPortletKeys.DYMER,
                PortletRequest.RENDER_PHASE);
        portletURL.setParameter("mvcPath", "/dymer/edit_entry.jsp");
        portletURL.setParameter("entryId", String.valueOf(_entry.getEntryId()));
        portletURL.setParameter("showback", Boolean.FALSE.toString());

        return portletURL;
    }

    @Override
    public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) 
                    throws Exception {
 
        try {
            long plid = PortalUtil.getPlidFromPortletId(_entry.getGroupId(),
                    DymerPortletKeys.DYMER);

            PortletURL portletURL;
            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
                        DymerPortletKeys.DYMER, PortletRequest.RENDER_PHASE);
            } else {
                portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
                        DymerPortletKeys.DYMER, plid, PortletRequest.RENDER_PHASE);
            }

            portletURL.setParameter("mvcPath", "/dymer/view_entry.jsp");
            portletURL.setParameter("entryId", String.valueOf(_entry.getEntryId()));

            String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

            portletURL.setParameter("redirect", currentUrl);

            return portletURL.toString();

        } catch (PortalException e) {
        	_log.error("getURLViewInContext " + e.getMessage());
        } catch (SystemException e) {
        	_log.error("getURLViewInContext " + e.getMessage());
        }

        return noSuchEntryRedirect;
    }

    @Override
    public String getURLView(LiferayPortletResponse liferayPortletResponse, 
            WindowState windowState) throws Exception {
    	
    	return super.getURLView(liferayPortletResponse, windowState);
    }

    @Override
    public boolean isPrintable() {
        return true;
    }
    
    private static final Log _log = LogFactoryUtil.getLog(
    		DymerEntryAssetRenderer.class);
    private final ModelResourcePermission<DymerEntry> _dymerEntryModelResourcePermission;
    private DymerEntry _entry;
}