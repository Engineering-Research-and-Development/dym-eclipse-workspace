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
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.web.util.ChatServiceUtil;

@Component(
		immediate = true, 
		property = {
				"javax.portlet.name=it_eng_rd_chat_web_SocketPortlet", 
				"mvc.command.name=/getUnreadMessageCount"
		}, service = {MVCResourceCommand.class}
	)
public class GetUnreadMessageCountMVCResourceCommand extends BaseMVCResourceCommand {
  private static Log _log = LogFactoryUtil.getLog(GetUnreadMessageCountMVCResourceCommand.class);
  
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
    Long fromUserId = Long.valueOf(ParamUtil.getLong((PortletRequest)resourceRequest, "fromUserId"));
    int unreadMessageCount = ChatServiceUtil.getUnreadMessageCount(fromUserId, Long.valueOf(themeDisplay.getUserId()));
    JSONObject json = JSONFactoryUtil.createJSONObject();
    json.put("fromUserId", fromUserId);
    json.put("unreadCount", unreadMessageCount);
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
