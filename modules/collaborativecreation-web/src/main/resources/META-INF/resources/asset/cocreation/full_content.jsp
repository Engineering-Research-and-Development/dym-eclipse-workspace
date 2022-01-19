<%@include file="../../init.jsp"%>

<%
Cocreation cocreation = (Cocreation)request.getAttribute("collaborativecreation_cocreation");

cocreation = cocreation.toEscapedModel();
%>
 
cocreationId: <%=cocreation.getCocreationId()%>
<p/>
title: <%=cocreation.getTitle()%>