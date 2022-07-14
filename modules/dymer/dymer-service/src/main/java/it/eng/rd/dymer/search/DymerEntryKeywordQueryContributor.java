package it.eng.rd.dymer.search;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=it.eng.rd.dymer.model.DymerEntry",
        service = KeywordQueryContributor.class
)
public class DymerEntryKeywordQueryContributor implements KeywordQueryContributor {

    @Override
    public void contribute(
        String keywords, BooleanQuery booleanQuery,
        KeywordQueryContributorHelper keywordQueryContributorHelper) {

        SearchContext searchContext =
    keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchLocalizedTerm(
    booleanQuery, searchContext, Field.TITLE, false);
        queryHelper.addSearchLocalizedTerm(
    booleanQuery, searchContext, Field.CONTENT, false);
       /* queryHelper.addSearchLocalizedTerm(
        	    booleanQuery, searchContext, "type", false);*/
        
    }

    @Reference
    protected QueryHelper queryHelper;

}





