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

package it.eng.rd.chat.service.persistence.impl;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.eng.rd.chat.exception.NoSuchChatRequestException;
import it.eng.rd.chat.model.ChatRequest;
import it.eng.rd.chat.model.impl.ChatRequestImpl;
import it.eng.rd.chat.model.impl.ChatRequestModelImpl;
import it.eng.rd.chat.service.persistence.ChatRequestPersistence;
import it.eng.rd.chat.service.persistence.impl.constants.dymPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the chat request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ChatRequestPersistence.class)
public class ChatRequestPersistenceImpl
	extends BasePersistenceImpl<ChatRequest> implements ChatRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChatRequestUtil</code> to access the chat request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChatRequestImpl.class.getName();

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
	 * Returns all the chat requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching chat requests
	 */
	@Override
	public List<ChatRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chat requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @return the range of matching chat requests
	 */
	@Override
	public List<ChatRequest> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chat requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat requests
	 */
	@Override
	public List<ChatRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChatRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chat requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chat requests
	 */
	@Override
	public List<ChatRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChatRequest> orderByComparator,
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

		List<ChatRequest> list = null;

		if (useFinderCache) {
			list = (List<ChatRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChatRequest chatRequest : list) {
					if (!uuid.equals(chatRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_CHATREQUEST_WHERE);

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
				sb.append(ChatRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<ChatRequest>)QueryUtil.list(
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
	 * Returns the first chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	@Override
	public ChatRequest findByUuid_First(
			String uuid, OrderByComparator<ChatRequest> orderByComparator)
		throws NoSuchChatRequestException {

		ChatRequest chatRequest = fetchByUuid_First(uuid, orderByComparator);

		if (chatRequest != null) {
			return chatRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchChatRequestException(sb.toString());
	}

	/**
	 * Returns the first chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	@Override
	public ChatRequest fetchByUuid_First(
		String uuid, OrderByComparator<ChatRequest> orderByComparator) {

		List<ChatRequest> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	@Override
	public ChatRequest findByUuid_Last(
			String uuid, OrderByComparator<ChatRequest> orderByComparator)
		throws NoSuchChatRequestException {

		ChatRequest chatRequest = fetchByUuid_Last(uuid, orderByComparator);

		if (chatRequest != null) {
			return chatRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchChatRequestException(sb.toString());
	}

	/**
	 * Returns the last chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	@Override
	public ChatRequest fetchByUuid_Last(
		String uuid, OrderByComparator<ChatRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ChatRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chat requests before and after the current chat request in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current chat request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat request
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	@Override
	public ChatRequest[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ChatRequest> orderByComparator)
		throws NoSuchChatRequestException {

		uuid = Objects.toString(uuid, "");

		ChatRequest chatRequest = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChatRequest[] array = new ChatRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, chatRequest, uuid, orderByComparator, true);

			array[1] = chatRequest;

			array[2] = getByUuid_PrevAndNext(
				session, chatRequest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChatRequest getByUuid_PrevAndNext(
		Session session, ChatRequest chatRequest, String uuid,
		OrderByComparator<ChatRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHATREQUEST_WHERE);

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
			sb.append(ChatRequestModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(chatRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChatRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chat requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ChatRequest chatRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(chatRequest);
		}
	}

	/**
	 * Returns the number of chat requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching chat requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHATREQUEST_WHERE);

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
		"chatRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(chatRequest.uuid IS NULL OR chatRequest.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByIsAccested;
	private FinderPath _finderPathWithoutPaginationFindByIsAccested;
	private FinderPath _finderPathCountByIsAccested;

	/**
	 * Returns all the chat requests where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @return the matching chat requests
	 */
	@Override
	public List<ChatRequest> findByIsAccested(boolean isAccepted) {
		return findByIsAccested(
			isAccepted, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chat requests where isAccepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param isAccepted the is accepted
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @return the range of matching chat requests
	 */
	@Override
	public List<ChatRequest> findByIsAccested(
		boolean isAccepted, int start, int end) {

		return findByIsAccested(isAccepted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chat requests where isAccepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param isAccepted the is accepted
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat requests
	 */
	@Override
	public List<ChatRequest> findByIsAccested(
		boolean isAccepted, int start, int end,
		OrderByComparator<ChatRequest> orderByComparator) {

		return findByIsAccested(
			isAccepted, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chat requests where isAccepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param isAccepted the is accepted
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chat requests
	 */
	@Override
	public List<ChatRequest> findByIsAccested(
		boolean isAccepted, int start, int end,
		OrderByComparator<ChatRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIsAccested;
				finderArgs = new Object[] {isAccepted};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsAccested;
			finderArgs = new Object[] {
				isAccepted, start, end, orderByComparator
			};
		}

		List<ChatRequest> list = null;

		if (useFinderCache) {
			list = (List<ChatRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChatRequest chatRequest : list) {
					if (isAccepted != chatRequest.isIsAccepted()) {
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

			sb.append(_SQL_SELECT_CHATREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_ISACCESTED_ISACCEPTED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ChatRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isAccepted);

				list = (List<ChatRequest>)QueryUtil.list(
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
	 * Returns the first chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	@Override
	public ChatRequest findByIsAccested_First(
			boolean isAccepted,
			OrderByComparator<ChatRequest> orderByComparator)
		throws NoSuchChatRequestException {

		ChatRequest chatRequest = fetchByIsAccested_First(
			isAccepted, orderByComparator);

		if (chatRequest != null) {
			return chatRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isAccepted=");
		sb.append(isAccepted);

		sb.append("}");

		throw new NoSuchChatRequestException(sb.toString());
	}

	/**
	 * Returns the first chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	@Override
	public ChatRequest fetchByIsAccested_First(
		boolean isAccepted, OrderByComparator<ChatRequest> orderByComparator) {

		List<ChatRequest> list = findByIsAccested(
			isAccepted, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	@Override
	public ChatRequest findByIsAccested_Last(
			boolean isAccepted,
			OrderByComparator<ChatRequest> orderByComparator)
		throws NoSuchChatRequestException {

		ChatRequest chatRequest = fetchByIsAccested_Last(
			isAccepted, orderByComparator);

		if (chatRequest != null) {
			return chatRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isAccepted=");
		sb.append(isAccepted);

		sb.append("}");

		throw new NoSuchChatRequestException(sb.toString());
	}

	/**
	 * Returns the last chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	@Override
	public ChatRequest fetchByIsAccested_Last(
		boolean isAccepted, OrderByComparator<ChatRequest> orderByComparator) {

		int count = countByIsAccested(isAccepted);

		if (count == 0) {
			return null;
		}

		List<ChatRequest> list = findByIsAccested(
			isAccepted, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chat requests before and after the current chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param id the primary key of the current chat request
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat request
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	@Override
	public ChatRequest[] findByIsAccested_PrevAndNext(
			long id, boolean isAccepted,
			OrderByComparator<ChatRequest> orderByComparator)
		throws NoSuchChatRequestException {

		ChatRequest chatRequest = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChatRequest[] array = new ChatRequestImpl[3];

			array[0] = getByIsAccested_PrevAndNext(
				session, chatRequest, isAccepted, orderByComparator, true);

			array[1] = chatRequest;

			array[2] = getByIsAccested_PrevAndNext(
				session, chatRequest, isAccepted, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChatRequest getByIsAccested_PrevAndNext(
		Session session, ChatRequest chatRequest, boolean isAccepted,
		OrderByComparator<ChatRequest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHATREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_ISACCESTED_ISACCEPTED_2);

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
			sb.append(ChatRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isAccepted);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(chatRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChatRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chat requests where isAccepted = &#63; from the database.
	 *
	 * @param isAccepted the is accepted
	 */
	@Override
	public void removeByIsAccested(boolean isAccepted) {
		for (ChatRequest chatRequest :
				findByIsAccested(
					isAccepted, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(chatRequest);
		}
	}

	/**
	 * Returns the number of chat requests where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @return the number of matching chat requests
	 */
	@Override
	public int countByIsAccested(boolean isAccepted) {
		FinderPath finderPath = _finderPathCountByIsAccested;

		Object[] finderArgs = new Object[] {isAccepted};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHATREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_ISACCESTED_ISACCEPTED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isAccepted);

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

	private static final String _FINDER_COLUMN_ISACCESTED_ISACCEPTED_2 =
		"chatRequest.isAccepted = ?";

	public ChatRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ChatRequest.class);

		setModelImplClass(ChatRequestImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the chat request in the entity cache if it is enabled.
	 *
	 * @param chatRequest the chat request
	 */
	@Override
	public void cacheResult(ChatRequest chatRequest) {
		entityCache.putResult(
			ChatRequestImpl.class, chatRequest.getPrimaryKey(), chatRequest);
	}

	/**
	 * Caches the chat requests in the entity cache if it is enabled.
	 *
	 * @param chatRequests the chat requests
	 */
	@Override
	public void cacheResult(List<ChatRequest> chatRequests) {
		for (ChatRequest chatRequest : chatRequests) {
			if (entityCache.getResult(
					ChatRequestImpl.class, chatRequest.getPrimaryKey()) ==
						null) {

				cacheResult(chatRequest);
			}
		}
	}

	/**
	 * Clears the cache for all chat requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChatRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chat request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChatRequest chatRequest) {
		entityCache.removeResult(ChatRequestImpl.class, chatRequest);
	}

	@Override
	public void clearCache(List<ChatRequest> chatRequests) {
		for (ChatRequest chatRequest : chatRequests) {
			entityCache.removeResult(ChatRequestImpl.class, chatRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ChatRequestImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new chat request with the primary key. Does not add the chat request to the database.
	 *
	 * @param id the primary key for the new chat request
	 * @return the new chat request
	 */
	@Override
	public ChatRequest create(long id) {
		ChatRequest chatRequest = new ChatRequestImpl();

		chatRequest.setNew(true);
		chatRequest.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		chatRequest.setUuid(uuid);

		return chatRequest;
	}

	/**
	 * Removes the chat request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chat request
	 * @return the chat request that was removed
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	@Override
	public ChatRequest remove(long id) throws NoSuchChatRequestException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the chat request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chat request
	 * @return the chat request that was removed
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	@Override
	public ChatRequest remove(Serializable primaryKey)
		throws NoSuchChatRequestException {

		Session session = null;

		try {
			session = openSession();

			ChatRequest chatRequest = (ChatRequest)session.get(
				ChatRequestImpl.class, primaryKey);

			if (chatRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChatRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(chatRequest);
		}
		catch (NoSuchChatRequestException noSuchEntityException) {
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
	protected ChatRequest removeImpl(ChatRequest chatRequest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chatRequest)) {
				chatRequest = (ChatRequest)session.get(
					ChatRequestImpl.class, chatRequest.getPrimaryKeyObj());
			}

			if (chatRequest != null) {
				session.delete(chatRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (chatRequest != null) {
			clearCache(chatRequest);
		}

		return chatRequest;
	}

	@Override
	public ChatRequest updateImpl(ChatRequest chatRequest) {
		boolean isNew = chatRequest.isNew();

		if (!(chatRequest instanceof ChatRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(chatRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(chatRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in chatRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ChatRequest implementation " +
					chatRequest.getClass());
		}

		ChatRequestModelImpl chatRequestModelImpl =
			(ChatRequestModelImpl)chatRequest;

		if (Validator.isNull(chatRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			chatRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (chatRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				chatRequest.setCreateDate(now);
			}
			else {
				chatRequest.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!chatRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				chatRequest.setModifiedDate(now);
			}
			else {
				chatRequest.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(chatRequest);
			}
			else {
				chatRequest = (ChatRequest)session.merge(chatRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ChatRequestImpl.class, chatRequestModelImpl, false, true);

		if (isNew) {
			chatRequest.setNew(false);
		}

		chatRequest.resetOriginalValues();

		return chatRequest;
	}

	/**
	 * Returns the chat request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chat request
	 * @return the chat request
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	@Override
	public ChatRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChatRequestException {

		ChatRequest chatRequest = fetchByPrimaryKey(primaryKey);

		if (chatRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChatRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return chatRequest;
	}

	/**
	 * Returns the chat request with the primary key or throws a <code>NoSuchChatRequestException</code> if it could not be found.
	 *
	 * @param id the primary key of the chat request
	 * @return the chat request
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	@Override
	public ChatRequest findByPrimaryKey(long id)
		throws NoSuchChatRequestException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the chat request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chat request
	 * @return the chat request, or <code>null</code> if a chat request with the primary key could not be found
	 */
	@Override
	public ChatRequest fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the chat requests.
	 *
	 * @return the chat requests
	 */
	@Override
	public List<ChatRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chat requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @return the range of chat requests
	 */
	@Override
	public List<ChatRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chat requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chat requests
	 */
	@Override
	public List<ChatRequest> findAll(
		int start, int end, OrderByComparator<ChatRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chat requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat requests
	 * @param end the upper bound of the range of chat requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chat requests
	 */
	@Override
	public List<ChatRequest> findAll(
		int start, int end, OrderByComparator<ChatRequest> orderByComparator,
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

		List<ChatRequest> list = null;

		if (useFinderCache) {
			list = (List<ChatRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHATREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHATREQUEST;

				sql = sql.concat(ChatRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ChatRequest>)QueryUtil.list(
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
	 * Removes all the chat requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ChatRequest chatRequest : findAll()) {
			remove(chatRequest);
		}
	}

	/**
	 * Returns the number of chat requests.
	 *
	 * @return the number of chat requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHATREQUEST);

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
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CHATREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChatRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the chat request persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ChatRequestModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ChatRequest.class.getName()));

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

		_finderPathWithPaginationFindByIsAccested = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsAccested",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isAccepted"}, true);

		_finderPathWithoutPaginationFindByIsAccested = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsAccested",
			new String[] {Boolean.class.getName()}, new String[] {"isAccepted"},
			true);

		_finderPathCountByIsAccested = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsAccested",
			new String[] {Boolean.class.getName()}, new String[] {"isAccepted"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ChatRequestImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = dymPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = dymPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = dymPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_CHATREQUEST =
		"SELECT chatRequest FROM ChatRequest chatRequest";

	private static final String _SQL_SELECT_CHATREQUEST_WHERE =
		"SELECT chatRequest FROM ChatRequest chatRequest WHERE ";

	private static final String _SQL_COUNT_CHATREQUEST =
		"SELECT COUNT(chatRequest) FROM ChatRequest chatRequest";

	private static final String _SQL_COUNT_CHATREQUEST_WHERE =
		"SELECT COUNT(chatRequest) FROM ChatRequest chatRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "chatRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ChatRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ChatRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ChatRequestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

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

	private static class ChatRequestModelArgumentsResolver
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

			ChatRequestModelImpl chatRequestModelImpl =
				(ChatRequestModelImpl)baseModel;

			long columnBitmask = chatRequestModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(chatRequestModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						chatRequestModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(chatRequestModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ChatRequestModelImpl chatRequestModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = chatRequestModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = chatRequestModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}