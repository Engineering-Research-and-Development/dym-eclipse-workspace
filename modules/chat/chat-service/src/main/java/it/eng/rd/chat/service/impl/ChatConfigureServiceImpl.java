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

package it.eng.rd.chat.service.impl;

import com.liferay.portal.aop.AopService;

import it.eng.rd.chat.service.base.ChatConfigureServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the chat configure remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.chat.service.ChatConfigureService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatConfigureServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=dym",
		"json.web.service.context.path=ChatConfigure"
	},
	service = AopService.class
)
public class ChatConfigureServiceImpl extends ChatConfigureServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.rd.chat.service.ChatConfigureServiceUtil</code> to access the chat configure remote service.
	 */
}