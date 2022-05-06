<%@ include file="/init.jsp" %>

<%
String redirectTo = request.getParameter("redirectTo");
long challengeId = ParamUtil.getLong(request, "challengeId");
String participationRequest = request.getParameter("participationRequest");
String participant = request.getParameter("participant");
List<User> users = UserLocalServiceUtil.getGroupUsers(themeDisplay.getScopeGroupId());
User currentUser = themeDisplay.getUser();
%>

<portlet:actionURL name="addParticipant" var="addParticipantURL">
	<portlet:param name="participants" value="<%=participant %>"></portlet:param>
	<portlet:param name="challengeId" value="<%=String.valueOf(challengeId)%>"/>
	<portlet:param name="cocreationId" value="0"/>
	<portlet:param name="redirectTo" value=""></portlet:param>
</portlet:actionURL>

<portlet:actionURL name="declineRequest" var="declineRequestURL">
	<portlet:param name="participant" value="<%=participant %>"></portlet:param>
	<portlet:param name="challengeId" value="<%=String.valueOf(challengeId)%>"/>
	<portlet:param name="redirectTo" value=""/>
</portlet:actionURL>

<liferay-ui:success key="actionSuccess" message="Operation performed"/>
<liferay-ui:error key="actionError" message="Operation performed"/>

<div id="participantFormContainer">
	<aui:form id="formparticipant" name="formparticipant" method="post" action="<%=addParticipantURL.toString()%>">
		<aui:fieldset>
			<div class="clearfix" style="margin-right:20px; margin-left:20px;">
	             <div>
	             	<aui:input label="Challenge" name="challenge" id="challenge" readonly="true" value="<%=ChallengeLocalServiceUtil.getChallenge(challengeId).getTitle()%>"/>
	             </div>
	             <div>
	             	<aui:input label="Request" name="request" id="request" readonly="true" value="<%=participationRequest%>"/>
	             </div>
	             <%-- <aui:input label="Contribution requested" placeholder="Type a message here..." name="message" id="message" type="textarea" required='true'/> --%>
		    </div>            
		</aui:fieldset>
		<aui:button-row>
		  	<div id="aui_popup_click">
		       	<aui:button id="accept" name="accept" type="submit" value="Accept" cssClass="btn-outline-info"></aui:button>
		       	<aui:button id="decline" name="decline" type="button" value="Decline"  onClick="<%=\"window.location.href='\"+declineRequestURL.toString() +\"'\"%>"/>
		   	</div>
		   	<div id="aui_popup_content" ></div>
		</aui:button-row>
	</aui:form>      
</div>
