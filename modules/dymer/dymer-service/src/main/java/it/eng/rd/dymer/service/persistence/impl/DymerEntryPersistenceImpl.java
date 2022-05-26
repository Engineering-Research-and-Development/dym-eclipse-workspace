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

package it.eng.rd.dymer.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.eng.rd.dymer.exception.NoSuchDymerEntryException;
import it.eng.rd.dymer.model.DymerEntry;
import it.eng.rd.dymer.model.impl.DymerEntryImpl;
import it.eng.rd.dymer.model.impl.DymerEntryModelImpl;
import it.eng.rd.dymer.service.persistence.DymerEntryPersistence;
import it.eng.rd.dymer.service.persistence.impl.constants.DYMPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the dymer entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ENGRD
 * @generated
 */
@Component(service = DymerEntryPersistence.class)
public class DymerEntryPersistenceImpl
	extends BasePersistenceImpl<DymerEntry> implements DymerEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DymerEntryUtil</code> to access the dymer entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DymerEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the dymer entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dymer entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dymer entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dymer entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<DymerEntry> list = null;

		if (useFinderCache) {
			list = (List<DymerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DymerEntry dymerEntry : list) {
					if (!uuid.equals(dymerEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<DymerEntry>)QueryUtil.list(
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
	 * Returns the first dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByUuid_First(
			String uuid, OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByUuid_First(uuid, orderByComparator);

		if (dymerEntry != null) {
			return dymerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDymerEntryException(sb.toString());
	}

	/**
	 * Returns the first dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByUuid_First(
		String uuid, OrderByComparator<DymerEntry> orderByComparator) {

		List<DymerEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByUuid_Last(
			String uuid, OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (dymerEntry != null) {
			return dymerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDymerEntryException(sb.toString());
	}

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DymerEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DymerEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where uuid = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry[] findByUuid_PrevAndNext(
			long entryId, String uuid,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		uuid = Objects.toString(uuid, "");

		DymerEntry dymerEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			DymerEntry[] array = new DymerEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, dymerEntry, uuid, orderByComparator, true);

			array[1] = dymerEntry;

			array[2] = getByUuid_PrevAndNext(
				session, dymerEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DymerEntry getByUuid_PrevAndNext(
		Session session, DymerEntry dymerEntry, String uuid,
		OrderByComparator<DymerEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
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
			sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dymerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DymerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dymer entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DymerEntry dymerEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dymerEntry);
		}
	}

	/**
	 * Returns the number of dymer entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dymer entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DYMERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"dymerEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(dymerEntry.uuid IS NULL OR dymerEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the dymer entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDymerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByUUID_G(uuid, groupId);

		if (dymerEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDymerEntryException(sb.toString());
		}

		return dymerEntry;
	}

	/**
	 * Returns the dymer entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dymer entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof DymerEntry) {
			DymerEntry dymerEntry = (DymerEntry)result;

			if (!Objects.equals(uuid, dymerEntry.getUuid()) ||
				(groupId != dymerEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<DymerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					DymerEntry dymerEntry = list.get(0);

					result = dymerEntry;

					cacheResult(dymerEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DymerEntry)result;
		}
	}

	/**
	 * Removes the dymer entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dymer entry that was removed
	 */
	@Override
	public DymerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = findByUUID_G(uuid, groupId);

		return remove(dymerEntry);
	}

	/**
	 * Returns the number of dymer entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dymer entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DYMERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"dymerEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(dymerEntry.uuid IS NULL OR dymerEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"dymerEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<DymerEntry> list = null;

		if (useFinderCache) {
			list = (List<DymerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DymerEntry dymerEntry : list) {
					if (!uuid.equals(dymerEntry.getUuid()) ||
						(companyId != dymerEntry.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<DymerEntry>)QueryUtil.list(
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
	 * Returns the first dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (dymerEntry != null) {
			return dymerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDymerEntryException(sb.toString());
	}

	/**
	 * Returns the first dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DymerEntry> orderByComparator) {

		List<DymerEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (dymerEntry != null) {
			return dymerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDymerEntryException(sb.toString());
	}

	/**
	 * Returns the last dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DymerEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DymerEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry[] findByUuid_C_PrevAndNext(
			long entryId, String uuid, long companyId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		uuid = Objects.toString(uuid, "");

		DymerEntry dymerEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			DymerEntry[] array = new DymerEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, dymerEntry, uuid, companyId, orderByComparator, true);

			array[1] = dymerEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, dymerEntry, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DymerEntry getByUuid_C_PrevAndNext(
		Session session, DymerEntry dymerEntry, String uuid, long companyId,
		OrderByComparator<DymerEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dymerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DymerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dymer entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DymerEntry dymerEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dymerEntry);
		}
	}

	/**
	 * Returns the number of dymer entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dymer entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DYMERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"dymerEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(dymerEntry.uuid IS NULL OR dymerEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"dymerEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByG_D;
	private FinderPath _finderPathWithoutPaginationFindByG_D;
	private FinderPath _finderPathCountByG_D;

	/**
	 * Returns all the dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByG_D(long groupId, long dymerId) {
		return findByG_D(
			groupId, dymerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByG_D(
		long groupId, long dymerId, int start, int end) {

		return findByG_D(groupId, dymerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByG_D(
		long groupId, long dymerId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return findByG_D(groupId, dymerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByG_D(
		long groupId, long dymerId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_D;
				finderArgs = new Object[] {groupId, dymerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_D;
			finderArgs = new Object[] {
				groupId, dymerId, start, end, orderByComparator
			};
		}

		List<DymerEntry> list = null;

		if (useFinderCache) {
			list = (List<DymerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DymerEntry dymerEntry : list) {
					if ((groupId != dymerEntry.getGroupId()) ||
						(dymerId != dymerEntry.getDymerId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_D_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_D_DYMERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(dymerId);

				list = (List<DymerEntry>)QueryUtil.list(
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
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByG_D_First(
			long groupId, long dymerId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByG_D_First(
			groupId, dymerId, orderByComparator);

		if (dymerEntry != null) {
			return dymerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", dymerId=");
		sb.append(dymerId);

		sb.append("}");

		throw new NoSuchDymerEntryException(sb.toString());
	}

	/**
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByG_D_First(
		long groupId, long dymerId,
		OrderByComparator<DymerEntry> orderByComparator) {

		List<DymerEntry> list = findByG_D(
			groupId, dymerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByG_D_Last(
			long groupId, long dymerId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByG_D_Last(
			groupId, dymerId, orderByComparator);

		if (dymerEntry != null) {
			return dymerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", dymerId=");
		sb.append(dymerId);

		sb.append("}");

		throw new NoSuchDymerEntryException(sb.toString());
	}

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByG_D_Last(
		long groupId, long dymerId,
		OrderByComparator<DymerEntry> orderByComparator) {

		int count = countByG_D(groupId, dymerId);

		if (count == 0) {
			return null;
		}

		List<DymerEntry> list = findByG_D(
			groupId, dymerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry[] findByG_D_PrevAndNext(
			long entryId, long groupId, long dymerId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			DymerEntry[] array = new DymerEntryImpl[3];

			array[0] = getByG_D_PrevAndNext(
				session, dymerEntry, groupId, dymerId, orderByComparator, true);

			array[1] = dymerEntry;

			array[2] = getByG_D_PrevAndNext(
				session, dymerEntry, groupId, dymerId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DymerEntry getByG_D_PrevAndNext(
		Session session, DymerEntry dymerEntry, long groupId, long dymerId,
		OrderByComparator<DymerEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_D_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_D_DYMERID_2);

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
			sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(dymerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dymerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DymerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dymer entries that the user has permission to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the matching dymer entries that the user has permission to view
	 */
	@Override
	public List<DymerEntry> filterFindByG_D(long groupId, long dymerId) {
		return filterFindByG_D(
			groupId, dymerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dymer entries that the user has permission to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries that the user has permission to view
	 */
	@Override
	public List<DymerEntry> filterFindByG_D(
		long groupId, long dymerId, int start, int end) {

		return filterFindByG_D(groupId, dymerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dymer entries that the user has permissions to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries that the user has permission to view
	 */
	@Override
	public List<DymerEntry> filterFindByG_D(
		long groupId, long dymerId, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_D(groupId, dymerId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_D_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_D_DYMERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DymerEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DymerEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DymerEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DymerEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(dymerId);

			return (List<DymerEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set of dymer entries that the user has permission to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry[] filterFindByG_D_PrevAndNext(
			long entryId, long groupId, long dymerId,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_D_PrevAndNext(
				entryId, groupId, dymerId, orderByComparator);
		}

		DymerEntry dymerEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			DymerEntry[] array = new DymerEntryImpl[3];

			array[0] = filterGetByG_D_PrevAndNext(
				session, dymerEntry, groupId, dymerId, orderByComparator, true);

			array[1] = dymerEntry;

			array[2] = filterGetByG_D_PrevAndNext(
				session, dymerEntry, groupId, dymerId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DymerEntry filterGetByG_D_PrevAndNext(
		Session session, DymerEntry dymerEntry, long groupId, long dymerId,
		OrderByComparator<DymerEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_D_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_D_DYMERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DymerEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DymerEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DymerEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DymerEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(dymerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dymerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DymerEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dymer entries where groupId = &#63; and dymerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 */
	@Override
	public void removeByG_D(long groupId, long dymerId) {
		for (DymerEntry dymerEntry :
				findByG_D(
					groupId, dymerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dymerEntry);
		}
	}

	/**
	 * Returns the number of dymer entries where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the number of matching dymer entries
	 */
	@Override
	public int countByG_D(long groupId, long dymerId) {
		FinderPath finderPath = _finderPathCountByG_D;

		Object[] finderArgs = new Object[] {groupId, dymerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DYMERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_D_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_D_DYMERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(dymerId);

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

	/**
	 * Returns the number of dymer entries that the user has permission to view where groupId = &#63; and dymerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param dymerId the dymer ID
	 * @return the number of matching dymer entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_D(long groupId, long dymerId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_D(groupId, dymerId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_DYMERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_D_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_D_DYMERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DymerEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(dymerId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_D_GROUPID_2 =
		"dymerEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_D_DYMERID_2 =
		"dymerEntry.dymerId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the dymer entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dymer entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dymer entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dymer entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<DymerEntry> list = null;

		if (useFinderCache) {
			list = (List<DymerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DymerEntry dymerEntry : list) {
					if (status != dymerEntry.getStatus()) {
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

			sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<DymerEntry>)QueryUtil.list(
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
	 * Returns the first dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByStatus_First(
			int status, OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByStatus_First(status, orderByComparator);

		if (dymerEntry != null) {
			return dymerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDymerEntryException(sb.toString());
	}

	/**
	 * Returns the first dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByStatus_First(
		int status, OrderByComparator<DymerEntry> orderByComparator) {

		List<DymerEntry> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByStatus_Last(
			int status, OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByStatus_Last(status, orderByComparator);

		if (dymerEntry != null) {
			return dymerEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDymerEntryException(sb.toString());
	}

	/**
	 * Returns the last dymer entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByStatus_Last(
		int status, OrderByComparator<DymerEntry> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<DymerEntry> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where status = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry[] findByStatus_PrevAndNext(
			long entryId, int status,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			DymerEntry[] array = new DymerEntryImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, dymerEntry, status, orderByComparator, true);

			array[1] = dymerEntry;

			array[2] = getByStatus_PrevAndNext(
				session, dymerEntry, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DymerEntry getByStatus_PrevAndNext(
		Session session, DymerEntry dymerEntry, int status,
		OrderByComparator<DymerEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dymerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DymerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dymer entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (DymerEntry dymerEntry :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dymerEntry);
		}
	}

	/**
	 * Returns the number of dymer entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching dymer entries
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DYMERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"dymerEntry.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dymer entries
	 */
	@Override
	public List<DymerEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<DymerEntry> list = null;

		if (useFinderCache) {
			list = (List<DymerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DymerEntry dymerEntry : list) {
					if ((groupId != dymerEntry.getGroupId()) ||
						(status != dymerEntry.getStatus())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<DymerEntry>)QueryUtil.list(
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
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (dymerEntry != null) {
			return dymerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDymerEntryException(sb.toString());
	}

	/**
	 * Returns the first dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<DymerEntry> orderByComparator) {

		List<DymerEntry> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (dymerEntry != null) {
			return dymerEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchDymerEntryException(sb.toString());
	}

	/**
	 * Returns the last dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<DymerEntry> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<DymerEntry> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry[] findByG_S_PrevAndNext(
			long entryId, long groupId, int status,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			DymerEntry[] array = new DymerEntryImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, dymerEntry, groupId, status, orderByComparator, true);

			array[1] = dymerEntry;

			array[2] = getByG_S_PrevAndNext(
				session, dymerEntry, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DymerEntry getByG_S_PrevAndNext(
		Session session, DymerEntry dymerEntry, long groupId, int status,
		OrderByComparator<DymerEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

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
			sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dymerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DymerEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dymer entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching dymer entries that the user has permission to view
	 */
	@Override
	public List<DymerEntry> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dymer entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of matching dymer entries that the user has permission to view
	 */
	@Override
	public List<DymerEntry> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dymer entries that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dymer entries that the user has permission to view
	 */
	@Override
	public List<DymerEntry> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DymerEntry> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, status, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DymerEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DymerEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DymerEntryImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DymerEntryImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<DymerEntry>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the dymer entries before and after the current dymer entry in the ordered set of dymer entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param entryId the primary key of the current dymer entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry[] filterFindByG_S_PrevAndNext(
			long entryId, long groupId, int status,
			OrderByComparator<DymerEntry> orderByComparator)
		throws NoSuchDymerEntryException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				entryId, groupId, status, orderByComparator);
		}

		DymerEntry dymerEntry = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			DymerEntry[] array = new DymerEntryImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, dymerEntry, groupId, status, orderByComparator, true);

			array[1] = dymerEntry;

			array[2] = filterGetByG_S_PrevAndNext(
				session, dymerEntry, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DymerEntry filterGetByG_S_PrevAndNext(
		Session session, DymerEntry dymerEntry, long groupId, int status,
		OrderByComparator<DymerEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_WHERE);
		}
		else {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_DYMERENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(DymerEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(DymerEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DymerEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, DymerEntryImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, DymerEntryImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dymerEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DymerEntry> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dymer entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (DymerEntry dymerEntry :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dymerEntry);
		}
	}

	/**
	 * Returns the number of dymer entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching dymer entries
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DYMERENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

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

	/**
	 * Returns the number of dymer entries that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching dymer entries that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_DYMERENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), DymerEntry.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"dymerEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"dymerEntry.status = ?";

	private FinderPath _finderPathFetchByForIndexTypeId;
	private FinderPath _finderPathCountByForIndexTypeId;

	/**
	 * Returns the dymer entry where index = &#63; and type = &#63; and id = &#63; or throws a <code>NoSuchDymerEntryException</code> if it could not be found.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the matching dymer entry
	 * @throws NoSuchDymerEntryException if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry findByForIndexTypeId(String index, String type, String id)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByForIndexTypeId(index, type, id);

		if (dymerEntry == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("index=");
			sb.append(index);

			sb.append(", type=");
			sb.append(type);

			sb.append(", id=");
			sb.append(id);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDymerEntryException(sb.toString());
		}

		return dymerEntry;
	}

	/**
	 * Returns the dymer entry where index = &#63; and type = &#63; and id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByForIndexTypeId(
		String index, String type, String id) {

		return fetchByForIndexTypeId(index, type, id, true);
	}

	/**
	 * Returns the dymer entry where index = &#63; and type = &#63; and id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching dymer entry, or <code>null</code> if a matching dymer entry could not be found
	 */
	@Override
	public DymerEntry fetchByForIndexTypeId(
		String index, String type, String id, boolean useFinderCache) {

		index = Objects.toString(index, "");
		type = Objects.toString(type, "");
		id = Objects.toString(id, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {index, type, id};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByForIndexTypeId, finderArgs, this);
		}

		if (result instanceof DymerEntry) {
			DymerEntry dymerEntry = (DymerEntry)result;

			if (!Objects.equals(index, dymerEntry.getIndex()) ||
				!Objects.equals(type, dymerEntry.getType()) ||
				!Objects.equals(id, dymerEntry.getId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_DYMERENTRY_WHERE);

			boolean bindIndex = false;

			if (index.isEmpty()) {
				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_INDEX_3);
			}
			else {
				bindIndex = true;

				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_INDEX_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_TYPE_2);
			}

			boolean bindId = false;

			if (id.isEmpty()) {
				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_ID_3);
			}
			else {
				bindId = true;

				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIndex) {
					queryPos.add(index);
				}

				if (bindType) {
					queryPos.add(type);
				}

				if (bindId) {
					queryPos.add(id);
				}

				List<DymerEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByForIndexTypeId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {index, type, id};
							}

							_log.warn(
								"DymerEntryPersistenceImpl.fetchByForIndexTypeId(String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DymerEntry dymerEntry = list.get(0);

					result = dymerEntry;

					cacheResult(dymerEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DymerEntry)result;
		}
	}

	/**
	 * Removes the dymer entry where index = &#63; and type = &#63; and id = &#63; from the database.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the dymer entry that was removed
	 */
	@Override
	public DymerEntry removeByForIndexTypeId(
			String index, String type, String id)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = findByForIndexTypeId(index, type, id);

		return remove(dymerEntry);
	}

	/**
	 * Returns the number of dymer entries where index = &#63; and type = &#63; and id = &#63;.
	 *
	 * @param index the index
	 * @param type the type
	 * @param id the ID
	 * @return the number of matching dymer entries
	 */
	@Override
	public int countByForIndexTypeId(String index, String type, String id) {
		index = Objects.toString(index, "");
		type = Objects.toString(type, "");
		id = Objects.toString(id, "");

		FinderPath finderPath = _finderPathCountByForIndexTypeId;

		Object[] finderArgs = new Object[] {index, type, id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_DYMERENTRY_WHERE);

			boolean bindIndex = false;

			if (index.isEmpty()) {
				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_INDEX_3);
			}
			else {
				bindIndex = true;

				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_INDEX_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_TYPE_2);
			}

			boolean bindId = false;

			if (id.isEmpty()) {
				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_ID_3);
			}
			else {
				bindId = true;

				sb.append(_FINDER_COLUMN_FORINDEXTYPEID_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIndex) {
					queryPos.add(index);
				}

				if (bindType) {
					queryPos.add(type);
				}

				if (bindId) {
					queryPos.add(id);
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

	private static final String _FINDER_COLUMN_FORINDEXTYPEID_INDEX_2 =
		"dymerEntry.index = ? AND ";

	private static final String _FINDER_COLUMN_FORINDEXTYPEID_INDEX_3 =
		"(dymerEntry.index IS NULL OR dymerEntry.index = '') AND ";

	private static final String _FINDER_COLUMN_FORINDEXTYPEID_TYPE_2 =
		"dymerEntry.type = ? AND ";

	private static final String _FINDER_COLUMN_FORINDEXTYPEID_TYPE_3 =
		"(dymerEntry.type IS NULL OR dymerEntry.type = '') AND ";

	private static final String _FINDER_COLUMN_FORINDEXTYPEID_ID_2 =
		"dymerEntry.id = ?";

	private static final String _FINDER_COLUMN_FORINDEXTYPEID_ID_3 =
		"(dymerEntry.id IS NULL OR dymerEntry.id = '')";

	public DymerEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("index", "index_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DymerEntry.class);

		setModelImplClass(DymerEntryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the dymer entry in the entity cache if it is enabled.
	 *
	 * @param dymerEntry the dymer entry
	 */
	@Override
	public void cacheResult(DymerEntry dymerEntry) {
		entityCache.putResult(
			DymerEntryImpl.class, dymerEntry.getPrimaryKey(), dymerEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {dymerEntry.getUuid(), dymerEntry.getGroupId()},
			dymerEntry);

		finderCache.putResult(
			_finderPathFetchByForIndexTypeId,
			new Object[] {
				dymerEntry.getIndex(), dymerEntry.getType(), dymerEntry.getId()
			},
			dymerEntry);
	}

	/**
	 * Caches the dymer entries in the entity cache if it is enabled.
	 *
	 * @param dymerEntries the dymer entries
	 */
	@Override
	public void cacheResult(List<DymerEntry> dymerEntries) {
		for (DymerEntry dymerEntry : dymerEntries) {
			if (entityCache.getResult(
					DymerEntryImpl.class, dymerEntry.getPrimaryKey()) == null) {

				cacheResult(dymerEntry);
			}
		}
	}

	/**
	 * Clears the cache for all dymer entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DymerEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dymer entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DymerEntry dymerEntry) {
		entityCache.removeResult(DymerEntryImpl.class, dymerEntry);
	}

	@Override
	public void clearCache(List<DymerEntry> dymerEntries) {
		for (DymerEntry dymerEntry : dymerEntries) {
			entityCache.removeResult(DymerEntryImpl.class, dymerEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DymerEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DymerEntryModelImpl dymerEntryModelImpl) {

		Object[] args = new Object[] {
			dymerEntryModelImpl.getUuid(), dymerEntryModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, dymerEntryModelImpl, false);

		args = new Object[] {
			dymerEntryModelImpl.getIndex(), dymerEntryModelImpl.getType(),
			dymerEntryModelImpl.getId()
		};

		finderCache.putResult(
			_finderPathCountByForIndexTypeId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByForIndexTypeId, args, dymerEntryModelImpl, false);
	}

	/**
	 * Creates a new dymer entry with the primary key. Does not add the dymer entry to the database.
	 *
	 * @param entryId the primary key for the new dymer entry
	 * @return the new dymer entry
	 */
	@Override
	public DymerEntry create(long entryId) {
		DymerEntry dymerEntry = new DymerEntryImpl();

		dymerEntry.setNew(true);
		dymerEntry.setPrimaryKey(entryId);

		String uuid = PortalUUIDUtil.generate();

		dymerEntry.setUuid(uuid);

		dymerEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dymerEntry;
	}

	/**
	 * Removes the dymer entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry that was removed
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry remove(long entryId) throws NoSuchDymerEntryException {
		return remove((Serializable)entryId);
	}

	/**
	 * Removes the dymer entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dymer entry
	 * @return the dymer entry that was removed
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry remove(Serializable primaryKey)
		throws NoSuchDymerEntryException {

		Session session = null;

		try {
			session = openSession();

			DymerEntry dymerEntry = (DymerEntry)session.get(
				DymerEntryImpl.class, primaryKey);

			if (dymerEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDymerEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dymerEntry);
		}
		catch (NoSuchDymerEntryException noSuchEntityException) {
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
	protected DymerEntry removeImpl(DymerEntry dymerEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dymerEntry)) {
				dymerEntry = (DymerEntry)session.get(
					DymerEntryImpl.class, dymerEntry.getPrimaryKeyObj());
			}

			if (dymerEntry != null) {
				session.delete(dymerEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dymerEntry != null) {
			clearCache(dymerEntry);
		}

		return dymerEntry;
	}

	@Override
	public DymerEntry updateImpl(DymerEntry dymerEntry) {
		boolean isNew = dymerEntry.isNew();

		if (!(dymerEntry instanceof DymerEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dymerEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dymerEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dymerEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DymerEntry implementation " +
					dymerEntry.getClass());
		}

		DymerEntryModelImpl dymerEntryModelImpl =
			(DymerEntryModelImpl)dymerEntry;

		if (Validator.isNull(dymerEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dymerEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (dymerEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				dymerEntry.setCreateDate(now);
			}
			else {
				dymerEntry.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!dymerEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dymerEntry.setModifiedDate(now);
			}
			else {
				dymerEntry.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dymerEntry);
			}
			else {
				dymerEntry = (DymerEntry)session.merge(dymerEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DymerEntryImpl.class, dymerEntryModelImpl, false, true);

		cacheUniqueFindersCache(dymerEntryModelImpl);

		if (isNew) {
			dymerEntry.setNew(false);
		}

		dymerEntry.resetOriginalValues();

		return dymerEntry;
	}

	/**
	 * Returns the dymer entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dymer entry
	 * @return the dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDymerEntryException {

		DymerEntry dymerEntry = fetchByPrimaryKey(primaryKey);

		if (dymerEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDymerEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dymerEntry;
	}

	/**
	 * Returns the dymer entry with the primary key or throws a <code>NoSuchDymerEntryException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry
	 * @throws NoSuchDymerEntryException if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry findByPrimaryKey(long entryId)
		throws NoSuchDymerEntryException {

		return findByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns the dymer entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the dymer entry
	 * @return the dymer entry, or <code>null</code> if a dymer entry with the primary key could not be found
	 */
	@Override
	public DymerEntry fetchByPrimaryKey(long entryId) {
		return fetchByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns all the dymer entries.
	 *
	 * @return the dymer entries
	 */
	@Override
	public List<DymerEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dymer entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @return the range of dymer entries
	 */
	@Override
	public List<DymerEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dymer entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dymer entries
	 */
	@Override
	public List<DymerEntry> findAll(
		int start, int end, OrderByComparator<DymerEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dymer entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DymerEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dymer entries
	 * @param end the upper bound of the range of dymer entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dymer entries
	 */
	@Override
	public List<DymerEntry> findAll(
		int start, int end, OrderByComparator<DymerEntry> orderByComparator,
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

		List<DymerEntry> list = null;

		if (useFinderCache) {
			list = (List<DymerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DYMERENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DYMERENTRY;

				sql = sql.concat(DymerEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DymerEntry>)QueryUtil.list(
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
	 * Removes all the dymer entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DymerEntry dymerEntry : findAll()) {
			remove(dymerEntry);
		}
	}

	/**
	 * Returns the number of dymer entries.
	 *
	 * @return the number of dymer entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DYMERENTRY);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "entryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DYMERENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DymerEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dymer entry persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DymerEntryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DymerEntry.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByG_D = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_D",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "dymerId"}, true);

		_finderPathWithoutPaginationFindByG_D = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_D",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "dymerId"}, true);

		_finderPathCountByG_D = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_D",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "dymerId"}, false);

		_finderPathWithPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "status"}, true);

		_finderPathWithoutPaginationFindByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, true);

		_finderPathCountByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, false);

		_finderPathFetchByForIndexTypeId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByForIndexTypeId",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"index_", "type_", "id_"}, true);

		_finderPathCountByForIndexTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByForIndexTypeId",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"index_", "type_", "id_"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(DymerEntryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = DYMPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DYMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DYMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_DYMERENTRY =
		"SELECT dymerEntry FROM DymerEntry dymerEntry";

	private static final String _SQL_SELECT_DYMERENTRY_WHERE =
		"SELECT dymerEntry FROM DymerEntry dymerEntry WHERE ";

	private static final String _SQL_COUNT_DYMERENTRY =
		"SELECT COUNT(dymerEntry) FROM DymerEntry dymerEntry";

	private static final String _SQL_COUNT_DYMERENTRY_WHERE =
		"SELECT COUNT(dymerEntry) FROM DymerEntry dymerEntry WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"dymerEntry.entryId";

	private static final String _FILTER_SQL_SELECT_DYMERENTRY_WHERE =
		"SELECT DISTINCT {dymerEntry.*} FROM DYM_DymerEntry dymerEntry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_DYMERENTRY_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {DYM_DymerEntry.*} FROM (SELECT DISTINCT dymerEntry.entryId FROM DYM_DymerEntry dymerEntry WHERE ";

	private static final String
		_FILTER_SQL_SELECT_DYMERENTRY_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN DYM_DymerEntry ON TEMP_TABLE.entryId = DYM_DymerEntry.entryId";

	private static final String _FILTER_SQL_COUNT_DYMERENTRY_WHERE =
		"SELECT COUNT(DISTINCT dymerEntry.entryId) AS COUNT_VALUE FROM DYM_DymerEntry dymerEntry WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "dymerEntry";

	private static final String _FILTER_ENTITY_TABLE = "DYM_DymerEntry";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dymerEntry.";

	private static final String _ORDER_BY_ENTITY_TABLE = "DYM_DymerEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DymerEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DymerEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DymerEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "index", "type", "id"});

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

	private static class DymerEntryModelArgumentsResolver
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

			DymerEntryModelImpl dymerEntryModelImpl =
				(DymerEntryModelImpl)baseModel;

			long columnBitmask = dymerEntryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(dymerEntryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						dymerEntryModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(dymerEntryModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			DymerEntryModelImpl dymerEntryModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = dymerEntryModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = dymerEntryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}