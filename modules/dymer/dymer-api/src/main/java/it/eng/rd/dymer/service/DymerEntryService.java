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

package it.eng.rd.dymer.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import it.eng.rd.dymer.model.DymerEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for DymerEntry. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author ENGRD
 * @see DymerEntryServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DymerEntryService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.rd.dymer.service.impl.DymerEntryServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dymer entry remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DymerEntryServiceUtil} if injection and service tracking are not available.
	 */
	@Deprecated
	@JSONWebService(method = "POST", value = "delete")
	public void delete(long userId, String index, String type, String id);

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
	@JSONWebService(method = "POST", value = "delete")
	public void delete(
		String emailAddress, long companyId, String index, String type,
		String id);

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
	@JSONWebService(method = "POST", value = "delete")
	public void delete(
		String emailAddress, long companyId, String index, String type,
		String id, boolean notify);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Get userId and fullName by emailAddress of a Liferay user
	 *
	 * @param emailAddress the emailAddress of user
	 * @param companyId the primary key of the user's company
	 * @return service response json with userId and fullName
	 */
	@JSONWebService(method = "POST", value = "getUserInfoByEmail")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getUserInfoByEmail(String emailAddress, long companyId);

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
	@JSONWebService(method = "POST", value = "sendNotificationByRole")
	public JSONObject sendNotificationByRole(
		String companyId, String title, String description, String resourceId,
		String index, String type, String resourceLink, String sender,
		String role);

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
	@JSONWebService(method = "POST", value = "sendNotificationByTeam")
	public JSONObject sendNotificationByTeam(
		String companyId, String groupId, String title, String description,
		String resourceId, String index, String type, String resourceLink,
		String sender, String team);

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
	 * @param recipients the email addresses array of the notification recipients
	 * @return service response json: success true if everything went well or success false and the type of error otherwise
	 */
	@JSONWebService(method = "POST", value = "sendPersonalNotification")
	public JSONObject sendPersonalNotification(
		String companyId, String title, String description, String resourceId,
		String index, String type, String resourceLink, String sender,
		String[] recipients);

	@Deprecated
	@JSONWebService(method = "POST", value = "update")
	public DymerEntry update(
		long userId, long groupId, String index, String type, String id,
		String url, String title, String extContent);

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
	@JSONWebService(method = "POST", value = "update")
	public DymerEntry update(
		String dymerDomainName, String emailAddress, long companyId,
		long groupId, String index, String type, String id, String url,
		String title, String extContent);

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
	@JSONWebService(method = "POST", value = "update")
	public DymerEntry update(
		String dymerDomainName, String emailAddress, long companyId,
		long groupId, String index, String type, String id, String url,
		String title, String extContent, boolean notify);

}