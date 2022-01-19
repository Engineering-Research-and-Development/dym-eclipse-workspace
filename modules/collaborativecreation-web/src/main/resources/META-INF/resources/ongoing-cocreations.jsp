<%@ include file="/init.jsp" %>

<style>
	.aui .navbar .navbar-inner {
    	min-height: 67px;
	}
	
	.cocreations {
  		background: #ECF0F1;
  		padding: 5px;
  		margin-top: 43px !Important;
  		min-height: 54px !important;
  		border: 10px solid #fff;
  		float:left; 
  		display:block;
  		padding:20px; 
  		width:350px;
  	    height:350px;
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

<aui:nav cssClass="nav-tabs">
	<portlet:renderURL var="ongoingCocreationsURL">
		<portlet:param name="jspPage" value="/ongoing-cocreations.jsp"/>
	</portlet:renderURL>
	<aui:nav-item href="<%=ongoingCocreationsURL%>" label="Ongoing Co-Creations"/>

	<portlet:renderURL var="previousCocreationsURL">
		<portlet:param name="jspPage" value="/previous-cocreations.jsp"/>
	</portlet:renderURL>
	<aui:nav-item href="<%=previousCocreationsURL%>" label="Previous Co-Creations"/>
</aui:nav>

<portlet:renderURL var="details">
    <portlet:param name="jspPage" value="/cocreationDetails.jsp" />
</portlet:renderURL>

<aui:fieldset>
	<div id="oingoingCocreations">
		<div class="cocreations" id="first">
	        <p></p>
	        <span>Sensor integration of soil humidity with weather data to predict future harvest.</span>
	        <p></p>
	        <span><b>Your Open To Do :</b> 2</span>
	        <p></p>
	        <span>
		        <label class="control-label">Latest Activities :</label>
		      	<ul>
				  <li>Johannes uploaded an image (13/10/2021)</li>
				  <li>Peter posted a question (13/10/2021)</li>
				  <li>Martina uploaded a document (13/10/2021)</li>
				</ul>
			</span>				
	        <span><a href="<%=details%>">Details</a></span>
	        <p></p>
	    </div>
	    <div class="cocreations" id="second">
	        <p></p>
	        <span>Lorem ipsum...</span>
	        <p></p>
	        <span><a href="">Details</a></span>
	        <p></p>
	    </div>
	    <div class="cocreations" id="third">
	        <p></p>
	        <span>Lorem ipsum...</span>
	        <p></p>
	        <span><a href="">Details</a></span>
	        <p></p>
	    </div>
	</div>
</aui:fieldset>