<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@ page import="it.eng.rd.dymer.portlet.configuration.DymerViewerConfiguration" %>
<%@ page import="it.eng.rd.dymer.portlet.constants.DymerViewerPortletKeys" %>

<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>

<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.List"%>


<liferay-theme:defineObjects />
<portlet:defineObjects />

<%

	Log _log = LogFactoryUtil.getLog("init.jsp");
	DymerViewerConfiguration dymerViewerConfiguration =	(DymerViewerConfiguration)renderRequest.getAttribute(DymerViewerConfiguration.class.getName());
	
	String dymerIp = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		dymerIp = portletPreferences.getValue("dymerIp", dymerViewerConfiguration.dymerIp());
	}
	String dviewtype = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		dviewtype = portletPreferences.getValue("dviewtype", dymerViewerConfiguration.dviewtype());
	}
	String addModel = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		addModel = portletPreferences.getValue("addModel", dymerViewerConfiguration.addModel());
	}
	String keyget = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		keyget = portletPreferences.getValue("keyget", dymerViewerConfiguration.keyget());
	}
	String query = "";
	String configview ="";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		query = portletPreferences.getValue("query", dymerViewerConfiguration.query());
		configview = portletPreferences.getValue("query", dymerViewerConfiguration.query());
	}
	String label = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		label = portletPreferences.getValue("label", dymerViewerConfiguration.label());
	}
	String not_import = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		not_import = portletPreferences.getValue("not_import", dymerViewerConfiguration.not_import());
	}
	
	String dymerTour = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		dymerTour = portletPreferences.getValue("dymerTour", dymerViewerConfiguration.dymerTour());
	}
	
	

/* *******************************************************************************************************
	renderer conditions
*/	
	
	String showbread = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		showbread = portletPreferences.getValue("showbread", dymerViewerConfiguration.showbread());
	}
	
	String autostartsearch = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		autostartsearch = portletPreferences.getValue("autostartsearch", dymerViewerConfiguration.autostartsearch());
	}
	
	String showfilter = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		showfilter = portletPreferences.getValue("showfilter", dymerViewerConfiguration.showfilter());
	}
	

	String expandedFilter = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		expandedFilter = portletPreferences.getValue("expandedFilter", dymerViewerConfiguration.expandedFilter());
	}
	String placeHolderFilter = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		placeHolderFilter = portletPreferences.getValue("placeHolderFilter", dymerViewerConfiguration.placeHolderFilter());
	}

