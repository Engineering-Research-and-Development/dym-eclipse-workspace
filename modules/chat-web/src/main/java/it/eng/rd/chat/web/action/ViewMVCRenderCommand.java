package it.eng.rd.chat.web.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.chat.model.ChatConfigure;
import it.eng.rd.chat.service.ChatConfigureLocalService;
import it.eng.rd.chat.service.ChatConfigureLocalServiceUtil;


@Component(immediate = true, property = {
		"javax.portlet.name=it_eng_rd_chat_web_SocketPortlet", 
		"mvc.command.name=/"
}, service = {MVCRenderCommand.class})
public class ViewMVCRenderCommand implements MVCRenderCommand {
  private static Log _log = LogFactoryUtil.getLog(ViewMVCRenderCommand.class.getName());
  
  @Reference
  private ChatConfigureLocalService _chatConfigureLocalService;
  
  public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
    ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
    if (_log.isDebugEnabled())
    	_log.debug("scopeGroupId: "+themeDisplay.getScopeGroupId());
    
    List<ChatConfigure> chatConfigures = ChatConfigureLocalServiceUtil.FindConfigureByGroupId(themeDisplay.getScopeGroupId());
    String[] roleIdSiteConfiguration = new String[0];
    boolean userHaveRoleForChat = false;
    if (chatConfigures.size() > 0 && 
      Validator.isNotNull(((ChatConfigure)chatConfigures.get(0)).getChatRoleId()))
      roleIdSiteConfiguration = ((ChatConfigure)chatConfigures.get(0)).getChatRoleId().split(","); 
    for (int i = 0; i < roleIdSiteConfiguration.length; i++) {
      if (RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), Long.parseLong(roleIdSiteConfiguration[i])) && 
        GroupLocalServiceUtil.hasUserGroup(themeDisplay.getUserId(), themeDisplay.getSiteGroupId()))
        userHaveRoleForChat = true; 
      if (GroupLocalServiceUtil.hasUserGroup(themeDisplay.getUserId(), themeDisplay.getSiteGroupId()))
        if (UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), themeDisplay.getSiteGroupId(), Long.parseLong(roleIdSiteConfiguration[i]))) {
          userHaveRoleForChat = true;
        } else {
          try {
            Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Site Member");
            if (role.getRoleId() == Long.parseLong(roleIdSiteConfiguration[i]))
              userHaveRoleForChat = true; 
          } catch (PortalException e) {
            _log.error(e,e);
          } 
        }  
    } 
    if (chatConfigures.size() > 0) {
      ChatConfigure chatConfigure = chatConfigures.get(0);
      renderRequest.setAttribute("isEnable", Boolean.valueOf(chatConfigure.getEnable()));
      renderRequest.setAttribute("requestFeature", Boolean.valueOf(chatConfigure.getRequestFeature()));
      renderRequest.setAttribute("headerColor", chatConfigure.getHeaderColor());
      renderRequest.setAttribute("chatRightColor", chatConfigure.getChatRightColor());
      renderRequest.setAttribute("chatLeftColor", chatConfigure.getChatLeftColor());
      renderRequest.setAttribute("headerTextColor", chatConfigure.getHeaderTextColor());
      renderRequest.setAttribute("contentTextColor", chatConfigure.getContentTextColor());
      renderRequest.setAttribute("backColor", chatConfigure.getBackColor());
      renderRequest.setAttribute("fontFamily", chatConfigure.getFontFamily());
    } else {
      renderRequest.setAttribute("requestFeature", Boolean.valueOf(false));
      renderRequest.setAttribute("isEnable", Boolean.valueOf(false));
    } 
    if (userHaveRoleForChat) {
      String endPoint = "/o/chat/{userId}"; 
      if (_log.isDebugEnabled())
    	  _log.debug("render, endPoint "+endPoint);
      endPoint = endPoint.replace("{userId}", "" + themeDisplay.getUserId());
      renderRequest.setAttribute("socketChatEndPointPath", endPoint);
    } 
    renderRequest.setAttribute("userHaveRole", Boolean.valueOf(userHaveRoleForChat));
    return "/view.jsp";
  }
}

