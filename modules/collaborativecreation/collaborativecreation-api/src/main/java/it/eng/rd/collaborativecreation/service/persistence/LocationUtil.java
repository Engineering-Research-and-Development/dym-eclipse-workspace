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

import it.eng.rd.collaborativecreation.model.Location;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the location service. This utility wraps <code>it.eng.rd.collaborativecreation.service.persistence.impl.LocationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see LocationPersistence
 * @generated
 */
public class LocationUtil {

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
	public static void clearCache(Location location) {
		getPersistence().clearCache(location);
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
	public static Map<Serializable, Location> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Location> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Location> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Location> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Location> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Location update(Location location) {
		return getPersistence().update(location);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Location update(
		Location location, ServiceContext serviceContext) {

		return getPersistence().update(location, serviceContext);
	}

	/**
	 * Returns all the locations where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching locations
	 */
	public static List<Location> findByName(String name) {
		return getPersistence().findByName(name);
	}

	/**
	 * Returns a range of all the locations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of matching locations
	 */
	public static List<Location> findByName(String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the locations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching locations
	 */
	public static List<Location> findByName(
		String name, int start, int end,
		OrderByComparator<Location> orderByComparator) {

		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the locations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LocationModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching locations
	 */
	public static List<Location> findByName(
		String name, int start, int end,
		OrderByComparator<Location> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first location in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location
	 * @throws NoSuchLocationException if a matching location could not be found
	 */
	public static Location findByName_First(
			String name, OrderByComparator<Location> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchLocationException {

		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first location in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching location, or <code>null</code> if a matching location could not be found
	 */
	public static Location fetchByName_First(
		String name, OrderByComparator<Location> orderByComparator) {

		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last location in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location
	 * @throws NoSuchLocationException if a matching location could not be found
	 */
	public static Location findByName_Last(
			String name, OrderByComparator<Location> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchLocationException {

		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last location in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching location, or <code>null</code> if a matching location could not be found
	 */
	public static Location fetchByName_Last(
		String name, OrderByComparator<Location> orderByComparator) {

		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the locations before and after the current location in the ordered set where name = &#63;.
	 *
	 * @param locatoinId the primary key of the current location
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next location
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	public static Location[] findByName_PrevAndNext(
			long locatoinId, String name,
			OrderByComparator<Location> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchLocationException {

		return getPersistence().findByName_PrevAndNext(
			locatoinId, name, orderByComparator);
	}

	/**
	 * Removes all the locations where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByName(String name) {
		getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of locations where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching locations
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the location in the entity cache if it is enabled.
	 *
	 * @param location the location
	 */
	public static void cacheResult(Location location) {
		getPersistence().cacheResult(location);
	}

	/**
	 * Caches the locations in the entity cache if it is enabled.
	 *
	 * @param locations the locations
	 */
	public static void cacheResult(List<Location> locations) {
		getPersistence().cacheResult(locations);
	}

	/**
	 * Creates a new location with the primary key. Does not add the location to the database.
	 *
	 * @param locatoinId the primary key for the new location
	 * @return the new location
	 */
	public static Location create(long locatoinId) {
		return getPersistence().create(locatoinId);
	}

	/**
	 * Removes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param locatoinId the primary key of the location
	 * @return the location that was removed
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	public static Location remove(long locatoinId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchLocationException {

		return getPersistence().remove(locatoinId);
	}

	public static Location updateImpl(Location location) {
		return getPersistence().updateImpl(location);
	}

	/**
	 * Returns the location with the primary key or throws a <code>NoSuchLocationException</code> if it could not be found.
	 *
	 * @param locatoinId the primary key of the location
	 * @return the location
	 * @throws NoSuchLocationException if a location with the primary key could not be found
	 */
	public static Location findByPrimaryKey(long locatoinId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchLocationException {

		return getPersistence().findByPrimaryKey(locatoinId);
	}

	/**
	 * Returns the location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param locatoinId the primary key of the location
	 * @return the location, or <code>null</code> if a location with the primary key could not be found
	 */
	public static Location fetchByPrimaryKey(long locatoinId) {
		return getPersistence().fetchByPrimaryKey(locatoinId);
	}

	/**
	 * Returns all the locations.
	 *
	 * @return the locations
	 */
	public static List<Location> findAll() {
		return getPersistence().findAll();
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
	public static List<Location> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Location> findAll(
		int start, int end, OrderByComparator<Location> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Location> findAll(
		int start, int end, OrderByComparator<Location> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the locations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of locations.
	 *
	 * @return the number of locations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LocationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LocationPersistence, LocationPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LocationPersistence.class);

		ServiceTracker<LocationPersistence, LocationPersistence>
			serviceTracker =
				new ServiceTracker<LocationPersistence, LocationPersistence>(
					bundle.getBundleContext(), LocationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}