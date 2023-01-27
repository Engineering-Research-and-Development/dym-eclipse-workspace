package it.eng.rd.chat.web.action;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.Date;
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
				"mvc.command.name=/chatMarkAsRead"
		}, 
		service = {MVCResourceCommand.class}
	)
public class SetMarkAsReadMVCResourceCommand extends BaseMVCResourceCommand {
  private static Log _log = LogFactoryUtil.getLog(SetMarkAsReadMVCResourceCommand.class);
  
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    Long fromUserId = Long.valueOf(ParamUtil.getLong((PortletRequest)resourceRequest, "userId"));
    DynamicQuery query = ChatMessageLocalServiceUtil.dynamicQuery();
    query.add(RestrictionsFactoryUtil.eq("fromUser", fromUserId));
    query.add(RestrictionsFactoryUtil.eq("readed", Boolean.valueOf(false)));
    List<ChatMessage> chatMessages = ChatMessageLocalServiceUtil.dynamicQuery(query);
    for (ChatMessage chatMessage : chatMessages) {
      chatMessage.setReaded(true);
      chatMessage.setReadDate(new Date());
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
