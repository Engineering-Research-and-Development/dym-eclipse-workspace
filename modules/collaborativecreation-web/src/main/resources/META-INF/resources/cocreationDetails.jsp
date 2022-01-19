<%@ include file="/init.jsp" %>

<style>
	.aui .navbar .navbar-inner {
    	min-height: 67px;
	}
	
	.cocreationRight {
  		background: #ECF0F1;
  		padding: 5px;
  		float:left;
  		margin-top: -10px !Important;
  		margin-left: -15px !Important;
  		min-height: 54px !important;
  		border: 10px solid #fff; 
  		display:block; 
  		width:30%;
  	    height:300px;
   	}		
   	.cocreationCenter {
  		background: #ECF0F1;
  		padding: 5px;
  		float:left;
  		margin-top: -10px !Important;
  		min-height: 54px !important;
  		border: 10px solid #fff; 
  		display:block; 
  		width:30%;
  	    height:300px;
   	}	
   	.cocreationCenterDown {
  		background: #ECF0F1;
  		padding: 5px;
  		float:left;
  		margin-top: -10px !Important;
  		min-height: 54px !important;
  		border: 10px solid #fff; 
  		display:block; 
  		width:30%;
  	    height:170px;
   	}	
   	.cocreationCenterDownDown {
  		background: #ECF0F1;
  		padding: 5px;
  		float:left;
  		margin-top: -170px !Important;
  		min-height: 54px !important;
  		border: 10px solid #fff; 
  		display:block; 
  		width:29.7%;
  	    height:170px;
   	}	
   	.cocreationLeft {
   		background: #ECF0F1;
  		float:left; 
  		display:block; 
  		width:30%;
  	    height:570px;
  	    margin-bottom: 43px !Important;
  	    margin-right: 1px !Important;
  	    clear:left;
   	}
</style>

<aui:nav cssClass="nav-tabs">
	<portlet:renderURL var="cocreationsURL">
		<portlet:param name="jspPage" value="/view.jsp"/>
	</portlet:renderURL>
	<aui:nav-item href="<%=cocreationsURL%>" label="Welcome !"/>
</aui:nav>

<aui:nav cssClass="nav-tabs">
	<portlet:renderURL var="challengesURL">
		<portlet:param name="jspPage" value="/challenges.jsp"/>
	</portlet:renderURL>
	<aui:nav-item href="<%=challengesURL%>" label="Challenges"/>

	<portlet:renderURL var="mycocreationsURL">
		<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
	</portlet:renderURL>
	<aui:nav-item href="<%=mycocreationsURL%>" label="My Co-Creations"/>
</aui:nav>	

<portlet:renderURL var="addMilestoneURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/addMilestone.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addToDoURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/addToDo.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addQuestionAndFeedbackURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/addQuestionAndFeedback.jsp" />
</portlet:renderURL>

