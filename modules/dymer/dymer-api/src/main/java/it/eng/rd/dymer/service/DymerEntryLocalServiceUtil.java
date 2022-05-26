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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.dymer.model.DymerEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DymerEntry. This utility wraps
 * <code>it.eng.rd.dymer.service.impl.DymerEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ENGRD
 * @see DymerEntryLocalService
 * @generated
 */
public class DymerEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.rd.dymer.service.impl.DymerEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the dymer entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DymerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dymerEntry the dymer entry
	 * @return the dymer entry that was added
	 */
	public static DymerEntry addDymerEntry(DymerEntry dymerEntry) {
		return getService().addDymerEntry(dymerEntry);
	}

	/**
	 * Old local services
	 */
	@Deprecated
	public static DymerEntry addDymerEntry(
			long dymerId, long userId, String index, String type, String id,
			String url, String title, String extContent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().addDymerEntry(
			dymerId, userId, index, type, id, url, title, extContent,
			serviceContext);
	}

	public static DymerEntry addDymerEntry(
			long dymerId, String index, String type, String id, String url,
			String title, String extContent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().addDymerEntry(
			dymerId, index, type, id, url, title, extContent, serviceContext);
	}

	/**
	 * Creates a new dymer entry with the primary key. Does not add the dymer entry to the database.
	 *
	 * @param entryId the primary key for the new dymer entry
	 * @return the new dymer entry
	 */
	public static DymerEntry createDymerEntry(long entryId) {
		return getService().createDymerEntry(entryId);
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
	 * Deletes the dymer entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DymerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dymerEntry the dymer entry
	 * @return the dymer entry that was removed
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static DymerEntry deleteDymerEntry(DymerEntry dymerEntry)
		throws PortalException, SystemException {

		return getService().deleteDymerEntry(dymerEntry);
	}

	/**
	 * Deletes the dymer entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DymerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry that was removed
	 * @throws PortalException if a dymer entry with the primary key could not be found
	 * @throws SystemException
	 */
	public static DymerEntry deleteDymerEntry(long entryId)
		throws PortalException, SystemException {

		return getService().deleteDymerEntry(entryId);
	}

	public static DymerEntry deleteDymerEntry(long entryId, long userId)
		throws PortalException, SystemException {

		return getService().deleteDymerEntry(entryId, userId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.dymer.model.impl.DymerEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.dymer.model.impl.DymerEntryModelImpl</code>.
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

	public static DymerEntry fetchDymerEntry(long entryId) {
		return getService().fetchDymerEntry(entryId);
	}

	/**
	 * Returns the dymer entry matching the UUID and group.
	 *
	 * @param uuid the dymer entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	public static DymerEntry fetchDymerEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDymerEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the dymer entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.dymer.model.impl.DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of dymer entries
	 */
	public static List<DymerEntry> getDymerEntries(int start, int end) {
		return getService().getDymerEntries(start, end);
	}

	public static List<DymerEntry> getDymerEntries(long groupId, long dymerId) {
		return getService().getDymerEntries(groupId, dymerId);
	}

	public static List<DymerEntry> getDymerEntries(
			long groupId, long dymerId, int start, int end)
		throws PortalException, SystemException {

		return getService().getDymerEntries(groupId, dymerId, start, end);
	}

	public static List<DymerEntry> getDymerEntries(
		long groupId, long dymerId, int start, int end,
		OrderByComparator<DymerEntry> obc) {

		return getService().getDymerEntries(groupId, dymerId, start, end, obc);
	}

	/**
	 * Returns all the dymer entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dymer entries
	 * @param companyId the primary key of the company
	 * @return the matching dymer entries, or an empty list if no matches were found
	 */
	public static List<DymerEntry> getDymerEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDymerEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of dymer entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dymer entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dymer entries, or an empty list if no matches were found
	 */
	public static List<DymerEntry> getDymerEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return getService().getDymerEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dymer entries.
	 *
	 * @return the number of dymer entries
	 */
	public static int getDymerEntriesCount() {
		return getService().getDymerEntriesCount();
	}

	public static int getDymerEntriesCount(long groupId, long dymerId) {
		return getService().getDymerEntriesCount(groupId, dymerId);
	}

	/**
	 * Returns the dymer entry with the primary key.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry
	 * @throws PortalException if a dymer entry with the primary key could not be found
	 * @throws SystemException
	 */
	public static DymerEntry getDymerEntry(long entryId)
		throws PortalException, SystemException {

		return getService().getDymerEntry(entryId);
	}

	/**
	 * Returns the dymer entry matching the UUID and group.
	 *
	 * @param uuid the dymer entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dymer entry
	 * @throws PortalException if a matching dymer entry could not be found
	 * @throws SystemException
	 */
	public static DymerEntry getDymerEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException, SystemException {

		return getService().getDymerEntryByUuidAndGroupId(uuid, groupId);
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
	 * Updates the dymer entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DymerEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dymerEntry the dymer entry
	 * @return the dymer entry that was updated
	 */
	public static DymerEntry updateDymerEntry(DymerEntry dymerEntry) {
		return getService().updateDymerEntry(dymerEntry);
	}

	@Deprecated
	public static DymerEntry updateDymerEntry(
			long dymerId, long userId, long entryId, String index, String type,
			String id, String url, String title, String extContent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateDymerEntry(
			dymerId, userId, entryId, index, type, id, url, title, extContent,
			serviceContext);
	}

	public static DymerEntry updateDymerEntry(
			long dymerId, long entryId, String index, String type, String id,
			String url, String title, String extContent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateDymerEntry(
			dymerId, entryId, index, type, id, url, title, extContent,
			serviceContext);
	}

	public static DymerEntryLocalService getService() {
		return _service;
	}

	private static volatile DymerEntryLocalService _service;

}