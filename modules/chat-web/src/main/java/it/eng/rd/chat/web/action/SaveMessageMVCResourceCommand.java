package it.eng.rd.chat.web.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.model.ChatMessage;
import it.eng.rd.chat.service.ChatMessageLocalServiceUtil;
import it.eng.rd.chat.web.common.WebsocketServiceImpl;
import it.eng.rd.chat.web.message.indexer.MessageIndexer;
import it.eng.rd.chat.web.util.ChatServiceUtil;
import it.eng.rd.chat.web.util.FileUploadUtil;

@Component(
		immediate = true, 
		property = {
				"javax.portlet.name=it_eng_rd_chat_web_SocketPortlet", 
				"mvc.command.name=/saveMessage"
		}, service = {MVCResourceCommand.class}
)
public class SaveMessageMVCResourceCommand extends BaseMVCResourceCommand {
  private static Log _log = LogFactoryUtil.getLog(SaveMessageMVCResourceCommand.class);
  
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
    String textMessage = ParamUtil.getString((PortletRequest)resourceRequest, "text");
    Long toUserId = Long.valueOf(ParamUtil.getLong((PortletRequest)resourceRequest, "toUser"));
    Map<String, Object> fileMap = FileUploadUtil.fileUpload(themeDisplay, resourceRequest);
    Long messageId = Long.valueOf(CounterLocalServiceUtil.increment());
    ChatMessage chatMessage = ChatMessageLocalServiceUtil.createChatMessage(messageId.longValue());
    chatMessage.setGroupId(themeDisplay.getUser().getGroupId());
    chatMessage.setToUser(toUserId.longValue());
    chatMessage.setFromUser(themeDisplay.getUserId());
    chatMessage.setMessage(textMessage);
    chatMessage.setSentDate(new Date());
    if (fileMap.containsKey("fileName")) {
      chatMessage.setFileName(fileMap.get("fileName").toString());
      chatMessage.setFileId(Long.parseLong(fileMap.get("fileId").toString()));
    } 
    ChatMessageLocalServiceUtil.addChatMessage(chatMessage);
    MessageIndexer.reindex(ChatMessage.class.getName(), chatMessage);
    WebsocketServiceImpl websocketServiceImpl = new WebsocketServiceImpl();
    websocketServiceImpl.sendChatMessage(UserLocalServiceUtil.getUser(toUserId.longValue()), themeDisplay.getUser(), Long.valueOf(chatMessage.getId()));
    List<ChatMessage> cMessage = ChatServiceUtil.getRecentMessageByFromUser(Long.valueOf(themeDisplay.getUserId()));
    JSONObject json = JSONFactoryUtil.createJSONObject();
    json.put("toUser", toUserId);
    json.put("fromUser", themeDisplay.getUserId());
    json.put("chat", cMessage);
    try {
      resourceResponse.getWriter().println(json.toJSONString());
      if (_log.isDebugEnabled()) 
    		_log.debug("JSON: " + json.toJSONString());
    } catch (IOException e) {
    	_log.error(e.getMessage());
    } catch (Exception e) {
    	_log.error(e.getMessage());
    } finally {
      resourceResponse.getWriter().flush();
      resourceResponse.getWriter().close();
    } 
  }
}
