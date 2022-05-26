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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.sandbox.request.model.Sandbox;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Sandbox. This utility wraps
 * <code>it.eng.rd.sandbox.request.service.impl.SandboxLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SandboxLocalService
 * @generated
 */
public class SandboxLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.rd.sandbox.request.service.impl.SandboxLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Sandbox addSandbox(Sandbox sandbox) {
		return getService().addSandbox(sandbox);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sandbox with the primary key. Does not add the sandbox to the database.
	 *
	 * @param sandboxId the primary key for the new sandbox
	 * @return the new sandbox
	 */
	public static Sandbox createSandbox(long sandboxId) {
		return getService().createSandbox(sandboxId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static Sandbox deleteSandbox(long sandboxId) throws PortalException {
		return getService().deleteSandbox(sandboxId);
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
	public static Sandbox deleteSandbox(Sandbox sandbox) {
		return getService().deleteSandbox(sandbox);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
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
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Sandbox fetchSandbox(long sandboxId) {
		return getService().fetchSandbox(sandboxId);
	}

	/**
	 * Returns the sandbox matching the UUID and group.
	 *
	 * @param uuid the sandbox's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sandbox, or <code>null</code> if a matching sandbox could not be found
	 */
	public static Sandbox fetchSandboxByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSandboxByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sandbox with the primary key.
	 *
	 * @param sandboxId the primary key of the sandbox
	 * @return the sandbox
	 * @throws PortalException if a sandbox with the primary key could not be found
	 */
	public static Sandbox getSandbox(long sandboxId) throws PortalException {
		return getService().getSandbox(sandboxId);
	}

	/**
	 * Returns the sandbox matching the UUID and group.
	 *
	 * @param uuid the sandbox's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sandbox
	 * @throws PortalException if a matching sandbox could not be found
	 */
	public static Sandbox getSandboxByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getSandboxByUuidAndGroupId(uuid, groupId);
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
	public static List<Sandbox> getSandboxes(int start, int end) {
		return getService().getSandboxes(start, end);
	}

	/**
	 * Returns all the sandboxes matching the UUID and company.
	 *
	 * @param uuid the UUID of the sandboxes
	 * @param companyId the primary key of the company
	 * @return the matching sandboxes, or an empty list if no matches were found
	 */
	public static List<Sandbox> getSandboxesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSandboxesByUuidAndCompanyId(uuid, companyId);
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
	public static List<Sandbox> getSandboxesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Sandbox> orderByComparator) {

		return getService().getSandboxesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sandboxes.
	 *
	 * @return the number of sandboxes
	 */
	public static int getSandboxesCount() {
		return getService().getSandboxesCount();
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
	public static Sandbox updateSandbox(Sandbox sandbox) {
		return getService().updateSandbox(sandbox);
	}

	public static SandboxLocalService getService() {
		return _service;
	}

	private static volatile SandboxLocalService _service;

}