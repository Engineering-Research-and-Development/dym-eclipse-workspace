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

package it.eng.rd.dymer.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.dymer.model.DymerEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the dymer entry service. This utility wraps <code>it.eng.rd.dymer.service.persistence.impl.DymerEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see DymerEntryPersistence
 * @generated
 */
public class DymerEntryUtil {

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
	public static void clearCache(DymerEntry dymerEntry) {
		getPersistence().clearCache(dymerEntry);
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
	public static Map<Serializable, DymerEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DymerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DymerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DymerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DymerEntry update(DymerEntry dymerEntry) {
		return getPersistence().update(dymerEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DymerEntry update(
		DymerEntry dymerEntry, ServiceContext serviceContext) {

		return getPersistence().update(dymerEntry, serviceContext);
	}

	/**
	 * Returns all the dymer entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dymer entries
	 */
	public static List<DymerEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the dymer entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries
	 */
	public static List<DymerEntry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the dymer entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries
	 */
	public static List<DymerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dymer entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymer entries
	 */
	public static List<DymerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByUuid_First(
			String uuid, OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByUuid_First(
		String uuid, OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByUuid_Last(
			String uuid, OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public static DymerEntry[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			entryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the dymer entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of dymer entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dymer entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the dymer entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDymerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByUUID_G(String uuid, long groupId)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dymer entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dymer entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the dymer entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dymer entry that was removed
	 */
	public static DymerEntry removeByUUID_G(String uuid, long groupId)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of dymer entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dymer entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dymer entries
	 */
	public static List<DymerEntry> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries
	 */
	public static List<DymerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries
	 */
	public static List<DymerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymer entries
	 */
	public static List<DymerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public static DymerEntry[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			entryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the dymer entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dymer entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the matching dymer entries
	 */
	public static List<DymerEntry> findByG_D(long groupId, long dymerId) {
		return getPersistence().findByG_D(groupId, dymerId);
	}

	/**
	 * Returns a range of all the dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries
	 */
	public static List<DymerEntry> findByG_D(
		long groupId, long dymerId, int start, int end) {

		return getPersistence().findByG_D(groupId, dymerId, start, end);
	}

	/**
	 * Returns an ordered range of all the dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries
	 */
	public static List<DymerEntry> findByG_D(
		long groupId, long dymerId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().findByG_D(
			groupId, dymerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymer entries
	 */
	public static List<DymerEntry> findByG_D(
		long groupId, long dymerId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_D(
			groupId, dymerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByG_D_First(
			long groupId, long dymerId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByG_D_First(
			groupId, dymerId, orderByComparator);
	}

	/**
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByG_D_First(
		long groupId, long dymerId,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().fetchByG_D_First(
			groupId, dymerId, orderByComparator);
	}

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByG_D_Last(
			long groupId, long dymerId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByG_D_Last(
			groupId, dymerId, orderByComparator);
	}

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByG_D_Last(
		long groupId, long dymerId,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().fetchByG_D_Last(
			groupId, dymerId, orderByComparator);
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public static DymerEntry[] findByG_D_PrevAndNext(
			long entryId, long groupId, long dymerId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByG_D_PrevAndNext(
			entryId, groupId, dymerId, orderByComparator);
	}

	/**
	 * Returns all the dymer entries that the user has permission to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the matching dymer entries that the user has permission to view
	 */
	public static List<DymerEntry> filterFindByG_D(long groupId, long dymerId) {
		return getPersistence().filterFindByG_D(groupId, dymerId);
	}

	/**
	 * Returns a range of all the dymer entries that the user has permission to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries that the user has permission to view
	 */
	public static List<DymerEntry> filterFindByG_D(
		long groupId, long dymerId, int start, int end) {

		return getPersistence().filterFindByG_D(groupId, dymerId, start, end);
	}

	/**
	 * Returns an ordered range of all the dymer entries that the user has permissions to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries that the user has permission to view
	 */
	public static List<DymerEntry> filterFindByG_D(
		long groupId, long dymerId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().filterFindByG_D(
			groupId, dymerId, start, end, orderByComparator);
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set of dymer entries that the user has permission to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public static DymerEntry[] filterFindByG_D_PrevAndNext(
			long entryId, long groupId, long dymerId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().filterFindByG_D_PrevAndNext(
			entryId, groupId, dymerId, orderByComparator);
	}

	/**
	 * Removes all the dymer entries where groupId = &#63; and dymerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 */
	public static void removeByG_D(long groupId, long dymerId) {
		getPersistence().removeByG_D(groupId, dymerId);
	}

	/**
	 * Returns the number of dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the number of matching dymer entries
	 */
	public static int countByG_D(long groupId, long dymerId) {
		return getPersistence().countByG_D(groupId, dymerId);
	}

	/**
	 * Returns the number of dymer entries that the user has permission to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the number of matching dymer entries that the user has permission to view
	 */
	public static int filterCountByG_D(long groupId, long dymerId) {
		return getPersistence().filterCountByG_D(groupId, dymerId);
	}

	/**
	 * Returns all the dymer entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching dymer entries
	 */
	public static List<DymerEntry> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the dymer entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries
	 */
	public static List<DymerEntry> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the dymer entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries
	 */
	public static List<DymerEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dymer entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymer entries
	 */
	public static List<DymerEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByStatus_First(
			int status, OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByStatus_First(
		int status, OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByStatus_Last(
			int status, OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByStatus_Last(
		int status, OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where status = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public static DymerEntry[] findByStatus_PrevAndNext(
			long entryId, int status,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByStatus_PrevAndNext(
			entryId, status, orderByComparator);
	}

	/**
	 * Removes all the dymer entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of dymer entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching dymer entries
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching dymer entries
	 */
	public static List<DymerEntry> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries
	 */
	public static List<DymerEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries
	 */
	public static List<DymerEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymer entries
	 */
	public static List<DymerEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public static DymerEntry[] findByG_S_PrevAndNext(
			long entryId, long groupId, int status,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByG_S_PrevAndNext(
			entryId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the dymer entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching dymer entries that the user has permission to view
	 */
	public static List<DymerEntry> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the dymer entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries that the user has permission to view
	 */
	public static List<DymerEntry> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the dymer entries that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries that the user has permission to view
	 */
	public static List<DymerEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set of dymer entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public static DymerEntry[] filterFindByG_S_PrevAndNext(
			long entryId, long groupId, int status,
			OrderByComparator<DymerEntry> orderByComparator)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			entryId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the dymer entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching dymer entries
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of dymer entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching dymer entries that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns the dymer entry where index = &#63; and type = &#63; and id = &#63; or throws a <code>NoSuchDymerEntryException</code> if it could not be found.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public static DymerEntry findByForIndexTypeId(
			String index, String type, String id)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByForIndexTypeId(index, type, id);
	}

	/**
	 * Returns the dymer entry where index = &#63; and type = &#63; and id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByForIndexTypeId(
		String index, String type, String id) {

		return getPersistence().fetchByForIndexTypeId(index, type, id);
	}

	/**
	 * Returns the dymer entry where index = &#63; and type = &#63; and id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchByForIndexTypeId(
		String index, String type, String id, boolean useFinderCache) {

		return getPersistence().fetchByForIndexTypeId(
			index, type, id, useFinderCache);
	}

	/**
	 * Removes the dymer entry where index = &#63; and type = &#63; and id = &#63; from the database.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the dymer entry that was removed
	 */
	public static DymerEntry removeByForIndexTypeId(
			String index, String type, String id)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().removeByForIndexTypeId(index, type, id);
	}

	/**
	 * Returns the number of dymer entries where index = &#63; and type = &#63; and id = &#63;.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the number of matching dymer entries
	 */
	public static int countByForIndexTypeId(
		String index, String type, String id) {

		return getPersistence().countByForIndexTypeId(index, type, id);
	}

	/**
	 * Caches the dymer entry in the entity cache if it is enabled.
	 *
	 * @param dymerEntry the dymer entry
	 */
	public static void cacheResult(DymerEntry dymerEntry) {
		getPersistence().cacheResult(dymerEntry);
	}

	/**
	 * Caches the dymer entries in the entity cache if it is enabled.
	 *
	 * @param dymerEntries the dymer entries
	 */
	public static void cacheResult(List<DymerEntry> dymerEntries) {
		getPersistence().cacheResult(dymerEntries);
	}

	/**
	 * Creates a new dymer entry with the primary key. Does not add the dymer entry to the database.
	 *
	 * @param entryId the primary key for the new dymer entry
	 * @return the new dymer entry
	 */
	public static DymerEntry create(long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	 * Removes the dymer entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry that was removed
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public static DymerEntry remove(long entryId)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().remove(entryId);
	}

	public static DymerEntry updateImpl(DymerEntry dymerEntry) {
		return getPersistence().updateImpl(dymerEntry);
	}

	/**
	 * Returns the dymer entry with the primary key or throws a <code>NoSuchDymerEntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public static DymerEntry findByPrimaryKey(long entryId)
		throws it.eng.rd.dymer.exception.NoSuchDymerEntryException {

		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	 * Returns the dymer entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry, or <code>null</code> if a dymer entry with the primary key could not be found
	 */
	public static DymerEntry fetchByPrimaryKey(long entryId) {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	 * Returns all the dymer entries.
	 *
	 * @return the dymer entries
	 */
	public static List<DymerEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dymer entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of dymer entries
	 */
	public static List<DymerEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dymer entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dymer entries
	 */
	public static List<DymerEntry> findAll(
		int start, int end, OrderByComparator<DymerEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dymer entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dymer entries
	 */
	public static List<DymerEntry> findAll(
		int start, int end, OrderByComparator<DymerEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dymer entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dymer entries.
	 *
	 * @return the number of dymer entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DymerEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DymerEntryPersistence, DymerEntryPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DymerEntryPersistence.class);

		ServiceTracker<DymerEntryPersistence, DymerEntryPersistence>
			serviceTracker =
				new ServiceTracker
					<DymerEntryPersistence, DymerEntryPersistence>(
						bundle.getBundleContext(), DymerEntryPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}