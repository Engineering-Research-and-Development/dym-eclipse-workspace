package it.eng.rd.chat.web.util;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.List;

import javax.portlet.ResourceRequest;

import it.eng.rd.chat.model.ChatMessage;
import it.eng.rd.chat.service.ChatMessageLocalServiceUtil;
import it.eng.rd.chat.web.message.indexer.ChatMessageHistory;
import it.eng.rd.chat.web.message.indexer.ChatMessageObject;

public class ChatServiceUtil {
  public static List<ChatMessage> getUserUnreadMessages(Long toUserId, Long fromUserId) {
    DynamicQuery query = ChatMessageLocalServiceUtil.dynamicQuery();
    query.add(RestrictionsFactoryUtil.eq("fromUser", fromUserId));
    query.add(RestrictionsFactoryUtil.eq("toUser", toUserId));
    query.add(RestrictionsFactoryUtil.eq("readed", Boolean.valueOf(false)));
    List<ChatMessage> unreadMessage = ChatMessageLocalServiceUtil.dynamicQuery(query);
    return unreadMessage;
  }
  
  public static List<ChatMessage> getRecentMessageByFromUser(Long fromUserId) {
    DynamicQuery query = ChatMessageLocalServiceUtil.dynamicQuery();
    query.add(RestrictionsFactoryUtil.eq("fromUser", fromUserId));
    query.addOrder(OrderFactoryUtil.desc("id"));
    query.setLimit(0, 1);
    List<ChatMessage> chatMessages = ChatMessageLocalServiceUtil.dynamicQuery(query);
    return chatMessages;
  }
  
  public static List<ChatMessageObject> getChat(ResourceRequest resourceRequest, Long toUserId, Long fromUserId, int count) {
    return ChatMessageHistory.getHistory(resourceRequest, toUserId, fromUserId, count);
  }
  
  public static int getUserChatCount(Long toUserId, Long fromUserId) {
    Disjunction fromUser = RestrictionsFactoryUtil.disjunction();
    fromUser.add(RestrictionsFactoryUtil.eq("fromUser", fromUserId));
    fromUser.add(RestrictionsFactoryUtil.eq("fromUser", toUserId));
    Disjunction toUser = RestrictionsFactoryUtil.disjunction();
    toUser.add(RestrictionsFactoryUtil.eq("toUser", fromUserId));
    toUser.add(RestrictionsFactoryUtil.eq("toUser", toUserId));
    DynamicQuery query = ChatMessageLocalServiceUtil.dynamicQuery();
    query.add((Criterion)fromUser);
    query.add((Criterion)toUser);
    List<ChatMessage> chatMessages = ChatMessageLocalServiceUtil.dynamicQuery(query);
    return chatMessages.size();
  }
  
  public static int getUnreadMessageCount(Long fromUserId, Long toUserId) {
    DynamicQuery query = ChatMessageLocalServiceUtil.dynamicQuery();
    query.add(RestrictionsFactoryUtil.eq("fromUser", fromUserId));
    query.add(RestrictionsFactoryUtil.eq("toUser", toUserId));
    query.add(RestrictionsFactoryUtil.eq("readed", Boolean.valueOf(false)));
    query.add(RestrictionsFactoryUtil.eq("deleted", Boolean.valueOf(false)));
    List<ChatMessage> chatMessages = ChatMessageLocalServiceUtil.dynamicQuery(query);
    return chatMessages.size();
  }
}
