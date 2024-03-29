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
		        <span>Here, farmers and technology providers can collaborate to co-create innovative technology solutions to improve farming.</span>
		        <p></p>
		        <span>Under <b>'Challenges'</b> you can find a list of problems that farmers experience on their farms. You can browse through the list of posted challenges and engage in conversations with people that have experienced similar problems. </span>
		        <p></p>
		        <span>� You can <b>upvote</b> challenges to express its relevance. Challenges with more up-votes are listed higher than other challenges.</span></br>
		        <span>� You can <b>subscribe</b> a specific challenge to get notified about updates. </span></br>
		        <span>� If you have the role of Challenge author and you can't find what you need, you can also create a new challenge by pressing on <b>'Post new challenge'</b>.</span></br>
		        <p></p>
		        <span>If you are interested in finding a solution for the challenge, you can send a collaboration request.</span>
		        <p></p>
		        <span>Under <b>'Co-creations'</b> you can find all the challenges that you are a part of.</span>
		        <p></p>
		    </div>
		</div>
		<portlet:renderURL var="challengesURL">
				<portlet:param name="jspPage" value="/challenges.jsp"/>
		</portlet:renderURL>
 		<a href="<%=challengesURL%>" class="btn btn-primary"><liferay-ui:message key="getStarted"/></a>
 	</div>
</div>