/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.rd.chat.service.impl;

import com.google.gson.Gson;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.model.ChatConfigure;
import it.eng.rd.chat.model.ChatMessage;
import it.eng.rd.chat.model.ChatRequest;
import it.eng.rd.chat.service.ChatConfigureLocalServiceUtil;
import it.eng.rd.chat.service.ChatMessageLocalServiceUtil;
import it.eng.rd.chat.service.ChatRequestLocalServiceUtil;
import it.eng.rd.chat.service.base.ChatRequestServiceBaseImpl;

/**
 * The implementation of the chat request remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.chat.service.ChatRequestService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatRequestServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=dym",
		"json.web.service.context.path=ChatRequest"
	},
	service = AopService.class
)
	public class ChatRequestServiceImpl extends ChatRequestServiceBaseImpl {

	@JSONWebService(value="getUsersFF",method="POST")
	public String getUsersFF(
			long scopeGroupId,
			long siteGroupId,
			long companyId,
			long userId,
			String portraitURL
	) {
		
	    List<ChatConfigure> chatConfigures = ChatConfigureLocalServiceUtil.FindConfigureByGroupId(scopeGroupId);
	    List<String> roleIds = new ArrayList<>();
	   
	    if (_log.isDebugEnabled()) {
	    	_log.debug("scopeGroupId: "+scopeGroupId);
		    _log.debug("siteGroupId: "+siteGroupId);
		    _log.debug("companyId: "+companyId);
		    _log.debug("userId: "+userId);
		    _log.debug("portraitURL: "+portraitURL);
	    }
	    
	    if (chatConfigures.size() > 0) {
	      String siteRoleIdsForAccess = ((ChatConfigure)chatConfigures.get(0)).getChatRoleId();
	      roleIds.addAll(Arrays.asList(siteRoleIdsForAccess.split("\\s*,\\s*")));
	    } 
	    long[] longRoleIds = new long[roleIds.size()];
	    for (int i = 0; i < roleIds.size(); ) {
	      longRoleIds[i] = Long.parseLong((String)roleIds.get(i));
	      i++;
	    } 
	    Set<User> users = new HashSet<>();
	    List<User> groupUsers = new ArrayList<>();
	    groupUsers.addAll(UserLocalServiceUtil.getGroupUsers(siteGroupId));
	    for (User user : groupUsers) {
	      if (userHasRoleForAccess(user, siteGroupId, companyId, longRoleIds))
	        users.add(user); 
	    } 
	    for (String roleId : roleIds) {
	      List<User> roleUsers = UserLocalServiceUtil.getRoleUsers(Long.parseLong(roleId));
	      for (User user : roleUsers) {
	        if (GroupLocalServiceUtil.hasUserGroup(user.getUserId(), siteGroupId))
	          users.add(user); 
	      } 
	    } 
	    Predicate<User> condition = user -> String.valueOf(user.getUserId()).equalsIgnoreCase(String.valueOf(userId));
	    users.removeIf(condition);
	    Set<ChatRequest> requestedUser = new HashSet<>();
	    DynamicQuery query = ChatRequestLocalServiceUtil.dynamicQuery();
	    Disjunction fromUser = RestrictionsFactoryUtil.disjunction();
	    fromUser.add(RestrictionsFactoryUtil.eq("fromUserId", Long.valueOf(userId)));
	    fromUser.add(RestrictionsFactoryUtil.eq("toUserId", Long.valueOf(userId)));
	    query.add((Criterion)fromUser);
	    query.add(RestrictionsFactoryUtil.ne("isRejected", Boolean.valueOf(true)));
	    List<ChatRequest> chatReuests = ChatRequestLocalServiceUtil.dynamicQuery(query);
	    requestedUser.addAll(chatReuests);

	    DynamicQuery recentUserDynamicQuery = ChatMessageLocalServiceUtil.dynamicQuery();
	    Disjunction fromUserForUser = RestrictionsFactoryUtil.disjunction();
	    fromUserForUser.add(RestrictionsFactoryUtil.eq("fromUser", Long.valueOf(userId)));
	    fromUserForUser.add(RestrictionsFactoryUtil.eq("toUser", Long.valueOf(userId)));
	    recentUserDynamicQuery.addOrder(OrderFactoryUtil.desc("sentDate"));
	    recentUserDynamicQuery.add((Criterion)fromUserForUser);
	    List<ChatMessage> recentChats = ChatMessageLocalServiceUtil.dynamicQuery(recentUserDynamicQuery);
	    List<Long> recentUserIds = new ArrayList<>();
	    for (ChatMessage recentChat : recentChats) {
	      if (!recentUserIds.contains(Long.valueOf(recentChat.getFromUser())))
	        recentUserIds.add(Long.valueOf(recentChat.getFromUser())); 
	      if (!recentUserIds.contains(Long.valueOf(recentChat.getToUser())))
	        recentUserIds.add(Long.valueOf(recentChat.getToUser())); 
	    } 
	    List<User> recentUsersSet = new ArrayList<>();

	    try {
		    for (Long uid : recentUserIds) {
		      User user = UserLocalServiceUtil.getUser(uid.longValue());
		      if (GroupLocalServiceUtil.hasUserGroup(uid.longValue(), siteGroupId)) {
		        if (userHasRoleForAccess(user, siteGroupId, companyId, longRoleIds)) {
		          recentUsersSet.add(user);
		          continue;
		        } 
		        if (userHasRegularRoleForAccess(uid.longValue(), longRoleIds))
		          recentUsersSet.add(user); 
		      } 
		    } 
	    } catch (PortalException e) {
			_log.error("user error: " + e.getMessage());
		}
	    
	    recentUsersSet.removeIf(condition);
	    users.removeAll(recentUsersSet);
	    recentUsersSet.addAll(users);
	    Map<Long, String> usersPortrait = new HashMap<>();
	    Map<Long, Integer> userUnreadMessage = new HashMap<>();
	    for (User user : recentUsersSet) {
		  usersPortrait.put(Long.valueOf(user.getUserId()), portraitURL);
	      userUnreadMessage.put(Long.valueOf(user.getUserId()), Integer.valueOf(getUnreadMessageCount(Long.valueOf(user.getUserId()), Long.valueOf(userId))));
	    }
	    
	    JSONObject obj = JSONFactoryUtil.createJSONObject();
	    obj.put("users", recentUsersSet);
	    obj.put("userPortrait", usersPortrait);
	    obj.put("requestedUser", requestedUser);
	    obj.put("userUnreadMessage", userUnreadMessage);
	    
	    if (_log.isDebugEnabled()) {
		    _log.debug("users: ");
		    for (User u : recentUsersSet) {
		    	_log.debug(u.toString());
		    }
		    _log.debug("usersPortrait: ");
		    for (Map.Entry<Long, String> entry : usersPortrait.entrySet()) {
		    	_log.debug(entry.getKey()  + '[' + entry.getValue() + ']');
		    }
		    _log.debug("requestedUser: ");
		    Iterator itr = requestedUser.iterator();
		    while(itr.hasNext()){
		    	_log.debug(itr.next()+",");
		    }
		    
		    _log.debug("userUnreadMessage: ");
		    for (Map.Entry<Long, Integer> entry : userUnreadMessage.entrySet()) {
		    	_log.debug(entry.getKey()  + '[' + entry.getValue() + ']');
		    }
	    }
	     
    	String json = new Gson().toJson(obj);
    	if (_log.isDebugEnabled()) 
    		_log.debug("json: " + json);
    		
    	return json;
	}
	
	private static boolean userHasRoleForAccess(User user, long siteId, long companyId, long[] roleIds) {
	    for (int i = 0; i < roleIds.length; i++) {
	      if (UserGroupRoleLocalServiceUtil.hasUserGroupRole(user.getUserId(), siteId, roleIds[i], true))
	        return true; 
	      try {
	        Role role = RoleLocalServiceUtil.getRole(companyId, "Site Member");
	        if (role.getRoleId() == roleIds[i])
	          return true; 
	      } catch (PortalException e) {
	        _log.error(e.getMessage());
	      } 
	    } 
	    return false;
  }

  private boolean userHasRegularRoleForAccess(long userId, long[] roleIds) {
    for (int i = 0; i < roleIds.length; i++) {
      if (UserLocalServiceUtil.hasRoleUser(roleIds[i], userId))
        return true; 
    } 
    return false;
  }
  
  private int getUnreadMessageCount(Long fromUserId, Long toUserId) {
    DynamicQuery query = ChatMessageLocalServiceUtil.dynamicQuery();
    query.add(RestrictionsFactoryUtil.eq("fromUser", fromUserId));
    query.add(RestrictionsFactoryUtil.eq("toUser", toUserId));
    query.add(RestrictionsFactoryUtil.eq("readed", Boolean.valueOf(false)));
    query.add(RestrictionsFactoryUtil.eq("deleted", Boolean.valueOf(false)));
    List<ChatMessage> chatMessages = ChatMessageLocalServiceUtil.dynamicQuery(query);
    return chatMessages.size();
  }
  
  private static Log _log = LogFactoryUtil.getLog(ChatRequestServiceImpl.class);
}

