<%@include file="../../init.jsp"%>

<%
Dymer dymer = (Dymer)request.getAttribute("dym_dymer");

dymer = dymer.toEscapedModel();
%>
 
dymerId: <%=dymer.getDymerId()%>
<p/>
name: <%=dymer.getName()%>