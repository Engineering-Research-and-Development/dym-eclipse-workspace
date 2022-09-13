<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.portal.kernel.model.PersistedModel" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="it.eng.rd.dymer.model.Dymer" %>
<%@ page import="it.eng.rd.dymer.service.DymerEntryLocalServiceUtil" %>
<%@ page import="it.eng.rd.dymer.service.DymerLocalServiceUtil" %>
<%@ page import="it.eng.rd.dymer.model.DymerEntry" %> 
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.service.AssetTagLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %>
<%@ page import="com.liferay.asset.kernel.model.AssetTag" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.comment.Discussion" %>
<%@ page import="com.liferay.portal.kernel.comment.CommentManagerUtil" %>
<%@ page import="com.liferay.portal.kernel.service.ServiceContextFunction" %>

<%@ page import="it.eng.rd.dymer.web.internal.security.permission.resource.DymerModelPermission" %>
<%@ page import="it.eng.rd.dymer.web.internal.security.permission.resource.DymerPermission" %>
<%@ page import="it.eng.rd.dymer.web.internal.security.permission.resource.DymerEntryPermission" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>

<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="java.util.List" %>

<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Base64" %>

<%@ page import="com.liferay.portal.kernel.model.Company" %>
<%@ page import="com.liferay.portal.kernel.service.CompanyLocalServiceUtil" %>

<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.Validator" %>


<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>


<%@ page import="it.eng.rd.dymer.web.util.crypto.AesCrypto"%>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="it.eng.rd.dymer.portlet.constants.DymerPortletKeys" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%  
	Log log = LogFactoryUtil.getLog("init.jsp");

	User currentUser = themeDisplay.getUser();
	
	List<Role> roles = currentUser.getRoles();
	Boolean isAdmin = false;
	for (Role role : roles) {
		JSONObject userRole = JSONFactoryUtil.createJSONObject();
		userRole.put("id", role.getRoleId());
		if (Validator.isNotNull(role.getName()) && role.getName().equalsIgnoreCase("Administrator")){
			isAdmin = true;
		}
	}
	
	String[] jwts = AesCrypto.dymerJwts(currentUser, themeDisplay.getScopeGroupId());
	
	String dymerJwt = AesCrypto.encrypting(jwts[0]);
	if (dymerJwt.equalsIgnoreCase(jwts[0])){	
		dymerJwt = new String (Base64.getEncoder().encode(dymerJwt.getBytes()));
		if (log.isDebugEnabled())
			log.debug("[dymer-web] dymerJwt base64: "+dymerJwt);
	}
	String dymerExtraJwt = new String (Base64.getEncoder().encode((jwts[1]).getBytes()));
%>

<script type="text/javascript">
	var dymJWT = '<%=dymerJwt%>';
	var dymExtraJWT = '<%=dymerExtraJwt%>';
	localStorage.setItem('DYM', dymJWT );
	localStorage.setItem('DYM_EXTRA', dymExtraJWT );
</script>

<!-- upgrade 300822 --> 