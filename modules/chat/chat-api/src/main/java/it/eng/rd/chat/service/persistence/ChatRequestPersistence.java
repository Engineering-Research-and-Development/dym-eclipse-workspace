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

package it.eng.rd.chat.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.eng.rd.chat.exception.NoSuchChatRequestException;
import it.eng.rd.chat.model.ChatRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the chat request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatRequestUtil
 * @generated
 */
@ProviderType
public interface ChatRequestPersistence extends BasePersistence<ChatRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChatRequestUtil} to access the chat request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the chat requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching chat requests
	 */
	public java.util.List<ChatRequest> findByUuid(String uuid);

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
	public java.util.List<ChatRequest> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ChatRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
			orderByComparator);

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
	public java.util.List<ChatRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	public ChatRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
				orderByComparator)
		throws NoSuchChatRequestException;

	/**
	 * Returns the first chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	public ChatRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
			orderByComparator);

	/**
	 * Returns the last chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	public ChatRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
				orderByComparator)
		throws NoSuchChatRequestException;

	/**
	 * Returns the last chat request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	public ChatRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
			orderByComparator);

	/**
	 * Returns the chat requests before and after the current chat request in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current chat request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat request
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	public ChatRequest[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
				orderByComparator)
		throws NoSuchChatRequestException;

	/**
	 * Removes all the chat requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of chat requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching chat requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the chat requests where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @return the matching chat requests
	 */
	public java.util.List<ChatRequest> findByIsAccested(boolean isAccepted);

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
	public java.util.List<ChatRequest> findByIsAccested(
		boolean isAccepted, int start, int end);

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
	public java.util.List<ChatRequest> findByIsAccested(
		boolean isAccepted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
			orderByComparator);

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
	public java.util.List<ChatRequest> findByIsAccested(
		boolean isAccepted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	public ChatRequest findByIsAccested_First(
			boolean isAccepted,
			com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
				orderByComparator)
		throws NoSuchChatRequestException;

	/**
	 * Returns the first chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	public ChatRequest fetchByIsAccested_First(
		boolean isAccepted,
		com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
			orderByComparator);

	/**
	 * Returns the last chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request
	 * @throws NoSuchChatRequestException if a matching chat request could not be found
	 */
	public ChatRequest findByIsAccested_Last(
			boolean isAccepted,
			com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
				orderByComparator)
		throws NoSuchChatRequestException;

	/**
	 * Returns the last chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chat request, or <code>null</code> if a matching chat request could not be found
	 */
	public ChatRequest fetchByIsAccested_Last(
		boolean isAccepted,
		com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
			orderByComparator);

	/**
	 * Returns the chat requests before and after the current chat request in the ordered set where isAccepted = &#63;.
	 *
	 * @param id the primary key of the current chat request
	 * @param isAccepted the is accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chat request
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	public ChatRequest[] findByIsAccested_PrevAndNext(
			long id, boolean isAccepted,
			com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
				orderByComparator)
		throws NoSuchChatRequestException;

	/**
	 * Removes all the chat requests where isAccepted = &#63; from the database.
	 *
	 * @param isAccepted the is accepted
	 */
	public void removeByIsAccested(boolean isAccepted);

	/**
	 * Returns the number of chat requests where isAccepted = &#63;.
	 *
	 * @param isAccepted the is accepted
	 * @return the number of matching chat requests
	 */
	public int countByIsAccested(boolean isAccepted);

	/**
	 * Caches the chat request in the entity cache if it is enabled.
	 *
	 * @param chatRequest the chat request
	 */
	public void cacheResult(ChatRequest chatRequest);

	/**
	 * Caches the chat requests in the entity cache if it is enabled.
	 *
	 * @param chatRequests the chat requests
	 */
	public void cacheResult(java.util.List<ChatRequest> chatRequests);

	/**
	 * Creates a new chat request with the primary key. Does not add the chat request to the database.
	 *
	 * @param id the primary key for the new chat request
	 * @return the new chat request
	 */
	public ChatRequest create(long id);

	/**
	 * Removes the chat request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chat request
	 * @return the chat request that was removed
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	public ChatRequest remove(long id) throws NoSuchChatRequestException;

	public ChatRequest updateImpl(ChatRequest chatRequest);

	/**
	 * Returns the chat request with the primary key or throws a <code>NoSuchChatRequestException</code> if it could not be found.
	 *
	 * @param id the primary key of the chat request
	 * @return the chat request
	 * @throws NoSuchChatRequestException if a chat request with the primary key could not be found
	 */
	public ChatRequest findByPrimaryKey(long id)
		throws NoSuchChatRequestException;

	/**
	 * Returns the chat request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chat request
	 * @return the chat request, or <code>null</code> if a chat request with the primary key could not be found
	 */
	public ChatRequest fetchByPrimaryKey(long id);

	/**
	 * Returns all the chat requests.
	 *
	 * @return the chat requests
	 */
	public java.util.List<ChatRequest> findAll();

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
	public java.util.List<ChatRequest> findAll(int start, int end);

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
	public java.util.List<ChatRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
			orderByComparator);

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
	public java.util.List<ChatRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChatRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the chat requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of chat requests.
	 *
	 * @return the number of chat requests
	 */
	public int countAll();

}