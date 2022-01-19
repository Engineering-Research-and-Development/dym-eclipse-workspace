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
 * Provides a wrapper for {@link HashtagLocalService}.
 *
 * @author ENGRD
 * @see HashtagLocalService
 * @generated
 */
public class HashtagLocalServiceWrapper
	implements HashtagLocalService, ServiceWrapper<HashtagLocalService> {

	public HashtagLocalServiceWrapper(HashtagLocalService hashtagLocalService) {
		_hashtagLocalService = hashtagLocalService;
	}

	/**
	 * Adds the hashtag to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HashtagLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hashtag the hashtag
	 * @return the hashtag that was added
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Hashtag addHashtag(
		it.eng.rd.collaborativecreation.model.Hashtag hashtag) {

		return _hashtagLocalService.addHashtag(hashtag);
	}

	/**
	 * Creates a new hashtag with the primary key. Does not add the hashtag to the database.
	 *
	 * @param hashtagId the primary key for the new hashtag
	 * @return the new hashtag
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Hashtag createHashtag(
		long hashtagId) {

		return _hashtagLocalService.createHashtag(hashtagId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hashtagLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the hashtag from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HashtagLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hashtag the hashtag
	 * @return the hashtag that was removed
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Hashtag deleteHashtag(
		it.eng.rd.collaborativecreation.model.Hashtag hashtag) {

		return _hashtagLocalService.deleteHashtag(hashtag);
	}

	/**
	 * Deletes the hashtag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HashtagLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hashtagId the primary key of the hashtag
	 * @return the hashtag that was removed
	 * @throws PortalException if a hashtag with the primary key could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Hashtag deleteHashtag(
			long hashtagId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hashtagLocalService.deleteHashtag(hashtagId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hashtagLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _hashtagLocalService.dynamicQuery();
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

		return _hashtagLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.HashtagModelImpl</code>.
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

		return _hashtagLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.HashtagModelImpl</code>.
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

		return _hashtagLocalService.dynamicQuery(
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

		return _hashtagLocalService.dynamicQueryCount(dynamicQuery);
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

		return _hashtagLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Hashtag fetchHashtag(
		long hashtagId) {

		return _hashtagLocalService.fetchHashtag(hashtagId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _hashtagLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the hashtag with the primary key.
	 *
	 * @param hashtagId the primary key of the hashtag
	 * @return the hashtag
	 * @throws PortalException if a hashtag with the primary key could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Hashtag getHashtag(
			long hashtagId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hashtagLocalService.getHashtag(hashtagId);
	}

	/**
	 * Returns a range of all the hashtags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @return the range of hashtags
	 */
	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Hashtag>
		getHashtags(int start, int end) {

		return _hashtagLocalService.getHashtags(start, end);
	}

	/**
	 * Returns the number of hashtags.
	 *
	 * @return the number of hashtags
	 */
	@Override
	public int getHashtagsCount() {
		return _hashtagLocalService.getHashtagsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _hashtagLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _hashtagLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hashtagLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the hashtag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HashtagLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hashtag the hashtag
	 * @return the hashtag that was updated
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Hashtag updateHashtag(
		it.eng.rd.collaborativecreation.model.Hashtag hashtag) {

		return _hashtagLocalService.updateHashtag(hashtag);
	}

	@Override
	public HashtagLocalService getWrappedService() {
		return _hashtagLocalService;
	}

	@Override
	public void setWrappedService(HashtagLocalService hashtagLocalService) {
		_hashtagLocalService = hashtagLocalService;
	}

	private HashtagLocalService _hashtagLocalService;

}