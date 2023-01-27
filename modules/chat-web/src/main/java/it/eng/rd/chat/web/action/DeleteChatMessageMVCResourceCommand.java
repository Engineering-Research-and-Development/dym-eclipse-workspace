package it.eng.rd.chat.web.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

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
				"mvc.command.name=/deleteMessage"
		}, 
		service = {MVCResourceCommand.class}
	)
public class DeleteChatMessageMVCResourceCommand extends BaseMVCResourceCommand {
  private static Log _log = LogFactoryUtil.getLog(DeleteChatMessageMVCResourceCommand.class);
  
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    long messageId = ParamUtil.getLong((PortletRequest)resourceRequest, "id");
    ChatMessage chatMessage = ChatMessageLocalServiceUtil.getChatMessage(messageId);
    chatMessage.setDeleted(true);
    ChatMessageLocalServiceUtil.updateChatMessage(chatMessage);
    MessageIndexer.reindex(ChatMessage.class.getName(), chatMessage);
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
