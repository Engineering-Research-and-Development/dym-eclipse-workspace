package it.eng.rd.dymer.portlet.action;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import it.eng.rd.dymer.portlet.configuration.DymerViewerConfiguration;
import it.eng.rd.dymer.portlet.constants.DymerViewerPortletKeys;

/**
 * @author ENGRD
 */

@Component(
	configurationPid = "it.eng.rd.dymer.portlet.configuration.DymerViewerConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL, 
	immediate = true,
	property = "javax.portlet.name=" + DymerViewerPortletKeys.DYMERVIEWER,
	service = ConfigurationAction.class
)
public class DymerViewerConfigurationAction
	extends DefaultConfigurationAction {

	@Override
	public void include(
			PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		httpServletRequest.setAttribute(
			DymerViewerConfiguration.class.getName(),
			_dymerViewerConfiguration);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		
		String dymerIp = ParamUtil.getString(actionRequest, "dymerIp");
		String dviewtype = ParamUtil.getString(actionRequest, "dviewtype");
		String addModel = ParamUtil.getString(actionRequest, "addModel");
		String keyget = ParamUtil.getString(actionRequest, "keyget");
		String query = ParamUtil.getString(actionRequest, "query");
		String label = ParamUtil.getString(actionRequest, "label");
		String not_import = ParamUtil.getString(actionRequest, "not_import");
		if (not_import!=null) {
			not_import = not_import.trim();
		}
		
		String dymerTour = ParamUtil.getString(actionRequest, "dymerTour");
		String dymerFreeHTML = ParamUtil.getString(actionRequest, "dymerFreeHTML");
		String dymerFreeJSON = ParamUtil.getString(actionRequest, "dymerFreeJSON");
		 
//		renderer conditions		
		String autostartsearch = ParamUtil.getString(actionRequest, "autostartsearch");
		String showbread = ParamUtil.getString(actionRequest, "showbread");
		String showfilter = ParamUtil.getString(actionRequest, "showfilter");
		String expandedFilter = ParamUtil.getString(actionRequest, "expandedFilter");
		String placeHolderFilter = ParamUtil.getString(actionRequest, "placeHolderFilter");
		
//		search
		String dsearchtype = ParamUtil.getString(actionRequest, "dsearchtype");
		String keyurlget = ParamUtil.getString(actionRequest, "keyurlget");
		String filtermodel = ParamUtil.getString(actionRequest, "filtermodel");
		String basefilter = ParamUtil.getString(actionRequest, "basefilter");
		String customfilter = ParamUtil.getString(actionRequest, "customfilter");

//		Vertical Search
		String showVerticalfilter = ParamUtil.getString(actionRequest, "showVerticalfilter");
		String precustomfilter = ParamUtil.getString(actionRequest, "precustomfilter");
		String dymerSearch = ParamUtil.getString(actionRequest, "dymerSearch");
		String postcustomfilter = ParamUtil.getString(actionRequest, "postcustomfilter");
		
//		map
		String typemapdt = ParamUtil.getString(actionRequest, "typemapdt");
		String dataTable = ParamUtil.getString(actionRequest, "dataTable");
		String dmapstyle = ParamUtil.getString(actionRequest, "dmapstyle");
		String map_markers = ParamUtil.getString(actionRequest, "map_markers");
		String map_configuration = ParamUtil.getString(actionRequest, "map_configuration");
		
		setPreference(actionRequest, "dymerIp", dymerIp);
		setPreference(actionRequest, "dviewtype", dviewtype);
		setPreference(actionRequest, "addModel", addModel);
		setPreference(actionRequest, "keyget", keyget);
		setPreference(actionRequest, "query", query);
		setPreference(actionRequest, "label", label);
		if (_log.isDebugEnabled())
			_log.debug("excludes the following libraries: " + not_import);
		setPreference(actionRequest, "not_import", not_import);

//		Dymer tour		
		setPreference(actionRequest, "dymerTour", dymerTour);
		setPreference(actionRequest, "dymerFreeHTML", dymerFreeHTML);
		setPreference(actionRequest, "dymerFreeJSON", dymerFreeJSON);

//		renderer conditions
		setPreference(actionRequest, "autostartsearch", autostartsearch);
		setPreference(actionRequest, "showbread", showbread);
		setPreference(actionRequest, "showfilter", showfilter);
		setPreference(actionRequest, "expandedFilter", expandedFilter);
		setPreference(actionRequest, "placeHolderFilter", placeHolderFilter);
		
//		search
		setPreference(actionRequest, "dsearchtype", dsearchtype);
		setPreference(actionRequest, "keyurlget", keyurlget);
		setPreference(actionRequest, "filtermodel", filtermodel);
		setPreference(actionRequest, "basefilter", basefilter);
		setPreference(actionRequest, "customfilter", customfilter);
		
//		vertical search
		setPreference(actionRequest, "showVerticalfilter", showVerticalfilter);
		setPreference(actionRequest, "precustomfilter", precustomfilter);
		setPreference(actionRequest, "dymerSearch", dymerSearch);
		setPreference(actionRequest, "postcustomfilter", postcustomfilter);
//		map
		setPreference(actionRequest, "typemapdt", typemapdt);
		setPreference(actionRequest, "dataTable", dataTable);
		setPreference(actionRequest, "dmapstyle", dmapstyle);
		setPreference(actionRequest, "map_markers", map_markers);
		setPreference(actionRequest, "map_configuration", map_configuration);
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_dymerViewerConfiguration = ConfigurableUtil.createConfigurable(
			DymerViewerConfiguration.class, properties);
	}

	private static final Log _log = LogFactoryUtil.getLog(
			DymerViewerConfiguration.class);

	private volatile DymerViewerConfiguration _dymerViewerConfiguration;

}