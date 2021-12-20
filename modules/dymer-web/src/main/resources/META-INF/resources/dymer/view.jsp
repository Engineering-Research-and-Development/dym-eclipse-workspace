<%@ include file="../init.jsp" %>

<%

List<Dymer> dymers = DymerLocalServiceUtil.getDymers(themeDisplay.getScopeGroupId());

long dymerId = 0;

if (dymers!=null && dymers.size()>0){
	dymerId = dymers.get(0).getDymerId();
}

%>


	
<liferay-ui:search-container total="<%=DymerEntryLocalServiceUtil.getDymerEntriesCount()%>">
<liferay-ui:search-container-results
	results="<%=DymerEntryLocalServiceUtil.getDymerEntries(scopeGroupId.longValue(),
					dymerId, searchContainer.getStart(),
					searchContainer.getEnd())%>" />

	<liferay-ui:search-container-row className="it.eng.rd.dymer.model.DymerEntry" modelVar="entry">
		<liferay-ui:search-container-column-text property="entryId" />
		<liferay-ui:search-container-column-text property="dymerId" />
		<liferay-ui:search-container-column-text property="index" />
		<liferay-ui:search-container-column-text property="type" />
		<liferay-ui:search-container-column-text property="id" />
		<liferay-ui:search-container-column-text property="title" />
		<liferay-ui:search-container-column-text property="extContent" />
		<liferay-ui:search-container-column-text property="url" />
	
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>




					


