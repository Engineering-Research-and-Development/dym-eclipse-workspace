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

package it.eng.rd.dymer.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Dymer. This utility wraps
 * <code>it.eng.rd.dymer.service.impl.DymerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ENGRD
 * @see DymerLocalService
 * @generated
 */
public class DymerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.rd.dymer.service.impl.DymerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dymer to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dymer the dymer
	 * @return the dymer that was added
	 */
	public static it.eng.rd.dymer.model.Dymer addDymer(
		it.eng.rd.dymer.model.Dymer dymer) {

		return getService().addDymer(dymer);
	}

	public static it.eng.rd.dymer.model.Dymer addDymer(
			long userId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addDymer(userId, name, serviceContext);
	}

	/**
	 * Creates a new dymer with the primary key. Does not add the dymer to the database.
	 *
	 * @param dymerId the primary key for the new dymer
	 * @return the new dymer
	 */
	public static it.eng.rd.dymer.model.Dymer createDymer(long dymerId) {
		return getService().createDymer(dymerId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dymer from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dymer the dymer
	 * @return the dymer that was removed
	 */
	public static it.eng.rd.dymer.model.Dymer deleteDymer(
		it.eng.rd.dymer.model.Dymer dymer) {

		return getService().deleteDymer(dymer);
	}

	/**
	 * Deletes the dymer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dymerId the primary key of the dymer
	 * @return the dymer that was removed
	 * @throws PortalException if a dymer with the primary key could not be found
	 */
	public static it.eng.rd.dymer.model.Dymer deleteDymer(long dymerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDymer(dymerId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.dymer.model.impl.DymerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.dymer.model.impl.DymerModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.eng.rd.dymer.model.Dymer fetchDymer(long dymerId) {
		return getService().fetchDymer(dymerId);
	}

	/**
	 * Returns the dymer matching the UUID and group.
	 *
	 * @param uuid the dymer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	public static it.eng.rd.dymer.model.Dymer fetchDymerByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDymerByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the dymer with the primary key.
	 *
	 * @param dymerId the primary key of the dymer
	 * @return the dymer
	 * @throws PortalException if a dymer with the primary key could not be found
	 */
	public static it.eng.rd.dymer.model.Dymer getDymer(long dymerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDymer(dymerId);
	}

	/**
	 * Returns the dymer matching the UUID and group.
	 *
	 * @param uuid the dymer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dymer
	 * @throws PortalException if a matching dymer could not be found
	 */
	public static it.eng.rd.dymer.model.Dymer getDymerByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDymerByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the dymers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.dymer.model.impl.DymerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @return the range of dymers
	 */
	public static java.util.List<it.eng.rd.dymer.model.Dymer> getDymers(
		int start, int end) {

		return getService().getDymers(start, end);
	}

	public static java.util.List<it.eng.rd.dymer.model.Dymer> getDymers(
		long groupId) {

		return getService().getDymers(groupId);
	}

	public static java.util.List<it.eng.rd.dymer.model.Dymer> getDymers(
		long groupId, int start, int end) {

		return getService().getDymers(groupId, start, end);
	}

	public static java.util.List<it.eng.rd.dymer.model.Dymer> getDymers(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<it.eng.rd.dymer.model.Dymer> obc) {

		return getService().getDymers(groupId, start, end, obc);
	}

	/**
	 * Returns all the dymers matching the UUID and company.
	 *
	 * @param uuid the UUID of the dymers
	 * @param companyId the primary key of the company
	 * @return the matching dymers, or an empty list if no matches were found
	 */
	public static java.util.List<it.eng.rd.dymer.model.Dymer>
		getDymersByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getDymersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of dymers matching the UUID and company.
	 *
	 * @param uuid the UUID of the dymers
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dymers
	 * @param end the upper bound of the range of dymers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dymers, or an empty list if no matches were found
	 */
	public static java.util.List<it.eng.rd.dymer.model.Dymer>
		getDymersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.dymer.model.Dymer> orderByComparator) {

		return getService().getDymersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dymers.
	 *
	 * @return the number of dymers
	 */
	public static int getDymersCount() {
		return getService().getDymersCount();
	}

	public static int getDymersCount(long groupId) {
		return getService().getDymersCount(groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dymer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dymer the dymer
	 * @return the dymer that was updated
	 */
	public static it.eng.rd.dymer.model.Dymer updateDymer(
		it.eng.rd.dymer.model.Dymer dymer) {

		return getService().updateDymer(dymer);
	}

	public static DymerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DymerLocalService, DymerLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DymerLocalService.class);

		ServiceTracker<DymerLocalService, DymerLocalService> serviceTracker =
			new ServiceTracker<DymerLocalService, DymerLocalService>(
				bundle.getBundleContext(), DymerLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}