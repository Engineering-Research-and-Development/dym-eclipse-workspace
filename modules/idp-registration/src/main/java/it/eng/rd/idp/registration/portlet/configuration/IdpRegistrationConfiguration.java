package it.eng.rd.idp.registration.portlet.configuration;

import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Liferay
 */
@Meta.OCD(
	id = "it.eng.rd.idp.registration.portlet.configuration.IdpRegistrationConfiguration"
)
public interface IdpRegistrationConfiguration {

	@Meta.AD(required = false)
	public String idmUrl();
	
	@Meta.AD(required = false)
	public String idmEmailAdmin();
	
	@Meta.AD(required = false)
	public String idmEmailAdminNotification();
	
	@Meta.AD(required = false)
	public String idmPasswordAdmin();
	
	@Meta.AD(required = false)
	public String idmEnable();
	
	@Meta.AD(required = false)
	public String projectName();
	
	@Meta.AD(required = false)
	public String logoLiferayPortalUrl();
	
	@Meta.AD(required = false)
	public String liferayPortalName();
	
	@Meta.AD(required = false)
	public String liferayPortalUrl();
	
	@Meta.AD(required = false)
	public String mailSubject();
	
	@Meta.AD(required = false)
	public String from();
	
	@Meta.AD(required = false)
	public String termsOfUseUrl();
	
	@Meta.AD(required = false)
	public String organizationTypelist();
	
	@Meta.AD(required = false)
	public String copyrightCompany();
	
	@Meta.AD(required = false)
	public String copyrightCompanyUrl();
	
}