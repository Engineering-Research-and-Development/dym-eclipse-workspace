<%@ include file="../init.jsp"%>
<%
	long entryId = ParamUtil.getLong(renderRequest, "entryId");
	DymerEntry entry = DymerEntryLocalServiceUtil.getDymerEntry(entryId);
	entryId = entry.getEntryId();
	entry = entry.toEscapedModel();
%> 
<c:if test="<%= themeDisplay.isSignedIn() && isAdmin%>">
	<div class="container">
	  <div class="row align-items-start">
	    <div class="col">
	      <b>Title:</b>
	    </div>
	  </div>
	  <div class="row align-items-start">
	    <div class="col">
	      <%=entry.getTitle()%>
	    </div>
	  </div>
	  <hr/>
	  <div class="row align-items-start">
	    <div class="col">
	      <b>Content:</b>
	    </div>
	  </div>
	  <div class="row align-items-start">
	    <div class="col">
	      <%=entry.getExtContent()%>
	    </div>
	  </div>
	 
	 <hr/>
	 <div class="row align-items-start">
	    <div class="col">
	      <b>EntryId:</b> <%=entry.getEntryId()%>
	    </div>
	  </div>
	  <div class="row align-items-start">
	    <div class="col">
	      <b>DymerId:</b> <%=entry.getDymerId()%>
	    </div>
	  </div>
	  <div class="row align-items-start">
	    <div class="col">
	      <b>Index:</b> <%=entry.getIndex()%>
	    </div>
	  </div>
	  <div class="row align-items-start">
	    <div class="col">
	      <b>Type:</b> <%=entry.getType()%>
	    </div>
	  </div>
	  <div class="row align-items-start">
	    <div class="col">
	      <b>ID:</b> <%=entry.getId()%>
	    </div>
	  </div>
	  <div class="row align-items-start">
	    <div class="col">
	      <b>URL:</b> <%=entry.getUrl()%>
	    </div>
	  </div>
	  <div class="row align-items-start">
	    <div class="col">
	      <b>UserId:</b> <%=entry.getUserId()%>
	    </div>
	  </div>
	  <div class="row align-items-start">
	    <div class="col">
	      <b>UserName:</b> <%=entry.getUserName()%>
	    </div>
	  </div>
	</div>
</c:if>
 