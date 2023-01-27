package it.eng.rd.chat.web.message.indexer;

import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;

public class MessageIndexer {
  public static void reindex(String className, Object object) throws SearchException {
    Indexer indexer = IndexerRegistryUtil.getIndexer(className);
    try {
      indexer.reindex(object);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
