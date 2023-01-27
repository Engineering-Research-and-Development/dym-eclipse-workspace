package it.eng.rd.chat.web.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.model.ChatMessage;
import it.eng.rd.chat.model.ChatRequest;
import it.eng.rd.chat.service.ChatMessageLocalServiceUtil;
import it.eng.rd.chat.service.ChatRequestLocalServiceUtil;
import it.eng.rd.chat.web.common.WebsocketServiceImpl;

@Component(
		immediate = true, 
		property = {
				"javax.portlet.name=it_eng_rd_chat_web_SocketPortlet", 
				"mvc.command.name=/sendChatRequest"}, 
		service = {MVCResourceCommand.class}
	)
public class SendChatRequestMVCResourceCommand extends BaseMVCResourceCommand {
  private static Log _log = LogFactoryUtil.getLog(SendChatRequestMVCResourceCommand.class);
  
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
//  long userId = ParamUtil.getLong((PortletRequest)resourceRequest, "userId");
    
    UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
	String userIdTxt = uploadRequest.getParameter("userId");
    long userId = Long.parseLong(userIdTxt);
    
    if (_log.isDebugEnabled()) {
    	_log.debug("userIdTxt: " + userIdTxt);
        _log.debug("userId: " + userId);
        _log.debug("current userId: " + themeDisplay.getUserId());
    }
   
    if (userId != 0) {
    	DynamicQuery query = ChatRequestLocalServiceUtil.dynamicQuery();
	    query.add(RestrictionsFactoryUtil.eq("toUserId", Long.valueOf(userId)));
	    query.add(RestrictionsFactoryUtil.eq("fromUserId", Long.valueOf(themeDisplay.getUserId())));
	    List<ChatRequest> chatRequests = ChatRequestLocalServiceUtil.dynamicQuery(query);
	    if (chatRequests.size() > 0) {
	      ChatRequest chatRequest = chatRequests.get(0);
	      chatRequest.setIsAccepted(false);
	      chatRequest.setIsRejected(false);
	      chatRequest.setModifiedDate(new Date());
	      ChatRequestLocalServiceUtil.updateChatRequest(chatRequest);
	      Long chatId = Long.valueOf(CounterLocalServiceUtil.increment());
	      ChatMessage chatMessage = ChatMessageLocalServiceUtil.createChatMessage(chatId.longValue());
	      chatMessage.setGroupId(themeDisplay.getUser().getGroupId());
	      chatMessage.setToUser(userId);
	      chatMessage.setFromUser(themeDisplay.getUserId());
	      chatMessage.setMessage("REQUEST");
	      chatMessage.setDeleted(true);
	      chatMessage.setSentDate(new Date());
	      ChatMessageLocalServiceUtil.addChatMessage(chatMessage);
	    } else {
	      long chatRequestId = CounterLocalServiceUtil.increment();
	      ChatRequest chatRequest = ChatRequestLocalServiceUtil.createChatRequest(chatRequestId);
	      chatRequest.setFromUserId(themeDisplay.getUserId());
	      chatRequest.setToUserId(userId);
	      chatRequest.setIsAccepted(false);
	      chatRequest.setIsRejected(false);
	      chatRequest.setCreateDate(new Date());
	      ChatRequestLocalServiceUtil.addChatRequest(chatRequest);
	      Long chatId = Long.valueOf(CounterLocalServiceUtil.increment());
	      ChatMessage chatMessage = ChatMessageLocalServiceUtil.createChatMessage(chatId.longValue());
	      chatMessage.setGroupId(themeDisplay.getUser().getGroupId());
	      chatMessage.setToUser(userId);
	      chatMessage.setFromUser(themeDisplay.getUserId());
	      chatMessage.setMessage("REQUEST");
	      chatMessage.setDeleted(true);
	      chatMessage.setSentDate(new Date());
	      ChatMessageLocalServiceUtil.addChatMessage(chatMessage);
	    } 
	    WebsocketServiceImpl websocketServiceImpl = new WebsocketServiceImpl();
	    websocketServiceImpl.sendRequest(UserLocalServiceUtil.getUser(userId), themeDisplay.getUser());
	    try {
	      resourceResponse.getWriter().println("");
	    } catch (IOException e) {
	      _log.error(e.getMessage());
	    } finally {
	      resourceResponse.getWriter().flush();
	      resourceResponse.getWriter().close();
	    } 
     } else {
    	 _log.error("sendChatRequest method: userId = 0");
     }
  }
}
