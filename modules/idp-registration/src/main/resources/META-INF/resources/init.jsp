<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>

<%@ page import="it.eng.rd.idp.registration.portlet.configuration.IdpRegistrationConfiguration" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />


<%

Log _log = LogFactoryUtil.getLog("init.jsp");
IdpRegistrationConfiguration idpUserRegistrationConfiguration =	(IdpRegistrationConfiguration)renderRequest.getAttribute(IdpRegistrationConfiguration.class.getName());

String idmUrl = "";
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	idmUrl = portletPreferences.getValue("idmUrl", idpUserRegistrationConfiguration.idmUrl());
}
String idmEmailAdmin = "";
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	idmEmailAdmin = portletPreferences.getValue("idmEmailAdmin", idpUserRegistrationConfiguration.idmEmailAdmin());
}
String idmPasswordAdmin = "";
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	idmPasswordAdmin = portletPreferences.getValue("idmPasswordAdmin", idpUserRegistrationConfiguration.idmPasswordAdmin());
}
String idmEnable = "";
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	idmEnable = portletPreferences.getValue("idmEnable", idpUserRegistrationConfiguration.idmEnable());
}
boolean idmEnable_ = false;
if (idmEnable!=null && !idmEnable.isEmpty()){
	if(idmEnable.equalsIgnoreCase("on") ){
		idmEnable_=true;
	}
}

String mailSubject = "Collaboration Portal Registration";
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	mailSubject = portletPreferences.getValue("mailSubject", idpUserRegistrationConfiguration.mailSubject());
}
String from = "noreply@server.com";
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	from = portletPreferences.getValue("from", idpUserRegistrationConfiguration.from());
}
String projectName = "";
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	projectName = portletPreferences.getValue("projectName", idpUserRegistrationConfiguration.projectName());
}
String logoLiferayPortalUrl = "";
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	logoLiferayPortalUrl = portletPreferences.getValue("logoLiferayPortalUrl", idpUserRegistrationConfiguration.logoLiferayPortalUrl());
}
String liferayPortalName = "";
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	liferayPortalName = portletPreferences.getValue("liferayPortalName", idpUserRegistrationConfiguration.liferayPortalName());
}
String liferayPortalUrl = "";
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	liferayPortalUrl = portletPreferences.getValue("liferayPortalUrl", idpUserRegistrationConfiguration.liferayPortalUrl());
}
%>
<c:set var="idmEnable_" value="<%=idmEnable_ %>" />
 