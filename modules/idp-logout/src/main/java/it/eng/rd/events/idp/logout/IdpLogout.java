package it.eng.rd.events.idp.logout;


import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


import it.eng.rd.events.idp.logout.constants.IdpLogoutPropsKeys;
import it.eng.rd.events.idp.util.crypto.AesCrypto;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.CookieSpecs;

import javax.servlet.http.*;

@Component(
        immediate = true,
        property = "key=logout.events.post",
        service = LifecycleAction.class)
public class IdpLogout implements LifecycleAction {
	
    @Override    
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
    	HttpServletRequest request = lifecycleEvent.getRequest();
        HttpServletResponse response = lifecycleEvent.getResponse();
        User user = null;
        try {
			user = PortalUtil.getUser(request);
        } catch (PortalException e1) {
			_log.error("An error occurred while checking user info in LogoutPostAction: "+e1.getMessage());
		}
			
		List<Role> roles = user.getRoles();
		
		if (!containsName(roles, "Administrator")) {
				
	        String idm_host = GetterUtil.getString(PropsUtil.get(IdpLogoutPropsKeys.IDM_HOST));
	        String idm_client_id = GetterUtil.getString(PropsUtil.get(IdpLogoutPropsKeys.IDM_CLIENT_ID));
	        String idm_secret_id = GetterUtil.getString(PropsUtil.get(IdpLogoutPropsKeys.IDM_SECRET_ID));
	        String secretKey = "";
    		secretKey = GetterUtil.getString(PropsUtil.get(IdpLogoutPropsKeys.SECRET_KEY));
    		String idm_without_custom_logout = idm_without_custom_logout = GetterUtil.getString(PropsUtil.get(IdpLogoutPropsKeys.IDM_WITHOUT_CUSTOM_LOGOUT));
    		 _log.info("props idm_without_custom_logout "+idm_without_custom_logout);
    		if (Validator.isNull(idm_without_custom_logout)) {
    			 _log.info("isNotNull ");
    			 idm_without_custom_logout = "false";
    		}
    		
	        if (_log.isDebugEnabled()) {
	        	_log.debug("idm_host: "+idm_host);
		        _log.debug("idm_client_id: "+idm_client_id);
		        _log.debug("idm_secret_id: "+idm_secret_id);
		        _log.debug("secretKey "+secretKey);
		        _log.debug("idm_without_custom_logout "+idm_without_custom_logout);
	        }
	        _log.info("idm_without_custom_logout "+idm_without_custom_logout);
	        if (Validator.isNotNull(idm_host) && user!=null) {
	        	
	        	try (CloseableHttpClient client = HttpClients.createDefault()) {
	        		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(request);
	        		String logoutDYMAT = CookieKeys.getCookie(originalRequest, "LODYMAT");

	        		try {
		        		String messageDecriptato = "";
		        		if(Validator.isNotNull(secretKey) && !secretKey.equalsIgnoreCase("")) {
		        			logoutDYMAT = AesCrypto.decrypt(logoutDYMAT, secretKey);
		        			
						}
	        		} catch(Exception e) {
	        			_log.error("An error occurred while decrypting access token: " + e.getMessage());
	        		} 
	        		
	        		String authorization = idm_client_id+":"+idm_secret_id;
					String authEncoded = Base64.getEncoder().encodeToString(authorization.getBytes());
	        		
					try {
						HttpPost postRevoke = new HttpPost(idm_host+IdpLogoutPropsKeys.REVOKE_URL);
		        		postRevoke.addHeader(IdpLogoutPropsKeys.CONTENT_TYPE,IdpLogoutPropsKeys.X_WWW_FORM_URLENCODED);
						postRevoke.addHeader(IdpLogoutPropsKeys.AUTHORIZATION, IdpLogoutPropsKeys.AUTH_METHOD+" "+authEncoded);
						List<NameValuePair> body = new ArrayList<NameValuePair>();
						body.add(new BasicNameValuePair("token", logoutDYMAT));
		        		UrlEncodedFormEntity revokeEntity = new UrlEncodedFormEntity(body, Consts.UTF_8);
		        		revokeEntity.setContentType(IdpLogoutPropsKeys.X_WWW_FORM_URLENCODED+"; "+IdpLogoutPropsKeys.CHARSET);
		        		postRevoke.setEntity(revokeEntity);
		        		_log.info("Starting token revoke: "+idm_host+IdpLogoutPropsKeys.REVOKE_URL);
						HttpResponse  httpRevokeResponse = client.execute(postRevoke);
						int statusCodeRevoke = httpRevokeResponse.getStatusLine().getStatusCode();
						HttpEntity revokeToken = httpRevokeResponse.getEntity();
						
						if (_log.isDebugEnabled()) {
							_log.debug("Base64(clientId:secretId): "+authEncoded);
							_log.debug("logoutDYMAT: "+logoutDYMAT);
							_log.debug("Response revoke statusCode: "+statusCodeRevoke);
							String revokeResponse = EntityUtils.toString(revokeToken);
							JSONObject revokeResponseJSON = JSONFactoryUtil.createJSONObject(revokeResponse);
							_log.debug("Response revoke: "+revokeResponseJSON.toJSONString());
						}
						
						if (statusCodeRevoke == HttpStatus.SC_OK) {
							_log.info("User token revoked ");
						} else {
							_log.warn("Invalid token: access or refresh token is invalid ");
						}
					} catch(Exception e) {
	        			_log.error("An error occurred while revoking access token: " + e.getMessage());
	        		} 
					

					
					String pathInfo = request.getPathInfo();
					_log.info("pathInfo "+pathInfo);
					if (Validator.isNotNull(pathInfo) && pathInfo.contains("/portal/logout")) {

						HttpSession session = request.getSession();
						session.invalidate();
						String logoutUrl = StringPool.BLANK;
						
						if (idm_without_custom_logout.equalsIgnoreCase("false")) {
							logoutUrl = idm_host + IdpLogoutPropsKeys.CUSTOM_IDM_LOGOUT_URL +"&client_id=" + idm_client_id;
						} else {
							logoutUrl = idm_host + IdpLogoutPropsKeys.IDM_LOGOUT_URL;
						}
						
						_log.info("logoutUrl "+logoutUrl);

						if (null != logoutUrl && logoutUrl.length() > 0) {
							_log.info("Starting idm custom logout ");
							response.sendRedirect(logoutUrl);
							_log.info("The userId="+user.getUserId()+" has logged out of idm");
							return;
						}

					}
					
	        	} catch (IOException e) {
	        		_log.error("An error occurred during logout event: " + e.getMessage());
				} 
	        }
		}
		
    }

    private boolean containsName(final List<Role> list, final String name){
        return list.stream().map(Role::getName).filter(name::equals).findFirst().isPresent();
    }

    @Reference    
    private Portal _portal;
    
    private static Log _log = LogFactoryUtil.getLog(IdpLogout.class);
}