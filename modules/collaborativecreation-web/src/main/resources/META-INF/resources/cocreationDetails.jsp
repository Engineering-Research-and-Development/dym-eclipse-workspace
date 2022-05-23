<%@ include file="/init.jsp" %>
	
<%
String participationURL = "";
int height = 0;
String redirectTo = request.getParameter("redirectTo");
String cocreationId = request.getParameter("cocreationId").toString();
String challengeTitle = request.getParameter("challengeTitle").toString();
String desiredOutcome = request.getParameter("desiredOutcome").toString();
Cocreation cocreation = CocreationLocalServiceUtil.getCocreation(Long.parseLong(cocreationId));
String folderTitle = challengeTitle.replaceAll("[^a-zA-Z0-9]", "_");
Folder cocreationFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "CO-CREATION");
Folder challengeFolder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), cocreationFolder.getFolderId(), folderTitle);
List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), challengeFolder.getFolderId());
List<Activity> milestones = ActivityLocalServiceUtil.getActivitiesByCocreationId(Long.parseLong(cocreationId));
List<Task> toDos = TaskLocalServiceUtil.getTasksByCocreationId(Long.parseLong(cocreationId), user.getUserId());
boolean isCocreator = false;
%>

<portlet:renderURL var="farmerProfile">
    <portlet:param name="jspPage" value="/farmerProfile.jsp" />
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="addMilestoneURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/addMilestone.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addToDoURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/addToDo.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addQuestionAndFeedbackURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/addQuestionAndFeedback.jsp" />
</portlet:renderURL>
<portlet:renderURL var="requestParticipationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/requestParticipation.jsp" />
    <portlet:param name="challengeId" value="<%=String.valueOf(ChallengeLocalServiceUtil.getChallengeByCocreationId(Long.parseLong(cocreationId), themeDisplay.getScopeGroupId()).getChallengeId())%>"/>
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="inviteParticipantsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/inviteParticipants.jsp" />
    <portlet:param name="challengeId" value="<%=String.valueOf(ChallengeLocalServiceUtil.getChallengeByCocreationId(Long.parseLong(cocreationId), themeDisplay.getScopeGroupId()).getChallengeId())%>"/>
    <portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="deleteConfirmationURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/deleteConfirmation.jsp" />
    <portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
</portlet:renderURL>
<portlet:renderURL var="addMilestoneURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/addMilestone.jsp" />
    <portlet:param name="challengeId" value="<%=String.valueOf(ChallengeLocalServiceUtil.getChallengeByCocreationId(Long.parseLong(cocreationId), themeDisplay.getScopeGroupId()).getChallengeId())%>"/>
    <portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="addToDoURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/addToDo.jsp" />
    <portlet:param name="challengeId" value="<%=String.valueOf(ChallengeLocalServiceUtil.getChallengeByCocreationId(Long.parseLong(cocreationId), themeDisplay.getScopeGroupId()).getChallengeId())%>"/>
    <portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="addQuestionFeedbackURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/addQuestionFeedback.jsp" />
    <portlet:param name="challengeId" value="<%=String.valueOf(ChallengeLocalServiceUtil.getChallengeByCocreationId(Long.parseLong(cocreationId), themeDisplay.getScopeGroupId()).getChallengeId())%>"/>
    <portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="ongoingCocreationsURL" windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="deleteCocreation" var="deleteCocreationURL">
	<portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
	<portlet:param name="redirectTo" value="<%=ongoingCocreationsURL%>"/>
</portlet:actionURL>
<portlet:actionURL name="updateCocreation" var="updateCocreationURL">
	<portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
	<portlet:param name="redirectTo" value="<%=redirectTo%>"/>
</portlet:actionURL>

