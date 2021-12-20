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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.rd.dymer.exception.NoSuchDymerException;
import it.eng.rd.dymer.model.Dymer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dymer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see DymerUtil
 * @generated
 */
@ProviderType
public interface DymerPersistence extends BasePersistence<Dymer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DymerUtil} to access the dymer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dymers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dymers
	 */
	public java.util.List<Dymer> findByUuid(String uuid);

	/**
	 * Returns a range of all the dymers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @return the range of matching dymers
	 */
	public java.util.List<Dymer> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the dymers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymers
	 */
	public java.util.List<Dymer> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dymers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymers
	 */
	public java.util.List<Dymer> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dymer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer
	 * @throws NoSuchDymerException if a matching dymer could not be found
	 */
	public Dymer findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns the first dymer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the last dymer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer
	 * @throws NoSuchDymerException if a matching dymer could not be found
	 */
	public Dymer findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns the last dymer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the dymers before and after the current dymer in the ordered set where uuid = &#63;.
	 *
	 * @param dymerId the primary key of the current dymer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer
	 * @throws NoSuchDymerException if a dymer with the primary key could not be found
	 */
	public Dymer[] findByUuid_PrevAndNext(
			long dymerId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Removes all the dymers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dymers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dymers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dymer where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDymerException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dymer
	 * @throws NoSuchDymerException if a matching dymer could not be found
	 */
	public Dymer findByUUID_G(String uuid, long groupId)
		throws NoSuchDymerException;

	/**
	 * Returns the dymer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the dymer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dymer where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dymer that was removed
	 */
	public Dymer removeByUUID_G(String uuid, long groupId)
		throws NoSuchDymerException;

	/**
	 * Returns the number of dymers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dymers
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dymers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dymers
	 */
	public java.util.List<Dymer> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the dymers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @return the range of matching dymers
	 */
	public java.util.List<Dymer> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the dymers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymers
	 */
	public java.util.List<Dymer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dymers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymers
	 */
	public java.util.List<Dymer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dymer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer
	 * @throws NoSuchDymerException if a matching dymer could not be found
	 */
	public Dymer findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns the first dymer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the last dymer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer
	 * @throws NoSuchDymerException if a matching dymer could not be found
	 */
	public Dymer findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns the last dymer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the dymers before and after the current dymer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dymerId the primary key of the current dymer
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer
	 * @throws NoSuchDymerException if a dymer with the primary key could not be found
	 */
	public Dymer[] findByUuid_C_PrevAndNext(
			long dymerId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Removes all the dymers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dymers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dymers
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the dymers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dymers
	 */
	public java.util.List<Dymer> findByGroupId(long groupId);

	/**
	 * Returns a range of all the dymers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @return the range of matching dymers
	 */
	public java.util.List<Dymer> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the dymers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymers
	 */
	public java.util.List<Dymer> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dymers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymers
	 */
	public java.util.List<Dymer> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dymer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer
	 * @throws NoSuchDymerException if a matching dymer could not be found
	 */
	public Dymer findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns the first dymer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the last dymer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer
	 * @throws NoSuchDymerException if a matching dymer could not be found
	 */
	public Dymer findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns the last dymer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the dymers before and after the current dymer in the ordered set where groupId = &#63;.
	 *
	 * @param dymerId the primary key of the current dymer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer
	 * @throws NoSuchDymerException if a dymer with the primary key could not be found
	 */
	public Dymer[] findByGroupId_PrevAndNext(
			long dymerId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns all the dymers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching dymers that the user has permission to view
	 */
	public java.util.List<Dymer> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the dymers that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @return the range of matching dymers that the user has permission to view
	 */
	public java.util.List<Dymer> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the dymers that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymers that the user has permission to view
	 */
	public java.util.List<Dymer> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the dymers before and after the current dymer in the ordered set of dymers that the user has permission to view where groupId = &#63;.
	 *
	 * @param dymerId the primary key of the current dymer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer
	 * @throws NoSuchDymerException if a dymer with the primary key could not be found
	 */
	public Dymer[] filterFindByGroupId_PrevAndNext(
			long dymerId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Removes all the dymers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of dymers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dymers
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of dymers that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching dymers that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the dymers where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching dymers
	 */
	public java.util.List<Dymer> findByStatus(int status);

	/**
	 * Returns a range of all the dymers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @return the range of matching dymers
	 */
	public java.util.List<Dymer> findByStatus(int status, int start, int end);

	/**
	 * Returns an ordered range of all the dymers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymers
	 */
	public java.util.List<Dymer> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dymers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymers
	 */
	public java.util.List<Dymer> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dymer in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer
	 * @throws NoSuchDymerException if a matching dymer could not be found
	 */
	public Dymer findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns the first dymer in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the last dymer in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer
	 * @throws NoSuchDymerException if a matching dymer could not be found
	 */
	public Dymer findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns the last dymer in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the dymers before and after the current dymer in the ordered set where status = &#63;.
	 *
	 * @param dymerId the primary key of the current dymer
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer
	 * @throws NoSuchDymerException if a dymer with the primary key could not be found
	 */
	public Dymer[] findByStatus_PrevAndNext(
			long dymerId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Removes all the dymers where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of dymers where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching dymers
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the dymers where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching dymers
	 */
	public java.util.List<Dymer> findByG_S(long groupId, int status);

	/**
	 * Returns a range of all the dymers where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @return the range of matching dymers
	 */
	public java.util.List<Dymer> findByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the dymers where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymers
	 */
	public java.util.List<Dymer> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dymers where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymers
	 */
	public java.util.List<Dymer> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dymer in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer
	 * @throws NoSuchDymerException if a matching dymer could not be found
	 */
	public Dymer findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns the first dymer in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the last dymer in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer
	 * @throws NoSuchDymerException if a matching dymer could not be found
	 */
	public Dymer findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns the last dymer in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public Dymer fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the dymers before and after the current dymer in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param dymerId the primary key of the current dymer
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer
	 * @throws NoSuchDymerException if a dymer with the primary key could not be found
	 */
	public Dymer[] findByG_S_PrevAndNext(
			long dymerId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Returns all the dymers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching dymers that the user has permission to view
	 */
	public java.util.List<Dymer> filterFindByG_S(long groupId, int status);

	/**
	 * Returns a range of all the dymers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @return the range of matching dymers that the user has permission to view
	 */
	public java.util.List<Dymer> filterFindByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the dymers that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymers that the user has permission to view
	 */
	public java.util.List<Dymer> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns the dymers before and after the current dymer in the ordered set of dymers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param dymerId the primary key of the current dymer
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer
	 * @throws NoSuchDymerException if a dymer with the primary key could not be found
	 */
	public Dymer[] filterFindByG_S_PrevAndNext(
			long dymerId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Dymer>
				orderByComparator)
		throws NoSuchDymerException;

	/**
	 * Removes all the dymers where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of dymers where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching dymers
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of dymers that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching dymers that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Caches the dymer in the entity cache if it is enabled.
	 *
	 * @param dymer the dymer
	 */
	public void cacheResult(Dymer dymer);

	/**
	 * Caches the dymers in the entity cache if it is enabled.
	 *
	 * @param dymers the dymers
	 */
	public void cacheResult(java.util.List<Dymer> dymers);

	/**
	 * Creates a new dymer with the primary key. Does not add the dymer to the database.
	 *
	 * @param dymerId the primary key for the new dymer
	 * @return the new dymer
	 */
	public Dymer create(long dymerId);

	/**
	 * Removes the dymer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dymerId the primary key of the dymer
	 * @return the dymer that was removed
	 * @throws NoSuchDymerException if a dymer with the primary key could not be found
	 */
	public Dymer remove(long dymerId) throws NoSuchDymerException;

	public Dymer updateImpl(Dymer dymer);

	/**
	 * Returns the dymer with the primary key or throws a <code>NoSuchDymerException</code> if it could not be found.
	 *
	 * @param dymerId the primary key of the dymer
	 * @return the dymer
	 * @throws NoSuchDymerException if a dymer with the primary key could not be found
	 */
	public Dymer findByPrimaryKey(long dymerId) throws NoSuchDymerException;

	/**
	 * Returns the dymer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dymerId the primary key of the dymer
	 * @return the dymer, or <code>null</code> if a dymer with the primary key could not be found
	 */
	public Dymer fetchByPrimaryKey(long dymerId);

	/**
	 * Returns all the dymers.
	 *
	 * @return the dymers
	 */
	public java.util.List<Dymer> findAll();

	/**
	 * Returns a range of all the dymers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @return the range of dymers
	 */
	public java.util.List<Dymer> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dymers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dymers
	 */
	public java.util.List<Dymer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dymers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dymers
	 */
	public java.util.List<Dymer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dymer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dymers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dymers.
	 *
	 * @return the number of dymers
	 */
	public int countAll();

}