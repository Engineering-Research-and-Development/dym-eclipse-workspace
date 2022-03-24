<%@ include file="/init.jsp" %>

<style>
	.aui .navbar .navbar-inner {
    	min-height: 67px;
	}
</style>

<portlet:renderURL var="inviteParticipantsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="jspPage" value="/inviteParticipants.jsp" />
</portlet:renderURL>

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
	<aui:nav-item href="<%=mycocreationsURL%>" label="Co-Creations"/>
</aui:nav>	

<aui:fieldset>
	<div id="details">
       <span><b>NEED : </b>Sensor integration of soil humidity with weather data to predict future harvest.</span>
       <p></p>
       <span><b>Posted by : </b> Johannes Antoniadis</span>
       <br>
       <span><b>Date : </b>20/09/2020</span>
       <p></p>
       <span><b>Description : </b></span>
       <span>Dolorem ipsum, quia dolor sit, amet, consectetur, adipisci velit,</span>
       <span>sed quia non numquam eius modi tempora incidunt, ut labore et dolore magnam aliquam quaerat voluptatem.</span>
       <p></p>
       <span>Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur ?</span>
       <span>Quis autem vel eum iure reprehenderit, qui in ea voluptate velit esse, quam nihil molestiae consequatur, vel illum, qui dolorem eum fugiat, quo voluptas nulla pariatur ?</span>
       <p></p>
       <span><a href="">View Pictures</a></span>
       <p></p>
    </div>
</aui:fieldset>

<aui:button-row>
  	<div id="aui_popup_click">
       	<aui:button type="submit" value="Request to Co-Create" cssClass="btn-outline-info"></aui:button>
   	</div>
   	<div id="aui_popup_content" ></div>
</aui:button-row>   

<aui:script use="liferay-util-window">
	A.one("#aui_popup_click").on('click',function(event){
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
</aui:script>