package it.eng.rd.dymer.search;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "indexer.class.name=it.eng.rd.dymer.model.DymerEntry",
        service = ModelSummaryContributor.class
)
public class DymerEntryModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(
		Document document, Locale locale, String snippet) {

		String languageId = LocaleUtil.toLanguageId(locale);

		return _createSummary(
			document,
			LocalizationUtil.getLocalizedName(Field.CONTENT, languageId),
			LocalizationUtil.getLocalizedName(Field.TITLE, languageId));
	}

	private Summary _createSummary(
		Document document, String contentField, String titleField) {

		String prefix = Field.SNIPPET + StringPool.UNDERLINE;

		Summary summary = new Summary(
			document.get(prefix + titleField, titleField),
			document.get(prefix + contentField, contentField));
		
		if (_log.isDebugEnabled()) {
			_log.debug("titleField: "+titleField);
			_log.debug("contentField: "+contentField);
			_log.debug("summary.getTitle: "+summary.getTitle());
			_log.debug("summary.getContent: "+summary.getContent());
		}

		summary.setMaxContentLength(200);

		return summary;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(DymerEntryModelSummaryContributor.class);
}
