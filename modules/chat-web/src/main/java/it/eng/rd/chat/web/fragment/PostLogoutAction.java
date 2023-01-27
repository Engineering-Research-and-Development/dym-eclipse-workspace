package it.eng.rd.chat.web.fragment;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import javax.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.web.common.WebsocketServiceImpl;

@Component(immediate = true, property = {"key=logout.events.post"}, service = {LifecycleAction.class})
public class PostLogoutAction implements LifecycleAction {
  public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
    HttpServletRequest req = lifecycleEvent.getRequest();
    WebsocketServiceImpl websocketServiceImpl = new WebsocketServiceImpl();
    String userId = req.getRemoteUser();
    websocketServiceImpl.clearStorage(Long.valueOf(Long.parseLong(userId)));
    req.setAttribute("userId", userId);
  }
}
