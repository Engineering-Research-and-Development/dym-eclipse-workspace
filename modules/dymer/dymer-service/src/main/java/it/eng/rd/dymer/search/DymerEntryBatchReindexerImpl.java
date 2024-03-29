package it.eng.rd.dymer.search;

import it.eng.rd.dymer.model.DymerEntry;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = DymerEntryBatchReindexer.class)
public class DymerEntryBatchReindexerImpl implements DymerEntryBatchReindexer {

    @Override
    public void reindex(long dymerId, long companyId) {
    	
        if (_log.isDebugEnabled())
        	_log.debug("reindex DymerEntryBatchReindexerImpl");
    	
        BatchIndexingActionable batchIndexingActionable =
    indexerWriter.getBatchIndexingActionable();

        batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
            Property dymerIdProperty = PropertyFactoryUtil.forName("dymerId");
            dynamicQuery.add(dymerIdProperty.eq(dymerId));
        });

        batchIndexingActionable.setCompanyId(companyId);

        batchIndexingActionable.setPerformActionMethod((DymerEntry entry) -> {
            Document document = indexerDocumentBuilder.getDocument(entry);
            batchIndexingActionable.addDocuments(document);
        });

        batchIndexingActionable.performActions();
        
    }

    @Reference(target = "(indexer.class.name=it.eng.rd.dymer.model.DymerEntry)")
    protected IndexerDocumentBuilder indexerDocumentBuilder;

    @Reference(target = "(indexer.class.name=it.eng.rd.dymer.model.DymerEntry)")
    protected IndexerWriter<DymerEntry> indexerWriter;
    
    final Log _log = LogFactoryUtil.getLog(DymerEntryBatchReindexerImpl.class);

}
