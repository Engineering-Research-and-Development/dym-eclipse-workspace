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

import it.eng.rd.collaborativecreation.exception.NoSuchActivityException;
import it.eng.rd.collaborativecreation.model.Activity;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see ActivityUtil
 * @generated
 */
@ProviderType
public interface ActivityPersistence extends BasePersistence<Activity> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ActivityUtil} to access the activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the activities where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the matching activities
	 */
	public java.util.List<Activity> findByActivity(long activityId);

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
	public java.util.List<Activity> findByActivity(
		long activityId, int start, int end);

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
	public java.util.List<Activity> findByActivity(
		long activityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity>
			orderByComparator);

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
	public java.util.List<Activity> findByActivity(
		long activityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	public Activity findByActivity_First(
			long activityId,
			com.liferay.portal.kernel.util.OrderByComparator<Activity>
				orderByComparator)
		throws NoSuchActivityException;

	/**
	 * Returns the first activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity, or <code>null</code> if a matching activity could not be found
	 */
	public Activity fetchByActivity_First(
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Activity>
			orderByComparator);

	/**
	 * Returns the last activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	public Activity findByActivity_Last(
			long activityId,
			com.liferay.portal.kernel.util.OrderByComparator<Activity>
				orderByComparator)
		throws NoSuchActivityException;

	/**
	 * Returns the last activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity, or <code>null</code> if a matching activity could not be found
	 */
	public Activity fetchByActivity_Last(
		long activityId,
		com.liferay.portal.kernel.util.OrderByComparator<Activity>
			orderByComparator);

	/**
	 * Removes all the activities where activityId = &#63; from the database.
	 *
	 * @param activityId the activity ID
	 */
	public void removeByActivity(long activityId);

	/**
	 * Returns the number of activities where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the number of matching activities
	 */
	public int countByActivity(long activityId);

	/**
	 * Returns all the activities where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @return the matching activities
	 */
	public java.util.List<Activity> findByCocreation(long cocreationId);

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
	public java.util.List<Activity> findByCocreation(
		long cocreationId, int start, int end);

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
	public java.util.List<Activity> findByCocreation(
		long cocreationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity>
			orderByComparator);

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
	public java.util.List<Activity> findByCocreation(
		long cocreationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first activity in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	public Activity findByCocreation_First(
			long cocreationId,
			com.liferay.portal.kernel.util.OrderByComparator<Activity>
				orderByComparator)
		throws NoSuchActivityException;

	/**
	 * Returns the first activity in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity, or <code>null</code> if a matching activity could not be found
	 */
	public Activity fetchByCocreation_First(
		long cocreationId,
		com.liferay.portal.kernel.util.OrderByComparator<Activity>
			orderByComparator);

	/**
	 * Returns the last activity in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	public Activity findByCocreation_Last(
			long cocreationId,
			com.liferay.portal.kernel.util.OrderByComparator<Activity>
				orderByComparator)
		throws NoSuchActivityException;

	/**
	 * Returns the last activity in the ordered set where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity, or <code>null</code> if a matching activity could not be found
	 */
	public Activity fetchByCocreation_Last(
		long cocreationId,
		com.liferay.portal.kernel.util.OrderByComparator<Activity>
			orderByComparator);

	/**
	 * Returns the activities before and after the current activity in the ordered set where cocreationId = &#63;.
	 *
	 * @param activityId the primary key of the current activity
	 * @param cocreationId the cocreation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	public Activity[] findByCocreation_PrevAndNext(
			long activityId, long cocreationId,
			com.liferay.portal.kernel.util.OrderByComparator<Activity>
				orderByComparator)
		throws NoSuchActivityException;

	/**
	 * Removes all the activities where cocreationId = &#63; from the database.
	 *
	 * @param cocreationId the cocreation ID
	 */
	public void removeByCocreation(long cocreationId);

	/**
	 * Returns the number of activities where cocreationId = &#63;.
	 *
	 * @param cocreationId the cocreation ID
	 * @return the number of matching activities
	 */
	public int countByCocreation(long cocreationId);

	/**
	 * Caches the activity in the entity cache if it is enabled.
	 *
	 * @param activity the activity
	 */
	public void cacheResult(Activity activity);

	/**
	 * Caches the activities in the entity cache if it is enabled.
	 *
	 * @param activities the activities
	 */
	public void cacheResult(java.util.List<Activity> activities);

	/**
	 * Creates a new activity with the primary key. Does not add the activity to the database.
	 *
	 * @param activityId the primary key for the new activity
	 * @return the new activity
	 */
	public Activity create(long activityId);

	/**
	 * Removes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity that was removed
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	public Activity remove(long activityId) throws NoSuchActivityException;

	public Activity updateImpl(Activity activity);

	/**
	 * Returns the activity with the primary key or throws a <code>NoSuchActivityException</code> if it could not be found.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	public Activity findByPrimaryKey(long activityId)
		throws NoSuchActivityException;

	/**
	 * Returns the activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity, or <code>null</code> if a activity with the primary key could not be found
	 */
	public Activity fetchByPrimaryKey(long activityId);

	/**
	 * Returns all the activities.
	 *
	 * @return the activities
	 */
	public java.util.List<Activity> findAll();

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
	public java.util.List<Activity> findAll(int start, int end);

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
	public java.util.List<Activity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity>
			orderByComparator);

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
	public java.util.List<Activity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Activity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the activities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of activities.
	 *
	 * @return the number of activities
	 */
	public int countAll();

}