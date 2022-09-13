package it.eng.rd.dymer.portlet.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.sso.openid.connect.OpenIdConnectSession;
import com.liferay.portal.security.sso.openid.connect.constants.OpenIdConnectWebKeys;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import it.eng.rd.dymer.portlet.configuration.DymerViewerConfiguration;
import it.eng.rd.dymer.portlet.constants.DymerViewerPortletKeys;
import it.eng.rd.dymer.portlet.util.crypto.AesCrypto;

/**
 * @author ENGRD
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
			_log.error("An error occurred while setting cookies, "+e.getMessage());
		}
		
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		
		if (httpServletRequest!=null) {
			HttpSession httpSession = PortalUtil.getOriginalServletRequest(httpServletRequest).getSession();
			
			if (httpSession!=null) {
				OpenIdConnectSession openIdConnectSession = (OpenIdConnectSession)httpSession.getAttribute(OpenIdConnectWebKeys.OPEN_ID_CONNECT_SESSION);
				if (openIdConnectSession==null) {
					 _log.warn("no OPEN_ID_CONNECT_SESSION data");	
				} else {
					String accessToken = "";
					try {
						accessToken = openIdConnectSession.getAccessTokenValue();

						if (_log.isDebugEnabled()) {
							_log.debug("StateValue: "+openIdConnectSession.getStateValue());
							_log.debug("LoginTime: "+openIdConnectSession.getLoginTime());
							_log.debug("LoginUserId: "+openIdConnectSession.getLoginUserId());
							_log.debug("RefreshTokenValue: "+openIdConnectSession.getRefreshTokenValue());
							_log.debug("OpenIdProviderName: "+openIdConnectSession.getOpenIdProviderName());
							_log.debug("NonceValue: "+openIdConnectSession.getNonceValue());
						}

						PortletPreferences _portletPreferences = renderRequest.getPreferences();
						
						Cookie cookie = new Cookie("DYMAT", accessToken);
						cookie.setMaxAge(CookieKeys.MAX_AGE);
						cookie.setPath("/");
						
						CookieKeys.addCookie(PortalUtil.getHttpServletRequest(renderRequest), PortalUtil.getHttpServletResponse(renderResponse), cookie);	  
						renderRequest.setAttribute("DYMATattribute", accessToken);
						HttpServletRequest convertRes = PortalUtil.getHttpServletRequest(renderRequest);
						HttpServletRequest originalRequest = (HttpServletRequest) ((HttpServletRequestWrapper) convertRes).getRequest();
					    Cookie DYMATNEW = new Cookie("LODYMAT", accessToken);
					    DYMATNEW.setMaxAge(CookieKeys.MAX_AGE);
					    DYMATNEW.setPath("/");

						CookieKeys.addCookie(originalRequest, PortalUtil.getHttpServletResponse(renderResponse), DYMATNEW);
						
					} catch (Exception e) {
						 _log.warn("no accessTokenValue, "+e.getMessage());	
					}
					
				}//openIdConnectSession
			} 
			
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
	private void setCookies(RenderRequest renderRequest, RenderResponse renderResponse) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User currentUser = themeDisplay.getUser();
		
		String[] jwts = AesCrypto.dymerJwts(currentUser, themeDisplay.getScopeGroupId());
		
		String dymerJwt = AesCrypto.encrypting(jwts[0]);
		if (dymerJwt.equalsIgnoreCase(jwts[0])){	
			dymerJwt = new String (Base64.getEncoder().encode(dymerJwt.getBytes()));
			if (_log.isDebugEnabled())
				_log.debug(" dymerJwt base64: "+dymerJwt);
		}
		
		String dymerExtraJwt = new String (Base64.getEncoder().encode((jwts[1]).getBytes()));
		
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