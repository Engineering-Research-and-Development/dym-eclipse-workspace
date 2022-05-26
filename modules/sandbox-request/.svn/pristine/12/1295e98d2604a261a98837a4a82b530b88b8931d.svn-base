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

package it.eng.rd.sandbox.request.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SandboxLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SandboxLocalService
 * @generated
 */
public class SandboxLocalServiceWrapper
	implements SandboxLocalService, ServiceWrapper<SandboxLocalService> {

	public SandboxLocalServiceWrapper(SandboxLocalService sandboxLocalService) {
		_sandboxLocalService = sandboxLocalService;
	}

	/**
	 * Adds the sandbox to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SandboxLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sandbox the sandbox
	 * @return the sandbox that was added
	 */
	@Override
	public it.eng.rd.sandbox.request.model.Sandbox addSandbox(
		it.eng.rd.sandbox.request.model.Sandbox sandbox) {

		return _sandboxLocalService.addSandbox(sandbox);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sandboxLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sandbox with the primary key. Does not add the sandbox to the database.
	 *
	 * @param sandboxId the primary key for the new sandbox
	 * @return the new sandbox
	 */
	@Override
	public it.eng.rd.sandbox.request.model.Sandbox createSandbox(
		long sandboxId) {

		return _sandboxLocalService.createSandbox(sandboxId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sandboxLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sandbox with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SandboxLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sandboxId the primary key of the sandbox
	 * @return the sandbox that was removed
	 * @throws PortalException if a sandbox with the primary key could not be found
	 */
	@Override
	public it.eng.rd.sandbox.request.model.Sandbox deleteSandbox(long sandboxId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sandboxLocalService.deleteSandbox(sandboxId);
	}

	/**
	 * Deletes the sandbox from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SandboxLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sandbox the sandbox
	 * @return the sandbox that was removed
	 */
	@Override
	public it.eng.rd.sandbox.request.model.Sandbox deleteSandbox(
		it.eng.rd.sandbox.request.model.Sandbox sandbox) {

		return _sandboxLocalService.deleteSandbox(sandbox);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sandboxLocalService.dynamicQuery();
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

		return _sandboxLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.sandbox.request.model.impl.SandboxModelImpl</code>.
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

		return _sandboxLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.sandbox.request.model.impl.SandboxModelImpl</code>.
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

		return _sandboxLocalService.dynamicQuery(
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

		return _sandboxLocalService.dynamicQueryCount(dynamicQuery);
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

		return _sandboxLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.rd.sandbox.request.model.Sandbox fetchSandbox(
		long sandboxId) {

		return _sandboxLocalService.fetchSandbox(sandboxId);
	}

	/**
	 * Returns the sandbox matching the UUID and group.
	 *
	 * @param uuid the sandbox's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sandbox, or <code>null</code> if a matching sandbox could not be found
	 */
	@Override
	public it.eng.rd.sandbox.request.model.Sandbox fetchSandboxByUuidAndGroupId(
		String uuid, long groupId) {

		return _sandboxLocalService.fetchSandboxByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sandboxLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _sandboxLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sandboxLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sandboxLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sandboxLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sandbox with the primary key.
	 *
	 * @param sandboxId the primary key of the sandbox
	 * @return the sandbox
	 * @throws PortalException if a sandbox with the primary key could not be found
	 */
	@Override
	public it.eng.rd.sandbox.request.model.Sandbox getSandbox(long sandboxId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sandboxLocalService.getSandbox(sandboxId);
	}

	/**
	 * Returns the sandbox matching the UUID and group.
	 *
	 * @param uuid the sandbox's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sandbox
	 * @throws PortalException if a matching sandbox could not be found
	 */
	@Override
	public it.eng.rd.sandbox.request.model.Sandbox getSandboxByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sandboxLocalService.getSandboxByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the sandboxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.sandbox.request.model.impl.SandboxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sandboxes
	 * @param end the upper bound of the range of sandboxes (not inclusive)
	 * @return the range of sandboxes
	 */
	@Override
	public java.util.List<it.eng.rd.sandbox.request.model.Sandbox> getSandboxes(
		int start, int end) {

		return _sandboxLocalService.getSandboxes(start, end);
	}

	/**
	 * Returns all the sandboxes matching the UUID and company.
	 *
	 * @param uuid the UUID of the sandboxes
	 * @param companyId the primary key of the company
	 * @return the matching sandboxes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.sandbox.request.model.Sandbox>
		getSandboxesByUuidAndCompanyId(String uuid, long companyId) {

		return _sandboxLocalService.getSandboxesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of sandboxes matching the UUID and company.
	 *
	 * @param uuid the UUID of the sandboxes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of sandboxes
	 * @param end the upper bound of the range of sandboxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching sandboxes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.sandbox.request.model.Sandbox>
		getSandboxesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.sandbox.request.model.Sandbox> orderByComparator) {

		return _sandboxLocalService.getSandboxesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sandboxes.
	 *
	 * @return the number of sandboxes
	 */
	@Override
	public int getSandboxesCount() {
		return _sandboxLocalService.getSandboxesCount();
	}

	/**
	 * Updates the sandbox in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SandboxLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sandbox the sandbox
	 * @return the sandbox that was updated
	 */
	@Override
	public it.eng.rd.sandbox.request.model.Sandbox updateSandbox(
		it.eng.rd.sandbox.request.model.Sandbox sandbox) {

		return _sandboxLocalService.updateSandbox(sandbox);
	}

	@Override
	public SandboxLocalService getWrappedService() {
		return _sandboxLocalService;
	}

	@Override
	public void setWrappedService(SandboxLocalService sandboxLocalService) {
		_sandboxLocalService = sandboxLocalService;
	}

	private SandboxLocalService _sandboxLocalService;

}