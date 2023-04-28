package it.eng.rd.dymer.search;

import it.eng.rd.dymer.model.DymerEntry;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class DymerEntrySearchRegistrar {

//	SearchRegistrars use the search framework’s registry to define certain things
//	about your model entity’s ModelSearchDefinition: which fields are used 
//	by default to retrieve documents from the search engine, and which optional 
//	search services are registered for your entity. 
//	Registration occurs as soon as the Component is activated (during portal startup).
	
    @Activate
    protected void activate(BundleContext bundleContext) {
    	if (_log.isDebugEnabled())
    		_log.debug("activate DymerEntrySearchRegistrar");
    	
        _serviceRegistration = modelSearchRegistrarHelper.register(
            DymerEntry.class, bundleContext, modelSearchDefinition -> {
                modelSearchDefinition.setDefaultSelectedFieldNames(
                    Field.COMPANY_ID, Field.ENTRY_CLASS_NAME,
                    Field.ENTRY_CLASS_PK, Field.UID, 
                    Field.SCOPE_GROUP_ID, Field.GROUP_ID);

                modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
                    Field.TITLE, Field.CONTENT, "index");

                modelSearchDefinition.setModelIndexWriteContributor(
                    modelIndexWriterContributor);
                modelSearchDefinition.setModelSummaryContributor(
                    modelSummaryContributor);
                
                modelSearchDefinition.setSelectAllLocales(true);

            });
    }

    @Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference(target = "(indexer.class.name=it.eng.rd.dymer.model.DymerEntry)")
    protected ModelIndexerWriterContributor<DymerEntry> modelIndexWriterContributor;

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    @Reference(target = "(indexer.class.name=it.eng.rd.dymer.model.DymerEntry)")
    protected ModelSummaryContributor modelSummaryContributor;

    private ServiceRegistration<?> _serviceRegistration;
    
    private static final Log _log = LogFactoryUtil.getLog(
    		DymerEntrySearchRegistrar.class);
}