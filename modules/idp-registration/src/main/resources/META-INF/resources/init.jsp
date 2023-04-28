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
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>

<%@ page import="it.eng.rd.idp.registration.portlet.configuration.IdpRegistrationConfiguration" %>
<%@ page import="it.eng.rd.idp.registration.constants.IdpRegistrationPortletKeys" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />


<%

Log _log = LogFactoryUtil.getLog("init.jsp");
IdpRegistrationConfiguration idpUserRegistrationConfiguration =	(IdpRegistrationConfiguration)renderRequest.getAttribute(IdpRegistrationConfiguration.class.getName());




String idmUrl = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	idmUrl = portletPreferences.getValue("idmUrl", idpUserRegistrationConfiguration.idmUrl());
}
String idmEmailAdmin = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	idmEmailAdmin = portletPreferences.getValue("idmEmailAdmin", idpUserRegistrationConfiguration.idmEmailAdmin());
}
String idmEmailAdminNotification = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	idmEmailAdminNotification = portletPreferences.getValue("idmEmailAdminNotification", idpUserRegistrationConfiguration.idmEmailAdminNotification());
}
String idmPasswordAdmin = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	idmPasswordAdmin = portletPreferences.getValue("idmPasswordAdmin", idpUserRegistrationConfiguration.idmPasswordAdmin());
}
String idmEnable = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	idmEnable = portletPreferences.getValue("idmEnable", idpUserRegistrationConfiguration.idmEnable());
}
boolean idmEnable_ = false;
if (idmEnable!=null && !idmEnable.isEmpty()){
	if(idmEnable.equalsIgnoreCase("on") ){
		idmEnable_=true;
	}
}
String idmActive = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	idmActive = portletPreferences.getValue("idmActive", idpUserRegistrationConfiguration.idmActive());
}
boolean idmActive_ = false;
if (idmActive!=null && !idmActive.isEmpty()){
	if(idmActive.equalsIgnoreCase("on") ){
		idmActive_=true;
	}
}
String mailSubject = IdpRegistrationPortletKeys.MAIL_SUBJECT_DEFAULT;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	mailSubject = portletPreferences.getValue("mailSubject", idpUserRegistrationConfiguration.mailSubject());
}
String from = IdpRegistrationPortletKeys.FROM_DEFAULT;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	from = portletPreferences.getValue("from", idpUserRegistrationConfiguration.from());
}
String projectName = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	projectName = portletPreferences.getValue("projectName", idpUserRegistrationConfiguration.projectName());
}
String logoLiferayPortalUrl = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	logoLiferayPortalUrl = portletPreferences.getValue("logoLiferayPortalUrl", idpUserRegistrationConfiguration.logoLiferayPortalUrl());
}
String liferayPortalName = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	liferayPortalName = portletPreferences.getValue("liferayPortalName", idpUserRegistrationConfiguration.liferayPortalName());
}
String liferayPortalUrl = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	liferayPortalUrl = portletPreferences.getValue("liferayPortalUrl", idpUserRegistrationConfiguration.liferayPortalUrl());
}
String termsOfUseUrl = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	termsOfUseUrl = portletPreferences.getValue("termsOfUseUrl", idpUserRegistrationConfiguration.termsOfUseUrl());
}
String organizationTypelist = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	organizationTypelist = portletPreferences.getValue("organizationTypelist", idpUserRegistrationConfiguration.organizationTypelist());
}
String[] organizationType_NAMES = StringUtil.splitLines(organizationTypelist);

String copyrightCompany = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	copyrightCompany = portletPreferences.getValue("copyrightCompany", idpUserRegistrationConfiguration.copyrightCompany());
}
String copyrightCompanyUrl = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	copyrightCompanyUrl = portletPreferences.getValue("copyrightCompanyUrl", idpUserRegistrationConfiguration.copyrightCompanyUrl());
}
String templateID = StringPool.BLANK;
if (Validator.isNotNull(idpUserRegistrationConfiguration)) {
	templateID = portletPreferences.getValue("templateID", idpUserRegistrationConfiguration.templateID());
}
%>
<c:set var="idmEnable_" value="<%=idmEnable_ %>" />
<c:set var="idmActive_" value="<%=idmActive_ %>" />