/* *******************************************************************************************************
	searchbar
*/
	String dsearchtype = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		dsearchtype = portletPreferences.getValue("dsearchtype", dymerViewerConfiguration.dsearchtype());
	}
	String keyurlget = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		keyurlget = portletPreferences.getValue("keyurlget", dymerViewerConfiguration.keyurlget());
	}
	String filtermodel = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		filtermodel = portletPreferences.getValue("filtermodel", dymerViewerConfiguration.filtermodel());
	}
	String basefilter = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		basefilter = portletPreferences.getValue("basefilter", dymerViewerConfiguration.basefilter());
	}
	String customfilter = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		if (portletPreferences!=null){
			customfilter = portletPreferences.getValue("customfilter", dymerViewerConfiguration.customfilter());
			if (customfilter!=null){
				if (customfilter.equalsIgnoreCase("null")){
					customfilter = "";
				} 
			}
		} 
	}
	
	/* ******************************************* Vertical searchbar ***************************/	
	String showVerticalfilter = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		showVerticalfilter = portletPreferences.getValue("showVerticalfilter", dymerViewerConfiguration.showVerticalfilter());
	}
	
	String dymerSearch = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		dymerSearch = portletPreferences.getValue("dymerSearch", dymerViewerConfiguration.dymerSearch());
	}
	
	
	String precustomfilter = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		if (portletPreferences!=null){
			precustomfilter = portletPreferences.getValue("precustomfilter", dymerViewerConfiguration.precustomfilter());
			if (precustomfilter!=null){
				if (precustomfilter.equalsIgnoreCase("null")){
					precustomfilter = "";
				} 
			}
		} 
	}
	
	String postcustomfilter = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		if (portletPreferences!=null){
			postcustomfilter = portletPreferences.getValue("postcustomfilter", dymerViewerConfiguration.postcustomfilter());
			if (postcustomfilter!=null){
				if (postcustomfilter.equalsIgnoreCase("null")){
					postcustomfilter = "";
				} 
			}
		} 
	}
	
	
	/********************* end vertical searchbar************************/
	
	boolean showfilter_ = false;
	if (showfilter!=null && !showfilter.isEmpty()){
		if(showfilter.equalsIgnoreCase("on") ){
			showfilter_=true;
		}
	}
	
	boolean expandedFilter_ = false;
	if (expandedFilter!=null && !expandedFilter.isEmpty()){
		if(expandedFilter.equalsIgnoreCase("on") ){
			expandedFilter_=true;
		}
	}

	boolean placeHolderFilter_ = false;
	if (placeHolderFilter!=null && !placeHolderFilter.isEmpty()){
		if(placeHolderFilter.equalsIgnoreCase("on") ){
			placeHolderFilter_=true;
		}
	}

	boolean autostartsearch_ = false;
	if (autostartsearch!=null && !autostartsearch.isEmpty()){
		if(autostartsearch.equalsIgnoreCase("on") ){
			autostartsearch_=true;
		}
	}
	
	boolean showbread_ = false;
	if (showbread!=null && !showbread.isEmpty()){
		if(showbread.equalsIgnoreCase("on") ){
			showbread_=true;
		}
	}
	
	boolean showVerticalfilter_ = false;
	if (showVerticalfilter!=null && !showVerticalfilter.isEmpty()){
		if(showVerticalfilter.equalsIgnoreCase("on") ){
			showVerticalfilter_=true;
		}
	}
	
	
	
	
	
/* *******************************************************************************************************
	map
*/
	String typemapdt = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		typemapdt = portletPreferences.getValue("typemapdt", dymerViewerConfiguration.typemapdt());
	}
	
	String dataTable = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		dataTable = portletPreferences.getValue("dataTable", dymerViewerConfiguration.dataTable());
	}
	String dmapstyle = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		dmapstyle = portletPreferences.getValue("dmapstyle", dymerViewerConfiguration.dmapstyle());
	}
	String map_markers = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		map_markers = portletPreferences.getValue("map_markers", dymerViewerConfiguration.map_markers());
	}
	
	String secretKey = "";
	if (Validator.isNotNull(dymerViewerConfiguration)) {
		secretKey = portletPreferences.getValue("secretKey", dymerViewerConfiguration.secreKey());
	}
// 	String[] checkedRoles = portletPreferences.getValues("checkedRoles", dymerViewerConfiguration.checkedRoles());
	
/*	_log.info("[DymerViewerPortlet][init.jsp] dymerIp: "+dymerIp);
	_log.info("[DymerViewerPortlet][init.jsp] dviewtype: "+dviewtype);
	_log.info("[DymerViewerPortlet][init.jsp] addModel: "+addModel);
	_log.info("[DymerViewerPortlet][init.jsp] keyget: "+keyget);
	_log.info("[DymerViewerPortlet][init.jsp] query: "+query);
	_log.info("[DymerViewerPortlet][init.jsp] label: "+label);*/
	
/* *******************************************************************************************************
	renderer conditions
*/	

/*	_log.info("[DymerViewerPortlet][init.jsp] showbread: "+showbread);
	_log.info("[DymerViewerPortlet][init.jsp] autostartsearch: "+autostartsearch);
	_log.info("[DymerViewerPortlet][init.jsp] showfilter: "+showfilter);*/
	
