package it.eng.rd.events.idp.logout.constants;

import com.liferay.portal.kernel.util.PropsKeys;

public class IdpLogoutPropsKeys implements PropsKeys {

	public static final String IDM_HOST = "idm.host";
	
//	public static final String IDM_CLIENT_ID = "idm.client_id";
	
//	public static final String IDM_SECRET_ID = "idm.secret_id";
	
	public static final String OIDC_PROVIDER_NAME = "oidc.provider.name";
	
	public static final String REVOKE_URL = "/oauth2/revoke";
	
	public static final String IDM_LOGOUT_URL = "/auth/logout?_method=DELETE";
	
	public static final String CUSTOM_IDM_LOGOUT_URL = "/auth/logout2?_method=DELETE";
	
	public static final String AUTH_METHOD = "Basic";
	
	public static final String X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
	
	public static final String AUTHORIZATION = "Authorization";
	
	public static final String CHARSET = "charset=UTF-8";
	
	public static final String CONTENT_TYPE = "Content-Type";
	
	public static final String SECRET_KEY = "aes.secret.key";
	
	public static final String IDM_WITHOUT_CUSTOM_LOGOUT ="idm.without.custom.logout";
	
	public static final String AES_SECRET_KEY = "aes.secret.key";

}