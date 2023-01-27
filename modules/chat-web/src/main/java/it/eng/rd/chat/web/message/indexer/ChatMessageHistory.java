package it.eng.rd.chat.web.message.indexer;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcher;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.QueryTerm;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchEngine;
import com.liferay.portal.kernel.search.SearchEngineHelperUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.search.generic.QueryTermImpl;
import com.liferay.portal.kernel.search.generic.TermQueryImpl;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;

import it.eng.rd.chat.model.ChatMessage;

public class ChatMessageHistory {
  private static Log _log = LogFactoryUtil.getLog(ChatMessageHistory.class);
  
  public static List<ChatMessageObject> getHistory(ResourceRequest resourceRequest, Long toUserId, Long fromUserId, int count) {
    BooleanQueryImpl booleanQueryImpl1 = new BooleanQueryImpl();
    BooleanQueryImpl booleanQueryImpl2 = new BooleanQueryImpl();
    BooleanQueryImpl booleanQueryImpl3 = new BooleanQueryImpl();
    List<ChatMessageObject> chatMessageObjects = new ArrayList<>();
    try {
      addExactRequiredTerm((BooleanQuery)booleanQueryImpl1, "entryClassName", ChatMessage.class.getName());
      addExactRequiredNotTerm((BooleanQuery)booleanQueryImpl1, "deleted", "true");
      addRequiredTerm((BooleanQuery)booleanQueryImpl2, "fromUser", String.valueOf(fromUserId));
      addRequiredTerm((BooleanQuery)booleanQueryImpl2, "fromUser", String.valueOf(toUserId));
      addRequiredTerm((BooleanQuery)booleanQueryImpl3, "toUser", String.valueOf(fromUserId));
      addRequiredTerm((BooleanQuery)booleanQueryImpl3, "toUser", String.valueOf(toUserId));
      booleanQueryImpl1.add((Query)booleanQueryImpl2, BooleanClauseOccur.MUST);
      booleanQueryImpl1.add((Query)booleanQueryImpl3, BooleanClauseOccur.MUST);
      HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest((PortletRequest)resourceRequest));
      SearchContext searchContext = SearchContextFactory.getInstance(httpReq);
      Sort[] sorts = new Sort[2];
      sorts[0] = SortFactoryUtil.create("sentDate_sortable", 3, true);
      searchContext.setSorts(sorts);
      searchContext.setStart(0);
      searchContext.setEnd(count);
      SearchEngine searchEngine = SearchEngineHelperUtil.getSearchEngine(searchContext.getSearchEngineId());
      IndexSearcher indexSearcher = searchEngine.getIndexSearcher();
      Hits hits = indexSearcher.search(searchContext, (Query)booleanQueryImpl1);
      ChatMessageObject chatMessageObject = null;
      DateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm");
      for (Document doc : hits.getDocs()) {
        chatMessageObject = new ChatMessageObject();
        chatMessageObject.setId(Long.valueOf(Long.parseLong(doc.get("entryClassPK"))));
        chatMessageObject.setGroupId(doc.get("groupId"));
        chatMessageObject.setCompanyId(doc.get("companyId"));
        chatMessageObject.setFromUser(doc.get("fromUser"));
        chatMessageObject.setToUser(doc.get("toUser"));
        Calendar sentDateCalendar = Calendar.getInstance();
        sentDateCalendar.setTimeInMillis(Long.parseLong(doc.get("sentDate_sortable")));
        chatMessageObject.setSentDate(simpleDateFormat.format(sentDateCalendar.getTime()));
        if (Validator.isNotNull(doc.get("readDate_sortable"))) {
          Calendar readDateCalendar = Calendar.getInstance();
          readDateCalendar.setTimeInMillis(Long.parseLong(doc.get("readDate_sortable")));
          chatMessageObject.setReadDate(simpleDateFormat.format(readDateCalendar.getTime()));
        } 
        chatMessageObject.setMessage(doc.get("message"));
        chatMessageObject.setReaded(Boolean.parseBoolean(doc.get("readed")));
        chatMessageObject.setDeleted(Boolean.parseBoolean(doc.get("deleted")));
        chatMessageObject.setFileName(doc.get("fileName"));
        chatMessageObject.setFileId(Long.parseLong(doc.get("fileId")));
        chatMessageObjects.add(chatMessageObject);
      } 
    } catch (Exception e) {
      _log.error(e.getMessage());
    } 
    return chatMessageObjects;
  }
  
  private static void addExactRequiredTerm(BooleanQuery query, String field, String value) throws ParseException {
    query.addTerm(field, value, true);
    TermQueryImpl termQuery = new TermQueryImpl((QueryTerm)new QueryTermImpl(field, value));
    query.add((Query)termQuery, BooleanClauseOccur.MUST);
  }
  
  private static void addExactRequiredNotTerm(BooleanQuery query, String field, String value) throws ParseException {
    TermQueryImpl termQuery = new TermQueryImpl((QueryTerm)new QueryTermImpl(field, value));
    query.add((Query)termQuery, BooleanClauseOccur.MUST_NOT);
  }
  
  private static void addRequiredTerm(BooleanQuery query, String field, String value) throws ParseException {
    query.addTerm(field, value, true);
    TermQueryImpl termQuery = new TermQueryImpl((QueryTerm)new QueryTermImpl(field, value));
    query.add((Query)termQuery, BooleanClauseOccur.SHOULD);
  }
}
