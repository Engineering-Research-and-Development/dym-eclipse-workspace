<%@ include file="/init.jsp" %>

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
    
    	<!-- accordion start -->
    	
    	<fieldset aria-labelledby="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_generalTitle" class="panel " id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_general" role="group">
	 		<div class="panel-heading" id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_generalHeader" role="presentation">
				<div id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_generalTitle">
					 <a aria-controls="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_generalContent" aria-expanded="false" class="collapse-icon sheet-subtitle collapsed" data-toggle="liferay-collapse" href="#_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_generalContent" role="button">
						<liferay-ui:message key="general-configuration"/>
	 					<span class="collapse-icon-closed" id="gffek____"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-right" focusable="false"><use href="/o/dihiware-theme/images/clay/icons.svg#angle-right"></use></svg></span>
						<span class="collapse-icon-open" id="gqcss____"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-down" focusable="false"><use href="/o/dihiware-theme/images/clay/icons.svg#angle-down"></use></svg></span>
					 </a>
				</div>
			</div>

			<div aria-labelledby="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_generalHeader" class="panel-collapse collapse" id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_generalContent" role="presentation" style="height: 0px;">
				<div class="panel-body">
					<div class="alert alert-info">
						<liferay-ui:message key="use-this-configuration-widget-to-send-requests-to-identity-manager"/>
					</div>
		 			
