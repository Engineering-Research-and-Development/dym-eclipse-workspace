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

import it.eng.rd.dymer.exception.NoSuchDymerEntryException;
import it.eng.rd.dymer.model.DymerEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the dymer entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see DymerEntryUtil
 * @generated
 */
@ProviderType
public interface DymerEntryPersistence extends BasePersistence<DymerEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DymerEntryUtil} to access the dymer entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dymer entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dymer entries
	 */
	public java.util.List<DymerEntry> findByUuid(String uuid);

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
	public java.util.List<DymerEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<DymerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

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
	public java.util.List<DymerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the first dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public DymerEntry[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Removes all the dymer entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of dymer entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dymer entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the dymer entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDymerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the dymer entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the dymer entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the dymer entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dymer entry that was removed
	 */
	public DymerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the number of dymer entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dymer entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dymer entries
	 */
	public java.util.List<DymerEntry> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<DymerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<DymerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

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
	public java.util.List<DymerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the first dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

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
	public DymerEntry[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Removes all the dymer entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dymer entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the matching dymer entries
	 */
	public java.util.List<DymerEntry> findByG_D(long groupId, long dymerId);

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
	public java.util.List<DymerEntry> findByG_D(
		long groupId, long dymerId, int start, int end);

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
	public java.util.List<DymerEntry> findByG_D(
		long groupId, long dymerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

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
	public java.util.List<DymerEntry> findByG_D(
		long groupId, long dymerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByG_D_First(
			long groupId, long dymerId,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByG_D_First(
		long groupId, long dymerId,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByG_D_Last(
			long groupId, long dymerId,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByG_D_Last(
		long groupId, long dymerId,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

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
	public DymerEntry[] findByG_D_PrevAndNext(
			long entryId, long groupId, long dymerId,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns all the dymer entries that the user has permission to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the matching dymer entries that the user has permission to view
	 */
	public java.util.List<DymerEntry> filterFindByG_D(
		long groupId, long dymerId);

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
	public java.util.List<DymerEntry> filterFindByG_D(
		long groupId, long dymerId, int start, int end);

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
	public java.util.List<DymerEntry> filterFindByG_D(
		long groupId, long dymerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

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
	public DymerEntry[] filterFindByG_D_PrevAndNext(
			long entryId, long groupId, long dymerId,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Removes all the dymer entries where groupId = &#63; and dymerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 */
	public void removeByG_D(long groupId, long dymerId);

	/**
	 * Returns the number of dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the number of matching dymer entries
	 */
	public int countByG_D(long groupId, long dymerId);

	/**
	 * Returns the number of dymer entries that the user has permission to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the number of matching dymer entries that the user has permission to view
	 */
	public int filterCountByG_D(long groupId, long dymerId);

	/**
	 * Returns all the dymer entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching dymer entries
	 */
	public java.util.List<DymerEntry> findByStatus(int status);

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
	public java.util.List<DymerEntry> findByStatus(
		int status, int start, int end);

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
	public java.util.List<DymerEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

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
	public java.util.List<DymerEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the first dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

	/**
	 * Returns the last dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the last dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where status = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public DymerEntry[] findByStatus_PrevAndNext(
			long entryId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Removes all the dymer entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of dymer entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching dymer entries
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching dymer entries
	 */
	public java.util.List<DymerEntry> findByG_S(long groupId, int status);

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
	public java.util.List<DymerEntry> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<DymerEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

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
	public java.util.List<DymerEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

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
	public DymerEntry[] findByG_S_PrevAndNext(
			long entryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Returns all the dymer entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching dymer entries that the user has permission to view
	 */
	public java.util.List<DymerEntry> filterFindByG_S(long groupId, int status);

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
	public java.util.List<DymerEntry> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<DymerEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

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
	public DymerEntry[] filterFindByG_S_PrevAndNext(
			long entryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
				orderByComparator)
		throws NoSuchDymerEntryException;

	/**
	 * Removes all the dymer entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching dymer entries
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of dymer entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching dymer entries that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns the dymer entry where index = &#63; and type = &#63; and id = &#63; or throws a <code>NoSuchDymerEntryException</code> if it could not be found.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	public DymerEntry findByForIndexTypeId(String index, String type, String id)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the dymer entry where index = &#63; and type = &#63; and id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByForIndexTypeId(
		String index, String type, String id);

	/**
	 * Returns the dymer entry where index = &#63; and type = &#63; and id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public DymerEntry fetchByForIndexTypeId(
		String index, String type, String id, boolean useFinderCache);

	/**
	 * Removes the dymer entry where index = &#63; and type = &#63; and id = &#63; from the database.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the dymer entry that was removed
	 */
	public DymerEntry removeByForIndexTypeId(
			String index, String type, String id)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the number of dymer entries where index = &#63; and type = &#63; and id = &#63;.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the number of matching dymer entries
	 */
	public int countByForIndexTypeId(String index, String type, String id);

	/**
	 * Caches the dymer entry in the entity cache if it is enabled.
	 *
	 * @param dymerEntry the dymer entry
	 */
	public void cacheResult(DymerEntry dymerEntry);

	/**
	 * Caches the dymer entries in the entity cache if it is enabled.
	 *
	 * @param dymerEntries the dymer entries
	 */
	public void cacheResult(java.util.List<DymerEntry> dymerEntries);

	/**
	 * Creates a new dymer entry with the primary key. Does not add the dymer entry to the database.
	 *
	 * @param entryId the primary key for the new dymer entry
	 * @return the new dymer entry
	 */
	public DymerEntry create(long entryId);

	/**
	 * Removes the dymer entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry that was removed
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public DymerEntry remove(long entryId) throws NoSuchDymerEntryException;

	public DymerEntry updateImpl(DymerEntry dymerEntry);

	/**
	 * Returns the dymer entry with the primary key or throws a <code>NoSuchDymerEntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	public DymerEntry findByPrimaryKey(long entryId)
		throws NoSuchDymerEntryException;

	/**
	 * Returns the dymer entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry, or <code>null</code> if a dymer entry with the primary key could not be found
	 */
	public DymerEntry fetchByPrimaryKey(long entryId);

	/**
	 * Returns all the dymer entries.
	 *
	 * @return the dymer entries
	 */
	public java.util.List<DymerEntry> findAll();

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
	public java.util.List<DymerEntry> findAll(int start, int end);

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
	public java.util.List<DymerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator);

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
	public java.util.List<DymerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DymerEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dymer entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dymer entries.
	 *
	 * @return the number of dymer entries
	 */
	public int countAll();

}