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

import it.eng.rd.collaborativecreation.exception.NoSuchCocreationException;
import it.eng.rd.collaborativecreation.model.Cocreation;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cocreation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see CocreationUtil
 * @generated
 */
@ProviderType
public interface CocreationPersistence extends BasePersistence<Cocreation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CocreationUtil} to access the cocreation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cocreations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cocreations
	 */
	public java.util.List<Cocreation> findByUuid(String uuid);

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
	public java.util.List<Cocreation> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Cocreation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

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
	public java.util.List<Cocreation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocreation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the first cocreation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

	/**
	 * Returns the last cocreation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the last cocreation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

	/**
	 * Returns the cocreations before and after the current cocreation in the ordered set where uuid = &#63;.
	 *
	 * @param cocreationId the primary key of the current cocreation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreation
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public Cocreation[] findByUuid_PrevAndNext(
			long cocreationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Removes all the cocreations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cocreations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cocreations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the cocreation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCocreationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByUUID_G(String uuid, long groupId)
		throws NoSuchCocreationException;

	/**
	 * Returns the cocreation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the cocreation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the cocreation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the cocreation that was removed
	 */
	public Cocreation removeByUUID_G(String uuid, long groupId)
		throws NoSuchCocreationException;

	/**
	 * Returns the number of cocreations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cocreations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the cocreations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cocreations
	 */
	public java.util.List<Cocreation> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Cocreation> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Cocreation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

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
	public java.util.List<Cocreation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocreation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the first cocreation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

	/**
	 * Returns the last cocreation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the last cocreation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

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
	public Cocreation[] findByUuid_C_PrevAndNext(
			long cocreationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Removes all the cocreations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of cocreations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cocreations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the cocreations where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @return the matching cocreations
	 */
	public java.util.List<Cocreation> findByChallengeId(long challengeId);

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
	public java.util.List<Cocreation> findByChallengeId(
		long challengeId, int start, int end);

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
	public java.util.List<Cocreation> findByChallengeId(
		long challengeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

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
	public java.util.List<Cocreation> findByChallengeId(
		long challengeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocreation in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByChallengeId_First(
			long challengeId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the first cocreation in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByChallengeId_First(
		long challengeId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

	/**
	 * Returns the last cocreation in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByChallengeId_Last(
			long challengeId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the last cocreation in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByChallengeId_Last(
		long challengeId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

	/**
	 * Returns the cocreations before and after the current cocreation in the ordered set where challengeId = &#63;.
	 *
	 * @param cocreationId the primary key of the current cocreation
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreation
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public Cocreation[] findByChallengeId_PrevAndNext(
			long cocreationId, long challengeId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Removes all the cocreations where challengeId = &#63; from the database.
	 *
	 * @param challengeId the challenge ID
	 */
	public void removeByChallengeId(long challengeId);

	/**
	 * Returns the number of cocreations where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @return the number of matching cocreations
	 */
	public int countByChallengeId(long challengeId);

	/**
	 * Returns all the cocreations where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching cocreations
	 */
	public java.util.List<Cocreation> findByTitle(String title);

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
	public java.util.List<Cocreation> findByTitle(
		String title, int start, int end);

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
	public java.util.List<Cocreation> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

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
	public java.util.List<Cocreation> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocreation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByTitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the first cocreation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByTitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

	/**
	 * Returns the last cocreation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByTitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the last cocreation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByTitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

	/**
	 * Returns the cocreations before and after the current cocreation in the ordered set where title = &#63;.
	 *
	 * @param cocreationId the primary key of the current cocreation
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cocreation
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public Cocreation[] findByTitle_PrevAndNext(
			long cocreationId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Removes all the cocreations where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeByTitle(String title);

	/**
	 * Returns the number of cocreations where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching cocreations
	 */
	public int countByTitle(String title);

	/**
	 * Returns all the cocreations where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching cocreations
	 */
	public java.util.List<Cocreation> findByUserId(long userId, long groupId);

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
	public java.util.List<Cocreation> findByUserId(
		long userId, long groupId, int start, int end);

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
	public java.util.List<Cocreation> findByUserId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

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
	public java.util.List<Cocreation> findByUserId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocreation in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByUserId_First(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the first cocreation in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByUserId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

	/**
	 * Returns the last cocreation in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByUserId_Last(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the last cocreation in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByUserId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

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
	public Cocreation[] findByUserId_PrevAndNext(
			long cocreationId, long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Removes all the cocreations where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	public void removeByUserId(long userId, long groupId);

	/**
	 * Returns the number of cocreations where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching cocreations
	 */
	public int countByUserId(long userId, long groupId);

	/**
	 * Returns all the cocreations where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @return the matching cocreations
	 */
	public java.util.List<Cocreation> findByGroupId(
		long groupId, boolean completed);

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
	public java.util.List<Cocreation> findByGroupId(
		long groupId, boolean completed, int start, int end);

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
	public java.util.List<Cocreation> findByGroupId(
		long groupId, boolean completed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

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
	public java.util.List<Cocreation> findByGroupId(
		long groupId, boolean completed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cocreation in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByGroupId_First(
			long groupId, boolean completed,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the first cocreation in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByGroupId_First(
		long groupId, boolean completed,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

	/**
	 * Returns the last cocreation in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation
	 * @throws NoSuchCocreationException if a matching cocreation could not be found
	 */
	public Cocreation findByGroupId_Last(
			long groupId, boolean completed,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Returns the last cocreation in the ordered set where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	public Cocreation fetchByGroupId_Last(
		long groupId, boolean completed,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

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
	public Cocreation[] findByGroupId_PrevAndNext(
			long cocreationId, long groupId, boolean completed,
			com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
				orderByComparator)
		throws NoSuchCocreationException;

	/**
	 * Removes all the cocreations where groupId = &#63; and completed = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 */
	public void removeByGroupId(long groupId, boolean completed);

	/**
	 * Returns the number of cocreations where groupId = &#63; and completed = &#63;.
	 *
	 * @param groupId the group ID
	 * @param completed the completed
	 * @return the number of matching cocreations
	 */
	public int countByGroupId(long groupId, boolean completed);

	/**
	 * Caches the cocreation in the entity cache if it is enabled.
	 *
	 * @param cocreation the cocreation
	 */
	public void cacheResult(Cocreation cocreation);

	/**
	 * Caches the cocreations in the entity cache if it is enabled.
	 *
	 * @param cocreations the cocreations
	 */
	public void cacheResult(java.util.List<Cocreation> cocreations);

	/**
	 * Creates a new cocreation with the primary key. Does not add the cocreation to the database.
	 *
	 * @param cocreationId the primary key for the new cocreation
	 * @return the new cocreation
	 */
	public Cocreation create(long cocreationId);

	/**
	 * Removes the cocreation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cocreationId the primary key of the cocreation
	 * @return the cocreation that was removed
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public Cocreation remove(long cocreationId)
		throws NoSuchCocreationException;

	public Cocreation updateImpl(Cocreation cocreation);

	/**
	 * Returns the cocreation with the primary key or throws a <code>NoSuchCocreationException</code> if it could not be found.
	 *
	 * @param cocreationId the primary key of the cocreation
	 * @return the cocreation
	 * @throws NoSuchCocreationException if a cocreation with the primary key could not be found
	 */
	public Cocreation findByPrimaryKey(long cocreationId)
		throws NoSuchCocreationException;

	/**
	 * Returns the cocreation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cocreationId the primary key of the cocreation
	 * @return the cocreation, or <code>null</code> if a cocreation with the primary key could not be found
	 */
	public Cocreation fetchByPrimaryKey(long cocreationId);

	/**
	 * Returns all the cocreations.
	 *
	 * @return the cocreations
	 */
	public java.util.List<Cocreation> findAll();

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
	public java.util.List<Cocreation> findAll(int start, int end);

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
	public java.util.List<Cocreation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator);

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
	public java.util.List<Cocreation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cocreation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cocreations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cocreations.
	 *
	 * @return the number of cocreations
	 */
	public int countAll();

}