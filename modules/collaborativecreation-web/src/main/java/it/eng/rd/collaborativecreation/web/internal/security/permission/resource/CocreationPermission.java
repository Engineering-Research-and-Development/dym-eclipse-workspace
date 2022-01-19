package it.eng.rd.collaborativecreation.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.collaborativecreation.model.Cocreation;

@Component(immediate = true)
public class CocreationPermission {
	public static boolean contains(
            PermissionChecker permissionChecker, Cocreation cocreation, String actionId) throws PortalException {

        return _cocreationModelResourcePermission.contains(permissionChecker, cocreation, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long cocreationId, String actionId) throws PortalException {

        return _cocreationModelResourcePermission.contains(permissionChecker, cocreationId, actionId);
    }

    @Reference(
            target = "(model.class.name=it.eng.rd.collaborativecreation.model.Cocreation)", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<Cocreation> modelResourcePermission) {

        _cocreationModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Cocreation>_cocreationModelResourcePermission;
}
