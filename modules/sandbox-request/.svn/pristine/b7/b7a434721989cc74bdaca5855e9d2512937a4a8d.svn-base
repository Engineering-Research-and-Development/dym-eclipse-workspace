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

package it.eng.rd.sandbox.request.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.sandbox.request.model.Sandbox;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the sandbox service. This utility wraps <code>it.eng.rd.sandbox.request.service.persistence.impl.SandboxPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SandboxPersistence
 * @generated
 */
public class SandboxUtil {

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
	public static void clearCache(Sandbox sandbox) {
		getPersistence().clearCache(sandbox);
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
	public static Map<Serializable, Sandbox> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Sandbox> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Sandbox> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Sandbox> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Sandbox> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Sandbox update(Sandbox sandbox) {
		return getPersistence().update(sandbox);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Sandbox update(
		Sandbox sandbox, ServiceContext serviceContext) {

		return getPersistence().update(sandbox, serviceContext);
	}

	/**
	 * Returns all the sandboxes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sandboxes
	 */
	public static List<Sandbox> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the sandboxes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SandboxModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sandboxes
	 * @param end the upper bound of the range of sandboxes (not inclusive)
	 * @return the range of matching sandboxes
	 */
	public static List<Sandbox> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the sandboxes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SandboxModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sandboxes
	 * @param end the upper bound of the range of sandboxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sandboxes
	 */
	public static List<Sandbox> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Sandbox> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sandboxes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SandboxModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sandboxes
	 * @param end the upper bound of the range of sandboxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sandboxes
	 */
	public static List<Sandbox> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Sandbox> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sandbox in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sandbox
	 * @throws NoSuchSandboxException if a matching sandbox could not be found
	 */
	public static Sandbox findByUuid_First(
			String uuid, OrderByComparator<Sandbox> orderByComparator)
		throws it.eng.rd.sandbox.request.exception.NoSuchSandboxException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first sandbox in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sandbox, or <code>null</code> if a matching sandbox could not be found
	 */
	public static Sandbox fetchByUuid_First(
		String uuid, OrderByComparator<Sandbox> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last sandbox in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sandbox
	 * @throws NoSuchSandboxException if a matching sandbox could not be found
	 */
	public static Sandbox findByUuid_Last(
			String uuid, OrderByComparator<Sandbox> orderByComparator)
		throws it.eng.rd.sandbox.request.exception.NoSuchSandboxException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last sandbox in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sandbox, or <code>null</code> if a matching sandbox could not be found
	 */
	public static Sandbox fetchByUuid_Last(
		String uuid, OrderByComparator<Sandbox> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the sandboxes before and after the current sandbox in the ordered set where uuid = &#63;.
	 *
	 * @param sandboxId the primary key of the current sandbox
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sandbox
	 * @throws NoSuchSandboxException if a sandbox with the primary key could not be found
	 */
	public static Sandbox[] findByUuid_PrevAndNext(
			long sandboxId, String uuid,
			OrderByComparator<Sandbox> orderByComparator)
		throws it.eng.rd.sandbox.request.exception.NoSuchSandboxException {

		return getPersistence().findByUuid_PrevAndNext(
			sandboxId, uuid, orderByComparator);
	}

	/**
	 * Removes all the sandboxes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of sandboxes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sandboxes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the sandbox where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSandboxException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sandbox
	 * @throws NoSuchSandboxException if a matching sandbox could not be found
	 */
	public static Sandbox findByUUID_G(String uuid, long groupId)
		throws it.eng.rd.sandbox.request.exception.NoSuchSandboxException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sandbox where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sandbox, or <code>null</code> if a matching sandbox could not be found
	 */
	public static Sandbox fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sandbox where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sandbox, or <code>null</code> if a matching sandbox could not be found
	 */
	public static Sandbox fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the sandbox where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sandbox that was removed
	 */
	public static Sandbox removeByUUID_G(String uuid, long groupId)
		throws it.eng.rd.sandbox.request.exception.NoSuchSandboxException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of sandboxes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sandboxes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the sandboxes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sandboxes
	 */
	public static List<Sandbox> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the sandboxes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SandboxModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sandboxes
	 * @param end the upper bound of the range of sandboxes (not inclusive)
	 * @return the range of matching sandboxes
	 */
	public static List<Sandbox> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the sandboxes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SandboxModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sandboxes
	 * @param end the upper bound of the range of sandboxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sandboxes
	 */
	public static List<Sandbox> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Sandbox> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sandboxes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SandboxModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sandboxes
	 * @param end the upper bound of the range of sandboxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sandboxes
	 */
	public static List<Sandbox> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Sandbox> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sandbox in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sandbox
	 * @throws NoSuchSandboxException if a matching sandbox could not be found
	 */
	public static Sandbox findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Sandbox> orderByComparator)
		throws it.eng.rd.sandbox.request.exception.NoSuchSandboxException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first sandbox in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sandbox, or <code>null</code> if a matching sandbox could not be found
	 */
	public static Sandbox fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Sandbox> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sandbox in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sandbox
	 * @throws NoSuchSandboxException if a matching sandbox could not be found
	 */
	public static Sandbox findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Sandbox> orderByComparator)
		throws it.eng.rd.sandbox.request.exception.NoSuchSandboxException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sandbox in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sandbox, or <code>null</code> if a matching sandbox could not be found
	 */
	public static Sandbox fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Sandbox> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the sandboxes before and after the current sandbox in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sandboxId the primary key of the current sandbox
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sandbox
	 * @throws NoSuchSandboxException if a sandbox with the primary key could not be found
	 */
	public static Sandbox[] findByUuid_C_PrevAndNext(
			long sandboxId, String uuid, long companyId,
			OrderByComparator<Sandbox> orderByComparator)
		throws it.eng.rd.sandbox.request.exception.NoSuchSandboxException {

		return getPersistence().findByUuid_C_PrevAndNext(
			sandboxId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the sandboxes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of sandboxes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sandboxes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the sandbox in the entity cache if it is enabled.
	 *
	 * @param sandbox the sandbox
	 */
	public static void cacheResult(Sandbox sandbox) {
		getPersistence().cacheResult(sandbox);
	}

	/**
	 * Caches the sandboxes in the entity cache if it is enabled.
	 *
	 * @param sandboxes the sandboxes
	 */
	public static void cacheResult(List<Sandbox> sandboxes) {
		getPersistence().cacheResult(sandboxes);
	}

	/**
	 * Creates a new sandbox with the primary key. Does not add the sandbox to the database.
	 *
	 * @param sandboxId the primary key for the new sandbox
	 * @return the new sandbox
	 */
	public static Sandbox create(long sandboxId) {
		return getPersistence().create(sandboxId);
	}

	/**
	 * Removes the sandbox with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sandboxId the primary key of the sandbox
	 * @return the sandbox that was removed
	 * @throws NoSuchSandboxException if a sandbox with the primary key could not be found
	 */
	public static Sandbox remove(long sandboxId)
		throws it.eng.rd.sandbox.request.exception.NoSuchSandboxException {

		return getPersistence().remove(sandboxId);
	}

	public static Sandbox updateImpl(Sandbox sandbox) {
		return getPersistence().updateImpl(sandbox);
	}

	/**
	 * Returns the sandbox with the primary key or throws a <code>NoSuchSandboxException</code> if it could not be found.
	 *
	 * @param sandboxId the primary key of the sandbox
	 * @return the sandbox
	 * @throws NoSuchSandboxException if a sandbox with the primary key could not be found
	 */
	public static Sandbox findByPrimaryKey(long sandboxId)
		throws it.eng.rd.sandbox.request.exception.NoSuchSandboxException {

		return getPersistence().findByPrimaryKey(sandboxId);
	}

	/**
	 * Returns the sandbox with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sandboxId the primary key of the sandbox
	 * @return the sandbox, or <code>null</code> if a sandbox with the primary key could not be found
	 */
	public static Sandbox fetchByPrimaryKey(long sandboxId) {
		return getPersistence().fetchByPrimaryKey(sandboxId);
	}

	/**
	 * Returns all the sandboxes.
	 *
	 * @return the sandboxes
	 */
	public static List<Sandbox> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sandboxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SandboxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sandboxes
	 * @param end the upper bound of the range of sandboxes (not inclusive)
	 * @return the range of sandboxes
	 */
	public static List<Sandbox> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sandboxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SandboxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sandboxes
	 * @param end the upper bound of the range of sandboxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sandboxes
	 */
	public static List<Sandbox> findAll(
		int start, int end, OrderByComparator<Sandbox> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sandboxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SandboxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sandboxes
	 * @param end the upper bound of the range of sandboxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sandboxes
	 */
	public static List<Sandbox> findAll(
		int start, int end, OrderByComparator<Sandbox> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sandboxes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sandboxes.
	 *
	 * @return the number of sandboxes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SandboxPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SandboxPersistence, SandboxPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SandboxPersistence.class);

		ServiceTracker<SandboxPersistence, SandboxPersistence> serviceTracker =
			new ServiceTracker<SandboxPersistence, SandboxPersistence>(
				bundle.getBundleContext(), SandboxPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}