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
 * Provides a wrapper for {@link ChatConfigureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChatConfigureLocalService
 * @generated
 */
public class ChatConfigureLocalServiceWrapper
	implements ChatConfigureLocalService,
			   ServiceWrapper<ChatConfigureLocalService> {

	public ChatConfigureLocalServiceWrapper(
		ChatConfigureLocalService chatConfigureLocalService) {

		_chatConfigureLocalService = chatConfigureLocalService;
	}

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
	@Override
	public it.eng.rd.chat.model.ChatConfigure addChatConfigure(
		it.eng.rd.chat.model.ChatConfigure chatConfigure) {

		return _chatConfigureLocalService.addChatConfigure(chatConfigure);
	}

	/**
	 * Creates a new chat configure with the primary key. Does not add the chat configure to the database.
	 *
	 * @param id the primary key for the new chat configure
	 * @return the new chat configure
	 */
	@Override
	public it.eng.rd.chat.model.ChatConfigure createChatConfigure(long id) {
		return _chatConfigureLocalService.createChatConfigure(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatConfigureLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public it.eng.rd.chat.model.ChatConfigure deleteChatConfigure(
		it.eng.rd.chat.model.ChatConfigure chatConfigure) {

		return _chatConfigureLocalService.deleteChatConfigure(chatConfigure);
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
	@Override
	public it.eng.rd.chat.model.ChatConfigure deleteChatConfigure(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatConfigureLocalService.deleteChatConfigure(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatConfigureLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _chatConfigureLocalService.dynamicQuery();
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

		return _chatConfigureLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _chatConfigureLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _chatConfigureLocalService.dynamicQuery(
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

		return _chatConfigureLocalService.dynamicQueryCount(dynamicQuery);
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

		return _chatConfigureLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.rd.chat.model.ChatConfigure fetchChatConfigure(long id) {
		return _chatConfigureLocalService.fetchChatConfigure(id);
	}

	/**
	 * Returns the chat configure matching the UUID and group.
	 *
	 * @param uuid the chat configure's UUID
	 * @param groupId the primary key of the group
	 * @return the matching chat configure, or <code>null</code> if a matching chat configure could not be found
	 */
	@Override
	public it.eng.rd.chat.model.ChatConfigure
		fetchChatConfigureByUuidAndGroupId(String uuid, long groupId) {

		return _chatConfigureLocalService.fetchChatConfigureByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<it.eng.rd.chat.model.ChatConfigure>
			FindConfigureByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _chatConfigureLocalService.FindConfigureByGroupId(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _chatConfigureLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the chat configure with the primary key.
	 *
	 * @param id the primary key of the chat configure
	 * @return the chat configure
	 * @throws PortalException if a chat configure with the primary key could not be found
	 */
	@Override
	public it.eng.rd.chat.model.ChatConfigure getChatConfigure(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatConfigureLocalService.getChatConfigure(id);
	}

	/**
	 * Returns the chat configure matching the UUID and group.
	 *
	 * @param uuid the chat configure's UUID
	 * @param groupId the primary key of the group
	 * @return the matching chat configure
	 * @throws PortalException if a matching chat configure could not be found
	 */
	@Override
	public it.eng.rd.chat.model.ChatConfigure getChatConfigureByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatConfigureLocalService.getChatConfigureByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<it.eng.rd.chat.model.ChatConfigure> getChatConfigures(
		int start, int end) {

		return _chatConfigureLocalService.getChatConfigures(start, end);
	}

	/**
	 * Returns all the chat configures matching the UUID and company.
	 *
	 * @param uuid the UUID of the chat configures
	 * @param companyId the primary key of the company
	 * @return the matching chat configures, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.chat.model.ChatConfigure>
		getChatConfiguresByUuidAndCompanyId(String uuid, long companyId) {

		return _chatConfigureLocalService.getChatConfiguresByUuidAndCompanyId(
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
	@Override
	public java.util.List<it.eng.rd.chat.model.ChatConfigure>
		getChatConfiguresByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.chat.model.ChatConfigure> orderByComparator) {

		return _chatConfigureLocalService.getChatConfiguresByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of chat configures.
	 *
	 * @return the number of chat configures
	 */
	@Override
	public int getChatConfiguresCount() {
		return _chatConfigureLocalService.getChatConfiguresCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _chatConfigureLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _chatConfigureLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chatConfigureLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chatConfigureLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public it.eng.rd.chat.model.ChatConfigure updateChatConfigure(
		it.eng.rd.chat.model.ChatConfigure chatConfigure) {

		return _chatConfigureLocalService.updateChatConfigure(chatConfigure);
	}

	@Override
	public ChatConfigureLocalService getWrappedService() {
		return _chatConfigureLocalService;
	}

	@Override
	public void setWrappedService(
		ChatConfigureLocalService chatConfigureLocalService) {

		_chatConfigureLocalService = chatConfigureLocalService;
	}

	private ChatConfigureLocalService _chatConfigureLocalService;

}