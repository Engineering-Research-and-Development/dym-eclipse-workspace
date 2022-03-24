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
 * Provides a wrapper for {@link CocreationLocalService}.
 *
 * @author ENGRD
 * @see CocreationLocalService
 * @generated
 */
public class CocreationLocalServiceWrapper
	implements CocreationLocalService, ServiceWrapper<CocreationLocalService> {

	public CocreationLocalServiceWrapper(
		CocreationLocalService cocreationLocalService) {

		_cocreationLocalService = cocreationLocalService;
	}

	/**
	 * Adds the cocreation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CocreationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cocreation the cocreation
	 * @return the cocreation that was added
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation addCocreation(
		it.eng.rd.collaborativecreation.model.Cocreation cocreation) {

		return _cocreationLocalService.addCocreation(cocreation);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation addCocreation(
			long challengeId, long cocreatorId, String req, String message,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreationLocalService.addCocreation(
			challengeId, cocreatorId, req, message, serviceContext);
	}

	/**
	 * Creates a new cocreation with the primary key. Does not add the cocreation to the database.
	 *
	 * @param cocreationId the primary key for the new cocreation
	 * @return the new cocreation
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation createCocreation(
		long cocreationId) {

		return _cocreationLocalService.createCocreation(cocreationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the cocreation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CocreationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cocreation the cocreation
	 * @return the cocreation that was removed
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation deleteCocreation(
		it.eng.rd.collaborativecreation.model.Cocreation cocreation) {

		return _cocreationLocalService.deleteCocreation(cocreation);
	}

	/**
	 * Deletes the cocreation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CocreationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cocreationId the primary key of the cocreation
	 * @return the cocreation that was removed
	 * @throws PortalException if a cocreation with the primary key could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation deleteCocreation(
			long cocreationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreationLocalService.deleteCocreation(cocreationId);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation deleteCocreation(
			long cocreationId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreationLocalService.deleteCocreation(cocreationId, userId);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation
			deleteCocreationByCocreationId(long cocreationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreationLocalService.deleteCocreationByCocreationId(
			cocreationId);
	}

	@Override
	public void deleteCocreationsByChallengeId(long challengeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_cocreationLocalService.deleteCocreationsByChallengeId(challengeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cocreationLocalService.dynamicQuery();
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

		return _cocreationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.CocreationModelImpl</code>.
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

		return _cocreationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.CocreationModelImpl</code>.
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

		return _cocreationLocalService.dynamicQuery(
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

		return _cocreationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cocreationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation fetchCocreation(
		long cocreationId) {

		return _cocreationLocalService.fetchCocreation(cocreationId);
	}

	/**
	 * Returns the cocreation matching the UUID and group.
	 *
	 * @param uuid the cocreation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cocreation, or <code>null</code> if a matching cocreation could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation
		fetchCocreationByUuidAndGroupId(String uuid, long groupId) {

		return _cocreationLocalService.fetchCocreationByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cocreationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cocreation with the primary key.
	 *
	 * @param cocreationId the primary key of the cocreation
	 * @return the cocreation
	 * @throws PortalException if a cocreation with the primary key could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation getCocreation(
			long cocreationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreationLocalService.getCocreation(cocreationId);
	}

	/**
	 * Returns the cocreation matching the UUID and group.
	 *
	 * @param uuid the cocreation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cocreation
	 * @throws PortalException if a matching cocreation could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation
			getCocreationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreationLocalService.getCocreationByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the cocreations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.CocreationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @return the range of cocreations
	 */
	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreation>
		getCocreations(int start, int end) {

		return _cocreationLocalService.getCocreations(start, end);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreation>
			getCocreationsByChallengeId(long challengeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreationLocalService.getCocreationsByChallengeId(challengeId);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreation>
		getCocreationsByCocreatorId(
			long userId, long groupId, boolean completed) {

		return _cocreationLocalService.getCocreationsByCocreatorId(
			userId, groupId, completed);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreation>
			getCocreationsByGroupId(long groupId, boolean completed)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _cocreationLocalService.getCocreationsByGroupId(
			groupId, completed);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreation>
			getCocreationsBySearchGroupId(
				String keywords, long groupId, boolean completed)
		throws ClassNotFoundException,
			   com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _cocreationLocalService.getCocreationsBySearchGroupId(
			keywords, groupId, completed);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreation>
			getCocreationsBySearchUserId(
				String keywords, long userId, long groupId, boolean completed)
		throws ClassNotFoundException,
			   com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _cocreationLocalService.getCocreationsBySearchUserId(
			keywords, userId, groupId, completed);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreation>
		getCocreationsByUserId(long userId, long groupId) {

		return _cocreationLocalService.getCocreationsByUserId(userId, groupId);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreation>
			getCocreationsByUserId(
				long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _cocreationLocalService.getCocreationsByUserId(
			userId, groupId, start, end);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreation>
		getCocreationsByUserId(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.collaborativecreation.model.Cocreation> obc) {

		return _cocreationLocalService.getCocreationsByUserId(
			userId, groupId, start, end, obc);
	}

	/**
	 * Returns all the cocreations matching the UUID and company.
	 *
	 * @param uuid the UUID of the cocreations
	 * @param companyId the primary key of the company
	 * @return the matching cocreations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreation>
		getCocreationsByUuidAndCompanyId(String uuid, long companyId) {

		return _cocreationLocalService.getCocreationsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of cocreations matching the UUID and company.
	 *
	 * @param uuid the UUID of the cocreations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of cocreations
	 * @param end the upper bound of the range of cocreations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching cocreations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Cocreation>
		getCocreationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.collaborativecreation.model.Cocreation>
					orderByComparator) {

		return _cocreationLocalService.getCocreationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of cocreations.
	 *
	 * @return the number of cocreations
	 */
	@Override
	public int getCocreationsCount() {
		return _cocreationLocalService.getCocreationsCount();
	}

	@Override
	public int getCocreationsCountByUserId(long userId, long groupId) {
		return _cocreationLocalService.getCocreationsCountByUserId(
			userId, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _cocreationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cocreationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cocreationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cocreationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cocreation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CocreationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cocreation the cocreation
	 * @return the cocreation that was updated
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation updateCocreation(
		it.eng.rd.collaborativecreation.model.Cocreation cocreation) {

		return _cocreationLocalService.updateCocreation(cocreation);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Cocreation updateCocreation(
			long cocreationId, String title, String description,
			boolean completed,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _cocreationLocalService.updateCocreation(
			cocreationId, title, description, completed, serviceContext);
	}

	@Override
	public CocreationLocalService getWrappedService() {
		return _cocreationLocalService;
	}

	@Override
	public void setWrappedService(
		CocreationLocalService cocreationLocalService) {

		_cocreationLocalService = cocreationLocalService;
	}

	private CocreationLocalService _cocreationLocalService;

}