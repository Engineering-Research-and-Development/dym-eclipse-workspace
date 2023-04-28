package it.eng.rd.dymer.search;

import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.service.DymerEntryLocalService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=it.eng.rd.dymer.model.DymerEntry",
        service = ModelIndexerWriterContributor.class
)
public class DymerEntryModelIndexerWriterContributor
    implements ModelIndexerWriterContributor<DymerEntry> {

//	Configure the re-indexing and batch re-indexing behavior for the model entity. 
//	This class s method is called 
//	when a re-index is triggered from the Search administrative application found 
//	in Control Panel → Configuration → Search.
	
    @Override
    public void customize(
        BatchIndexingActionable batchIndexingActionable,
        ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
    	if (_log.isDebugEnabled())
    		_log.debug("customize DymerEntryModelIndexerWriterContributor");
    	
        batchIndexingActionable.setPerformActionMethod((DymerEntry entry) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(entry);
            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
    dymerEntryLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(DymerEntry entry) {
        return entry.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
    dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected DymerEntryLocalService dymerEntryLocalService;
    
    private static final Log _log = LogFactoryUtil.getLog(DymerEntryModelIndexerWriterContributor.class);

}
