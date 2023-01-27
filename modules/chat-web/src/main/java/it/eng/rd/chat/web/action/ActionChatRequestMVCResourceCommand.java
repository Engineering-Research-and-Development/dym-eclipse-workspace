package it.eng.rd.chat.web.action;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import it.eng.rd.chat.model.ChatRequest;
import it.eng.rd.chat.service.ChatRequestLocalServiceUtil;
import it.eng.rd.chat.web.common.WebsocketServiceImpl;

@Component(
	immediate = true, 
	property = {
			"javax.portlet.name=it_eng_rd_chat_web_SocketPortlet", 
			"mvc.command.name=/actionChatRequest"
	}, 
	service = {MVCResourceCommand.class}
)
public class ActionChatRequestMVCResourceCommand extends BaseMVCResourceCommand {
  private static Log _log = LogFactoryUtil.getLog(ActionChatRequestMVCResourceCommand.class);
  
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
    long userId = ParamUtil.getLong((PortletRequest)resourceRequest, "userId");
    boolean action = ParamUtil.getBoolean((PortletRequest)resourceRequest, "actionStatus");
    DynamicQuery query = ChatRequestLocalServiceUtil.dynamicQuery();
    query.add(RestrictionsFactoryUtil.eq("fromUserId", Long.valueOf(userId)));
    query.add(RestrictionsFactoryUtil.eq("toUserId", Long.valueOf(themeDisplay.getUserId())));
    List<ChatRequest> chatReuests = ChatRequestLocalServiceUtil.dynamicQuery(query);
    JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    if (chatReuests.size() > 0) {
      WebsocketServiceImpl websocketServiceImpl = new WebsocketServiceImpl();
      ChatRequest chatReuest = chatReuests.get(0);
      if (action) {
        chatReuest.setIsAccepted(true);
        websocketServiceImpl.requestAction(UserLocalServiceUtil.getUser(userId), themeDisplay.getUser(), true);
        jsonObject.put("actionStatus", "true");
      } else {
        chatReuest.setIsRejected(true);
        websocketServiceImpl.requestAction(UserLocalServiceUtil.getUser(userId), themeDisplay.getUser(), false);
        jsonObject.put("actionStatus", "false");
      } 
      chatReuest.setModifiedDate(new Date());
      ChatRequestLocalServiceUtil.updateChatRequest(chatReuest);
    } 
    try {
      resourceResponse.getWriter().println(jsonObject.toJSONString());
      if (_log.isDebugEnabled()) 
  		_log.debug("JSON: " + jsonObject.toJSONString());
    } catch (IOException e) {
    	if (_log.isDebugEnabled()) 
    		_log.debug("JSON: " + jsonObject.toJSONString());
    	 _log.error(e.getMessage());
    } catch (Exception e) {
    	 _log.error(e.getMessage());
    } finally {
      resourceResponse.getWriter().flush();
      resourceResponse.getWriter().close();
    } 
  }
}
