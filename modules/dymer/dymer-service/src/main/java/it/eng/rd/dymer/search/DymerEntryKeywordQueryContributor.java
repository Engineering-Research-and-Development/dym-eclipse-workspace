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

	// It contributes clauses to the ongoing search query.
	// This is called at search time, and ensures that all the fields you indexed are also the ones searched. 
    @Override
    public void contribute(
        String keywords, BooleanQuery booleanQuery,
        KeywordQueryContributorHelper keywordQueryContributorHelper) {

        if (_log.isDebugEnabled())
        	_log.debug("contribute DymerEntryKeywordQueryContributor");
    	
        SearchContext searchContext =
        		keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchLocalizedTerm(
        		booleanQuery, searchContext, Field.TITLE, false);
        queryHelper.addSearchLocalizedTerm(
        		booleanQuery, searchContext, Field.CONTENT, false);
        queryHelper.addSearchLocalizedTerm(
        	    booleanQuery, searchContext, "index", false);
        
    }

    @Reference
    protected QueryHelper queryHelper;
    
    final Log _log = LogFactoryUtil.getLog(DymerEntryKeywordQueryContributor.class);

}





