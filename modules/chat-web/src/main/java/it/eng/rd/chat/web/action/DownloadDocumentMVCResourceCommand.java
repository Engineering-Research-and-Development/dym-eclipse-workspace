package it.eng.rd.chat.web.action;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, 
	property = {
			"javax.portlet.name=it_eng_rd_chat_web_SocketPortlet", 
			"mvc.command.name=/downloadFile"}, 
	service = {MVCResourceCommand.class}
)
public class DownloadDocumentMVCResourceCommand extends BaseMVCResourceCommand {
  protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    Long fileId = Long.valueOf(ParamUtil.getLong((PortletRequest)resourceRequest, "fileId"));
    FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileId.longValue());
    String[] originalFileName = fileEntry.getFileName().split("\\.");
    StringBuilder fileName = new StringBuilder();
    fileName.append(originalFileName[0].subSequence(0, originalFileName[0].length() - 4));
    fileName.append(".");
    fileName.append(originalFileName[1]);
    try {
      PortletResponseUtil.sendFile((PortletRequest)resourceRequest, (MimeResponse)resourceResponse, fileName
          .toString(), fileEntry.getContentStream(), 0, fileEntry
          .getMimeType(), "attachment");
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
