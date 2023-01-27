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
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.chat.model.ChatMessage;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ChatMessage. This utility wraps
 * <code>it.eng.rd.chat.service.impl.ChatMessageLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ChatMessageLocalService
 * @generated
 */
public class ChatMessageLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.rd.chat.service.impl.ChatMessageLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the chat message to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatMessageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatMessage the chat message
	 * @return the chat message that was added
	 */
	public static ChatMessage addChatMessage(ChatMessage chatMessage) {
		return getService().addChatMessage(chatMessage);
	}

	/**
	 * Creates a new chat message with the primary key. Does not add the chat message to the database.
	 *
	 * @param id the primary key for the new chat message
	 * @return the new chat message
	 */
	public static ChatMessage createChatMessage(long id) {
		return getService().createChatMessage(id);
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
	 * Deletes the chat message from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatMessageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatMessage the chat message
	 * @return the chat message that was removed
	 */
	public static ChatMessage deleteChatMessage(ChatMessage chatMessage) {
		return getService().deleteChatMessage(chatMessage);
	}

	/**
	 * Deletes the chat message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatMessageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the chat message
	 * @return the chat message that was removed
	 * @throws PortalException if a chat message with the primary key could not be found
	 */
	public static ChatMessage deleteChatMessage(long id)
		throws PortalException {

		return getService().deleteChatMessage(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatMessageModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatMessageModelImpl</code>.
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

	public static ChatMessage fetchChatMessage(long id) {
		return getService().fetchChatMessage(id);
	}

	/**
	 * Returns the chat message matching the UUID and group.
	 *
	 * @param uuid the chat message's UUID
	 * @param groupId the primary key of the group
	 * @return the matching chat message, or <code>null</code> if a matching chat message could not be found
	 */
	public static ChatMessage fetchChatMessageByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchChatMessageByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the chat message with the primary key.
	 *
	 * @param id the primary key of the chat message
	 * @return the chat message
	 * @throws PortalException if a chat message with the primary key could not be found
	 */
	public static ChatMessage getChatMessage(long id) throws PortalException {
		return getService().getChatMessage(id);
	}

	/**
	 * Returns the chat message matching the UUID and group.
	 *
	 * @param uuid the chat message's UUID
	 * @param groupId the primary key of the group
	 * @return the matching chat message
	 * @throws PortalException if a matching chat message could not be found
	 */
	public static ChatMessage getChatMessageByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getChatMessageByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the chat messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @return the range of chat messages
	 */
	public static List<ChatMessage> getChatMessages(int start, int end) {
		return getService().getChatMessages(start, end);
	}

	/**
	 * Returns all the chat messages matching the UUID and company.
	 *
	 * @param uuid the UUID of the chat messages
	 * @param companyId the primary key of the company
	 * @return the matching chat messages, or an empty list if no matches were found
	 */
	public static List<ChatMessage> getChatMessagesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getChatMessagesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of chat messages matching the UUID and company.
	 *
	 * @param uuid the UUID of the chat messages
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching chat messages, or an empty list if no matches were found
	 */
	public static List<ChatMessage> getChatMessagesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChatMessage> orderByComparator) {

		return getService().getChatMessagesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of chat messages.
	 *
	 * @return the number of chat messages
	 */
	public static int getChatMessagesCount() {
		return getService().getChatMessagesCount();
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

	public static List<com.liferay.portal.kernel.model.User>
		getUserByRecentChat(long userId) {

		return getService().getUserByRecentChat(userId);
	}

	/**
	 * Updates the chat message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatMessageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatMessage the chat message
	 * @return the chat message that was updated
	 */
	public static ChatMessage updateChatMessage(ChatMessage chatMessage) {
		return getService().updateChatMessage(chatMessage);
	}

	public static ChatMessageLocalService getService() {
		return _service;
	}

	private static volatile ChatMessageLocalService _service;

}