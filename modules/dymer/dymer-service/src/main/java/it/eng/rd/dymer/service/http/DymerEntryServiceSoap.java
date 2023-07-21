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

import it.eng.rd.dymer.service.DymerEntryServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>DymerEntryServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>it.eng.rd.dymer.model.DymerEntrySoap</code>. If the method in the
 * service utility returns a
 * <code>it.eng.rd.dymer.model.DymerEntry</code>, that is translated to a
 * <code>it.eng.rd.dymer.model.DymerEntrySoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author ENGRD
 * @see DymerEntryServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DymerEntryServiceSoap {

	/**
	 * Add/Update Dymer Resource
	 *
	 * @param dymerDomainName
	 * @param emailAddress the emailAddress of user owner of the resource
	 * @param companyId the primary key of the user's company
	 * @param groupId
	 * @param index the index name of the Dymer resource
	 * @param type the type name of the Dymer resource
	 * @param id the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param url the Dymer Portal URL
	 * @param title the title Dymer resource
	 * @param extContent the Dymer resource description
	 * @param notify, if notify is true the system enables the sending of notifications; the user receives the notification according to the configuration he has set
	 */
	public static it.eng.rd.dymer.model.DymerEntrySoap update(
			String dymerDomainName, String emailAddress, long companyId,
			long groupId, String index, String type, String id, String url,
			String title, String extContent, boolean notify)
		throws RemoteException {

		try {
			it.eng.rd.dymer.model.DymerEntry returnValue =
				DymerEntryServiceUtil.update(
					dymerDomainName, emailAddress, companyId, groupId, index,
					type, id, url, title, extContent, notify);

			return it.eng.rd.dymer.model.DymerEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Add/Update Dymer Resource
	 *
	 * @param dymerDomainName
	 * @param emailAddress the emailAddress of user owner of the resource
	 * @param companyId the primary key of the user's company
	 * @param groupId
	 * @param index the index name of the Dymer resource
	 * @param type the type name of the Dymer resource
	 * @param id the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param url the Dymer Portal URL
	 * @param title the title Dymer resource
	 * @param extContent the Dymer resource description
	 * @param notify is true by default so the system enables the sending of notifications; the user receives the notification according to the configuration he has set
	 */
	@Deprecated
	public static it.eng.rd.dymer.model.DymerEntrySoap update(
			String dymerDomainName, String emailAddress, long companyId,
			long groupId, String index, String type, String id, String url,
			String title, String extContent)
		throws RemoteException {

		try {
			it.eng.rd.dymer.model.DymerEntry returnValue =
				DymerEntryServiceUtil.update(
					dymerDomainName, emailAddress, companyId, groupId, index,
					type, id, url, title, extContent);

			return it.eng.rd.dymer.model.DymerEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Delete Dymer Resource
	 *
	 * @param emailAddress the emailAddress of user owner of the resource
	 * @param companyId the primary key of the user's company
	 * @param index the index name of the Dymer resource
	 * @param type the type name of the Dymer resource
	 * @param id the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param notify, if true send notification
	 */
	public static void delete(
			String emailAddress, long companyId, String index, String type,
			String id, boolean notify)
		throws RemoteException {

		try {
			DymerEntryServiceUtil.delete(
				emailAddress, companyId, index, type, id, notify);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Delete Dymer Resource
	 *
	 * @param emailAddress the emailAddress of user owner of the resource
	 * @param companyId the primary key of the user's company
	 * @param index the index name of the Dymer resource
	 * @param type the type name of the Dymer resource
	 * @param id the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param notify, if true send notification
	 */
	@Deprecated
	public static void delete(
			String emailAddress, long companyId, String index, String type,
			String id)
		throws RemoteException {

		try {
			DymerEntryServiceUtil.delete(
				emailAddress, companyId, index, type, id);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Get userId and fullName by emailAddress of a Liferay user
	 *
	 * @param emailAddress the emailAddress of user
	 * @param companyId the primary key of the user's company
	 * @return service response json with userId and fullName
	 */
	public static String getUserInfoByEmail(String emailAddress, long companyId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				DymerEntryServiceUtil.getUserInfoByEmail(
					emailAddress, companyId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Send Dymer notification to a list of Liferay users
	 *
	 * @param companyId the primary key of the user's company
	 * @param title the Dymer notification title
	 * @param description the Dymer notification description
	 * @param resourceId the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param index the index name of the Dymer resource
	 * @param type the type name of the Dymer resource
	 * @param resourceLink the relative URL of the resource
	 * @param sender the email address of the sender of the notification
	 * @param recipients the email addresses array of the notification recipients (if the recipient is the owner of the resource, the notification does not start)
	 * @return service response json: success true if everything went well or success false and the type of error otherwise
	 */
	public static String sendPersonalNotification(
			String companyId, String title, String description,
			String resourceId, String index, String type, String resourceLink,
			String sender, String[] recipients)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				DymerEntryServiceUtil.sendPersonalNotification(
					companyId, title, description, resourceId, index, type,
					resourceLink, sender, recipients);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Send a Dymer Notification to a list of Liferay users who have the indicated role
	 *
	 * @param companyId the primary key of the user's company
	 * @param title the Dymer notification title
	 * @param description the Dymer notification description
	 * @param resourceId the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param index the index name of the Dymer resource
	 * @param type the type name of the Dymer resource
	 * @param resourceLink the relative URL of the resource
	 * @param sender the email address of the sender of the notification
	 * @param role the role of the users receiving the notification
	 * @return service response json: success true if everything went well or success false and the type of error otherwise
	 */
	public static String sendNotificationByRole(
			String companyId, String title, String description,
			String resourceId, String index, String type, String resourceLink,
			String sender, String role)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				DymerEntryServiceUtil.sendNotificationByRole(
					companyId, title, description, resourceId, index, type,
					resourceLink, sender, role);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Send a Dymer Notification to a list of Liferay users who belong to the indicated team
	 *
	 * @param companyId the primary key of the user's company
	 * @param title the Dymer notification title
	 * @param description the Dymer notification description
	 * @param resourceId the Dymer resource ID (e.g. basedyml-eym6-4168-3806-138016813806)
	 * @param index the index name of the Dymer resource
	 * @param type the type name of the Dymer resource
	 * @param resourceLink the relative URL of the resource
	 * @param sender the email address of the sender of the notification
	 * @param team the team of the users receiving the notification
	 * @return service response json: success true if everything went well or success false and the type of error otherwise
	 */
	public static String sendNotificationByTeam(
			String companyId, String groupId, String title, String description,
			String resourceId, String index, String type, String resourceLink,
			String sender, String team)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				DymerEntryServiceUtil.sendNotificationByTeam(
					companyId, groupId, title, description, resourceId, index,
					type, resourceLink, sender, team);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	@Deprecated
	public static it.eng.rd.dymer.model.DymerEntrySoap update(
			long userId, long groupId, String index, String type, String id,
			String url, String title, String extContent)
		throws RemoteException {

		try {
			it.eng.rd.dymer.model.DymerEntry returnValue =
				DymerEntryServiceUtil.update(
					userId, groupId, index, type, id, url, title, extContent);

			return it.eng.rd.dymer.model.DymerEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	@Deprecated
	public static void delete(long userId, String index, String type, String id)
		throws RemoteException {

		try {
			DymerEntryServiceUtil.delete(userId, index, type, id);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		DymerEntryServiceSoap.class);

}