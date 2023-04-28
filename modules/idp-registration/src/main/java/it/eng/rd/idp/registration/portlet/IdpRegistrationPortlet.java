package it.eng.rd.idp.registration.portlet;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.DefaultScreenNameValidator;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.eng.rd.idp.registration.constants.IdpRegistrationPortletKeys;
import it.eng.rd.idp.registration.exception.AddIdmUserException;
import it.eng.rd.idp.registration.exception.IdmException;
import it.eng.rd.idp.registration.mailer.Mailer;
import it.eng.rd.idp.registration.model.RegistrationInfo;
import it.eng.rd.idp.registration.portlet.configuration.IdpRegistrationConfiguration;

/**
 * @author ENGRD
 */
@Component(configurationPid = "it.eng.rd.idp.registration.portlet.configuration.IdpRegistrationConfiguration",
		immediate = true, property = {
		"com.liferay.portlet.display-category=category.signup", 
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=IdpRegistration", 
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + IdpRegistrationPortletKeys.IDPREGISTRATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class IdpRegistrationPortlet extends MVCPortlet {

	public static final String POSTFIX = "postfix";
	private String _specialChars;

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		renderRequest.setAttribute(
				IdpRegistrationConfiguration.class.getName(),
				_idpRegistrationConfiguration);
		
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		if (_log.isDebugEnabled()) {
			_log.info("render method");
		}
		
		renderRequest.setAttribute(IdpRegistrationConfiguration.class.getName(), _idpRegistrationConfiguration);
		super.render(renderRequest, renderResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_idpRegistrationConfiguration = ConfigurableUtil.createConfigurable(IdpRegistrationConfiguration.class,
				properties);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			CaptchaUtil.serveImage(resourceRequest, resourceResponse);
		} catch (Exception exception) {
			_log.error(exception.getMessage(), exception);
		}
	}

	public void processAction(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		String cmd = ParamUtil.getString(request, Constants.CMD);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Locale locale = themeDisplay.getLocale();
		
		long companyId = themeDisplay.getCompanyId();
		
		ResourceBundle resourceBundle = getResourceBundle(themeDisplay.getLocale());
		
		PortletPreferences portletPreferences = request.getPreferences();
		
		String	idmActive = StringUtil.trim(portletPreferences.getValue("idmActive", _idpRegistrationConfiguration.idmActive()));
		RegistrationInfo ri = setRegistrationInfo(request, response);
		String organizationTypelist = StringUtil.trim(portletPreferences.getValue("organizationTypelist", _idpRegistrationConfiguration.organizationTypelist()));
		
		if (_log.isDebugEnabled()) {
			_log.debug("processAction cmd: "+cmd);
			_log.debug("idmActive: "+idmActive);
		}
		
		if (cmd.equalsIgnoreCase(Constants.ADD)){
			if (idmActive.equalsIgnoreCase("on")) {
				addUserByIdM(request, response, false, locale, resourceBundle, portletPreferences, ri, companyId,	organizationTypelist);
			} else {
				addUserByLiferay(request, response, true, locale, resourceBundle, portletPreferences, ri, companyId, organizationTypelist);
			}
		}
	}
	
	private void addUserByLiferay(ActionRequest request, ActionResponse response,
			boolean liferayEnabled,
			Locale locale,
			ResourceBundle resourceBundle,
			PortletPreferences portletPreferences,
			RegistrationInfo ri, 
			long companyId,
			String organizationTypelist) {
		
		if (_log.isDebugEnabled())
			_log.debug("addUserByLiferay method");

		request.setAttribute("registrationInfo", ri);
		
		try {
			
			CaptchaUtil.check(request);
			validate(ri, organizationTypelist, companyId);
			try {
				
				long creatorUserId = 0;
				boolean autoPassword = false;
				boolean autoScreenName = false;
				String middleName = StringPool.BLANK;
				long prefixId = 0;
				long suffixId = 0;
				boolean male = true;
				int birthdayMonth = Calendar.JANUARY;
				int birthdayDay = 1;
				int birthdayYear = 1970;
				String jobTitle = StringPool.BLANK;
				long[] groupIds = null;
				long[] organizationIds = null;
				long[] roleIds = null;
				long[] userGroupIds = null;
				boolean sendEmail = false;

				ServiceContext serviceContext = new ServiceContext();
				
				User user = UserLocalServiceUtil.addUser(
					creatorUserId, companyId, autoPassword, ri.getPassword1(), ri.getPassword2(),
					autoScreenName, ri.getUsername(), ri.getEmail(), locale, ri.getName(),
					middleName, ri.getSurname(), prefixId, suffixId, male, birthdayMonth,
					birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
					roleIds, userGroupIds, sendEmail, serviceContext);
				
				sendNotification(ri, portletPreferences, companyId, true);
				
			}catch (Exception e) {
				_log.error("no user add "+e.getMessage());
			}
			
			response.setRenderParameter("mvcPath", IdpRegistrationPortletKeys.PAGE_RESULT);
			request.setAttribute("success", true);
			String msg = LanguageUtil.format(resourceBundle, "sign-up-completed", false);
			request.setAttribute("message", msg);

		} catch (Exception e1) {
			SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			request.setAttribute("error", true);
			
			if (e1 instanceof CaptchaException) {
				_log.error("CAPTCHA verification failed... "+e1.getMessage());
				String msg = LanguageUtil.format(resourceBundle, "idp-captcha-verification-failed", false);
				request.setAttribute("message", msg);
			} else if (e1 instanceof CaptchaException) {
				_log.error("CAPTCHA text verification failed... "+e1.getMessage());
				String msg1 = LanguageUtil.format(resourceBundle, "text-verification-failed", false);
				request.setAttribute("message", msg1);
			} else {
				_log.error("User sign up failed...");
				_log.error(e1.getMessage() +" "+e1.getCause());
				String msg = e1.getMessage();
				if (e1.getMessage()==null || e1.getMessage().equals(StringPool.BLANK))
					msg = LanguageUtil.format(resourceBundle, "sign-up-failed", false);
							
				request.setAttribute("message", msg);
			}
			
			request.setAttribute("registrationInfo", ri);
			response.setRenderParameter("mvcPath", IdpRegistrationPortletKeys.PAGE_VIEW);
		}
		
	}
	
	
	private void addUserByIdM(ActionRequest request, ActionResponse response,
		boolean liferayEnabled,
		Locale locale,
		ResourceBundle resourceBundle,
		PortletPreferences portletPreferences,
		RegistrationInfo ri, 
		long companyId,
		String organizationTypelist) {
	
		if (_log.isDebugEnabled())
			_log.debug("addUserByIdM method");

		request.setAttribute("registrationInfo", ri);
		
		try {
			
			CaptchaUtil.check(request);
			validate(ri, organizationTypelist, companyId);
			
			registerIdmUser(ri, portletPreferences, companyId, liferayEnabled);
			
			response.setRenderParameter("mvcPath", IdpRegistrationPortletKeys.PAGE_RESULT);
			request.setAttribute("success", true);
			String msg = LanguageUtil.format(resourceBundle, "sign-up-completed", false);
			request.setAttribute("message", msg);

		} catch (Exception e1) {
			SessionMessages.add(request, SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			request.setAttribute("error", true);
			
			if (e1 instanceof CaptchaException) {
				_log.error("CAPTCHA verification failed... "+e1.getMessage());
				String msg = LanguageUtil.format(resourceBundle, "idp-captcha-verification-failed", false);
				request.setAttribute("message", msg);
			} else if (e1 instanceof CaptchaException) {
				_log.error("CAPTCHA text verification failed... "+e1.getMessage());
				String msg1 = LanguageUtil.format(resourceBundle, "text-verification-failed", false);
				request.setAttribute("message", msg1);
			} else if (e1 instanceof AddIdmUserException) {
				_log.error("IDM Request REST failed, check configuration... "+e1.getMessage());
				String msg1 = "";
				if (e1.getMessage().contains("org.json.JSONException")) {
					msg1 = LanguageUtil.format(resourceBundle, "please-contact-portal-administrator", false) +StringPool.COLON + StringPool.SPACE;
				}
				request.setAttribute("message", msg1 + e1.getMessage());
			} else if (e1 instanceof IdmException) {
				_log.error("Unauthorized IDM request, check configuration... "+e1.getMessage());
				String msg1 = LanguageUtil.format(resourceBundle, "please-contact-portal-administrator", false) +StringPool.COLON + StringPool.SPACE;
				request.setAttribute("message", msg1 + e1.getMessage());
			} else if (e1 instanceof org.apache.http.client.ClientProtocolException) { 
				_log.error("Request REST failed, check configuration... "+e1.getMessage()+", caused "+e1.getCause());
				String msg1 = LanguageUtil.format(resourceBundle, "please-contact-portal-administrator", false) +StringPool.COLON + StringPool.SPACE;
				request.setAttribute("message", msg1 + " "+e1.getMessage()+", caused "+e1.getCause());
			} else if (e1 instanceof IOException) {
				_log.error("RegisterIdmUser method, check configuration... "+e1.getMessage()+", caused "+e1.getCause());
				request.setAttribute("message", e1.getMessage());
			} else if (e1 instanceof JSONException) {
				_log.error("RegisterIdmUser method, check configuration... "+e1.getMessage()+", caused "+e1.getCause());
				String msg1 = LanguageUtil.format(resourceBundle, "please-contact-portal-administrator", false) +StringPool.COLON + StringPool.SPACE;
				request.setAttribute("message", msg1 +e1.getMessage());
			} else {
				_log.error("User sign up failed...");
				_log.error(e1.getMessage() +" "+e1.getCause());
				String msg = e1.getMessage();
				if (e1.getMessage()==null || e1.getMessage().equals(StringPool.BLANK))
					msg = LanguageUtil.format(resourceBundle, "sign-up-failed", false);
							
				request.setAttribute("message", msg);
			}
			
			request.setAttribute("registrationInfo", ri);
			response.setRenderParameter("mvcPath", IdpRegistrationPortletKeys.PAGE_VIEW);
		}
	}
	
	
	private void registerIdmUser(RegistrationInfo ri, PortletPreferences portletPreferences, long companyId, boolean liferayEnabled) 
			throws AddIdmUserException, IdmException, ClientProtocolException, IOException, JSONException {
		
		String	idmUrl = StringUtil.trim(portletPreferences.getValue("idmUrl", _idpRegistrationConfiguration.idmUrl()));
		String	idmEmailAdmin = StringUtil.trim(portletPreferences.getValue("idmEmailAdmin", _idpRegistrationConfiguration.idmEmailAdmin()));
		String	idmPasswordAdmin = portletPreferences.getValue("idmPasswordAdmin", _idpRegistrationConfiguration.idmPasswordAdmin());
		boolean userEnabled = false;
		String	idmEnable = portletPreferences.getValue("idmEnable", _idpRegistrationConfiguration.idmEnable());
		if (idmEnable.equalsIgnoreCase("on")) {
			userEnabled = true;
		}
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpPost post = new HttpPost(idmUrl + IdpRegistrationPortletKeys.IDM_API_AUTH_TOKENS);
		
		post.addHeader("Content-Type", "application/json");

		JSONObject adminInfo = (new JSONFactoryUtil().createJSONObject());
		
		adminInfo.put("name", idmEmailAdmin);
		adminInfo.put("password", idmPasswordAdmin);
		
		StringEntity se = new StringEntity(adminInfo.toString());
		
		post.setEntity(se);
		
		HttpResponse httpResponse = client.execute(post);
		
		int statusCode = httpResponse.getStatusLine().getStatusCode();

		HttpEntity entityToken = httpResponse.getEntity();
		
		String getTokenResponse = EntityUtils.toString(entityToken);
		
		if (_log.isDebugEnabled())
			_log.debug("POST : "+idmUrl + IdpRegistrationPortletKeys.IDM_API_AUTH_TOKENS+" response: "+getTokenResponse);
		
		JSONObject jsonObjectToken = JSONFactoryUtil.createJSONObject(getTokenResponse);

		if (statusCode == HttpStatus.SC_CREATED) {

			String xSubjectToken = httpResponse.getFirstHeader("X-Subject-Token").getValue();

			if (_log.isDebugEnabled()) {
				_log.debug("xSubjectToken: " + xSubjectToken);
				_log.debug("Success Case, X-Auth-token response " + jsonObjectToken);
			}

			if (Validator.isNotNull(xSubjectToken)) {
				JSONObject parentData = (new JSONFactoryUtil().createJSONObject());
				JSONObject childData = (new JSONFactoryUtil().createJSONObject());
				JSONObject visible_attributes = (new JSONFactoryUtil().createJSONObject());
				visible_attributes.put("visible_attributes", "");
				childData.put("email", ri.getEmail());
				childData.put("enabled", userEnabled);
				childData.put("username", ri.getUsername());
				childData.put("password", ri.getPassword1());
				childData.put("domain_id", "default");
				childData.put("extra", visible_attributes);
				childData.put("description", ri.getName() + StringPool.PIPE + ri.getSurname());
				parentData.put("user", childData);

				HttpPost postAddUser = new HttpPost(idmUrl + IdpRegistrationPortletKeys.IDM_API_USERS);
				
				postAddUser.addHeader("Content-Type", "application/json");
				
				postAddUser.addHeader("X-Auth-Token", xSubjectToken);
				
				StringEntity userInfo = new StringEntity(parentData.toString());
				
				postAddUser.setEntity(userInfo);

				if (_log.isDebugEnabled()) {
					_log.debug("userInfo.json-------------------------------------------");
					_log.debug(parentData.toString());
				}

				HttpResponse httpResponseAddUser = client.execute(postAddUser);
				
				int statusCodeAddUser = httpResponseAddUser.getStatusLine().getStatusCode();

				HttpEntity entity = httpResponseAddUser.getEntity();
				
				String getAddUserResponse = EntityUtils.toString(entity);
				
				JSONObject jsonObjectAddUser = JSONFactoryUtil.createJSONObject(getAddUserResponse);

				if (statusCodeAddUser == HttpStatus.SC_CREATED) {
					JSONObject responseMessage = jsonObjectAddUser.getJSONObject("user");
					String id = responseMessage.getString("id");

					_log.info("User sign up completed! User e-mail: " + ri.getEmail());
					
					if (_log.isDebugEnabled()) {
						_log.debug("User sign up completed! Idm userId: " + id);
					}

					sendNotification(ri, portletPreferences, companyId, false);
					
				} else {
					JSONObject responseMessage = jsonObjectAddUser.getJSONObject("error");
					String message = responseMessage.getString("message");
					_log.error("AddIdmUserException: " + responseMessage.toString());
					throw new AddIdmUserException(message);
				}
			}
		} else {
			
			JSONObject responseMessage = jsonObjectToken.getJSONObject("error");
			_log.error("IdmException: " + responseMessage.toString());
			String message = responseMessage.getString("message");
			throw new IdmException(message);
		}
	}

	private void sendNotification(RegistrationInfo ri, PortletPreferences portletPreferences, long companyId, boolean liferayEnabled) {
		
		String	idmUrl = StringUtil.trim(portletPreferences.getValue("idmUrl", _idpRegistrationConfiguration.idmUrl()));
		String	adminEmail = StringUtil.trim(portletPreferences.getValue("idmEmailAdminNotification", _idpRegistrationConfiguration.idmEmailAdminNotification()));
		boolean userEnabled = false;
		String	idmEnable = portletPreferences.getValue("idmEnable", _idpRegistrationConfiguration.idmEnable());
		if (idmEnable.equalsIgnoreCase("on")) {
			userEnabled = true;
		}
		String mailSubject = portletPreferences.getValue("mailSubject", _idpRegistrationConfiguration.mailSubject());
		String from = portletPreferences.getValue("from", _idpRegistrationConfiguration.from());
		String projectName = portletPreferences.getValue("projectName", _idpRegistrationConfiguration.projectName());
		String logoLiferayPortalUrl = portletPreferences.getValue("logoLiferayPortalUrl", _idpRegistrationConfiguration.logoLiferayPortalUrl());
		String liferayPortalName = portletPreferences.getValue("liferayPortalName", _idpRegistrationConfiguration.liferayPortalName());
		String liferayPortalUrl = portletPreferences.getValue("liferayPortalUrl", _idpRegistrationConfiguration.liferayPortalUrl());
		String copyrightCompany = portletPreferences.getValue("copyrightCompany", _idpRegistrationConfiguration.copyrightCompany());
		String copyrightCompanyUrl = portletPreferences.getValue("copyrightCompanyUrl",	_idpRegistrationConfiguration.copyrightCompanyUrl());
		String templateID = portletPreferences.getValue("templateID", _idpRegistrationConfiguration.templateID());
		
		if (_log.isDebugEnabled()) {
			_log.debug("Configuration Values-------------------------------------------");
			_log.debug("companyId: " + companyId);
			_log.debug("liferayEnabled: " + liferayEnabled);
			_log.debug("idmUrl: " + idmUrl);
			_log.debug("adminEmail: " + adminEmail);
			_log.debug("idmEnable: " + idmEnable);
			_log.debug("mailSubject: " + mailSubject);
			_log.debug("from: " + from);
			_log.debug("projectName: " + projectName);
			_log.debug("logoLiferayPortalUrl: " + logoLiferayPortalUrl);
			_log.debug("liferayPortalName: " + liferayPortalName);
			_log.debug("liferayPortalUrl: " + liferayPortalUrl);
			_log.debug("copyrightCompany: " + copyrightCompany);
			_log.debug("copyrightCompanyUrl: " + copyrightCompanyUrl);
			_log.debug("templateID: " + templateID);
		}
		
		Mailer mailer = new Mailer();

		Locale locale = LocaleUtil.getDefault();

		String msgNewAccount = IdpRegistrationPortletKeys.NEW_ACCOUNT;
		if (locale.getLanguage().equalsIgnoreCase("it")) {
			msgNewAccount = IdpRegistrationPortletKeys.NEW_ACCOUNT_IT;
		}
		
		String[] placeholders = new String[] { "[$PROJECT_NAME$]", "[$LOGO_LIFERAY_PORTAL_URL$]",
				"[$LIFERAY_PORTAL_NAME$]", "[$LIFERAY_PORTAL_URL$]", "[$COPYRIGHT_COMPANY_URL$]",
				"[$COPYRIGHT_COMPANY$]", "[$COPYRIGHT_YEAR$]", "[$TO$]", "[$EMAIL$]", "[$PASSWORD$]", "[$IDM$]",
				"[$ORGANIZATION_TYPE$]", "[$ORGANIZATION$]", "[$NAME$]", "[$SURNAME$]", "[$QUESTION$]", "[$REPLY$]",
				"[$WEBSITE$]" };
		
		int year = YearMonth.now().getYear();
		String copyrightYear = String.valueOf(year);
		
		String[] values = new String[] { projectName, logoLiferayPortalUrl, 
				liferayPortalName, liferayPortalUrl, copyrightCompany, 
				copyrightCompanyUrl, copyrightYear, adminEmail, ri.getEmail(), ri.getPassword1(), idmUrl,
				ri.getOrganizationType(), ri.getOrganizationName(), ri.getName(), ri.getSurname(), ri.getQuestion(), ri.getReply(), ri.getOrganizationWebSite() };
		
		boolean adminNotification = true;
		if (liferayEnabled) {
			userEnabled = true;
			_log.debug("liferayEnabled: " + liferayEnabled);
			_log.debug("userEnabled: " + userEnabled);
		}
		
		_log.info("Sending mail to registered user: " + ri.getEmail());
		
		mailer.sentMail(mailSubject, from, ri.getEmail(), !adminNotification, liferayEnabled, userEnabled, templateID, placeholders, values);
		
		if (adminNotification) 
			mailSubject = projectName + StringPool.SPACE + msgNewAccount;
		
		_log.info("Sending mail to Liferay administrator (see Identity Manager Admin E-mail Notification): " + adminEmail);
		
		mailer.sentMail(mailSubject, from, adminEmail, adminNotification, liferayEnabled, userEnabled, templateID, placeholders, values);

	}

	private RegistrationInfo setRegistrationInfo(ActionRequest request, ActionResponse response) {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		String userEmail = uploadRequest.getParameter("email");
		String password1 = uploadRequest.getParameter("password1");
		String password2 = uploadRequest.getParameter("password2");
		String organizationType = ParamUtil.getString(uploadRequest, "orgType");
		String organizationName = uploadRequest.getParameter("organizationName");
		String name = uploadRequest.getParameter("name");
		String surname = uploadRequest.getParameter("surname") ;
		String website = uploadRequest.getParameter("organizationWeb");
		String termsOfUse = uploadRequest.getParameter("termsOfUseCheckbox")!=null ? uploadRequest.getParameter("termsOfUseCheckbox") : "";
		String grantToAddContent = "";
		if (uploadRequest.getParameter("addContentCheckBox")!=null && organizationType!=null && organizationType.equalsIgnoreCase(IdpRegistrationPortletKeys.DIH)) {
			grantToAddContent = uploadRequest.getParameter("addContentCheckBox");
		}
		
		RegistrationInfo ri = new RegistrationInfo();
		ri.setEmail(userEmail);
		ri.setPassword1(password1);
		ri.setPassword2(password2);
		ri.setOrganizationType(organizationType);
		ri.setOrganizationName(organizationName);
		ri.setTermsOfUse(termsOfUse);
		ri.setGrantToAddContent(grantToAddContent);
		ri.setName(name);
		ri.setSurname(surname);
		ri.setOrganizationWebSite(website);
		
		if(_log.isDebugEnabled()) {
			_log.debug("RegistrationInfo-------------------------------------------");
			_log.debug(ri.toString());
		}
		
		return ri;

	}

	private void validate(RegistrationInfo registrationInfo, String organizationTypelist, long companyId) throws PortalException, PortletException{

		if (_log.isDebugEnabled()) {
			_log.debug("User Info to validate-------------------------------------------");
			_log.debug("companyId: " + companyId);
			_log.debug("username: " + registrationInfo.getUsername());
			_log.debug("email: " + registrationInfo.getEmail());
			_log.debug("name: " + registrationInfo.getName());
			_log.debug("surname: " + registrationInfo.getSurname());
			_log.debug("organizationType: " + registrationInfo.getOrganizationType());
			_log.debug("organizationTypelist: " + organizationTypelist.toString());
			_log.debug("termsOfUseEnabled: " +  registrationInfo.isTermsOfUseEnabled());
			_log.debug("website: " + registrationInfo.getOrganizationWebSite());
		}
		
		// required fields

		if (Validator.isNull(registrationInfo.getName())) {
			throw new PortalException("name-is-required");
		}
		if (Validator.isNull(registrationInfo.getSurname())) {
			throw new PortalException("surname-is-required");
		}
		if (Validator.isNull(registrationInfo.getEmail())) {
			throw new PortalException("email-is-required");
		}
		if (Validator.isNull(registrationInfo.getPassword1())) {
			throw new PortalException("password-is-required");
		}
		if (Validator.isNull(registrationInfo.getPassword2())) {
			throw new PortalException("password-again-is-required");
		}
		if (Validator.isNull(registrationInfo.getOrganizationType())) {
			throw new PortalException("organization-type-is-required");
		}
		if (Validator.isNull(registrationInfo.getOrganizationName())) {
			throw new PortalException("organization-name-is-required");
		}
		if (Validator.isNull(registrationInfo.isTermsOfUseEnabled())) {
			throw new PortalException("you-must-accept-terms-of-use");
		}
		if (!registrationInfo.isTermsOfUseEnabled()) {
			throw new PortalException("you-must-accept-terms-of-use");
		}
		
		// validation rules
		
		// username
		DefaultScreenNameValidator defaultScreenNameValidator = new DefaultScreenNameValidator();
		if (!defaultScreenNameValidator.validate(companyId, registrationInfo.getUsername())) {
			_log.error("Invalid username: " + registrationInfo.getUsername());
			throw new PortletException("check-the-characters-of-name-or-surname");
		}

		if (registrationInfo.getUsername().length() > IdpRegistrationPortletKeys.MAX_LENGHT) {
			throw new PortalException("name-has-more-than-x-characters");
		}
		if (registrationInfo.getUsername().length() > IdpRegistrationPortletKeys.MAX_LENGHT) {
			throw new PortalException("surname-has-more-than-x-characters");
		}

		// email
		if (!Validator.isEmailAddress(registrationInfo.getEmail())) {
			throw new PortalException("invalid-email");
		}
		// password
		if (!registrationInfo.getPassword1().equals(registrationInfo.getPassword2())) {
			throw new PortalException("you-have-to-enter-the-same-password");
		}
		Pattern pattern = Pattern.compile(IdpRegistrationPortletKeys.PATTERN);
		// organizationName
		if (matchRegex(registrationInfo.getOrganizationName(), pattern)) {
			_log.error("Invalid organization name:" + registrationInfo.getOrganizationName());
			throw new PortalException("the-organization-name-must-contain");
		}
		// organizationType
		if (Validator.isNotNull(registrationInfo.getOrganizationType())) {
			String[] organizationType_NAMES = StringUtil.splitLines(organizationTypelist);
			boolean contains = Arrays.stream(organizationType_NAMES).anyMatch(registrationInfo.getOrganizationType()::equals);

			if (!contains) {
				throw new PortalException("organization-type-is-not-valid");
			}
		}
		// website
		if (Validator.isNotNull(registrationInfo.getOrganizationWebSite()) && (!Validator.isUrl(registrationInfo.getOrganizationWebSite()))) {
			_log.error("Invalid web organization url:" + registrationInfo.getOrganizationWebSite());
			throw new PortalException("please-enter-a-valid-website");
		}
	}

	private boolean matchRegex(String value, Pattern pattern) {
		if (_log.isDebugEnabled()) {
			_log.debug("Value: " + value);
			_log.debug("Pattern: " + pattern);
		}
		boolean match = false;
		String valueParts = HtmlUtil.escape(value);
		if (!"".equals(valueParts)) {
			String[] parts = valueParts.split(" ");
			for (String part : parts) {
				Matcher matcher = pattern.matcher(StringUtil.trim(part));
				if (matcher.find()) {
					if (_log.isDebugEnabled())
						_log.debug("MatchRegex part: " + part);
					match = true;
				}
			}
		}
		return match;
	}
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	private volatile IdpRegistrationConfiguration _idpRegistrationConfiguration;

	private static final Log _log = LogFactoryUtil.getLog(IdpRegistrationPortlet.class);
}
