<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<%
String redirectTo = request.getParameter("redirectTo");
String challengeId = request.getParameter("challengeId").toString();
Challenge challenge = ChallengeLocalServiceUtil.getChallenge(Long.parseLong(challengeId));
String participationURL = "";
String folderTitle = challenge.getTitle().replaceAll("[^a-zA-Z0-9]", "_");
Folder cocreationFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "CO-CREATION");
Folder challengeFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), cocreationFolder.getFolderId(), folderTitle);
List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), challengeFolder.getFolderId());
%>
<portlet:renderURL var="farmerProfile">
    <portlet:param name="jspPage" value="/farmerProfile.jsp" />
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="requestParticipationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/requestParticipation.jsp" />
    <portlet:param name="challengeId" value="<%=String.valueOf(challengeId)%>"/>
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="inviteParticipantsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/inviteParticipants.jsp" />
    <portlet:param name="challengeId" value="<%=String.valueOf(challengeId)%>"/>
    <portlet:param name="cocreationId" value="0"/>
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="deleteChallenge" var="deleteChallengeURL">
	<portlet:param name="challengeId" value="<%=String.valueOf(challengeId)%>"/>
	<portlet:param name="redirectTo" value="<%=redirectTo%>"/>
</portlet:actionURL>

<portlet:actionURL name="updateChallenge" var="updateChallengeURL">
	<portlet:param name="challengeId" value="<%=String.valueOf(challengeId)%>"/>
	<portlet:param name="redirectTo" value="<%=redirectTo%>"/>
</portlet:actionURL>

