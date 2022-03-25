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
		        <span>Under <b>challenges</b> you can find a list of contests : </span>
		        <span>they are a call for action for technology developers and farmers to <b>co-create a solution</b>.</span>
		        <p></p>
		        <span>You can upvote to express importance for a specific challenge.</span>
		        <span>If you want to stay up-to-date about a challenge, you can <b>follow</b> it.</span>
		        <span>If you want to post your own challenge, press on <b>post new challenge</b>.</span>
		        <p></p>
		        <span>Under <b>co-creations</b> you can find all the co-creations you belong to.</span>
		        <p></p>
		    </div>
		</div>
		<portlet:renderURL var="challengesURL">
				<portlet:param name="jspPage" value="/challenges.jsp"/>
		</portlet:renderURL>
 		<a href="<%=challengesURL%>" class="btn btn-primary">Get Started !</a>
 	</div>
</div>