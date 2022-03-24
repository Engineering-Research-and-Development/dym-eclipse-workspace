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
 * Provides a wrapper for {@link CocreatorLocalService}.
 *
 * @author ENGRD
 * @see CocreatorLocalService
 * @generated
 */
public class CocreatorLocalServiceWrapper
	implements CocreatorLocalService, ServiceWrapper<CocreatorLocalService> {

	public CocreatorLocalServiceWrapper(
		CocreatorLocalService cocreatorLocalService) {

		_cocreatorLocalService = cocreatorLocalService;
	}

	/**
	 * Adds the cocreator to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CocreatorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cocreator the cocreator
	 * @return the cocreator that was added
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreator addCocreator(
		it.eng.rd.collaborativecreation.model.Cocreator cocreator) {

		return _cocreatorLocalService.addCocreator(cocreator);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Cocreator addCocreator(
			long cocreationId, long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreatorLocalService.addCocreator(
			cocreationId, userId, serviceContext);
	}

	/**
	 * Creates a new cocreator with the primary key. Does not add the cocreator to the database.
	 *
	 * @param cocreatorId the primary key for the new cocreator
	 * @return the new cocreator
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreator createCocreator(
		long cocreatorId) {

		return _cocreatorLocalService.createCocreator(cocreatorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreatorLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the cocreator from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CocreatorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cocreator the cocreator
	 * @return the cocreator that was removed
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreator deleteCocreator(
		it.eng.rd.collaborativecreation.model.Cocreator cocreator) {

		return _cocreatorLocalService.deleteCocreator(cocreator);
	}

	/**
	 * Deletes the cocreator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CocreatorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cocreatorId the primary key of the cocreator
	 * @return the cocreator that was removed
	 * @throws PortalException if a cocreator with the primary key could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreator deleteCocreator(
			long cocreatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreatorLocalService.deleteCocreator(cocreatorId);
	}

	@Override
	public void deleteCocreatorByCocreatorId(long cocreatorId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		_cocreatorLocalService.deleteCocreatorByCocreatorId(cocreatorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreatorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cocreatorLocalService.dynamicQuery();
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

		return _cocreatorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.CocreatorModelImpl</code>.
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

		return _cocreatorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.CocreatorModelImpl</code>.
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

		return _cocreatorLocalService.dynamicQuery(
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

		return _cocreatorLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cocreatorLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Cocreator fetchCocreator(
		long cocreatorId) {

		return _cocreatorLocalService.fetchCocreator(cocreatorId);
	}

	/**
	 * Returns the cocreator matching the UUID and group.
	 *
	 * @param uuid the cocreator's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreator
		fetchCocreatorByUuidAndGroupId(String uuid, long groupId) {

		return _cocreatorLocalService.fetchCocreatorByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cocreatorLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cocreator with the primary key.
	 *
	 * @param cocreatorId the primary key of the cocreator
	 * @return the cocreator
	 * @throws PortalException if a cocreator with the primary key could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreator getCocreator(
			long cocreatorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreatorLocalService.getCocreator(cocreatorId);
	}

	/**
	 * Returns the cocreator matching the UUID and group.
	 *
	 * @param uuid the cocreator's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cocreator
	 * @throws PortalException if a matching cocreator could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreator
			getCocreatorByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreatorLocalService.getCocreatorByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the cocreators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.CocreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @return the range of cocreators
	 */
	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreator>
		getCocreators(int start, int end) {

		return _cocreatorLocalService.getCocreators(start, end);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreator>
			getCocreatorsByCocreationId(long cocreationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreatorLocalService.getCocreatorsByCocreationId(cocreationId);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreator>
		getCocreatorsByUserId(long userId) {

		return _cocreatorLocalService.getCocreatorsByUserId(userId);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreator>
			getCocreatorsByUserId(long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _cocreatorLocalService.getCocreatorsByUserId(userId, start, end);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreator>
		getCocreatorsByUserId(
			long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.collaborativecreation.model.Cocreator> obc) {

		return _cocreatorLocalService.getCocreatorsByUserId(
			userId, start, end, obc);
	}

	/**
	 * Returns all the cocreators matching the UUID and company.
	 *
	 * @param uuid the UUID of the cocreators
	 * @param companyId the primary key of the company
	 * @return the matching cocreators, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreator>
		getCocreatorsByUuidAndCompanyId(String uuid, long companyId) {

		return _cocreatorLocalService.getCocreatorsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of cocreators matching the UUID and company.
	 *
	 * @param uuid the UUID of the cocreators
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of cocreators
	 * @param end the upper bound of the range of cocreators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching cocreators, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreator>
		getCocreatorsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.collaborativecreation.model.Cocreator>
					orderByComparator) {

		return _cocreatorLocalService.getCocreatorsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of cocreators.
	 *
	 * @return the number of cocreators
	 */
	@Override
	public int getCocreatorsCount() {
		return _cocreatorLocalService.getCocreatorsCount();
	}

	@Override
	public int getCocreatorsCountByUserId(long userId) {
		return _cocreatorLocalService.getCocreatorsCountByUserId(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cocreatorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cocreatorLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreatorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cocreator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CocreatorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cocreator the cocreator
	 * @return the cocreator that was updated
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreator updateCocreator(
		it.eng.rd.collaborativecreation.model.Cocreator cocreator) {

		return _cocreatorLocalService.updateCocreator(cocreator);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Cocreator updateCocreator(
			long cocreationId, long cocreatorId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _cocreatorLocalService.updateCocreator(
			cocreationId, cocreatorId, serviceContext);
	}

	@Override
	public CocreatorLocalService getWrappedService() {
		return _cocreatorLocalService;
	}

	@Override
	public void setWrappedService(CocreatorLocalService cocreatorLocalService) {
		_cocreatorLocalService = cocreatorLocalService;
	}

	private CocreatorLocalService _cocreatorLocalService;

}