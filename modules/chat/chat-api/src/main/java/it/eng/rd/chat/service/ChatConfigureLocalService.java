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

package it.eng.rd.chat.service;

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
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.chat.model.ChatConfigure;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ChatConfigure. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ChatConfigureLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ChatConfigureLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.rd.chat.service.impl.ChatConfigureLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the chat configure local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ChatConfigureLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the chat configure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatConfigureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatConfigure the chat configure
	 * @return the chat configure that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ChatConfigure addChatConfigure(ChatConfigure chatConfigure);

	/**
	 * Creates a new chat configure with the primary key. Does not add the chat configure to the database.
	 *
	 * @param id the primary key for the new chat configure
	 * @return the new chat configure
	 */
	@Transactional(enabled = false)
	public ChatConfigure createChatConfigure(long id);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the chat configure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatConfigureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatConfigure the chat configure
	 * @return the chat configure that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ChatConfigure deleteChatConfigure(ChatConfigure chatConfigure);

	/**
	 * Deletes the chat configure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatConfigureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the chat configure
	 * @return the chat configure that was removed
	 * @throws PortalException if a chat configure with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ChatConfigure deleteChatConfigure(long id) throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatConfigureModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatConfigureModelImpl</code>.
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
	public ChatConfigure fetchChatConfigure(long id);

	/**
	 * Returns the chat configure matching the UUID and group.
	 *
	 * @param uuid the chat configure's UUID
	 * @param groupId the primary key of the group
	 * @return the matching chat configure, or <code>null</code> if a matching chat configure could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ChatConfigure fetchChatConfigureByUuidAndGroupId(
		String uuid, long groupId);

	public List<ChatConfigure> FindConfigureByGroupId(long groupId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the chat configure with the primary key.
	 *
	 * @param id the primary key of the chat configure
	 * @return the chat configure
	 * @throws PortalException if a chat configure with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ChatConfigure getChatConfigure(long id) throws PortalException;

	/**
	 * Returns the chat configure matching the UUID and group.
	 *
	 * @param uuid the chat configure's UUID
	 * @param groupId the primary key of the group
	 * @return the matching chat configure
	 * @throws PortalException if a matching chat configure could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ChatConfigure getChatConfigureByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the chat configures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.chat.model.impl.ChatConfigureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @return the range of chat configures
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ChatConfigure> getChatConfigures(int start, int end);

	/**
	 * Returns all the chat configures matching the UUID and company.
	 *
	 * @param uuid the UUID of the chat configures
	 * @param companyId the primary key of the company
	 * @return the matching chat configures, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ChatConfigure> getChatConfiguresByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of chat configures matching the UUID and company.
	 *
	 * @param uuid the UUID of the chat configures
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of chat configures
	 * @param end the upper bound of the range of chat configures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching chat configures, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ChatConfigure> getChatConfiguresByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChatConfigure> orderByComparator);

	/**
	 * Returns the number of chat configures.
	 *
	 * @return the number of chat configures
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getChatConfiguresCount();

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
	 * Updates the chat configure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChatConfigureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chatConfigure the chat configure
	 * @return the chat configure that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ChatConfigure updateChatConfigure(ChatConfigure chatConfigure);

}