package it.eng.rd.dymer.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author ENGRD
 */

@Meta.OCD(
	id = "it.eng.rd.dymer.portlet.configuration.DymerViewerConfiguration"
)
public interface DymerViewerConfiguration {

	@Meta.AD(deflt = "", required = false)
	public String dymerIp();
	
	@Meta.AD(deflt = "", required = false)
	public String dviewtype();
	
	@Meta.AD(deflt = "", required = false)
	public String addModel();
	
	@Meta.AD(deflt = "", required = false)
	public String keyget();
	
	@Meta.AD(deflt = "", required = false)
	public String query();
	
	@Meta.AD(deflt = "", required = false)
	public String label();
 
	@Meta.AD(deflt = "", required = false)
	public String dymerQoptions();
	
	@Meta.AD(deflt = "", required = false)
	public String autostartsearch();
	
	@Meta.AD(deflt = "", required = false)
	public String showtour();
	
	@Meta.AD(deflt = "", required = false)
	public String showbread();
	
	@Meta.AD(deflt = "", required = false)
	public String not_import();
	
	@Meta.AD(deflt = "", required = false)
	public String dymerTour();
	
	@Meta.AD(deflt = "", required = false)
	public String dymerTourText();
	
	@Meta.AD(deflt = "", required = false)
	public String dymerFreeJSON();
	
	@Meta.AD(deflt = "", required = false)
	public String dymerFreeHTML();
	
//	searchbar
	@Meta.AD(deflt = "", required = false)
	public String showfilter();

	@Meta.AD(deflt = "", required = false)
	public String expandedFilter();

	@Meta.AD(deflt = "", required = false)
	public String placeHolderFilter();
	
	@Meta.AD(deflt = "", required = false)
	public String dsearchtype();
	
	@Meta.AD(deflt = "", required = false)
	public String keyurlget();
	
	@Meta.AD(deflt = "", required = false)
	public String filtermodel();
	
	@Meta.AD(deflt = "", required = false)
	public String basefilter();
	
	@Meta.AD(deflt = "", required = false)
	public String customfilter();
	
//vertical search
	@Meta.AD(deflt = "", required = false)
	public String showVerticalfilter();
	
	@Meta.AD(deflt = "", required = false)
	public String dymerSearch();
	
	@Meta.AD(deflt = "", required = false)
	public String precustomfilter();
	
	@Meta.AD(deflt = "", required = false)
	public String postcustomfilter();
	
//	map
	@Meta.AD(deflt = "", required = false)
	public String typemapdt();

	@Meta.AD(deflt = "", required = false)
	public String dataTable();
	
	@Meta.AD(deflt = "", required = false)
	public String dmapstyle();
	
	@Meta.AD(deflt = "", required = false)
	public String map_markers();
	
	@Meta.AD(required = false)
	public String map_configuration();
	
	@Meta.AD(deflt = "", required = false)
	public String dymerHeaderHtml();
	
	@Meta.AD(deflt = "", required = false)
	public String dymerFooterHtml();
}