package it.eng.rd.chat.config.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.KeyValuePair;
import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {
		"javax.portlet.name=it_eng_rd_chat_config_ChatConfigPortlet", 
		"mvc.command.name=/"
}, service = {MVCRenderCommand.class})
public class ViewMVCRenderCommand implements MVCRenderCommand {
  private static Log _log = LogFactoryUtil.getLog(ViewMVCRenderCommand.class);
  
  public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
    ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
    List<Group> groups = new ArrayList<>();
    List<KeyValuePair> leftList = new ArrayList<>();
    List<KeyValuePair> rightList = new ArrayList<>();
    try {
      groups = GroupLocalServiceUtil.getUserSitesGroups(themeDisplay.getUserId());
    } catch (PortalException e) {
      _log.error(e.getMessage());
    } 
    renderRequest.setAttribute("groups", groups);
    renderRequest.setAttribute("leftList", leftList);
    renderRequest.setAttribute("rightList", rightList);
    return "/view.jsp";
  }
}