<!-- 		 			<div> -->
<!-- 					   <div class="position-relative row"> -->
<!-- 						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="0" class="col-ddm col-md-12"> -->
<!-- 							 <div class="ddm-field-container ddm-target h-100" data-field-name="Field95292365"> -->
<!-- 								<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="0"></div> -->
<!-- 								<div class="ddm-drag"> -->
<!-- 								   <div class="ddm-field" data-field-name="Field95292365"> -->
<!-- 									  <div class="form-group"  -->
<!-- 									  		data-field-name="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field95292365$LtunLVJm$0$$en_US"> -->
<!-- 										 <label aria-describedby="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field95292365$LtunLVJm$0$$en_US_fieldDetails" class="ddm-label" tabindex="0">General Configuration</label> -->
<!-- 										 <div class="separator" style=""></div> -->
<!-- 										 <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field95292365$LtunLVJm$0$$en_US_fieldDetails">General Configuration<br></span> -->
<!-- 									  </div> -->
<!-- 								   </div> -->
<!-- 								</div> -->
<!-- 								<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="0"></div> -->
<!-- 							 </div> -->
<!-- 						  </div> -->
<!-- 					   </div> -->
<!-- 					   <div class="placeholder row"> -->
<!-- 						  <div data-ddm-field-page="0" data-ddm-field-row="1" class="col col-ddm col-empty col-md-12"> -->
<!-- 							 <div class="ddm-target"></div> -->
<!-- 						  </div> -->
<!-- 					   </div> -->
<!-- 					</div> -->
			    
			    	<div>
					   <div class="placeholder row">
					  	 <div data-ddm-field-column="1" data-ddm-field-page="0" data-ddm-field-row="3" class="col-ddm col-md-12">
						  	 <div class="container_keyget bordercont row">
								<div class="col-12 span12">
									<label><liferay-ui:message key="identity-manager-admin-e-mail"/></label>
								    <input class="form-control form-text lfr-input-resource " 
										id="<portlet:namespace />idmEmailAdmin" 
										name="<portlet:namespace />idmEmailAdmin" 
										type="text" 
										value="<%= idmEmailAdmin %>">
								</div>
						  	 </div>
					  	 </div>
					   </div>
					   <div class="placeholder row">
					  	 <div data-ddm-field-column="1" data-ddm-field-page="0" data-ddm-field-row="3" class="col-ddm col-md-12">
						  	 <div class="container_keyget bordercont row">
								<div class="col-12 span12">
									<label><liferay-ui:message key="identity-manager-admin-e-mail-notification"/></label>
								    <input class="form-control form-text lfr-input-resource " 
										id="<portlet:namespace />idmEmailAdminNotification" 
										name="<portlet:namespace />idmEmailAdminNotification" 
										type="text" 
										value="<%= idmEmailAdminNotification %>">
								</div>
						  	 </div>
					  	 </div>
					   </div>
					   <div class="placeholder row">
					  	 <div data-ddm-field-column="1" data-ddm-field-page="0" data-ddm-field-row="3" class="col-ddm col-md-12">
						  	 <div class="container_keyget bordercont row">
								<div class="col-12 span12">
									<label><liferay-ui:message key="identity-manager-admin-password"/></label>
								    <input class="form-control form-text lfr-input-resource " 
										id="<portlet:namespace />idmPasswordAdmin" 
										name="<portlet:namespace />idmPasswordAdmin" 
										type="password" 
										value="<%= idmPasswordAdmin %>">
								</div>
						  	 </div>
					  	 </div>
					   </div>
					   
					   <div class="placeholder" >
							<div class="row ">
								<div class="col-10 idmEnableContentLabel">  
									<span>
										<label class="control-label" >
											<liferay-ui:message key="enable-self-registering-users-on-identity-manager"/>
										</label>
									</span> 
								</div>
								<div class="col-2">
									<label class="switch2">
										<input 
											id="<portlet:namespace />idmEnable" 
											name="<portlet:namespace />idmEnable" 
											onclick="" 
											type="checkbox" 
											<% 
												if(idmEnable_) { 
											%>
											checked="checked"
											<% } %>>
									  <span class="slider2"></span>
									</label>
								</div>
							</div>
						</div>
					   
					   
					   <div class="placeholder row">
						 <div data-ddm-field-column="1" data-ddm-field-page="0" data-ddm-field-row="3" class="col-ddm col-md-12">
							 <div class="container_keyget bordercont row">
								<div class="col-12 span12">
									<label><liferay-ui:message key="template-id"/></label>
									<input class="form-control form-text lfr-input-resource " 
										id="<portlet:namespace />templateID" 
										name="<portlet:namespace />templateID" 
										type="text" 
										value="<%= templateID %>">
								</div>
							 </div>
						 </div>
					   
					</div>
			 		
						              
		       </div>
			</div>
		</fieldset>
		
		<fieldset aria-labelledby="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_templateTitle" class="panel " id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_template" role="group">
	 		<div class="panel-heading" id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_templateHeader" role="presentation">
				<div id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_templateTitle">
					 <a aria-controls="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_templateContent" aria-expanded="false" class="collapse-icon sheet-subtitle collapsed" data-toggle="liferay-collapse" href="#_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_templateContent" role="button">
						<liferay-ui:message key="template-configuration"/>
	 					<span class="collapse-icon-closed" id="ffek____"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-right" focusable="false"><use href="/o/dihiware-theme/images/clay/icons.svg#angle-right"></use></svg></span>
						<span class="collapse-icon-open" id="qcss____"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-down" focusable="false"><use href="/o/dihiware-theme/images/clay/icons.svg#angle-down"></use></svg></span>
					 </a>
				</div>
			</div>

			<div aria-labelledby="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_templateHeader" class="panel-collapse collapse" id="_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_templateContent" role="presentation" style="height: 0px;">
				<div class="panel-body">
					<div class="alert alert-info">
						<liferay-ui:message key="use-this-configuration-widget-to-customize-a-registration-template"/>
					</div>
		 			
		 			<div>
					   <div class="position-relative row">
						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-12">
							 <div class="ddm-field-container ddm-target h-100" data-field-name="Field63772425">
								<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
								<div class="ddm-drag">
								   <div class="ddm-field" data-field-name="Field63772425">
									  <div class="form-group"  ><label class="ddm-label" tabindex="0"><liferay-ui:message key="subject-mail"/></label>
									  <input name="<portlet:namespace />mailSubject" type="text"  value="<%=mailSubject%>"class="form-control ddm-field-text">
									  <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field63772425$kUjcTyrP$0$$en_US_fieldDetails"><br></span></div>
								   </div>
								</div>
								<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
							 </div>
						  </div>
					    </div>
					</div>
					
					<div>
					   <div class="position-relative row">
						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-12">
							 <div class="ddm-field-container ddm-target h-100" data-field-name="Field63772425">
								<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
								<div class="ddm-drag">
								   <div class="ddm-field" data-field-name="Field63772425">
									  <div class="form-group"  ><label class="ddm-label" tabindex="0"><liferay-ui:message key="from"/></label>
									  <input name="<portlet:namespace />from" type="text"  value="<%=from%>"class="form-control ddm-field-text">
									  <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field63772425$kUjcTyrP$0$$en_US_fieldDetails"><br></span></div>
								   </div>
								</div>
								<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
							 </div>
						  </div>
					    </div>
					</div>
					
					<div>
					   <div class="position-relative row">
						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-12">
							 <div class="ddm-field-container ddm-target h-100" data-field-name="Field63772425">
								<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
								<div class="ddm-drag">
								   <div class="ddm-field" data-field-name="Field63772425">
									  <div class="form-group"  ><label class="ddm-label" tabindex="0"><liferay-ui:message key="project-name"/></label>
									  <input name="<portlet:namespace />projectName" type="text"  value="<%=projectName%>"class="form-control ddm-field-text">
									  <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field63772425$kUjcTyrP$0$$en_US_fieldDetails"><br></span></div>
								   </div>
								</div>
								<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
							 </div>
						  </div>
					    </div>
					</div>
					
					<div>
					   <div class="position-relative row">
						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-12">
							 <div class="ddm-field-container ddm-target h-100" data-field-name="Field63772425">
								<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
								<div class="ddm-drag">
								   <div class="ddm-field" data-field-name="Field63772425">
									  <div class="form-group"  ><label class="ddm-label" tabindex="0"><liferay-ui:message key="liferay-portal-logo-url"/></label>
									  <input name="<portlet:namespace />logoLiferayPortalUrl" type="text"  value="<%=logoLiferayPortalUrl%>"class="form-control ddm-field-text">
									  <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field63772425$kUjcTyrP$0$$en_US_fieldDetails"><br></span></div>
								   </div>
								</div>
								<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
							 </div>
						  </div>
					    </div>
					</div>
					
					<div>
					   <div class="position-relative row">
						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-12">
							 <div class="ddm-field-container ddm-target h-100" data-field-name="Field63772425">
								<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
								<div class="ddm-drag">
								   <div class="ddm-field" data-field-name="Field63772425">
									  <div class="form-group"  ><label class="ddm-label" tabindex="0"><liferay-ui:message key="liferay-portal-name"/></label>
									  <input name="<portlet:namespace />liferayPortalName" type="text"  value="<%=liferayPortalName%>"class="form-control ddm-field-text">
									  <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field63772425$kUjcTyrP$0$$en_US_fieldDetails"><br></span></div>
								   </div>
								</div>
								<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
							 </div>
						  </div>
					    </div>
					</div>
					
					<div>
					   <div class="position-relative row">
						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-12">
							 <div class="ddm-field-container ddm-target h-100" data-field-name="Field63772425">
								<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
								<div class="ddm-drag">
								   <div class="ddm-field" data-field-name="Field63772425">
									  <div class="form-group"  ><label class="ddm-label" tabindex="0"><liferay-ui:message key="liferay-portal-url"/></label>
									  <input name="<portlet:namespace />liferayPortalUrl" type="text"  value="<%=liferayPortalUrl%>"class="form-control ddm-field-text">
									  <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field63772425$kUjcTyrP$0$$en_US_fieldDetails"><br></span></div>
								   </div>
								</div>
								<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
							 </div>
						  </div>
					    </div>
					</div>
					
					<div>
					   <div class="position-relative row">
						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-12">
							 <div class="ddm-field-container ddm-target h-100" data-field-name="Field63772425">
								<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
								<div class="ddm-drag">
								   <div class="ddm-field" data-field-name="Field63772425">
									  <div class="form-group"  ><label class="ddm-label" tabindex="0"><liferay-ui:message key="identity-manager-url"/></label>
									  <input name="<portlet:namespace />idmUrl" type="text"  value="<%=idmUrl%>"class="form-control ddm-field-text">
									  <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field63772425$kUjcTyrP$0$$en_US_fieldDetails"><br></span></div>
								   </div>
								</div>
								<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
							 </div>
						  </div>
					    </div>
					</div>
					
					<div>
					   <div class="position-relative row">
						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-12">
							<div class="form-group input-text-wrapper">
								<label class="control-label" for=""><liferay-ui:message key="organization-type-list"/>
										<span class="taglib-icon-help lfr-portal-tooltip" title="Enter the default organization type names">
									<span id="fehs____"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-question-circle-full" focusable="false"><use href="http://localhost:8080/o/admin-theme/images/clay/icons.svg#question-circle-full"></use></svg></span>	
									</span>
								</label>
								<textarea class="field form-control" id="<portlet:namespace />organizationTypelist" name="<portlet:namespace />organizationTypelist"><%=organizationTypelist%></textarea>
							</div>
						</div>
					    </div>
					</div>
					
					<div>
					   <div class="position-relative row">
						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-12">
							 <div class="ddm-field-container ddm-target h-100" data-field-name="Field63772425">
								<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
								<div class="ddm-drag">
								   <div class="ddm-field" data-field-name="Field63772425">
									  <div class="form-group"  ><label class="ddm-label" tabindex="0"><liferay-ui:message key="terms-of-use-url"/></label>
									  <input name="<portlet:namespace />termsOfUseUrl" type="text"  value="<%=termsOfUseUrl%>"class="form-control ddm-field-text">
									  <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field63772425$kUjcTyrP$0$$en_US_fieldDetails"><br></span></div>
								   </div>
								</div>
								<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
							 </div>
						  </div>
					    </div>
					</div>
					
					<div>
					   <div class="position-relative row">
						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-12">
							 <div class="ddm-field-container ddm-target h-100" data-field-name="Field63772425">
								<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
								<div class="ddm-drag">
								   <div class="ddm-field" data-field-name="Field63772425">
									  <div class="form-group"  ><label class="ddm-label" tabindex="0"><liferay-ui:message key="copyright-company"/></label>
									  <input name="<portlet:namespace />copyrightCompany" type="text"  value="<%=copyrightCompany%>"class="form-control ddm-field-text">
									  <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field63772425$kUjcTyrP$0$$en_US_fieldDetails"><br></span></div>
								   </div>
								</div>
								<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
							 </div>
						  </div>
					    </div>
					</div>
			 		
			 		<div>
					   <div class="position-relative row">
						  <div data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1" class="col-ddm col-md-12">
							 <div class="ddm-field-container ddm-target h-100" data-field-name="Field63772425">
								<div class="ddm-resize-handle ddm-resize-handle-left hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
								<div class="ddm-drag">
								   <div class="ddm-field" data-field-name="Field63772425">
									  <div class="form-group"  ><label class="ddm-label" tabindex="0"><liferay-ui:message key="copyright-company-url"/></label>
									  <input name="<portlet:namespace />copyrightCompanyUrl" type="text"  value="<%=copyrightCompanyUrl%>"class="form-control ddm-field-text">
									  <span class="sr-only" id="_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_ddm$$Field63772425$kUjcTyrP$0$$en_US_fieldDetails"><br></span></div>
								   </div>
								</div>
								<div class="ddm-resize-handle ddm-resize-handle-right hide" data-ddm-field-column="0" data-ddm-field-page="0" data-ddm-field-row="1"></div>
							 </div>
						  </div>
					    </div>
					</div>
						              
		       </div>
			</div>
		</fieldset>
		   
		   
		   <div class="placeholder row">
			  <div data-ddm-field-page="0" data-ddm-field-row="4" class="col col-ddm col-empty col-md-12">
				 <div class="ddm-target"></div>
			  </div>
		   </div>
		</div>
		 
		<div>
			 
		</div>
		
		<br><br><br>
	</div>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>
 <!-- 050922 -->