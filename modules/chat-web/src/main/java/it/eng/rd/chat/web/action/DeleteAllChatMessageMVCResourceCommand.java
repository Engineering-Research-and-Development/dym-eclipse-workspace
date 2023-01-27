package it.eng.rd.chat.web.action;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.model.ChatMessage;
import it.eng.rd.chat.service.ChatMessageLocalServiceUtil;
import it.eng.rd.chat.web.message.indexer.MessageIndexer;

@Component(
		immediate = true, 
		property = {
				"javax.portlet.name=it_eng_rd_chat_web_SocketPortlet", 
				"mvc.command.name=/deleteAllMessages"}, 
		service = {MVCResourceCommand.class}
	)
public class DeleteAllChatMessageMVCResourceCommand extends BaseMVCResourceCommand {
  private static Log _log = LogFactoryUtil.getLog(DeleteAllChatMessageMVCResourceCommand.class);
  
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
    long userId = ParamUtil.getLong((PortletRequest)resourceRequest, "userId");
    DynamicQuery query = ChatMessageLocalServiceUtil.dynamicQuery();
    query.add(RestrictionsFactoryUtil.eq("fromUser", Long.valueOf(themeDisplay.getUserId())));
    query.add(RestrictionsFactoryUtil.eq("toUser", Long.valueOf(userId)));
    List<ChatMessage> chatMessages = ChatMessageLocalServiceUtil.dynamicQuery(query);
    for (ChatMessage chatMessage : chatMessages) {
      chatMessage.setDeleted(true);
      ChatMessageLocalServiceUtil.updateChatMessage(chatMessage);
      MessageIndexer.reindex(ChatMessage.class.getName(), chatMessage);
    } 
    try {
      resourceResponse.getWriter().println("");
    } catch (IOException e) {
      _log.error(e.getMessage());
    } finally {
      resourceResponse.getWriter().flush();
      resourceResponse.getWriter().close();
    } 
  }
}
