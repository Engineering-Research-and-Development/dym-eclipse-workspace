<%@ include file="/init.jsp" %>

<%
String redirectTo = request.getParameter("redirectTo");
long challengeId = ParamUtil.getLong(request, "challengeId");
long cocreationId = ParamUtil.getLong(request, "cocreationId");
/* List<User> users = UserLocalServiceUtil.getGroupUsers(themeDisplay.getScopeGroupId()); */
List<User> users = UserLocalServiceUtil.getUsers(0, 999);

User currentUser = themeDisplay.getUser();
List<Cocreator> allCocreators = new ArrayList();
List<Cocreator> cocreators = new ArrayList();
if (cocreationId > 0){
	/*Invito a partecipare ad una cocreazione : acquisisco tutti i cocreatori per la cocreazione di riferimento*/
	cocreators = CocreatorLocalServiceUtil.getCocreatorsByCocreationId(cocreationId);
	Iterator<Cocreator> cocreatorsIt = cocreators.iterator();
	while(cocreatorsIt.hasNext()){
			Cocreator cocreator = cocreatorsIt.next();
			allCocreators.add(cocreator);
	}
}
%>

<portlet:actionURL name="addMilestone" var="addMilestoneURL">
	<portlet:param name="active" value="true"/>
	<portlet:param name="challengeId" value="<%=String.valueOf(challengeId)%>"/>
	<portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
	<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:actionURL>

<liferay-ui:success key="actionSuccess" message="Operation performed"/>
<liferay-ui:error key="actionError" message="Operation performed"/>

<div id="milestoneFormContainer">
	<aui:form id="formMilestone" name="formMilestone" method="post" action="<%=addMilestoneURL.toString()%>">
		<aui:fieldset>
			<div class="clearfix" style="margin-right:20px; margin-left:20px;">
	             <div>
	             	<aui:input label="Co-creation" name="cocreation" id="cocreation" readonly="true" value="<%=CocreationLocalServiceUtil.getCocreation(cocreationId).getTitle()%>"/>
	             </div>
	             <div>
	             	<aui:input label="description" name="description" id="description" type="text" required='true'/>
	             </div>
	             <div>
	             	<aui:select label="assignTo" name="participants" id="participants" showEmptyOption="false" multiple="true" required="true">
	             		<aui:option selected="<%=true%>" value=""><liferay-ui:message key="select"/>...</aui:option>
						<%
						for (User groupUser : users) {
							boolean isCocreator = false;
							for (Cocreator cocreator : allCocreators) {
								if (groupUser.getUserId() == cocreator.getUserId()){
									isCocreator = true;
								}
							}
							if (isCocreator){
							%>
								<aui:option value="<%=groupUser.getUserId()%>"><%=groupUser.getFullName()%> - <%=groupUser.getEmailAddress()%></aui:option>
							<%
							}
						}
						%>
				   </aui:select>
	             </div> 
	             <div>  
		  			<label class="control-label"><liferay-ui:message key="expirationDate"/>*</label>
		  			<input id="expirationDate" name="expirationDate" class="form-control date" type="text" placeholder="dd/mm/yyyy" value="" required='true'>
			     </div> 
		    </div>            
		</aui:fieldset>
		<aui:button-row>
		  	<div id="aui_popup_click">
		       	<aui:button id="saveForm" name="saveForm" type="submit" value="publish" cssClass="btn-outline-info"></aui:button>
		       	<aui:button id="closePopup" name="closePopup" type="button" value="close" cssClass="btn-outline-info"></aui:button>
		   	</div>
		   	<div id="aui_popup_content" ></div>
		</aui:button-row>
	</aui:form>      
</div>

<aui:script use="aui-io-request,aui-node" >
	A.one('#<portlet:namespace/>closePopup').on('click',function(event){
		Liferay.Util.getOpener().refreshPortlet();
	});
</aui:script>