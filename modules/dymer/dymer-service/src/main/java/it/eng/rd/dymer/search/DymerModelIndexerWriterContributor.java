package it.eng.rd.dymer.search;

import it.eng.rd.dymer.model.Dymer;
import it.eng.rd.dymer.service.DymerLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=it.eng.rd.dymer.model.Dymer",
        service = ModelIndexerWriterContributor.class
)
public class DymerModelIndexerWriterContributor
    implements ModelIndexerWriterContributor<Dymer> {

    @Override
    public void customize(
        BatchIndexingActionable batchIndexingActionable,
        ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod((Dymer dymer) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(
    dymer);

            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
    dymerLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(Dymer dymer) {
        return dymer.getCompanyId();
    }

    @Override
    public void modelIndexed(Dymer dymer) {
        dymerEntryBatchReindexer.reindex(
    dymer.getDymerId(), dymer.getCompanyId());
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
    dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected DymerEntryBatchReindexer dymerEntryBatchReindexer;

    @Reference
    protected DymerLocalService dymerLocalService;

}