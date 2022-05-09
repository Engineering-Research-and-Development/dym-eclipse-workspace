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
 * Provides a wrapper for {@link ChallengeLocalService}.
 *
 * @author ENGRD
 * @see ChallengeLocalService
 * @generated
 */
public class ChallengeLocalServiceWrapper
	implements ChallengeLocalService, ServiceWrapper<ChallengeLocalService> {

	public ChallengeLocalServiceWrapper(
		ChallengeLocalService challengeLocalService) {

		_challengeLocalService = challengeLocalService;
	}

	/**
	 * Adds the challenge to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChallengeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param challenge the challenge
	 * @return the challenge that was added
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Challenge addChallenge(
		it.eng.rd.collaborativecreation.model.Challenge challenge) {

		return _challengeLocalService.addChallenge(challenge);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Challenge addChallenge(
			String title, String description, String desiredOutcome,
			java.util.Date startDate, java.util.Date endDate, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _challengeLocalService.addChallenge(
			title, description, desiredOutcome, startDate, endDate, active,
			serviceContext);
	}

	/**
	 * Creates a new challenge with the primary key. Does not add the challenge to the database.
	 *
	 * @param challengeId the primary key for the new challenge
	 * @return the new challenge
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Challenge createChallenge(
		long challengeId) {

		return _challengeLocalService.createChallenge(challengeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _challengeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the challenge from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChallengeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param challenge the challenge
	 * @return the challenge that was removed
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Challenge deleteChallenge(
		it.eng.rd.collaborativecreation.model.Challenge challenge) {

		return _challengeLocalService.deleteChallenge(challenge);
	}

	/**
	 * Deletes the challenge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChallengeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param challengeId the primary key of the challenge
	 * @return the challenge that was removed
	 * @throws PortalException if a challenge with the primary key could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Challenge deleteChallenge(
			long challengeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _challengeLocalService.deleteChallenge(challengeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _challengeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _challengeLocalService.dynamicQuery();
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

		return _challengeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.ChallengeModelImpl</code>.
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

		return _challengeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.ChallengeModelImpl</code>.
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

		return _challengeLocalService.dynamicQuery(
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

		return _challengeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _challengeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Challenge fetchChallenge(
		long challengeId) {

		return _challengeLocalService.fetchChallenge(challengeId);
	}

	/**
	 * Returns the challenge matching the UUID and group.
	 *
	 * @param uuid the challenge's UUID
	 * @param groupId the primary key of the group
	 * @return the matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Challenge
		fetchChallengeByUuidAndGroupId(String uuid, long groupId) {

		return _challengeLocalService.fetchChallengeByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _challengeLocalService.getActionableDynamicQuery();
	}

	@Override
	public double getAverageScore(long challengeId) {
		return _challengeLocalService.getAverageScore(challengeId);
	}

	/**
	 * Returns the challenge with the primary key.
	 *
	 * @param challengeId the primary key of the challenge
	 * @return the challenge
	 * @throws PortalException if a challenge with the primary key could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Challenge getChallenge(
			long challengeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _challengeLocalService.getChallenge(challengeId);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Challenge
		getChallengeByCocreationId(long cocreationId, long groupId) {

		return _challengeLocalService.getChallengeByCocreationId(
			cocreationId, groupId);
	}

	/**
	 * Returns the challenge matching the UUID and group.
	 *
	 * @param uuid the challenge's UUID
	 * @param groupId the primary key of the group
	 * @return the matching challenge
	 * @throws PortalException if a matching challenge could not be found
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Challenge
			getChallengeByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _challengeLocalService.getChallengeByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the challenges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.ChallengeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of challenges
	 */
	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Challenge>
		getChallenges(int start, int end) {

		return _challengeLocalService.getChallenges(start, end);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Challenge>
		getChallengesByActive(long groupId, boolean active) {

		return _challengeLocalService.getChallengesByActive(groupId, active);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Challenge>
		getChallengesByGroupId(long groupId) {

		return _challengeLocalService.getChallengesByGroupId(groupId);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Challenge>
			getChallengesBySearch(String keywords)
		throws ClassNotFoundException,
			   com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _challengeLocalService.getChallengesBySearch(keywords);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Challenge>
		getChallengesByUserId(long userId, long groupId) {

		return _challengeLocalService.getChallengesByUserId(userId, groupId);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Challenge>
			getChallengesByUserId(long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _challengeLocalService.getChallengesByUserId(
			userId, groupId, start, end);
	}

	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Challenge>
		getChallengesByUserId(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.collaborativecreation.model.Challenge> obc) {

		return _challengeLocalService.getChallengesByUserId(
			userId, groupId, start, end, obc);
	}

	/**
	 * Returns all the challenges matching the UUID and company.
	 *
	 * @param uuid the UUID of the challenges
	 * @param companyId the primary key of the company
	 * @return the matching challenges, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Challenge>
		getChallengesByUuidAndCompanyId(String uuid, long companyId) {

		return _challengeLocalService.getChallengesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of challenges matching the UUID and company.
	 *
	 * @param uuid the UUID of the challenges
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching challenges, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.eng.rd.collaborativecreation.model.Challenge>
		getChallengesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.rd.collaborativecreation.model.Challenge>
					orderByComparator) {

		return _challengeLocalService.getChallengesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of challenges.
	 *
	 * @return the number of challenges
	 */
	@Override
	public int getChallengesCount() {
		return _challengeLocalService.getChallengesCount();
	}

	@Override
	public int getChallengesCountByUserId(long userId, long groupId) {
		return _challengeLocalService.getChallengesCountByUserId(
			userId, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _challengeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _challengeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _challengeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _challengeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the challenge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChallengeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param challenge the challenge
	 * @return the challenge that was updated
	 */
	@Override
	public it.eng.rd.collaborativecreation.model.Challenge updateChallenge(
		it.eng.rd.collaborativecreation.model.Challenge challenge) {

		return _challengeLocalService.updateChallenge(challenge);
	}

	@Override
	public it.eng.rd.collaborativecreation.model.Challenge updateChallenge(
			long challengeId, String title, String description,
			String desiredOutcome, java.util.Date startDate,
			java.util.Date endDate, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _challengeLocalService.updateChallenge(
			challengeId, title, description, desiredOutcome, startDate, endDate,
			active, serviceContext);
	}

	@Override
	public ChallengeLocalService getWrappedService() {
		return _challengeLocalService;
	}

	@Override
	public void setWrappedService(ChallengeLocalService challengeLocalService) {
		_challengeLocalService = challengeLocalService;
	}

	private ChallengeLocalService _challengeLocalService;

}