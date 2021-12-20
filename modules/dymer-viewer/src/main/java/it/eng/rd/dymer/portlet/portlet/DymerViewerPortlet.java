package it.eng.rd.dymer.portlet.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectSession;
import com.liferay.portal.security.sso.openid.connect.constants.OpenIdConnectWebKeys;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.eng.rd.dymer.portlet.configuration.DymerViewerConfiguration;
import it.eng.rd.dymer.portlet.constants.DymerViewerPortletKeys;
import it.eng.rd.util.crypto.AesCrypto;

import javax.portlet.PortletPreferences;
/**
 * @author Viviana Latino
 */


@Component(
	configurationPid = "it.eng.rd.dymer.configuration.DymerViewerConfiguration",
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.display-name=Dymer Viewer Portlet",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DymerViewerPortletKeys.DYMERVIEWER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DymerViewerPortlet extends MVCPortlet {
	
	
	
	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		renderRequest.setAttribute(
				DymerViewerConfiguration.class.getName(),
			_dymerViewerConfiguration);
		try {
			setCookies(renderRequest, renderResponse);
		} catch (PortalException e) {
			_log.error(e,e);
		}
		HttpSession httpSession = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)).getSession();
		
		if (httpSession!=null) {
			OpenIdConnectSession openIdConnectSession = (OpenIdConnectSession)httpSession.getAttribute(OpenIdConnectWebKeys.OPEN_ID_CONNECT_SESSION);
			if (openIdConnectSession==null) {
				 _log.warn("OpenIdConnectSession is null");	
			} else {
				String accessToken = openIdConnectSession.getAccessTokenValue();
				
				if (_log.isDebugEnabled()) {
					_log.debug("StateValue: "+openIdConnectSession.getStateValue());
					_log.debug("LoginTime: "+openIdConnectSession.getLoginTime());
					_log.debug("LoginUserId: "+openIdConnectSession.getLoginUserId());
					_log.debug("RefreshTokenValue: "+openIdConnectSession.getRefreshTokenValue());
					_log.debug("OpenIdProviderName: "+openIdConnectSession.getOpenIdProviderName());
					_log.debug("NonceValue: "+openIdConnectSession.getNonceValue());
					_log.debug("AccessToken: "+accessToken);	
				}

//				HttpServletRequest servletRequest = (HttpServletRequest) PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
				
				PortletPreferences _portletPreferences = renderRequest.getPreferences();
				
				String secretKey = "";
				if (Validator.isNotNull(_dymerViewerConfiguration)) {
					secretKey = _portletPreferences.getValue("secretKey", _dymerViewerConfiguration.secreKey());
					
					if(Validator.isNotNull(secretKey) && !secretKey.equalsIgnoreCase("")) {
						accessToken = AesCrypto.encrypt(accessToken, secretKey);
						_log.debug("secretKey "+secretKey);
						_log.debug("crypted accessToken "+accessToken);
					}
					
//					_log.info("---->"+AesCrypto.encrypt("a2a81aae2781d5286731b650ed9f44ff230a947b", "xxxxxxxxxxxxxxx"));
				}
				
				Cookie cookie = new Cookie("DYMAT", accessToken);
				cookie.setMaxAge(CookieKeys.MAX_AGE);
				cookie.setPath("/");
				
				CookieKeys.addCookie(PortalUtil.getHttpServletRequest(renderRequest), PortalUtil.getHttpServletResponse(renderResponse), cookie);	  
				renderRequest.setAttribute("DYMATattribute", accessToken);
			}
		} else {
			 _log.warn("HttpSession is null");	
		}	
		
		super.doView(renderRequest, renderResponse);
	}
	
	/*
	protected boolean hasValidAccessToken(accessToken, tokenLifetime) {

			AccessToken accessToken = openIdConnectSessionImpl.getAccessToken();

			if (accessToken == null) {
				return false;
			}

			long currentTime = System.currentTimeMillis();
			long lifetime = accessToken.getLifetime() * Time.SECOND;
			long loginTime = openIdConnectSessionImpl.getLoginTime();

			if ((currentTime - loginTime) < lifetime) {
				return true;
			}

			return false;
	}  */
	
	private void setCookies(RenderRequest renderRequest, RenderResponse renderResponse) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User currentUser = themeDisplay.getUser();
		
		JSONObject userInfoJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray roleArray = JSONFactoryUtil.createJSONArray();
		List<Role> roles = currentUser.getRoles();
		for (Role role : roles) {
			JSONObject userRole = JSONFactoryUtil.createJSONObject();
			userRole.put("id", role.getRoleId());
			userRole.put("role", role.getName());
			roleArray.put(userRole);
		}
		userInfoJSONObject.put("username", currentUser.getFullName());
		userInfoJSONObject.put("app_azf_domain", "");
		userInfoJSONObject.put("authorization_decision", "");
		userInfoJSONObject.put("id", "");
		userInfoJSONObject.put("email", currentUser.getEmailAddress());
		userInfoJSONObject.put("isGravatarEnabled", false);
		userInfoJSONObject.put("app_id", "");
		userInfoJSONObject.put("roles", roleArray);
		JSONObject extraInfoJSONObject = JSONFactoryUtil.createJSONObject();
		extraInfoJSONObject.put("userId", currentUser.getUserId());
		extraInfoJSONObject.put("groupId", themeDisplay.getScopeGroupId());
		extraInfoJSONObject.put("companyId", currentUser.getCompanyId());
		extraInfoJSONObject.put("cms", "lfr");
		Company company = CompanyLocalServiceUtil.getCompany(currentUser.getCompanyId());
	 	extraInfoJSONObject.put("virtualhost", company.getVirtualHostname());
		userInfoJSONObject.put("extrainfo", extraInfoJSONObject);
		
		JSONObject dymerExtraInfoJSONObject = JSONFactoryUtil.createJSONObject();
		dymerExtraInfoJSONObject.put("extrainfo", extraInfoJSONObject);
		
		String dymerToken = userInfoJSONObject.toJSONString();
		String dymerJwt = new String (Base64.getEncoder().encode(dymerToken.getBytes()));
		
		String dymerExtraJwt = new String (Base64.getEncoder().encode((dymerExtraInfoJSONObject.toJSONString()).getBytes()));
		
		Cookie cookie = new Cookie("DYM", dymerJwt);
		cookie.setMaxAge(CookieKeys.MAX_AGE);
		cookie.setPath("/");
		
		Cookie cookieExtra = new Cookie("DYM_EXTRA", dymerJwt);
		cookieExtra.setMaxAge(CookieKeys.MAX_AGE);
		cookieExtra.setPath("/");

		CookieKeys.addCookie(PortalUtil.getHttpServletRequest(renderRequest), PortalUtil.getHttpServletResponse(renderResponse), cookie);
		CookieKeys.addCookie(PortalUtil.getHttpServletRequest(renderRequest), PortalUtil.getHttpServletResponse(renderResponse), cookieExtra);
	}
	
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_dymerViewerConfiguration = ConfigurableUtil.createConfigurable(
				DymerViewerConfiguration.class, properties);
	}

	private static final Log _log = LogFactoryUtil.getLog(
			DymerViewerPortlet.class);

	private volatile DymerViewerConfiguration _dymerViewerConfiguration;

}