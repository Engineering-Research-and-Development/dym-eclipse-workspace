package it.eng.rd.chat.web.action;

import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.model.ChatConfigure;
import it.eng.rd.chat.model.ChatMessage;
import it.eng.rd.chat.model.ChatRequest;
import it.eng.rd.chat.service.ChatConfigureLocalServiceUtil;
import it.eng.rd.chat.service.ChatMessageLocalServiceUtil;
import it.eng.rd.chat.service.ChatRequestLocalServiceUtil;
import it.eng.rd.chat.web.util.ChatServiceUtil;

@Component(immediate = true, 
	property = {
			"javax.portlet.name=it_eng_rd_chat_web_SocketPortlet", 
			"mvc.command.name=/getUsers"}, 
	service = {MVCResourceCommand.class}
)
public class GetLiferayUsersMVCResourceCommand extends BaseMVCResourceCommand {
  private static Log _log = LogFactoryUtil.getLog(GetLiferayUsersMVCResourceCommand.class);
  
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
    List<ChatConfigure> chatConfigures = ChatConfigureLocalServiceUtil.FindConfigureByGroupId(themeDisplay.getScopeGroupId());
    List<String> roleIds = new ArrayList<>();
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
    groupUsers.addAll(UserLocalServiceUtil.getGroupUsers(themeDisplay.getSiteGroupId()));
    for (User user : groupUsers) {
      if (userHasRoleForAccess(user, themeDisplay.getSiteGroupId(), themeDisplay.getCompanyId(), longRoleIds))
        users.add(user); 
    } 
    for (String roleId : roleIds) {
      List<User> roleUsers = UserLocalServiceUtil.getRoleUsers(Long.parseLong(roleId));
      for (User user : roleUsers) {
        if (GroupLocalServiceUtil.hasUserGroup(user.getUserId(), themeDisplay.getSiteGroupId()))
          users.add(user); 
      } 
    } 
    Predicate<User> condition = user -> String.valueOf(user.getUserId()).equalsIgnoreCase(String.valueOf(themeDisplay.getUserId()));
    users.removeIf(condition);
    Set<ChatRequest> requestedUser = new HashSet<>();
    DynamicQuery query = ChatRequestLocalServiceUtil.dynamicQuery();
    Disjunction fromUser = RestrictionsFactoryUtil.disjunction();
    fromUser.add(RestrictionsFactoryUtil.eq("fromUserId", Long.valueOf(themeDisplay.getUserId())));
    fromUser.add(RestrictionsFactoryUtil.eq("toUserId", Long.valueOf(themeDisplay.getUserId())));
    query.add((Criterion)fromUser);
    query.add(RestrictionsFactoryUtil.ne("isRejected", Boolean.valueOf(true)));
    List<ChatRequest> chatReuests = ChatRequestLocalServiceUtil.dynamicQuery(query);
    requestedUser.addAll(chatReuests);
    DynamicQuery recentUserDynamicQuery = ChatMessageLocalServiceUtil.dynamicQuery();
    Disjunction fromUserForUser = RestrictionsFactoryUtil.disjunction();
    fromUserForUser.add(RestrictionsFactoryUtil.eq("fromUser", Long.valueOf(themeDisplay.getUserId())));
    fromUserForUser.add(RestrictionsFactoryUtil.eq("toUser", Long.valueOf(themeDisplay.getUserId())));
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
    for (Long userId : recentUserIds) {
      User user = UserLocalServiceUtil.getUser(userId.longValue());
      if (GroupLocalServiceUtil.hasUserGroup(userId.longValue(), themeDisplay.getSiteGroupId())) {
        if (userHasRoleForAccess(user, themeDisplay.getSiteGroupId(), themeDisplay.getCompanyId(), longRoleIds)) {
          recentUsersSet.add(user);
          continue;
        } 
        if (userHasRegularRoleForAccess(userId.longValue(), longRoleIds))
          recentUsersSet.add(user); 
      } 
    } 
    recentUsersSet.removeIf(condition);
    users.removeAll(recentUsersSet);
    recentUsersSet.addAll(users);
    Map<Long, String> usersPortrait = new HashMap<>();
    Map<Long, Integer> userUnreadMessage = new HashMap<>();
    for (User user : recentUsersSet) {
      usersPortrait.put(Long.valueOf(user.getUserId()), user.getPortraitURL(themeDisplay));
      userUnreadMessage.put(Long.valueOf(user.getUserId()), Integer.valueOf(ChatServiceUtil.getUnreadMessageCount(Long.valueOf(user.getUserId()), Long.valueOf(themeDisplay.getUserId()))));
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
    
    try {
    	String json = new Gson().toJson(obj);
    	if (_log.isDebugEnabled()) 
    		_log.debug("json " + json);
    	resourceResponse.getWriter().println(json);
    } catch (IOException e) {
    	_log.error(e.getMessage());
    } catch (Exception e) {
    	_log.error(e.getMessage());
    } finally {
      resourceResponse.getWriter().flush();
      resourceResponse.getWriter().close();
    } 
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
  
  public static boolean userHasRegularRoleForAccess(long userId, long[] roleIds) {
    for (int i = 0; i < roleIds.length; i++) {
      if (UserLocalServiceUtil.hasRoleUser(roleIds[i], userId))
        return true; 
    } 
    return false;
  }
}
