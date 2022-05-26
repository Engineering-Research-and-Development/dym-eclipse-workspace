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

package it.eng.rd.sandbox.request.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * Provides the remote service utility for Sandbox. This utility wraps
 * <code>it.eng.rd.sandbox.request.service.impl.SandboxServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SandboxService
 * @generated
 */
public class SandboxServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.rd.sandbox.request.service.impl.SandboxServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONObject getSendModel(
			String m_id, String t_id)
		throws PortalException, SystemException {

		return getService().getSendModel(m_id, t_id);
	}

	public static com.liferay.portal.kernel.json.JSONObject getSendName()
		throws PortalException, SystemException {

		return getService().getSendName();
	}

	public static com.liferay.portal.kernel.json.JSONObject getSendTool(
			String t_id)
		throws PortalException, SystemException {

		return getService().getSendTool(t_id);
	}

	public static SandboxService getService() {
		return _service;
	}

	private static volatile SandboxService _service;

}