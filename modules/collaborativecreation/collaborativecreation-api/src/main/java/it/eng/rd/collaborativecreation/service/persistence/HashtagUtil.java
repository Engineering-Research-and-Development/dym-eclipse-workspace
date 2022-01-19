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

import it.eng.rd.collaborativecreation.model.Hashtag;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the hashtag service. This utility wraps <code>it.eng.rd.collaborativecreation.service.persistence.impl.HashtagPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see HashtagPersistence
 * @generated
 */
public class HashtagUtil {

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
	public static void clearCache(Hashtag hashtag) {
		getPersistence().clearCache(hashtag);
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
	public static Map<Serializable, Hashtag> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Hashtag> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Hashtag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Hashtag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Hashtag> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Hashtag update(Hashtag hashtag) {
		return getPersistence().update(hashtag);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Hashtag update(
		Hashtag hashtag, ServiceContext serviceContext) {

		return getPersistence().update(hashtag, serviceContext);
	}

	/**
	 * Returns all the hashtags where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching hashtags
	 */
	public static List<Hashtag> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the hashtags where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @return the range of matching hashtags
	 */
	public static List<Hashtag> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the hashtags where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hashtags
	 */
	public static List<Hashtag> findByName(
		String name, int start, int end,
		OrderByComparator<Hashtag> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the hashtags where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hashtags
	 */
	public static List<Hashtag> findByName(
		String name, int start, int end,
		OrderByComparator<Hashtag> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first hashtag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hashtag
	 * @throws NoSuchHashtagException if a matching hashtag could not be found
	 */
	public static Hashtag findByName_First(
			String name, OrderByComparator<Hashtag> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchHashtagException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first hashtag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hashtag, or <code>null</code> if a matching hashtag could not be found
	 */
	public static Hashtag fetchByName_First(
		String name, OrderByComparator<Hashtag> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last hashtag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hashtag
	 * @throws NoSuchHashtagException if a matching hashtag could not be found
	 */
	public static Hashtag findByName_Last(
			String name, OrderByComparator<Hashtag> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchHashtagException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last hashtag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hashtag, or <code>null</code> if a matching hashtag could not be found
	 */
	public static Hashtag fetchByName_Last(
		String name, OrderByComparator<Hashtag> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the hashtags before and after the current hashtag in the ordered set where name = &#63;.
	 *
	 * @param hashtagId the primary key of the current hashtag
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hashtag
	 * @throws NoSuchHashtagException if a hashtag with the primary key could not be found
	 */
	public static Hashtag[] findByName_PrevAndNext(
			long hashtagId, String name,
			OrderByComparator<Hashtag> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchHashtagException {

		return getPersistence().findByName_PrevAndNext(
			hashtagId, name, orderByComparator);
	}

	/**
	 * Removes all the hashtags where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of hashtags where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching hashtags
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the hashtag in the entity cache if it is enabled.
	 *
	 * @param hashtag the hashtag
	 */
	public static void cacheResult(Hashtag hashtag) {
		getPersistence().cacheResult(hashtag);
	}

	/**
	 * Caches the hashtags in the entity cache if it is enabled.
	 *
	 * @param hashtags the hashtags
	 */
	public static void cacheResult(List<Hashtag> hashtags) {
		getPersistence().cacheResult(hashtags);
	}

	/**
	 * Creates a new hashtag with the primary key. Does not add the hashtag to the database.
	 *
	 * @param hashtagId the primary key for the new hashtag
	 * @return the new hashtag
	 */
	public static Hashtag create(long hashtagId) {
		return getPersistence().create(hashtagId);
	}

	/**
	 * Removes the hashtag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hashtagId the primary key of the hashtag
	 * @return the hashtag that was removed
	 * @throws NoSuchHashtagException if a hashtag with the primary key could not be found
	 */
	public static Hashtag remove(long hashtagId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchHashtagException {

		return getPersistence().remove(hashtagId);
	}

	public static Hashtag updateImpl(Hashtag hashtag) {
		return getPersistence().updateImpl(hashtag);
	}

	/**
	 * Returns the hashtag with the primary key or throws a <code>NoSuchHashtagException</code> if it could not be found.
	 *
	 * @param hashtagId the primary key of the hashtag
	 * @return the hashtag
	 * @throws NoSuchHashtagException if a hashtag with the primary key could not be found
	 */
	public static Hashtag findByPrimaryKey(long hashtagId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchHashtagException {

		return getPersistence().findByPrimaryKey(hashtagId);
	}

	/**
	 * Returns the hashtag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hashtagId the primary key of the hashtag
	 * @return the hashtag, or <code>null</code> if a hashtag with the primary key could not be found
	 */
	public static Hashtag fetchByPrimaryKey(long hashtagId) {
		return getPersistence().fetchByPrimaryKey(hashtagId);
	}

	/**
	 * Returns all the hashtags.
	 *
	 * @return the hashtags
	 */
	public static List<Hashtag> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Hashtag> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Hashtag> findAll(
		int start, int end, OrderByComparator<Hashtag> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Hashtag> findAll(
		int start, int end, OrderByComparator<Hashtag> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the hashtags from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of hashtags.
	 *
	 * @return the number of hashtags
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HashtagPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<HashtagPersistence, HashtagPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(HashtagPersistence.class);

		ServiceTracker<HashtagPersistence, HashtagPersistence> serviceTracker =
			new ServiceTracker<HashtagPersistence, HashtagPersistence>(
				bundle.getBundleContext(), HashtagPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}