<aui:fieldset>
	<div id="details">
       <span><b>Challenge : </b>Sensor integration of soil humidity with weather data to predict future harvest.</span>
       <br>
       <span><b>Posted by : </b> Johannes Antoniadis</span>
       <br>
       <span><b>Date : </b>20/09/2020</span>
       <p></p>
       <div id="milestonesAndDeadlines" class="cocreationLeft">
       		  <label class="control-label">Milestones and Deadlines</label>	
              <br>
              <span><b>1. </b> Need posted by Johannes</span>
              <br>
              <span>Date : 20/09/2020</span>
              <p></p>
              <span><b>2. </b> Need upgraded to challenhges</span>
              <br>
              <span>Date : 02/10/2020</span>
              <p></p>
              <span><b>3. </b> Lorem ipsum...</span>
              <p></p>
              <span><b>4. </b> Lorem ipsum...</span>
              <p></p>
	          <div id="aui_milestone_popup_click">
	            	<aui:button type="submit" value="Add Milestone" cssClass="btn-outline-info" style="margin-top:300px; margin-left:15px"></aui:button>
	          </div>
	          <div id="aui_milestone_popup_content" ></div>        
       </div>
       <div id="myToDo" class="cocreationCenter">
       		  <label class="control-label">My To Do</label>	
              <br>
              <span><b>1. </b> Send email</span>
              <p></p>
              <span><b>2. </b> View contract</span>
              <p></p>
              <span><b>3. </b> Call</span>
              <p></p>
              <span><b>4. </b> Schedule meeting</span>
              <p></p> 
	          <div id="aui_toDo_popup_click">
	            	<aui:button type="submit" value="Add To-Do" cssClass="btn-outline-info" style="margin-top:50px; margin-left:10px"></aui:button>
	          </div>
	          <div id="aui_toDo_popup_content" ></div>        
       </div>
       <div id="contactAndResponsibilities" class="cocreationRight">
       		  <label class="control-label">Contact and Responsibilities</label>	
              <br>
              
              <img style="margin-right:50px;margin-top:55px;margin-left:50px;" class="journal-image" hspace="0" id="idea" src="<%=request.getContextPath()%>/img/man.png" vspace="0"/>
              <div id="contact1" style="margin-top:-25px;margin-left:125px">
              		<span>Johannes Antoniadis</span>
              </div>
              <p></p>
              <img style="margin-right:50px;margin-top:55px;margin-left:50px;" class="journal-image" hspace="0" id="idea" src="<%=request.getContextPath()%>/img/woman.png" vspace="0"/>
              <div id="contact2" style="margin-top:-25px;margin-left:125px">
              		<span>Martina Smith</span>
              </div>
              <p></p>        
       </div>
       <div id="contractDocumentAndPictures" class="cocreationCenterDown">
       		  <img style="margin-right:100px;margin-top:40px;margin-left:50px;" class="journal-image" hspace="0" id="idea" src="<%=request.getContextPath()%>/img/document.png" vspace="0"/>	
       		  <label style="margin-left:130px; margin-top:-10%;" class="control-label">Contract Document And Pictures</label>	  
       </div>
       <div id="questionAndFeedback" class="cocreationRight">
            <label class="control-label">Question and Feedback</label>			
			<aui:input name="check" label="When will I get the contract documents ?" type="checkbox" value="1"></aui:input>
			<aui:input name="check" label="How does soil humidity change with weather ?" type="checkbox" value="2"></aui:input>
			<aui:input name="check" label="Lorem Ipsum..." type="checkbox" value="3"></aui:input>
       		<div id="aui_questionAndFeedback_popup_click">
	           	<aui:button type="submit" value="Add Question" cssClass="btn-outline-info" style="margin-top:60px; margin-left:10px"></aui:button>
	        </div>
	        <div id="aui_questionAndFeedback_popup_content" ></div>   
       </div>
       <div id="ideaSpace" class="cocreationCenterDownDown">
       		  <img style="margin-right:50px;margin-top:-5px;margin-left:50px;" class="journal-image" hspace="0" id="idea" src="<%=request.getContextPath()%>/img/idea.png" vspace="0"/>
       		  <label style="margin-top:50px;" class="control-label">Idea Space</label>	     
       </div>
    </div>
</aui:fieldset>

<aui:script use="liferay-util-window">
	A.one("#aui_milestone_popup_click").on('click',function(event){
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
		popUpWindow.titleNode.html("Add a Milestone");
 	});
 	A.one("#aui_questionAndFeedback_popup_click").on('click',function(event){
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
				uri:"<%=addQuestionAndFeedbackURL.toString()%>"
			}
		).render();
		popUpWindow.show(popUpWindow);
		popUpWindow.titleNode.html("Add a Question");
 	});
 	A.one("#aui_toDo_popup_click").on('click',function(event){
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
		popUpWindow.titleNode.html("Add a To-Do");
 	});
</aui:script>