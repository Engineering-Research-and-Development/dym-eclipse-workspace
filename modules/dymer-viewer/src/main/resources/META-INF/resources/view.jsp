<%@ include file="/init.jsp" %>
<%@ page import="it.eng.rd.dymer.portlet.util.Util" %>

<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.model.Company" %>
<%@ page import="com.liferay.portal.kernel.service.CompanyLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CookieKeys" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Base64" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="it.eng.rd.dymer.portlet.configuration.DymerViewerConfiguration" %>
<%@ page import="it.eng.rd.dymer.portlet.util.crypto.AesCrypto"%>
<%@ page import="it.eng.rd.dymer.portlet.util.Util" %>

<%  

	Log log = LogFactoryUtil.getLog("view.jsp");

	String fglobalsearch = "";
	fglobalsearch=(fglobalsearch==null) ? "" : fglobalsearch;
	User currentUser = themeDisplay.getUser();
	
	String[] jwts = AesCrypto.dymerJwts(currentUser, themeDisplay.getScopeGroupId());
	
	String dymerJwt = AesCrypto.encrypting(jwts[0]);
	if (dymerJwt.equalsIgnoreCase(jwts[0])){	
		dymerJwt = new String (Base64.getEncoder().encode(dymerJwt.getBytes()));
		if (log.isDebugEnabled())
			log.debug("[dymer-viewer] dymerJwt base64: "+dymerJwt);
	}
	String dymerExtraJwt = new String (Base64.getEncoder().encode((jwts[1]).getBytes()));
	String dymAT = (String) request.getAttribute("DYMATattribute");
%>

<script type="text/javascript">
	var pnamespacedymerview = '<portlet:namespace/>';
	var dviewtype = "${dviewtype_}"; 
</script>

<script type="text/javascript">
	var dymExtraJWT = '<%=dymerExtraJwt%>';
	var dymJWT = '<%=dymerJwt%>';
	var dymATjs = '<%=dymAT%>'
	localStorage.setItem('DYM_EXTRA', dymExtraJWT );
	localStorage.setItem('DYM', dymJWT );
	localStorage.setItem('DYMAT', dymATjs );
</script>

<div class="container-fluid" id="containerDymerViewer">
<!---------------------------------------------------- start searchbar ---------------------------------------------------->
<c:if test="<%=showfilter_ %>">
<c:choose>
	<c:when test="${dsearchtype_ eq 'snippets'}">
	<div id="dymer_filtercontent">
		<div class="row">
			<div class="col-12 span12">

				<div class="input-group" id="adv-search">
					<input id="dTagFilter" 
						type="text" 
						data-role="tagsinput" 
						placeholder="Search for snippets, click on caret" 
						class="col-6 span6">
					<div class="input-group-btn">
                    	<div class="btn-group" role="group">
    						<div class="dropdown dropdown-lg">
                               	<button type="button"  id="dFilterClearAll" class="btn"  data-autostart="<%=autostartsearch_%>">
                               			<i class="fa fa-eraser" onclick="clearDFilter()"></i>
                               	</button>

							 <% if(expandedFilter_) { %>
									<button type="button" id="dFilterDropdown" class="btn btn-default dropdown-toggle"  onclick="toggleFilter()" ><span class="caret"></span></button>
									<% } else { %>
									<button type="button" id="dFilterDropdown" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></button>
							 <% } %>
                        		 


							 <% if(!expandedFilter_) { %>
								<div id="d_entityfilter" class="dropdown-menu dropdown-menu-right " <% if(placeHolderFilter_) { %> useplaceholder="true" <% } else {  %> useplaceholder="false" <% } %> role="menu"> 
								  ${customfilter_}
                        		</div>
								<% } %>
                  			</div>
                   			<button type="button" 
                   				class="btn btn-primary" 
                   				onclick="switchByFilter(dTagFilter, dviewtype)">
                   					<i class="fa fa-search" aria-hidden="true"></i>
                   			</button>
          				</div>
		            </div>
		        </div>
		    </div>
			<% if(expandedFilter_) { %>
				<div class="col-12">		
					 <div id="d_entityfilter" class="expanded" <% if(placeHolderFilter_) { %> useplaceholder="true" <% } else {  %> useplaceholder="false" <% } %> >
						${customfilter_}
					 </div>
				</div>
		  <% } %>
		</div> 
	</div> 
	</c:when>
	<c:when test="${dsearchtype_ eq 'freeinput'}">
	<div id="dymer_filtercontent">
		<div class="row">
			<div class="col-12 span12">
				<div class="input-group" id="adv-search">
					<input id="dTagFilter" type="text" 
						data-role="tagsinput" 
						placeholder="Search" 
						class="col-6 span6 freetext" 
						value="">
					<div class="input-group-btn">
                    	<div class="btn-group" role="group">
    						<div class="dropdown dropdown-lg">
                               	<button type="button" 
                               		id="dFilterClearAll" 
                               		class="btn freetext" 
                               		data-autostart=<%=autostartsearch_%>>
                               		<i class="fa fa-eraser" onclick="clearDFilter()"></i>
                               	</button>
                  			</div>
                   			<button type="button" 
                   				class="btn btn-primary" 
                   				onclick="switchByFilter(dTagFilter, dviewtype)">
                   					<i class="fa fa-search" aria-hidden="true"></i>
                   			</button>
          				</div>
		            </div>
		        </div>
		    </div>
		</div> 
	</div> 
	<script>
	$("#dTagFilter").on('keyup', function (e) {
	    if (e.key === 'Enter' || e.keyCode === 13) {
	    	switchByFilter(dTagFilter, dviewtype);
	    }
	});
	</script>
	</c:when>
