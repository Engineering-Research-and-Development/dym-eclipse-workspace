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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SandboxService}.
 *
 * @author Brian Wing Shun Chan
 * @see SandboxService
 * @generated
 */
public class SandboxServiceWrapper
	implements SandboxService, ServiceWrapper<SandboxService> {

	public SandboxServiceWrapper(SandboxService sandboxService) {
		_sandboxService = sandboxService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sandboxService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getSendModel(
			String m_id, String t_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _sandboxService.getSendModel(m_id, t_id);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getSendName()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _sandboxService.getSendName();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getSendTool(String t_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _sandboxService.getSendTool(t_id);
	}

	@Override
	public SandboxService getWrappedService() {
		return _sandboxService;
	}

	@Override
	public void setWrappedService(SandboxService sandboxService) {
		_sandboxService = sandboxService;
	}

	private SandboxService _sandboxService;

}