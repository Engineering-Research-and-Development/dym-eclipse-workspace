package it.eng.rd.chat.web.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import java.io.IOException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.web.common.WebsocketServiceImpl;

@Component(
		immediate = true, 
		property = {
				"javax.portlet.name=it_eng_rd_chat_web_SocketPortlet", 
				"mvc.command.name=/userTyping"
		}, service = {MVCResourceCommand.class}
	)
public class UserTypingMVCResourceCommand extends BaseMVCResourceCommand {
  private static Log _log = LogFactoryUtil.getLog(UserTypingMVCResourceCommand.class);
  
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
    long userId = ParamUtil.getLong((PortletRequest)resourceRequest, "userId");
    WebsocketServiceImpl websocketServiceImpl = new WebsocketServiceImpl();
    websocketServiceImpl.typingMessage(UserLocalServiceUtil.getUser(userId), themeDisplay.getUser());
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
