package it.eng.rd.chat.web.message.indexer;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.chat.model.ChatMessage;
import it.eng.rd.chat.service.ChatMessageLocalServiceUtil;

@Component(immediate = true, service = {Indexer.class})
public class ChatMessageIndexer extends BaseIndexer<ChatMessage> {
  private static final Log _log = LogFactoryUtil.getLog(ChatMessageIndexer.class);
  
  public static final String CLASS_NAMES = ChatMessage.class.getName();
  
  public static final String PORTLET_ID = "it_eng_rd_chat_web_SocketPortlet";
  
  @Reference
  IndexWriterHelper indexWriterHelper;
  
  public ChatMessageIndexer() {
    setDefaultSelectedFieldNames(new String[] { 
          "companyId", "entryClassPK", "id", "groupId", "fromUser", "toUser", "sentDate", "readDate", "message", "readed", 
          "deleted", "fileName", "fileId" });
    setPermissionAware(false);
    setFilterSearch(false);
  }
  
  public String getClassName() {
    return CLASS_NAMES;
  }
  
  protected void doDelete(ChatMessage object) throws Exception {
    DocumentImpl documentImpl = new DocumentImpl();
    documentImpl.addUID("it_eng_rd_chat_web_SocketPortlet", object.getId());
    IndexWriterHelperUtil.deleteDocument(getSearchEngineId(), object.getCompanyId(), documentImpl.getUID(), true);
  }
  
  protected Document doGetDocument(ChatMessage object) throws Exception {
    Document document = getBaseModelDocument(CLASS_NAMES, (BaseModel)object);
    document.addUID("it_eng_rd_chat_web_SocketPortlet", object.getId());
    document.addKeyword("id", object.getId());
    document.addKeyword("companyId", object.getCompanyId());
    document.addKeyword("groupId", object.getGroupId());
    document.addKeyword("fromUser", object.getFromUser());
    document.addKeyword("toUser", object.getToUser());
    document.addDate("sentDate", object.getSentDate());
    document.addDate("readDate", object.getReadDate());
    document.addText("message", object.getMessage());
    document.addKeyword("readed", object.getReaded());
    document.addKeyword("deleted", object.getDeleted());
    document.addText("fileName", object.getFileName());
    document.addKeyword("fileId", object.getFileId());
    return document;
  }
  
  protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest, PortletResponse portletResponse) throws Exception {
    Summary summary = createSummary(document);
    summary.setMaxContentLength(200);
    return summary;
  }
  
  protected void doReindex(String className, long classPK) throws Exception {
    _log.info("Reindexing StoreInformation id " + classPK);
    ChatMessage chatMessage = ChatMessageLocalServiceUtil.getChatMessage(classPK);
    doReindex(chatMessage);
  }
  
  protected void doReindex(String[] ids) throws Exception {
    for (String companyId : ids) {
      long companyIdIndex = GetterUtil.getLong(companyId);
      _log.info("Reindex all Store objects " + companyIdIndex);
      List<ChatMessage> chatMessages = ChatMessageLocalServiceUtil.getChatMessages(-1, -1);
      if (chatMessages.isEmpty())
        return; 
      Collection<Document> documents = new ArrayList<>();
      for (ChatMessage chatMessage : chatMessages) {
        Document doc = getDocument(ChatMessageLocalServiceUtil.getChatMessage(chatMessage.getId()));
        documents.add(doc);
      } 
      this.indexWriterHelper.updateDocuments(getSearchEngineId(), companyIdIndex, documents, true);
    } 
  }
  
  protected void doReindex(ChatMessage object) throws Exception {
    Document document = getDocument(object);
    this.indexWriterHelper.updateDocument(getSearchEngineId(), object.getCompanyId(), document, isCommitImmediately());
  }
}
