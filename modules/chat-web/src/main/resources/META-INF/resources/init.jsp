<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<c:set var="now" value="<%=new Date()%>"/>
<fmt:formatDate var="temp" pattern="s" type="time"  value = "${now}" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/socket.css">

<script src="<%=request.getContextPath()%>/js/socket.common.js?${temp}"></script>
<script src="<%=request.getContextPath()%>/js/socket.chat.js?${temp}"></script>
<script src="<%=request.getContextPath()%>/js/socket.js?${temp}"></script>
<script src="<%=request.getContextPath()%>/js/notification.js?${temp}"></script>
<script src="<%=request.getContextPath()%>/js/moment.js?${temp}"></script>
<script>
$(document).ready(function() {
	initWebSocket('${socketChatEndPointPath}');
});
</script>