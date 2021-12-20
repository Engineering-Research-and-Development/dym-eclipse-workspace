package it.eng.rd.dymer.search;

import it.eng.rd.dymer.model.Dymer;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

public class DymerSearchRegistrar {
    @Activate
    protected void activate(BundleContext bundleContext) {

        _serviceRegistration = modelSearchRegistrarHelper.register(
            Dymer.class, bundleContext, modelSearchDefinition -> {
                modelSearchDefinition.setDefaultSelectedFieldNames(
                    Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
                    Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
                    Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID,
                    Field.TITLE, Field.UID);

                modelSearchDefinition.setModelIndexWriteContributor(
                    modelIndexWriterContributor);
                modelSearchDefinition.setModelSummaryContributor(
                    modelSummaryContributor);
            });
    }

    @Deactivate
    protected void deactivate() {

        _serviceRegistration.unregister();
    }
    
    @Reference(target = "(indexer.class.name=it.eng.rd.dymer.model.Dymer)")
    protected ModelIndexerWriterContributor<Dymer> modelIndexWriterContributor;

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    @Reference(target = "(indexer.class.name=it.eng.rd.dymer.model.Dymer)")
    protected ModelSummaryContributor modelSummaryContributor;

    private ServiceRegistration<?> _serviceRegistration;
}
