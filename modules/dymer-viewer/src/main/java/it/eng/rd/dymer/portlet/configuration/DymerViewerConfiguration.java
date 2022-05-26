package it.eng.rd.dymer.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Liferay
 */
@Meta.OCD(
	id = "it.eng.rd.dymer.portlet.configuration.DymerViewerConfiguration"
)
public interface DymerViewerConfiguration {

	@Meta.AD(required = false)
	public String fontColor();
	
	@Meta.AD(required = false)
	public String dymerIp();
	
	@Meta.AD(required = false)
	public String dviewtype();
	
	@Meta.AD(required = false)
	public String addModel();
	
	@Meta.AD(required = false)
	public String keyget();
	
	@Meta.AD(required = false)
	public String query();
	
	@Meta.AD(required = false)
	public String label();
 
	@Meta.AD(required = false)
	public String autostartsearch();
	
	@Meta.AD(required = false)
	public String showbread();
	
	@Meta.AD(required = false)
	public String not_import();
	
	@Meta.AD(required = false)
	public String dymerTour();
	
	@Meta.AD(required = false)
	public String dymerFreeJSON();
	
	@Meta.AD(required = false)
	public String dymerFreeHTML();
	
	
//	searchbar
	@Meta.AD(required = false)
	public String showfilter();

	@Meta.AD(required = false)
	public String expandedFilter();

	@Meta.AD(required = false)
	public String placeHolderFilter();
	
	@Meta.AD(required = false)
	public String dsearchtype();
	
	@Meta.AD(required = false)
	public String keyurlget();
	
	@Meta.AD(required = false)
	public String filtermodel();
	
	@Meta.AD(required = false)
	public String basefilter();
	
	@Meta.AD(required = false)
	public String customfilter();
	
	
	//vertical search
	@Meta.AD(required = false)
	public String showVerticalfilter();
	
	@Meta.AD(required = false)
	public String dymerSearch();
	
	@Meta.AD(required = false)
	public String precustomfilter();
	
	@Meta.AD(required = false)
	public String postcustomfilter();
	
//	map
	@Meta.AD(required = false)
	public String typemapdt();

	@Meta.AD(required = false)
	public String dataTable();
	
	@Meta.AD(required = false)
	public String dmapstyle();
	
	@Meta.AD(required = false)
	public String map_markers();
	
	@Meta.AD(required = false)
	public String map_configuration();
	
//crypto
	@Meta.AD(required = false)
	public String secreKey();
		
}