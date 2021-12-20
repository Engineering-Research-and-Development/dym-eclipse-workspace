package it.eng.rd.dymer.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.dymer.model.DymerEntry;

@Component(immediate = true)
public class DymerEntryPermission {
	public static boolean contains(
            PermissionChecker permissionChecker, DymerEntry entry, String actionId) throws PortalException {
		
        return _dymerEntryModelResourcePermission.contains(permissionChecker, entry, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long entryId, String actionId) throws PortalException {

        return _dymerEntryModelResourcePermission.contains(permissionChecker, entryId, actionId);
    }

    @Reference(
            target = "(model.class.name=it.eng.rd.dymer.model.DymerEntry)", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<DymerEntry> modelResourcePermission) {

        _dymerEntryModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<DymerEntry>_dymerEntryModelResourcePermission;

}
