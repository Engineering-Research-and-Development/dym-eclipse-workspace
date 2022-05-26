package it.eng.rd.idp.registration.portlet.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

//import com.liferay.portal.kernel.util.GetterUtil;
//import com.liferay.util.portlet.PortletProps;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Meta;
import it.eng.rd.idp.registration.portlet.configuration.IdpRegistrationConfiguration;
import it.eng.rd.idp.registration.constants.IdpRegistrationPortletKeys;

/**
 * @author ENGRD
 */
@Component(
	configurationPid = "it.eng.rd.idp.registration.portlet.configuration.IdpRegistrationConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
	property = "javax.portlet.name=" + IdpRegistrationPortletKeys.IDPREGISTRATION,
	service = ConfigurationAction.class
)
public class IdpRegistrationConfigurationAction
	extends DefaultConfigurationAction {

	@Override
	public void include(
			PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

//		_log.info("IdpRegistrationPortlet configuration include");

		httpServletRequest.setAttribute(
				IdpRegistrationConfiguration.class.getName(),
				_idpRegistrationConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String idmUrl = ParamUtil.getString(actionRequest, "idmUrl");
		String idmEmailAdmin = ParamUtil.getString(actionRequest, "idmEmailAdmin");
		String idmEmailAdminNotification = ParamUtil.getString(actionRequest, "idmEmailAdminNotification");
		
		String idmPasswordAdmin = ParamUtil.getString(actionRequest, "idmPasswordAdmin");
		String idmEnable = ParamUtil.getString(actionRequest, "idmEnable");
		
		String mailSubject = ParamUtil.getString(actionRequest, "mailSubject");
		String from = ParamUtil.getString(actionRequest, "from");
		String projectName = ParamUtil.getString(actionRequest, "projectName");
		String logoLiferayPortalUrl = ParamUtil.getString(actionRequest, "logoLiferayPortalUrl");
		String liferayPortalName = ParamUtil.getString(actionRequest, "liferayPortalName");
		String liferayPortalUrl = ParamUtil.getString(actionRequest, "liferayPortalUrl");
		String organizationTypelist = ParamUtil.getString(actionRequest, "organizationTypelist");
		String termsOfUseUrl = ParamUtil.getString(actionRequest, "termsOfUseUrl");
		String copyrightCompany = ParamUtil.getString(actionRequest, "copyrightCompany");
		String copyrightCompanyUrl = ParamUtil.getString(actionRequest, "copyrightCompanyUrl");
		
		setPreference(actionRequest, "idmUrl", idmUrl);
		setPreference(actionRequest, "idmEmailAdmin", idmEmailAdmin);
		setPreference(actionRequest, "idmEmailAdminNotification", idmEmailAdminNotification);
		setPreference(actionRequest, "idmPasswordAdmin", idmPasswordAdmin);
		setPreference(actionRequest, "idmEnable", idmEnable);
		
		setPreference(actionRequest, "mailSubject", mailSubject);
		setPreference(actionRequest, "from", from);
		setPreference(actionRequest, "projectName", projectName);
		setPreference(actionRequest, "logoLiferayPortalUrl", logoLiferayPortalUrl);
		setPreference(actionRequest, "liferayPortalName", liferayPortalName);
		setPreference(actionRequest, "liferayPortalUrl", liferayPortalUrl);
		setPreference(actionRequest, "organizationTypelist", organizationTypelist);
		setPreference(actionRequest, "termsOfUseUrl", termsOfUseUrl);
		setPreference(actionRequest, "copyrightCompany", copyrightCompany);
		setPreference(actionRequest, "copyrightCompanyUrl", copyrightCompanyUrl);
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_idpRegistrationConfiguration = ConfigurableUtil.createConfigurable(
				IdpRegistrationConfiguration.class, properties);
	}

	private static final Log _log = LogFactoryUtil.getLog(
			IdpRegistrationConfiguration.class);

	private volatile IdpRegistrationConfiguration _idpRegistrationConfiguration;

}