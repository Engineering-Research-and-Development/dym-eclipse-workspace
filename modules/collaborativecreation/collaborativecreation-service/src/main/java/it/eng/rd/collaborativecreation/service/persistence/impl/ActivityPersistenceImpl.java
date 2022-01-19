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

package it.eng.rd.collaborativecreation.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import it.eng.rd.collaborativecreation.exception.NoSuchActivityException;
import it.eng.rd.collaborativecreation.model.Activity;
import it.eng.rd.collaborativecreation.model.impl.ActivityImpl;
import it.eng.rd.collaborativecreation.model.impl.ActivityModelImpl;
import it.eng.rd.collaborativecreation.service.persistence.ActivityPersistence;
import it.eng.rd.collaborativecreation.service.persistence.impl.constants.COCREATIONPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @generated
 */
@Component(service = ActivityPersistence.class)
public class ActivityPersistenceImpl
	extends BasePersistenceImpl<Activity> implements ActivityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ActivityUtil</code> to access the activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ActivityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByActivity;
	private FinderPath _finderPathWithoutPaginationFindByActivity;
	private FinderPath _finderPathCountByActivity;

	/**
	 * Returns all the activities where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the matching activities
	 */
	@Override
	public List<Activity> findByActivity(long activityId) {
		return findByActivity(
			activityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Activity> findByActivity(long activityId, int start, int end) {
		return findByActivity(activityId, start, end, null);
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
	@Override
	public List<Activity> findByActivity(
		long activityId, int start, int end,
		OrderByComparator<Activity> orderByComparator) {

		return findByActivity(activityId, start, end, orderByComparator, true);
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
	@Override
	public List<Activity> findByActivity(
		long activityId, int start, int end,
		OrderByComparator<Activity> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByActivity;
				finderArgs = new Object[] {activityId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByActivity;
			finderArgs = new Object[] {
				activityId, start, end, orderByComparator
			};
		}

		List<Activity> list = null;

		if (useFinderCache) {
			list = (List<Activity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Activity activity : list) {
					if (activityId != activity.getActivityId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ACTIVITY_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVITY_ACTIVITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ActivityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(activityId);

				list = (List<Activity>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	@Override
	public Activity findByActivity_First(
			long activityId, OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException {

		Activity activity = fetchByActivity_First(
			activityId, orderByComparator);

		if (activity != null) {
			return activity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("activityId=");
		sb.append(activityId);

		sb.append("}");

		throw new NoSuchActivityException(sb.toString());
	}

	/**
	 * Returns the first activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity, or <code>null</code> if a matching activity could not be found
	 */
	@Override
	public Activity fetchByActivity_First(
		long activityId, OrderByComparator<Activity> orderByComparator) {

		List<Activity> list = findByActivity(
			activityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity
	 * @throws NoSuchActivityException if a matching activity could not be found
	 */
	@Override
	public Activity findByActivity_Last(
			long activityId, OrderByComparator<Activity> orderByComparator)
		throws NoSuchActivityException {

		Activity activity = fetchByActivity_Last(activityId, orderByComparator);

		if (activity != null) {
			return activity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("activityId=");
		sb.append(activityId);

		sb.append("}");

		throw new NoSuchActivityException(sb.toString());
	}

	/**
	 * Returns the last activity in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity, or <code>null</code> if a matching activity could not be found
	 */
	@Override
	public Activity fetchByActivity_Last(
		long activityId, OrderByComparator<Activity> orderByComparator) {

		int count = countByActivity(activityId);

		if (count == 0) {
			return null;
		}

		List<Activity> list = findByActivity(
			activityId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the activities where activityId = &#63; from the database.
	 *
	 * @param activityId the activity ID
	 */
	@Override
	public void removeByActivity(long activityId) {
		for (Activity activity :
				findByActivity(
					activityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(activity);
		}
	}

	/**
	 * Returns the number of activities where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the number of matching activities
	 */
	@Override
	public int countByActivity(long activityId) {
		FinderPath finderPath = _finderPathCountByActivity;

		Object[] finderArgs = new Object[] {activityId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTIVITY_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVITY_ACTIVITYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(activityId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ACTIVITY_ACTIVITYID_2 =
		"activity.activityId = ?";

	public ActivityPersistenceImpl() {
		setModelClass(Activity.class);

		setModelImplClass(ActivityImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the activity in the entity cache if it is enabled.
	 *
	 * @param activity the activity
	 */
	@Override
	public void cacheResult(Activity activity) {
		entityCache.putResult(
			ActivityImpl.class, activity.getPrimaryKey(), activity);
	}

	/**
	 * Caches the activities in the entity cache if it is enabled.
	 *
	 * @param activities the activities
	 */
	@Override
	public void cacheResult(List<Activity> activities) {
		for (Activity activity : activities) {
			if (entityCache.getResult(
					ActivityImpl.class, activity.getPrimaryKey()) == null) {

				cacheResult(activity);
			}
		}
	}

	/**
	 * Clears the cache for all activities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ActivityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the activity.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Activity activity) {
		entityCache.removeResult(ActivityImpl.class, activity);
	}

	@Override
	public void clearCache(List<Activity> activities) {
		for (Activity activity : activities) {
			entityCache.removeResult(ActivityImpl.class, activity);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ActivityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new activity with the primary key. Does not add the activity to the database.
	 *
	 * @param activityId the primary key for the new activity
	 * @return the new activity
	 */
	@Override
	public Activity create(long activityId) {
		Activity activity = new ActivityImpl();

		activity.setNew(true);
		activity.setPrimaryKey(activityId);

		return activity;
	}

	/**
	 * Removes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity that was removed
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	@Override
	public Activity remove(long activityId) throws NoSuchActivityException {
		return remove((Serializable)activityId);
	}

	/**
	 * Removes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the activity
	 * @return the activity that was removed
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	@Override
	public Activity remove(Serializable primaryKey)
		throws NoSuchActivityException {

		Session session = null;

		try {
			session = openSession();

			Activity activity = (Activity)session.get(
				ActivityImpl.class, primaryKey);

			if (activity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActivityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(activity);
		}
		catch (NoSuchActivityException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Activity removeImpl(Activity activity) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(activity)) {
				activity = (Activity)session.get(
					ActivityImpl.class, activity.getPrimaryKeyObj());
			}

			if (activity != null) {
				session.delete(activity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (activity != null) {
			clearCache(activity);
		}

		return activity;
	}

	@Override
	public Activity updateImpl(Activity activity) {
		boolean isNew = activity.isNew();

		if (!(activity instanceof ActivityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(activity.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(activity);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in activity proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Activity implementation " +
					activity.getClass());
		}

		ActivityModelImpl activityModelImpl = (ActivityModelImpl)activity;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(activity);
			}
			else {
				activity = (Activity)session.merge(activity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ActivityImpl.class, activityModelImpl, false, true);

		if (isNew) {
			activity.setNew(false);
		}

		activity.resetOriginalValues();

		return activity;
	}

	/**
	 * Returns the activity with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity
	 * @return the activity
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	@Override
	public Activity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActivityException {

		Activity activity = fetchByPrimaryKey(primaryKey);

		if (activity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActivityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return activity;
	}

	/**
	 * Returns the activity with the primary key or throws a <code>NoSuchActivityException</code> if it could not be found.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity
	 * @throws NoSuchActivityException if a activity with the primary key could not be found
	 */
	@Override
	public Activity findByPrimaryKey(long activityId)
		throws NoSuchActivityException {

		return findByPrimaryKey((Serializable)activityId);
	}

	/**
	 * Returns the activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity, or <code>null</code> if a activity with the primary key could not be found
	 */
	@Override
	public Activity fetchByPrimaryKey(long activityId) {
		return fetchByPrimaryKey((Serializable)activityId);
	}

	/**
	 * Returns all the activities.
	 *
	 * @return the activities
	 */
	@Override
	public List<Activity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Activity> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Activity> findAll(
		int start, int end, OrderByComparator<Activity> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Activity> findAll(
		int start, int end, OrderByComparator<Activity> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Activity> list = null;

		if (useFinderCache) {
			list = (List<Activity>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ACTIVITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ACTIVITY;

				sql = sql.concat(ActivityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Activity>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the activities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Activity activity : findAll()) {
			remove(activity);
		}
	}

	/**
	 * Returns the number of activities.
	 *
	 * @return the number of activities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ACTIVITY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "activityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ACTIVITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ActivityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the activity persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ActivityModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Activity.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByActivity = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActivity",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"activityId"}, true);

		_finderPathWithoutPaginationFindByActivity = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActivity",
			new String[] {Long.class.getName()}, new String[] {"activityId"},
			true);

		_finderPathCountByActivity = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActivity",
			new String[] {Long.class.getName()}, new String[] {"activityId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ActivityImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = COCREATIONPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = COCREATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = COCREATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ACTIVITY =
		"SELECT activity FROM Activity activity";

	private static final String _SQL_SELECT_ACTIVITY_WHERE =
		"SELECT activity FROM Activity activity WHERE ";

	private static final String _SQL_COUNT_ACTIVITY =
		"SELECT COUNT(activity) FROM Activity activity";

	private static final String _SQL_COUNT_ACTIVITY_WHERE =
		"SELECT COUNT(activity) FROM Activity activity WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "activity.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Activity exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Activity exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ActivityPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class ActivityModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			ActivityModelImpl activityModelImpl = (ActivityModelImpl)baseModel;

			long columnBitmask = activityModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(activityModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						activityModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(activityModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ActivityModelImpl activityModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = activityModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = activityModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}