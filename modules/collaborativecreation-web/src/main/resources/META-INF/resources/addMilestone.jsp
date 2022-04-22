<%@ include file="/init.jsp" %>

<%
String redirectTo = request.getParameter("redirectTo");
long challengeId = ParamUtil.getLong(request, "challengeId");
long cocreationId = ParamUtil.getLong(request, "cocreationId");
List<User> users = UserLocalServiceUtil.getGroupUsers(themeDisplay.getScopeGroupId());
User currentUser = themeDisplay.getUser();
%>

<portlet:actionURL name="addMilestone" var="addMilestoneURL">
	<portlet:param name="active" value="true"/>
	<portlet:param name="challengeId" value="<%=String.valueOf(challengeId)%>"/>
	<portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
	<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:actionURL>

<liferay-ui:success key="actionSuccess" message="Operation performed"/>
<liferay-ui:error key="actionError" message="Operation performed"/>

<div id="milestoneFormContainer">
	<aui:form id="formMilestone" name="formMilestone" method="post" action="<%=addMilestoneURL.toString()%>">
		<aui:fieldset>
			<div class="clearfix" style="margin-right:20px; margin-left:20px;">
	             <div>
	             	<aui:input label="Co-creation" name="cocreation" id="cocreation" readonly="true" value="<%=CocreationLocalServiceUtil.getCocreation(cocreationId).getTitle()%>"/>
	             </div>
	             <div>
	             	<aui:input label="Description" name="description" id="description" type="text" required='true'/>
	             </div>
	             <div>
	             	<aui:select label="Invite Participants" name="participants" id="participants" showEmptyOption="false" multiple="true" required="true">
	             		<aui:option selected="<%=true%>" value="">Select...</aui:option>
						<%
						for (User groupUser : users) {
						%>
							<aui:option value="<%=groupUser.getUserId()%>"><%=groupUser.getFullName()%> - <%=groupUser.getEmailAddress()%></aui:option>
						<%
						}
						%>
				   </aui:select>
	             </div> 
	             <div>  
		  			<label class="control-label">Expiration Date*</label>
		  			<input id="expirationDate" name="expirationDate" class="form-control date" type="text" placeholder="dd/mm/yyyy" value="" required='true'>
			     </div> 
	             <div id="fileList"></div>
			     <span style="display:block; height: 10px;"></span>
			     <div class="btn-group">
					<label for="uploadedFile" class="btn btn-primary pull-left">Upload documents</label>
				    <div id="clearFileList" style="display:none">
						<liferay-ui:icon
								cssClass="btn-outline-info"
								id="clearFileListLink"
								image="delete"
								label="<%=true%>"
								url="javascript:void(0)" onClick="clearFileList();"  
					    /> 
				    </div>
				    <input type="file" id="uploadedFile" name="uploadedFile" style="visibility:hidden;" multiple="multiple" accept="image/*, .xlsx, .xls, .doc, .docx, .ppt, .pptx, .txt, .pdf" onchange="javascript:updateFileList()"/>
		         </div>    
		    </div>            
		</aui:fieldset>
		<aui:button-row>
		  	<div id="aui_popup_click">
		       	<aui:button id="saveForm" name="saveForm" type="submit" value="Publish" cssClass="btn-outline-info"></aui:button>
		       	<aui:button id="closePopup" name="closePopup" type="button" value="Close and Refresh" cssClass="btn-outline-info"></aui:button>
		   	</div>
		   	<div id="aui_popup_content" ></div>
		</aui:button-row>
	</aui:form>      
</div>

<aui:script use="aui-io-request,aui-node" >
	A.one('#<portlet:namespace/>closePopup').on('click',function(event){
		Liferay.Util.getOpener().refreshPortlet();
	});
</aui:script>