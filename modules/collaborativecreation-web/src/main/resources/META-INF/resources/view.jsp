<%@ include file="/init.jsp" %>

<style>
	.aui .navbar .navbar-inner {
    	min-height: 67px;
	}
</style>

<liferay-ui:success key="actionSuccess" message="Operation performed"/>
<liferay-ui:error key="actionError" message="Operation performed"/>		
<div class=" m-2 p-1">
	<div class=" mb-2">
		<h3 class="co-title"><liferay-ui:message key='collaborativecreationweb.caption'></liferay-ui:message></h3>
		<div id="welcome" class="m-2 p-2">
			<div class="span4" id="first">
		        <p></p>
		        <span>In this section of the <b>SOCS Platform</b>, farmers and technology providers can collaborate</span>
		        <span>to co-ceate innovative technology solutions to improve farming.</span>
		        <p></p>
		        <span>Under <b>needs</b> you can find a list of needs that farmers experience on their farms.</span>
		        <span>You can browse through the list of existing needs and engage in conversations with farmers that have experienced similar needs.</span>
		        <p></p>
		        <span>You can upvote needs to express importance for this specific need.</span>
		        <span>If you want to stay up-to-date about a need, you can <b>follow</b> it by pressing the <b>star</b> icon in the top-left corner.</span>
		        <span>If you want to post your own need, press on <b>post new need</b>.</span>
		        <p></p>
		        <span>If a need gets enough backing from the community in the form of upvotes or followers, a need can be promoted to a <b>challenge</b>.</span>
		        <span>Challenges are a call for action for technology developers and farmers to <b>co-create a solution</b>.</span>
		        <p></p>
		        <span>Under <b>my co-creations</b> you can find all the needs that you follow and all the challenges that you are part of.</span>
		        <p></p>
		    </div>
		</div>
		<portlet:renderURL var="challengesURL">
				<portlet:param name="jspPage" value="/challenges.jsp"/>
		</portlet:renderURL>
 		<a href="<%=challengesURL%>" class="btn btn-primary">Get Started !</a>
 	</div>
</div>