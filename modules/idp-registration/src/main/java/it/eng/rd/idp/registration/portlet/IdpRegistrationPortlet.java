package it.eng.rd.idp.registration.portlet;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.DefaultScreenNameValidator;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
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
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.eng.rd.idp.registration.constants.IdpRegistrationPortletKeys;
import it.eng.rd.idp.registration.mailer.Mailer;
import it.eng.rd.idp.registration.portlet.configuration.IdpRegistrationConfiguration;

/**
 * @author viviana.latino
 */
@Component(
	configurationPid = "it.eng.rd.idp.registration.portlet.configuration.IdpRegistrationConfiguration",
	immediate = true,
	property = {
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
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
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

		renderRequest.setAttribute(
			IdpRegistrationConfiguration.class.getName(),
			_idpRegistrationConfiguration);
	
		super.render(renderRequest, renderResponse);
	}
		
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_idpRegistrationConfiguration = ConfigurableUtil.createConfigurable(
				IdpRegistrationConfiguration.class, properties);
	}
		
	@Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
        throws  IOException, PortletException {
        try {
            CaptchaUtil.serveImage(resourceRequest, resourceResponse);
        }catch(Exception exception) {
            _log.error(exception.getMessage(), exception);
        }
    }
 
	public void addUser(ActionRequest request, ActionResponse response) {
		_log.info("addUser method");
	}
		
	public void processAction(ActionRequest request, ActionResponse response) throws IOException {
		PortletPreferences portletPreferences = request.getPreferences();
		
		String idmUrl = StringPool.BLANK;
		if (Validator.isNotNull(_idpRegistrationConfiguration)) {
			idmUrl = StringUtil.trim(portletPreferences.getValue("idmUrl", _idpRegistrationConfiguration.idmUrl()));
		}
		String idmEmailAdmin = StringPool.BLANK;
		if (Validator.isNotNull(_idpRegistrationConfiguration)) {
			idmEmailAdmin = StringUtil.trim(portletPreferences.getValue("idmEmailAdmin", _idpRegistrationConfiguration.idmEmailAdmin()));
		}
		String idmEmailAdminNotification = StringPool.BLANK;
		if (Validator.isNotNull(_idpRegistrationConfiguration)) {
			idmEmailAdminNotification = StringUtil.trim(portletPreferences.getValue("idmEmailAdminNotification", _idpRegistrationConfiguration.idmEmailAdminNotification()));
		}
		String idmPasswordAdmin = StringPool.BLANK;
		if (Validator.isNotNull(_idpRegistrationConfiguration)) {
			idmPasswordAdmin = portletPreferences.getValue("idmPasswordAdmin", _idpRegistrationConfiguration.idmPasswordAdmin());
		}
		String idmEnable = "off";
		boolean  idmUserEnabled = false;
		if (Validator.isNotNull(_idpRegistrationConfiguration)) {
			idmEnable = portletPreferences.getValue("idmEnable", _idpRegistrationConfiguration.idmEnable());
			if (idmEnable.equalsIgnoreCase("on")) {
				idmUserEnabled = true;
			}
		}
		String organizationTypelist = StringPool.BLANK;
		if (Validator.isNotNull(_idpRegistrationConfiguration)) {
			organizationTypelist = StringUtil.trim(portletPreferences.getValue("organizationTypelist", _idpRegistrationConfiguration.organizationTypelist()));
		}
		
		boolean addContentEnabled = false;	
		String addContent = ParamUtil.getString(request, "addContent");
		if (addContent.equalsIgnoreCase("on")) {
			addContentEnabled = true;
		}
		
		try{
		    CaptchaUtil.check(request);
		    if (_log.isDebugEnabled()) {
		    	 _log.debug("CAPTCHA verification successful");
		    }
		    
		    UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			String email =  uploadRequest.getParameter("email");
			if (Validator.isNotNull(email)) {
				email = StringUtil.trim(email);
			}
/*			String username = uploadRequest.getParameter("username");
			if (Validator.isNotNull(username)) {
				username = StringUtil.trim(username);
			}*/
			String password = uploadRequest.getParameter("password1");
			String password2 = uploadRequest.getParameter("password2");
			String organizationType = ParamUtil.getString(uploadRequest, "orgType");
			if (Validator.isNotNull(organizationType)) {
				organizationType =	StringUtil.trim(organizationType);
				organizationType = HtmlUtil.escape(organizationType);
			}
			String organizationName = uploadRequest.getParameter("organizationName");
			if (Validator.isNotNull(organizationType)) {
				organizationName = StringUtil.trim(organizationName);
				organizationName =  HtmlUtil.escape(organizationName);
			}
			String termsOfUseEnable = uploadRequest.getParameter("termsOfUseCheckbox");
			
			String name = uploadRequest.getParameter("name");
			if (Validator.isNotNull(name)) {
				name = StringUtil.trim(name);
				name = HtmlUtil.escape(name);
			}
			String surname = uploadRequest.getParameter("surname");
			if (Validator.isNotNull(surname)) {
				surname = StringUtil.trim(surname);
				surname = HtmlUtil.escape(surname);
			}
			String username = StringPool.BLANK;
			String dName = StringPool.BLANK;
			String dSurname = StringPool.BLANK;
			
			if (Validator.isNotNull(name) && Validator.isNotNull(surname)) {
				dName = name;
				dSurname = surname;
				
				name = name.replaceAll("\\s+","");
				surname = surname.replaceAll("\\s+","");
				username = name.toLowerCase() +StringPool.PERIOD + surname.toLowerCase();
			}
			int usernameMaxLenght = 30;
			if (username.length() > usernameMaxLenght) {
				username = username.substring(0, usernameMaxLenght);
				_log.info("The username has been truncated to thirty characters: "+username);
			}
			
			/*String organizationRole = StringPool.BLANK;
			if (Validator.isNotNull(uploadRequest.getParameter("organization-role"))) {
				organizationRole = StringUtil.trim(uploadRequest.getParameter("organization-role"));
			}*/
			String website = uploadRequest.getParameter("organizationWeb");
			if (Validator.isNotNull(website)) {
				website = StringUtil.trim(website);
			}
			
			validate(request, username, email, password, password2, organizationName, organizationType, organizationTypelist, termsOfUseEnable, name, surname, website);
			
			if (_log.isDebugEnabled()) {
				_log.debug("------------------Configuration Info----------------");
				_log.debug("idmUrl: "+idmUrl);
				_log.debug("idmEmailAdmin: "+idmEmailAdmin);
				_log.debug("idmEmailAdminNotification: "+idmEmailAdminNotification);
//				_log.debug("idmPasswordAdmin: "+idmPasswordAdmin);	
				_log.debug("idmUserEnabled: "+idmUserEnabled);
				_log.debug("name: "+name);
				_log.debug("surname: "+surname);
				_log.debug("username: "+username);
				_log.debug("dName: "+dName);
				_log.debug("dSurname: "+dSurname);
				_log.debug("----------------------------------------------------");
			}
			
			try (CloseableHttpClient client = HttpClients.createDefault()) {
				HttpPost post = new HttpPost(idmUrl+IdpRegistrationPortletKeys.IDM_API_AUTH_TOKENS);
				post.addHeader("Content-Type","application/json");
				 
				JSONObject adminInfo = (new JSONFactoryUtil().createJSONObject());
				adminInfo.put("name", idmEmailAdmin);
				adminInfo.put("password", idmPasswordAdmin);
				StringEntity se = new StringEntity(adminInfo.toString());
				post.setEntity(se);
				HttpResponse  httpResponse = client.execute(post);
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				
				HttpEntity entityToken = httpResponse.getEntity();
				String getTokenResponse = EntityUtils.toString(entityToken);
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
						childData.put("email", email);
						childData.put("enabled", idmUserEnabled);
						childData.put("username", username);
						childData.put("password", password);
						childData.put("domain_id", "default");
						childData.put("extra", visible_attributes);
						childData.put("description", dName+StringPool.PIPE+dSurname);
						parentData.put("user", childData);
						    
						HttpPost postAddUser = new HttpPost(idmUrl+IdpRegistrationPortletKeys.IDM_API_USERS);
						postAddUser.addHeader("Content-Type","application/json");
						postAddUser.addHeader("X-Auth-Token",xSubjectToken);
						StringEntity userInfo = new StringEntity(parentData.toString());
						postAddUser.setEntity(userInfo);
						
						if (_log.isDebugEnabled()) {
							_log.debug("userInfo " +parentData.toString());
						}
							
						HttpResponse  httpResponseAddUser = client.execute(postAddUser);
						int statusCodeAddUser = httpResponseAddUser.getStatusLine().getStatusCode();
						
						HttpEntity entity = httpResponseAddUser.getEntity();
						String getAddUserResponse = EntityUtils.toString(entity);
						JSONObject jsonObjectAddUser = JSONFactoryUtil.createJSONObject(getAddUserResponse);
							
						if (statusCodeAddUser == HttpStatus.SC_CREATED) {
							JSONObject responseMessage = jsonObjectAddUser.getJSONObject ("user");
							String id = responseMessage.getString("id");
							
							if (_log.isDebugEnabled()) {
								_log.debug("User sign up completed! Idm userId: "+id);
		    				}
							
							String mailSubject = "Collaboration Portal registration";
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								mailSubject = portletPreferences.getValue("mailSubject", _idpRegistrationConfiguration.mailSubject());
							}
							String from = "noreply@server.com";
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								from = portletPreferences.getValue("from", _idpRegistrationConfiguration.from());
							}
							String projectName = StringPool.BLANK;
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								projectName = portletPreferences.getValue("projectName", _idpRegistrationConfiguration.projectName());
							}
							String logoLiferayPortalUrl = StringPool.BLANK;
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								logoLiferayPortalUrl = portletPreferences.getValue("logoLiferayPortalUrl", _idpRegistrationConfiguration.logoLiferayPortalUrl());
							}
							String liferayPortalName = StringPool.BLANK;
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								liferayPortalName = portletPreferences.getValue("liferayPortalName", _idpRegistrationConfiguration.liferayPortalName());
							}
							String liferayPortalUrl = StringPool.BLANK;
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								liferayPortalUrl = portletPreferences.getValue("liferayPortalUrl", _idpRegistrationConfiguration.liferayPortalUrl());
							}
							String copyrightCompany = StringPool.BLANK;
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								copyrightCompany = portletPreferences.getValue("copyrightCompany", _idpRegistrationConfiguration.copyrightCompany());
							}
							String copyrightCompanyUrl = StringPool.POUND;
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								copyrightCompanyUrl = portletPreferences.getValue("copyrightCompanyUrl", _idpRegistrationConfiguration.copyrightCompanyUrl());
							}
							
							Mailer mailer = new Mailer();
							
							Locale locale = LocaleUtil.getDefault();
							
							String msgNewAccount = " New Account";
							if (locale.getLanguage().equalsIgnoreCase("it")) {
								msgNewAccount = " Nuovo Account";
							}
							String question = StringPool.BLANK;
							String reply = StringPool.BLANK;
							_log.info("sending mail to IDM admin");
							
							if (organizationType.equalsIgnoreCase("DIH")) {
								question = "Would you like to be enabled to insert content into the portal?";
								if (addContentEnabled) {
									reply = "Yes.";
								} else {
									reply = "No.";
								}
							}
							
							mailer.sentMail(projectName + msgNewAccount, from, projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, idmEmailAdminNotification, email, password, idmUrl, true, idmUserEnabled, organizationType, organizationName, copyrightCompany, copyrightCompanyUrl, dName, dSurname, question, reply, website);
							_log.info("send mail to registered user");
							mailer.sentMail(mailSubject, from, projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, email, email, password, idmUrl, false, idmUserEnabled, organizationType, organizationName, copyrightCompany, copyrightCompanyUrl, dName, dSurname, question, reply, website);
						} else {
							JSONObject responseMessage = jsonObjectAddUser.getJSONObject ("error");
							String message = responseMessage.getString("message");
							throw new Exception(message);
						}
							
					}
				} else {
					_log.error("Failed Case, X-Auth-token response: " + jsonObjectToken);
					JSONObject responseMessage = jsonObjectToken.getJSONObject ("error");
					String message = responseMessage.getString("message");
					throw new Exception(message);
				}
			  	response.setRenderParameter("mvcPath", StringPool.SLASH + IdpRegistrationPortletKeys.PAGE_RESULT);
				request.setAttribute("success", true);
				request.setAttribute("message", "sign-up-completed");
				
				
			} catch (Exception e) {
				request.setAttribute("error", true);
				request.setAttribute("message", e.getMessage());
				response.setRenderParameter("mvcPath", StringPool.SLASH + IdpRegistrationPortletKeys.PAGE_RESULT);
			}
			
		}catch(Exception e1) {
			SessionMessages.add(request,  SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			request.setAttribute("error", true);
			Locale locale = LocaleUtil.getDefault();
			
			if (e1 instanceof CaptchaException) {
				_log.error("CAPTCHA verification failed...");
				String msg = LanguageUtil.format(
						locale,
						"idp-captcha-verification-failed", false);
			    request.setAttribute("message", msg);
			} else if (e1 instanceof CaptchaException) {	
				_log.error("CAPTCHA text verification failed...");
				String msg1 = LanguageUtil.format(
						locale,
						"text-verification-failed", false);
			    request.setAttribute("message", msg1);
			} else {
				_log.error("An error occurred while trying to sign up");
				_log.error(e1.getMessage());
				request.setAttribute("message", e1.getMessage());
			}
			
			response.setRenderParameter("mvcPath", StringPool.SLASH + IdpRegistrationPortletKeys.PAGE_VIEW);

		}
	}
	
	private void validate(ActionRequest request,
			 String username, String email, String password1, String password2, String organizationName, String organizationType, String organizationTypelist, String termsOfUseEnable,
			 String name, String surname, String website)
		throws PortalException, PortletException {
		
		if (_log.isDebugEnabled()) {
			_log.debug("------------------New user Info---------------------");
//			_log.debug("username escaped: "+username);
			_log.debug("name: "+name);
			_log.debug("surname: "+surname);
			_log.debug("email: "+email);
//			_log.debug("password: "+password);
			_log.debug("organizationName (escaped): "+organizationName);
			_log.debug("organizationType (escaped): "+organizationType);
			_log.debug("termsOfUseEnable: "+termsOfUseEnable);
			_log.debug("website: "+website);
			_log.debug("----------------------------------------------------");
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Locale locale = LocaleUtil.getDefault();
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		
		int maxLenght = 30;
		
		/*
		 *  fields required
		 */
		
/*		if (Validator.isNull(username)) {
			throw new PortalException("username-is-required");
		}*/
		if (Validator.isNull(name)) {
			throw new PortalException("name-is-required");
		}
		if (Validator.isNull(surname)) {
			throw new PortalException("surname-is-required");
		}
		if (Validator.isNull(email)) {
			throw new PortalException("email-is-required");
		}
		if (Validator.isNull(password1)) {
			throw new PortalException("password-is-required");
		}
		if (Validator.isNull(password2)) {
			throw new PortalException("password-again-is-required");
		}
		if (Validator.isNull(organizationName)) {
			throw new PortalException("organization-name-is-required");
		}
		if (Validator.isNull(organizationType)) {
			throw new PortalException("organization-type-is-required");
		}
		/*if (organizationType.equalsIgnoreCase("DIH") && Validator.isNull(organizationRole)) {
			throw new PortalException("organization-role-is-required");
		}*/
		if (Validator.isNull(termsOfUseEnable)) {
			throw new PortalException("you-must-accept-terms-of-use");
		}
		boolean termsOfUseEnabled = false;
		if (termsOfUseEnable.equalsIgnoreCase("on")) {
			termsOfUseEnabled = true;
		}
		if (!termsOfUseEnabled) {
			throw new PortalException("you-must-accept-terms-of-use");
		}
		
		/*
		 * fields valid
		 */
		// username
		DefaultScreenNameValidator defaultScreenNameValidator = new DefaultScreenNameValidator();
		if (!defaultScreenNameValidator.validate(themeDisplay.getCompanyId(), username)) {
			_log.error("Invalid username: "+username);
			throw new PortletException("check-the-characters-of-name-or-surname");
//			throw new PortletException(defaultScreenNameValidator.getDescription(locale));
		}
		/*if (username.length() > usernameMaxLenght) {
			String message = LanguageUtil.format(
					httpRequest, "username-has-more-than-x-characters", usernameMaxLenght,
					true);
			throw new PortalException(message);
		}*/
		
		if (name.length() > maxLenght) {
			throw new PortalException("name-has-more-than-x-characters");
		}
		if (surname.length() > maxLenght) {
			throw new PortalException("surname-has-more-than-x-characters");
		}
		
		// email
		if (!Validator.isEmailAddress(email)) {
			throw new PortalException("invalid-email");
		}
		// password
		if (!password1.equals(password2)) {
			throw new PortalException("you-have-to-enter-the-same-password");
		}
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9._-]");
		// organizationName
		if(matchRegex(organizationName, pattern)) {
			_log.error("Invalid organization name:"+organizationName);
			throw new PortalException("the-organization-name-must-contain");
		};
		
		// organizationRole
		/*if (Validator.isNotNull(organizationRole) && matchRegex(organizationRole, pattern)) {
			_log.error("Invalid organization role:"+organizationRole);
			throw new PortalException("the-organization-role-must-contain");
		}*/
		// organizationType
		if (Validator.isNotNull(organizationType)) {
			String[] organizationType_NAMES = StringUtil.splitLines(organizationTypelist);
			boolean contains = Arrays.stream(organizationType_NAMES).anyMatch(organizationType::equals);
			
			if (!contains) {
				throw new PortalException("organization-type-is-not-valid");
			}
		}
		// website
		if (Validator.isNotNull(website) && (!Validator.isUrl(website))) {
			_log.error("Invalid web organization url:"+website);
			throw new PortalException("please-enter-a-valid-url");
		}
	}
	
	private boolean matchRegex(String value, Pattern pattern){
		if (_log.isDebugEnabled()) {
			_log.debug("Value: " +value);
			_log.debug("Pattern: " +pattern);
		}
		boolean match = false;
        String valueParts =  HtmlUtil.escape(value);
        if (!"".equals(valueParts)) {
            String[] parts = valueParts.split(" ");
            for ( String part : parts ) {
            	Matcher matcher = pattern.matcher(StringUtil.trim(part));
            	if(matcher.find()) {
            		if (_log.isDebugEnabled())
                		_log.debug("MatchRegex part: " +part);
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
