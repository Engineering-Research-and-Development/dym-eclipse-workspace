package it.eng.rd.chat.web.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.web.message.indexer.ChatMessageObject;
import it.eng.rd.chat.web.util.ChatServiceUtil;

@Component(
		immediate = true, 
		property = {
				"javax.portlet.name=it_eng_rd_chat_web_SocketPortlet", 
				"mvc.command.name=/getMessages"}, 
		service = {MVCResourceCommand.class}
)
public class GetMessagesMVCResourceCommand extends BaseMVCResourceCommand {
  private static Log _log = LogFactoryUtil.getLog(GetMessagesMVCResourceCommand.class);
  
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
    Long userId = Long.valueOf(ParamUtil.getLong((PortletRequest)resourceRequest, "userId"));
    int totalRecords = ParamUtil.getInteger((PortletRequest)resourceRequest, "totalRecord");
    int count = ChatServiceUtil.getUserChatCount(userId, Long.valueOf(themeDisplay.getUserId()));
    count -= totalRecords;
    List<ChatMessageObject> chatHistory = ChatServiceUtil.getChat(resourceRequest, userId, Long.valueOf(themeDisplay.getUserId()), totalRecords);
    Comparator<ChatMessageObject> compareById = (o1, o2) -> Long.compare(o1.getId().longValue(), o2.getId().longValue());
    chatHistory.sort(compareById);
    JSONObject json = JSONFactoryUtil.createJSONObject();
    json.put("toUser", userId);
    json.put("fromUser", themeDisplay.getUserId());
    json.put("chat", chatHistory);
    json.put("count", (count < 0) ? 0 : count);
    json.put("totalRecords", totalRecords);
    try {
      resourceResponse.getWriter().println(json.toJSONString());
      if (_log.isDebugEnabled()) 
  		_log.debug("JSON: " + json.toJSONString());
    } catch (IOException e) {
    	_log.error(e.getMessage());
    } catch (Exception e) {
    	_log.error(e.getMessage());;
    } finally {
      resourceResponse.getWriter().flush();
      resourceResponse.getWriter().close();
    } 
  }
}
