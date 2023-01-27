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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ChatMessageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChatMessageLocalService
 * @generated
 */
public class ChatMessageLocalServiceWrapper
	implements ChatMessageLocalService,
			   ServiceWrapper<ChatMessageLocalService> {

	public ChatMessageLocalServiceWrapper(
		ChatMessageLocalService chatMessageLocalService) {

		_chatMessageLocalService = chatMessageLocalService;
	}

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
	@Override
	public it.eng.rd.chat.model.ChatMessage addChatMessage(
		it.eng.rd.chat.model.ChatMessage chatMessage) {

		return _chatMessageLocalService.addChatMessage(chatMessage);
	}

	/**
	 * Creates a new chat message with the primary key. Does not add the chat message to the database.
	 *
	 * @param id the primary key for the new chat message
	 * @return the new chat message
	 */
	@Override
	public it.eng.rd.chat.model.ChatMessage createChatMessage(long id) {
		return _chatMessageLocalService.createChatMessage(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatMessageLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public it.eng.rd.chat.model.ChatMessage deleteChatMessage(
		it.eng.rd.chat.model.ChatMessage chatMessage) {

		return _chatMessageLocalService.deleteChatMessage(chatMessage);
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
	@Override
	public it.eng.rd.chat.model.ChatMessage deleteChatMessage(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatMessageLocalService.deleteChatMessage(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatMessageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _chatMessageLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _chatMessageLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _chatMessageLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _chatMessageLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _chatMessageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _chatMessageLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.rd.chat.model.ChatMessage fetchChatMessage(long id) {
		return _chatMessageLocalService.fetchChatMessage(id);
	}

	/**
	 * Returns the chat message matching the UUID and group.
	 *
	 * @param uuid the chat message's UUID
	 * @param groupId the primary key of the group
	 * @return the matching chat message, or <code>null</code> if a matching chat message could not be found
	 */
	@Override
	public it.eng.rd.chat.model.ChatMessage fetchChatMessageByUuidAndGroupId(
		String uuid, long groupId) {

		return _chatMessageLocalService.fetchChatMessageByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _chatMessageLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the chat message with the primary key.
	 *
	 * @param id the primary key of the chat message
	 * @return the chat message
	 * @throws PortalException if a chat message with the primary key could not be found
	 */
	@Override
	public it.eng.rd.chat.model.ChatMessage getChatMessage(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatMessageLocalService.getChatMessage(id);
	}

	/**
	 * Returns the chat message matching the UUID and group.
	 *
	 * @param uuid the chat message's UUID
	 * @param groupId the primary key of the group
	 * @return the matching chat message
	 * @throws PortalException if a matching chat message could not be found
	 */
	@Override
	public it.eng.rd.chat.model.ChatMessage getChatMessageByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatMessageLocalService.getChatMessageByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<it.eng.rd.chat.model.ChatMessage> getChatMessages(
		int start, int end) {

		return _chatMessageLocalService.getChatMessages(start, end);
	}

	/**
	 * Returns all the chat messages matching the UUID and company.
	 *
	 * @param uuid the UUID of the chat messages
	 * @param companyId the primary key of the company
	 * @return the matching chat messages, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.chat.model.ChatMessage>
		getChatMessagesByUuidAndCompanyId(String uuid, long companyId) {

		return _chatMessageLocalService.getChatMessagesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<it.eng.rd.chat.model.ChatMessage>
		getChatMessagesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.chat.model.ChatMessage> orderByComparator) {

		return _chatMessageLocalService.getChatMessagesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of chat messages.
	 *
	 * @return the number of chat messages
	 */
	@Override
	public int getChatMessagesCount() {
		return _chatMessageLocalService.getChatMessagesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _chatMessageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chatMessageLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatMessageLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User>
		getUserByRecentChat(long userId) {

		return _chatMessageLocalService.getUserByRecentChat(userId);
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
	@Override
	public it.eng.rd.chat.model.ChatMessage updateChatMessage(
		it.eng.rd.chat.model.ChatMessage chatMessage) {

		return _chatMessageLocalService.updateChatMessage(chatMessage);
	}

	@Override
	public ChatMessageLocalService getWrappedService() {
		return _chatMessageLocalService;
	}

	@Override
	public void setWrappedService(
		ChatMessageLocalService chatMessageLocalService) {

		_chatMessageLocalService = chatMessageLocalService;
	}

	private ChatMessageLocalService _chatMessageLocalService;

}