package it.eng.rd.dymer.search;

import it.eng.rd.dymer.model.Dymer;
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

@Component(
        immediate = true,
        property = "indexer.class.name=it.eng.rd.dymer.model.Dymer",
        service = ModelDocumentContributor.class
)
public class DymerModelDocumentContributor
    implements ModelDocumentContributor<Dymer> {

    @Override
    public void contribute(Document document, Dymer dymer) {
        try {
            document.addDate(Field.MODIFIED_DATE, dymer.getModifiedDate());

            Locale defaultLocale = PortalUtil.getSiteDefaultLocale(
    dymer.getGroupId());

            String localizedTitle = LocalizationUtil.getLocalizedName(
    Field.TITLE, defaultLocale.toString());

            document.addText(localizedTitle, dymer.getName());
        } catch (PortalException pe) {
            if (_log.isWarnEnabled()) {
                _log.warn(
    "Unable to index dymer " + dymer.getDymerId(), pe);
            }
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(
    DymerModelDocumentContributor.class);

}