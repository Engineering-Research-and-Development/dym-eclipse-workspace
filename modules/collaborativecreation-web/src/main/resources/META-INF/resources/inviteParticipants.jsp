<%@ include file="/init.jsp" %>

<%
String redirectTo = request.getParameter("redirectTo");
long challengeId = ParamUtil.getLong(request, "challengeId");
long cocreationId = ParamUtil.getLong(request, "cocreationId");
/*List<User> users = UserLocalServiceUtil.getGroupUsers(themeDisplay.getScopeGroupId());*/
List<User> users = UserLocalServiceUtil.getUsers(0, 999);

User currentUser = themeDisplay.getUser();
List<Cocreator> allCocreators = new ArrayList();
List<Cocreator> cocreators = new ArrayList();
List<Cocreation> cocreations = new ArrayList();
if (cocreationId > 0){
	/*Invito a partecipare ad una cocreazione : acquisisco tutti i cocreatori per la cocreazione di riferimento*/
	cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(cocreationId);
	Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
	while(cocreatorsIt.hasNext()){
			Cocreator cocreator = cocreatorsIt.next();
			allCocreators.add(cocreator);
	}
}else{
	/*Invito a partecipare ad una gara : acquisisco tutti i cocreatori per la gara di riferimento*/
	cocreations = CocreationLocalServiceUtil.getCocreationsByChallengeId(challengeId);
	Iterator<Cocreation> cocreationsIt = cocreations.iterator();
	while(cocreationsIt.hasNext()){
		Cocreation cocreation = cocreationsIt.next();
		cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(cocreation.getCocreationId());
		Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
		while(cocreatorsIt.hasNext()){
				Cocreator cocreator = cocreatorsIt.next();
				allCocreators.add(cocreator);
		}
	}
}
%>

<portlet:actionURL name="addParticipant" var="addParticipantURL">
	<portlet:param name="active" value="true"/>
	<portlet:param name="challengeId" value="<%=String.valueOf(challengeId)%>"/>
	<portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
	<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
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
	             	<liferay-ui:input-editor name="request" initMethod="initEditor" width="100" height="600" resizable="true" toolbarSet="liferay-article"></liferay-ui:input-editor>
	             </div>
	             <div>
	             	<aui:select label="inviteParticipants" name="participants" id="participants" showEmptyOption="false" multiple="true" required="true">
	             		<aui:option selected="<%=true%>" value=""><liferay-ui:message key="selectOrType"/>...</aui:option>
						<%
						for (User groupUser : users) {
							boolean isCocreator = false;
							if (groupUser.getUserId() != currentUser.getUserId() || isChallengeOwner){
								for (Cocreator cocreator : allCocreators) {
									if (groupUser.getUserId() == cocreator.getUserId()){
										isCocreator = true;
									}
								}
								/*Disabilito gli utenti già cocreatori*/
								if (isCocreator){
								%>
									<aui:option value="<%=groupUser.getUserId()%>" disabled="true" style="font-style: oblique;"><%=groupUser.getFullName()%> - Already Participates</aui:option>
								<%	
								}else{
								%>
									<aui:option value="<%=groupUser.getUserId()%>"><%=groupUser.getFullName()%> - <%=groupUser.getEmailAddress()%></aui:option>
								<%
								}
							}
						}
						%>
				   </aui:select>
	             </div>  
		    </div>            
		</aui:fieldset>
		<aui:button-row>
		  	<div id="aui_popup_click">
		       	<aui:button id="saveForm" name="saveForm" type="submit" value="sendRequest" cssClass="btn-outline-info"></aui:button>
		   	</div>
		   	<div id="aui_popup_content" ></div>
		</aui:button-row>
	</aui:form>      
</div>
