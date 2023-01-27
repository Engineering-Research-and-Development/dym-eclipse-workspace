package it.eng.rd.chat.web.util;

import java.io.IOException;
import java.util.Hashtable;

import javax.websocket.Session;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.eng.rd.chat.web.portlet.ChatWebPortlet;

public class NotificationUtil {
  public static void joinDisconnectBroadcast() {
    Hashtable<Long, Session> connections = ChatWebPortlet.getConnections();
    for (Long userId : connections.keySet()) {
      try {
        JSONArray onlineUserIds = getOnlineUserIdOfSockets();
        onlineUserIds.remove(userId);
        Session session = connections.get(userId);
        JSONObject obj = new JSONObject();
        obj.put("sendFrom", userId);
        obj.put("onlineUserIds", onlineUserIds);
        if (session.isOpen())
          session.getBasicRemote().sendText(obj.toJSONString()); 
      } catch (IOException ignore) {
        ignore.printStackTrace();
      } 
    } 
  }
  
  private static JSONArray getOnlineUserIdOfSockets() {
    JSONArray userIds = new JSONArray();
    Hashtable<Long, Session> connections = ChatWebPortlet.getConnections();
    for (Long userId : connections.keySet()) {
      if (!userIds.contains(userId))
        userIds.add(userId); 
    } 
    return userIds;
  }
}
