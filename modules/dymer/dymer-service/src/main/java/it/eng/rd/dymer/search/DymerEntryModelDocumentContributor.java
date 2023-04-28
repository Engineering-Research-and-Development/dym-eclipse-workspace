package it.eng.rd.dymer.search;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.eng.rd.dymer.model.Dymer;
import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.service.DymerLocalService;

@Component(
        immediate = true,
        property = "indexer.class.name=it.eng.rd.dymer.model.DymerEntry",
        service = ModelDocumentContributor.class
)
public class DymerEntryModelDocumentContributor
    implements ModelDocumentContributor<DymerEntry> {
	
//	It specifies which database fields are indexed in the model entity’s search 
//	engine documents
    
	@Override
    public void contribute(Document document, DymerEntry entry) {
		if (_log.isDebugEnabled())
        	_log.debug("contribute DymerEntryModelDocumentContributor");
		
		try {
			String extContent = HtmlUtil.extractText(entry.getExtContent());
	
			document.addText(Field.TITLE, entry.getTitle());
			document.addText(Field.CONTENT, extContent);
			document.addText(Field.TYPE, entry.getType());
	        
	        long dymerId = entry.getDymerId();
	        Dymer dymer = _dymerLocalService.getDymer(dymerId);
	        String dymerName = dymer.getName();
	        document.addText("dymerName", dymerName);
			
			for (Locale locale :
					LanguageUtil.getAvailableLocales(entry.getGroupId())) {
	
				String languageId = LocaleUtil.toLanguageId(locale);
	
				document.addText(
					LocalizationUtil.getLocalizedName(Field.TITLE, languageId),
					entry.getTitle());
				document.addText(
						LocalizationUtil.getLocalizedName(Field.CONTENT, languageId),
						extContent);
				
		        if (_log.isDebugEnabled())
		        	_log.debug("title_languageId: "+LocalizationUtil.getLocalizedName(Field.TITLE, languageId));
				
			}
		} catch (PortalException e) {
			if (_log.isWarnEnabled()) {
                _log.warn("Unable to index entry " + entry.getEntryId(), e);
            }
		}
    }

    @Reference
    private DymerLocalService _dymerLocalService;
    
    private static final Log _log = LogFactoryUtil.getLog(
    	    DymerEntryModelDocumentContributor.class);

}
