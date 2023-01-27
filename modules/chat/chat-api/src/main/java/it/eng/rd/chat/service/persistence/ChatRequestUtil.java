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

package it.eng.rd.chat.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.chat.model.ChatRequest;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the chat request service. This utility wraps <code>it.eng.rd.chat.service.persistence.impl.ChatRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatRequestPersistence
 * @generated
 */
public class ChatRequestUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ChatRequest chatRequest) {
		getPersistence().clearCache(chatRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ChatRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChatRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChatRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChatRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ChatRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ChatRequest update(ChatRequest chatRequest) {
		return getPersistence().update(chatRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ChatRequest update(
		ChatRequest chatRequest, ServiceContext serviceContext) {

		return getPersistence().update(chatRequest, serviceContext);
	}

	/**
	 * Returns all the chat requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching chat requests
	 */
	public static List<ChatRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the chat requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @return the range of matching chat requests
	 */
	public static List<ChatRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the chat requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat requests
	 */
	public static List<ChatRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChatRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chat requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chat requests
	 */
	public static List<ChatRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChatRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	public static ChatRequest findByUuid_First(
			String uuid, OrderByComparator<ChatRequest> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	public static ChatRequest fetchByUuid_First(
		String uuid, OrderByComparator<ChatRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	public static ChatRequest findByUuid_Last(
			String uuid, OrderByComparator<ChatRequest> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	public static ChatRequest fetchByUuid_Last(
		String uuid, OrderByComparator<ChatRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the chat requests before and after the current chat request in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current chat request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat request
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	public static ChatRequest[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ChatRequest> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the chat requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of chat requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching chat requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the chat requests where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @return the matching chat requests
	 */
	public static List<ChatRequest> findByIsAccested(boolean isAccepted) {
		return getPersistence().findByIsAccested(isAccepted);
	}

	/**
	 * Returns a range of all the chat requests where isAccepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param isAccepted the is accepted
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @return the range of matching chat requests
	 */
	public static List<ChatRequest> findByIsAccested(
		boolean isAccepted, int start, int end) {

		return getPersistence().findByIsAccested(isAccepted, start, end);
	}

	/**
	 * Returns an ordered range of all the chat requests where isAccepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param isAccepted the is accepted
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat requests
	 */
	public static List<ChatRequest> findByIsAccested(
		boolean isAccepted, int start, int end,
		OrderByComparator<ChatRequest> orderByComparator) {

		return getPersistence().findByIsAccested(
			isAccepted, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chat requests where isAccepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param isAccepted the is accepted
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chat requests
	 */
	public static List<ChatRequest> findByIsAccested(
		boolean isAccepted, int start, int end,
		OrderByComparator<ChatRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsAccested(
			isAccepted, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	public static ChatRequest findByIsAccested_First(
			boolean isAccepted,
			OrderByComparator<ChatRequest> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatRequestException {

		return getPersistence().findByIsAccested_First(
			isAccepted, orderByComparator);
	}

	/**
	 * Returns the first chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	public static ChatRequest fetchByIsAccested_First(
		boolean isAccepted, OrderByComparator<ChatRequest> orderByComparator) {

		return getPersistence().fetchByIsAccested_First(
			isAccepted, orderByComparator);
	}

	/**
	 * Returns the last chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	public static ChatRequest findByIsAccested_Last(
			boolean isAccepted,
			OrderByComparator<ChatRequest> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatRequestException {

		return getPersistence().findByIsAccested_Last(
			isAccepted, orderByComparator);
	}

	/**
	 * Returns the last chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	public static ChatRequest fetchByIsAccested_Last(
		boolean isAccepted, OrderByComparator<ChatRequest> orderByComparator) {

		return getPersistence().fetchByIsAccested_Last(
			isAccepted, orderByComparator);
	}

	/**
	 * Returns the chat requests before and after the current chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param id the primary key of the current chat request
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat request
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	public static ChatRequest[] findByIsAccested_PrevAndNext(
			long id, boolean isAccepted,
			OrderByComparator<ChatRequest> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatRequestException {

		return getPersistence().findByIsAccested_PrevAndNext(
			id, isAccepted, orderByComparator);
	}

	/**
	 * Removes all the chat requests where isAccepted = &#63; from the database.
	 *
	 * @param isAccepted the is accepted
	 */
	public static void removeByIsAccested(boolean isAccepted) {
		getPersistence().removeByIsAccested(isAccepted);
	}

	/**
	 * Returns the number of chat requests where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @return the number of matching chat requests
	 */
	public static int countByIsAccested(boolean isAccepted) {
		return getPersistence().countByIsAccested(isAccepted);
	}

	/**
	 * Caches the chat request in the entity cache if it is enabled.
	 *
	 * @param chatRequest the chat request
	 */
	public static void cacheResult(ChatRequest chatRequest) {
		getPersistence().cacheResult(chatRequest);
	}

	/**
	 * Caches the chat requests in the entity cache if it is enabled.
	 *
	 * @param chatRequests the chat requests
	 */
	public static void cacheResult(List<ChatRequest> chatRequests) {
		getPersistence().cacheResult(chatRequests);
	}

	/**
	 * Creates a new chat request with the primary key. Does not add the chat request to the database.
	 *
	 * @param id the primary key for the new chat request
	 * @return the new chat request
	 */
	public static ChatRequest create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the chat request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chat request
	 * @return the chat request that was removed
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	public static ChatRequest remove(long id)
		throws it.eng.rd.chat.exception.NoSuchChatRequestException {

		return getPersistence().remove(id);
	}

	public static ChatRequest updateImpl(ChatRequest chatRequest) {
		return getPersistence().updateImpl(chatRequest);
	}

	/**
	 * Returns the chat request with the primary key or throws a <code>NoSuchChatRequestException</code> if it could not be found.
	 *
	 * @param id the primary key of the chat request
	 * @return the chat request
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	public static ChatRequest findByPrimaryKey(long id)
		throws it.eng.rd.chat.exception.NoSuchChatRequestException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the chat request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chat request
	 * @return the chat request, or <code>null</code> if a chat request with the primary key could not be found
	 */
	public static ChatRequest fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the chat requests.
	 *
	 * @return the chat requests
	 */
	public static List<ChatRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the chat requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @return the range of chat requests
	 */
	public static List<ChatRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the chat requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chat requests
	 */
	public static List<ChatRequest> findAll(
		int start, int end, OrderByComparator<ChatRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chat requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chat requests
	 */
	public static List<ChatRequest> findAll(
		int start, int end, OrderByComparator<ChatRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the chat requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of chat requests.
	 *
	 * @return the number of chat requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChatRequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ChatRequestPersistence, ChatRequestPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ChatRequestPersistence.class);

		ServiceTracker<ChatRequestPersistence, ChatRequestPersistence>
			serviceTracker =
				new ServiceTracker
					<ChatRequestPersistence, ChatRequestPersistence>(
						bundle.getBundleContext(), ChatRequestPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}