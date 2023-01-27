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

import it.eng.rd.chat.model.ChatConfigure;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the chat configure service. This utility wraps <code>it.eng.rd.chat.service.persistence.impl.ChatConfigurePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatConfigurePersistence
 * @generated
 */
public class ChatConfigureUtil {

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
	public static void clearCache(ChatConfigure chatConfigure) {
		getPersistence().clearCache(chatConfigure);
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
	public static Map<Serializable, ChatConfigure> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChatConfigure> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChatConfigure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChatConfigure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ChatConfigure> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ChatConfigure update(ChatConfigure chatConfigure) {
		return getPersistence().update(chatConfigure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ChatConfigure update(
		ChatConfigure chatConfigure, ServiceContext serviceContext) {

		return getPersistence().update(chatConfigure, serviceContext);
	}

	/**
	 * Returns all the chat configures where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching chat configures
	 */
	public static List<ChatConfigure> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the chat configures where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @return the range of matching chat configures
	 */
	public static List<ChatConfigure> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the chat configures where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat configures
	 */
	public static List<ChatConfigure> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChatConfigure> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chat configures where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chat configures
	 */
	public static List<ChatConfigure> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChatConfigure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first chat configure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat configure
	 * @throws NoSuchChatConfigureException if a matching chat configure could not be found
	 */
	public static ChatConfigure findByUuid_First(
			String uuid, OrderByComparator<ChatConfigure> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first chat configure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat configure, or <code>null</code> if a matching chat configure could not be found
	 */
	public static ChatConfigure fetchByUuid_First(
		String uuid, OrderByComparator<ChatConfigure> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last chat configure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat configure
	 * @throws NoSuchChatConfigureException if a matching chat configure could not be found
	 */
	public static ChatConfigure findByUuid_Last(
			String uuid, OrderByComparator<ChatConfigure> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last chat configure in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat configure, or <code>null</code> if a matching chat configure could not be found
	 */
	public static ChatConfigure fetchByUuid_Last(
		String uuid, OrderByComparator<ChatConfigure> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the chat configures before and after the current chat configure in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current chat configure
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat configure
	 * @throws NoSuchChatConfigureException if a chat configure with the primary key could not be found
	 */
	public static ChatConfigure[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ChatConfigure> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the chat configures where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of chat configures where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching chat configures
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the chat configure where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchChatConfigureException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching chat configure
	 * @throws NoSuchChatConfigureException if a matching chat configure could not be found
	 */
	public static ChatConfigure findByUUID_G(String uuid, long groupId)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the chat configure where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching chat configure, or <code>null</code> if a matching chat configure could not be found
	 */
	public static ChatConfigure fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the chat configure where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching chat configure, or <code>null</code> if a matching chat configure could not be found
	 */
	public static ChatConfigure fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the chat configure where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the chat configure that was removed
	 */
	public static ChatConfigure removeByUUID_G(String uuid, long groupId)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of chat configures where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching chat configures
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the chat configures where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching chat configures
	 */
	public static List<ChatConfigure> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the chat configures where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @return the range of matching chat configures
	 */
	public static List<ChatConfigure> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the chat configures where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat configures
	 */
	public static List<ChatConfigure> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChatConfigure> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chat configures where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chat configures
	 */
	public static List<ChatConfigure> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChatConfigure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first chat configure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat configure
	 * @throws NoSuchChatConfigureException if a matching chat configure could not be found
	 */
	public static ChatConfigure findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ChatConfigure> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first chat configure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat configure, or <code>null</code> if a matching chat configure could not be found
	 */
	public static ChatConfigure fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ChatConfigure> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last chat configure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat configure
	 * @throws NoSuchChatConfigureException if a matching chat configure could not be found
	 */
	public static ChatConfigure findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ChatConfigure> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last chat configure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat configure, or <code>null</code> if a matching chat configure could not be found
	 */
	public static ChatConfigure fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ChatConfigure> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the chat configures before and after the current chat configure in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current chat configure
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat configure
	 * @throws NoSuchChatConfigureException if a chat configure with the primary key could not be found
	 */
	public static ChatConfigure[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<ChatConfigure> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the chat configures where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of chat configures where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching chat configures
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the chat configures where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching chat configures
	 */
	public static List<ChatConfigure> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the chat configures where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @return the range of matching chat configures
	 */
	public static List<ChatConfigure> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the chat configures where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat configures
	 */
	public static List<ChatConfigure> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ChatConfigure> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chat configures where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chat configures
	 */
	public static List<ChatConfigure> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ChatConfigure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first chat configure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat configure
	 * @throws NoSuchChatConfigureException if a matching chat configure could not be found
	 */
	public static ChatConfigure findByGroupId_First(
			long groupId, OrderByComparator<ChatConfigure> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first chat configure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat configure, or <code>null</code> if a matching chat configure could not be found
	 */
	public static ChatConfigure fetchByGroupId_First(
		long groupId, OrderByComparator<ChatConfigure> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last chat configure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat configure
	 * @throws NoSuchChatConfigureException if a matching chat configure could not be found
	 */
	public static ChatConfigure findByGroupId_Last(
			long groupId, OrderByComparator<ChatConfigure> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last chat configure in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat configure, or <code>null</code> if a matching chat configure could not be found
	 */
	public static ChatConfigure fetchByGroupId_Last(
		long groupId, OrderByComparator<ChatConfigure> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the chat configures before and after the current chat configure in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current chat configure
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat configure
	 * @throws NoSuchChatConfigureException if a chat configure with the primary key could not be found
	 */
	public static ChatConfigure[] findByGroupId_PrevAndNext(
			long id, long groupId,
			OrderByComparator<ChatConfigure> orderByComparator)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().findByGroupId_PrevAndNext(
			id, groupId, orderByComparator);
	}

	/**
	 * Removes all the chat configures where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of chat configures where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching chat configures
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the chat configure in the entity cache if it is enabled.
	 *
	 * @param chatConfigure the chat configure
	 */
	public static void cacheResult(ChatConfigure chatConfigure) {
		getPersistence().cacheResult(chatConfigure);
	}

	/**
	 * Caches the chat configures in the entity cache if it is enabled.
	 *
	 * @param chatConfigures the chat configures
	 */
	public static void cacheResult(List<ChatConfigure> chatConfigures) {
		getPersistence().cacheResult(chatConfigures);
	}

	/**
	 * Creates a new chat configure with the primary key. Does not add the chat configure to the database.
	 *
	 * @param id the primary key for the new chat configure
	 * @return the new chat configure
	 */
	public static ChatConfigure create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the chat configure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chat configure
	 * @return the chat configure that was removed
	 * @throws NoSuchChatConfigureException if a chat configure with the primary key could not be found
	 */
	public static ChatConfigure remove(long id)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().remove(id);
	}

	public static ChatConfigure updateImpl(ChatConfigure chatConfigure) {
		return getPersistence().updateImpl(chatConfigure);
	}

	/**
	 * Returns the chat configure with the primary key or throws a <code>NoSuchChatConfigureException</code> if it could not be found.
	 *
	 * @param id the primary key of the chat configure
	 * @return the chat configure
	 * @throws NoSuchChatConfigureException if a chat configure with the primary key could not be found
	 */
	public static ChatConfigure findByPrimaryKey(long id)
		throws it.eng.rd.chat.exception.NoSuchChatConfigureException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the chat configure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chat configure
	 * @return the chat configure, or <code>null</code> if a chat configure with the primary key could not be found
	 */
	public static ChatConfigure fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the chat configures.
	 *
	 * @return the chat configures
	 */
	public static List<ChatConfigure> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the chat configures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @return the range of chat configures
	 */
	public static List<ChatConfigure> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the chat configures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chat configures
	 */
	public static List<ChatConfigure> findAll(
		int start, int end,
		OrderByComparator<ChatConfigure> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chat configures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chat configures
	 */
	public static List<ChatConfigure> findAll(
		int start, int end, OrderByComparator<ChatConfigure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the chat configures from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of chat configures.
	 *
	 * @return the number of chat configures
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChatConfigurePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ChatConfigurePersistence, ChatConfigurePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ChatConfigurePersistence.class);

		ServiceTracker<ChatConfigurePersistence, ChatConfigurePersistence>
			serviceTracker =
				new ServiceTracker
					<ChatConfigurePersistence, ChatConfigurePersistence>(
						bundle.getBundleContext(),
						ChatConfigurePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}