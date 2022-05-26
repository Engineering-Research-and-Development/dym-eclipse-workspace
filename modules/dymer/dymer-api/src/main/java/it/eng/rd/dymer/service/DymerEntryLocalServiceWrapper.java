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
 * Provides a wrapper for {@link DymerEntryLocalService}.
 *
 * @author ENGRD
 * @see DymerEntryLocalService
 * @generated
 */
public class DymerEntryLocalServiceWrapper
	implements DymerEntryLocalService, ServiceWrapper<DymerEntryLocalService> {

	public DymerEntryLocalServiceWrapper(
		DymerEntryLocalService dymerEntryLocalService) {

		_dymerEntryLocalService = dymerEntryLocalService;
	}

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
	@Override
	public it.eng.rd.dymer.model.DymerEntry addDymerEntry(
		it.eng.rd.dymer.model.DymerEntry dymerEntry) {

		return _dymerEntryLocalService.addDymerEntry(dymerEntry);
	}

	/**
	 * Old local services
	 */
	@Deprecated
	@Override
	public it.eng.rd.dymer.model.DymerEntry addDymerEntry(
			long dymerId, long userId, String index, String type, String id,
			String url, String title, String extContent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dymerEntryLocalService.addDymerEntry(
			dymerId, userId, index, type, id, url, title, extContent,
			serviceContext);
	}

	@Override
	public it.eng.rd.dymer.model.DymerEntry addDymerEntry(
			long dymerId, String index, String type, String id, String url,
			String title, String extContent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dymerEntryLocalService.addDymerEntry(
			dymerId, index, type, id, url, title, extContent, serviceContext);
	}

	/**
	 * Creates a new dymer entry with the primary key. Does not add the dymer entry to the database.
	 *
	 * @param entryId the primary key for the new dymer entry
	 * @return the new dymer entry
	 */
	@Override
	public it.eng.rd.dymer.model.DymerEntry createDymerEntry(long entryId) {
		return _dymerEntryLocalService.createDymerEntry(entryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dymerEntryLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public it.eng.rd.dymer.model.DymerEntry deleteDymerEntry(
			it.eng.rd.dymer.model.DymerEntry dymerEntry)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dymerEntryLocalService.deleteDymerEntry(dymerEntry);
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
	@Override
	public it.eng.rd.dymer.model.DymerEntry deleteDymerEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dymerEntryLocalService.deleteDymerEntry(entryId);
	}

	@Override
	public it.eng.rd.dymer.model.DymerEntry deleteDymerEntry(
			long entryId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dymerEntryLocalService.deleteDymerEntry(entryId, userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dymerEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dymerEntryLocalService.dynamicQuery();
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

		return _dymerEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dymerEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dymerEntryLocalService.dynamicQuery(
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

		return _dymerEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dymerEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.rd.dymer.model.DymerEntry fetchDymerEntry(long entryId) {
		return _dymerEntryLocalService.fetchDymerEntry(entryId);
	}

	/**
	 * Returns the dymer entry matching the UUID and group.
	 *
	 * @param uuid the dymer entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public it.eng.rd.dymer.model.DymerEntry fetchDymerEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return _dymerEntryLocalService.fetchDymerEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dymerEntryLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<it.eng.rd.dymer.model.DymerEntry> getDymerEntries(
		int start, int end) {

		return _dymerEntryLocalService.getDymerEntries(start, end);
	}

	@Override
	public java.util.List<it.eng.rd.dymer.model.DymerEntry> getDymerEntries(
		long groupId, long dymerId) {

		return _dymerEntryLocalService.getDymerEntries(groupId, dymerId);
	}

	@Override
	public java.util.List<it.eng.rd.dymer.model.DymerEntry> getDymerEntries(
			long groupId, long dymerId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dymerEntryLocalService.getDymerEntries(
			groupId, dymerId, start, end);
	}

	@Override
	public java.util.List<it.eng.rd.dymer.model.DymerEntry> getDymerEntries(
		long groupId, long dymerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<it.eng.rd.dymer.model.DymerEntry> obc) {

		return _dymerEntryLocalService.getDymerEntries(
			groupId, dymerId, start, end, obc);
	}

	/**
	 * Returns all the dymer entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dymer entries
	 * @param companyId the primary key of the company
	 * @return the matching dymer entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.dymer.model.DymerEntry>
		getDymerEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _dymerEntryLocalService.getDymerEntriesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<it.eng.rd.dymer.model.DymerEntry>
		getDymerEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.dymer.model.DymerEntry> orderByComparator) {

		return _dymerEntryLocalService.getDymerEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of dymer entries.
	 *
	 * @return the number of dymer entries
	 */
	@Override
	public int getDymerEntriesCount() {
		return _dymerEntryLocalService.getDymerEntriesCount();
	}

	@Override
	public int getDymerEntriesCount(long groupId, long dymerId) {
		return _dymerEntryLocalService.getDymerEntriesCount(groupId, dymerId);
	}

	/**
	 * Returns the dymer entry with the primary key.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry
	 * @throws PortalException if a dymer entry with the primary key could not be found
	 * @throws SystemException
	 */
	@Override
	public it.eng.rd.dymer.model.DymerEntry getDymerEntry(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dymerEntryLocalService.getDymerEntry(entryId);
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
	@Override
	public it.eng.rd.dymer.model.DymerEntry getDymerEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dymerEntryLocalService.getDymerEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dymerEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dymerEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dymerEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dymerEntryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public it.eng.rd.dymer.model.DymerEntry updateDymerEntry(
		it.eng.rd.dymer.model.DymerEntry dymerEntry) {

		return _dymerEntryLocalService.updateDymerEntry(dymerEntry);
	}

	@Deprecated
	@Override
	public it.eng.rd.dymer.model.DymerEntry updateDymerEntry(
			long dymerId, long userId, long entryId, String index, String type,
			String id, String url, String title, String extContent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dymerEntryLocalService.updateDymerEntry(
			dymerId, userId, entryId, index, type, id, url, title, extContent,
			serviceContext);
	}

	@Override
	public it.eng.rd.dymer.model.DymerEntry updateDymerEntry(
			long dymerId, long entryId, String index, String type, String id,
			String url, String title, String extContent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dymerEntryLocalService.updateDymerEntry(
			dymerId, entryId, index, type, id, url, title, extContent,
			serviceContext);
	}

	@Override
	public DymerEntryLocalService getWrappedService() {
		return _dymerEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DymerEntryLocalService dymerEntryLocalService) {

		_dymerEntryLocalService = dymerEntryLocalService;
	}

	private DymerEntryLocalService _dymerEntryLocalService;

}