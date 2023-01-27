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

package it.eng.rd.chat.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.chat.model.ChatConfigure;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ChatConfigure. This utility wraps
 * <code>it.eng.rd.chat.service.impl.ChatConfigureLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ChatConfigureLocalService
 * @generated
 */
public class ChatConfigureLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.rd.chat.service.impl.ChatConfigureLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the chat configure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatConfigureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatConfigure the chat configure
	 * @return the chat configure that was added
	 */
	public static ChatConfigure addChatConfigure(ChatConfigure chatConfigure) {
		return getService().addChatConfigure(chatConfigure);
	}

	/**
	 * Creates a new chat configure with the primary key. Does not add the chat configure to the database.
	 *
	 * @param id the primary key for the new chat configure
	 * @return the new chat configure
	 */
	public static ChatConfigure createChatConfigure(long id) {
		return getService().createChatConfigure(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the chat configure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatConfigureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatConfigure the chat configure
	 * @return the chat configure that was removed
	 */
	public static ChatConfigure deleteChatConfigure(
		ChatConfigure chatConfigure) {

		return getService().deleteChatConfigure(chatConfigure);
	}

	/**
	 * Deletes the chat configure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatConfigureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the chat configure
	 * @return the chat configure that was removed
	 * @throws PortalException if a chat configure with the primary key could not be found
	 */
	public static ChatConfigure deleteChatConfigure(long id)
		throws PortalException {

		return getService().deleteChatConfigure(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ChatConfigure fetchChatConfigure(long id) {
		return getService().fetchChatConfigure(id);
	}

	/**
	 * Returns the chat configure matching the UUID and group.
	 *
	 * @param uuid the chat configure's UUID
	 * @param groupId the primary key of the group
	 * @return the matching chat configure, or <code>null</code> if a matching chat configure could not be found
	 */
	public static ChatConfigure fetchChatConfigureByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchChatConfigureByUuidAndGroupId(uuid, groupId);
	}

	public static List<ChatConfigure> FindConfigureByGroupId(long groupId)
		throws SystemException {

		return getService().FindConfigureByGroupId(groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the chat configure with the primary key.
	 *
	 * @param id the primary key of the chat configure
	 * @return the chat configure
	 * @throws PortalException if a chat configure with the primary key could not be found
	 */
	public static ChatConfigure getChatConfigure(long id)
		throws PortalException {

		return getService().getChatConfigure(id);
	}

	/**
	 * Returns the chat configure matching the UUID and group.
	 *
	 * @param uuid the chat configure's UUID
	 * @param groupId the primary key of the group
	 * @return the matching chat configure
	 * @throws PortalException if a matching chat configure could not be found
	 */
	public static ChatConfigure getChatConfigureByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getChatConfigureByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the chat configures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @return the range of chat configures
	 */
	public static List<ChatConfigure> getChatConfigures(int start, int end) {
		return getService().getChatConfigures(start, end);
	}

	/**
	 * Returns all the chat configures matching the UUID and company.
	 *
	 * @param uuid the UUID of the chat configures
	 * @param companyId the primary key of the company
	 * @return the matching chat configures, or an empty list if no matches were found
	 */
	public static List<ChatConfigure> getChatConfiguresByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getChatConfiguresByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of chat configures matching the UUID and company.
	 *
	 * @param uuid the UUID of the chat configures
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching chat configures, or an empty list if no matches were found
	 */
	public static List<ChatConfigure> getChatConfiguresByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChatConfigure> orderByComparator) {

		return getService().getChatConfiguresByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of chat configures.
	 *
	 * @return the number of chat configures
	 */
	public static int getChatConfiguresCount() {
		return getService().getChatConfiguresCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the chat configure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatConfigureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatConfigure the chat configure
	 * @return the chat configure that was updated
	 */
	public static ChatConfigure updateChatConfigure(
		ChatConfigure chatConfigure) {

		return getService().updateChatConfigure(chatConfigure);
	}

	public static ChatConfigureLocalService getService() {
		return _service;
	}

	private static volatile ChatConfigureLocalService _service;

}