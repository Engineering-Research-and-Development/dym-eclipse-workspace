<%@ include file="/init.jsp" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaException" %>

<portlet:defineObjects />

<c:if test="${success}">
		<div class="alert alert-success">
			<liferay-ui:message key="${message}" /> 
		</div>
</c:if>
<c:if test="${error}">
	<div class="alert alert-danger"><liferay-ui:message key="${message}" /> </div>
</c:if>