</c:choose>
</c:if>
<!---------------------------------------------------- end searchbar ---------------------------------------------------->
<c:choose>
		<c:when test="${(query_ eq '') && (dviewtype_ ne 'dymersingleid')}">
			<div class="row">
				<div class="col-12 span12 ">
					<div class="alert alert-info" style="margin: 0">
						<strong>You need to configure the portlet.</strong>
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${dviewtype_ eq 'dymerfree'}">
			
			<script>
			 
			 	var str_not_import = "<%=not_import%>";
				var ar = str_not_import.split(',');
			
				var dymerconf= {
	  				notImport:ar
	  			};
				
				<%=dymerFreeJSON%>
	  	 	 </script>
			 <%=dymerFreeHTML%>
		</c:when>
		<c:when test="${dviewtype_ eq 'dymerlist'}">
		<!-- ------------------------------------------------------------------------------------------------ -->
			
			<script>
			
			
// 			  var tour = new Tour({
<%-- 				  steps: [<%=dymerTour%> ]}); --%>

// 				 tour.init();

// 				 tour.start();
		
		   <%  if(showtour_) {    %>
					   $( document ).ready(function() {
							
							$("#startTour").click(function() { 
								
						     	introJs().setOptions({
								  steps: [<%=dymerTour%>]
								}).start();
						
						     });	
						});			
						
	  	 	 
	  	    <%}%>

                


				var str_not_import = "<%=not_import%>";
				var ar = str_not_import.split(',');
			
			 	var dTagFilter;
				var dymerQueries = [<%=query%>];
				var dymerconf= {
	  				notImport:ar
	  			};

		  	 	var jsonConfig = {
					query: { 'query': { 'query' : dymerQueries[0]}},
					endpoint: 'entity.search',
					viewtype: 'teaserlist',
					target: {
						teaserlist: {
							id: "#cont-MyList",
							action: "html",
							reload:false
						},
						fullcontent: {
							id: "#cont-MyList",
							action: "html"
						}
					}
				};

	  	 	<%
	  	 		//TODO check
	  	 		boolean reloadContent = false;
	  	 		if(reloadContent) {
	  	 	%>
	  	 		mainDymerView();
	  	 	<%}%>

			function mainDymerView() {
				<% 
					//TODO check
					boolean roleOkay = true;
					if(roleOkay) { 
				%>
					var index = '${addModel_}';
					loadModelListToModal($('#cont-addentity'), index);
				<% } %>
				
		    
		    <%  if(showVerticalfilter_) {    %>
			          dsearch = new dymerSearch(<%=  dymerSearch  %> );

            <%  }%>
				
				
				//TODO check
				<% 
					if(showfilter_) { 
				%>
				setTimeout(function() {
                    dTagFilter = $('#dTagFilter');
                    dTagFilter.dymertagsinput({
                        //indexmodelfilter:"hubcapmodel",
                        <% 
                       		if(!basefilter.isEmpty()) { 
                        %>
                        	indexterms: <%=  basefilter  %>,
                        <% 
                        	}
                        %>
                        	allowDuplicates: true,
                        <% 
                        	if(dsearchtype.equals("snippets")) {
                        %> 
		                        freeInput: false,
		                        itemValue: 'id', // this will be used to set id of tag
		                        itemText: 'label' // this will be used to set text of tag	 
                        <% 
                        	} else {
                        %>
                        		freeInput: true 
                        <% 
                        	} 
                       	%>
                        
                    });
                    dTagFilter.on('beforeItemRemove', function(event) {
                        $('#d_entityfilter [filter-rel="' + event.item.id + '"').prop("checked", false);
                    });
                    <% 
                    	if(!autostartsearch_) { 
                    		if(!(fglobalsearch.trim()).isEmpty()) {
                    %>
                    			switchByFilter(dTagFilter, dviewtype);
                    <% 
                    		} else {    
                    %>
                    			$('#cont-MyList').empty();
                    <% 
                    		}  
                    	} 
                    %>
                }, 3000);
					<% 
						if(!filtermodel.isEmpty() && dsearchtype.endsWith("snippets")) { 
					%>
							var indexFilter ="<%=filtermodel.toString() %>";
					 		loadFilterModel(indexFilter, dTagFilter);
					<% } %>
				<% } //TODO check close showfilter_%>
				<% if(autostartsearch_ && (fglobalsearch.trim()).isEmpty()) { %>
					drawEntities(jsonConfig);
				<% 
					} else { 
				%>
					loadEntitiesTemplate(jsonConfig);
				<% 
					} 
				%>
				checkbreadcrumb(null, $('#primodfil'));//per il primo home breadcrumb
			}

			</script>
			  
	         <%  if(showtour_) {    %>
	         
	         <%= dymerTourText %>
	         
	          <%}%>
			 
			 
			 
			 <div class="row">
			    <div class="col-md-12">
					<div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Dymer Toolbar">
						  <div class="btn-group" role="group" aria-label="First group">
						    <button id="primodfil" type="button" class="btn btn-outline-secondary" onclick="drawEntities(jsonConfig)"><i class="fa fa-home" aria-hidden="true"></i> <%= label %></button>
						     
						  </div>
						  <%  boolean roleOkay_=true;
									if(roleOkay_) { 
								%> <div class="input-group" id="cont-addentity">
						       
						  
								  </div><%
								}%>
						</div>
			 
			    </div>
			 </div>
			 
			 
			 
			 
			 <div class="row">
 					<% if(showVerticalfilter_) { %>
                    <div id="dymer_filtercontent" class="col-md-3 ">
                    		<form    id="myfilter" class="dymerSearch">
                    		  <% 
		                    	if(!precustomfilter.isEmpty()) { 
		                    %>
		                    	  <%=precustomfilter%>
		                    <% 
		                    	} 
		                    %>
                    			 <div id="contform" class="row"></div>
                    			 
                    			  <% 
		                    	if(!postcustomfilter.isEmpty()) { 
		                    %>
		                     <%=postcustomfilter%>
		                    <% 
		                    	} 
		                    %>
                    		</form>
                    </div>
                    <div class="col-md-9">
                    <% }else{%>
                    <div class="col-md-12">
		   			 <% }%>
				 
				 	 
				  	<c:if test="<%=showbread_ %>">
						<div id="dymer_breadcrumb" class="col-12"></div>
					</c:if>
	
					<div id="cont-MyList">
							 
							<div class="text-center">
							<div class="spinner-border text-secondary" role="status">
							  <span class="sr-only">Loading...</span>
							</div>	
						</div>
					</div>
					
					</div>			 
		    </div>
		</c:when>
		
		<c:when test="${dviewtype_ eq 'dymersingleid'}">
		<!-- ------------------------------------------------------------------------------------------------ -->
			 <script>
			 
			 	var str_not_import = "<%=not_import%>";
				var ar = str_not_import.split(',');
			
				var dymerconf= {
	  				notImport:ar
	  			};
			 
	  	 	 function mainDymerView() {
	  	        drawEntityByIdUrl("#cont-MyEnt",'${keyget_}');
	  	     }
	  	 	 </script>
			 <div id="cont-MyEnt"></div>
		</c:when>
		
		<c:when test="${dviewtype_ eq 'dymermap'}">
		<!-- ------------------------------------------------------------------------------------------------ -->
 
			<script>
			
