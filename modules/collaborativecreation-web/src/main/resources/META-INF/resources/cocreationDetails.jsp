<%@ include file="/init.jsp" %>
	
<%
String redirectTo = request.getParameter("redirectTo");
String cocreationId = request.getParameter("cocreationId").toString();
String challengeTitle = request.getParameter("challengeTitle").toString();
String desiredOutcome = request.getParameter("desiredOutcome").toString();
Cocreation cocreation = CocreationLocalServiceUtil.getCocreation(Long.parseLong(cocreationId));
String folderTitle = challengeTitle.replaceAll("[^a-zA-Z0-9]", "_");
Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, folderTitle);
List<Activity> milestones = ActivityLocalServiceUtil.getActivitiesByCocreationId(Long.parseLong(cocreationId));
%>

<portlet:renderURL var="farmerProfile">
    <portlet:param name="jspPage" value="/farmerProfile.jsp" />
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
<portlet:renderURL var="inviteParticipantsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/inviteParticipants.jsp" />
    <portlet:param name="challengeId" value="<%=String.valueOf(ChallengeLocalServiceUtil.getChallengeByCocreationId(Long.parseLong(cocreationId), themeDisplay.getScopeGroupId()).getChallengeId())%>"/>
    <portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
    <portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
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
<portlet:actionURL name="deleteCocreation" var="deleteCocreationURL">
	<portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
	<portlet:param name="redirectTo" value="<%=redirectTo%>"/>
</portlet:actionURL>
<portlet:actionURL name="updateCocreation" var="updateCocreationURL">
	<portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
	<portlet:param name="redirectTo" value="<%=redirectTo%>"/>
