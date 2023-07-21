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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DymerEntryService}.
 *
 * @author ENGRD
 * @see DymerEntryService
 * @generated
 */
public class DymerEntryServiceWrapper
	implements DymerEntryService, ServiceWrapper<DymerEntryService> {

	public DymerEntryServiceWrapper(DymerEntryService dymerEntryService) {
		_dymerEntryService = dymerEntryService;
	}

	@Deprecated
	@Override
	public void delete(long userId, String index, String type, String id) {
		_dymerEntryService.delete(userId, index, type, id);
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
	@Override
	public void delete(
		String emailAddress, long companyId, String index, String type,
		String id) {

		_dymerEntryService.delete(emailAddress, companyId, index, type, id);
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
	@Override
	public void delete(
		String emailAddress, long companyId, String index, String type,
		String id, boolean notify) {

		_dymerEntryService.delete(
			emailAddress, companyId, index, type, id, notify);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dymerEntryService.getOSGiServiceIdentifier();
	}

	/**
	 * Get userId and fullName by emailAddress of a Liferay user
	 *
	 * @param emailAddress the emailAddress of user
	 * @param companyId the primary key of the user's company
	 * @return service response json with userId and fullName
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getUserInfoByEmail(
		String emailAddress, long companyId) {

		return _dymerEntryService.getUserInfoByEmail(emailAddress, companyId);
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
	@Override
	public com.liferay.portal.kernel.json.JSONObject sendNotificationByRole(
		String companyId, String title, String description, String resourceId,
		String index, String type, String resourceLink, String sender,
		String role) {

		return _dymerEntryService.sendNotificationByRole(
			companyId, title, description, resourceId, index, type,
			resourceLink, sender, role);
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
	@Override
	public com.liferay.portal.kernel.json.JSONObject sendNotificationByTeam(
		String companyId, String groupId, String title, String description,
		String resourceId, String index, String type, String resourceLink,
		String sender, String team) {

		return _dymerEntryService.sendNotificationByTeam(
			companyId, groupId, title, description, resourceId, index, type,
			resourceLink, sender, team);
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
	@Override
	public com.liferay.portal.kernel.json.JSONObject sendPersonalNotification(
		String companyId, String title, String description, String resourceId,
		String index, String type, String resourceLink, String sender,
		String[] recipients) {

		return _dymerEntryService.sendPersonalNotification(
			companyId, title, description, resourceId, index, type,
			resourceLink, sender, recipients);
	}

	@Deprecated
	@Override
	public it.eng.rd.dymer.model.DymerEntry update(
		long userId, long groupId, String index, String type, String id,
		String url, String title, String extContent) {

		return _dymerEntryService.update(
			userId, groupId, index, type, id, url, title, extContent);
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
	@Override
	public it.eng.rd.dymer.model.DymerEntry update(
		String dymerDomainName, String emailAddress, long companyId,
		long groupId, String index, String type, String id, String url,
		String title, String extContent) {

		return _dymerEntryService.update(
			dymerDomainName, emailAddress, companyId, groupId, index, type, id,
			url, title, extContent);
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
	 * @param notify, if notify is true the system enables the sending of notifications; the user receives the notification according to the configuration he has set
	 */
	@Override
	public it.eng.rd.dymer.model.DymerEntry update(
		String dymerDomainName, String emailAddress, long companyId,
		long groupId, String index, String type, String id, String url,
		String title, String extContent, boolean notify) {

		return _dymerEntryService.update(
			dymerDomainName, emailAddress, companyId, groupId, index, type, id,
			url, title, extContent, notify);
	}

	@Override
	public DymerEntryService getWrappedService() {
		return _dymerEntryService;
	}

	@Override
	public void setWrappedService(DymerEntryService dymerEntryService) {
		_dymerEntryService = dymerEntryService;
	}

	private DymerEntryService _dymerEntryService;

}