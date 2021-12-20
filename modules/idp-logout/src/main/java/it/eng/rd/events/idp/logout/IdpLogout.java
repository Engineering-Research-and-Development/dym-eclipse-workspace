package it.eng.rd.events.idp.logout;


import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PrefsProps;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
        immediate = true,
        property = "key=logout.events.post",
        service = LifecycleAction.class)
public class IdpLogout implements LifecycleAction {

    @Override    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

        try {
            HttpServletRequest request = lifecycleEvent.getRequest();
            HttpServletResponse response = lifecycleEvent.getResponse();

            String DYMATattribute = (String) request.getAttribute("DYMATattribute");
            _log.info("DYMATattribute: "+DYMATattribute);
           
            Cookie[] cookiesNew = request.getCookies();

			if (cookiesNew != null) {
				for (Cookie c : cookiesNew) {
					if (c.getName().startsWith("DYM")) {
						_log.info(c.getName() +": "+c.getValue());
					}
					if (c.getName().startsWith("DYMAT")) {
						CookieKeys.deleteCookies(request, response, c.getDomain(), "DYMAT");
						_log.info("domain "+c.getDomain() +", deleted "+c.getName());
					}
					if (c.getName().startsWith("DYM_EXTRA")) {
						CookieKeys.deleteCookies(request, response, c.getDomain(), "DYM_EXTRA");
						_log.info("domain "+c.getDomain() +", deleted "+c.getName());
					}
					if (c.getName().startsWith("DYM")) {
						CookieKeys.deleteCookies(request, response, c.getDomain(), "DYM");
						_log.info("domain "+c.getDomain() +", deleted "+c.getName());
					}
					
					if (c.getName().startsWith("LFR_SESSION_STATE")) {
						CookieKeys.deleteCookies(request, response, c.getDomain(), c.getName());
						_log.info("domain "+c.getDomain() +", deleted "+c.getName());
					}
					if (c.getName().startsWith("session.sig")) {
						CookieKeys.deleteCookies(request, response, c.getDomain(), c.getName());
						_log.info("domain "+c.getDomain() +", deleted "+c.getName());
					}
					if (c.getName().startsWith("session")) {
						CookieKeys.deleteCookies(request, response, c.getDomain(), c.getName());
						_log.info("domain "+c.getDomain() +", deleted "+c.getName());
					}
					if (c.getName().startsWith("_csrf")) {
						CookieKeys.deleteCookies(request, response, c.getDomain(), c.getName());
						_log.info("domain "+c.getDomain() +", deleted "+c.getName());
					}

				}
			}
            
        } catch (Exception e) {
            _log.error("Error in LogoutPostAction: " + e.getMessage(), e);
        }
    }


    @Reference    private Portal _portal;
    @Reference    private PrefsProps _prefsProps;

    private static final Log _log = LogFactoryUtil.getLog(IdpLogout.class);
}