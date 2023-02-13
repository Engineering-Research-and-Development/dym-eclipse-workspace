package it.eng.rd.events.idp.logout;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
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
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectProvider;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectProviderRegistry;
import com.nimbusds.openid.connect.sdk.op.OIDCProviderMetadata;
import com.nimbusds.openid.connect.sdk.rp.OIDCClientMetadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.events.idp.logout.constants.IdpLogoutPropsKeys;
import it.eng.rd.events.idp.util.crypto.AesCrypto;

@Component(
        immediate = true,
        property = "key=logout.events.post",
        service = LifecycleAction.class)
public class IdpLogout implements LifecycleAction {
	
    @Override    
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
    	
    	/*
    	Collection<String> openIdConnectProviderNames =	_openIdConnectProviderRegistry.getOpenIdConnectProviderNames(_portal.getCompanyId(httpServletRequest));  
    	
    	for (String provider : openIdConnectProviderNames) {
    		_log.info("providerName: "+provider);
    	}
    	*/
    	
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
	        String providerName = GetterUtil.getString(PropsUtil.get(IdpLogoutPropsKeys.OIDC_PROVIDER_NAME));
	        String secretKey = "";
    		secretKey = GetterUtil.getString(PropsUtil.get(IdpLogoutPropsKeys.SECRET_KEY));
    		String idm_without_custom_logout = GetterUtil.getString(PropsUtil.get(IdpLogoutPropsKeys.IDM_WITHOUT_CUSTOM_LOGOUT));
    		if (Validator.isNull(idm_host)) {
 	        	_log.error("Set idm.host in portal-ext.properties.");
 	        }
 	        if (Validator.isNull(providerName)) {
 	        	_log.error("Set oidc.provider.name in portal-ext.properties.");
 	        }
    		 if (Validator.isNull(idm_without_custom_logout)) {
    			 _log.warn("If you want invoke the native IDM endpoint logout set idm.without.custom.logout=true in portal-ext.properties.");
    			 //otherwise if you want invoke the custom IDM endpoint logout2 don't set that property
    			 idm_without_custom_logout = "false";
    		}
    		
	        if (_log.isDebugEnabled()) {
	        	_log.debug("idm_host: "+idm_host);
	        	_log.debug("idm_without_custom_logout: "+idm_without_custom_logout);
		        _log.debug("secretKey: "+secretKey);
		        _log.debug("providerName: "+providerName);
	        }
	        if (Validator.isNotNull(idm_host) && user!=null && Validator.isNotNull(providerName)) {
	        	
	        	try (CloseableHttpClient client = HttpClients.createDefault()) {
	        		
	        		long companyId =  _portal.getCompanyId(request);
	            	OpenIdConnectProvider<OIDCClientMetadata, OIDCProviderMetadata>	openIdConnectProvider =  _openIdConnectProviderRegistry.getOpenIdConnectProvider(companyId, providerName);
	            	String idm_client_id = openIdConnectProvider.getClientId();
	            	String idm_secret_id = openIdConnectProvider.getClientSecret();
	            	if (_log.isDebugEnabled()) {
	    	        	_log.debug("companyId: "+companyId);
	    		        _log.debug("idm_client_id: "+idm_client_id);
	    		        _log.debug("idm_secret_id: "+idm_secret_id);
	    	        }
	        		
	        		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(request);
	        		String logoutDYMAT = CookieKeys.getCookie(originalRequest, "LODYMAT");
	        		
	        		
	        		
	        		
	        		
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
    
	@Reference
	private OpenIdConnectProviderRegistry _openIdConnectProviderRegistry;
    
    private static Log _log = LogFactoryUtil.getLog(IdpLogout.class);
}