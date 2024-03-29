
<%@ include file="/init.jsp" %>

<%
String redirectTo = request.getParameter("redirectTo");
String challengeId = request.getParameter("challengeId").toString();
Challenge challenge = ChallengeLocalServiceUtil.getChallenge(Long.parseLong(challengeId));
String participationURL = "";
int height = 0;
String folderTitle = challenge.getTitle().replaceAll("[^a-zA-Z0-9]", "_");
Folder cocreationFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "CO-CREATION");
Folder challengeFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), cocreationFolder.getFolderId(), folderTitle);
List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), challengeFolder.getFolderId());
int fileEntriesSize = 0;
for (FileEntry file : fileEntries) {    
	if (file.getFileName().startsWith(challenge.getTitle().replaceAll("[^a-zA-Z0-9]", "_"))){
		fileEntriesSize++;
	}
}
boolean readonly = true;
if (challenge.getUserId() == themeDisplay.getUserId()){
	readonly = false;
}
boolean isCocreator = false;
List<Cocreation> cocreations = CocreationLocalServiceUtil.getCocreationsByChallengeId(Long.parseLong(challengeId));
Iterator<Cocreation> cocreationsIt = cocreations.iterator();
while(cocreationsIt.hasNext()){
	Cocreation cocreation = cocreationsIt.next();
	List<Cocreator> cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(cocreation.getCocreationId());
	Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
	while(cocreatorsIt.hasNext()){
			Cocreator cocreator = cocreatorsIt.next();
			User userDisplay = UserLocalServiceUtil.getUserById(cocreator.getUserId());
			if (user.getUserId() == cocreator.getUserId()){
				/*L'utente loggato � uno dei co-creatori*/
				isCocreator = true;
			}		
	}
}
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
				<span class="co-title"><liferay-ui:message key="challengeDetails"/></span>
			</div><!-- w-1/2  END-->
			<div class="col col-lg-6 col-sm-6 col-6 col-md-12"> 
				<aui:nav cssClass="nav-tabs nav-co-tabs-not-sel">	
					<portlet:renderURL var="mycocreationsURL">
						<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
					</portlet:renderURL>
				</aui:nav>	
				<aui:nav cssClass="nav-tabs nav-co-tabs">
					<portlet:renderURL var="challengesURL">
						<portlet:param name="jspPage" value="/challenges.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=challengesURL%>" label="Challenges"/>
				</aui:nav>
				<aui:nav cssClass="nav-tabs nav-co-tabs-not-sel">
					<portlet:renderURL var="viewURL">
						<portlet:param name="jspPage" value="/view.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=viewURL%>" label="Help"/>
				</aui:nav>
			</div><!-- w-1/2 END -->
		</div>
   </div>
   <aui:form id="formChallenge" name="formChallenge" method="post" enctype="multipart/form-data" action="<%= updateChallengeURL.toString() %>">
   	   	<div class="row">
	   	   	   <div class="col-12 col-md-12">
		       		<div class="pb-2">     
				       <span><b><liferay-ui:message key="postedBy"/> : </b><a href="<%=UserLocalServiceUtil.getUserById(challenge.getUserId()).getDisplayURL(themeDisplay)%>"><%=challenge.getUserName()%></a></span>
				       <br>
				       <span><b><liferay-ui:message key="start"/> : </b><%=formatter.format(challenge.getStartDate()) %></span>
				       <br>
				       <span><b><liferay-ui:message key="end"/> : </b><%=formatter.format(challenge.getEndDate()) %></span>
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
		       			<%if (readonly){%>  
	           				<aui:input label="title" name="title" id="title" type="text" value="<%=challenge.getTitle()%>" readonly="true" cssClass="field disabled form-control"/>   			
	           			<%}else{%>
	           				<aui:input label="title" name="title" id="title" type="text" value="<%=challenge.getTitle()%>" required="true" />
	           			<%}%>
	           		</div>
			   </div>	
			   <div class="col-12 col-md-12"> 
			   <%if (readonly){%> 		
	    	   		<aui:input label="description" name="description" id="description" type="textarea" value="<%=challenge.getDescription()%>" readonly="true" cssClass="field disabled form-control"/>
	    	   <%}else{%> 
	    	   		<aui:input label="description" name="description" id="description" type="textarea" value="<%=challenge.getDescription()%>" required="true"/>
	    	   <%}%> 
			   </div>
			   <div class="col-12 col-md-12">
			   		<%if (readonly){%>
	    	   			<aui:input label="desiredOutcome" name="desiredOutcome" id="desiredOutcome" type="textarea" value="<%=challenge.getDesiredOutcome()%>" readonly="true" cssClass="field disabled form-control"/>
	    	   		<%}else{%>
	    	   			<aui:input label="desiredOutcome" name="desiredOutcome" id="desiredOutcome" type="textarea" value="<%=challenge.getDesiredOutcome()%>" required="true"/>
	    	   		<%}%>
			   </div>
			   <div class="col-12 col-md-12">
	       	   		<div class="pb-2">	
			   			<h3 class="sheet-subtitle"></h3>
			   		</div>
			   </div>
			   <div class="col-sm-6 col-md-6">
		           <div class=" pb-2 borderGroup">
		           <%if (readonly){%>
		           		  <aui:input label="location" name="location" id="location" type="text" value="<%=LocationLocalServiceUtil.getLocationByChallengeId(challenge.getChallengeId()).getName()%>" readonly="true" cssClass="field disabled form-control"/>
		           <%}else{%>
			          <aui:select label="location" id="location" name="location" showEmptyOption="false" required="true">
			          		<aui:option selected="<%=true%>" value="<%=LocationLocalServiceUtil.getLocationByChallengeId(challenge.getChallengeId()).getName()%>"><%=LocationLocalServiceUtil.getLocationByChallengeId(challenge.getChallengeId()).getName()%></aui:option>
						    <%
							for (Country country : countries) {
							%>
								<aui:option selected="<%=false%>" value="<%=country.getName()%>"><%=country.getName()%></aui:option>	
							<% 
							}
							%>
					  </aui:select>
				  <%}%>
				  </div>
			   </div>
			   <%-- <div class="col-sm-6 col-md-6">
		           <div class=" pb-2 borderGroup">
		           <%if (readonly){%>
		           		  <aui:input label="status" name="status" id="status" type="text" value="<%=challenge.getActive()%>" readonly="true" cssClass="field disabled form-control"/>
		           <%}else{%>
			           	  <aui:select label="Status" id="active" name="active" showEmptyOption="false" required="true">
							    <aui:option selected="<%=true%>" value="<%=challenge.getActive()%>"><%=challenge.getActive() == true ?  "Active" : "Inactive"%></aui:option>
							    <aui:option selected="<%=false%>" value="true">Active</aui:option>
							    <aui:option selected="<%=false%>" value="false">Inactive</aui:option>
						  </aui:select>
		           <%}%>
				  </div>
			   </div> --%>
			   <div class="col-sm-6 col-md-6">
		           <div class=" pb-2 borderGroup">
		           		  <aui:input label="status" name="status" id="status" type="text" value="<%=challenge.getEndDate().after(nowDate) == true ?  "Active" : "Inactive"%>" readonly="true" cssClass="field disabled form-control"/>
				  </div>
			   </div>
			   <h3 class="sheet-subtitle"></h3>
			   <div class="col-sm-6 col-md-6">
			        <div class=" pb-2 borderGroup">
			        	  <%if (readonly){%>	
			              		<label class="control-label">Tags</label>
			              		<select label="Tags*" id="tags" name="tags" showEmptyOption="false" multiple="true" style="width: 100%;" disabled="true">
								    <%
									for (AssetTag assetTag : assetTags) {
										if (assetTag.getGroupId() == themeDisplay.getScopeGroupId()){
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
									}
									%>
						  		</select>
			              <%}else{%>
			              		<label class="control-label">Tags*</label>
			              		<select label="Tags*" id="tags" name="tags" showEmptyOption="false" multiple="true" style="width: 100%;" required>
								    <%
									for (AssetTag assetTag : assetTags) {
										if (assetTag.getGroupId() == themeDisplay.getScopeGroupId()){
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
									}
									%>
						  		</select>
			              <%}%>
				          
					</div>
			    </div>
				<div class="col-sm-6 col-md-6">
			        <div class=" pb-2 borderGroup">
			        	  <%if (readonly){%>	
			              		<label class="control-label"><liferay-ui:message key="categories"/></label>
			              		<select label="" id="categories" name="categories" showEmptyOption="false" multiple="true" style="width: 100%;" disabled="true">
								    <%
									for (AssetCategory assetCategory : assetCategories) {
										if (assetCategory.getGroupId() == themeDisplay.getScopeGroupId()){
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
									}
									%>
							  </select>
			              <%}else{%>
			              		<label class="control-label"><liferay-ui:message key="categories"/>*</label>
			              		<select label="" id="categories" name="categories" showEmptyOption="false" multiple="true" style="width: 100%;" required>
								    <%
									for (AssetCategory assetCategory : assetCategories) {
										if (assetCategory.getGroupId() == themeDisplay.getScopeGroupId()){
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
									}
									%>
							  </select>
			              <%}%>
					</div>
			   </div>
			   <div class="col-12 col-md-12"> 
			   <%if (readonly){%> 		
	    	   		<aui:input label="additionalInformation" name="additionalInformation" id="additionalInformation" type="textarea" value="<%=challenge.getAdditionalInformation()%>" readonly="true" cssClass="field disabled form-control"/>
	    	   <%}else{%> 
	    	   		<aui:input label="additionalInformation" name="additionalInformation" id="additionalInformation" type="textarea" value="<%=challenge.getAdditionalInformation()%>"/>
	    	   <%}%> 
			   </div>
			   <div class="col-sm-6 col-md-6">
		           <div class=" pb-2 borderGroup">   
			  			<%if (!readonly){%>	
			            	<label class="control-label"><liferay-ui:message key="start"/>*</label>
			            <%}%>
			  			<%if (readonly){%>
			  				<aui:input name="startDate" id="startDate" type="text" value="<%=formatter.format(challenge.getStartDate())%>" readonly="true" cssClass="field disabled form-control"/>
						<%}else{%>
							<input id="startDate" name="startDate" class="form-control date" type="text" placeholder="dd/mm/yyyy" value="<%=formatter.format(challenge.getStartDate())%>" required='true'/>
							<%-- <input id="startDate" name="startDate" type="date" placeholder="dd/mm/yyyy" value="<%=formatter.format(challenge.getStartDate())%>" required='true' onchange="validateStartDate(this);"/> --%>
						<%}%>
					</div>
			   </div>		 
			   <div class="col-sm-6 col-md-6">
		           <div class=" pb-2 borderGroup">
			  		    <%if (!readonly){%>	
			            	<label class="control-label"><liferay-ui:message key="end"/>*</label>
			            <%}%>
			  			<%if (readonly){%>
			  				<aui:input name="endDate" id="endDate" type="text" value="<%=formatter.format(challenge.getEndDate())%>" readonly="true" cssClass="field disabled form-control"/>
	          	 		<%}else{%>
	          	 			<input id="endDate" name="endDate" class="form-control date" type="text" placeholder="dd/mm/yyyy" value="<%=formatter.format(challenge.getEndDate())%>" required='true'/>
	          	 			<%-- <input id="endDate" name="endDate" type="date" placeholder="dd/mm/yyyy" value="<%=formatter.format(challenge.getEndDate())%>" required='true' onchange="validateEndDate(this);"/> --%>
	          	 		<%}%>
	          	  </div>
	           </div>
			   <%if (isChallengeOwner || fileEntriesSize > 0){%>
				   <div class="col-12 col-md-12">
		       	   		<div class="pb-2">	
				   			<h3 class="sheet-subtitle"></h3>
				   		</div>
				   </div>
				    <div class="col-12 col-md-12">
		       	   		<div class="pb-2">	
		       	   			<%if (isChallengeOwner){%>
		       	   				<%if (themeDisplay.getUserId() == challenge.getUserId()){%>
									<h3 class="sheet-subtitle"><liferay-ui:message key="documentsPictures"/> <%=stringUploadMaxSize%>)</h3>
								<%}%>
							<%}else{%>					
								<h3 class="sheet-subtitle"><liferay-ui:message key="documentsPictures1"/></h3>
							<%}%>
							<% 
							String fileURL = "";
							for (FileEntry file : fileEntries) {    
								fileURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + file.getUuid();
								if (file.getFileName().startsWith(challenge.getTitle().replaceAll("[^a-zA-Z0-9]", "_"))){
								%>	
									<liferay-ui:icon target="_blank" label="<%= true %>" message="<%=file.getTitle() %>" url="<%= fileURL %>"/></br>
							 	<%
								}
							 }
							 %>
						</div>
				    </div>
		   		<%}%>	  
			    <%if (challenge.getUserId() == user.getUserId()){%>
				   <div class="col-sm-6 col-md-6">
			       	   <div class="pb-2">
			       			<div id="fileList"></div>
							<span style="display:block; height: 10px;"></span>
							<div class="btn-group">
								<label for="uploadedFile" class="btn btn-primary pull-left"><liferay-ui:message key="upload"/></label>
							    <div id="clearFileList" style="display:none">
									<liferay-ui:icon
											cssClass="btn-outline-info"
											id="clearFileListLink"
											image="delete"
											label="<%=true%>"
											url="javascript:void(0)" onClick="clearFileList();"  
									/> 
								</div>
							    <input type="file" id="uploadedFile" name="uploadedFile" style="visibility:hidden;" multiple="multiple" accept="video/*, image/*, .xlsx, .xls, .doc, .docx, .ppt, .pptx, .txt, .pdf" onchange="javascript:updateFileList()"/>
								
							</div>
						</div>
				   </div>
				   <div class="col-12 col-md-12">
	       	   		<div class="pb-2">	
			   			<h3 class="sheet-subtitle"></h3>
			   		</div>
			   </div>
			   <%}%>
			   <%if (challenge.getEndDate().after(nowDate) == true) {%>
				   <div class="col-12 col-md-12">
					 	<div class="pb-2">
					 		<aui:button-row>
					  			<div id="aui_popup_click">
					  				<%if (challenge.getUserId() == user.getUserId()){%>
					       				<aui:button type="button" value="inviteParticipants" cssClass="btn-outline-info"></aui:button>
					       			<%}else{
					       			    if (!isCocreator){%>
					       					<aui:button type="button" value="requestToCoCreate" cssClass="btn-outline-info"></aui:button>
					       			    <%}	
					       			 }%>
					   			</div>
					   			<div id="aui_popup_content" ></div>
					   			<%-- <%if (challenge.getUserId() != user.getUserId() && isCocreator){%>
					   				<aui:button type="button" value="requestToCoCreate" cssClass="btn-outline-info" disabled="true"></aui:button>
					   			<%}%> --%>
							</aui:button-row>  
						</div>
				   </div>
			   <%}else{%>
			   		<div class="col-12 col-md-12">
					 	<div class="pb-2">
					 		<aui:button-row>
					  			<div id="aui_popup_click">
					  				<%-- <%if (challenge.getUserId() == user.getUserId()){%>
					       				<aui:button type="button" value="inviteParticipants" cssClass="btn-outline-info" disabled="true"></aui:button>
					       			<%}else{
					       			    if (!isCocreator){%>
					       					<aui:button type="button" value="requestToCoCreate" cssClass="btn-outline-info" disabled="true"></aui:button>
					       			    <%}	
					       			 }%> --%>
					   			</div>
					   			<div id="aui_popup_content" ></div>
					   			<%-- <%if (challenge.getUserId() != user.getUserId() && isCocreator){%>
					   				<aui:button type="button" value="requestToCoCreate" cssClass="btn-outline-info" disabled="true"></aui:button>
					   			<%}%> --%>
							</aui:button-row>  
						</div>
				   </div>
				<%}%>		   
		 </div> 
         <div class="row">
       		<div class="col-12 col-md-12">
		       <aui:button-row>
		       		<%if (challenge.getUserId() == user.getUserId()){%>
			        	<aui:button type="submit" value="save" cssClass="btn-outline-info"></aui:button>
			        	<aui:button name="deleteChallenge" type="button" value="delete" onClick="javascript:deleteConfirmation();"/>
		        	<%}%>
		        	<aui:button name="cancel" type="button" value="cancel" onClick="<%=challengesURL%>"/>
		        </aui:button-row>
        	</div>
         </div>
         
  	</aui:form>
  	<%
	AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(Challenge.class.getName(), challenge.getChallengeId());
    Discussion discussion = CommentManagerUtil.getDiscussion(user.getUserId(), scopeGroupId, Challenge.class.getName(), entry.getEntryId(), new ServiceContextFunction(request));
    String currentURL = PortalUtil.getCurrentURL(request);
	currentURL = currentURL + "?challengeId="+challenge.getChallengeId();
	%>								
   	<liferay-ui:panel-container extended="<%=false%>" id="guestbookCollaborationPanelContainer" persistState="<%=true%>">
		<liferay-ui:panel collapsible="<%=true%>" extended="<%=true%>" id="guestbookCollaborationPanel" persistState="<%=true%>" title="">
  			<liferay-comment:discussion className="<%=Challenge.class.getName()%>"
						classPK="<%=entry.getClassPK()%>" 
						formName="fm2"
						discussion="<%= discussion %>"
						ratingsEnabled="<%=true%>" redirect="<%=currentURL%>"
						userId="<%=entry.getUserId()%>" />
		</liferay-ui:panel>
	</liferay-ui:panel-container>
</div>

<script type="text/javascript">
	function deleteConfirmation() {
		msg = "<%=deleteOperationConfirmation%>";
		if(confirm(msg)) {
			window.location.href = '<%=deleteChallengeURL.toString()%>';
		}else{
			return false;
		}
	}
</script>
 
<aui:script use="liferay-util-window">
	A.one("#aui_popup_click").on('click',function(event){
		<%if (challenge.getEndDate().after(nowDate) == true) {%>
			<%if(challenge.getUserId() == user.getUserId()){
				participationURL = inviteParticipantsURL.toString();
				height = 720;
			}else{
				participationURL = requestParticipationURL.toString();
				height = 620;
			}%>
		
			var popUpWindow=Liferay.Util.Window.getWindow(
				{
					dialog: {
						centered: true,
						constrain2view: true,					
						modal: true,
						resizable: true,
						width: 700,
						height: <%=height%>
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
			popUpWindow.titleNode.html("<%=requestToCoCreate%>");
		<%}%>
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

<script>
function validateStartDate(object){
	alert(object.value);
}
function validateEndDate(object){
	alert(object.value);
}
</script>
