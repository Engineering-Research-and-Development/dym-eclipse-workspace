package it.eng.rd.chat.config.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.websocket.Session;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.chat.model.ChatConfigure;
import it.eng.rd.chat.service.ChatConfigureLocalService;
import it.eng.rd.chat.service.ChatConfigureLocalServiceUtil;
import it.eng.rd.chat.web.portlet.ChatWebPortlet;

@Component(immediate = true, property = {
		"javax.portlet.name=it_eng_rd_chat_config_ChatConfigPortlet", 
		"mvc.command.name=/saveConfiguration"
}, service = {MVCActionCommand.class})
public class SaveConfigurationMVCActionCommand extends BaseMVCActionCommand {
  protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
    ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
    boolean chatRequestFeature = ParamUtil.getBoolean((PortletRequest)actionRequest, "chat-request");
    boolean isEnable = ParamUtil.getBoolean((PortletRequest)actionRequest, "enable");
    String headerColor = ParamUtil.getString((PortletRequest)actionRequest, "header-color");
    String rightColor = ParamUtil.getString((PortletRequest)actionRequest, "chat-right-color");
    String leftColor = ParamUtil.getString((PortletRequest)actionRequest, "chat-left-color");
    String headerTextColor = ParamUtil.getString((PortletRequest)actionRequest, "header-text-color");
    String contentTextColor = ParamUtil.getString((PortletRequest)actionRequest, "content-text-color");
    String backColor = ParamUtil.getString((PortletRequest)actionRequest, "back-ground-color");
    String textFontFamily = ParamUtil.getString((PortletRequest)actionRequest, "text-change-position");
    String[] selectItems = ParamUtil.getStringValues((PortletRequest)actionRequest, "selectItems");
    long siteId = ParamUtil.getLong((PortletRequest)actionRequest, "site");
    if (Validator.isNull(Long.valueOf(siteId))) {
      SessionErrors.add((PortletRequest)actionRequest, "not-allow-group");
    } else {
      List<ChatConfigure> chatConfigures = _chatConfigureLocalService.FindConfigureByGroupId(siteId);
      if (chatConfigures.size() == 0) {
        long id = CounterLocalServiceUtil.increment();
        ChatConfigure chatConfigure = ChatConfigureLocalServiceUtil.createChatConfigure(id);
        chatConfigure.setGroupId(siteId);
        chatConfigure.setEnable(isEnable);
        chatConfigure.setRequestFeature(chatRequestFeature);
        chatConfigure.setHeaderColor(headerColor);
        chatConfigure.setChatRightColor(rightColor);
        chatConfigure.setChatLeftColor(leftColor);
        chatConfigure.setHeaderTextColor(headerTextColor);
        chatConfigure.setContentTextColor(contentTextColor);
        chatConfigure.setBackColor(backColor);
        chatConfigure.setCreateDate(new Date());
        chatConfigure.setChatRoleId(String.join(",", (CharSequence[])selectItems));
        chatConfigure.setFontFamily(textFontFamily);
        chatConfigure.setUserId(themeDisplay.getUserId());
        chatConfigure.setUserName(themeDisplay.getUser().getFullName());
        ChatConfigureLocalServiceUtil.addChatConfigure(chatConfigure);
      } else {
        ChatConfigure chatConfigure = chatConfigures.get(0);
        chatConfigure.setRequestFeature(chatRequestFeature);
        chatConfigure.setEnable(isEnable);
        chatConfigure.setHeaderColor(headerColor);
        chatConfigure.setChatRightColor(rightColor);
        chatConfigure.setChatLeftColor(leftColor);
        chatConfigure.setHeaderTextColor(headerTextColor);
        chatConfigure.setContentTextColor(contentTextColor);
        chatConfigure.setBackColor(backColor);
        chatConfigure.setModifiedDate(new Date());
        chatConfigure.setChatRoleId(String.join(",", (CharSequence[])selectItems));
        chatConfigure.setFontFamily(textFontFamily);
        chatConfigure.setUserId(themeDisplay.getUserId());
        chatConfigure.setUserName(themeDisplay.getUser().getFullName());
        ChatConfigureLocalServiceUtil.updateChatConfigure(chatConfigure);
      } 
      Hashtable<Long, Session> connection = ChatWebPortlet.getConnections();
      for (Long userId : connection.keySet()) {
        try {
          JSONObject obj = JSONFactoryUtil.createJSONObject();
          obj.put("clearStorage", "");
          Session session = connection.get(userId);
          if (session.isOpen())
            session.getBasicRemote().sendText(obj.toJSONString()); 
        } catch (IOException e) { 
        	_log.error(e.getMessage());
        } catch (Exception e1) {
        	_log.error(e1.getMessage());
        }
      } 
    } 
  }
  
  private static final Log _log = LogFactoryUtil.getLog(SaveConfigurationMVCActionCommand.class);
  
  @Reference
  private ChatConfigureLocalService _chatConfigureLocalService;
}
