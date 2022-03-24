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

import it.eng.rd.collaborativecreation.model.Cocreation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cocreation service. This utility wraps <code>it.eng.rd.collaborativecreation.service.persistence.impl.CocreationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see CocreationPersistence
 * @generated
 */
public class CocreationUtil {

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
	public static void clearCache(Cocreation cocreation) {
		getPersistence().clearCache(cocreation);
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
	public static Map<Serializable, Cocreation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Cocreation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cocreation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cocreation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Cocreation update(Cocreation cocreation) {
		return getPersistence().update(cocreation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Cocreation update(
		Cocreation cocreation, ServiceContext serviceContext) {

		return getPersistence().update(cocreation, serviceContext);
	}

	/**
	 * Returns all the cocreations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cocreations
	 */
	public static List<Cocreation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cocreations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @return the range of matching cocreations
	 */
	public static List<Cocreation> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cocreations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Cocreation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocreation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByUuid_First(
			String uuid, OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cocreation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByUuid_First(
		String uuid, OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByUuid_Last(
			String uuid, OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByUuid_Last(
		String uuid, OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cocreations before and after the current cocreation in the ordered set where uuid = &#63;.
	 *
	 * @param cocreationId the primary key of the current cocreation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreation
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public static Cocreation[] findByUuid_PrevAndNext(
			long cocreationId, String uuid,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByUuid_PrevAndNext(
			cocreationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cocreations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cocreations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cocreations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the cocreation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCocreationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByUUID_G(String uuid, long groupId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cocreation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cocreation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the cocreation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cocreation that was removed
	 */
	public static Cocreation removeByUUID_G(String uuid, long groupId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of cocreations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cocreations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the cocreations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cocreations
	 */
	public static List<Cocreation> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the cocreations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @return the range of matching cocreations
	 */
	public static List<Cocreation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the cocreations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cocreation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocreation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first cocreation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the cocreations before and after the current cocreation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cocreationId the primary key of the current cocreation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreation
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public static Cocreation[] findByUuid_C_PrevAndNext(
			long cocreationId, String uuid, long companyId,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			cocreationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the cocreations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of cocreations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cocreations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the cocreations where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @return the matching cocreations
	 */
	public static List<Cocreation> findByChallengeId(long challengeId) {
		return getPersistence().findByChallengeId(challengeId);
	}

	/**
	 * Returns a range of all the cocreations where challengeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param challengeId the challenge ID
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @return the range of matching cocreations
	 */
	public static List<Cocreation> findByChallengeId(
		long challengeId, int start, int end) {

		return getPersistence().findByChallengeId(challengeId, start, end);
	}

	/**
	 * Returns an ordered range of all the cocreations where challengeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param challengeId the challenge ID
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByChallengeId(
		long challengeId, int start, int end,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().findByChallengeId(
			challengeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreations where challengeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param challengeId the challenge ID
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByChallengeId(
		long challengeId, int start, int end,
		OrderByComparator<Cocreation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByChallengeId(
			challengeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocreation in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByChallengeId_First(
			long challengeId, OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByChallengeId_First(
			challengeId, orderByComparator);
	}

	/**
	 * Returns the first cocreation in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByChallengeId_First(
		long challengeId, OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByChallengeId_First(
			challengeId, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByChallengeId_Last(
			long challengeId, OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByChallengeId_Last(
			challengeId, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByChallengeId_Last(
		long challengeId, OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByChallengeId_Last(
			challengeId, orderByComparator);
	}

	/**
	 * Returns the cocreations before and after the current cocreation in the ordered set where challengeId = &#63;.
	 *
	 * @param cocreationId the primary key of the current cocreation
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreation
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public static Cocreation[] findByChallengeId_PrevAndNext(
			long cocreationId, long challengeId,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByChallengeId_PrevAndNext(
			cocreationId, challengeId, orderByComparator);
	}

	/**
	 * Removes all the cocreations where challengeId = &#63; from the database.
	 *
	 * @param challengeId the challenge ID
	 */
	public static void removeByChallengeId(long challengeId) {
		getPersistence().removeByChallengeId(challengeId);
	}

	/**
	 * Returns the number of cocreations where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @return the number of matching cocreations
	 */
	public static int countByChallengeId(long challengeId) {
		return getPersistence().countByChallengeId(challengeId);
	}

	/**
	 * Returns all the cocreations where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching cocreations
	 */
	public static List<Cocreation> findByTitle(String title) {
		return getPersistence().findByTitle(title);
	}

	/**
	 * Returns a range of all the cocreations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @return the range of matching cocreations
	 */
	public static List<Cocreation> findByTitle(
		String title, int start, int end) {

		return getPersistence().findByTitle(title, start, end);
	}

	/**
	 * Returns an ordered range of all the cocreations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByTitle(
		String title, int start, int end,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByTitle(
		String title, int start, int end,
		OrderByComparator<Cocreation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocreation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByTitle_First(
			String title, OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first cocreation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByTitle_First(
		String title, OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByTitle_Last(
			String title, OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByTitle_Last(
		String title, OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the cocreations before and after the current cocreation in the ordered set where title = &#63;.
	 *
	 * @param cocreationId the primary key of the current cocreation
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreation
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public static Cocreation[] findByTitle_PrevAndNext(
			long cocreationId, String title,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByTitle_PrevAndNext(
			cocreationId, title, orderByComparator);
	}

	/**
	 * Removes all the cocreations where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeByTitle(String title) {
		getPersistence().removeByTitle(title);
	}

	/**
	 * Returns the number of cocreations where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching cocreations
	 */
	public static int countByTitle(String title) {
		return getPersistence().countByTitle(title);
	}

	/**
	 * Returns all the cocreations where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching cocreations
	 */
	public static List<Cocreation> findByUserId(long userId, long groupId) {
		return getPersistence().findByUserId(userId, groupId);
	}

	/**
	 * Returns a range of all the cocreations where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @return the range of matching cocreations
	 */
	public static List<Cocreation> findByUserId(
		long userId, long groupId, int start, int end) {

		return getPersistence().findByUserId(userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the cocreations where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByUserId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().findByUserId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreations where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByUserId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Cocreation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocreation in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByUserId_First(
			long userId, long groupId,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByUserId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the first cocreation in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByUserId_First(
		long userId, long groupId,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByUserId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByUserId_Last(
			long userId, long groupId,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByUserId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByUserId_Last(
		long userId, long groupId,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByUserId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the cocreations before and after the current cocreation in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param cocreationId the primary key of the current cocreation
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreation
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public static Cocreation[] findByUserId_PrevAndNext(
			long cocreationId, long userId, long groupId,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByUserId_PrevAndNext(
			cocreationId, userId, groupId, orderByComparator);
	}

	/**
	 * Removes all the cocreations where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public static void removeByUserId(long userId, long groupId) {
		getPersistence().removeByUserId(userId, groupId);
	}

	/**
	 * Returns the number of cocreations where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching cocreations
	 */
	public static int countByUserId(long userId, long groupId) {
		return getPersistence().countByUserId(userId, groupId);
	}

	/**
	 * Returns all the cocreations where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @return the matching cocreations
	 */
	public static List<Cocreation> findByGroupId(
		long groupId, boolean completed) {

		return getPersistence().findByGroupId(groupId, completed);
	}

	/**
	 * Returns a range of all the cocreations where groupId = &#63; and completed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @return the range of matching cocreations
	 */
	public static List<Cocreation> findByGroupId(
		long groupId, boolean completed, int start, int end) {

		return getPersistence().findByGroupId(groupId, completed, start, end);
	}

	/**
	 * Returns an ordered range of all the cocreations where groupId = &#63; and completed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByGroupId(
		long groupId, boolean completed, int start, int end,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, completed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreations where groupId = &#63; and completed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cocreations
	 */
	public static List<Cocreation> findByGroupId(
		long groupId, boolean completed, int start, int end,
		OrderByComparator<Cocreation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, completed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cocreation in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByGroupId_First(
			long groupId, boolean completed,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByGroupId_First(
			groupId, completed, orderByComparator);
	}

	/**
	 * Returns the first cocreation in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByGroupId_First(
		long groupId, boolean completed,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, completed, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public static Cocreation findByGroupId_Last(
			long groupId, boolean completed,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByGroupId_Last(
			groupId, completed, orderByComparator);
	}

	/**
	 * Returns the last cocreation in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public static Cocreation fetchByGroupId_Last(
		long groupId, boolean completed,
		OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(
			groupId, completed, orderByComparator);
	}

	/**
	 * Returns the cocreations before and after the current cocreation in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param cocreationId the primary key of the current cocreation
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreation
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public static Cocreation[] findByGroupId_PrevAndNext(
			long cocreationId, long groupId, boolean completed,
			OrderByComparator<Cocreation> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByGroupId_PrevAndNext(
			cocreationId, groupId, completed, orderByComparator);
	}

	/**
	 * Removes all the cocreations where groupId = &#63; and completed = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 */
	public static void removeByGroupId(long groupId, boolean completed) {
		getPersistence().removeByGroupId(groupId, completed);
	}

	/**
	 * Returns the number of cocreations where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @return the number of matching cocreations
	 */
	public static int countByGroupId(long groupId, boolean completed) {
		return getPersistence().countByGroupId(groupId, completed);
	}

	/**
	 * Caches the cocreation in the entity cache if it is enabled.
	 *
	 * @param cocreation the cocreation
	 */
	public static void cacheResult(Cocreation cocreation) {
		getPersistence().cacheResult(cocreation);
	}

	/**
	 * Caches the cocreations in the entity cache if it is enabled.
	 *
	 * @param cocreations the cocreations
	 */
	public static void cacheResult(List<Cocreation> cocreations) {
		getPersistence().cacheResult(cocreations);
	}

	/**
	 * Creates a new cocreation with the primary key. Does not add the cocreation to the database.
	 *
	 * @param cocreationId the primary key for the new cocreation
	 * @return the new cocreation
	 */
	public static Cocreation create(long cocreationId) {
		return getPersistence().create(cocreationId);
	}

	/**
	 * Removes the cocreation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocreationId the primary key of the cocreation
	 * @return the cocreation that was removed
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public static Cocreation remove(long cocreationId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().remove(cocreationId);
	}

	public static Cocreation updateImpl(Cocreation cocreation) {
		return getPersistence().updateImpl(cocreation);
	}

	/**
	 * Returns the cocreation with the primary key or throws a <code>NoSuchCocreationException</code> if it could not be found.
	 *
	 * @param cocreationId the primary key of the cocreation
	 * @return the cocreation
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public static Cocreation findByPrimaryKey(long cocreationId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreationException {

		return getPersistence().findByPrimaryKey(cocreationId);
	}

	/**
	 * Returns the cocreation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cocreationId the primary key of the cocreation
	 * @return the cocreation, or <code>null</code> if a cocreation with the primary key could not be found
	 */
	public static Cocreation fetchByPrimaryKey(long cocreationId) {
		return getPersistence().fetchByPrimaryKey(cocreationId);
	}

	/**
	 * Returns all the cocreations.
	 *
	 * @return the cocreations
	 */
	public static List<Cocreation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cocreations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @return the range of cocreations
	 */
	public static List<Cocreation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cocreations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cocreations
	 */
	public static List<Cocreation> findAll(
		int start, int end, OrderByComparator<Cocreation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cocreations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cocreations
	 */
	public static List<Cocreation> findAll(
		int start, int end, OrderByComparator<Cocreation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cocreations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cocreations.
	 *
	 * @return the number of cocreations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CocreationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CocreationPersistence, CocreationPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CocreationPersistence.class);

		ServiceTracker<CocreationPersistence, CocreationPersistence>
			serviceTracker =
				new ServiceTracker
					<CocreationPersistence, CocreationPersistence>(
						bundle.getBundleContext(), CocreationPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}