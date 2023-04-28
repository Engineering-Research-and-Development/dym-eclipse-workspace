package it.eng.rd.idp.registration.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;
import it.eng.rd.idp.registration.constants.IdpRegistrationPortletKeys;

/**
 * @author ENGRD
 */
@Meta.OCD(
	id = "it.eng.rd.idp.registration.portlet.configuration.IdpRegistrationConfiguration"
)
public interface IdpRegistrationConfiguration {
	
	@Meta.AD(deflt = "", required = false)
	public String idmUrl();
	
	@Meta.AD(deflt = IdpRegistrationPortletKeys.IDM_ADMIN_DEFAULT, required = false)
	public String idmEmailAdmin();
	
	@Meta.AD(deflt = IdpRegistrationPortletKeys.IDM_ADMIN_DEFAULT, required = false)
	public String idmEmailAdminNotification();
	
	@Meta.AD(deflt = "", required = false)
	public String idmPasswordAdmin();
	
	@Meta.AD(required = false)
	public String idmEnable();
	
	@Meta.AD(required = false)
	public String idmActive();
	
	@Meta.AD(deflt = "", required = false)
	public String projectName();
	
	@Meta.AD(deflt = "", required = false)
	public String logoLiferayPortalUrl();
	
	@Meta.AD(deflt = "", required = false)
	public String liferayPortalName();
	
	@Meta.AD(deflt = "", required = false)
	public String liferayPortalUrl();
	
	@Meta.AD(deflt = "", required = false)
	public String mailSubject();

	@Meta.AD(deflt = IdpRegistrationPortletKeys.FROM_DEFAULT, required = false)
	public String from();
	
	@Meta.AD(deflt = "", required = false)
	public String termsOfUseUrl();
		
	@Meta.AD(deflt = IdpRegistrationPortletKeys.DEFAULT_ORGANIZATIONS, required = false)
	public String organizationTypelist();
	
	@Meta.AD(deflt = IdpRegistrationPortletKeys.COPYRIGHT_COMPANY_DEFAULT, required = false)
	public String copyrightCompany();
	
	@Meta.AD(deflt = IdpRegistrationPortletKeys.COPYRIGHT_COMPANY_URL_DEFAULT, required = false)
	public String copyrightCompanyUrl();
	
	@Meta.AD(deflt = "", required = false)
	public String name();
	
	@Meta.AD(deflt = "", required = false)
	public String surname();
	
	@Meta.AD(deflt = "", required = false)
	public String website();
	
	@Meta.AD(deflt = "", required = false)
	public String templateID();
	
}