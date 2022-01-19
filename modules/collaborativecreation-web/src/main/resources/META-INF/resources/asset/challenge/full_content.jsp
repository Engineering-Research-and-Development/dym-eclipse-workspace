<%@include file="../../init.jsp"%>

<%
Challenge challenge = (Challenge)request.getAttribute("collaborativecreation_challenge");

challenge = challenge.toEscapedModel();
%>
 
challengeId: <%=challenge.getChallengeId()%>
<p/>
title: <%=challenge.getTitle()%>