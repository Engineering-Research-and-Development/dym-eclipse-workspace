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

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%  
	User currentUser = themeDisplay.getUser();
	
	JSONObject userInfoJSONObject = JSONFactoryUtil.createJSONObject();
	JSONArray roleArray = JSONFactoryUtil.createJSONArray();
	List<Role> roles = currentUser.getRoles();
	Boolean isAdmin = false;
	for (Role role : roles) {
		JSONObject userRole = JSONFactoryUtil.createJSONObject();
		userRole.put("id", role.getRoleId());
		if (Validator.isNotNull(role.getName()) && role.getName().equalsIgnoreCase("Administrator")){
			isAdmin = true;
		}
		userRole.put("role", role.getName());
		roleArray.put(userRole);
	}
	userInfoJSONObject.put("username", currentUser.getFullName());
	userInfoJSONObject.put("app_azf_domain", "");
	userInfoJSONObject.put("authorization_decision", "");
	userInfoJSONObject.put("id", "");
	userInfoJSONObject.put("email", currentUser.getEmailAddress());
	userInfoJSONObject.put("isGravatarEnabled", false);
	userInfoJSONObject.put("app_id", "");
	userInfoJSONObject.put("roles", roleArray);
	JSONObject extraInfoJSONObject = JSONFactoryUtil.createJSONObject();
	extraInfoJSONObject.put("userId", currentUser.getUserId());
	extraInfoJSONObject.put("groupId", themeDisplay.getScopeGroupId());
	extraInfoJSONObject.put("companyId", currentUser.getCompanyId());
	extraInfoJSONObject.put("cms", "lfr");
 	extraInfoJSONObject.put("virtualhost", company.getVirtualHostname());
	userInfoJSONObject.put("extrainfo", extraInfoJSONObject);
	
	JSONObject dymerExtraInfoJSONObject = JSONFactoryUtil.createJSONObject();
	dymerExtraInfoJSONObject.put("extrainfo", extraInfoJSONObject);


	String dymerToken = userInfoJSONObject.toJSONString();
	String dymerJwt = new String (Base64.getEncoder().encode(dymerToken.getBytes()));
	
	String dymerExtraJwt = new String (Base64.getEncoder().encode((dymerExtraInfoJSONObject.toJSONString()).getBytes()));
	
// 	String showbread = portletPreferences.getValue("showbread", dymerViewerConfiguration.showbread());
// 	boolean roleOkay = Util.isUserRoleOkay(currentUser.getUserId(), themeDisplay.getSiteGroup().getGroupId(), checkedRoles);
	
%>

<script type="text/javascript">
	var dymExtraJWT = '<%=dymerExtraJwt%>';
	var dymJWT = '<%=dymerJwt%>';
	localStorage.setItem('DYM_EXTRA', dymExtraJWT );
	localStorage.setItem('DYM', dymJWT );
</script>



    
    