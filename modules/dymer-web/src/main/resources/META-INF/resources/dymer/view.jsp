<%@page import="com.liferay.portal.kernel.exception.NoSuchUserException"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@ include file="../init.jsp" %>

<%
List<Dymer> dymers = DymerLocalServiceUtil.getDymers(themeDisplay.getScopeGroupId());

long dymerId = 0;

if (dymers!=null && dymers.size()>0){
	dymerId = dymers.get(0).getDymerId();
}
%>

<c:if test="<%= themeDisplay.isSignedIn() && isAdmin%>">
<aui:form method="post" name="fm">
			<aui:input name="deleteDymerEntryIds" type="hidden" />
	<liferay-ui:search-container emptyResultsMessage="no-catalogue-resources-were-found" total="<%=DymerEntryLocalServiceUtil.getDymerEntriesCount()%>" rowChecker="<%= new RowChecker(renderResponse) %>">
	<liferay-ui:search-container-results
		results="<%=DymerEntryLocalServiceUtil.getDymerEntries(scopeGroupId.longValue(),
						dymerId, searchContainer.getStart(),
						searchContainer.getEnd())%>" />
	
		<aui:button cssClass="btn-lg" onClick='<%= liferayPortletResponse.getNamespace() + "deleteCatalogueResources(true);" %>' value="delete" />
		
		<liferay-ui:search-container-row className="it.eng.rd.dymer.model.DymerEntry" modelVar="entry" keyProperty="entryId">
			<liferay-ui:search-container-column-text property="entryId"  orderable="true" orderableProperty="entryId" />
			<liferay-ui:search-container-column-text property="dymerId"  orderable="true" orderableProperty="dymerId" />
			<liferay-ui:search-container-column-text property="index"  orderable="true" orderableProperty="index" />
			<liferay-ui:search-container-column-text property="type"  orderable="true" orderableProperty="type" />
			<liferay-ui:search-container-column-text property="id"  orderable="true" orderableProperty="id" />
			<liferay-ui:search-container-column-text property="title"  orderable="true" orderableProperty="title" value="<%=StringUtil.shorten(entry.getTitle(), 10) %>" />
			<liferay-ui:search-container-column-text name="extContent" value="<%=StringUtil.shorten(entry.getExtContent(), 20) %>"   orderable="true" orderableProperty="extContent" />
			<liferay-ui:search-container-column-text property="userId"  orderable="true" orderableProperty="userId" />
			<liferay-ui:search-container-column-text property="userName"  orderable="true" orderableProperty="userName" />
		
			<liferay-ui:search-container-column-jsp
				align="right" 
				path="/dymer/actions.jsp" />
		
		</liferay-ui:search-container-row>	
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	window['<portlet:namespace />deleteCatalogueResources'] = function (dicussion) {
	
		var deleteDymerEntryIds = Liferay.Util.listCheckedExcept(
			document.<portlet:namespace />fm,
			'<portlet:namespace />allRowIds'
		);

		if (
			deleteDymerEntryIds &&
			confirm(
				'<%= UnicodeLanguageUtil.get(portletConfig.getResourceBundle(locale), "are-you-sure-you-want-to-delete-the-selected-catalogue-resources") %>'
			)
		) {
			document.<portlet:namespace />fm.<portlet:namespace />deleteDymerEntryIds.value = deleteDymerEntryIds;

			if (dicussion) {
				submitForm(
					document.<portlet:namespace />fm,
					'<portlet:actionURL name="deleteByAdminAllEntries"></portlet:actionURL>'
				);
			}
		}
	};
</aui:script>
</c:if>