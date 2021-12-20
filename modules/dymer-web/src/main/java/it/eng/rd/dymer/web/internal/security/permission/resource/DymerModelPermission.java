package it.eng.rd.dymer.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.dymer.model.Dymer;

@Component(immediate = true)
public class DymerModelPermission {
	public static boolean contains(
            PermissionChecker permissionChecker, Dymer dymer, String actionId) throws PortalException {

        return _dymerModelResourcePermission.contains(permissionChecker, dymer, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long dymerId, String actionId) throws PortalException {

        return _dymerModelResourcePermission.contains(permissionChecker, dymerId, actionId);
    }

    @Reference(
            target = "(model.class.name=it.eng.rd.dymer.model.Dymer)", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<Dymer> modelResourcePermission) {

        _dymerModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Dymer>_dymerModelResourcePermission;
}
