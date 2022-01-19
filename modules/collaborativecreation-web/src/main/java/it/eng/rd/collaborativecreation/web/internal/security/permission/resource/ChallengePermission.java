package it.eng.rd.collaborativecreation.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.collaborativecreation.model.Challenge;


@Component(immediate = true)
public class ChallengePermission {
	public static boolean contains(
            PermissionChecker permissionChecker, Challenge challenge, String actionId) throws PortalException {
		
        return _challengeModelResourcePermission.contains(permissionChecker, challenge, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long challengeId, String actionId) throws PortalException {

        return _challengeModelResourcePermission.contains(permissionChecker, challengeId, actionId);
    }

    @Reference(
            target = "(model.class.name=it.eng.rd.collaborativecreation.model.Challenge)", 
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<Challenge> modelResourcePermission) {

        _challengeModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Challenge>_challengeModelResourcePermission;

}
