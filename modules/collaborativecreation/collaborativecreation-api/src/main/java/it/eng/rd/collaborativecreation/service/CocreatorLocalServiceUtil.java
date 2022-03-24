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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.collaborativecreation.model.Cocreator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Cocreator. This utility wraps
 * <code>it.eng.rd.collaborativecreation.service.impl.CocreatorLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ENGRD
 * @see CocreatorLocalService
 * @generated
 */
public class CocreatorLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.rd.collaborativecreation.service.impl.CocreatorLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Cocreator addCocreator(Cocreator cocreator) {
		return getService().addCocreator(cocreator);
	}

	public static Cocreator addCocreator(
			long cocreationId, long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addCocreator(cocreationId, userId, serviceContext);
	}

	/**
	 * Creates a new cocreator with the primary key. Does not add the cocreator to the database.
	 *
	 * @param cocreatorId the primary key for the new cocreator
	 * @return the new cocreator
	 */
	public static Cocreator createCocreator(long cocreatorId) {
		return getService().createCocreator(cocreatorId);
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
	 * Deletes the cocreator from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CocreatorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cocreator the cocreator
	 * @return the cocreator that was removed
	 */
	public static Cocreator deleteCocreator(Cocreator cocreator) {
		return getService().deleteCocreator(cocreator);
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
	public static Cocreator deleteCocreator(long cocreatorId)
		throws PortalException {

		return getService().deleteCocreator(cocreatorId);
	}

	public static void deleteCocreatorByCocreatorId(long cocreatorId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchCocreatorException {

		getService().deleteCocreatorByCocreatorId(cocreatorId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.CocreatorModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.CocreatorModelImpl</code>.
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

	public static Cocreator fetchCocreator(long cocreatorId) {
		return getService().fetchCocreator(cocreatorId);
	}

	/**
	 * Returns the cocreator matching the UUID and group.
	 *
	 * @param uuid the cocreator's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cocreator, or <code>null</code> if a matching cocreator could not be found
	 */
	public static Cocreator fetchCocreatorByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCocreatorByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cocreator with the primary key.
	 *
	 * @param cocreatorId the primary key of the cocreator
	 * @return the cocreator
	 * @throws PortalException if a cocreator with the primary key could not be found
	 */
	public static Cocreator getCocreator(long cocreatorId)
		throws PortalException {

		return getService().getCocreator(cocreatorId);
	}

	/**
	 * Returns the cocreator matching the UUID and group.
	 *
	 * @param uuid the cocreator's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cocreator
	 * @throws PortalException if a matching cocreator could not be found
	 */
	public static Cocreator getCocreatorByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCocreatorByUuidAndGroupId(uuid, groupId);
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
	public static List<Cocreator> getCocreators(int start, int end) {
		return getService().getCocreators(start, end);
	}

	public static List<Cocreator> getCocreatorsByCocreationId(long cocreationId)
		throws PortalException {

		return getService().getCocreatorsByCocreationId(cocreationId);
	}

	public static List<Cocreator> getCocreatorsByUserId(long userId) {
		return getService().getCocreatorsByUserId(userId);
	}

	public static List<Cocreator> getCocreatorsByUserId(
			long userId, int start, int end)
		throws SystemException {

		return getService().getCocreatorsByUserId(userId, start, end);
	}

	public static List<Cocreator> getCocreatorsByUserId(
		long userId, int start, int end, OrderByComparator<Cocreator> obc) {

		return getService().getCocreatorsByUserId(userId, start, end, obc);
	}

	/**
	 * Returns all the cocreators matching the UUID and company.
	 *
	 * @param uuid the UUID of the cocreators
	 * @param companyId the primary key of the company
	 * @return the matching cocreators, or an empty list if no matches were found
	 */
	public static List<Cocreator> getCocreatorsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCocreatorsByUuidAndCompanyId(uuid, companyId);
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
	public static List<Cocreator> getCocreatorsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cocreator> orderByComparator) {

		return getService().getCocreatorsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of cocreators.
	 *
	 * @return the number of cocreators
	 */
	public static int getCocreatorsCount() {
		return getService().getCocreatorsCount();
	}

	public static int getCocreatorsCountByUserId(long userId) {
		return getService().getCocreatorsCountByUserId(userId);
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
	 * Updates the cocreator in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CocreatorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cocreator the cocreator
	 * @return the cocreator that was updated
	 */
	public static Cocreator updateCocreator(Cocreator cocreator) {
		return getService().updateCocreator(cocreator);
	}

	public static Cocreator updateCocreator(
			long cocreationId, long cocreatorId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateCocreator(
			cocreationId, cocreatorId, serviceContext);
	}

	public static CocreatorLocalService getService() {
		return _service;
	}

	private static volatile CocreatorLocalService _service;

}