// 			$( document ).ready(function() {
				
// 				  var tour = new Tour({
<%-- 					  steps: [<%=dymerTour%> ]}); --%>

// 					 tour.init();

// 					 tour.start();
// 				});			
			<%  if(showtour_) {    %>
			
			$( document ).ready(function() {
				
				$("#startTour").click(function() { 
					
			     	introJs().setOptions({
					  steps: [<%=dymerTour%>]
					}).start();
			
			     });	
 			});			
			
				 
				 
			  <%}%>

			
			var str_not_import = "<%=not_import%>";
			var ar = str_not_import.split(',');
		
		 	var dTagFilter;
			var dymerQueries = [<%=query%>];
			var dymerconf= {
  				notImport:ar
  			};
			
		  	function mainDymerMap() {
		  		<% 	
		  			boolean roleOkay = true;
		  		    if(roleOkay) { 
		  		%>
					var index = '${addModel_}';
					if(index!="")
						loadModelListToModal($('#cont-addentity'), index);
				<% 
				} 
				%>
				
				
				  <%  if(showVerticalfilter_) {    %>
		          dsearch = new dymerSearch(<%=  dymerSearch  %> );

       			 <%  }%>
				
				//query: { 'query': { 'query' : dymerQueries[0]}},
				
				//query: { 'instance': dymerQueries[0] },
		  		var callconf = {
		  			query: { 'query': { 'query' : dymerQueries[0]}},
					endpoint: 'entity.search',
					viewtype: 'teaserlist',
					swapgeop: true,
					<% 
						if(typemapdt.equals("mapdt") || typemapdt.equals("map")) { 
					%>	
						map:{
							 <% 
							if(!map_configuration.isEmpty()) { 
							%>	
							<%=map_configuration%>
							<% 
							} 
							%>
						},
					<% 
						} 
					%>
					<% 
						if(typemapdt.equals("mapdt") || typemapdt.equals("dt")) { 
					%>	
							dt:  <%= dataTable != null && !dataTable.equals("") ? dataTable : "{}"%>,
					<% 
						} 
					%>
						target: {
							fullcontent: {
								id: "#cont-MyEnt",
								action: "html"
							},
							map:{
								id:"#cont-TotalMap"},
								dt:{id:"#cont-Dt"}
							}
						};
					<% 
						if(!configview.isEmpty()) { 
					%>
				   		<% 
				   			if(autostartsearch_ && (fglobalsearch.trim()).isEmpty()) {
				   		%>
				   				generateMapDT(callconf);
						<% 
							} else { 
						%>
								loadEntitiesTemplate(callconf);
						<% 
							}
						%>
			 		<% 
			 			} 
			 		%>
				<% 
					if(showfilter_) { 
				%>
					setTimeout(function() {
		                dTagFilter = $('#dTagFilter');
		                dTagFilter.dymertagsinput({
		                    <% 
		                    	if(!basefilter.isEmpty()) { 
		                    %>
		                    	indexterms: <%=basefilter%>,
		                    <% 
		                    	} 
		                    %>
		                    allowDuplicates: true,
		                    <% 
		                    	if(dsearchtype.equals("snippets")) {
		                    %> 
		                        freeInput: false,
		                        itemValue: 'id', // this will be used to set id of tag
		                        itemText: 'label' // this will be used to set text of tag	 
	                        <%  
	                        	} else { 
	                        %>
	                        	freeInput: true 
	                        <% 
	                        	} 
	                        %>
		                });
		                dTagFilter.on('beforeItemRemove', function(event) {
		                    $('#d_entityfilter [filter-rel="' + event.item.id + '"').prop("checked", false);
		                });
		                <% 
		                	if(!autostartsearch_) { 
	                    		if(!(fglobalsearch.trim()).isEmpty()) {
	                    %>
	                    		switchByFilter(dTagFilter, dviewtype);
	                    <% 
	                    		} else {    
	                    %>
	                    			$('#cont-Map').empty();
	                    <% 		}  
		              		} 
		              	%>
		                
		            }, 3000);
					<% 
						if(!filtermodel.isEmpty() && dsearchtype.endsWith("snippets")) { 
					%>
							var indexFilter ="<%=filtermodel.toString() %>";
					 		loadFilterModel(indexFilter, dTagFilter);
					<% 
						} 
					%>
				<% } %>
				//generateMapDT(callconf);
				//drawEntities(callconf);
				}
		  		//var d_dt_functions=${d_dt_functions};
			</script>

			<div class="container_">
				  <%  if(showtour_) {    %>
				  
				  <%= dymerTourText %>
			                
			    <%}%> 
  				<div class="row mb-2 ">
					<div class="col-12 col-md-12 span12  "  >
					<div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Dymer Toolbar">
					
					
					<% 
						if(typemapdt.equals("map")) { 
					%>	
  	
						<div class="btn-group" role="group" aria-label="First group">
						    <button type="button" class="btn btn-outline-secondary" id="showmap" onclick="showDatasetContainer();"><i class="fa fa-globe" aria-hidden="true"></i> Show Map</button>
						 </div>
						
						
						
					<% } %>
					<% 
						if(typemapdt.equals("dt")) { 
					%>	
 
						 <div class="btn-group" role="group" aria-label="First group">
						    <button type="button" class="btn btn-outline-secondary" id="showmap" onclick="showDatasetContainer();"> <i class="fa fa-table" aria-hidden="true"></i> Show Table</button>
						 </div>
						
						
						
					<% } %>
					<% 
						if(typemapdt.equals("mapdt")) { 
					%>	
  						 <div class="btn-group" role="group" aria-label="First group">
						    <button type="button" class="btn btn-outline-secondary" id="showmap" onclick="showDatasetContainer();"> <i class="fa fa-table" aria-hidden="true"></i> Show Map & Table</button>
						 </div>
					<% } %>
					
					   <%  	if(roleOkay) { 
						   %>
						   <div class="input-group" id="cont-addentity">
						  	 
						  	</div>
						   <% 
					 		} 
					   %>
					   
					     </div>
					</div>
				</div>
			</div>
			
			
			<div class="container_" >
 			<% 
 				if(typemapdt.equals("mapdt") || typemapdt.equals("map")) { 
 			%>	
				<div class="row" id="cont-TotalMap"> 
 					
 					
 					<% if(showVerticalfilter_) { %>
                    <div id="dymer_filtercontent" class="col-md-3 ">
                    		<form    id="myfilter" class="dymerSearch">
                    		 <% 
		                    	if(!precustomfilter.isEmpty()) { 
		                    %>
		                    	  <%=precustomfilter%>
		                    <% 
		                    	} 
		                    %>
                    			 <div id="contform" class="row"></div>
                    			 
                    			  <% 
		                    	if(!postcustomfilter.isEmpty()) { 
		                    %>
		                     <%=postcustomfilter%>
		                    <% 
		                    	} 
		                    %>
                    		  
                    		</form>
                    </div>
                    <div class="col-md-9" id="cont-Map">
                    <% }else{%>
                    <div class="col-md-12" id="cont-Map">
		   			 <% }%>
 					
 					
 					  <div class="text-center">
							<div class="spinner-border text-secondary" role="status">
							  <span class="sr-only">Loading...</span>
							</div>	
						</div>
					<span class="loader"></span>
					</div>
				</div>

				<!---->
			<% 
				}
			%>
			<% 
				if(typemapdt.equals("mapdt") || typemapdt.equals("dt")) { 
			%>	
				<div id="cont-Dt"> </div>
			<% 
				} 
			%>
				<div id="cont-MyEnt"></div>
			</div>
			<!--<div id="cont-MyList">Loading...3</div>-->
		</c:when>

	</c:choose>
</div>