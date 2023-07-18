/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.rd.dymer.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import it.eng.rd.dymer.service.DymerEntryServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>DymerEntryServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author ENGRD
 * @see DymerEntryServiceSoap
 * @generated
 */
public class DymerEntryServiceHttp {

	public static it.eng.rd.dymer.model.DymerEntry update(
		HttpPrincipal httpPrincipal, String dymerDomainName,
		String emailAddress, long companyId, long groupId, String index,
		String type, String id, String url, String title, String extContent,
		boolean notify) {

		try {
			MethodKey methodKey = new MethodKey(
				DymerEntryServiceUtil.class, "update", _updateParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, dymerDomainName, emailAddress, companyId, groupId,
				index, type, id, url, title, extContent, notify);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (it.eng.rd.dymer.model.DymerEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static it.eng.rd.dymer.model.DymerEntry update(
		HttpPrincipal httpPrincipal, String dymerDomainName,
		String emailAddress, long companyId, long groupId, String index,
		String type, String id, String url, String title, String extContent) {

		try {
			MethodKey methodKey = new MethodKey(
				DymerEntryServiceUtil.class, "update", _updateParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, dymerDomainName, emailAddress, companyId, groupId,
				index, type, id, url, title, extContent);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (it.eng.rd.dymer.model.DymerEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void delete(
		HttpPrincipal httpPrincipal, String emailAddress, long companyId,
		String index, String type, String id, boolean notify) {

		try {
			MethodKey methodKey = new MethodKey(
				DymerEntryServiceUtil.class, "delete", _deleteParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, emailAddress, companyId, index, type, id, notify);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void delete(
		HttpPrincipal httpPrincipal, String emailAddress, long companyId,
		String index, String type, String id) {

		try {
			MethodKey methodKey = new MethodKey(
				DymerEntryServiceUtil.class, "delete", _deleteParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, emailAddress, companyId, index, type, id);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getUserInfoByEmail(
		HttpPrincipal httpPrincipal, String emailAddress, long companyId) {

		try {
			MethodKey methodKey = new MethodKey(
				DymerEntryServiceUtil.class, "getUserInfoByEmail",
				_getUserInfoByEmailParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, emailAddress, companyId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject
		sendPersonalNotification(
			HttpPrincipal httpPrincipal, String companyId, String title,
			String description, String resourceId, String index, String type,
			String resourceLink, String sender, String[] recipients) {

		try {
			MethodKey methodKey = new MethodKey(
				DymerEntryServiceUtil.class, "sendPersonalNotification",
				_sendPersonalNotificationParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, title, description, resourceId, index,
				type, resourceLink, sender, recipients);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject
		sendNotificationByRole(
			HttpPrincipal httpPrincipal, String companyId, String title,
			String description, String resourceId, String index, String type,
			String resourceLink, String sender, String role) {

		try {
			MethodKey methodKey = new MethodKey(
				DymerEntryServiceUtil.class, "sendNotificationByRole",
				_sendNotificationByRoleParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, title, description, resourceId, index,
				type, resourceLink, sender, role);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject
		sendNotificationByTeam(
			HttpPrincipal httpPrincipal, String companyId, String groupId,
			String title, String description, String resourceId, String index,
			String type, String resourceLink, String sender, String team) {

		try {
			MethodKey methodKey = new MethodKey(
				DymerEntryServiceUtil.class, "sendNotificationByTeam",
				_sendNotificationByTeamParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, groupId, title, description, resourceId,
				index, type, resourceLink, sender, team);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static it.eng.rd.dymer.model.DymerEntry update(
		HttpPrincipal httpPrincipal, long userId, long groupId, String index,
		String type, String id, String url, String title, String extContent) {

		try {
			MethodKey methodKey = new MethodKey(
				DymerEntryServiceUtil.class, "update", _updateParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, groupId, index, type, id, url, title,
				extContent);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (it.eng.rd.dymer.model.DymerEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void delete(
		HttpPrincipal httpPrincipal, long userId, String index, String type,
		String id) {

		try {
			MethodKey methodKey = new MethodKey(
				DymerEntryServiceUtil.class, "delete", _deleteParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, index, type, id);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		DymerEntryServiceHttp.class);

	private static final Class<?>[] _updateParameterTypes0 = new Class[] {
		String.class, String.class, long.class, long.class, String.class,
		String.class, String.class, String.class, String.class, String.class,
		boolean.class
	};
	private static final Class<?>[] _updateParameterTypes1 = new Class[] {
		String.class, String.class, long.class, long.class, String.class,
		String.class, String.class, String.class, String.class, String.class
	};
	private static final Class<?>[] _deleteParameterTypes3 = new Class[] {
		String.class, long.class, String.class, String.class, String.class,
		boolean.class
	};
	private static final Class<?>[] _deleteParameterTypes4 = new Class[] {
		String.class, long.class, String.class, String.class, String.class
	};
	private static final Class<?>[] _getUserInfoByEmailParameterTypes5 =
		new Class[] {String.class, long.class};
	private static final Class<?>[] _sendPersonalNotificationParameterTypes6 =
		new Class[] {
			String.class, String.class, String.class, String.class,
			String.class, String.class, String.class, String.class,
			String[].class
		};
	private static final Class<?>[] _sendNotificationByRoleParameterTypes7 =
		new Class[] {
			String.class, String.class, String.class, String.class,
			String.class, String.class, String.class, String.class, String.class
		};
	private static final Class<?>[] _sendNotificationByTeamParameterTypes8 =
		new Class[] {
			String.class, String.class, String.class, String.class,
			String.class, String.class, String.class, String.class,
			String.class, String.class
		};
	private static final Class<?>[] _updateParameterTypes10 = new Class[] {
		long.class, long.class, String.class, String.class, String.class,
		String.class, String.class, String.class
	};
	private static final Class<?>[] _deleteParameterTypes11 = new Class[] {
		long.class, String.class, String.class, String.class
	};

}