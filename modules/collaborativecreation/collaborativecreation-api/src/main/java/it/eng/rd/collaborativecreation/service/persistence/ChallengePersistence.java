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

import it.eng.rd.collaborativecreation.exception.NoSuchChallengeException;
import it.eng.rd.collaborativecreation.model.Challenge;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the challenge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see ChallengeUtil
 * @generated
 */
@ProviderType
public interface ChallengePersistence extends BasePersistence<Challenge> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChallengeUtil} to access the challenge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the challenges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching challenges
	 */
	public java.util.List<Challenge> findByUuid(String uuid);

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
	public java.util.List<Challenge> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Challenge> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

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
	public java.util.List<Challenge> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the first challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns the last challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the last challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns the challenges before and after the current challenge in the ordered set where uuid = &#63;.
	 *
	 * @param challengeId the primary key of the current challenge
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public Challenge[] findByUuid_PrevAndNext(
			long challengeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Removes all the challenges where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of challenges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching challenges
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the challenge where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchChallengeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByUUID_G(String uuid, long groupId)
		throws NoSuchChallengeException;

	/**
	 * Returns the challenge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the challenge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the challenge where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the challenge that was removed
	 */
	public Challenge removeByUUID_G(String uuid, long groupId)
		throws NoSuchChallengeException;

	/**
	 * Returns the number of challenges where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching challenges
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the challenges where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching challenges
	 */
	public java.util.List<Challenge> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Challenge> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Challenge> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

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
	public java.util.List<Challenge> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the first challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns the last challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the last challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

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
	public Challenge[] findByUuid_C_PrevAndNext(
			long challengeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Removes all the challenges where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of challenges where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching challenges
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the challenges where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching challenges
	 */
	public java.util.List<Challenge> findByTitle(String title);

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
	public java.util.List<Challenge> findByTitle(
		String title, int start, int end);

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
	public java.util.List<Challenge> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

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
	public java.util.List<Challenge> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first challenge in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByTitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the first challenge in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByTitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns the last challenge in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByTitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the last challenge in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByTitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns the challenges before and after the current challenge in the ordered set where title = &#63;.
	 *
	 * @param challengeId the primary key of the current challenge
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public Challenge[] findByTitle_PrevAndNext(
			long challengeId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Removes all the challenges where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeByTitle(String title);

	/**
	 * Returns the number of challenges where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching challenges
	 */
	public int countByTitle(String title);

	/**
	 * Returns all the challenges where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching challenges
	 */
	public java.util.List<Challenge> findByUserId(long groupId, long userId);

	/**
	 * Returns a range of all the challenges where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of matching challenges
	 */
	public java.util.List<Challenge> findByUserId(
		long groupId, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the challenges where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching challenges
	 */
	public java.util.List<Challenge> findByUserId(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns an ordered range of all the challenges where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching challenges
	 */
	public java.util.List<Challenge> findByUserId(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first challenge in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByUserId_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the first challenge in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByUserId_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns the last challenge in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByUserId_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the last challenge in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByUserId_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns the challenges before and after the current challenge in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param challengeId the primary key of the current challenge
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public Challenge[] findByUserId_PrevAndNext(
			long challengeId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Removes all the challenges where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByUserId(long groupId, long userId);

	/**
	 * Returns the number of challenges where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching challenges
	 */
	public int countByUserId(long groupId, long userId);

	/**
	 * Returns all the challenges where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching challenges
	 */
	public java.util.List<Challenge> findByGroupId(long groupId);

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
	public java.util.List<Challenge> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Challenge> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

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
	public java.util.List<Challenge> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first challenge in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the first challenge in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns the last challenge in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the last challenge in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns the challenges before and after the current challenge in the ordered set where groupId = &#63;.
	 *
	 * @param challengeId the primary key of the current challenge
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public Challenge[] findByGroupId_PrevAndNext(
			long challengeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Removes all the challenges where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of challenges where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching challenges
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the challenges where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching challenges
	 */
	public java.util.List<Challenge> findByActive(boolean active);

	/**
	 * Returns a range of all the challenges where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of matching challenges
	 */
	public java.util.List<Challenge> findByActive(
		boolean active, int start, int end);

	/**
	 * Returns an ordered range of all the challenges where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching challenges
	 */
	public java.util.List<Challenge> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns an ordered range of all the challenges where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching challenges
	 */
	public java.util.List<Challenge> findByActive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first challenge in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByActive_First(
			boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the first challenge in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByActive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns the last challenge in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge
	 * @throws NoSuchChallengeException if a matching challenge could not be found
	 */
	public Challenge findByActive_Last(
			boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Returns the last challenge in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public Challenge fetchByActive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

	/**
	 * Returns the challenges before and after the current challenge in the ordered set where active = &#63;.
	 *
	 * @param challengeId the primary key of the current challenge
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public Challenge[] findByActive_PrevAndNext(
			long challengeId, boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<Challenge>
				orderByComparator)
		throws NoSuchChallengeException;

	/**
	 * Removes all the challenges where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByActive(boolean active);

	/**
	 * Returns the number of challenges where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching challenges
	 */
	public int countByActive(boolean active);

	/**
	 * Caches the challenge in the entity cache if it is enabled.
	 *
	 * @param challenge the challenge
	 */
	public void cacheResult(Challenge challenge);

	/**
	 * Caches the challenges in the entity cache if it is enabled.
	 *
	 * @param challenges the challenges
	 */
	public void cacheResult(java.util.List<Challenge> challenges);

	/**
	 * Creates a new challenge with the primary key. Does not add the challenge to the database.
	 *
	 * @param challengeId the primary key for the new challenge
	 * @return the new challenge
	 */
	public Challenge create(long challengeId);

	/**
	 * Removes the challenge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param challengeId the primary key of the challenge
	 * @return the challenge that was removed
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public Challenge remove(long challengeId) throws NoSuchChallengeException;

	public Challenge updateImpl(Challenge challenge);

	/**
	 * Returns the challenge with the primary key or throws a <code>NoSuchChallengeException</code> if it could not be found.
	 *
	 * @param challengeId the primary key of the challenge
	 * @return the challenge
	 * @throws NoSuchChallengeException if a challenge with the primary key could not be found
	 */
	public Challenge findByPrimaryKey(long challengeId)
		throws NoSuchChallengeException;

	/**
	 * Returns the challenge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param challengeId the primary key of the challenge
	 * @return the challenge, or <code>null</code> if a challenge with the primary key could not be found
	 */
	public Challenge fetchByPrimaryKey(long challengeId);

	/**
	 * Returns all the challenges.
	 *
	 * @return the challenges
	 */
	public java.util.List<Challenge> findAll();

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
	public java.util.List<Challenge> findAll(int start, int end);

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
	public java.util.List<Challenge> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator);

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
	public java.util.List<Challenge> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Challenge>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the challenges from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of challenges.
	 *
	 * @return the number of challenges
	 */
	public int countAll();

}