<liferay-ui:success key="actionSuccess" message="Operation performed"/>
<liferay-ui:error key="actionError" message="Operation performed"/>				
<div id="details">
	<div class="container-fluid p-0 co-creation">
	   <div class="row mb-4 border-bottom">
			<div class="col col-lg-6 col-sm-6 col-6 col-md-12">
				<portlet:renderURL var="ongoingCcocreationsURL">
					<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
				</portlet:renderURL>
				<%-- <a href="<%=ongoingCcocreationsURL%>"><i class="fa fa-arrow-circle-left" aria-hidden="true"></i></a><span class="co-title">Co-creation details</span> --%>
				<span class="co-title">Co-creation details</span>
			</div><!-- w-1/2  END-->
			<div class="col col-lg-6 col-sm-6 col-6 col-md-12"> 
				  <aui:nav cssClass="nav-tabs nav-co-tabs">	
					<portlet:renderURL var="mycocreationsURL">
						<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
					</portlet:renderURL>
					<%if (isChallengeOwner){%>
						<aui:nav-item href="<%=mycocreationsURL%>" label="Co-Creations"/>
					<%}else{%>
						<aui:nav-item href="<%=mycocreationsURL%>" label="My Co-Creations"/>
					<%}%>
				</aui:nav>	
				<aui:nav cssClass="nav-tabs nav-co-tabs-not-sel">
					<portlet:renderURL var="challengesURL">
						<portlet:param name="jspPage" value="/challenges.jsp"/>
					</portlet:renderURL>
					<aui:nav-item href="<%=challengesURL%>" label="Challenges"/>
			    </aui:nav>	
			</div><!-- w-1/2 END -->
		</div>
   </div>
   <aui:form id="formCocreation" name="fm" method="post" enctype="multipart/form-data" action="<%= updateCocreationURL.toString() %>">
   	   <aui:fieldset> 
	       <div id="cocreators" class="challengesLeft">
				<span><b><label class="aui-field-label">Co-creators : </label></b></span>
		   </div>
	       <%
		   List<Cocreator> cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(Long.parseLong(cocreationId));
		   Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
		   while(cocreatorsIt.hasNext()){
				Cocreator cocreator = cocreatorsIt.next();
				User userDisplay = UserLocalServiceUtil.getUserById(cocreator.getUserId());
				if (user.getUserId() == cocreator.getUserId()){
					/*L'utente loggato � uno dei co-creatori*/
					isCocreator = true;
				}
				%>
				<span><label class="aui-field-label"><a href="<%=userDisplay.getDisplayURL(themeDisplay)%>"><%=cocreator.getUserName()%></a></label></span>
				<%
				if (cocreatorsIt.hasNext()){
				%>
					<span><label class="aui-field-label">,</label></span>
				<%
				}		
			}	
		    %>
	       <div id="date" class="challengesLeft">
		 		<span><b><label class="aui-field-label">Created on</label></b></span> : <span><%=formatter.format(cocreation.getCreateDate())%></span>
		   </div>
	       <p></p>    	    
		   <h3 class="sheet-subtitle">Challenge</h3>
	       <aui:input label="Challenge" name="challenge" id="challenge" readonly="true" value="<%=challengeTitle%>" cssClass="field disabled form-control"/>
	       <aui:input label="Desired Outcome" name="desiredOutcome" id="desiredOutcome" type="textarea" readonly="true" value="<%=desiredOutcome%>" cssClass="field disabled form-control"/>
	       <%-- <h3 class="sheet-subtitle">Request</h3>      
           <aui:input label="Request" name="request" id="request" type="textarea" value="<%=cocreation.getRequest()%>" readonly="true"/>
    	   <aui:input label="Request Reply" name="message" id="message" type="textarea" value="<%=cocreation.getMessage()%>" readonly="true"/> --%>
    	   <h3 class="sheet-subtitle">Co-creation</h3>
    	   <%if (!isCocreator){%>
	    	   <aui:input label="Title" name="title" id="title" type="textarea" value="<%=cocreation.getTitle()%>" readonly="true" cssClass="field disabled form-control"/>
	    	   <aui:input label="Description" name="description" id="description" type="textarea" value="<%=cocreation.getDescription()%>" readonly="true" cssClass="field disabled form-control"/>
	    	   <aui:input label="Status" name="status" id="status" type="text" value='<%=cocreation.getCompleted() == true ?  "Completed" : "To complete"%>' readonly="true" cssClass="field disabled form-control"/>
		   <%}else{%>
		   		<aui:input label="Title" name="title" id="title" type="textarea" value="<%=cocreation.getTitle()%>" required="true"/>
	    	    <aui:input label="Description" name="description" id="description" type="textarea" value="<%=cocreation.getDescription()%>" required="true"/>
	            <aui:select label="Status" id="completed" name="completed" showEmptyOption="false" required="true">
				    <aui:option selected="<%=true%>" value="<%=cocreation.getCompleted()%>"><%=cocreation.getCompleted() == true ?  "Completed" : "To complete"%></aui:option>
				    <aui:option selected="<%=false%>" value="true">Completed</aui:option>
				    <aui:option selected="<%=false%>" value="false">To complete</aui:option>
			    </aui:select>
		   <%}%>
		   <h3 class="sheet-subtitle">Document and Pictures</h3>
		   <div class="col-12 col-md-12">
       	   		<div class="pb-2">	
					<h3 class="sheet-subtitle">View pictures</h3>
					<% 
					String fileURL = "";
					for (FileEntry file : fileEntries) {    
						fileURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + file.getUuid();
						if ((file.getExtension().equalsIgnoreCase("jpeg") || 
						     file.getExtension().equalsIgnoreCase("jpg")  ||
						     file.getExtension().equalsIgnoreCase("png")) && 	
							 file.getFileName().startsWith("COCREATION_")){
						%>	
							<liferay-ui:icon target="_blank" label="<%= true %>" message="<%=file.getTitle() %>" url="<%= fileURL %>"/></br>
					 	<%
						}
					 }
					 %>
				</div>
				<div class="pb-2">	
					<h3 class="sheet-subtitle">Attached Documents</h3>
					<% 
						for (FileEntry file : fileEntries) {    
							fileURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + file.getUuid();
							if ((!file.getExtension().equalsIgnoreCase("jpeg") && 
								 !file.getExtension().equalsIgnoreCase("jpg")  &&
								 !file.getExtension().equalsIgnoreCase("png")) && 	
								  file.getFileName().startsWith("COCREATION_")){
							%>	
								<liferay-ui:icon target="_blank" label="<%= true %>" message="<%=file.getTitle() %>" url="<%= fileURL %>"/></br>
						 	<%
							}
						 }
						 %>
				</div>
		   </div>
		   <h3 class="sheet-subtitle"></h3>   	  
     	   <div id="fileList"></div>
		   <span style="display:block; height: 10px;"></span>
		   <div class="btn-group">
		   		<%if (isCocreator){%>
					<label for="uploadedFile" class="btn btn-primary pull-left">Upload pictures and documents</label>
				<%}%>
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
		   <h3 class="sheet-subtitle"></h3>
		   <div id="products" class="row view-group">			
		        <div class="item col-xs-4 col-lg-4" d-pagegroup="1">
		            <div class="thumbnail card">
		                <div class="caption card-body" style="overflow-y:Auto;height:400px;width:100%;overflow-x:hidden">
		                    <h3 class="co-title">Milestones and Deadlines</h3>
		                    <%
					   		if (milestones.size() == 0){
					   		%>
					   			</br>
					   			<h3 class="sheet-subtitle">There are no Milestones and Deadlines</a></h3>
							<%
							}else{
							%>	
								<h3 class="sheet-subtitle"</h3>
							<%
							}
							for (Activity milestone : milestones) {
							%>
								
								<liferay-portlet:actionURL name="deleteMilestone" var="deleteMilestoneURL">
									<portlet:param name="activityId" value="<%=String.valueOf(milestone.getActivityId())%>"/>
									<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
								</liferay-portlet:actionURL>	
			                    <p>
			                    <%
								for (Cocreator cocreator : CocreatorLocalServiceUtil.getCocreatorsByCocreationId(milestone.getActivityId())) {
								%>
			                        <h3 class="sheet-subtitle"><a href="<%=farmerProfile%>"><%=cocreator.getUserName()%></a>    
			                    <% 
								}
								%>
								</p>
								<br>
								<p>
									<%=milestone.getDescription()%>
								</p>
						   		<br>
						   		<p>	
									Expiration Date : <%=formatter.format(milestone.getExpirationDate())%>
						   		</p>
						   		<br>
						   		<%if (isCocreator){%>
							   		<p>
							   			<aui:button name="deleteMilestone" type="button" value="Delete"  onClick="<%=\"window.location.href='\"+deleteMilestoneURL.toString() +\"'\"%>"/></h3>
				                    </p>
			                    <%}%>	 	
			                <% 
							}
							%>
		                </div>
		            </div>
		            <%if (isCocreator){%>
                        <aui:button-row>
				  			<div id="aui_popup_milestonesAndDeadlines_click">
				       			<aui:button type="button" value="Add Milestone" cssClass="btn-outline-info"></aui:button>
				   			</div>
				   			<div id="aui_popup_milestonesAndDeadlines_content" ></div>
						</aui:button-row>             
		            <%}%>
		         </div>   
		         <%if (isCocreator){%>
			         <div class="item col-xs-4 col-lg-4" d-pagegroup="1">
			            <div class="thumbnail card">
			                <div class="caption card-body" style="overflow-y:Auto;height:400px;width:100%;overflow-x:hidden">
			                    <h3 class="co-title">My To-Do's</h3>
			                    <%
						   		if (toDos.size() == 0){
						   		%>
						   			</br>
						   			<h3 class="sheet-subtitle">There are no My To-Do's</a></h3>
								<%
								}else{
								%>
									<h3 class="sheet-subtitle"</h3>
								<%	
								}
								for (Task toDo : toDos) {
								%>
									<liferay-portlet:actionURL name="deleteToDo" var="deleteToDoURL">
										<portlet:param name="taskId" value="<%=String.valueOf(toDo.getTaskId())%>"/>
										<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
									</liferay-portlet:actionURL>	
				                    <p>
				                    	<h3 class="sheet-subtitle"><%=toDo.getDescription()%>
				                    </p>
				                    <br>
				                    <p>	
				                    	Expiration Date : <%=formatter.format(toDo.getExpirationDate())%>    
				                    </p>
				                    <br>
							   		<p>
							   			<aui:button name="deleteToDo" type="button" value="Delete"  onClick="<%=\"window.location.href='\"+deleteToDoURL.toString() +\"'\"%>"/></h3>	
				                    </p>
				                <% 
								}
								%>
			                </div>
			            </div> 
                           <aui:button-row>
				  			<div id="aui_popup_mytodos_click">
				       			<aui:button type="button" value="Add To-Do" cssClass="btn-outline-info"></aui:button>
				   			</div>
				   			<div id="aui_popup_mytodos_content" ></div>
						</aui:button-row>              
			         </div>   
		         <%}%>
		         <div class="item col-xs-4 col-lg-4" d-pagegroup="1">   
		            <div class="thumbnail card">
		                <div class="caption card-body" style="overflow-y:Auto;height:400px;width:100%;overflow-x:hidden">
		                    <h3 class="co-title">Questions and Feedback</h3>
						    <div class="col-12 p0 mb-2">
		          			</div>
		                    <h3 class="sheet-subtitle"</h3>
		                    <p id="desc-1" class="card-text group inner list-group-item-text resourse-card">
		                        <h3 class="sheet-subtitle">Would it be possible to have some clarification ?
		                    </p>
		                    <br>
						   	<p>
						   		<aui:button name="deleteQuestionFeedback" type="button" value="Delete" onClick=""/></h3>	
			                </p>
			                <br>
		                    <p id="desc-2" class="card-text group inner list-group-item-text resourse-card">
		                        <h3 class="sheet-subtitle">We'll arrange a call as soon as possible.
		                    </p>
		                    <br>
						   	<p>
						   		<aui:button name="deleteQuestionFeedback" type="button" value="Delete" onClick=""/></h3>	
			                </p>
		                </div>
		            </div>
                       <aui:button-row>
			  			<div id="aui_popup_questionsFeedbacks_click">
			       			<aui:button type="button" value="Add Question or Feedback" cssClass="btn-outline-info"></aui:button>
			   			</div>
			   			<div id="aui_popup_questionsFeedbacks_content" ></div>
				    </aui:button-row>             
		         </div>   
		   </div>					   				   
		   <h3 class="sheet-subtitle"></h3>	
		   <div class="col-12 col-md-12">
			 	<div class="pb-2">
			 		<aui:button-row>
			  			<div id="aui_popup_requestToCocreate_click">
			  				<%if (isCocreator){%>
			       				<aui:button type="button" value="Invite Participants" cssClass="btn-outline-info"></aui:button>
			       			<%}else{%>
			       				<aui:button type="button" value="Request to Co-Create" cssClass="btn-outline-info"></aui:button>
			       			<%}%>
			   			</div>
			   			<div id="aui_popup_requestToCocreate_content" ></div>
					</aui:button-row>  
				</div>
			</div>
			<h3 class="sheet-subtitle"></h3>	
       </aui:fieldset>
	   <aui:button-row>
	   		<%if (isCocreator){%>
	   			<aui:button type="submit" value="Publish" cssClass="btn-outline-info"></aui:button>
	   			<aui:button name="deleteCocreation" type="button" value="Delete" onClick="javascript:deleteConfirmation();"/>
	   		<%}%>
	   		<aui:button name="cancel" type="button" value="Cancel" onClick="<%=ongoingCocreationsURL%>"/>
	   </aui:button-row>
  </aui:form>