<liferay-ui:success key="actionSuccess" message="Operation performed"/>
<liferay-ui:error key="actionError" message="Operation performed"/>
<div id="details">
   <div class="container-fluid p-0 co-creation">
	   <div class="row mb-4 border-bottom">
			<div class="col col-lg-6 col-sm-6 col-6 col-md-12">
				<portlet:renderURL var="challengesURL">
					<portlet:param name="jspPage" value="/challenges.jsp"/>
				</portlet:renderURL>
				<portlet:renderURL var="cocreationsURL">
					<portlet:param name="redirectTo" value="<%=redirectTo%>"></portlet:param>
				</portlet:renderURL>
				<span class="co-title">Challenge details</span>
			</div><!-- w-1/2  END-->
			<div class="col col-lg-6 col-sm-6 col-6 col-md-12"> 
				  <aui:nav cssClass="nav-tabs nav-co-tabs">
					<portlet:renderURL var="challengesURL">
						<portlet:param name="jspPage" value="/challenges.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=challengesURL%>" label="Challenges"/>
				
					<portlet:renderURL var="mycocreationsURL">
						<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=mycocreationsURL%>" label="Co-Creations"/>
				</aui:nav>	
			</div><!-- w-1/2 END -->
		</div>
   </div>
   <aui:form id="formChallenge" name="fm" method="post" enctype="multipart/form-data" action="<%= updateChallengeURL.toString() %>">
   	   	<div class="row">
	   	   	   <div class="col-12 col-md-12">
		       		<div class="pb-2">     
				       <span><b>Posted by : </b><a href="<%=UserLocalServiceUtil.getUserById(challenge.getUserId()).getDisplayURL(themeDisplay)%>"><%=challenge.getUserName()%></a></span>
				       <br>
				       <span><b>Created on : </b><%=formatter.format(challenge.getCreateDate()) %></span>
				       <p></p>    
				    </div>
			   </div>
			   <div class="col-12 col-md-12">
	       	   		<div class="pb-2">	
			   			<h3 class="sheet-subtitle"></h3>
			   		</div>
			   </div>
		       <div class="col-12 col-md-12">
		       		<div class="pb-2">     
	           			<aui:input label="Title" name="title" id="title" type="text" value="<%=challenge.getTitle()%>" required="true"/>
	           		</div>
			   </div>	
			   <div class="col-12 col-md-12">
		       		<div class="pb-2">
	    	   			<aui:input label="Description" name="description" id="description" type="textarea" value="<%=challenge.getDescription()%>" required="true"/>
	    	   		</div>
			   </div>
			   <div class="col-12 col-md-12">
		       		<div class="pb-2">
	    	   			<aui:input label="Desired Outcome" name="desiredOutcome" id="desiredOutcome" type="textarea" value="<%=challenge.getDesiredOutcome()%>" required="true"/>
	    	   		</div>
			   </div>
			   <div class="col-12 col-md-12">
	       	   		<div class="pb-2">	
			   			<h3 class="sheet-subtitle"></h3>
			   		</div>
			   </div>
			   <div class="col-sm-6 col-md-6">
		           <div class=" pb-2 borderGroup">
			          <aui:select label="Location" id="location" name="location" showEmptyOption="false" required="true">
			          		<aui:option selected="<%=true%>" value="<%=LocationLocalServiceUtil.getLocationByChallengeId(challenge.getChallengeId()).getName()%>"><%=LocationLocalServiceUtil.getLocationByChallengeId(challenge.getChallengeId()).getName()%></aui:option>
						    <%
							for (Country country : countries) {
							%>
								<aui:option selected="<%=false%>" value="<%=country.getName()%>"><%=country.getName()%></aui:option>	
							<% 
							}
							%>
					  </aui:select>
				  </div>
			   </div>
			   <div class="col-sm-6 col-md-6">
		           <div class=" pb-2 borderGroup">
			          <aui:select label="Status" id="active" name="active" showEmptyOption="false" required="true">
						    <aui:option selected="<%=true%>" value="<%=challenge.getActive()%>"><%=challenge.getActive() == true ?  "Active" : "Inactive"%></aui:option>
						    <aui:option selected="<%=false%>" value="true">Active</aui:option>
						    <aui:option selected="<%=false%>" value="false">Inactive</aui:option>
					  </aui:select>
				  </div>
			   </div>
			   <h3 class="sheet-subtitle"></h3>
			   <div class="col-sm-6 col-md-6">
			        <div class=" pb-2 borderGroup">
			              <label class="control-label">Tags</label>
				          <select label="Tags" id="tags" name="tags" showEmptyOption="false" multiple="true" style="width: 100%;" required>
							    <%
								for (AssetTag assetTag : assetTags) {
									if (HashtagLocalServiceUtil.getHashtag(challenge.getChallengeId(), assetTag.getName()) == null){
									%>
										<option value="<%=assetTag.getName()%>"><%=assetTag.getName()%></option>	
									<% 
									}else{
									%>
										<option selected value="<%=assetTag.getName()%>"><%=assetTag.getName()%></option>	
									<%
									}
								}
								%>
						  </select>
					</div>
			    </div>
				<div class="col-sm-6 col-md-6">
			        <div class=" pb-2 borderGroup">
			        	  <label class="control-label">Categories</label>
				          <select label="Categories" id="categories" name="categories" showEmptyOption="false" multiple="true" style="width: 100%;" required>
							    <%
								for (AssetCategory assetCategory : assetCategories) {
									if (CategoryLocalServiceUtil.getCategory(challenge.getChallengeId(), assetCategory.getName()) == null){
									%>
										<option value="<%=assetCategory.getName()%>"><%=assetCategory.getName()%></option>	
									<%
									}else{
									%>
										<option selected value="<%=assetCategory.getName()%>"><%=assetCategory.getName()%></option>	
									<%
									}
								}
								%>
						  </select>
					</div>
			   </div>
			   <div class="col-sm-6 col-md-6">
		           <div class=" pb-2 borderGroup">   
			  			<label class="control-label">Start Date</label>
			  			<input id="startDate" name="startDate" class="form-control date" type="text" placeholder="dd/mm/yyyy" value="<%=formatter.format(challenge.getStartDate())%>" required='true'>
					</div>
			   </div>		 
			   <div class="col-sm-6 col-md-6">
		           <div class=" pb-2 borderGroup">
			  			<label class="control-label">End Date</label>
			  			<input id="endDate" name="endDate" class="form-control date" type="text" placeholder="dd/mm/yyyy" value="<%=formatter.format(challenge.getEndDate())%>" required='true'>
	          	  </div>
	           </div>
			   <div class="col-12 col-md-12">
	       	   		<div class="pb-2">	
			   			<h3 class="sheet-subtitle"></h3>
			   		</div>
			   </div>
		       <div class="col-12 col-md-12">
	       	   		<div class="pb-2">	
						<h3 class="sheet-subtitle">View pictures</h3>
						<% 
						String fileURL = "";
						for (FileEntry file : fileEntries) {    
							fileURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + file.getUuid();
							if (file.getMimeType().equalsIgnoreCase("image/jpeg") && file.getFileName().startsWith("CHALLENGE_")){
							%>	
								<liferay-ui:icon target="_blank" label="<%= true %>" message="<%=file.getTitle() %>" url="<%= fileURL %>"/></br>
						 	<%
							}
						 }
						 %>
					</div>
			   </div>
			   <div class="col-12 col-md-12">
	       	   		<div class="pb-2">	
			   			<h3 class="sheet-subtitle"></h3>
			   		</div>
			   </div>
			   <div class="col-12 col-md-12">
	       	   		<div class="pb-2">	
						<h3 class="sheet-subtitle">Download documents</h3>
						<% 
						for (FileEntry file : fileEntries) {    
							fileURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + file.getUuid();
							if (!file.getMimeType().equalsIgnoreCase("image/jpeg") && file.getFileName().startsWith("CHALLENGE_")){
							%>	
								<liferay-ui:icon target="_blank" label="<%= true %>" message="<%=file.getTitle() %>" url="<%= fileURL %>"/></br>
						 	<%
							}
						 }
						 %>
					</div>
			   </div>
			   <div class="col-12 col-md-12">
	       	   		<div class="pb-2">	
			   			<h3 class="sheet-subtitle"></h3>
			   		</div>
			   </div>
			   <%if((challenge.getUserId() == user.getUserId()) || isSiteOwner){%>
				   <div class="col-sm-6 col-md-6">
			       	   <div class="pb-2">
			       			<div id="fileList"></div>
							<span style="display:block; height: 10px;"></span>
							<div class="btn-group">
								<label for="uploadedFile" class="btn btn-primary pull-left">Upload pictures and documents</label>
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
				   </div>
				   <div class="col-12 col-md-12">
	       	   		<div class="pb-2">	
			   			<h3 class="sheet-subtitle"></h3>
			   		</div>
			   </div>
			   <%}%>
			   <div class="col-12 col-md-12">
				 	<div class="pb-2">
				 		<aui:button-row>
				  			<div id="aui_popup_click">
				       			<aui:button type="button" value="Request to Co-Create" cssClass="btn-outline-info"></aui:button>
				   			</div>
				   			<div id="aui_popup_content" ></div>
						</aui:button-row>  
					</div>
			   </div>
		 </div>
       	 <%if(user != null){
       		if((challenge.getUserId() == user.getUserId()) || isSiteOwner){%>
		        <div class="row">
		       		<div class="col-12 col-md-12">
				       <aui:button-row>
				        	<aui:button type="submit" value="Update" cssClass="btn-outline-info"></aui:button>
				        	<aui:button name="deleteChallenge" type="button" value="Delete"  onClick="<%=\"window.location.href='\"+deleteChallengeURL.toString() +\"'\"%>"/>
				        </aui:button-row>
		        	</div>
		        </div>
        	<%}%>
         <%}%>
  	</aui:form>
</div>
 
<aui:script use="liferay-util-window">
	A.one("#aui_popup_click").on('click',function(event){
		
		<%if((challenge.getUserId() == user.getUserId()) || isSiteOwner){
			participationURL = inviteParticipantsURL.toString();
		}else{
			participationURL = requestParticipationURL.toString();
		}%>
	
		var popUpWindow=Liferay.Util.Window.getWindow(
			{
				dialog: {
					centered: true,
					constrain2view: true,					
					modal: true,
					resizable: false,
					width: 500
				}
			}
		).plug(
			A.Plugin.DialogIframe,
			{
				autoLoad: true,
				uri:"<%=participationURL%>"
			}
		).render();
		popUpWindow.show(popUpWindow);
		popUpWindow.titleNode.html("Request to Co-Create");
	});
	
	AUI().use(
        'aui-datepicker',
        function(A) {
            new A.DatePicker({
                trigger: '.date',
                mask: '%d/%m/%Y',
                popover: {
                    zIndex: 1000
                }
            });
        }
    );
</aui:script>
