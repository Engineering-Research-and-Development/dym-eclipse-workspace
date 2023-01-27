package it.eng.rd.chat.web.portlet;

/**
 * @author ENGRD
 */
//@Component(
//	immediate = true,
//	property = {
//		"com.liferay.portlet.display-category=Collaboration",
//		"com.liferay.portlet.header-portlet-css=/css/main.css",
//		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
//		"com.liferay.portlet.instanceable=true",
//		"javax.portlet.display-name=ChatWeb",
//		"javax.portlet.init-param.template-path=/",
//		"javax.portlet.init-param.view-template=/view.jsp",
//		"javax.portlet.name=" + ChatWebPortletKeys.CHATWEB,
//		"javax.portlet.resource-bundle=content.Language",
//		"javax.portlet.security-role-ref=power-user,user"
//	},
//	service = Portlet.class
//)
//public class ChatWebPortlet extends MVCPortlet {
//}


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.web.util.NotificationUtil;

@Component(immediate = true, property = {"org.osgi.http.websocket.endpoint.path=/o/chat/{userId}"}, service = {Endpoint.class})
public class ChatWebPortlet extends Endpoint {
  public static Hashtable<Long, Session> connections = new Hashtable<>();
  
  private Session session;
  
  private static final Log log = LogFactoryUtil.getLog(ChatWebPortlet.class);
  
  public void onOpen(final Session session, EndpointConfig config) {
    this.session = session;
    Map<String, String> map = session.getPathParameters();
    connections.put(Long.valueOf(Long.parseLong(map.get("userId"))), this.session);
    setConnections(connections);
    NotificationUtil.joinDisconnectBroadcast();
    session.addMessageHandler((MessageHandler)new MessageHandler.Whole<String>() {
          public void onMessage(String text) {
            try {
              RemoteEndpoint.Basic remoteEndpoint = session.getBasicRemote();
              remoteEndpoint.sendText(text);
            } catch (IOException ioe) {
              throw new RuntimeException(ioe);
            } 
          }
        });
  }
  
  public void onClose(Session session, CloseReason closeReason) {
    super.onClose(session, closeReason);
    Map<String, String> map = session.getPathParameters();
    connections.remove(Long.valueOf(Long.parseLong(map.get("userId"))));
    setConnections(connections);
    NotificationUtil.joinDisconnectBroadcast();
  }
  
  public void onError(Session session, Throwable thr) {
    super.onError(session, thr);
    log.info("onError = " + thr.getMessage());
  }
  
  public static Hashtable<Long, Session> getConnections() {
    return connections;
  }
  
  public static void setConnections(Hashtable<Long, Session> connections) {
	  ChatWebPortlet.connections = connections;
  }
}
