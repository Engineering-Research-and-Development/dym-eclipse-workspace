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

package it.eng.rd.collaborativecreation.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.collaborativecreation.model.Cocreator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cocreator service. This utility wraps <code>it.eng.rd.collaborativecreation.service.persistence.impl.CocreatorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see CocreatorPersistence
 * @generated
 */
public class CocreatorUtil {

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
	public static void clearCache(Cocreator cocreator) {
		getPersistence().clearCache(cocreator);
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
	public static Map<Serializable, Cocreator> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Cocreator> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cocreator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cocreator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Cocreator update(Cocreator cocreator) {
		return getPersistence().update(cocreator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Cocreator update(
		Cocreator cocreator, ServiceContext serviceContext) {

		return getPersistence().update(cocreator, serviceContext);
	}

	/**
	 * Returns all the cocreators where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cocreators
	 */
	public static List<Cocreator> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cocreators where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @return the range of matching cocreators
	 */
	public static List<Cocreator> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cocreators where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocreators
	 */
	public static List<Cocreator> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreators where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocreators
	 */
	public static List<Cocreator> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Cocreator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocreator in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public static Cocreator findByUuid_First(
			String uuid, OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cocreator in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public static Cocreator fetchByUuid_First(
		String uuid, OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cocreator in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public static Cocreator findByUuid_Last(
			String uuid, OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cocreator in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public static Cocreator fetchByUuid_Last(
		String uuid, OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cocreators before and after the current cocreator in the ordered set where uuid = &#63;.
	 *
	 * @param cocreatorId the primary key of the current cocreator
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreator
	 * @throws NoSuchCocreatorException if a cocreator with the primary key could not be found
	 */
	public static Cocreator[] findByUuid_PrevAndNext(
			long cocreatorId, String uuid,
			OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByUuid_PrevAndNext(
			cocreatorId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cocreators where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cocreators where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cocreators
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the cocreator where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCocreatorException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public static Cocreator findByUUID_G(String uuid, long groupId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cocreator where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public static Cocreator fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cocreator where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public static Cocreator fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the cocreator where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cocreator that was removed
	 */
	public static Cocreator removeByUUID_G(String uuid, long groupId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of cocreators where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cocreators
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the cocreators where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cocreators
	 */
	public static List<Cocreator> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the cocreators where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @return the range of matching cocreators
	 */
	public static List<Cocreator> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the cocreators where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocreators
	 */
	public static List<Cocreator> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreators where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocreators
	 */
	public static List<Cocreator> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cocreator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocreator in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public static Cocreator findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first cocreator in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public static Cocreator fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cocreator in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public static Cocreator findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cocreator in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public static Cocreator fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the cocreators before and after the current cocreator in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cocreatorId the primary key of the current cocreator
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreator
	 * @throws NoSuchCocreatorException if a cocreator with the primary key could not be found
	 */
	public static Cocreator[] findByUuid_C_PrevAndNext(
			long cocreatorId, String uuid, long companyId,
			OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByUuid_C_PrevAndNext(
			cocreatorId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the cocreators where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of cocreators where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cocreators
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the cocreators where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @return the matching cocreators
	 */
	public static List<Cocreator> findByCocreationId(long cocreationId) {
		return getPersistence().findByCocreationId(cocreationId);
	}

	/**
	 * Returns a range of all the cocreators where cocreationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param cocreationId the cocreation ID
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @return the range of matching cocreators
	 */
	public static List<Cocreator> findByCocreationId(
		long cocreationId, int start, int end) {

		return getPersistence().findByCocreationId(cocreationId, start, end);
	}

	/**
	 * Returns an ordered range of all the cocreators where cocreationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param cocreationId the cocreation ID
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocreators
	 */
	public static List<Cocreator> findByCocreationId(
		long cocreationId, int start, int end,
		OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().findByCocreationId(
			cocreationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreators where cocreationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param cocreationId the cocreation ID
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocreators
	 */
	public static List<Cocreator> findByCocreationId(
		long cocreationId, int start, int end,
		OrderByComparator<Cocreator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCocreationId(
			cocreationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocreator in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public static Cocreator findByCocreationId_First(
			long cocreationId, OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByCocreationId_First(
			cocreationId, orderByComparator);
	}

	/**
	 * Returns the first cocreator in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public static Cocreator fetchByCocreationId_First(
		long cocreationId, OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().fetchByCocreationId_First(
			cocreationId, orderByComparator);
	}

	/**
	 * Returns the last cocreator in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public static Cocreator findByCocreationId_Last(
			long cocreationId, OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByCocreationId_Last(
			cocreationId, orderByComparator);
	}

	/**
	 * Returns the last cocreator in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public static Cocreator fetchByCocreationId_Last(
		long cocreationId, OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().fetchByCocreationId_Last(
			cocreationId, orderByComparator);
	}

	/**
	 * Returns the cocreators before and after the current cocreator in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreatorId the primary key of the current cocreator
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreator
	 * @throws NoSuchCocreatorException if a cocreator with the primary key could not be found
	 */
	public static Cocreator[] findByCocreationId_PrevAndNext(
			long cocreatorId, long cocreationId,
			OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByCocreationId_PrevAndNext(
			cocreatorId, cocreationId, orderByComparator);
	}

	/**
	 * Removes all the cocreators where cocreationId = &#63; from the database.
	 *
	 * @param cocreationId the cocreation ID
	 */
	public static void removeByCocreationId(long cocreationId) {
		getPersistence().removeByCocreationId(cocreationId);
	}

	/**
	 * Returns the number of cocreators where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @return the number of matching cocreators
	 */
	public static int countByCocreationId(long cocreationId) {
		return getPersistence().countByCocreationId(cocreationId);
	}

	/**
	 * Returns all the cocreators where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching cocreators
	 */
	public static List<Cocreator> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the cocreators where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @return the range of matching cocreators
	 */
	public static List<Cocreator> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the cocreators where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocreators
	 */
	public static List<Cocreator> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreators where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocreators
	 */
	public static List<Cocreator> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Cocreator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocreator in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public static Cocreator findByUserId_First(
			long userId, OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first cocreator in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public static Cocreator fetchByUserId_First(
		long userId, OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last cocreator in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public static Cocreator findByUserId_Last(
			long userId, OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last cocreator in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public static Cocreator fetchByUserId_Last(
		long userId, OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the cocreators before and after the current cocreator in the ordered set where userId = &#63;.
	 *
	 * @param cocreatorId the primary key of the current cocreator
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreator
	 * @throws NoSuchCocreatorException if a cocreator with the primary key could not be found
	 */
	public static Cocreator[] findByUserId_PrevAndNext(
			long cocreatorId, long userId,
			OrderByComparator<Cocreator> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByUserId_PrevAndNext(
			cocreatorId, userId, orderByComparator);
	}

	/**
	 * Removes all the cocreators where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of cocreators where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cocreators
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the cocreator in the entity cache if it is enabled.
	 *
	 * @param cocreator the cocreator
	 */
	public static void cacheResult(Cocreator cocreator) {
		getPersistence().cacheResult(cocreator);
	}

	/**
	 * Caches the cocreators in the entity cache if it is enabled.
	 *
	 * @param cocreators the cocreators
	 */
	public static void cacheResult(List<Cocreator> cocreators) {
		getPersistence().cacheResult(cocreators);
	}

	/**
	 * Creates a new cocreator with the primary key. Does not add the cocreator to the database.
	 *
	 * @param cocreatorId the primary key for the new cocreator
	 * @return the new cocreator
	 */
	public static Cocreator create(long cocreatorId) {
		return getPersistence().create(cocreatorId);
	}

	/**
	 * Removes the cocreator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocreatorId the primary key of the cocreator
	 * @return the cocreator that was removed
	 * @throws NoSuchCocreatorException if a cocreator with the primary key could not be found
	 */
	public static Cocreator remove(long cocreatorId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().remove(cocreatorId);
	}

	public static Cocreator updateImpl(Cocreator cocreator) {
		return getPersistence().updateImpl(cocreator);
	}

	/**
	 * Returns the cocreator with the primary key or throws a <code>NoSuchCocreatorException</code> if it could not be found.
	 *
	 * @param cocreatorId the primary key of the cocreator
	 * @return the cocreator
	 * @throws NoSuchCocreatorException if a cocreator with the primary key could not be found
	 */
	public static Cocreator findByPrimaryKey(long cocreatorId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		return getPersistence().findByPrimaryKey(cocreatorId);
	}

	/**
	 * Returns the cocreator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cocreatorId the primary key of the cocreator
	 * @return the cocreator, or <code>null</code> if a cocreator with the primary key could not be found
	 */
	public static Cocreator fetchByPrimaryKey(long cocreatorId) {
		return getPersistence().fetchByPrimaryKey(cocreatorId);
	}

	/**
	 * Returns all the cocreators.
	 *
	 * @return the cocreators
	 */
	public static List<Cocreator> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cocreators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @return the range of cocreators
	 */
	public static List<Cocreator> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cocreators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cocreators
	 */
	public static List<Cocreator> findAll(
		int start, int end, OrderByComparator<Cocreator> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cocreators
	 */
	public static List<Cocreator> findAll(
		int start, int end, OrderByComparator<Cocreator> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cocreators from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cocreators.
	 *
	 * @return the number of cocreators
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CocreatorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CocreatorPersistence, CocreatorPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CocreatorPersistence.class);

		ServiceTracker<CocreatorPersistence, CocreatorPersistence>
			serviceTracker =
				new ServiceTracker<CocreatorPersistence, CocreatorPersistence>(
					bundle.getBundleContext(), CocreatorPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}