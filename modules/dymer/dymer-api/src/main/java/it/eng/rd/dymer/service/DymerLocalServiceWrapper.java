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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DymerLocalService}.
 *
 * @author ENGRD
 * @see DymerLocalService
 * @generated
 */
public class DymerLocalServiceWrapper
	implements DymerLocalService, ServiceWrapper<DymerLocalService> {

	public DymerLocalServiceWrapper(DymerLocalService dymerLocalService) {
		_dymerLocalService = dymerLocalService;
	}

	/**
	 * Adds the dymer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DymerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dymer the dymer
	 * @return the dymer that was added
	 */
	@Override
	public it.eng.rd.dymer.model.Dymer addDymer(
		it.eng.rd.dymer.model.Dymer dymer) {

		return _dymerLocalService.addDymer(dymer);
	}

	@Override
	public it.eng.rd.dymer.model.Dymer addDymer(
			long userId, String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dymerLocalService.addDymer(userId, name, serviceContext);
	}

	/**
	 * Creates a new dymer with the primary key. Does not add the dymer to the database.
	 *
	 * @param dymerId the primary key for the new dymer
	 * @return the new dymer
	 */
	@Override
	public it.eng.rd.dymer.model.Dymer createDymer(long dymerId) {
		return _dymerLocalService.createDymer(dymerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dymerLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dymer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DymerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dymer the dymer
	 * @return the dymer that was removed
	 */
	@Override
	public it.eng.rd.dymer.model.Dymer deleteDymer(
		it.eng.rd.dymer.model.Dymer dymer) {

		return _dymerLocalService.deleteDymer(dymer);
	}

	/**
	 * Deletes the dymer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DymerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dymerId the primary key of the dymer
	 * @return the dymer that was removed
	 * @throws PortalException if a dymer with the primary key could not be found
	 */
	@Override
	public it.eng.rd.dymer.model.Dymer deleteDymer(long dymerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dymerLocalService.deleteDymer(dymerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dymerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dymerLocalService.dynamicQuery();
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

		return _dymerLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dymerLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dymerLocalService.dynamicQuery(
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

		return _dymerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dymerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.rd.dymer.model.Dymer fetchDymer(long dymerId) {
		return _dymerLocalService.fetchDymer(dymerId);
	}

	/**
	 * Returns the dymer matching the UUID and group.
	 *
	 * @param uuid the dymer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dymer, or <code>null</code> if a matching dymer could not be found
	 */
	@Override
	public it.eng.rd.dymer.model.Dymer fetchDymerByUuidAndGroupId(
		String uuid, long groupId) {

		return _dymerLocalService.fetchDymerByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dymerLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dymer with the primary key.
	 *
	 * @param dymerId the primary key of the dymer
	 * @return the dymer
	 * @throws PortalException if a dymer with the primary key could not be found
	 */
	@Override
	public it.eng.rd.dymer.model.Dymer getDymer(long dymerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dymerLocalService.getDymer(dymerId);
	}

	/**
	 * Returns the dymer matching the UUID and group.
	 *
	 * @param uuid the dymer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dymer
	 * @throws PortalException if a matching dymer could not be found
	 */
	@Override
	public it.eng.rd.dymer.model.Dymer getDymerByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dymerLocalService.getDymerByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<it.eng.rd.dymer.model.Dymer> getDymers(
		int start, int end) {

		return _dymerLocalService.getDymers(start, end);
	}

	@Override
	public java.util.List<it.eng.rd.dymer.model.Dymer> getDymers(long groupId) {
		return _dymerLocalService.getDymers(groupId);
	}

	@Override
	public java.util.List<it.eng.rd.dymer.model.Dymer> getDymers(
		long groupId, int start, int end) {

		return _dymerLocalService.getDymers(groupId, start, end);
	}

	@Override
	public java.util.List<it.eng.rd.dymer.model.Dymer> getDymers(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<it.eng.rd.dymer.model.Dymer> obc) {

		return _dymerLocalService.getDymers(groupId, start, end, obc);
	}

	/**
	 * Returns all the dymers matching the UUID and company.
	 *
	 * @param uuid the UUID of the dymers
	 * @param companyId the primary key of the company
	 * @return the matching dymers, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.dymer.model.Dymer>
		getDymersByUuidAndCompanyId(String uuid, long companyId) {

		return _dymerLocalService.getDymersByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<it.eng.rd.dymer.model.Dymer>
		getDymersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.dymer.model.Dymer> orderByComparator) {

		return _dymerLocalService.getDymersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dymers.
	 *
	 * @return the number of dymers
	 */
	@Override
	public int getDymersCount() {
		return _dymerLocalService.getDymersCount();
	}

	@Override
	public int getDymersCount(long groupId) {
		return _dymerLocalService.getDymersCount(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dymerLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dymerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dymerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dymerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dymer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DymerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dymer the dymer
	 * @return the dymer that was updated
	 */
	@Override
	public it.eng.rd.dymer.model.Dymer updateDymer(
		it.eng.rd.dymer.model.Dymer dymer) {

		return _dymerLocalService.updateDymer(dymer);
	}

	@Override
	public DymerLocalService getWrappedService() {
		return _dymerLocalService;
	}

	@Override
	public void setWrappedService(DymerLocalService dymerLocalService) {
		_dymerLocalService = dymerLocalService;
	}

	private DymerLocalService _dymerLocalService;

}