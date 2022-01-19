<%@ include file="/init.jsp" %>

<style>
	.aui .navbar .navbar-inner {
    	min-height: 67px;
	}
   	.challengesRight {
  		background: #ECF0F1;
  		padding: 5px;
  		min-height: 54px !important;
  		border: 10px solid #fff;
  		float:right; 
  		display:block; 
  		width:70%;
  	    height:300px;
   	}
   	.challengesLeft {
  		float:left; 
  		display:block; 
  		width:auto;
  	    height:100px;
  	    margin-bottom: 43px !Important;
  	    margin-right: 1px !Important;
  	    clear:left;
   	}
</style>

<portlet:renderURL var="challengeDetails">
    <portlet:param name="jspPage" value="/challengeDetails.jsp" />
</portlet:renderURL>
<portlet:renderURL var="needDetails">
    <portlet:param name="jspPage" value="/needDetails.jsp" />
</portlet:renderURL>

<portlet:renderURL var="farmerProfile">
    <portlet:param name="jspPage" value="/farmerProfile.jsp" />
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
	<aui:nav-item href="<%=mycocreationsURL%>" label="My Co-Creations"/>
</aui:nav>	

<portlet:renderURL var="newchallengeURL">
		<portlet:param name="jspPage" value="/newchallenge.jsp"/>
</portlet:renderURL>
<a href="<%=newchallengeURL%>">Post a New Challenge</a>

<aui:fieldset>
	<div id="challenges">
		<div id="trending" class="challengesLeft">
	    	<label class="aui-field-label">Trending</label>
		    <aui:input label="Hot" name="trending" type="radio" value="1"/>
			<aui:input label="Top Voted" name="trending" type="radio" value="2"/>
		</div>
		<div id="search" style="float:right; width:70%;">
			<aui:input inlineLabel="left" label="" name="keywords" placeholder="Search" size="256" />
		</div>
		<div id="location" class="challengesLeft">
			<aui:select name="Location">
    			<aui:option value="1">Location 1</aui:option>
    			<aui:option value="2">Location 2</aui:option>
    			<aui:option value="3">Location 3</aui:option>
			</aui:select>
		</div>
		<div id="first" class="challengesRight">
	        <span>Sensor integration of soil humidity with weather data to predict future harvest.</span>
	        <p></p>
	        <span><b>Posted by : </b><a href="<%=farmerProfile%>">Johannes Antoniadis</a></span>
	        <br>
	        <span><b>Status : </b>Active</span>
	        <p></p>
	        <div id="aui_popup_click1">
	        	<img class="journal-image" hspace="0" id="vote1" src="<%=request.getContextPath()%>/img/vote.png" vspace="0"/>
	        </div>
	        <div id="aui_popup_content" ></div>
	        <p></p>
	        <span><b>28</b></span>
	        <br>
	        <p></p>
	        <span><a href="">#humidity</a></span>
	        <span><a href="">#weather</a></span>
	        <span><a href="">#harvest</a></span>
	        <p></p>
	        <span><a href="<%=challengeDetails%>">Details</a></span>
	        <p></p>
	        <span><a href="">Follow</a></span>
	    </div>
		<div id="category" class="challengesLeft">
			<aui:select name="Category">
    			<aui:option value="1">Category 1</aui:option>
    			<aui:option value="2">Category 2</aui:option>
    			<aui:option value="3">Category 3</aui:option>
			</aui:select>
		</div>
		<div id="second" class="challengesRight">
	        <span>Sensor integration of soil humidity with weather data to predict future harvest.</span>
	        <p></p>
	        <span><b>Posted by : </b><a href="<%=farmerProfile%>">Johannes Antoniadis</a></span>
	        <br>
	        <span><b>Status : </b>Inactive</span>
	        <p></p>
	        <div id="aui_popup_click2">
	        	<img class="journal-image" hspace="0" id="vote2" src="<%=request.getContextPath()%>/img/vote.png" vspace="0"/>
	        </div>
	        <p></p>
	        <span><b>27</b></span>
	        <br>
	        <p></p>
	        <span><a href="">#humidity</a></span>
	        <span><a href="">#weather</a></span>
	        <span><a href="">#harvest</a></span>
	        <p></p>
	        <span><a href="<%=needDetails%>">Details</a></span>
	        <p></p>
	        <span><a href="">Follow</a></span>
	    </div>
		<div id="status" class="challengesLeft">
	    	<label class="aui-field-label">Status</label>
	    	<aui:input name="active" label="active" type="checkbox" value="1"></aui:input>
			<aui:input name="inactive" label="inactive" type="checkbox" value="2"></aui:input>
		</div>    
	</div>
</aui:fieldset>

<aui:script use="liferay-util-window">
	A.one("#aui_popup_click1").on('click',function(event){
 		var dialog = new A.Modal({
	 		title: "<b>Challenge upvoted successfully !</b>",
	 		bodyContent: "<b>Challenge</b> : Sensor integration of soil humidity with weather data to predict future harvest.<br><b>Posted by</b> : Johannes Antoniadis",
	 		headerContent: "<b>Challenge upvoted successfully !</b>",
		    centered: true,
		    modal: true,
		    height: 200,
		    width:300,
		    render: '#aui_popup_content', 
		    close: true
 		});
 		dialog.render();
 	});
</aui:script>