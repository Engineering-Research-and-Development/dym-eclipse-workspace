package it.eng.rd.chat.web.common;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.websocket.Session;

import it.eng.rd.chat.model.ChatMessage;
import it.eng.rd.chat.service.ChatMessageLocalServiceUtil;
import it.eng.rd.chat.web.message.indexer.MessageIndexer;
import it.eng.rd.chat.web.portlet.ChatWebPortlet;
import it.eng.rd.chat.web.util.ChatServiceUtil;

public class WebsocketServiceImpl implements WebsocketService {
  private static Log log = LogFactoryUtil.getLog(WebsocketServiceImpl.class);
  
  public void sendChatMessage(User toUser, User fromUser, Long messageId) {
    try {
      Hashtable<Long, Session> connection = ChatWebPortlet.getConnections();
      if (connection.containsKey(Long.valueOf(toUser.getUserId()))) {
        Session session = connection.get(Long.valueOf(toUser.getUserId()));
        List<ChatMessage> chatMessages = ChatServiceUtil.getRecentMessageByFromUser(Long.valueOf(fromUser.getUserId()));
        JSONObject obj = JSONFactoryUtil.createJSONObject();
        obj.put("toUser", fromUser.getUserId());
        obj.put("fromUser", toUser.getUserId());
        obj.put("fromUserName", fromUser.getFullName());
        obj.put("chat", chatMessages);
        if (session.isOpen()) {
          ChatMessage chatMessage = ChatMessageLocalServiceUtil.getChatMessage(messageId.longValue());
          chatMessage.setReaded(true);
          chatMessage.setReadDate(new Date());
          ChatMessageLocalServiceUtil.updateChatMessage(chatMessage);
          MessageIndexer.reindex(ChatMessage.class.getName(), chatMessage);
          session.getBasicRemote().sendText(obj.toJSONString());
        } 
      } 
    } catch (Exception e) {
      log.error(e, e);
    } 
  }
  
  public void typingMessage(User toUser, User fromUser) {
    try {
      Hashtable<Long, Session> connection = ChatWebPortlet.getConnections();
      synchronized (connection) {
        if (connection.containsKey(Long.valueOf(toUser.getUserId()))) {
          Session session = connection.get(Long.valueOf(toUser.getUserId()));
          Message message = new Message();
          message.setFrom(fromUser.getFullName());
          String chatJson = "{ \"writing\": \"writing\" ,\"fromUserId\": " + fromUser.getUserId() + " }";
          message.setContent(chatJson);
          if (session.isOpen())
            session.getBasicRemote().sendText(chatJson); 
        } 
      } 
    } catch (Exception e) {
      log.error(e.getMessage());
    } 
  }
  
  public void sendRequest(User toUser, User fromUser) {
    try {
      Hashtable<Long, Session> connection = ChatWebPortlet.getConnections();
      if (connection.containsKey(Long.valueOf(toUser.getUserId()))) {
        Session session = connection.get(Long.valueOf(toUser.getUserId()));
        JSONObject obj = JSONFactoryUtil.createJSONObject();
        obj.put("sendRequest", true);
        obj.put("from", fromUser.getFullName());
        if (session.isOpen())
          session.getBasicRemote().sendText(obj.toJSONString()); 
      } 
    } catch (Exception e) {
      log.error(e, e);
    } 
  }
  
  public void requestAction(User toUser, User fromUser, boolean status) {
    try {
      Hashtable<Long, Session> connection = ChatWebPortlet.getConnections();
      if (connection.containsKey(Long.valueOf(toUser.getUserId()))) {
        String action = "";
        if (status) {
          action = "accept";
        } else {
          action = "reject";
        } 
        Session session = connection.get(Long.valueOf(toUser.getUserId()));
        JSONObject obj = JSONFactoryUtil.createJSONObject();
        obj.put("requestAction", action);
        obj.put("from", fromUser.getFullName());
        if (session.isOpen())
          session.getBasicRemote().sendText(obj.toJSONString()); 
      } 
    } catch (Exception e) {
      log.error(e, e);
    } 
  }
  
  public void clearStorage(Long userId) {
    try {
      Hashtable<Long, Session> connection = ChatWebPortlet.getConnections();
      if (connection.containsKey(userId)) {
        Session session = connection.get(userId);
        JSONObject obj = JSONFactoryUtil.createJSONObject();
        obj.put("clearStorage", true);
        if (session.isOpen())
          session.getBasicRemote().sendText(obj.toJSONString()); 
      } 
    } catch (Exception e) {
      log.error(e, e);
    } 
  }
}
