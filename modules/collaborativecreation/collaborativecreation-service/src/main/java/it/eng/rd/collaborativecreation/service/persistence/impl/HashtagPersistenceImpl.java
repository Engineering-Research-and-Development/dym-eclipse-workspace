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

import it.eng.rd.collaborativecreation.exception.NoSuchHashtagException;
import it.eng.rd.collaborativecreation.model.Hashtag;
import it.eng.rd.collaborativecreation.model.impl.HashtagImpl;
import it.eng.rd.collaborativecreation.model.impl.HashtagModelImpl;
import it.eng.rd.collaborativecreation.service.persistence.HashtagPersistence;
import it.eng.rd.collaborativecreation.service.persistence.impl.constants.COCREATIONPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
 * The persistence implementation for the hashtag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @generated
 */
@Component(service = HashtagPersistence.class)
public class HashtagPersistenceImpl
	extends BasePersistenceImpl<Hashtag> implements HashtagPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HashtagUtil</code> to access the hashtag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HashtagImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the hashtags where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching hashtags
	 */
	@Override
	public List<Hashtag> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hashtags where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @return the range of matching hashtags
	 */
	@Override
	public List<Hashtag> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hashtags where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hashtags
	 */
	@Override
	public List<Hashtag> findByName(
		String name, int start, int end,
		OrderByComparator<Hashtag> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hashtags where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hashtags
	 */
	@Override
	public List<Hashtag> findByName(
		String name, int start, int end,
		OrderByComparator<Hashtag> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<Hashtag> list = null;

		if (useFinderCache) {
			list = (List<Hashtag>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Hashtag hashtag : list) {
					if (!name.equals(hashtag.getName())) {
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

			sb.append(_SQL_SELECT_HASHTAG_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(HashtagModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<Hashtag>)QueryUtil.list(
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
	 * Returns the first hashtag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hashtag
	 * @throws NoSuchHashtagException if a matching hashtag could not be found
	 */
	@Override
	public Hashtag findByName_First(
			String name, OrderByComparator<Hashtag> orderByComparator)
		throws NoSuchHashtagException {

		Hashtag hashtag = fetchByName_First(name, orderByComparator);

		if (hashtag != null) {
			return hashtag;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchHashtagException(sb.toString());
	}

	/**
	 * Returns the first hashtag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hashtag, or <code>null</code> if a matching hashtag could not be found
	 */
	@Override
	public Hashtag fetchByName_First(
		String name, OrderByComparator<Hashtag> orderByComparator) {

		List<Hashtag> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last hashtag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hashtag
	 * @throws NoSuchHashtagException if a matching hashtag could not be found
	 */
	@Override
	public Hashtag findByName_Last(
			String name, OrderByComparator<Hashtag> orderByComparator)
		throws NoSuchHashtagException {

		Hashtag hashtag = fetchByName_Last(name, orderByComparator);

		if (hashtag != null) {
			return hashtag;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchHashtagException(sb.toString());
	}

	/**
	 * Returns the last hashtag in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hashtag, or <code>null</code> if a matching hashtag could not be found
	 */
	@Override
	public Hashtag fetchByName_Last(
		String name, OrderByComparator<Hashtag> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Hashtag> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hashtags before and after the current hashtag in the ordered set where name = &#63;.
	 *
	 * @param hashtagId the primary key of the current hashtag
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hashtag
	 * @throws NoSuchHashtagException if a hashtag with the primary key could not be found
	 */
	@Override
	public Hashtag[] findByName_PrevAndNext(
			long hashtagId, String name,
			OrderByComparator<Hashtag> orderByComparator)
		throws NoSuchHashtagException {

		name = Objects.toString(name, "");

		Hashtag hashtag = findByPrimaryKey(hashtagId);

		Session session = null;

		try {
			session = openSession();

			Hashtag[] array = new HashtagImpl[3];

			array[0] = getByName_PrevAndNext(
				session, hashtag, name, orderByComparator, true);

			array[1] = hashtag;

			array[2] = getByName_PrevAndNext(
				session, hashtag, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Hashtag getByName_PrevAndNext(
		Session session, Hashtag hashtag, String name,
		OrderByComparator<Hashtag> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HASHTAG_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(HashtagModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(hashtag)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Hashtag> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hashtags where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (Hashtag hashtag :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(hashtag);
		}
	}

	/**
	 * Returns the number of hashtags where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching hashtags
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HASHTAG_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAME_NAME_2 = "hashtag.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(hashtag.name IS NULL OR hashtag.name = '')";

	public HashtagPersistenceImpl() {
		setModelClass(Hashtag.class);

		setModelImplClass(HashtagImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the hashtag in the entity cache if it is enabled.
	 *
	 * @param hashtag the hashtag
	 */
	@Override
	public void cacheResult(Hashtag hashtag) {
		entityCache.putResult(
			HashtagImpl.class, hashtag.getPrimaryKey(), hashtag);
	}

	/**
	 * Caches the hashtags in the entity cache if it is enabled.
	 *
	 * @param hashtags the hashtags
	 */
	@Override
	public void cacheResult(List<Hashtag> hashtags) {
		for (Hashtag hashtag : hashtags) {
			if (entityCache.getResult(
					HashtagImpl.class, hashtag.getPrimaryKey()) == null) {

				cacheResult(hashtag);
			}
		}
	}

	/**
	 * Clears the cache for all hashtags.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HashtagImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the hashtag.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Hashtag hashtag) {
		entityCache.removeResult(HashtagImpl.class, hashtag);
	}

	@Override
	public void clearCache(List<Hashtag> hashtags) {
		for (Hashtag hashtag : hashtags) {
			entityCache.removeResult(HashtagImpl.class, hashtag);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HashtagImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new hashtag with the primary key. Does not add the hashtag to the database.
	 *
	 * @param hashtagId the primary key for the new hashtag
	 * @return the new hashtag
	 */
	@Override
	public Hashtag create(long hashtagId) {
		Hashtag hashtag = new HashtagImpl();

		hashtag.setNew(true);
		hashtag.setPrimaryKey(hashtagId);

		return hashtag;
	}

	/**
	 * Removes the hashtag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hashtagId the primary key of the hashtag
	 * @return the hashtag that was removed
	 * @throws NoSuchHashtagException if a hashtag with the primary key could not be found
	 */
	@Override
	public Hashtag remove(long hashtagId) throws NoSuchHashtagException {
		return remove((Serializable)hashtagId);
	}

	/**
	 * Removes the hashtag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hashtag
	 * @return the hashtag that was removed
	 * @throws NoSuchHashtagException if a hashtag with the primary key could not be found
	 */
	@Override
	public Hashtag remove(Serializable primaryKey)
		throws NoSuchHashtagException {

		Session session = null;

		try {
			session = openSession();

			Hashtag hashtag = (Hashtag)session.get(
				HashtagImpl.class, primaryKey);

			if (hashtag == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHashtagException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(hashtag);
		}
		catch (NoSuchHashtagException noSuchEntityException) {
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
	protected Hashtag removeImpl(Hashtag hashtag) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(hashtag)) {
				hashtag = (Hashtag)session.get(
					HashtagImpl.class, hashtag.getPrimaryKeyObj());
			}

			if (hashtag != null) {
				session.delete(hashtag);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (hashtag != null) {
			clearCache(hashtag);
		}

		return hashtag;
	}

	@Override
	public Hashtag updateImpl(Hashtag hashtag) {
		boolean isNew = hashtag.isNew();

		if (!(hashtag instanceof HashtagModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(hashtag.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(hashtag);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in hashtag proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Hashtag implementation " +
					hashtag.getClass());
		}

		HashtagModelImpl hashtagModelImpl = (HashtagModelImpl)hashtag;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(hashtag);
			}
			else {
				hashtag = (Hashtag)session.merge(hashtag);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(HashtagImpl.class, hashtagModelImpl, false, true);

		if (isNew) {
			hashtag.setNew(false);
		}

		hashtag.resetOriginalValues();

		return hashtag;
	}

	/**
	 * Returns the hashtag with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hashtag
	 * @return the hashtag
	 * @throws NoSuchHashtagException if a hashtag with the primary key could not be found
	 */
	@Override
	public Hashtag findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHashtagException {

		Hashtag hashtag = fetchByPrimaryKey(primaryKey);

		if (hashtag == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHashtagException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return hashtag;
	}

	/**
	 * Returns the hashtag with the primary key or throws a <code>NoSuchHashtagException</code> if it could not be found.
	 *
	 * @param hashtagId the primary key of the hashtag
	 * @return the hashtag
	 * @throws NoSuchHashtagException if a hashtag with the primary key could not be found
	 */
	@Override
	public Hashtag findByPrimaryKey(long hashtagId)
		throws NoSuchHashtagException {

		return findByPrimaryKey((Serializable)hashtagId);
	}

	/**
	 * Returns the hashtag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hashtagId the primary key of the hashtag
	 * @return the hashtag, or <code>null</code> if a hashtag with the primary key could not be found
	 */
	@Override
	public Hashtag fetchByPrimaryKey(long hashtagId) {
		return fetchByPrimaryKey((Serializable)hashtagId);
	}

	/**
	 * Returns all the hashtags.
	 *
	 * @return the hashtags
	 */
	@Override
	public List<Hashtag> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hashtags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @return the range of hashtags
	 */
	@Override
	public List<Hashtag> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hashtags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hashtags
	 */
	@Override
	public List<Hashtag> findAll(
		int start, int end, OrderByComparator<Hashtag> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hashtags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HashtagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hashtags
	 * @param end the upper bound of the range of hashtags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hashtags
	 */
	@Override
	public List<Hashtag> findAll(
		int start, int end, OrderByComparator<Hashtag> orderByComparator,
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

		List<Hashtag> list = null;

		if (useFinderCache) {
			list = (List<Hashtag>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HASHTAG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HASHTAG;

				sql = sql.concat(HashtagModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Hashtag>)QueryUtil.list(
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
	 * Removes all the hashtags from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Hashtag hashtag : findAll()) {
			remove(hashtag);
		}
	}

	/**
	 * Returns the number of hashtags.
	 *
	 * @return the number of hashtags
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HASHTAG);

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
		return "hashtagId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HASHTAG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HashtagModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the hashtag persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new HashtagModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Hashtag.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(HashtagImpl.class.getName());

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

	private static final String _SQL_SELECT_HASHTAG =
		"SELECT hashtag FROM Hashtag hashtag";

	private static final String _SQL_SELECT_HASHTAG_WHERE =
		"SELECT hashtag FROM Hashtag hashtag WHERE ";

	private static final String _SQL_COUNT_HASHTAG =
		"SELECT COUNT(hashtag) FROM Hashtag hashtag";

	private static final String _SQL_COUNT_HASHTAG_WHERE =
		"SELECT COUNT(hashtag) FROM Hashtag hashtag WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "hashtag.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Hashtag exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Hashtag exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HashtagPersistenceImpl.class);

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

	private static class HashtagModelArgumentsResolver
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

			HashtagModelImpl hashtagModelImpl = (HashtagModelImpl)baseModel;

			long columnBitmask = hashtagModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(hashtagModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						hashtagModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(hashtagModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			HashtagModelImpl hashtagModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = hashtagModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = hashtagModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}