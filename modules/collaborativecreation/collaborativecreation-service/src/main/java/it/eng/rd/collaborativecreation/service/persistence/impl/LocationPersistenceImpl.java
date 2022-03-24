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
import com.liferay.portal.kernel.util.StringUtil;

import it.eng.rd.collaborativecreation.exception.NoSuchLocationException;
import it.eng.rd.collaborativecreation.model.Location;
import it.eng.rd.collaborativecreation.model.impl.LocationImpl;
import it.eng.rd.collaborativecreation.model.impl.LocationModelImpl;
import it.eng.rd.collaborativecreation.service.persistence.LocationPersistence;
import it.eng.rd.collaborativecreation.service.persistence.impl.constants.COCREATIONPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
 * The persistence implementation for the location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @generated
 */
@Component(service = LocationPersistence.class)
public class LocationPersistenceImpl
	extends BasePersistenceImpl<Location> implements LocationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LocationUtil</code> to access the location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LocationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByChallenge;
	private FinderPath _finderPathCountByChallenge;

	/**
	 * Returns the location where challengeId = &#63; or throws a <code>NoSuchLocationException</code> if it could not be found.
	 *
	 * @param challengeId the challenge ID
	 * @return the matching location
	 * @throws NoSuchLocationException if a matching location could not be found
	 */
	@Override
	public Location findByChallenge(long challengeId)
		throws NoSuchLocationException {

		Location location = fetchByChallenge(challengeId);

		if (location == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("challengeId=");
			sb.append(challengeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLocationException(sb.toString());
		}

		return location;
	}

	/**
	 * Returns the location where challengeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param challengeId the challenge ID
	 * @return the matching location, or <code>null</code> if a matching location could not be found
	 */
	@Override
	public Location fetchByChallenge(long challengeId) {
		return fetchByChallenge(challengeId, true);
	}

	/**
	 * Returns the location where challengeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param challengeId the challenge ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching location, or <code>null</code> if a matching location could not be found
	 */
	@Override
	public Location fetchByChallenge(long challengeId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {challengeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByChallenge, finderArgs, this);
		}

		if (result instanceof Location) {
			Location location = (Location)result;

			if (challengeId != location.getChallengeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LOCATION_WHERE);

			sb.append(_FINDER_COLUMN_CHALLENGE_CHALLENGEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(challengeId);

				List<Location> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByChallenge, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {challengeId};
							}

							_log.warn(
								"LocationPersistenceImpl.fetchByChallenge(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Location location = list.get(0);

					result = location;

					cacheResult(location);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Location)result;
		}
	}

	/**
	 * Removes the location where challengeId = &#63; from the database.
	 *
	 * @param challengeId the challenge ID
	 * @return the location that was removed
	 */
	@Override
	public Location removeByChallenge(long challengeId)
		throws NoSuchLocationException {

		Location location = findByChallenge(challengeId);

		return remove(location);
	}

	/**
	 * Returns the number of locations where challengeId = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @return the number of matching locations
	 */
	@Override
	public int countByChallenge(long challengeId) {
		FinderPath finderPath = _finderPathCountByChallenge;

		Object[] finderArgs = new Object[] {challengeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LOCATION_WHERE);

			sb.append(_FINDER_COLUMN_CHALLENGE_CHALLENGEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(challengeId);

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

	private static final String _FINDER_COLUMN_CHALLENGE_CHALLENGEID_2 =
		"location.challengeId = ?";

	private FinderPath _finderPathFetchByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns the location where challengeId = &#63; and name = &#63; or throws a <code>NoSuchLocationException</code> if it could not be found.
	 *
	 * @param challengeId the challenge ID
	 * @param name the name
	 * @return the matching location
	 * @throws NoSuchLocationException if a matching location could not be found
	 */
	@Override
	public Location findByName(long challengeId, String name)
		throws NoSuchLocationException {

		Location location = fetchByName(challengeId, name);

		if (location == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("challengeId=");
			sb.append(challengeId);

			sb.append(", name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLocationException(sb.toString());
		}

		return location;
	}

	/**
	 * Returns the location where challengeId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param challengeId the challenge ID
	 * @param name the name
	 * @return the matching location, or <code>null</code> if a matching location could not be found
	 */
	@Override
	public Location fetchByName(long challengeId, String name) {
		return fetchByName(challengeId, name, true);
	}

	/**
	 * Returns the location where challengeId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param challengeId the challenge ID
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching location, or <code>null</code> if a matching location could not be found
	 */
	@Override
	public Location fetchByName(
		long challengeId, String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {challengeId, name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByName, finderArgs, this);
		}

		if (result instanceof Location) {
			Location location = (Location)result;

			if ((challengeId != location.getChallengeId()) ||
				!Objects.equals(name, location.getName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LOCATION_WHERE);

			sb.append(_FINDER_COLUMN_NAME_CHALLENGEID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(challengeId);

				if (bindName) {
					queryPos.add(name);
				}

				List<Location> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {challengeId, name};
							}

							_log.warn(
								"LocationPersistenceImpl.fetchByName(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Location location = list.get(0);

					result = location;

					cacheResult(location);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Location)result;
		}
	}

	/**
	 * Removes the location where challengeId = &#63; and name = &#63; from the database.
	 *
	 * @param challengeId the challenge ID
	 * @param name the name
	 * @return the location that was removed
	 */
	@Override
	public Location removeByName(long challengeId, String name)
		throws NoSuchLocationException {

		Location location = findByName(challengeId, name);

		return remove(location);
	}

	/**
	 * Returns the number of locations where challengeId = &#63; and name = &#63;.
	 *
	 * @param challengeId the challenge ID
	 * @param name the name
	 * @return the number of matching locations
	 */
	@Override
	public int countByName(long challengeId, String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {challengeId, name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LOCATION_WHERE);

			sb.append(_FINDER_COLUMN_NAME_CHALLENGEID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(challengeId);

				if (bindName) {
					queryPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAME_CHALLENGEID_2 =
		"location.challengeId = ? AND ";

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"location.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(location.name IS NULL OR location.name = '')";

	public LocationPersistenceImpl() {
		setModelClass(Location.class);

		setModelImplClass(LocationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the location in the entity cache if it is enabled.
	 *
	 * @param location the location
	 */
	@Override
	public void cacheResult(Location location) {
		entityCache.putResult(
			LocationImpl.class, location.getPrimaryKey(), location);

		finderCache.putResult(
			_finderPathFetchByChallenge,
			new Object[] {location.getChallengeId()}, location);

		finderCache.putResult(
			_finderPathFetchByName,
			new Object[] {location.getChallengeId(), location.getName()},
			location);
	}

	/**
	 * Caches the locations in the entity cache if it is enabled.
	 *
	 * @param locations the locations
	 */
	@Override
	public void cacheResult(List<Location> locations) {
		for (Location location : locations) {
			if (entityCache.getResult(
					LocationImpl.class, location.getPrimaryKey()) == null) {

				cacheResult(location);
			}
		}
	}

	/**
	 * Clears the cache for all locations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LocationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the location.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Location location) {
		entityCache.removeResult(LocationImpl.class, location);
	}

	@Override
	public void clearCache(List<Location> locations) {
		for (Location location : locations) {
			entityCache.removeResult(LocationImpl.class, location);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LocationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LocationModelImpl locationModelImpl) {

		Object[] args = new Object[] {locationModelImpl.getChallengeId()};

		finderCache.putResult(
			_finderPathCountByChallenge, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByChallenge, args, locationModelImpl, false);

		args = new Object[] {
			locationModelImpl.getChallengeId(), locationModelImpl.getName()
		};

		finderCache.putResult(
			_finderPathCountByName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByName, args, locationModelImpl, false);
	}

	/**
	 * Creates a new location with the primary key. Does not add the location to the database.
	 *
	 * @param locationId the primary key for the new location
	 * @return the new location
	 */
	@Override
	public Location create(long locationId) {
		Location location = new LocationImpl();

		location.setNew(true);
		location.setPrimaryKey(locationId);

		return location;
	}

	/**
	 * Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locationId the primary key of the location
	 * @return the location that was removed
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	@Override
	public Location remove(long locationId) throws NoSuchLocationException {
		return remove((Serializable)locationId);
	}

	/**
	 * Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the location
	 * @return the location that was removed
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	@Override
	public Location remove(Serializable primaryKey)
		throws NoSuchLocationException {

		Session session = null;

		try {
			session = openSession();

			Location location = (Location)session.get(
				LocationImpl.class, primaryKey);

			if (location == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLocationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(location);
		}
		catch (NoSuchLocationException noSuchEntityException) {
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
	protected Location removeImpl(Location location) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(location)) {
				location = (Location)session.get(
					LocationImpl.class, location.getPrimaryKeyObj());
			}

			if (location != null) {
				session.delete(location);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (location != null) {
			clearCache(location);
		}

		return location;
	}

	@Override
	public Location updateImpl(Location location) {
		boolean isNew = location.isNew();

		if (!(location instanceof LocationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(location.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(location);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in location proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Location implementation " +
					location.getClass());
		}

		LocationModelImpl locationModelImpl = (LocationModelImpl)location;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(location);
			}
			else {
				location = (Location)session.merge(location);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LocationImpl.class, locationModelImpl, false, true);

		cacheUniqueFindersCache(locationModelImpl);

		if (isNew) {
			location.setNew(false);
		}

		location.resetOriginalValues();

		return location;
	}

	/**
	 * Returns the location with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the location
	 * @return the location
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	@Override
	public Location findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLocationException {

		Location location = fetchByPrimaryKey(primaryKey);

		if (location == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLocationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return location;
	}

	/**
	 * Returns the location with the primary key or throws a <code>NoSuchLocationException</code> if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	@Override
	public Location findByPrimaryKey(long locationId)
		throws NoSuchLocationException {

		return findByPrimaryKey((Serializable)locationId);
	}

	/**
	 * Returns the location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locationId the primary key of the location
	 * @return the location, or <code>null</code> if a location with the primary key could not be found
	 */
	@Override
	public Location fetchByPrimaryKey(long locationId) {
		return fetchByPrimaryKey((Serializable)locationId);
	}

	/**
	 * Returns all the locations.
	 *
	 * @return the locations
	 */
	@Override
	public List<Location> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of locations
	 */
	@Override
	public List<Location> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of locations
	 */
	@Override
	public List<Location> findAll(
		int start, int end, OrderByComparator<Location> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of locations
	 */
	@Override
	public List<Location> findAll(
		int start, int end, OrderByComparator<Location> orderByComparator,
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

		List<Location> list = null;

		if (useFinderCache) {
			list = (List<Location>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LOCATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LOCATION;

				sql = sql.concat(LocationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Location>)QueryUtil.list(
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
	 * Removes all the locations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Location location : findAll()) {
			remove(location);
		}
	}

	/**
	 * Returns the number of locations.
	 *
	 * @return the number of locations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LOCATION);

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
		return "locationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOCATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LocationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the location persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new LocationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Location.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByChallenge = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByChallenge",
			new String[] {Long.class.getName()}, new String[] {"challengeId"},
			true);

		_finderPathCountByChallenge = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChallenge",
			new String[] {Long.class.getName()}, new String[] {"challengeId"},
			false);

		_finderPathFetchByName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"challengeId", "name"}, true);

		_finderPathCountByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"challengeId", "name"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LocationImpl.class.getName());

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

	private static final String _SQL_SELECT_LOCATION =
		"SELECT location FROM Location location";

	private static final String _SQL_SELECT_LOCATION_WHERE =
		"SELECT location FROM Location location WHERE ";

	private static final String _SQL_COUNT_LOCATION =
		"SELECT COUNT(location) FROM Location location";

	private static final String _SQL_COUNT_LOCATION_WHERE =
		"SELECT COUNT(location) FROM Location location WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "location.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Location exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Location exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LocationPersistenceImpl.class);

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

	private static class LocationModelArgumentsResolver
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

			LocationModelImpl locationModelImpl = (LocationModelImpl)baseModel;

			long columnBitmask = locationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(locationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						locationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(locationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			LocationModelImpl locationModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = locationModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = locationModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}