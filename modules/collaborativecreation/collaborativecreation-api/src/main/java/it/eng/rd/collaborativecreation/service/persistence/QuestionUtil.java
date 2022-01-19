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

package it.eng.rd.collaborativecreation.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.rd.collaborativecreation.model.Question;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the question service. This utility wraps <code>it.eng.rd.collaborativecreation.service.persistence.impl.QuestionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @see QuestionPersistence
 * @generated
 */
public class QuestionUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Question question) {
		getPersistence().clearCache(question);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Question> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Question> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Question> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Question> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Question> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Question update(Question question) {
		return getPersistence().update(question);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Question update(
		Question question, ServiceContext serviceContext) {

		return getPersistence().update(question, serviceContext);
	}

	/**
	 * Returns all the questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching questions
	 */
	public static List<Question> findByQuestion(long questionId) {
		return getPersistence().findByQuestion(questionId);
	}

	/**
	 * Returns a range of all the questions where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuestionModelImpl</code>.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of matching questions
	 */
	public static List<Question> findByQuestion(
		long questionId, int start, int end) {

		return getPersistence().findByQuestion(questionId, start, end);
	}

	/**
	 * Returns an ordered range of all the questions where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuestionModelImpl</code>.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching questions
	 */
	public static List<Question> findByQuestion(
		long questionId, int start, int end,
		OrderByComparator<Question> orderByComparator) {

		return getPersistence().findByQuestion(
			questionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the questions where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuestionModelImpl</code>.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching questions
	 */
	public static List<Question> findByQuestion(
		long questionId, int start, int end,
		OrderByComparator<Question> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByQuestion(
			questionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question
	 * @throws NoSuchQuestionException if a matching question could not be found
	 */
	public static Question findByQuestion_First(
			long questionId, OrderByComparator<Question> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchQuestionException {

		return getPersistence().findByQuestion_First(
			questionId, orderByComparator);
	}

	/**
	 * Returns the first question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question, or <code>null</code> if a matching question could not be found
	 */
	public static Question fetchByQuestion_First(
		long questionId, OrderByComparator<Question> orderByComparator) {

		return getPersistence().fetchByQuestion_First(
			questionId, orderByComparator);
	}

	/**
	 * Returns the last question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question
	 * @throws NoSuchQuestionException if a matching question could not be found
	 */
	public static Question findByQuestion_Last(
			long questionId, OrderByComparator<Question> orderByComparator)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchQuestionException {

		return getPersistence().findByQuestion_Last(
			questionId, orderByComparator);
	}

	/**
	 * Returns the last question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question, or <code>null</code> if a matching question could not be found
	 */
	public static Question fetchByQuestion_Last(
		long questionId, OrderByComparator<Question> orderByComparator) {

		return getPersistence().fetchByQuestion_Last(
			questionId, orderByComparator);
	}

	/**
	 * Removes all the questions where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 */
	public static void removeByQuestion(long questionId) {
		getPersistence().removeByQuestion(questionId);
	}

	/**
	 * Returns the number of questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching questions
	 */
	public static int countByQuestion(long questionId) {
		return getPersistence().countByQuestion(questionId);
	}

	/**
	 * Caches the question in the entity cache if it is enabled.
	 *
	 * @param question the question
	 */
	public static void cacheResult(Question question) {
		getPersistence().cacheResult(question);
	}

	/**
	 * Caches the questions in the entity cache if it is enabled.
	 *
	 * @param questions the questions
	 */
	public static void cacheResult(List<Question> questions) {
		getPersistence().cacheResult(questions);
	}

	/**
	 * Creates a new question with the primary key. Does not add the question to the database.
	 *
	 * @param questionId the primary key for the new question
	 * @return the new question
	 */
	public static Question create(long questionId) {
		return getPersistence().create(questionId);
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the question
	 * @return the question that was removed
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	public static Question remove(long questionId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchQuestionException {

		return getPersistence().remove(questionId);
	}

	public static Question updateImpl(Question question) {
		return getPersistence().updateImpl(question);
	}

	/**
	 * Returns the question with the primary key or throws a <code>NoSuchQuestionException</code> if it could not be found.
	 *
	 * @param questionId the primary key of the question
	 * @return the question
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	public static Question findByPrimaryKey(long questionId)
		throws it.eng.rd.collaborativecreation.exception.
			NoSuchQuestionException {

		return getPersistence().findByPrimaryKey(questionId);
	}

	/**
	 * Returns the question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionId the primary key of the question
	 * @return the question, or <code>null</code> if a question with the primary key could not be found
	 */
	public static Question fetchByPrimaryKey(long questionId) {
		return getPersistence().fetchByPrimaryKey(questionId);
	}

	/**
	 * Returns all the questions.
	 *
	 * @return the questions
	 */
	public static List<Question> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuestionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of questions
	 */
	public static List<Question> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuestionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of questions
	 */
	public static List<Question> findAll(
		int start, int end, OrderByComparator<Question> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuestionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of questions
	 */
	public static List<Question> findAll(
		int start, int end, OrderByComparator<Question> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the questions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of questions.
	 *
	 * @return the number of questions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuestionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<QuestionPersistence, QuestionPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(QuestionPersistence.class);

		ServiceTracker<QuestionPersistence, QuestionPersistence>
			serviceTracker =
				new ServiceTracker<QuestionPersistence, QuestionPersistence>(
					bundle.getBundleContext(), QuestionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}