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

import it.eng.rd.collaborativecreation.model.Challenge;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Challenge. This utility wraps
 * <code>it.eng.rd.collaborativecreation.service.impl.ChallengeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author ENGRD
 * @see ChallengeLocalService
 * @generated
 */
public class ChallengeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.rd.collaborativecreation.service.impl.ChallengeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Challenge addChallenge(Challenge challenge) {
		return getService().addChallenge(challenge);
	}

	public static Challenge addChallenge(
			String title, String description, String desiredOutcome,
			String additionalInformation, java.util.Date startDate,
			java.util.Date endDate, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addChallenge(
			title, description, desiredOutcome, additionalInformation,
			startDate, endDate, active, serviceContext);
	}

	/**
	 * Creates a new challenge with the primary key. Does not add the challenge to the database.
	 *
	 * @param challengeId the primary key for the new challenge
	 * @return the new challenge
	 */
	public static Challenge createChallenge(long challengeId) {
		return getService().createChallenge(challengeId);
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
	 * Deletes the challenge from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChallengeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param challenge the challenge
	 * @return the challenge that was removed
	 */
	public static Challenge deleteChallenge(Challenge challenge) {
		return getService().deleteChallenge(challenge);
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
	public static Challenge deleteChallenge(long challengeId)
		throws PortalException {

		return getService().deleteChallenge(challengeId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.ChallengeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.rd.collaborativecreation.model.impl.ChallengeModelImpl</code>.
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

	public static Challenge fetchChallenge(long challengeId) {
		return getService().fetchChallenge(challengeId);
	}

	/**
	 * Returns the challenge matching the UUID and group.
	 *
	 * @param uuid the challenge's UUID
	 * @param groupId the primary key of the group
	 * @return the matching challenge, or <code>null</code> if a matching challenge could not be found
	 */
	public static Challenge fetchChallengeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchChallengeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static double getAverageScore(long challengeId) {
		return getService().getAverageScore(challengeId);
	}

	/**
	 * Returns the challenge with the primary key.
	 *
	 * @param challengeId the primary key of the challenge
	 * @return the challenge
	 * @throws PortalException if a challenge with the primary key could not be found
	 */
	public static Challenge getChallenge(long challengeId)
		throws PortalException {

		return getService().getChallenge(challengeId);
	}

	public static Challenge getChallengeByCocreationId(
		long cocreationId, long groupId) {

		return getService().getChallengeByCocreationId(cocreationId, groupId);
	}

	/**
	 * Returns the challenge matching the UUID and group.
	 *
	 * @param uuid the challenge's UUID
	 * @param groupId the primary key of the group
	 * @return the matching challenge
	 * @throws PortalException if a matching challenge could not be found
	 */
	public static Challenge getChallengeByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getChallengeByUuidAndGroupId(uuid, groupId);
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
	public static List<Challenge> getChallenges(int start, int end) {
		return getService().getChallenges(start, end);
	}

	public static List<Challenge> getChallengesByActive(
		long groupId, boolean active) {

		return getService().getChallengesByActive(groupId, active);
	}

	public static List<Challenge> getChallengesByGroupId(long groupId) {
		return getService().getChallengesByGroupId(groupId);
	}

	public static List<Challenge> getChallengesBySearch(String keywords)
		throws ClassNotFoundException, PortalException, SystemException {

		return getService().getChallengesBySearch(keywords);
	}

	public static List<Challenge> getChallengesByUserId(
		long userId, long groupId) {

		return getService().getChallengesByUserId(userId, groupId);
	}

	public static List<Challenge> getChallengesByUserId(
			long userId, long groupId, int start, int end)
		throws SystemException {

		return getService().getChallengesByUserId(userId, groupId, start, end);
	}

	public static List<Challenge> getChallengesByUserId(
		long userId, long groupId, int start, int end,
		OrderByComparator<Challenge> obc) {

		return getService().getChallengesByUserId(
			userId, groupId, start, end, obc);
	}

	/**
	 * Returns all the challenges matching the UUID and company.
	 *
	 * @param uuid the UUID of the challenges
	 * @param companyId the primary key of the company
	 * @return the matching challenges, or an empty list if no matches were found
	 */
	public static List<Challenge> getChallengesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getChallengesByUuidAndCompanyId(uuid, companyId);
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
	public static List<Challenge> getChallengesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Challenge> orderByComparator) {

		return getService().getChallengesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of challenges.
	 *
	 * @return the number of challenges
	 */
	public static int getChallengesCount() {
		return getService().getChallengesCount();
	}

	public static int getChallengesCountByUserId(long userId, long groupId) {
		return getService().getChallengesCountByUserId(userId, groupId);
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
	 * Updates the challenge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChallengeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param challenge the challenge
	 * @return the challenge that was updated
	 */
	public static Challenge updateChallenge(Challenge challenge) {
		return getService().updateChallenge(challenge);
	}

	public static Challenge updateChallenge(
			long challengeId, String title, String description,
			String desiredOutcome, String additionalInformation,
			java.util.Date startDate, java.util.Date endDate, boolean active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateChallenge(
			challengeId, title, description, desiredOutcome,
			additionalInformation, startDate, endDate, active, serviceContext);
	}

	public static ChallengeLocalService getService() {
		return _service;
	}

	private static volatile ChallengeLocalService _service;

}