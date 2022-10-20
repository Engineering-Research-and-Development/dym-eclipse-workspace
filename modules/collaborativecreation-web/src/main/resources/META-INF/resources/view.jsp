<%@ include file="/init.jsp" %>

<div class="container-fluid p-0 co-creation">
	<div class="row">
		<div class="userRole">
			<h4><a href="<%=UserLocalServiceUtil.getUserById(themeDisplay.getUserId()).getDisplayURL(themeDisplay)%>"><%=themeDisplay.getUser().getFullName()%></a></h4>
			<%if (isChallengeOwner){%>
				<h4>Farmer</h4>
			<%}else{%>
				<h4>Technology developer </h4>
			<%}%>
		</div>		
   </div>	
   <div class="row mb-4 border-bottom">
   		<div class="col col-lg-6 col-sm-6 col-6 col-md-12">
			<h3 class="co-title"><liferay-ui:message key='collaborativecreationweb.caption'></liferay-ui:message></h3>
		</div><!-- w-1/2  END-->
		<div class="col col-lg-6 col-sm-6 col-6 col-md-12  "> 
			  <aui:nav cssClass="nav-tabs nav-co-tabs-not-sel">
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
			<aui:nav cssClass="nav-tabs nav-co-tabs">
				<portlet:renderURL var="viewURL">
					<portlet:param name="jspPage" value="/view.jsp"/>
				</portlet:renderURL>
				<aui:nav-item href="<%=viewURL%>" label="Help"/>
			</aui:nav>
		</div><!-- w-1/2 END -->
	</div>
	<div class="row">
		<div id="welcome" class="m-2 p-2">
			<div class="span4" id="first">
		        <p></p>
		        <span>Here, farmers and technology providers can collaborate to co-create innovative technology solutions to improve farming.</span>
		        <p></p>
		        <span>Under <b>'Challenges'</b> you can find a list of problems that farmers experience on their farms. You can browse through the list of posted challenges and engage in conversations with people that have experienced similar problems. </span>
		        <p></p>
		        <span>° You can <b>upvote</b> challenges to express its relevance. Challenges with more up-votes are listed higher than other challenges.</span></br>
		        <span>° You can <b>subscribe</b> a specific challenge to get notified about updates. </span></br>
		        <span>° If you have the role of Challenge author and you can't find what you need, you can also create a new challenge by pressing on <b>'Post new challenge'</b>.</span></br>
		        <p></p>
		        <span>If you are interested in finding a solution for the challenge, you can send a collaboration request.</span>
		        <p></p>
		        <span>Under <b>'Co-creations'</b> you can find all the challenges that you are a part of.</span>
		        <p></p>
		        <span>At the top right, in the <b>User Profile</b> menu, you can find the notifications section.</span>
		        <p></p>
		    </div>
		</div>
 	</div>
</div>