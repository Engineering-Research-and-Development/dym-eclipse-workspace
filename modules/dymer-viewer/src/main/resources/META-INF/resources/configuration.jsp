<%@ include file="/initConf.jsp" %>

<liferay-portlet:actionURL
	portletConfiguration="<%= true %>"
	var="configurationActionURL"
/>

<liferay-portlet:renderURL
	portletConfiguration="<%= true %>"
	var="configurationRenderURL"
/>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input
		name="<%= Constants.CMD %>"
		type="hidden"
		value="<%= Constants.UPDATE %>"
	/>

	<aui:input
		name="redirect"
		type="hidden"
		value="<%= configurationRenderURL %>"
	/>

 
	<div class="sheet sheet-lg active ddm-form-page lfr-ddm-form-page" data-ddm-page="0">
    
		<div>
		   <div class="position-relative row">
			  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="0" class="col-ddm col-md-12">
				 <div class="ddm-field-container ddm-target h-100" data-field-name="Field95292365">
					<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="0"></div>
					<div class="ddm-drag">
					   <div class="ddm-field" data-field-name="Field95292365">
						  <div class="form-group" 
						  		data-field-name="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field95292365$LtunLVJm$0$$en_US">
							 <label aria-describedby="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field95292365$LtunLVJm$0$$en_US_fieldDetails" class="ddm-label" tabindex="0">General Configuration</label>
							 <div class="separator" style=""></div>
							 <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field95292365$LtunLVJm$0$$en_US_fieldDetails">General Configuration<br></span>
						  </div>
					   </div>
					</div>
					<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="0"></div>
				 </div>
			  </div>
		   </div>
		   <div class="placeholder row">
			  <div data-ddm-field-page="0" data-ddm-field-row="1" class="col col-ddm col-empty col-md-12">
				 <div class="ddm-target"></div>
			  </div>
		   </div>
		</div>
		<div>
		   <div class="position-relative row">
				  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-6">
					 <div class="ddm-field-container ddm-target h-100" data-field-name="Field63772425">
						<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
						<div class="ddm-drag">
						   <div class="ddm-field" data-field-name="Field63772425">
							  <div class="form-group"  ><label class="ddm-label" tabindex="0">DymerURL</label>
							  <input name="<portlet:namespace />dymerIp" type="text"  value="<%=dymerIp%>"class="form-control ddm-field-text">
							  <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field63772425$kUjcTyrP$0$$en_US_fieldDetails">DymerURL<br></span></div>
						   </div>
						</div>
						<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
					 </div>
				  </div>
			  
				  <div data-ddm-field-column="1" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-6">
					 <div class="ddm-field-container ddm-target h-100" data-field-name="Field41787856">
						<aui:select label="label-dymer-view-as" name="dviewtype" id="dviewtype" value="<%=dviewtype%>" >
							    <aui:option  value="dymerlist" selected="${dviewtype_ eq 'dymerlist'}">
				                   	<liferay-ui:message key="openness.dymer.label.dymerlist" />
			                   	</aui:option>
			                   	<aui:option  value="dymermap"  selected="${dviewtype_ eq 'dymermap'}">
			                   		<liferay-ui:message key="openness.dymer.label.dymermap" />
			                   	</aui:option>
			                   	<aui:option  value="dymersingleid"  selected="${dviewtype_ eq 'dymersingleid'}" >
			                  		<liferay-ui:message key="openness.dymer.label.dymersinglebyid" />
			                  	</aui:option>
			                  	<aui:option  value="dymerfree"  selected="${dviewtype_ eq 'dymerfree'}" >
			                  		<liferay-ui:message key="openness.dymer.label.dymerfree" />
			                  	</aui:option>
						 </aui:select>
					</div>
				  </div>
			  </div>
			  
		  <div class="position-relative row">
				  <div  class="col-ddm col-md-6">
					 <div class="ddm-field-container ddm-target h-100" data-field-name="Field65143131">
						<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="2" data-ddm-field-page="0" data-ddm-field-row="1">
						</div>
						<div class="ddm-drag">
						   <div class="ddm-field" data-field-name="Field65143131">
							  <div class="form-group" data-field-name="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field65143131$hD5ehXcu$0$$en_US"><label aria-describedby="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field65143131$hD5ehXcu$0$$en_US_fieldDetails" class="ddm-label" tabindex="0">Model to Add</label>
							  <input  name="<portlet:namespace />addModel" type="text" value="<%=addModel%>" class="form-control ddm-field-text"><span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field65143131$hD5ehXcu$0$$en_US_fieldDetails">Model to Add<br></span></div>
						   </div>
						</div>
						<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="2" data-ddm-field-page="0" data-ddm-field-row="1"></div>
					 </div>
				  </div>
			  
			     <div   class="col-ddm col-md-6">
							  <div class="form-group form-inline input-checkbox-wrapper">
									 <label for="showonload">
									 	<input class="field" id="autostartsearch" 
									 		name="<portlet:namespace/>autostartsearch" 
									 		<c:if test="${autostartsearch_}">checked="checked"</c:if> 
									 		type="checkbox">
									 	<span class="">
									             Search Entities on load page. Deactive to use global search
							           	</span>
									</label>
						 </div>
			  
			     </div>
			  
		   </div>
		   <div class="placeholder row">
			  <div data-ddm-field-page="0" data-ddm-field-row="2" class="col col-ddm col-empty col-md-12">
				 <div class="ddm-target"></div>
			  </div>
		   </div>
		</div>
		<div>
		   <div class="position-relative row">
			 <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="2" class="col-ddm col-md-8">
				 <div class="ddm-field-container ddm-target h-100" data-field-name="Field70149449">
					<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="2">
					</div>
					<div class="ddm-drag">
					   <div class="ddm-field" data-field-name="Field70149449">
						  <div class="form-group" data-field-name="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field70149449$DIOH9jwz$0$$en_US"> 
							  <aui:input type="textarea" label="openness.dymer.label.query" name="query" required="true" cssClass="dymerTextarea" value='<%= query %>' >
								  <aui:validator name="custom" errorMessage="The query must to be a json">
									 function (val, fieldNode, ruleValue) {
										 if(${dviewtype eq 'dymersingleid'}) {
											 return true;
										 }
										 var result = false;
										 try {
											 var js = JSON.parse(val);
			 
											 result = true;
										 } catch(error) {
											 console.log("error=" + error);
										 }
										 return result;
									 }
								 </aui:validator>
						 	</aui:input>
							<span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field70149449$DIOH9jwz$0$$en_US_fieldDetails">Query<br></span>
						  
						  <span class="btn badge  badge-success" id="setquery"><i class="fas fa-paste"></i> Set Default Query</span>
						  <span class="btn badge badge-info" id="setqueryowner"><i class="fas fa-paste"></i> Set Owner Query</span>
		 	    
		 	    <script>

		 	   
		 	  $( document ).ready(function() {
	              
                     $('#setquery').click(function() {
	    					var linktoquery='{"bool": {"must": [{"term": {"_index": "YOUR_INDEX"}	}]}}';
	              			
	    					$('#<portlet:namespace />query').val(linktoquery);
	    					 
	 				 });
                     
                     $('#setqueryowner').click(function() {
	    					var linktoquery='{  "bool": {  "must": [     { "term": { "_index": "YOUR_INDEX" } 	}, { "match_phrase": { "properties.owner.uid": "@OWNERMAIL" } }] }  }';
	              			
	    					$('#<portlet:namespace />query').val(linktoquery);
	    					 
	 				 });
	          });	
		 	   </script>
						  
						  
						  </div>
					   </div>
					</div>
					<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="2"></div>
				 </div>
			 </div>
			 <div data-ddm-field-column="1" data-ddm-field-page="0" data-ddm-field-row="2" class="col-ddm col-md-4">
				 <div class="ddm-field-container ddm-target h-100" data-field-name="Field55496008">
					<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="1" data-ddm-field-page="0" data-ddm-field-row="2">
					</div>
					<div class="ddm-drag">
					   <div class="ddm-field" data-field-name="Field55496008">
						  <div class="form-group" data-field-name="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field55496008$0MErpO9z$0$$en_US">
						  	<label aria-describedby="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field55496008$0MErpO9z$0$$en_US_fieldDetails" class="ddm-label" tabindex="0">Label</label>
						  	<input  label="<%=label%>" name="<portlet:namespace />label" type="text" value='<%=label%>' class="form-control ddm-field-text">
						  	<span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field55496008$0MErpO9z$0$$en_US_fieldDetails">Label<br>
						  	</span>
						  </div>
					   </div>
					</div>
					<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="1" data-ddm-field-page="0" data-ddm-field-row="2">
					</div>
				 </div>
			 </div>
			 
		   </div>
		    <!-- qoption textarea  -->
		    <div class="position-relative row">
				  <div class="col-ddm col-md-8">
					  <div class="lfr-ddm-field-group field-wrapper"  >
				<span class="control-label" >
					<label>Query qoptions</label>
			 	</span>
			  
		 		<textarea class="field form-control lfr-textarea" 
		 			id="<portlet:namespace />dymerQoptions"  
		 			name="<portlet:namespace />dymerQoptions"><%=dymerQoptions%>
		 		</textarea>
		 	    <span class="btn badge badge-primary" id="setQoptions"><i class="fas fa-paste"></i> Set Qoptions</span>
		 	    <script>
                        $( document ).ready(function() {
				                 $('#setQoptions').click(function() {
				    					var linktocopy=',qoptions: {  size:3000, sort:["properties.created:desc"],"relations": true}';
				              			
				    					$('#<portlet:namespace />dymerQoptions').val(linktocopy);
				    					
				    					$('#qoptiondemo').html('<div class="alert alert-info" role="alert"><div class="alert-autofit-row autofit-row"><div class="autofit-col"><div class="autofit-section"><span class="alert-indicator"><svg class="lexicon-icon lexicon-icon-info-circle" role="presentation" viewBox="0 0 512 512">	<path class="lexicon-icon-outline" d="M437,75C388.7,26.6,324.4,0,256,0C187.6,0,123.3,26.6,75,75C26.6,123.3,0,187.6,0,256c0,68.4,26.6,132.7,75,181c48.4,48.4,112.6,75,181,75c68.4,0,132.7-26.6,181-75c48.4-48.4,75-112.6,75-181C512,187.6,485.4,123.3,437,75z M288,384c0,17.7-14.3,32-32,32c-17.7,0-32-14.3-32-32V224c0-17.7,14.3-32,32-32c17.7,0,32,14.3,32,32V384z M256,160c-17.7,0-32-14.3-32-32c0-17.7,14.3-32,32-32s32,14.3,32,32C288,145.7,273.7,160,256,160z"></path></svg></span></div></div><div class="autofit-col autofit-col-expand"><div class="autofit-section"><strong class="lead">Example:</strong> ,qoptions: {  size:3000, sort:["properties.created:desc"],"relations": true </div></div></div></div>')
				    			  });
	           			});	
		 	    </script>
			</div>
				  </div>
			      <div  class="col-ddm col-md-4">
							   
			  			<div id="qoptiondemo"></div>
			      </div>
			 </div>
		    
		    
		 
		    
		    <!-- qoption textarea end -->
		   <hr>
		   <div class="position-relative col-12 col-md-12">
		  	 <div class="form-group input-resource-wrapper">
				<label class="control-label" for="not_import">Excludes the following libraries</label>
				<input class="form-control form-text lfr-input-resource " 
					id="<portlet:namespace />not_import" 
					name="<portlet:namespace />not_import" 
					type="text" 
					value="<%= not_import %>">
		  	 </div>
		  </div>
		  <div class="alert alert-info" role="alert"><div class="alert-autofit-row autofit-row"><div class="autofit-col"><div class="autofit-section"><span class="alert-indicator"><svg class="lexicon-icon lexicon-icon-info-circle" role="presentation" viewBox="0 0 512 512">	<path class="lexicon-icon-outline" d="M437,75C388.7,26.6,324.4,0,256,0C187.6,0,123.3,26.6,75,75C26.6,123.3,0,187.6,0,256c0,68.4,26.6,132.7,75,181c48.4,48.4,112.6,75,181,75c68.4,0,132.7-26.6,181-75c48.4-48.4,75-112.6,75-181C512,187.6,485.4,123.3,437,75z M288,384c0,17.7-14.3,32-32,32c-17.7,0-32-14.3-32-32V224c0-17.7,14.3-32,32-32c17.7,0,32,14.3,32,32V384z M256,160c-17.7,0-32-14.3-32-32c0-17.7,14.3-32,32-32s32,14.3,32,32C288,145.7,273.7,160,256,160z"></path>
								</svg></span></div></div><div class="autofit-col autofit-col-expand"><div class="autofit-section"><strong class="lead">Info</strong>List some libraries to exclude from Dymer import. [bootstrap,jquery,summernote,font-awesome] </div></div></div></div>
								<hr>


		</div>
		<div>
		  
		   <div class="position-relative row">
			  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="3" class="col-ddm col-md-12">
				 <div class="form-group form-inline input-checkbox-wrapper alert alert-warning">
					<i class="fa fas fa-bars" aria-hidden="true"></i>  <label for="showbread">
						<input class="field" 
							id="showbread" 
							name="<portlet:namespace/>showbread"
							type="checkbox"  
							<c:if test="${showbread_}">checked="checked"</c:if>/>
						<span class="">Show breadcrumbs</span>
					 </label>
				 </div>
			  </div>
			   
		   </div>
		  <hr>
		  
		   <div class="placeholder row">
		  	 <div data-ddm-field-column="1" data-ddm-field-page="0" data-ddm-field-row="3" class="col-ddm col-md-12 mb-2">
			  	 <div class="container_keyget bordercont row">
					<div class="col-12 span12">
						<label><liferay-ui:message key="label-dymer-keyget" /></label>
					    <textarea class="field form-control lfr-textarea" id="<portlet:namespace />keyget" name="<portlet:namespace />keyget"> <%=keyget%></textarea>
					</div>
			  	 </div>
		  	 </div>
		   </div>
		    <div class="alert alert-info" role="alert"><div class="alert-autofit-row autofit-row"><div class="autofit-col"><div class="autofit-section"><span class="alert-indicator"><svg class="lexicon-icon lexicon-icon-info-circle" role="presentation" viewBox="0 0 512 512">	<path class="lexicon-icon-outline" d="M437,75C388.7,26.6,324.4,0,256,0C187.6,0,123.3,26.6,75,75C26.6,123.3,0,187.6,0,256c0,68.4,26.6,132.7,75,181c48.4,48.4,112.6,75,181,75c68.4,0,132.7-26.6,181-75c48.4-48.4,75-112.6,75-181C512,187.6,485.4,123.3,437,75z M288,384c0,17.7-14.3,32-32,32c-17.7,0-32-14.3-32-32V224c0-17.7,14.3-32,32-32c17.7,0,32,14.3,32,32V384z M256,160c-17.7,0-32-14.3-32-32c0-17.7,14.3-32,32-32s32,14.3,32,32C288,145.7,273.7,160,256,160z"></path>
								</svg></span></div></div><div class="autofit-col autofit-col-expand"><div class="autofit-section"><strong class="lead">Info</strong>Use key in get request that contain the element's id  </div></div></div></div>
		   
		   <hr>
		    
			
			<div class="position-relative row">
			  
			  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="3" class="col-ddm col-md-12">
				 <div class="form-group form-inline input-checkbox-wrapper">
					 <label for="showbread">
						<input class="field" 
							id="showtour" 
							name="<portlet:namespace/>showtour"
							type="checkbox"  
							<c:if test="${showtour_}">checked="checked"</c:if>/>
						<span class="">Show tour</span>
					 </label>
				 </div>
			  </div>
			  
			  
			  
			  <div   class="col-ddm col-md-6 col-xs-12">
				 <div class="lfr-ddm-field-group field-wrapper"  >
				<span class="control-label" >
					<label>Dymer Tour Text</label>
			 	</span>
			  
		 		<textarea class="field form-control lfr-textarea" 
		 			id="<portlet:namespace />dymerTourText"  
		 			name="<portlet:namespace />dymerTourText"><%=dymerTourText%>
		 		</textarea>
		 	    <span class="btn badge badge-primary" id="setbutton"><i class="fas fa-paste"></i> Set Default</span>
		 	    <script>
                        $( document ).ready(function() {
				                 $('#setbutton').click(function() {
				    					var linktocopy='<div class="row" id="dymerTourContainer"><div class="col-12 col-md-12"><div class="alert alert-warning" role="alert"><p style="font-size:16px;" class=""> <a id="startTour"  > <i class="fa fa-info-circle" aria-hidden="true"></i> Take the tour !</a></p>  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">�</span></button></div></div></div>';
				              			
				    					$('#<portlet:namespace />dymerTourText').val(linktocopy);
				    			  });
	           			});	
		 	    </script>
			</div>
			  </div>
			  <div   class="col-ddm col-md-6 col-xs-12">
				   <div class="lfr-ddm-field-group field-wrapper"  >
				<span class="control-label" >
					<label>Dymer Tour json</label>
			 	</span>
			  
		 		<textarea class="field form-control lfr-textarea" 
		 			id="<portlet:namespace />dymerTour"  
		 			name="<portlet:namespace />dymerTour"><%=dymerTour%>
		 		</textarea>
		 		
		 		<span class="btn badge badge-success" id="setjson"><i class="fas fa-code"></i> Set JSON</span>
		 	    <script>
                        $( document ).ready(function() {
				                 $('#setjson').click(function() {
				    					var linktojson="{ title: 'Welcome',intro: 'Hello DIHIWARE User! ' }, { title: 'One Page Navigation',	element: document.querySelector('#primodfil'),  intro: 'List Button: use this to return in the main list view.'}, { title: 'Add Item',  element: document.querySelector('#cont-addentity'),intro: 'Use this button to insert a new catalogue item'},{ title: 'Content Section', element: document.querySelector('#cont-MyList'), intro: 'Catalogue item card or list. You can enter in the details of each element and come back to the main view.'}";
				              			
				    					$('#<portlet:namespace />dymerTour').val(linktojson);
				    			  });
	           			});	
		 	    </script>
			</div>
			  </div>
		   </div>	
			 <div class="alert alert-info" role="alert"><div class="alert-autofit-row autofit-row"><div class="autofit-col"><div class="autofit-section"><span class="alert-indicator"><svg class="lexicon-icon lexicon-icon-info-circle" role="presentation" viewBox="0 0 512 512">	<path class="lexicon-icon-outline" d="M437,75C388.7,26.6,324.4,0,256,0C187.6,0,123.3,26.6,75,75C26.6,123.3,0,187.6,0,256c0,68.4,26.6,132.7,75,181c48.4,48.4,112.6,75,181,75c68.4,0,132.7-26.6,181-75c48.4-48.4,75-112.6,75-181C512,187.6,485.4,123.3,437,75z M288,384c0,17.7-14.3,32-32,32c-17.7,0-32-14.3-32-32V224c0-17.7,14.3-32,32-32c17.7,0,32,14.3,32,32V384z M256,160c-17.7,0-32-14.3-32-32c0-17.7,14.3-32,32-32s32,14.3,32,32C288,145.7,273.7,160,256,160z"></path>
								</svg></span></div></div><div class="autofit-col autofit-col-expand"><div class="autofit-section"><strong class="lead">Info</strong>IntroJs configuration section. See tutorial and documentation <a href="https://introjs.com/docs/examples/basic/json-config" target="_blank">here</a>  </div></div></div></div>
			
			 <hr>
			
			<div class="lfr-ddm-field-group field-wrapper" class="col-ddm col-md-12">
				<span class="control-label" >
					<label>Free Config JSON</label>
			 	</span>
			  
		 		<textarea class="field form-control lfr-textarea" 
		 			id="<portlet:namespace />dymerFreeJSON"  
		 			name="<portlet:namespace />dymerFreeJSON"><%=dymerFreeJSON%>
		 		</textarea>
			</div>
			
			<div class="lfr-ddm-field-group field-wrapper" class="col-ddm col-md-12">
				<span class="control-label" >
					<label>Free Config HTML</label>
			 	</span>
			  
		 		<textarea class="field form-control lfr-textarea" 
		 			id="<portlet:namespace />dymerFreeHTML"  
		 			name="<portlet:namespace />dymerFreeHTML"><%=dymerFreeHTML%>
		 		</textarea>
			</div>
		   
		   <div class="placeholder row">
			  <div data-ddm-field-page="0" data-ddm-field-row="4" class="col col-ddm col-empty col-md-12">
				 <div class="ddm-target"></div>
			  </div>
		   </div>
		</div>
		 
		<div>
			<!------------------------------------------------------------ new search bar ------------------------------------------------------------->
			
			<fieldset aria-labelledby="newsearchbar" class="panel " id="newSearchbar" role="group">
		 		<div class="panel-heading" id="newSearchbarHeader" role="presentation">
					<div id="newSearchbarTitle">
						 <a aria-controls="newSearchbarContent" aria-expanded="false" class="collapse-icon sheet-subtitle collapsed" data-toggle="liferay-collapse" href="#VsearchbarContent" role="button">
							Vertical Search bar Configuration
		 					<span class="collapse-icon-closed" id="ffek____"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-right" focusable="false"><use href="/o/dihiware-theme/images/clay/icons.svg#angle-right"></use></svg></span>
							<span class="collapse-icon-open" id="qcss____"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-down" focusable="false"><use href="/o/dihiware-theme/images/clay/icons.svg#angle-down"></use></svg></span>
						 </a>
					</div>
				</div>

			<div aria-labelledby="newSearchbarHeader" class="panel-collapse collapse" id="VsearchbarContent" role="presentation" style="height: 0px;">
				<div class="panel-body">
					<div class="alert alert-info">
						Use the searchbar Vertical Widget URL to create a searchbar Widget.
					</div>
		 			<div class="form-group form-inline input-checkbox-wrapper">
						<label for="showfilter">
							<input class="field" 
								id="<portlet:namespace />showVerticalfilter" 
								name="<portlet:namespace />showVerticalfilter" 
								onclick="" 
								type="checkbox" <c:if test="${showVerticalfilter_}">checked="checked"</c:if>>
						 
								<span class="">
							 	Show search bar
					 	</span>
						</label>
			 		</div>
			 		
			 		<div class="lfr-ddm-field-group field-wrapper">
						<span class="control-label">
							PRE-CustomFilter
					 	</span>
			 			<textarea class="field form-control lfr-textarea" 
			 				id="<portlet:namespace />precustomfilter"  
			 				name="<portlet:namespace />precustomfilter"><%=precustomfilter%>
			 			</textarea>
					</div>	
			 		
			 		<div class="lfr-ddm-field-group field-wrapper">
						<span class="control-label">
							DymerSearch JSON Config
					 	</span>
					  
				 		<textarea class="field form-control lfr-textarea" 
				 			id="<portlet:namespace />dymerSearch"  
				 			name="<portlet:namespace />dymerSearch"><%=dymerSearch%>
				 		</textarea>
					</div>
			 		
			 		<div class="lfr-ddm-field-group field-wrapper">
						<span class="control-label">
							POST-CustomFilter
					 	</span>
			 			<textarea class="field form-control lfr-textarea" 
			 				id="<portlet:namespace />postcustomfilter"  
			 				name="<portlet:namespace />postcustomfilter"><%=postcustomfilter%>
			 			</textarea>
					</div>
			 		 
			 		               
		       </div>
			</div>
			</fieldset>
			<!------------------------------------------------------------ *End new search bar --------------------------------------------------------->
			
		 	
		
		
		
		
		
			<!------------------------------------------------------------ start tab search ------------------------------------------------------------>
			<fieldset aria-labelledby="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_searchbarTitle" class="panel " id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_searchbar" role="group" style="display:none;">
		 		<div class="panel-heading" id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_searchbarHeader" role="presentation">
					<div id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_searchbarTitle">
						 <a aria-controls="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_searchbarContent" aria-expanded="false" class="collapse-icon sheet-subtitle collapsed" data-toggle="liferay-collapse" href="#_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_searchbarContent" role="button">
							Search bar Configuration
		 					<span class="collapse-icon-closed" id="ffek____"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-right" focusable="false"><use href="/o/dihiware-theme/images/clay/icons.svg#angle-right"></use></svg></span>
							<span class="collapse-icon-open" id="qcss____"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-down" focusable="false"><use href="/o/dihiware-theme/images/clay/icons.svg#angle-down"></use></svg></span>
						 </a>
					</div>
				</div>

			<div aria-labelledby="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_searchbarHeader" class="panel-collapse collapse" id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_searchbarContent" role="presentation" style="height: 0px;">
				<div class="panel-body">
					<div class="alert alert-info">
						Use the searchbar Widget URL to create a searchbar Dymer Widget.
					</div>
		 			<div class="form-group form-inline input-checkbox-wrapper">
						<label for="showfilter">
							<input class="field" 
								id="<portlet:namespace />showfilter" 
								name="<portlet:namespace />showfilter" 
								onclick="" 
								type="checkbox" <c:if test="${showfilter_}">checked="checked"</c:if>>
						 
								<span class="">
							 	Show search bar
					 	</span>
						</label>
			 		</div>
			 		
			 		<div class="form-group form-inline input-checkbox-wrapper">
						<label for="expandedFilter">
							<input class="field" 
								id="<portlet:namespace />expandedFilter" 
								name="<portlet:namespace />expandedFilter" 
								onclick="" 
								type="checkbox" <c:if test="${expandedFilter_}">checked="checked"</c:if>>
						 
								<span class="">
							 	Enable Expanded Filter
					 	</span>
						</label>
			 		</div>
			 		<div class="form-group form-inline input-checkbox-wrapper">
						<label for="placeHolderFilter">
							<input class="field" 
								id="<portlet:namespace />placeHolderFilter" 
								name="<portlet:namespace />placeHolderFilter" 
								onclick="" 
								type="checkbox" <c:if test="${placeHolderFilter_}">checked="checked"</c:if>>
						 
								<span class="">
							 	PlaceHolder Filter
					 	</span>
						</label>
			 		</div>
			 		
			 		
			 		
			 		
			 		
			 		
			 		
					<div class="form-group c-mb-4 input-select-wrapper">
						<aui:select label="label-dymer-searchbar-type" name="dsearchtype" id="dsearchtype"   >
							<aui:option  value="freeinput" selected="${dsearchtype_ eq 'freeinput'}">
			                   	<liferay-ui:message key="openness.dymer.label.searchbarfreeinput" />
		                   	</aui:option>
		                   	<aui:option  value="snippets"  selected="${dsearchtype_ eq 'snippets'}">
		                   		<liferay-ui:message key="openness.dymer.label.searchbarforsnippets" />
		                   	</aui:option>
						</aui:select>
						 <h6>select <liferay-ui:message key="openness.dymer.label.searchbarfreeinput" /> to use global search</h6>
					</div>
					
		        	<div class="form-group input-resource-wrapper">
						<label class="control-label" for="keyurlget">Key get from Url (Global search)</label>
						<input class="form-control form-text lfr-input-resource " 
							id="<portlet:namespace />keyurlget" 
							name="<portlet:namespace />keyurlget" 
							type="text" 
							value="<%= keyurlget %>">
				  	</div>
					<div class="form-group input-resource-wrapper">
						<label class="control-label" for="filtermodel">
							Index Model to Filter
						</label>
						<input class="form-control form-text lfr-input-resource " 
							id="<portlet:namespace />filtermodel" 
							name="<portlet:namespace />filtermodel" 
							type="text" 
							value="<%= filtermodel %>">
					</div>
					<div class="lfr-ddm-field-group field-wrapper">
						<span class="control-label">
							BaseFilter
					 	</span>
				 		<textarea class="field form-control lfr-textarea" 
				 			id="<portlet:namespace />basefilter"  
				 			name="<portlet:namespace />basefilter"><%=basefilter%>
				 		</textarea>
					</div>
					<div class="lfr-ddm-field-group field-wrapper">
						<span class="control-label">
							CustomFilter
					 	</span>
			 			<textarea class="field form-control lfr-textarea" 
			 				id="<portlet:namespace />customfilter"  
			 				name="<portlet:namespace />customfilter"><%=customfilter%>
			 			</textarea>
					</div>		              
		       </div>
			</div>
			</fieldset>
		 	
			<!------------------------------------------------------------ end tab search ------------------------------------------------------------>
		 
		 	
		 	
		 	
		 	
		 	<!------------------------------------------------------------ start tab map ------------------------------------------------------------>
		    <fieldset aria-labelledby="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_MapTitle" class="panel " id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_Map" role="group">
		 	<div class="panel-heading" id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_MapHeader" role="presentation">
					<div id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_MapTitle">
						 <a aria-controls="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_MapContent" 
						 	aria-expanded="false" class="collapse-icon sheet-subtitle collapsed" 
						 	data-toggle="liferay-collapse" 
						 	href="#_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_MapContent" 
						 	role="button">Map & Data Table Configuration
			   				<span class="collapse-icon-closed" id="ffek____">
			   					<svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-right" focusable="false">
			   						<use href="/o/dihiware-theme/images/clay/icons.svg#angle-right"></use>
			   					</svg>
			   				</span>
			
							<span class="collapse-icon-open" id="qcss____">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-down" focusable="false">
									<use href="/o/dihiware-theme/images/clay/icons.svg#angle-down"></use></svg>
							</span>
						</a>
							
				 		
					</div>
				</div>
				<div aria-labelledby="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_MapHeader" 
					class="panel-collapse collapse" 
					id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_MapContent" 
					role="presentation" 
					style="height: 0px;">
					<div class="panel-body">
								<div class="alert alert-info">
									Use the Map Widget URL to create a map Dymer Widget.
								</div>
			  
			
			<div class="form-group c-mb-4 input-select-wrapper">
				
					<label class="control-label" for="dsearchtype">
						<liferay-ui:message key="label-dymer-typemapdt" />
			     	</label>
			     	<aui:select label="" inlineField="" name="typemapdt" id="<portlet:namespace />typemapdt"   >
						<aui:option  value="mapdt" selected="${typemapdt_ eq 'mapdt'}">
		                   	Map & DataTable
	                   	</aui:option>
	                   	<aui:option  value="map" selected="${typemapdt_ eq 'map'}">
		                   	Only Map
	                   	</aui:option>
	                   	<aui:option  value="dt" selected="${typemapdt_ eq 'dt'}">
		                   	Only DataTable
	                   	</aui:option>
					</aui:select>
			</div>
			
			<div class="lfr-ddm-field-group field-wrapper">
				<span class="control-label">
					<liferay-ui:message key="label-dymer-map-data-table" />
				</span>
				<label for="<portlet:namespace />dataTable"> <liferay-ui:message key="label-dymer-map-data-table-columns"/></label>
				<textarea class="field form-control lfr-textarea dymerTextarea" 
					id="<portlet:namespace />dataTable"
					name="<portlet:namespace />dataTable">${dataTable_}
				</textarea>
	 		</div>
			<div class="form-group c-mb-4 input-select-wrapper">
					<label class="control-label" for="dsearchtype">
						<liferay-ui:message key="label-dymer-map-style" />
			     	</label>
				       	<aui:select 
				       		label="" 
				       		inlineField=""
				       		name="dmapstyle" 
				       		id="<portlet:namespace/>dmapstyle">
									<aui:option  value="standard" selected="${dmapstyle_ eq 'classic'}">
					                   	Classic
				                   	</aui:option>
				                   	<aui:option  value="light" selected="${dmapstyle_ eq 'light'}">
					                   	Light
				                   	</aui:option>
				                   	<aui:option  value="topo" selected="${dmapstyle_ eq 'topo'}">
					                   	Topo
				                   	</aui:option>
				                   	<aui:option  value="esristreet" selected="${dmapstyle_ eq 'esristreet'}">
					                   	EsirStreet
				                   	</aui:option>
				                   	<aui:option  value="lightstar" selected="${dmapstyle_ eq 'lightstar'}">
					                   	LightStart
				                   	</aui:option>
				                   	<aui:option  value="esrimap" selected="${dmapstyle_ eq 'esrimap'}">
					                   	EsriMap
				                   	</aui:option>
								</aui:select>
					 </div>
					<div class="lfr-ddm-field-group field-wrapper">
						<span class="control-label">
							<liferay-ui:message key="label-dymer-map-data-marker" />
					 	</span>
					 	<!-- eliminare attributo class duplicato -->
				   		<textarea class="field form-control lfr-textarea dymerTextarea"  
				   			name="<portlet:namespace />map_markers" 
				   			class="field dymerTextarea" >${map_markers_}</textarea>
								Must be a json object
					 </div>
					 
					 <div class="lfr-ddm-field-group field-wrapper">
						<span class="control-label">
							<liferay-ui:message key="label-dymer-map-configuration" />
					 	</span>
				   		<textarea class="field form-control lfr-textarea dymerTextarea"  
				   			name="<portlet:namespace />map_configuration" 
				   			class="field dymerTextarea" >${map_configuration_}</textarea>
					 </div>
			       </div>
				</div>
			</fieldset>
		    <br>
		    <!------------------------------------------------------------ end tab map ------------------------------------------------------------>
		    
		    
		    
		   <fieldset  class="panel " id="header_footer_tab" role="group">
		 	<div class="panel-heading" id="header_footer_tab_Header" role="presentation">
					<div id="header_footer_tab_Title">
						 <a aria-controls="header_footer_tab_Content" 
						 	aria-expanded="false" class="collapse-icon sheet-subtitle collapsed" 
						 	data-toggle="liferay-collapse" 
						 	href="#header_footer_tab_Content" 
						 	role="button">Header & Footer HTML
			   				<span class="collapse-icon-closed" id="ffek____">
			   					<svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-right" focusable="false">
			   						<use href="/o/dihiware-theme/images/clay/icons.svg#angle-right"></use>
			   					</svg>
			   				</span>
			
							<span class="collapse-icon-open" id="qcss____">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-down" focusable="false">
									<use href="/o/dihiware-theme/images/clay/icons.svg#angle-down"></use></svg>
							</span>
						</a>
							
				 		
					</div>
				</div>
				<div aria-labelledby="header_footer_tab_ContentHeader" 
					class="panel-collapse collapse" 
					id="header_footer_tab_Content" 
					role="presentation" 
					style="height: 0px;">
					<div class="panel-body">
								<div class="alert alert-info">
									Header & Footer HTML
								</div>
			  
			                     <div   class="col-ddm col-md-12 col-xs-12">
										 <div class="lfr-ddm-field-group field-wrapper"  >
										<span class="control-label" >
											<label>HEADER HTML</label>
									 	</span>
									  
								 		<textarea class="field form-control lfr-textarea" 
								 			id="<portlet:namespace />dymerHeaderHtml"  
								 			name="<portlet:namespace />dymerHeaderHtml"><%=dymerHeaderHtml%>
								 		</textarea>
								 	    
								 	 
								 </div>
								  </div>
								  <div   class="col-ddm col-md-12 col-xs-12">
										   <div class="lfr-ddm-field-group field-wrapper"  >
										<span class="control-label" >
											<label>FOOTER HTML</label>
									 	</span>
									  
								 		<textarea class="field form-control lfr-textarea" 
								 			id="<portlet:namespace />dymerFooterHtml"  
								 			name="<portlet:namespace />dymerFooterHtml"><%=dymerFooterHtml%>
								 		</textarea>
								 		
								 		 
								 	    
									</div>
							 </div>
			
			         </div>
				</div>
			</fieldset> 
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		      
		    <br>
		    <div class="placeholder row">
			  <div data-ddm-field-page="0" data-ddm-field-row="6" class="col col-ddm col-empty col-md-12">
				 <div class="ddm-target"></div>
			  </div>
		    </div>
		</div>
	</div>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>
