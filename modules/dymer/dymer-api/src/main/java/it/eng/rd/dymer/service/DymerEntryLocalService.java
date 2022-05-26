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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.dymer.model.DymerEntry;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DymerEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author ENGRD
 * @see DymerEntryLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DymerEntryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.rd.dymer.service.impl.DymerEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the dymer entry local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DymerEntryLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry addDymerEntry(DymerEntry dymerEntry);

	/**
	 * Old local services
	 */
	@Deprecated
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry addDymerEntry(
			long dymerId, long userId, String index, String type, String id,
			String url, String title, String extContent,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry addDymerEntry(
			long dymerId, String index, String type, String id, String url,
			String title, String extContent, ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	 * Creates a new dymer entry with the primary key. Does not add the dymer entry to the database.
	 *
	 * @param entryId the primary key for the new dymer entry
	 * @return the new dymer entry
	 */
	@Transactional(enabled = false)
	public DymerEntry createDymerEntry(long entryId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public DymerEntry deleteDymerEntry(DymerEntry dymerEntry)
		throws PortalException, SystemException;

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
	@Indexable(type = IndexableType.DELETE)
	public DymerEntry deleteDymerEntry(long entryId)
		throws PortalException, SystemException;

	@Indexable(type = IndexableType.DELETE)
	public DymerEntry deleteDymerEntry(long entryId, long userId)
		throws PortalException, SystemException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DymerEntry fetchDymerEntry(long entryId);

	/**
	 * Returns the dymer entry matching the UUID and group.
	 *
	 * @param uuid the dymer entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DymerEntry fetchDymerEntryByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DymerEntry> getDymerEntries(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DymerEntry> getDymerEntries(long groupId, long dymerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DymerEntry> getDymerEntries(
			long groupId, long dymerId, int start, int end)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DymerEntry> getDymerEntries(
		long groupId, long dymerId, int start, int end,
		OrderByComparator<DymerEntry> obc);

	/**
	 * Returns all the dymer entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the dymer entries
	 * @param companyId the primary key of the company
	 * @return the matching dymer entries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DymerEntry> getDymerEntriesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DymerEntry> getDymerEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator);

	/**
	 * Returns the number of dymer entries.
	 *
	 * @return the number of dymer entries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDymerEntriesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDymerEntriesCount(long groupId, long dymerId);

	/**
	 * Returns the dymer entry with the primary key.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry
	 * @throws PortalException if a dymer entry with the primary key could not be found
	 * @throws SystemException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DymerEntry getDymerEntry(long entryId)
		throws PortalException, SystemException;

	/**
	 * Returns the dymer entry matching the UUID and group.
	 *
	 * @param uuid the dymer entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dymer entry
	 * @throws PortalException if a matching dymer entry could not be found
	 * @throws SystemException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DymerEntry getDymerEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry updateDymerEntry(DymerEntry dymerEntry);

	@Deprecated
	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry updateDymerEntry(
			long dymerId, long userId, long entryId, String index, String type,
			String id, String url, String title, String extContent,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Indexable(type = IndexableType.REINDEX)
	public DymerEntry updateDymerEntry(
			long dymerId, long entryId, String index, String type, String id,
			String url, String title, String extContent,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

}