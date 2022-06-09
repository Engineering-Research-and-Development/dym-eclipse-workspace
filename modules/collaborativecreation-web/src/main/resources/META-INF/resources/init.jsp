<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/comment" prefix="liferay-comment" %>

<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>

<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.PortletMode"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

<%@ page import="com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionUtil"%>
<%@ page import="com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission"%>
<%@ page import="com.liferay.portal.kernel.service.ResourceActionLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.security.permission.ResourcePermissionCheckerUtil"%>
<%@ page import="com.liferay.portal.kernel.security.permission.PermissionChecker"%>
<%@ page import="com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.service.ResourceLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.service.PermissionServiceUtil"%>
<%@ page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ page import="com.liferay.portal.kernel.util.*"%>
<%@ page import="com.liferay.petra.string.StringPool"%>
<%@ page import="com.liferay.portal.kernel.model.*"%>
<%@ page import="com.liferay.portal.kernel.theme.*"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.service.AssetTagLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetEntry" %>
<%@ page import="com.liferay.asset.kernel.model.AssetTag" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.comment.Discussion" %>
<%@ page import="com.liferay.portal.kernel.comment.CommentManagerUtil" %>
<%@ page import="com.liferay.portal.kernel.service.ServiceContextFunction" %>
<%@ page import="com.liferay.portal.kernel.service.CompanyLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.service.CountryServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.model.Company" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@ page import="com.liferay.document.library.kernel.model.DLFolder"%>
<%@ page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@ page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@ page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@ page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>

<%@ page import="it.eng.rd.collaborativecreation.model.*" %>
<%@ page import="it.eng.rd.collaborativecreation.service.*" %> 
<%@ page import="it.eng.rd.collaborativecreation.web.internal.security.permission.resource.*" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
/*Impostazione properties di linguaggio*/
String propertiesLanguage = locale.getLanguage();
String propertiesCountry = locale.getCountry();
ResourceBundle languages = ResourceBundle.getBundle("content/Language", new Locale(propertiesLanguage, propertiesCountry));
String deleteOperationConfirmation = languages.getString("deleteConfirmation");
String addMilestone = languages.getString("addMilestone");
String addToDo = languages.getString("addToDo");
String requestToCoCreate = languages.getString("requestToCoCreate");

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
/* SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); */
Calendar calendar = Calendar.getInstance();
Date nowDate = calendar.getTime();
List<Country> countries = CountryServiceUtil.getCountries();
List<AssetTag> assetTags = AssetTagLocalServiceUtil.getAssetTags(0, 999);
List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil.getAssetCategories(0, 999);
boolean isChallengeOwner = false;
List<Role> userRelatedRoles = RoleLocalServiceUtil.getUserRelatedRoles(themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
Iterator<Role> userRelatedRolesIt = userRelatedRoles.iterator();
while(userRelatedRolesIt.hasNext()){
	Role role = userRelatedRolesIt.next();
	if (role.getName().equalsIgnoreCase("SOCS Challenge Owner")){
		isChallengeOwner = true;
	}
}
%>

<aui:script>
AUI().use(
        'aui-datepicker',
        function(A) {
            new A.DatePicker({
                trigger: '.date',
                mask: '%d/%m/%Y',
                popover: {
                    zIndex: 1000
                }
            });
        }
);
</aui:script>

<script>
function updateFileList() {
  	var input = document.getElementById('uploadedFile');
  	var output = document.getElementById('fileList');

  	output.innerHTML = '<ul>';
  	for (var i = 0; i < input.files.length; ++i) {
    	output.innerHTML += '<li>' + input.files.item(i).name + '</li>';
  	}
  	output.innerHTML += '</ul>';
  	document.getElementById("clearFileList").style.display = "block";
}
function clearFileList(){
	document.getElementById("uploadedFile").value = "";
	var output = document.getElementById('fileList');
	output.innerHTML = "";
	document.getElementById("clearFileList").style.display = "none";
}
</script>