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

package it.eng.rd.dymer.service;

import it.eng.rd.dymer.model.DymerEntry;

/**
 * Provides the remote service utility for DymerEntry. This utility wraps
 * <code>it.eng.rd.dymer.service.impl.DymerEntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author ENGRD
 * @see DymerEntryService
 * @generated
 */
public class DymerEntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.rd.dymer.service.impl.DymerEntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	@Deprecated
	public static void delete(
		long userId, String index, String type, String id) {

		getService().delete(userId, index, type, id);
	}

	public static void delete(
		String emailAddress, long companyId, String index, String type,
		String id) {

		getService().delete(emailAddress, companyId, index, type, id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONObject getUserInfoByEmail(
		String emailAddress, long companyId) {

		return getService().getUserInfoByEmail(emailAddress, companyId);
	}

	/**
	 * Old remote services
	 */
	@Deprecated
	public static DymerEntry update(
		long userId, long groupId, String index, String type, String id,
		String url, String title, String extContent) {

		return getService().update(
			userId, groupId, index, type, id, url, title, extContent);
	}

	public static DymerEntry update(
		String dymerDomainName, String emailAddress, long companyId,
		long groupId, String index, String type, String id, String url,
		String title, String extContent) {

		return getService().update(
			dymerDomainName, emailAddress, companyId, groupId, index, type, id,
			url, title, extContent);
	}

	public static DymerEntryService getService() {
		return _service;
	}

	private static volatile DymerEntryService _service;

}