package it.eng.rd.chat.config.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.chat.model.ChatConfigure;
import it.eng.rd.chat.service.ChatConfigureLocalService;
import it.eng.rd.chat.service.ChatConfigureLocalServiceUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=it_eng_rd_chat_config_ChatConfigPortlet", 
		"mvc.command.name=/getSiteData"
}, service = {MVCResourceCommand.class})
public class GetSiteDataMVCResourceCommand extends BaseMVCResourceCommand {
  private static Log _log = LogFactoryUtil.getLog(GetSiteDataMVCResourceCommand.class);
  
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
    long groupId = ParamUtil.getLong((PortletRequest)resourceRequest, "groupId");
    List<ChatConfigure> chatConfigures = _chatConfigureLocalService.FindConfigureByGroupId(groupId);
    List<Role> roles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId(), new int[] { 1, 2 });
    JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    if (chatConfigures.size() > 0) {
      ChatConfigure chatConfigure = chatConfigures.get(0);
      jsonObject.put("isEnable", chatConfigure.getEnable());
      jsonObject.put("requestFeature", chatConfigure.getRequestFeature());
      jsonObject.put("headerColor", chatConfigure.getHeaderColor());
      jsonObject.put("chatRightColor", chatConfigure.getChatRightColor());
      jsonObject.put("chatLeftColor", chatConfigure.getChatLeftColor());
      jsonObject.put("headerTextColor", chatConfigure.getHeaderTextColor());
      jsonObject.put("contentTextColor", chatConfigure.getContentTextColor());
      jsonObject.put("backColor", chatConfigure.getBackColor());
      jsonObject.put("groupId", groupId);
      jsonObject.put("roles", roles);
      jsonObject.put("selectedRole", chatConfigure.getChatRoleId());
      jsonObject.put("fontFamily", chatConfigure.getFontFamily());
    } else {
      jsonObject.put("requestFeature", false);
      jsonObject.put("isEnable", false);
      jsonObject.put("headerColor", "");
      jsonObject.put("chatRightColor", "");
      jsonObject.put("chatLeftColor", "");
      jsonObject.put("headerTextColor", "");
      jsonObject.put("contentTextColor", "");
      jsonObject.put("backColor", "");
      jsonObject.put("groupId", groupId);
      jsonObject.put("roles", roles);
      jsonObject.put("selectedRole", "");
      jsonObject.put("fontFamily", "");
    } 
    try {
      resourceResponse.getWriter().println(jsonObject.toJSONString());
    } catch (IOException e) {
      _log.error(e.getMessage());
    } finally {
      resourceResponse.getWriter().flush();
      resourceResponse.getWriter().close();
    } 
  }
  
	@Reference
	private ChatConfigureLocalService _chatConfigureLocalService;
}
