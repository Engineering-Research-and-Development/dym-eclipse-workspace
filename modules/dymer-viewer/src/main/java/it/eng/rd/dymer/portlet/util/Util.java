package it.eng.rd.dymer.portlet.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

public class Util {

	private final static Log _log = LogFactoryUtil.getLog(Util.class);

	private String localesString = null;

	public List<Locale> getLocaleList(HttpServletRequest request) {
		List<Locale> localesList = new ArrayList<Locale>();

		localesString = "";
		//int locIndex = 1 ;
		Enumeration<Locale> el = request.getLocales();

		while (el.hasMoreElements()) {
			Locale nextElement = el.nextElement();
			if(!nextElement.getCountry().equals("")) {
				//System.out.println(locIndex + ")" + nextElement.getDisplayLanguage(nextElement));
				//locIndex++;
				localesList.add(nextElement);
				if(!localesString.isEmpty()) {
					localesString += ",";
				}
				localesString += nextElement.toString();
			}
		}

		return localesList;
	}

	public String getLocalesString() {
		return localesString;
	}

	public static List<Role> getAllSiteRoles() {
		Long companyId = CompanyThreadLocal.getCompanyId();
		List<Role> roles = new ArrayList<Role>();
		try {
			roles = RoleLocalServiceUtil.getRoles(companyId, new int[] {2});
		} catch (SystemException e) {
			_log.error(e.getMessage(), e.getCause());
		}

		return roles;
	}

	public static boolean isUserRoleOkay(long userId, long groupId, String[] rolesArray) {
		_log.info("Start isUserRoleOkay(...) with parameter");
		_log.info("userId = " + userId);
		_log.info("groupId = " + groupId);
		_log.info("rolesArray = " + Arrays.toString(rolesArray));


		boolean result = false;

		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		result = permissionChecker.isOmniadmin();

		for (int i = 0; rolesArray != null && i < rolesArray.length && !result; i++) {
			try {
				result = UserGroupRoleLocalServiceUtil.hasUserGroupRole(userId, groupId, Long.parseLong(rolesArray[i]));
			} catch (NumberFormatException e) {
				_log.error(e.getMessage(), e.getCause());
			} catch (SystemException e) {
				_log.error(e.getMessage(), e.getCause());
			}
		}

		return result;
	}
	
}
