package it.eng.rd.idp.registration.portlet;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

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
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
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
	
	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		renderRequest.setAttribute(
				IdpRegistrationConfiguration.class.getName(),
				_idpRegistrationConfiguration);
		
		super.doView(renderRequest, renderResponse);
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
		_log.info("test");
	}
		
	public void processAction(ActionRequest request, ActionResponse response) throws IOException {
		PortletPreferences portletPreferences = request.getPreferences();
			
		String idmUrl = StringPool.BLANK;
		if (Validator.isNotNull(_idpRegistrationConfiguration)) {
			idmUrl = portletPreferences.getValue("idmUrl", _idpRegistrationConfiguration.idmUrl());
		}
		String idmEmailAdmin = StringPool.BLANK;
		if (Validator.isNotNull(_idpRegistrationConfiguration)) {
			idmEmailAdmin = portletPreferences.getValue("idmEmailAdmin", _idpRegistrationConfiguration.idmEmailAdmin());
		}
		String idmEmailAdminNotification = StringPool.BLANK;
		if (Validator.isNotNull(_idpRegistrationConfiguration)) {
			idmEmailAdminNotification = portletPreferences.getValue("idmEmailAdminNotification", _idpRegistrationConfiguration.idmEmailAdminNotification());
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
		
		try{
		    CaptchaUtil.check(request);
		    if (_log.isDebugEnabled()) {
		    	 _log.debug("CAPTCHA verification successful");
		    }
		
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			String email = uploadRequest.getParameter("email");
			String username = uploadRequest.getParameter("username");
			String password = uploadRequest.getParameter("password1");
			
			if (_log.isDebugEnabled()) {
				_log.debug("------------------Configuration Info----------------");
				_log.debug("idmUrl: "+idmUrl);
				_log.debug("idmEmailAdmin: "+idmEmailAdmin);
				_log.debug("idmEmailAdminNotification: "+idmEmailAdminNotification);
				_log.debug("idmPasswordAdmin: "+idmPasswordAdmin);	
				_log.debug("idmUserEnabled: "+idmUserEnabled);
				_log.debug("------------------New user Info---------------------");
				_log.debug("email: "+email);
				_log.debug("username: "+username);
//				_log.debug("password: "+password);
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
						childData.put("email", email);
						childData.put("enabled", idmUserEnabled);
						childData.put("username", username);
						childData.put("password", password);
						childData.put("domain_id", "default");
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
							String projectName = "";
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								projectName = portletPreferences.getValue("projectName", _idpRegistrationConfiguration.projectName());
							}
							String logoLiferayPortalUrl = "";
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								logoLiferayPortalUrl = portletPreferences.getValue("logoLiferayPortalUrl", _idpRegistrationConfiguration.logoLiferayPortalUrl());
							}
							String liferayPortalName = "";
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								liferayPortalName = portletPreferences.getValue("liferayPortalName", _idpRegistrationConfiguration.liferayPortalName());
							}
							String liferayPortalUrl = "";
							if (Validator.isNotNull(_idpRegistrationConfiguration)) {
								liferayPortalUrl = portletPreferences.getValue("liferayPortalUrl", _idpRegistrationConfiguration.liferayPortalUrl());
							}
							
							if (_log.isDebugEnabled()) {
								_log.debug("subject: "+mailSubject);
								_log.debug("from: "+from);
								_log.debug("projectName: "+projectName);
								_log.debug("logoLiferayPortalUrl: "+logoLiferayPortalUrl);
								_log.debug("liferayPortalName: "+liferayPortalName);
								_log.debug("liferayPortalUrl: "+liferayPortalUrl);
							}
							
							Mailer mailer = new Mailer();
							mailer.sentMail(projectName + "New Account", from, projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, idmEmailAdminNotification, password, idmUrl, true, idmUserEnabled);
							mailer.sentMail(mailSubject, from, projectName, logoLiferayPortalUrl, liferayPortalName, liferayPortalUrl, email, password, idmUrl, false, idmUserEnabled);
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
			_log.error("CAPTCHA verification failed.");
		    SessionMessages.add(request,  SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		    request.setAttribute("error", true);
			request.setAttribute("message", "captcha-verification-failed");
			response.setRenderParameter("mvcPath", StringPool.SLASH + IdpRegistrationPortletKeys.PAGE_VIEW);
		}
	}
		
    protected boolean isCheckMethodOnProcessAction() {
        return _CHECK_METHOD_ON_PROCESS_ACTION;
    }
 
    private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
    private volatile IdpRegistrationConfiguration _idpRegistrationConfiguration;
    
    private static final Log _log = LogFactoryUtil.getLog(IdpRegistrationPortlet.class);

}