</div>

<script type="text/javascript">
	function deleteConfirmation() {
		msg = "Are you sure you want to proceed with the delete operation?";
		if(confirm(msg)) {
			window.location.href = '<%=deleteCocreationURL.toString()%>';
		}else{
			return false;
		}
	}
</script>
 
<aui:script>
     Liferay.provide(window, 'refreshPortlet', function() {
         window.location.reload();
     },
     ['aui-dialog','aui-dialog-iframe']
     );
</aui:script>
  
<aui:script use="liferay-util-window">
	A.one("#aui_popup_requestToCocreate_click").on('click',function(event){
		
		<%if(isCocreator){
			participationURL = inviteParticipantsURL.toString();
			height = 520;
		}else{
			participationURL = requestParticipationURL.toString();
			height = 420;
		}%>
		
		var popUpWindow=Liferay.Util.Window.getWindow(
			{
				dialog: {
					centered: true,
					constrain2view: true,					
					modal: true,
					resizable: false,
					width: 500,
					height: 520
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
	
	A.one("#aui_popup_milestonesAndDeadlines_click").on('click',function(event){
		var popUpWindow=Liferay.Util.Window.getWindow(
			{
				dialog: {
					centered: true,
					constrain2view: true,					
					modal: true,
					resizable: false,
					width: 500,
					height: 600
				}
			}
		).plug(
			A.Plugin.DialogIframe,
			{
				autoLoad: true,
				uri:"<%=addMilestoneURL.toString()%>"
			}
		).render();
		popUpWindow.show(popUpWindow);
		popUpWindow.titleNode.html("Add Milestone");
	});
	
	A.one("#aui_popup_mytodos_click").on('click',function(event){
		var popUpWindow=Liferay.Util.Window.getWindow(
			{
				dialog: {
					centered: true,
					constrain2view: true,					
					modal: true,
					resizable: false,
					width: 500,
					height: 400
				}
			}
		).plug(
			A.Plugin.DialogIframe,
			{
				autoLoad: true,
				uri:"<%=addToDoURL.toString()%>"
			}
		).render();
		popUpWindow.show(popUpWindow);
		popUpWindow.titleNode.html("Add To-Do");
	});
	
	A.one("#aui_popup_questionsFeedbacks_click").on('click',function(event){
		var popUpWindow=Liferay.Util.Window.getWindow(
			{
				dialog: {
					centered: true,
					constrain2view: true,					
					modal: true,
					resizable: false,
					width: 500,
					height: 300
				}
			}
		).plug(
			A.Plugin.DialogIframe,
			{
				autoLoad: true,
				uri:"<%=addQuestionFeedbackURL.toString()%>"
			}
		).render();
		popUpWindow.show(popUpWindow);
		popUpWindow.titleNode.html("Add Question or Feedback");
	});
</aui:script>