</portlet:actionURL>

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
				%>
      			<span><label class="aui-field-label"><a href="<%=farmerProfile%>"><%=cocreator.getUserName()%></a></label></span>
				<%		
			}	
		    %>
	       <div id="date" class="challengesLeft">
		 		<span><b><label class="aui-field-label">Started on</label></b></span> : <span><label class="aui-field-label"><%=formatter.format(cocreation.getCreateDate())%></label></span>
		   </div>
	       <p></p>    	    
		   <h3 class="sheet-subtitle">Challenge</h3>
	       <aui:input label="Challenge" name="challenge" id="challenge" readonly="true" value="<%=challengeTitle%>"/>
	       <aui:input label="Desired Outcome" name="desiredOutcome" id="desiredOutcome" readonly="true" value="<%=desiredOutcome%>"/>
	       <h3 class="sheet-subtitle">Request</h3>      
           <aui:input label="Request" name="request" id="request" type="text" value="<%=cocreation.getRequest()%>" readonly="true"/>
    	   <aui:input label="Contribution requested" name="message" id="message" type="textarea" value="<%=cocreation.getMessage()%>" readonly="true"/>
    	   <h3 class="sheet-subtitle">Co-creation</h3>
    	   <aui:input label="Title" name="title" id="title" type="textarea" value="<%=cocreation.getTitle()%>" required="true"/>
    	   <aui:input label="Description" name="description" id="description" type="textarea" value="<%=cocreation.getDescription()%>" required="true"/>
           <aui:select label="Status" id="completed" name="completed" showEmptyOption="false" required="true">
			    <aui:option selected="<%=true%>" value="<%=cocreation.getCompleted()%>"><%=cocreation.getCompleted() == true ?  "Completed" : "To complete"%></aui:option>
			    <aui:option selected="<%=false%>" value="true">Completed</aui:option>
			    <aui:option selected="<%=false%>" value="false">To complete</aui:option>
		   </aui:select>
		   <h3 class="sheet-subtitle">Document and Pictures</h3>
		   <div class="col-12 col-md-12">
       	   		<div class="pb-2">	
					<h3 class="sheet-subtitle">View pictures</h3>
					<% 
					String fileURL = "";
					List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());
					for (FileEntry file : fileEntries) {    
						fileURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + file.getUuid();
						if (file.getMimeType().equalsIgnoreCase("image/jpeg") ){
						%>	
							<liferay-ui:icon target="_blank" label="<%= true %>" message="<%=file.getTitle() %>" url="<%= fileURL %>"/></br>
					 	<%
						}
					 }
					 %>
				</div>
				<div class="pb-2">	
					<h3 class="sheet-subtitle">Download documents</h3>
					<% 
					for (FileEntry file : fileEntries) {    
						fileURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + file.getUuid();
						if (!file.getMimeType().equalsIgnoreCase("image/jpeg") ){
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
		   <h3 class="sheet-subtitle"></h3>
		   <div id="products" class="row view-group">
		   						
			        <div class="item col-xs-4 col-lg-4" d-pagegroup="1">
			            <div class="thumbnail card">
			                <div class="caption card-body">
			                    <h3 class="co-title">Milestones and Deadlines</h3>
							    <div class="col-12 p0 mb-2">
			                    </div>
			                    <%
								for (Activity milestone : milestones) {
								%>
				                    <p id="desc-"<%=milestone.getActivityId()%> class="card-text group inner list-group-item-text resourse-card">
				                    <%
									for (Cocreator cocreator : CocreatorLocalServiceUtil.getCocreatorsByCocreationId(milestone.getActivityId())) {
									%>
				                        <h3 class="sheet-subtitle"><a href="<%=farmerProfile%>"><%=cocreator.getUserName()%></a><br>    
				                    <% 
									}
									%>
									<%=milestone.getDescription()%><br>Expire : <%=formatter.format(milestone.getExpirationDate())%></h3>
				                    </p>
				                <% 
								}
								%>
			                    <div class="row">
			                        <div class="col-12">
			                            <aui:button-row>
								  			<div id="aui_popup_milestonesAndDeadlines_click">
								       			<aui:button type="button" value="Add Milestone" cssClass="btn-outline-info"></aui:button>
								   			</div>
								   			<div id="aui_popup_milestonesAndDeadlines_content" ></div>
										</aui:button-row>  
			                        </div>
			                    </div>
			                </div>
			            </div>
			         </div>   
		         
		         <div class="item col-xs-4 col-lg-4" d-pagegroup="1">   
		            <div class="thumbnail card">
		                <div class="caption card-body">
		                    <h3 class="co-title">My To-do's</h3>
						    <div class="col-12 p0 mb-2">
		                    </div>
		                    <p id="desc-1" class="card-text group inner list-group-item-text resourse-card">
		                        My To Do 1...</p>
		                    <hr>
		                    <p id="desc-2" class="card-text group inner list-group-item-text resourse-card">
		                        My To Do 2...</p>
		                    <hr>
		                    <div class="row">
		                        <div class="col-12">
		                            <aui:button-row>
							  			<div id="aui_popup_mytodos_click">
							       			<aui:button type="button" value="Add To Do" cssClass="btn-outline-info"></aui:button>
							   			</div>
							   			<div id="aui_popup_mytodos_content" ></div>
									</aui:button-row>  
		                        </div>
		                    </div>
		                </div>
		            </div>
		         </div>   
		   </div>					   				   
		   <h3 class="sheet-subtitle"></h3>	
		   <div class="col-12 col-md-12">
			 	<div class="pb-2">
			 		<aui:button-row>
			  			<div id="aui_popup_requestToCocreate_click">
			       			<aui:button type="button" value="Request to Co-Create" cssClass="btn-outline-info"></aui:button>
			   			</div>
			   			<div id="aui_popup_requestToCocreate_content" ></div>
					</aui:button-row>  
				</div>
			</div>
			<h3 class="sheet-subtitle"></h3>	
       </aui:fieldset>
	   <aui:button-row>
	   		<aui:button type="submit" value="Update" cssClass="btn-outline-info"></aui:button>
	   		<aui:button name="deleteCocreation" type="button" value="Delete"  onClick="<%=\"window.location.href='\"+deleteCocreationURL.toString() +\"'\"%>"/>
	  </aui:button-row>
  </aui:form>
</div>

<aui:script use="liferay-util-window">
	A.one("#aui_popup_requestToCocreate_click").on('click',function(event){
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
				uri:"<%=inviteParticipantsURL.toString()%>"
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
					width: 500
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
					width: 500
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
		popUpWindow.titleNode.html("Add To Do");
	});
</aui:script>