/* *******************************************************************************************************
	searchbar
*/	
/*	_log.info("[DymerViewerPortlet][init.jsp] searchbar params");
	
	_log.info("[DymerViewerPortlet][init.jsp] dsearchtype: "+dsearchtype);
	_log.info("[DymerViewerPortlet][init.jsp] keyurlget: "+keyurlget);
	_log.info("[DymerViewerPortlet][init.jsp] filtermodel: "+filtermodel);
	_log.info("[DymerViewerPortlet][init.jsp] basefilter: "+basefilter);
	_log.info("[DymerViewerPortlet][init.jsp] customfilter: "+customfilter);
	
	_log.info("[DymerViewerPortlet][init.jsp] showfilter_: "+showfilter_);
	_log.info("[DymerViewerPortlet][init.jsp] autostartsearch_: "+autostartsearch_);
	_log.info("[DymerViewerPortlet][init.jsp] showbread_: "+showbread_);
	*/
/* *******************************************************************************************************
	map
*/
/*	_log.info("[DymerViewerPortlet][init.jsp] map params");
	_log.info("[DymerViewerPortlet][init.jsp] typemapdt: "+typemapdt);
	_log.info("[DymerViewerPortlet][init.jsp] dataTable: "+dataTable);
	_log.info("[DymerViewerPortlet][init.jsp] dmapstyle: "+dmapstyle);
	_log.info("[DymerViewerPortlet][init.jsp] map_markers: "+map_markers);*/
%>


<c:set var="dymerIp_" value="<%=dymerIp %>" />
<c:set var="dviewtype_" value="<%=dviewtype %>" />
<c:set var="addModel_" value="<%=addModel %>" />
<c:set var="keyget_" value="<%=keyget %>" />
<c:set var="query_" value="<%=query %>" />

<!-- renderer conditions -->
<c:set var="showfilter_" value="<%=showfilter_ %>" />

<c:set var="expandedFilter_" value="<%=expandedFilter_ %>" />
<c:set var="placeHolderFilter_" value="<%=placeHolderFilter_ %>" />

<c:set var="showbread_" value="<%=showbread_ %>" />
<c:set var="autostartsearch_" value="<%=autostartsearch_ %>" />

<c:set var="showfilter_txt" value="<%=showfilter %>" />
<c:set var="showbread_txt" value="<%=showbread%>" />
<c:set var="autostartsearch_txt" value="<%=autostartsearch%>" />

<!-- searchbar params -->
<c:set var="dsearchtype_" value="<%=dsearchtype %>" />
<c:set var="keyurlget_" value="<%=keyurlget %>" />
<c:set var="filtermodel_" value="<%=filtermodel %>" />
<c:set var="basefilter_" value="<%=basefilter %>" />
<c:set var="customfilter_" value="<%=customfilter %>" />

<c:set var="showVerticalfilter_" value="<%=showVerticalfilter_ %>" />
<c:set var="dymerSearch_" value="<%=dymerSearch %>" />
<c:set var="precustomfilter_" value="<%=precustomfilter %>" />
<c:set var="postcustomfilter_" value="<%=postcustomfilter %>" />

<!-- map params -->
<c:set var="typemapdt_" value="<%=typemapdt %>" />
<c:set var="dataTable_" value="<%=dataTable %>" />
<c:set var="dmapstyle_" value="<%=dmapstyle %>" />
<c:set var="map_markers_" value="<%=map_markers %>" />

<c:set var="secretKey_" value="<%=secretKey %>" />


<c:choose>
	<c:when test="${dviewtype_ eq 'dymerlist'}">
		<c:set var="viewjs" value="dymer.viewer.js" />
	</c:when>
	<c:when test="${dviewtype_ eq 'dymermap'}">
		<c:set var="viewjs" value="dymer.map.js" />
	</c:when>
	<c:when test="${dviewtype eq 'dymersingleid'}">
		<c:set var="viewjs" value="dymer.viewer.js" />
	</c:when>
</c:choose>


<script id="dymerurl" src="${dymerIp_}/public/cdn/js/${viewjs}" data-senna-off="true"></script>
<!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tour/0.12.0/css/bootstrap-tour.min.css" rel="stylesheet"> -->
<!-- <script id="dymertour" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-tour/0.12.0/js/bootstrap-tour.min.js" data-senna-off="true"></script> -->