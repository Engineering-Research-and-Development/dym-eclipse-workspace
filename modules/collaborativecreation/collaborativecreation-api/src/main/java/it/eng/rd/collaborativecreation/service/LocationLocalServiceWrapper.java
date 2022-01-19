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

package it.eng.rd.collaborativecreation.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LocationLocalService}.
 *
 * @author ENGRD
 * @see LocationLocalService
 * @generated
 */
public class LocationLocalServiceWrapper
	implements LocationLocalService, ServiceWrapper<LocationLocalService> {

	public LocationLocalServiceWrapper(
		LocationLocalService locationLocalService) {

		_locationLocalService = locationLocalService;
	}

	/**
	 * Adds the location to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param location the location
	 * @return the location that was added
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Location addLocation(
		it.eng.rd.collaborativecreation.model.Location location) {

		return _locationLocalService.addLocation(location);
	}

	/**
	 * Creates a new location with the primary key. Does not add the location to the database.
	 *
	 * @param locatoinId the primary key for the new location
	 * @return the new location
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Location createLocation(
		long locatoinId) {

		return _locationLocalService.createLocation(locatoinId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _locationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the location from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param location the location
	 * @return the location that was removed
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Location deleteLocation(
		it.eng.rd.collaborativecreation.model.Location location) {

		return _locationLocalService.deleteLocation(location);
	}

	/**
	 * Deletes the location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param locatoinId the primary key of the location
	 * @return the location that was removed
	 * @throws PortalException if a location with the primary key could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Location deleteLocation(
			long locatoinId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _locationLocalService.deleteLocation(locatoinId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _locationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _locationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _locationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.LocationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _locationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.LocationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _locationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _locationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _locationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Location fetchLocation(
		long locatoinId) {

		return _locationLocalService.fetchLocation(locatoinId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _locationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _locationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the location with the primary key.
	 *
	 * @param locatoinId the primary key of the location
	 * @return the location
	 * @throws PortalException if a location with the primary key could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Location getLocation(
			long locatoinId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _locationLocalService.getLocation(locatoinId);
	}

	/**
	 * Returns a range of all the locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.LocationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of locations
	 * @param end the upper bound of the range of locations (not inclusive)
	 * @return the range of locations
	 */
	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Location>
		getLocations(int start, int end) {

		return _locationLocalService.getLocations(start, end);
	}

	/**
	 * Returns the number of locations.
	 *
	 * @return the number of locations
	 */
	@Override
	public int getLocationsCount() {
		return _locationLocalService.getLocationsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _locationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _locationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the location in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LocationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param location the location
	 * @return the location that was updated
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Location updateLocation(
		it.eng.rd.collaborativecreation.model.Location location) {

		return _locationLocalService.updateLocation(location);
	}

	@Override
	public LocationLocalService getWrappedService() {
		return _locationLocalService;
	}

	@Override
	public void setWrappedService(LocationLocalService locationLocalService) {
		_locationLocalService = locationLocalService;
	}

	private LocationLocalService _locationLocalService;

}