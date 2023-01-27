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
 * Provides a wrapper for {@link ChatRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChatRequestLocalService
 * @generated
 */
public class ChatRequestLocalServiceWrapper
	implements ChatRequestLocalService,
			   ServiceWrapper<ChatRequestLocalService> {

	public ChatRequestLocalServiceWrapper(
		ChatRequestLocalService chatRequestLocalService) {

		_chatRequestLocalService = chatRequestLocalService;
	}

	/**
	 * Adds the chat request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatRequest the chat request
	 * @return the chat request that was added
	 */
	@Override
	public it.eng.rd.chat.model.ChatRequest addChatRequest(
		it.eng.rd.chat.model.ChatRequest chatRequest) {

		return _chatRequestLocalService.addChatRequest(chatRequest);
	}

	/**
	 * Creates a new chat request with the primary key. Does not add the chat request to the database.
	 *
	 * @param id the primary key for the new chat request
	 * @return the new chat request
	 */
	@Override
	public it.eng.rd.chat.model.ChatRequest createChatRequest(long id) {
		return _chatRequestLocalService.createChatRequest(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatRequestLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the chat request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatRequest the chat request
	 * @return the chat request that was removed
	 */
	@Override
	public it.eng.rd.chat.model.ChatRequest deleteChatRequest(
		it.eng.rd.chat.model.ChatRequest chatRequest) {

		return _chatRequestLocalService.deleteChatRequest(chatRequest);
	}

	/**
	 * Deletes the chat request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the chat request
	 * @return the chat request that was removed
	 * @throws PortalException if a chat request with the primary key could not be found
	 */
	@Override
	public it.eng.rd.chat.model.ChatRequest deleteChatRequest(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatRequestLocalService.deleteChatRequest(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatRequestLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _chatRequestLocalService.dynamicQuery();
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

		return _chatRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatRequestModelImpl</code>.
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

		return _chatRequestLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatRequestModelImpl</code>.
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

		return _chatRequestLocalService.dynamicQuery(
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

		return _chatRequestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _chatRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.rd.chat.model.ChatRequest fetchChatRequest(long id) {
		return _chatRequestLocalService.fetchChatRequest(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _chatRequestLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the chat request with the primary key.
	 *
	 * @param id the primary key of the chat request
	 * @return the chat request
	 * @throws PortalException if a chat request with the primary key could not be found
	 */
	@Override
	public it.eng.rd.chat.model.ChatRequest getChatRequest(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatRequestLocalService.getChatRequest(id);
	}

	/**
	 * Returns a range of all the chat requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @return the range of chat requests
	 */
	@Override
	public java.util.List<it.eng.rd.chat.model.ChatRequest> getChatRequests(
		int start, int end) {

		return _chatRequestLocalService.getChatRequests(start, end);
	}

	/**
	 * Returns the number of chat requests.
	 *
	 * @return the number of chat requests
	 */
	@Override
	public int getChatRequestsCount() {
		return _chatRequestLocalService.getChatRequestsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _chatRequestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chatRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the chat request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatRequest the chat request
	 * @return the chat request that was updated
	 */
	@Override
	public it.eng.rd.chat.model.ChatRequest updateChatRequest(
		it.eng.rd.chat.model.ChatRequest chatRequest) {

		return _chatRequestLocalService.updateChatRequest(chatRequest);
	}

	@Override
	public ChatRequestLocalService getWrappedService() {
		return _chatRequestLocalService;
	}

	@Override
	public void setWrappedService(
		ChatRequestLocalService chatRequestLocalService) {

		_chatRequestLocalService = chatRequestLocalService;
	}

	private ChatRequestLocalService _chatRequestLocalService;

}