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

package it.eng.rd.collaborativecreation.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import it.eng.rd.collaborativecreation.exception.NoSuchQuestionException;
import it.eng.rd.collaborativecreation.model.Question;
import it.eng.rd.collaborativecreation.model.impl.QuestionImpl;
import it.eng.rd.collaborativecreation.model.impl.QuestionModelImpl;
import it.eng.rd.collaborativecreation.service.persistence.QuestionPersistence;
import it.eng.rd.collaborativecreation.service.persistence.impl.constants.COCREATIONPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @generated
 */
@Component(service = QuestionPersistence.class)
public class QuestionPersistenceImpl
	extends BasePersistenceImpl<Question> implements QuestionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuestionUtil</code> to access the question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuestionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByQuestion;
	private FinderPath _finderPathWithoutPaginationFindByQuestion;
	private FinderPath _finderPathCountByQuestion;

	/**
	 * Returns all the questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching questions
	 */
	@Override
	public List<Question> findByQuestion(long questionId) {
		return findByQuestion(
			questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Question> findByQuestion(long questionId, int start, int end) {
		return findByQuestion(questionId, start, end, null);
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
	@Override
	public List<Question> findByQuestion(
		long questionId, int start, int end,
		OrderByComparator<Question> orderByComparator) {

		return findByQuestion(questionId, start, end, orderByComparator, true);
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
	@Override
	public List<Question> findByQuestion(
		long questionId, int start, int end,
		OrderByComparator<Question> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByQuestion;
				finderArgs = new Object[] {questionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByQuestion;
			finderArgs = new Object[] {
				questionId, start, end, orderByComparator
			};
		}

		List<Question> list = null;

		if (useFinderCache) {
			list = (List<Question>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Question question : list) {
					if (questionId != question.getQuestionId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_QUESTION_WHERE);

			sb.append(_FINDER_COLUMN_QUESTION_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(QuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(questionId);

				list = (List<Question>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question
	 * @throws NoSuchQuestionException if a matching question could not be found
	 */
	@Override
	public Question findByQuestion_First(
			long questionId, OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException {

		Question question = fetchByQuestion_First(
			questionId, orderByComparator);

		if (question != null) {
			return question;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("questionId=");
		sb.append(questionId);

		sb.append("}");

		throw new NoSuchQuestionException(sb.toString());
	}

	/**
	 * Returns the first question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public Question fetchByQuestion_First(
		long questionId, OrderByComparator<Question> orderByComparator) {

		List<Question> list = findByQuestion(
			questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question
	 * @throws NoSuchQuestionException if a matching question could not be found
	 */
	@Override
	public Question findByQuestion_Last(
			long questionId, OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException {

		Question question = fetchByQuestion_Last(questionId, orderByComparator);

		if (question != null) {
			return question;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("questionId=");
		sb.append(questionId);

		sb.append("}");

		throw new NoSuchQuestionException(sb.toString());
	}

	/**
	 * Returns the last question in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public Question fetchByQuestion_Last(
		long questionId, OrderByComparator<Question> orderByComparator) {

		int count = countByQuestion(questionId);

		if (count == 0) {
			return null;
		}

		List<Question> list = findByQuestion(
			questionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the questions where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 */
	@Override
	public void removeByQuestion(long questionId) {
		for (Question question :
				findByQuestion(
					questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(question);
		}
	}

	/**
	 * Returns the number of questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching questions
	 */
	@Override
	public int countByQuestion(long questionId) {
		FinderPath finderPath = _finderPathCountByQuestion;

		Object[] finderArgs = new Object[] {questionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_QUESTION_WHERE);

			sb.append(_FINDER_COLUMN_QUESTION_QUESTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(questionId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_QUESTION_QUESTIONID_2 =
		"question.questionId = ?";

	public QuestionPersistenceImpl() {
		setModelClass(Question.class);

		setModelImplClass(QuestionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the question in the entity cache if it is enabled.
	 *
	 * @param question the question
	 */
	@Override
	public void cacheResult(Question question) {
		entityCache.putResult(
			QuestionImpl.class, question.getPrimaryKey(), question);
	}

	/**
	 * Caches the questions in the entity cache if it is enabled.
	 *
	 * @param questions the questions
	 */
	@Override
	public void cacheResult(List<Question> questions) {
		for (Question question : questions) {
			if (entityCache.getResult(
					QuestionImpl.class, question.getPrimaryKey()) == null) {

				cacheResult(question);
			}
		}
	}

	/**
	 * Clears the cache for all questions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QuestionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Question question) {
		entityCache.removeResult(QuestionImpl.class, question);
	}

	@Override
	public void clearCache(List<Question> questions) {
		for (Question question : questions) {
			entityCache.removeResult(QuestionImpl.class, question);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(QuestionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new question with the primary key. Does not add the question to the database.
	 *
	 * @param questionId the primary key for the new question
	 * @return the new question
	 */
	@Override
	public Question create(long questionId) {
		Question question = new QuestionImpl();

		question.setNew(true);
		question.setPrimaryKey(questionId);

		return question;
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the question
	 * @return the question that was removed
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	@Override
	public Question remove(long questionId) throws NoSuchQuestionException {
		return remove((Serializable)questionId);
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question that was removed
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	@Override
	public Question remove(Serializable primaryKey)
		throws NoSuchQuestionException {

		Session session = null;

		try {
			session = openSession();

			Question question = (Question)session.get(
				QuestionImpl.class, primaryKey);

			if (question == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(question);
		}
		catch (NoSuchQuestionException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Question removeImpl(Question question) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(question)) {
				question = (Question)session.get(
					QuestionImpl.class, question.getPrimaryKeyObj());
			}

			if (question != null) {
				session.delete(question);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (question != null) {
			clearCache(question);
		}

		return question;
	}

	@Override
	public Question updateImpl(Question question) {
		boolean isNew = question.isNew();

		if (!(question instanceof QuestionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(question.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(question);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in question proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Question implementation " +
					question.getClass());
		}

		QuestionModelImpl questionModelImpl = (QuestionModelImpl)question;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(question);
			}
			else {
				question = (Question)session.merge(question);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			QuestionImpl.class, questionModelImpl, false, true);

		if (isNew) {
			question.setNew(false);
		}

		question.resetOriginalValues();

		return question;
	}

	/**
	 * Returns the question with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	@Override
	public Question findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuestionException {

		Question question = fetchByPrimaryKey(primaryKey);

		if (question == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuestionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return question;
	}

	/**
	 * Returns the question with the primary key or throws a <code>NoSuchQuestionException</code> if it could not be found.
	 *
	 * @param questionId the primary key of the question
	 * @return the question
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	@Override
	public Question findByPrimaryKey(long questionId)
		throws NoSuchQuestionException {

		return findByPrimaryKey((Serializable)questionId);
	}

	/**
	 * Returns the question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionId the primary key of the question
	 * @return the question, or <code>null</code> if a question with the primary key could not be found
	 */
	@Override
	public Question fetchByPrimaryKey(long questionId) {
		return fetchByPrimaryKey((Serializable)questionId);
	}

	/**
	 * Returns all the questions.
	 *
	 * @return the questions
	 */
	@Override
	public List<Question> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Question> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Question> findAll(
		int start, int end, OrderByComparator<Question> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Question> findAll(
		int start, int end, OrderByComparator<Question> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Question> list = null;

		if (useFinderCache) {
			list = (List<Question>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUESTION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTION;

				sql = sql.concat(QuestionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Question>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the questions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Question question : findAll()) {
			remove(question);
		}
	}

	/**
	 * Returns the number of questions.
	 *
	 * @return the number of questions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_QUESTION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "questionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUESTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuestionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the question persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new QuestionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Question.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByQuestion = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuestion",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"questionId"}, true);

		_finderPathWithoutPaginationFindByQuestion = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuestion",
			new String[] {Long.class.getName()}, new String[] {"questionId"},
			true);

		_finderPathCountByQuestion = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestion",
			new String[] {Long.class.getName()}, new String[] {"questionId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(QuestionImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = COCREATIONPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = COCREATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = COCREATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_QUESTION =
		"SELECT question FROM Question question";

	private static final String _SQL_SELECT_QUESTION_WHERE =
		"SELECT question FROM Question question WHERE ";

	private static final String _SQL_COUNT_QUESTION =
		"SELECT COUNT(question) FROM Question question";

	private static final String _SQL_COUNT_QUESTION_WHERE =
		"SELECT COUNT(question) FROM Question question WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "question.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Question exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Question exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuestionPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class QuestionModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			QuestionModelImpl questionModelImpl = (QuestionModelImpl)baseModel;

			long columnBitmask = questionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(questionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						questionModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(questionModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QuestionModelImpl questionModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = questionModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = questionModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}