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

import it.eng.rd.collaborativecreation.model.Activity;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the activity service. This utility wraps <code>it.eng.rd.collaborativecreation.service.persistence.impl.ActivityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see ActivityPersistence
 * @generated
 */
public class ActivityUtil {

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
	public static void clearCache(Activity activity) {
		getPersistence().clearCache(activity);
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
	public static Map<Serializable, Activity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Activity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Activity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Activity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Activity> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Activity update(Activity activity) {
		return getPersistence().update(activity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Activity update(
		Activity activity, ServiceContext serviceContext) {

		return getPersistence().update(activity, serviceContext);
	}

	/**
	 * Returns all the activities where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the matching activities
	 */
	public static List<Activity> findByActivity(long activityId) {
		return getPersistence().findByActivity(activityId);
	}

	/**
	 * Returns a range of all the activities where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @return the range of matching activities
	 */
	public static List<Activity> findByActivity(
		long activityId, int start, int end) {

		return getPersistence().findByActivity(activityId, start, end);
	}

	/**
	 * Returns an ordered range of all the activities where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activities
	 */
	public static List<Activity> findByActivity(
		long activityId, int start, int end,
		OrderByComparator<Activity> orderByComparator) {

		return getPersistence().findByActivity(
			activityId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activities where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activities
	 */
	public static List<Activity> findByActivity(
		long activityId, int start, int end,
		OrderByComparator<Activity> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByActivity(
			activityId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	public static Activity findByActivity_First(
			long activityId, OrderByComparator<Activity> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchActivityException {

		return getPersistence().findByActivity_First(
			activityId, orderByComparator);
	}

	/**
	 * Returns the first activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity, or <code>null</code> if a matching activity could not be found
	 */
	public static Activity fetchByActivity_First(
		long activityId, OrderByComparator<Activity> orderByComparator) {

		return getPersistence().fetchByActivity_First(
			activityId, orderByComparator);
	}

	/**
	 * Returns the last activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	public static Activity findByActivity_Last(
			long activityId, OrderByComparator<Activity> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchActivityException {

		return getPersistence().findByActivity_Last(
			activityId, orderByComparator);
	}

	/**
	 * Returns the last activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity, or <code>null</code> if a matching activity could not be found
	 */
	public static Activity fetchByActivity_Last(
		long activityId, OrderByComparator<Activity> orderByComparator) {

		return getPersistence().fetchByActivity_Last(
			activityId, orderByComparator);
	}

	/**
	 * Removes all the activities where activityId = &#63; from the database.
	 *
	 * @param activityId the activity ID
	 */
	public static void removeByActivity(long activityId) {
		getPersistence().removeByActivity(activityId);
	}

	/**
	 * Returns the number of activities where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the number of matching activities
	 */
	public static int countByActivity(long activityId) {
		return getPersistence().countByActivity(activityId);
	}

	/**
	 * Returns all the activities where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @return the matching activities
	 */
	public static List<Activity> findByCocreation(long cocreationId) {
		return getPersistence().findByCocreation(cocreationId);
	}

	/**
	 * Returns a range of all the activities where cocreationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param cocreationId the cocreation ID
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @return the range of matching activities
	 */
	public static List<Activity> findByCocreation(
		long cocreationId, int start, int end) {

		return getPersistence().findByCocreation(cocreationId, start, end);
	}

	/**
	 * Returns an ordered range of all the activities where cocreationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param cocreationId the cocreation ID
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activities
	 */
	public static List<Activity> findByCocreation(
		long cocreationId, int start, int end,
		OrderByComparator<Activity> orderByComparator) {

		return getPersistence().findByCocreation(
			cocreationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activities where cocreationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param cocreationId the cocreation ID
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activities
	 */
	public static List<Activity> findByCocreation(
		long cocreationId, int start, int end,
		OrderByComparator<Activity> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCocreation(
			cocreationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	public static Activity findByCocreation_First(
			long cocreationId, OrderByComparator<Activity> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchActivityException {

		return getPersistence().findByCocreation_First(
			cocreationId, orderByComparator);
	}

	/**
	 * Returns the first activity in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity, or <code>null</code> if a matching activity could not be found
	 */
	public static Activity fetchByCocreation_First(
		long cocreationId, OrderByComparator<Activity> orderByComparator) {

		return getPersistence().fetchByCocreation_First(
			cocreationId, orderByComparator);
	}

	/**
	 * Returns the last activity in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	public static Activity findByCocreation_Last(
			long cocreationId, OrderByComparator<Activity> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchActivityException {

		return getPersistence().findByCocreation_Last(
			cocreationId, orderByComparator);
	}

	/**
	 * Returns the last activity in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity, or <code>null</code> if a matching activity could not be found
	 */
	public static Activity fetchByCocreation_Last(
		long cocreationId, OrderByComparator<Activity> orderByComparator) {

		return getPersistence().fetchByCocreation_Last(
			cocreationId, orderByComparator);
	}

	/**
	 * Returns the activities before and after the current activity in the ordered set where cocreationId = &#63;.
	 *
	 * @param activityId the primary key of the current activity
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	public static Activity[] findByCocreation_PrevAndNext(
			long activityId, long cocreationId,
			OrderByComparator<Activity> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchActivityException {

		return getPersistence().findByCocreation_PrevAndNext(
			activityId, cocreationId, orderByComparator);
	}

	/**
	 * Removes all the activities where cocreationId = &#63; from the database.
	 *
	 * @param cocreationId the cocreation ID
	 */
	public static void removeByCocreation(long cocreationId) {
		getPersistence().removeByCocreation(cocreationId);
	}

	/**
	 * Returns the number of activities where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @return the number of matching activities
	 */
	public static int countByCocreation(long cocreationId) {
		return getPersistence().countByCocreation(cocreationId);
	}

	/**
	 * Caches the activity in the entity cache if it is enabled.
	 *
	 * @param activity the activity
	 */
	public static void cacheResult(Activity activity) {
		getPersistence().cacheResult(activity);
	}

	/**
	 * Caches the activities in the entity cache if it is enabled.
	 *
	 * @param activities the activities
	 */
	public static void cacheResult(List<Activity> activities) {
		getPersistence().cacheResult(activities);
	}

	/**
	 * Creates a new activity with the primary key. Does not add the activity to the database.
	 *
	 * @param activityId the primary key for the new activity
	 * @return the new activity
	 */
	public static Activity create(long activityId) {
		return getPersistence().create(activityId);
	}

	/**
	 * Removes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity that was removed
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	public static Activity remove(long activityId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchActivityException {

		return getPersistence().remove(activityId);
	}

	public static Activity updateImpl(Activity activity) {
		return getPersistence().updateImpl(activity);
	}

	/**
	 * Returns the activity with the primary key or throws a <code>NoSuchActivityException</code> if it could not be found.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	public static Activity findByPrimaryKey(long activityId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchActivityException {

		return getPersistence().findByPrimaryKey(activityId);
	}

	/**
	 * Returns the activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity, or <code>null</code> if a activity with the primary key could not be found
	 */
	public static Activity fetchByPrimaryKey(long activityId) {
		return getPersistence().fetchByPrimaryKey(activityId);
	}

	/**
	 * Returns all the activities.
	 *
	 * @return the activities
	 */
	public static List<Activity> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @return the range of activities
	 */
	public static List<Activity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of activities
	 */
	public static List<Activity> findAll(
		int start, int end, OrderByComparator<Activity> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of activities
	 */
	public static List<Activity> findAll(
		int start, int end, OrderByComparator<Activity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the activities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of activities.
	 *
	 * @return the number of activities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ActivityPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ActivityPersistence, ActivityPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ActivityPersistence.class);

		ServiceTracker<ActivityPersistence, ActivityPersistence>
			serviceTracker =
				new ServiceTracker<ActivityPersistence, ActivityPersistence>(
					bundle.getBundleContext(), ActivityPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}