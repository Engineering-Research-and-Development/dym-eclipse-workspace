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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.rd.collaborativecreation.exception.NoSuchCocreatorException;
import it.eng.rd.collaborativecreation.model.Cocreator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cocreator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see CocreatorUtil
 * @generated
 */
@ProviderType
public interface CocreatorPersistence extends BasePersistence<Cocreator> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CocreatorUtil} to access the cocreator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cocreators where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cocreators
	 */
	public java.util.List<Cocreator> findByUuid(String uuid);

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
	public java.util.List<Cocreator> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Cocreator> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

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
	public java.util.List<Cocreator> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocreator in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public Cocreator findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Returns the first cocreator in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public Cocreator fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

	/**
	 * Returns the last cocreator in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public Cocreator findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Returns the last cocreator in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public Cocreator fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

	/**
	 * Returns the cocreators before and after the current cocreator in the ordered set where uuid = &#63;.
	 *
	 * @param cocreatorId the primary key of the current cocreator
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreator
	 * @throws NoSuchCocreatorException if a cocreator with the primary key could not be found
	 */
	public Cocreator[] findByUuid_PrevAndNext(
			long cocreatorId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Removes all the cocreators where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cocreators where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cocreators
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the cocreator where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCocreatorException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public Cocreator findByUUID_G(String uuid, long groupId)
		throws NoSuchCocreatorException;

	/**
	 * Returns the cocreator where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public Cocreator fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the cocreator where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public Cocreator fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the cocreator where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cocreator that was removed
	 */
	public Cocreator removeByUUID_G(String uuid, long groupId)
		throws NoSuchCocreatorException;

	/**
	 * Returns the number of cocreators where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cocreators
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the cocreators where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cocreators
	 */
	public java.util.List<Cocreator> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Cocreator> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Cocreator> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

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
	public java.util.List<Cocreator> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocreator in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public Cocreator findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Returns the first cocreator in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public Cocreator fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

	/**
	 * Returns the last cocreator in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public Cocreator findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Returns the last cocreator in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public Cocreator fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

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
	public Cocreator[] findByUuid_C_PrevAndNext(
			long cocreatorId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Removes all the cocreators where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of cocreators where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cocreators
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the cocreators where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @return the matching cocreators
	 */
	public java.util.List<Cocreator> findByCocreationId(long cocreationId);

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
	public java.util.List<Cocreator> findByCocreationId(
		long cocreationId, int start, int end);

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
	public java.util.List<Cocreator> findByCocreationId(
		long cocreationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

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
	public java.util.List<Cocreator> findByCocreationId(
		long cocreationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocreator in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public Cocreator findByCocreationId_First(
			long cocreationId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Returns the first cocreator in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public Cocreator fetchByCocreationId_First(
		long cocreationId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

	/**
	 * Returns the last cocreator in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public Cocreator findByCocreationId_Last(
			long cocreationId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Returns the last cocreator in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public Cocreator fetchByCocreationId_Last(
		long cocreationId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

	/**
	 * Returns the cocreators before and after the current cocreator in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreatorId the primary key of the current cocreator
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreator
	 * @throws NoSuchCocreatorException if a cocreator with the primary key could not be found
	 */
	public Cocreator[] findByCocreationId_PrevAndNext(
			long cocreatorId, long cocreationId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Removes all the cocreators where cocreationId = &#63; from the database.
	 *
	 * @param cocreationId the cocreation ID
	 */
	public void removeByCocreationId(long cocreationId);

	/**
	 * Returns the number of cocreators where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @return the number of matching cocreators
	 */
	public int countByCocreationId(long cocreationId);

	/**
	 * Returns all the cocreators where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching cocreators
	 */
	public java.util.List<Cocreator> findByUserId(long userId);

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
	public java.util.List<Cocreator> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<Cocreator> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

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
	public java.util.List<Cocreator> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocreator in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public Cocreator findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Returns the first cocreator in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public Cocreator fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

	/**
	 * Returns the last cocreator in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator
	 * @throws NoSuchCocreatorException if a matching cocreator could not be found
	 */
	public Cocreator findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Returns the last cocreator in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public Cocreator fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

	/**
	 * Returns the cocreators before and after the current cocreator in the ordered set where userId = &#63;.
	 *
	 * @param cocreatorId the primary key of the current cocreator
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreator
	 * @throws NoSuchCocreatorException if a cocreator with the primary key could not be found
	 */
	public Cocreator[] findByUserId_PrevAndNext(
			long cocreatorId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
				orderByComparator)
		throws NoSuchCocreatorException;

	/**
	 * Removes all the cocreators where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of cocreators where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching cocreators
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the cocreator in the entity cache if it is enabled.
	 *
	 * @param cocreator the cocreator
	 */
	public void cacheResult(Cocreator cocreator);

	/**
	 * Caches the cocreators in the entity cache if it is enabled.
	 *
	 * @param cocreators the cocreators
	 */
	public void cacheResult(java.util.List<Cocreator> cocreators);

	/**
	 * Creates a new cocreator with the primary key. Does not add the cocreator to the database.
	 *
	 * @param cocreatorId the primary key for the new cocreator
	 * @return the new cocreator
	 */
	public Cocreator create(long cocreatorId);

	/**
	 * Removes the cocreator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocreatorId the primary key of the cocreator
	 * @return the cocreator that was removed
	 * @throws NoSuchCocreatorException if a cocreator with the primary key could not be found
	 */
	public Cocreator remove(long cocreatorId) throws NoSuchCocreatorException;

	public Cocreator updateImpl(Cocreator cocreator);

	/**
	 * Returns the cocreator with the primary key or throws a <code>NoSuchCocreatorException</code> if it could not be found.
	 *
	 * @param cocreatorId the primary key of the cocreator
	 * @return the cocreator
	 * @throws NoSuchCocreatorException if a cocreator with the primary key could not be found
	 */
	public Cocreator findByPrimaryKey(long cocreatorId)
		throws NoSuchCocreatorException;

	/**
	 * Returns the cocreator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cocreatorId the primary key of the cocreator
	 * @return the cocreator, or <code>null</code> if a cocreator with the primary key could not be found
	 */
	public Cocreator fetchByPrimaryKey(long cocreatorId);

	/**
	 * Returns all the cocreators.
	 *
	 * @return the cocreators
	 */
	public java.util.List<Cocreator> findAll();

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
	public java.util.List<Cocreator> findAll(int start, int end);

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
	public java.util.List<Cocreator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator);

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
	public java.util.List<Cocreator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreator>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cocreators from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cocreators.
	 *
	 * @return the number of cocreators
	 */
	public int countAll();

}