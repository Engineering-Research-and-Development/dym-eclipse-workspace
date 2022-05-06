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

import it.eng.rd.collaborativecreation.model.Challenge;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the challenge service. This utility wraps <code>it.eng.rd.collaborativecreation.service.persistence.impl.ChallengePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see ChallengePersistence
 * @generated
 */
public class ChallengeUtil {

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
	public static void clearCache(Challenge challenge) {
		getPersistence().clearCache(challenge);
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
	public static Map<Serializable, Challenge> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Challenge> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Challenge> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Challenge> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Challenge update(Challenge challenge) {
		return getPersistence().update(challenge);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Challenge update(
		Challenge challenge, ServiceContext serviceContext) {

		return getPersistence().update(challenge, serviceContext);
	}

	/**
	 * Returns all the challenges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching challenges
	 */
	public static List<Challenge> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the challenges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of matching challenges
	 */
	public static List<Challenge> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the challenges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the challenges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Challenge> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByUuid_First(
			String uuid, OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByUuid_First(
		String uuid, OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByUuid_Last(
			String uuid, OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByUuid_Last(
		String uuid, OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the challenges before and after the current challenge in the ordered set where uuid = &#63;.
	 *
	 * @param challengeId the primary key of the current challenge
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public static Challenge[] findByUuid_PrevAndNext(
			long challengeId, String uuid,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByUuid_PrevAndNext(
			challengeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the challenges where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of challenges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching challenges
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the challenge where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchChallengeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByUUID_G(String uuid, long groupId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the challenge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the challenge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the challenge where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the challenge that was removed
	 */
	public static Challenge removeByUUID_G(String uuid, long groupId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of challenges where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching challenges
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the challenges where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching challenges
	 */
	public static List<Challenge> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the challenges where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of matching challenges
	 */
	public static List<Challenge> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the challenges where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the challenges where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Challenge> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the challenges before and after the current challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param challengeId the primary key of the current challenge
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public static Challenge[] findByUuid_C_PrevAndNext(
			long challengeId, String uuid, long companyId,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			challengeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the challenges where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of challenges where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching challenges
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the challenges where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching challenges
	 */
	public static List<Challenge> findByTitle(String title) {
		return getPersistence().findByTitle(title);
	}

	/**
	 * Returns a range of all the challenges where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of matching challenges
	 */
	public static List<Challenge> findByTitle(
		String title, int start, int end) {

		return getPersistence().findByTitle(title, start, end);
	}

	/**
	 * Returns an ordered range of all the challenges where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByTitle(
		String title, int start, int end,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the challenges where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByTitle(
		String title, int start, int end,
		OrderByComparator<Challenge> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first challenge in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByTitle_First(
			String title, OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first challenge in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByTitle_First(
		String title, OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByTitle_Last(
			String title, OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByTitle_Last(
		String title, OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the challenges before and after the current challenge in the ordered set where title = &#63;.
	 *
	 * @param challengeId the primary key of the current challenge
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public static Challenge[] findByTitle_PrevAndNext(
			long challengeId, String title,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByTitle_PrevAndNext(
			challengeId, title, orderByComparator);
	}

	/**
	 * Removes all the challenges where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeByTitle(String title) {
		getPersistence().removeByTitle(title);
	}

	/**
	 * Returns the number of challenges where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching challenges
	 */
	public static int countByTitle(String title) {
		return getPersistence().countByTitle(title);
	}

	/**
	 * Returns all the challenges where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching challenges
	 */
	public static List<Challenge> findByUserId(long userId, long groupId) {
		return getPersistence().findByUserId(userId, groupId);
	}

	/**
	 * Returns a range of all the challenges where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of matching challenges
	 */
	public static List<Challenge> findByUserId(
		long userId, long groupId, int start, int end) {

		return getPersistence().findByUserId(userId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the challenges where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByUserId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().findByUserId(
			userId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the challenges where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByUserId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Challenge> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first challenge in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByUserId_First(
			long userId, long groupId,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByUserId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the first challenge in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByUserId_First(
		long userId, long groupId,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByUserId_First(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByUserId_Last(
			long userId, long groupId,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByUserId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByUserId_Last(
		long userId, long groupId,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByUserId_Last(
			userId, groupId, orderByComparator);
	}

	/**
	 * Returns the challenges before and after the current challenge in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param challengeId the primary key of the current challenge
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public static Challenge[] findByUserId_PrevAndNext(
			long challengeId, long userId, long groupId,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByUserId_PrevAndNext(
			challengeId, userId, groupId, orderByComparator);
	}

	/**
	 * Removes all the challenges where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public static void removeByUserId(long userId, long groupId) {
		getPersistence().removeByUserId(userId, groupId);
	}

	/**
	 * Returns the number of challenges where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching challenges
	 */
	public static int countByUserId(long userId, long groupId) {
		return getPersistence().countByUserId(userId, groupId);
	}

	/**
	 * Returns all the challenges where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching challenges
	 */
	public static List<Challenge> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the challenges where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of matching challenges
	 */
	public static List<Challenge> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the challenges where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the challenges where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Challenge> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first challenge in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByGroupId_First(
			long groupId, OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first challenge in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByGroupId_First(
		long groupId, OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByGroupId_Last(
			long groupId, OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByGroupId_Last(
		long groupId, OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the challenges before and after the current challenge in the ordered set where groupId = &#63;.
	 *
	 * @param challengeId the primary key of the current challenge
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public static Challenge[] findByGroupId_PrevAndNext(
			long challengeId, long groupId,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByGroupId_PrevAndNext(
			challengeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the challenges where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of challenges where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching challenges
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the challenges where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @return the matching challenges
	 */
	public static List<Challenge> findByActive(long groupId, boolean active) {
		return getPersistence().findByActive(groupId, active);
	}

	/**
	 * Returns a range of all the challenges where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of matching challenges
	 */
	public static List<Challenge> findByActive(
		long groupId, boolean active, int start, int end) {

		return getPersistence().findByActive(groupId, active, start, end);
	}

	/**
	 * Returns an ordered range of all the challenges where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByActive(
		long groupId, boolean active, int start, int end,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().findByActive(
			groupId, active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the challenges where groupId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching challenges
	 */
	public static List<Challenge> findByActive(
		long groupId, boolean active, int start, int end,
		OrderByComparator<Challenge> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByActive(
			groupId, active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first challenge in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByActive_First(
			long groupId, boolean active,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByActive_First(
			groupId, active, orderByComparator);
	}

	/**
	 * Returns the first challenge in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByActive_First(
		long groupId, boolean active,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByActive_First(
			groupId, active, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public static Challenge findByActive_Last(
			long groupId, boolean active,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByActive_Last(
			groupId, active, orderByComparator);
	}

	/**
	 * Returns the last challenge in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchByActive_Last(
		long groupId, boolean active,
		OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().fetchByActive_Last(
			groupId, active, orderByComparator);
	}

	/**
	 * Returns the challenges before and after the current challenge in the ordered set where groupId = &#63; and active = &#63;.
	 *
	 * @param challengeId the primary key of the current challenge
	 * @param groupId the group ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public static Challenge[] findByActive_PrevAndNext(
			long challengeId, long groupId, boolean active,
			OrderByComparator<Challenge> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByActive_PrevAndNext(
			challengeId, groupId, active, orderByComparator);
	}

	/**
	 * Removes all the challenges where groupId = &#63; and active = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 */
	public static void removeByActive(long groupId, boolean active) {
		getPersistence().removeByActive(groupId, active);
	}

	/**
	 * Returns the number of challenges where groupId = &#63; and active = &#63;.
	 *
	 * @param groupId the group ID
	 * @param active the active
	 * @return the number of matching challenges
	 */
	public static int countByActive(long groupId, boolean active) {
		return getPersistence().countByActive(groupId, active);
	}

	/**
	 * Caches the challenge in the entity cache if it is enabled.
	 *
	 * @param challenge the challenge
	 */
	public static void cacheResult(Challenge challenge) {
		getPersistence().cacheResult(challenge);
	}

	/**
	 * Caches the challenges in the entity cache if it is enabled.
	 *
	 * @param challenges the challenges
	 */
	public static void cacheResult(List<Challenge> challenges) {
		getPersistence().cacheResult(challenges);
	}

	/**
	 * Creates a new challenge with the primary key. Does not add the challenge to the database.
	 *
	 * @param challengeId the primary key for the new challenge
	 * @return the new challenge
	 */
	public static Challenge create(long challengeId) {
		return getPersistence().create(challengeId);
	}

	/**
	 * Removes the challenge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param challengeId the primary key of the challenge
	 * @return the challenge that was removed
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public static Challenge remove(long challengeId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().remove(challengeId);
	}

	public static Challenge updateImpl(Challenge challenge) {
		return getPersistence().updateImpl(challenge);
	}

	/**
	 * Returns the challenge with the primary key or throws a <code>NoSuchChallengeException</code> if it could not be found.
	 *
	 * @param challengeId the primary key of the challenge
	 * @return the challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public static Challenge findByPrimaryKey(long challengeId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchChallengeException {

		return getPersistence().findByPrimaryKey(challengeId);
	}

	/**
	 * Returns the challenge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param challengeId the primary key of the challenge
	 * @return the challenge, or <code>null</code> if a challenge with the primary key could not be found
	 */
	public static Challenge fetchByPrimaryKey(long challengeId) {
		return getPersistence().fetchByPrimaryKey(challengeId);
	}

	/**
	 * Returns all the challenges.
	 *
	 * @return the challenges
	 */
	public static List<Challenge> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the challenges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of challenges
	 */
	public static List<Challenge> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the challenges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of challenges
	 */
	public static List<Challenge> findAll(
		int start, int end, OrderByComparator<Challenge> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the challenges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of challenges
	 */
	public static List<Challenge> findAll(
		int start, int end, OrderByComparator<Challenge> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the challenges from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of challenges.
	 *
	 * @return the number of challenges
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChallengePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ChallengePersistence, ChallengePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ChallengePersistence.class);

		ServiceTracker<ChallengePersistence, ChallengePersistence>
			serviceTracker =
				new ServiceTracker<ChallengePersistence, ChallengePersistence>(
					bundle.getBundleContext(), ChallengePersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}