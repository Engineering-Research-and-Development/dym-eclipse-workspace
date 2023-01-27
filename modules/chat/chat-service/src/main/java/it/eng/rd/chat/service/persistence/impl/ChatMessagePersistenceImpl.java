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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import it.eng.rd.chat.exception.NoSuchChatMessageException;
import it.eng.rd.chat.model.ChatMessage;
import it.eng.rd.chat.model.impl.ChatMessageImpl;
import it.eng.rd.chat.model.impl.ChatMessageModelImpl;
import it.eng.rd.chat.service.persistence.ChatMessagePersistence;
import it.eng.rd.chat.service.persistence.impl.constants.dymPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the chat message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ChatMessagePersistence.class)
public class ChatMessagePersistenceImpl
	extends BasePersistenceImpl<ChatMessage> implements ChatMessagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChatMessageUtil</code> to access the chat message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChatMessageImpl.class.getName();

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
	 * Returns all the chat messages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching chat messages
	 */
	@Override
	public List<ChatMessage> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chat messages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @return the range of matching chat messages
	 */
	@Override
	public List<ChatMessage> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chat messages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat messages
	 */
	@Override
	public List<ChatMessage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChatMessage> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chat messages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chat messages
	 */
	@Override
	public List<ChatMessage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ChatMessage> orderByComparator,
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

		List<ChatMessage> list = null;

		if (useFinderCache) {
			list = (List<ChatMessage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChatMessage chatMessage : list) {
					if (!uuid.equals(chatMessage.getUuid())) {
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

			sb.append(_SQL_SELECT_CHATMESSAGE_WHERE);

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
				sb.append(ChatMessageModelImpl.ORDER_BY_JPQL);
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

				list = (List<ChatMessage>)QueryUtil.list(
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
	 * Returns the first chat message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat message
	 * @throws NoSuchChatMessageException if a matching chat message could not be found
	 */
	@Override
	public ChatMessage findByUuid_First(
			String uuid, OrderByComparator<ChatMessage> orderByComparator)
		throws NoSuchChatMessageException {

		ChatMessage chatMessage = fetchByUuid_First(uuid, orderByComparator);

		if (chatMessage != null) {
			return chatMessage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchChatMessageException(sb.toString());
	}

	/**
	 * Returns the first chat message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat message, or <code>null</code> if a matching chat message could not be found
	 */
	@Override
	public ChatMessage fetchByUuid_First(
		String uuid, OrderByComparator<ChatMessage> orderByComparator) {

		List<ChatMessage> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chat message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat message
	 * @throws NoSuchChatMessageException if a matching chat message could not be found
	 */
	@Override
	public ChatMessage findByUuid_Last(
			String uuid, OrderByComparator<ChatMessage> orderByComparator)
		throws NoSuchChatMessageException {

		ChatMessage chatMessage = fetchByUuid_Last(uuid, orderByComparator);

		if (chatMessage != null) {
			return chatMessage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchChatMessageException(sb.toString());
	}

	/**
	 * Returns the last chat message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat message, or <code>null</code> if a matching chat message could not be found
	 */
	@Override
	public ChatMessage fetchByUuid_Last(
		String uuid, OrderByComparator<ChatMessage> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ChatMessage> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chat messages before and after the current chat message in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current chat message
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat message
	 * @throws NoSuchChatMessageException if a chat message with the primary key could not be found
	 */
	@Override
	public ChatMessage[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ChatMessage> orderByComparator)
		throws NoSuchChatMessageException {

		uuid = Objects.toString(uuid, "");

		ChatMessage chatMessage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChatMessage[] array = new ChatMessageImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, chatMessage, uuid, orderByComparator, true);

			array[1] = chatMessage;

			array[2] = getByUuid_PrevAndNext(
				session, chatMessage, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChatMessage getByUuid_PrevAndNext(
		Session session, ChatMessage chatMessage, String uuid,
		OrderByComparator<ChatMessage> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHATMESSAGE_WHERE);

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
			sb.append(ChatMessageModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(chatMessage)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChatMessage> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chat messages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ChatMessage chatMessage :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(chatMessage);
		}
	}

	/**
	 * Returns the number of chat messages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching chat messages
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHATMESSAGE_WHERE);

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
		"chatMessage.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(chatMessage.uuid IS NULL OR chatMessage.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the chat message where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchChatMessageException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching chat message
	 * @throws NoSuchChatMessageException if a matching chat message could not be found
	 */
	@Override
	public ChatMessage findByUUID_G(String uuid, long groupId)
		throws NoSuchChatMessageException {

		ChatMessage chatMessage = fetchByUUID_G(uuid, groupId);

		if (chatMessage == null) {
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

			throw new NoSuchChatMessageException(sb.toString());
		}

		return chatMessage;
	}

	/**
	 * Returns the chat message where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching chat message, or <code>null</code> if a matching chat message could not be found
	 */
	@Override
	public ChatMessage fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the chat message where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching chat message, or <code>null</code> if a matching chat message could not be found
	 */
	@Override
	public ChatMessage fetchByUUID_G(
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

		if (result instanceof ChatMessage) {
			ChatMessage chatMessage = (ChatMessage)result;

			if (!Objects.equals(uuid, chatMessage.getUuid()) ||
				(groupId != chatMessage.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CHATMESSAGE_WHERE);

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

				List<ChatMessage> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ChatMessage chatMessage = list.get(0);

					result = chatMessage;

					cacheResult(chatMessage);
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
			return (ChatMessage)result;
		}
	}

	/**
	 * Removes the chat message where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the chat message that was removed
	 */
	@Override
	public ChatMessage removeByUUID_G(String uuid, long groupId)
		throws NoSuchChatMessageException {

		ChatMessage chatMessage = findByUUID_G(uuid, groupId);

		return remove(chatMessage);
	}

	/**
	 * Returns the number of chat messages where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching chat messages
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHATMESSAGE_WHERE);

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
		"chatMessage.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(chatMessage.uuid IS NULL OR chatMessage.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"chatMessage.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the chat messages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching chat messages
	 */
	@Override
	public List<ChatMessage> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chat messages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @return the range of matching chat messages
	 */
	@Override
	public List<ChatMessage> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chat messages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat messages
	 */
	@Override
	public List<ChatMessage> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChatMessage> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chat messages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chat messages
	 */
	@Override
	public List<ChatMessage> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ChatMessage> orderByComparator,
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

		List<ChatMessage> list = null;

		if (useFinderCache) {
			list = (List<ChatMessage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChatMessage chatMessage : list) {
					if (!uuid.equals(chatMessage.getUuid()) ||
						(companyId != chatMessage.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CHATMESSAGE_WHERE);

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
				sb.append(ChatMessageModelImpl.ORDER_BY_JPQL);
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

				list = (List<ChatMessage>)QueryUtil.list(
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
	 * Returns the first chat message in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat message
	 * @throws NoSuchChatMessageException if a matching chat message could not be found
	 */
	@Override
	public ChatMessage findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ChatMessage> orderByComparator)
		throws NoSuchChatMessageException {

		ChatMessage chatMessage = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (chatMessage != null) {
			return chatMessage;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchChatMessageException(sb.toString());
	}

	/**
	 * Returns the first chat message in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat message, or <code>null</code> if a matching chat message could not be found
	 */
	@Override
	public ChatMessage fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ChatMessage> orderByComparator) {

		List<ChatMessage> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chat message in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat message
	 * @throws NoSuchChatMessageException if a matching chat message could not be found
	 */
	@Override
	public ChatMessage findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ChatMessage> orderByComparator)
		throws NoSuchChatMessageException {

		ChatMessage chatMessage = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (chatMessage != null) {
			return chatMessage;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchChatMessageException(sb.toString());
	}

	/**
	 * Returns the last chat message in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat message, or <code>null</code> if a matching chat message could not be found
	 */
	@Override
	public ChatMessage fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ChatMessage> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ChatMessage> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chat messages before and after the current chat message in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current chat message
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat message
	 * @throws NoSuchChatMessageException if a chat message with the primary key could not be found
	 */
	@Override
	public ChatMessage[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<ChatMessage> orderByComparator)
		throws NoSuchChatMessageException {

		uuid = Objects.toString(uuid, "");

		ChatMessage chatMessage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChatMessage[] array = new ChatMessageImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, chatMessage, uuid, companyId, orderByComparator, true);

			array[1] = chatMessage;

			array[2] = getByUuid_C_PrevAndNext(
				session, chatMessage, uuid, companyId, orderByComparator,
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

	protected ChatMessage getByUuid_C_PrevAndNext(
		Session session, ChatMessage chatMessage, String uuid, long companyId,
		OrderByComparator<ChatMessage> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CHATMESSAGE_WHERE);

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
			sb.append(ChatMessageModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(chatMessage)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChatMessage> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chat messages where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ChatMessage chatMessage :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(chatMessage);
		}
	}

	/**
	 * Returns the number of chat messages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching chat messages
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHATMESSAGE_WHERE);

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
		"chatMessage.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(chatMessage.uuid IS NULL OR chatMessage.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"chatMessage.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByFindByToUser;
	private FinderPath _finderPathWithoutPaginationFindByFindByToUser;
	private FinderPath _finderPathCountByFindByToUser;

	/**
	 * Returns all the chat messages where toUser = &#63;.
	 *
	 * @param toUser the to user
	 * @return the matching chat messages
	 */
	@Override
	public List<ChatMessage> findByFindByToUser(long toUser) {
		return findByFindByToUser(
			toUser, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chat messages where toUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param toUser the to user
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @return the range of matching chat messages
	 */
	@Override
	public List<ChatMessage> findByFindByToUser(
		long toUser, int start, int end) {

		return findByFindByToUser(toUser, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chat messages where toUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param toUser the to user
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chat messages
	 */
	@Override
	public List<ChatMessage> findByFindByToUser(
		long toUser, int start, int end,
		OrderByComparator<ChatMessage> orderByComparator) {

		return findByFindByToUser(toUser, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chat messages where toUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param toUser the to user
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chat messages
	 */
	@Override
	public List<ChatMessage> findByFindByToUser(
		long toUser, int start, int end,
		OrderByComparator<ChatMessage> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindByToUser;
				finderArgs = new Object[] {toUser};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindByToUser;
			finderArgs = new Object[] {toUser, start, end, orderByComparator};
		}

		List<ChatMessage> list = null;

		if (useFinderCache) {
			list = (List<ChatMessage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChatMessage chatMessage : list) {
					if (toUser != chatMessage.getToUser()) {
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

			sb.append(_SQL_SELECT_CHATMESSAGE_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYTOUSER_TOUSER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ChatMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(toUser);

				list = (List<ChatMessage>)QueryUtil.list(
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
	 * Returns the first chat message in the ordered set where toUser = &#63;.
	 *
	 * @param toUser the to user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat message
	 * @throws NoSuchChatMessageException if a matching chat message could not be found
	 */
	@Override
	public ChatMessage findByFindByToUser_First(
			long toUser, OrderByComparator<ChatMessage> orderByComparator)
		throws NoSuchChatMessageException {

		ChatMessage chatMessage = fetchByFindByToUser_First(
			toUser, orderByComparator);

		if (chatMessage != null) {
			return chatMessage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toUser=");
		sb.append(toUser);

		sb.append("}");

		throw new NoSuchChatMessageException(sb.toString());
	}

	/**
	 * Returns the first chat message in the ordered set where toUser = &#63;.
	 *
	 * @param toUser the to user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat message, or <code>null</code> if a matching chat message could not be found
	 */
	@Override
	public ChatMessage fetchByFindByToUser_First(
		long toUser, OrderByComparator<ChatMessage> orderByComparator) {

		List<ChatMessage> list = findByFindByToUser(
			toUser, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chat message in the ordered set where toUser = &#63;.
	 *
	 * @param toUser the to user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat message
	 * @throws NoSuchChatMessageException if a matching chat message could not be found
	 */
	@Override
	public ChatMessage findByFindByToUser_Last(
			long toUser, OrderByComparator<ChatMessage> orderByComparator)
		throws NoSuchChatMessageException {

		ChatMessage chatMessage = fetchByFindByToUser_Last(
			toUser, orderByComparator);

		if (chatMessage != null) {
			return chatMessage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toUser=");
		sb.append(toUser);

		sb.append("}");

		throw new NoSuchChatMessageException(sb.toString());
	}

	/**
	 * Returns the last chat message in the ordered set where toUser = &#63;.
	 *
	 * @param toUser the to user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat message, or <code>null</code> if a matching chat message could not be found
	 */
	@Override
	public ChatMessage fetchByFindByToUser_Last(
		long toUser, OrderByComparator<ChatMessage> orderByComparator) {

		int count = countByFindByToUser(toUser);

		if (count == 0) {
			return null;
		}

		List<ChatMessage> list = findByFindByToUser(
			toUser, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chat messages before and after the current chat message in the ordered set where toUser = &#63;.
	 *
	 * @param id the primary key of the current chat message
	 * @param toUser the to user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat message
	 * @throws NoSuchChatMessageException if a chat message with the primary key could not be found
	 */
	@Override
	public ChatMessage[] findByFindByToUser_PrevAndNext(
			long id, long toUser,
			OrderByComparator<ChatMessage> orderByComparator)
		throws NoSuchChatMessageException {

		ChatMessage chatMessage = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChatMessage[] array = new ChatMessageImpl[3];

			array[0] = getByFindByToUser_PrevAndNext(
				session, chatMessage, toUser, orderByComparator, true);

			array[1] = chatMessage;

			array[2] = getByFindByToUser_PrevAndNext(
				session, chatMessage, toUser, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChatMessage getByFindByToUser_PrevAndNext(
		Session session, ChatMessage chatMessage, long toUser,
		OrderByComparator<ChatMessage> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHATMESSAGE_WHERE);

		sb.append(_FINDER_COLUMN_FINDBYTOUSER_TOUSER_2);

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
			sb.append(ChatMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(toUser);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(chatMessage)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChatMessage> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chat messages where toUser = &#63; from the database.
	 *
	 * @param toUser the to user
	 */
	@Override
	public void removeByFindByToUser(long toUser) {
		for (ChatMessage chatMessage :
				findByFindByToUser(
					toUser, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(chatMessage);
		}
	}

	/**
	 * Returns the number of chat messages where toUser = &#63;.
	 *
	 * @param toUser the to user
	 * @return the number of matching chat messages
	 */
	@Override
	public int countByFindByToUser(long toUser) {
		FinderPath finderPath = _finderPathCountByFindByToUser;

		Object[] finderArgs = new Object[] {toUser};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHATMESSAGE_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYTOUSER_TOUSER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(toUser);

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

	private static final String _FINDER_COLUMN_FINDBYTOUSER_TOUSER_2 =
		"chatMessage.toUser = ?";

	public ChatMessagePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ChatMessage.class);

		setModelImplClass(ChatMessageImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the chat message in the entity cache if it is enabled.
	 *
	 * @param chatMessage the chat message
	 */
	@Override
	public void cacheResult(ChatMessage chatMessage) {
		entityCache.putResult(
			ChatMessageImpl.class, chatMessage.getPrimaryKey(), chatMessage);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {chatMessage.getUuid(), chatMessage.getGroupId()},
			chatMessage);
	}

	/**
	 * Caches the chat messages in the entity cache if it is enabled.
	 *
	 * @param chatMessages the chat messages
	 */
	@Override
	public void cacheResult(List<ChatMessage> chatMessages) {
		for (ChatMessage chatMessage : chatMessages) {
			if (entityCache.getResult(
					ChatMessageImpl.class, chatMessage.getPrimaryKey()) ==
						null) {

				cacheResult(chatMessage);
			}
		}
	}

	/**
	 * Clears the cache for all chat messages.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChatMessageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chat message.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChatMessage chatMessage) {
		entityCache.removeResult(ChatMessageImpl.class, chatMessage);
	}

	@Override
	public void clearCache(List<ChatMessage> chatMessages) {
		for (ChatMessage chatMessage : chatMessages) {
			entityCache.removeResult(ChatMessageImpl.class, chatMessage);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ChatMessageImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ChatMessageModelImpl chatMessageModelImpl) {

		Object[] args = new Object[] {
			chatMessageModelImpl.getUuid(), chatMessageModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, chatMessageModelImpl, false);
	}

	/**
	 * Creates a new chat message with the primary key. Does not add the chat message to the database.
	 *
	 * @param id the primary key for the new chat message
	 * @return the new chat message
	 */
	@Override
	public ChatMessage create(long id) {
		ChatMessage chatMessage = new ChatMessageImpl();

		chatMessage.setNew(true);
		chatMessage.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		chatMessage.setUuid(uuid);

		chatMessage.setCompanyId(CompanyThreadLocal.getCompanyId());

		return chatMessage;
	}

	/**
	 * Removes the chat message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chat message
	 * @return the chat message that was removed
	 * @throws NoSuchChatMessageException if a chat message with the primary key could not be found
	 */
	@Override
	public ChatMessage remove(long id) throws NoSuchChatMessageException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the chat message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chat message
	 * @return the chat message that was removed
	 * @throws NoSuchChatMessageException if a chat message with the primary key could not be found
	 */
	@Override
	public ChatMessage remove(Serializable primaryKey)
		throws NoSuchChatMessageException {

		Session session = null;

		try {
			session = openSession();

			ChatMessage chatMessage = (ChatMessage)session.get(
				ChatMessageImpl.class, primaryKey);

			if (chatMessage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChatMessageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(chatMessage);
		}
		catch (NoSuchChatMessageException noSuchEntityException) {
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
	protected ChatMessage removeImpl(ChatMessage chatMessage) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chatMessage)) {
				chatMessage = (ChatMessage)session.get(
					ChatMessageImpl.class, chatMessage.getPrimaryKeyObj());
			}

			if (chatMessage != null) {
				session.delete(chatMessage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (chatMessage != null) {
			clearCache(chatMessage);
		}

		return chatMessage;
	}

	@Override
	public ChatMessage updateImpl(ChatMessage chatMessage) {
		boolean isNew = chatMessage.isNew();

		if (!(chatMessage instanceof ChatMessageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(chatMessage.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(chatMessage);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in chatMessage proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ChatMessage implementation " +
					chatMessage.getClass());
		}

		ChatMessageModelImpl chatMessageModelImpl =
			(ChatMessageModelImpl)chatMessage;

		if (Validator.isNull(chatMessage.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			chatMessage.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(chatMessage);
			}
			else {
				chatMessage = (ChatMessage)session.merge(chatMessage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ChatMessageImpl.class, chatMessageModelImpl, false, true);

		cacheUniqueFindersCache(chatMessageModelImpl);

		if (isNew) {
			chatMessage.setNew(false);
		}

		chatMessage.resetOriginalValues();

		return chatMessage;
	}

	/**
	 * Returns the chat message with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chat message
	 * @return the chat message
	 * @throws NoSuchChatMessageException if a chat message with the primary key could not be found
	 */
	@Override
	public ChatMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChatMessageException {

		ChatMessage chatMessage = fetchByPrimaryKey(primaryKey);

		if (chatMessage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChatMessageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return chatMessage;
	}

	/**
	 * Returns the chat message with the primary key or throws a <code>NoSuchChatMessageException</code> if it could not be found.
	 *
	 * @param id the primary key of the chat message
	 * @return the chat message
	 * @throws NoSuchChatMessageException if a chat message with the primary key could not be found
	 */
	@Override
	public ChatMessage findByPrimaryKey(long id)
		throws NoSuchChatMessageException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the chat message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chat message
	 * @return the chat message, or <code>null</code> if a chat message with the primary key could not be found
	 */
	@Override
	public ChatMessage fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the chat messages.
	 *
	 * @return the chat messages
	 */
	@Override
	public List<ChatMessage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chat messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @return the range of chat messages
	 */
	@Override
	public List<ChatMessage> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chat messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chat messages
	 */
	@Override
	public List<ChatMessage> findAll(
		int start, int end, OrderByComparator<ChatMessage> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chat messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChatMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chat messages
	 * @param end the upper bound of the range of chat messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chat messages
	 */
	@Override
	public List<ChatMessage> findAll(
		int start, int end, OrderByComparator<ChatMessage> orderByComparator,
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

		List<ChatMessage> list = null;

		if (useFinderCache) {
			list = (List<ChatMessage>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHATMESSAGE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHATMESSAGE;

				sql = sql.concat(ChatMessageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ChatMessage>)QueryUtil.list(
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
	 * Removes all the chat messages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ChatMessage chatMessage : findAll()) {
			remove(chatMessage);
		}
	}

	/**
	 * Returns the number of chat messages.
	 *
	 * @return the number of chat messages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHATMESSAGE);

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
		return _SQL_SELECT_CHATMESSAGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChatMessageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the chat message persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ChatMessageModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ChatMessage.class.getName()));

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

		_finderPathWithPaginationFindByFindByToUser = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindByToUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"toUser"}, true);

		_finderPathWithoutPaginationFindByFindByToUser = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindByToUser",
			new String[] {Long.class.getName()}, new String[] {"toUser"}, true);

		_finderPathCountByFindByToUser = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindByToUser",
			new String[] {Long.class.getName()}, new String[] {"toUser"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ChatMessageImpl.class.getName());

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

	private static final String _SQL_SELECT_CHATMESSAGE =
		"SELECT chatMessage FROM ChatMessage chatMessage";

	private static final String _SQL_SELECT_CHATMESSAGE_WHERE =
		"SELECT chatMessage FROM ChatMessage chatMessage WHERE ";

	private static final String _SQL_COUNT_CHATMESSAGE =
		"SELECT COUNT(chatMessage) FROM ChatMessage chatMessage";

	private static final String _SQL_COUNT_CHATMESSAGE_WHERE =
		"SELECT COUNT(chatMessage) FROM ChatMessage chatMessage WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "chatMessage.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ChatMessage exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ChatMessage exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ChatMessagePersistenceImpl.class);

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

	private static class ChatMessageModelArgumentsResolver
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

			ChatMessageModelImpl chatMessageModelImpl =
				(ChatMessageModelImpl)baseModel;

			long columnBitmask = chatMessageModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(chatMessageModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						chatMessageModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(chatMessageModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ChatMessageModelImpl chatMessageModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = chatMessageModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = chatMessageModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}