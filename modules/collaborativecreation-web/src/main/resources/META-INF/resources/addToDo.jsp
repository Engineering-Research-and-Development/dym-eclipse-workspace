<%@ include file="/init.jsp" %>

<%
String redirectTo = request.getParameter("redirectTo");
long challengeId = ParamUtil.getLong(request, "challengeId");
long cocreationId = ParamUtil.getLong(request, "cocreationId");
List<User> users = UserLocalServiceUtil.getGroupUsers(themeDisplay.getScopeGroupId());
User currentUser = themeDisplay.getUser();
%>

<portlet:actionURL name="addToDo" var="addToDoURL">
	<portlet:param name="active" value="true"/>
	<portlet:param name="challengeId" value="<%=String.valueOf(challengeId)%>"/>
	<portlet:param name="cocreationId" value="<%=String.valueOf(cocreationId)%>"/>
	<portlet:param name="redirectTo" value="<%=PortalUtil.getCurrentURL(request) %>"></portlet:param>
</portlet:actionURL>

<liferay-ui:success key="actionSuccess" message="Operation performed"/>
<liferay-ui:error key="actionError" message="Operation performed"/>

<div id="toDoFormContainer">
	<aui:form id="formToDo" name="formToDo" method="post" action="<%=addToDoURL.toString()%>">
		<aui:fieldset>
			<div class="clearfix" style="margin-right:20px; margin-left:20px;">
	             <div>
	             	<aui:input label="Cocreation" name="cocreation" id="cocreation" readonly="true" value="<%=CocreationLocalServiceUtil.getCocreation(cocreationId).getTitle()%>"/>
	             </div>
	             <div>
	             	<aui:input label="Description" name="description" id="description" type="text" required='true'/>
	             </div>
	             <div>  
		  			<label class="control-label">Date</label>
		  			<input id="date" name="date" class="form-control date" type="text" placeholder="dd/mm/yyyy" value="" required='true'>
			     </div> 
		    </div>            
		</aui:fieldset>
		<aui:button-row>
		  	<div id="aui_popup_click">
		       	<aui:button id="saveForm" name="saveForm" type="submit" value="Post" cssClass="btn-outline-info"></aui:button>
		   	</div>
		   	<div id="aui_popup_content" ></div>
		</aui:button-row>
	</aui:form>      
</div>
