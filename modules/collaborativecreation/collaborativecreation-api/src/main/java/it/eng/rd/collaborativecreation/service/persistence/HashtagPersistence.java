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

import it.eng.rd.collaborativecreation.exception.NoSuchHashtagException;
import it.eng.rd.collaborativecreation.model.Hashtag;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the hashtag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see HashtagUtil
 * @generated
 */
@ProviderType
public interface HashtagPersistence extends BasePersistence<Hashtag> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HashtagUtil} to access the hashtag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the hashtags where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @return the matching hashtags
	 */
	public java.util.List<Hashtag> findByChallenge(long challengeId);

	/**
	 * Returns a range of all the hashtags where challengeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param challengeId the challenge ID
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @return the range of matching hashtags
	 */
	public java.util.List<Hashtag> findByChallenge(
		long challengeId, int start, int end);

	/**
	 * Returns an ordered range of all the hashtags where challengeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param challengeId the challenge ID
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hashtags
	 */
	public java.util.List<Hashtag> findByChallenge(
		long challengeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hashtag>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hashtags where challengeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param challengeId the challenge ID
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hashtags
	 */
	public java.util.List<Hashtag> findByChallenge(
		long challengeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hashtag>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first hashtag in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hashtag
	 * @throws NoSuchHashtagException if a matching hashtag could not be found
	 */
	public Hashtag findByChallenge_First(
			long challengeId,
			com.liferay.portal.kernel.util.OrderByComparator<Hashtag>
				orderByComparator)
		throws NoSuchHashtagException;

	/**
	 * Returns the first hashtag in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hashtag, or <code>null</code> if a matching hashtag could not be found
	 */
	public Hashtag fetchByChallenge_First(
		long challengeId,
		com.liferay.portal.kernel.util.OrderByComparator<Hashtag>
			orderByComparator);

	/**
	 * Returns the last hashtag in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hashtag
	 * @throws NoSuchHashtagException if a matching hashtag could not be found
	 */
	public Hashtag findByChallenge_Last(
			long challengeId,
			com.liferay.portal.kernel.util.OrderByComparator<Hashtag>
				orderByComparator)
		throws NoSuchHashtagException;

	/**
	 * Returns the last hashtag in the ordered set where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hashtag, or <code>null</code> if a matching hashtag could not be found
	 */
	public Hashtag fetchByChallenge_Last(
		long challengeId,
		com.liferay.portal.kernel.util.OrderByComparator<Hashtag>
			orderByComparator);

	/**
	 * Returns the hashtags before and after the current hashtag in the ordered set where challengeId = &#63;.
	 *
	 * @param hashtagId the primary key of the current hashtag
	 * @param challengeId the challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hashtag
	 * @throws NoSuchHashtagException if a hashtag with the primary key could not be found
	 */
	public Hashtag[] findByChallenge_PrevAndNext(
			long hashtagId, long challengeId,
			com.liferay.portal.kernel.util.OrderByComparator<Hashtag>
				orderByComparator)
		throws NoSuchHashtagException;

	/**
	 * Removes all the hashtags where challengeId = &#63; from the database.
	 *
	 * @param challengeId the challenge ID
	 */
	public void removeByChallenge(long challengeId);

	/**
	 * Returns the number of hashtags where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @return the number of matching hashtags
	 */
	public int countByChallenge(long challengeId);

	/**
	 * Returns the hashtag where challengeId = &#63; and name = &#63; or throws a <code>NoSuchHashtagException</code> if it could not be found.
	 *
	 * @param challengeId the challenge ID
	 * @param name the name
	 * @return the matching hashtag
	 * @throws NoSuchHashtagException if a matching hashtag could not be found
	 */
	public Hashtag findByName(long challengeId, String name)
		throws NoSuchHashtagException;

	/**
	 * Returns the hashtag where challengeId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param challengeId the challenge ID
	 * @param name the name
	 * @return the matching hashtag, or <code>null</code> if a matching hashtag could not be found
	 */
	public Hashtag fetchByName(long challengeId, String name);

	/**
	 * Returns the hashtag where challengeId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param challengeId the challenge ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching hashtag, or <code>null</code> if a matching hashtag could not be found
	 */
	public Hashtag fetchByName(
		long challengeId, String name, boolean useFinderCache);

	/**
	 * Removes the hashtag where challengeId = &#63; and name = &#63; from the database.
	 *
	 * @param challengeId the challenge ID
	 * @param name the name
	 * @return the hashtag that was removed
	 */
	public Hashtag removeByName(long challengeId, String name)
		throws NoSuchHashtagException;

	/**
	 * Returns the number of hashtags where challengeId = &#63; and name = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param name the name
	 * @return the number of matching hashtags
	 */
	public int countByName(long challengeId, String name);

	/**
	 * Caches the hashtag in the entity cache if it is enabled.
	 *
	 * @param hashtag the hashtag
	 */
	public void cacheResult(Hashtag hashtag);

	/**
	 * Caches the hashtags in the entity cache if it is enabled.
	 *
	 * @param hashtags the hashtags
	 */
	public void cacheResult(java.util.List<Hashtag> hashtags);

	/**
	 * Creates a new hashtag with the primary key. Does not add the hashtag to the database.
	 *
	 * @param hashtagId the primary key for the new hashtag
	 * @return the new hashtag
	 */
	public Hashtag create(long hashtagId);

	/**
	 * Removes the hashtag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hashtagId the primary key of the hashtag
	 * @return the hashtag that was removed
	 * @throws NoSuchHashtagException if a hashtag with the primary key could not be found
	 */
	public Hashtag remove(long hashtagId) throws NoSuchHashtagException;

	public Hashtag updateImpl(Hashtag hashtag);

	/**
	 * Returns the hashtag with the primary key or throws a <code>NoSuchHashtagException</code> if it could not be found.
	 *
	 * @param hashtagId the primary key of the hashtag
	 * @return the hashtag
	 * @throws NoSuchHashtagException if a hashtag with the primary key could not be found
	 */
	public Hashtag findByPrimaryKey(long hashtagId)
		throws NoSuchHashtagException;

	/**
	 * Returns the hashtag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hashtagId the primary key of the hashtag
	 * @return the hashtag, or <code>null</code> if a hashtag with the primary key could not be found
	 */
	public Hashtag fetchByPrimaryKey(long hashtagId);

	/**
	 * Returns all the hashtags.
	 *
	 * @return the hashtags
	 */
	public java.util.List<Hashtag> findAll();

	/**
	 * Returns a range of all the hashtags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @return the range of hashtags
	 */
	public java.util.List<Hashtag> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the hashtags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hashtags
	 */
	public java.util.List<Hashtag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hashtag>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hashtags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hashtags
	 */
	public java.util.List<Hashtag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hashtag>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the hashtags from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of hashtags.
	 *
	 * @return the number of hashtags
	 */
	public int countAll();

}