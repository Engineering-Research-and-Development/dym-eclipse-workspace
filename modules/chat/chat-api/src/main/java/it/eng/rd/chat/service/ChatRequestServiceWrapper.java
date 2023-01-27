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

package it.eng.rd.chat.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ChatRequestService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChatRequestService
 * @generated
 */
public class ChatRequestServiceWrapper
	implements ChatRequestService, ServiceWrapper<ChatRequestService> {

	public ChatRequestServiceWrapper(ChatRequestService chatRequestService) {
		_chatRequestService = chatRequestService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chatRequestService.getOSGiServiceIdentifier();
	}

	@Override
	public String getUsersFF(
		long scopeGroupId, long siteGroupId, long companyId, long userId,
		String portraitURL) {

		return _chatRequestService.getUsersFF(
			scopeGroupId, siteGroupId, companyId, userId, portraitURL);
	}

	@Override
	public ChatRequestService getWrappedService() {
		return _chatRequestService;
	}

	@Override
	public void setWrappedService(ChatRequestService chatRequestService) {
		_chatRequestService = chatRequestService;
	}

	private ChatRequestService _chatRequestService;

}