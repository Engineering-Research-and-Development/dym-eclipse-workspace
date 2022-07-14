<%@include file="../init.jsp"%>
<%@ page import="it.eng.rd.dymer.model.DymerEntry" %>
<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
DymerEntry entry = (DymerEntry)row.getObject(); 
%>
<c:if test="<%= themeDisplay.isSignedIn() && isAdmin%>">
<liferay-ui:icon-menu>
	<c:if test="<%= isAdmin %>">
		<portlet:renderURL var="viewEntryURL">
		  <portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
		  <portlet:param name="mvcPath" value="/dymer/entry_details.jsp" />
		</portlet:renderURL>
		
		<liferay-ui:icon image="view" message="View" url="<%= viewEntryURL.toString() %>" />
	</c:if>

	<c:if test="<%= false %>">
		<portlet:actionURL name="deleteEntry" var="deleteURL">
			<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete image="remove" url="<%=deleteURL.toString() %>" />
	</c:if>
	
	<c:if test="<%= false %>">
 		<portlet:renderURL var="editURL">
 			<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
 			<portlet:param name="mvcPath" value="/dymer/edit_entry.jsp" />
 		</portlet:renderURL>

 		<liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
 	</c:if>
</liferay-ui:icon-menu>
</c:if>