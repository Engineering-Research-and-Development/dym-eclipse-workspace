package it.eng.rd.dymer.search;

import it.eng.rd.dymer.model.Dymer;
import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.service.DymerLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=it.eng.rd.dymer.model.DymerEntry",
        service = ModelDocumentContributor.class
)
public class DymerEntryModelDocumentContributor
    implements ModelDocumentContributor<DymerEntry> {

    @Override
    public void contribute(Document document, DymerEntry entry) {
        try {
            Locale defaultLocale = PortalUtil.getSiteDefaultLocale(
    entry.getGroupId());

            document.addDate(Field.MODIFIED_DATE, entry.getModifiedDate());

            String localizedTitle = LocalizationUtil.getLocalizedName(
    Field.TITLE, defaultLocale.toString());
            String localizedContent = LocalizationUtil.getLocalizedName(
    Field.CONTENT, defaultLocale.toString());
           /* String localizedType = LocalizationUtil.getLocalizedName(
            	    "type", defaultLocale.toString());*/

            document.addText(localizedTitle, entry.getTitle());
            document.addText(localizedContent, entry.getExtContent());
           /* document.addText(localizedType, entry.getType());*/

            long dymerId = entry.getDymerId();

            Dymer dymer = _dymerLocalService.getDymer(
    dymerId);

            String dymerName = dymer.getName();

            String localizedGbName = LocalizationUtil.getLocalizedName(
    Field.NAME, defaultLocale.toString());

            document.addText(localizedGbName, dymerName);
        } catch (PortalException pe) {
            if (_log.isWarnEnabled()) {
                _log.warn("Unable to index entry " + entry.getEntryId(), pe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(
    DymerEntryModelDocumentContributor.class);

    @Reference
    private DymerLocalService _dymerLocalService;

}
