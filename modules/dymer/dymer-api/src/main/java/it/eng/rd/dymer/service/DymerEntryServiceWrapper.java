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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DymerEntryService}.
 *
 * @author ENGRD
 * @see DymerEntryService
 * @generated
 */
public class DymerEntryServiceWrapper
	implements DymerEntryService, ServiceWrapper<DymerEntryService> {

	public DymerEntryServiceWrapper(DymerEntryService dymerEntryService) {
		_dymerEntryService = dymerEntryService;
	}

	@Deprecated
	@Override
	public void delete(long userId, String index, String type, String id) {
		_dymerEntryService.delete(userId, index, type, id);
	}

	@Override
	public void delete(
		String emailAddress, long companyId, String index, String type,
		String id) {

		_dymerEntryService.delete(emailAddress, companyId, index, type, id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dymerEntryService.getOSGiServiceIdentifier();
	}

	/**
	 * Old remote services
	 */
	@Deprecated
	@Override
	public it.eng.rd.dymer.model.DymerEntry update(
		long userId, long groupId, String index, String type, String id,
		String url, String title, String extContent) {

		return _dymerEntryService.update(
			userId, groupId, index, type, id, url, title, extContent);
	}

	@Override
	public it.eng.rd.dymer.model.DymerEntry update(
		String dymerDomainName, String emailAddress, long companyId,
		long groupId, String index, String type, String id, String url,
		String title, String extContent) {

		return _dymerEntryService.update(
			dymerDomainName, emailAddress, companyId, groupId, index, type, id,
			url, title, extContent);
	}

	@Override
	public DymerEntryService getWrappedService() {
		return _dymerEntryService;
	}

	@Override
	public void setWrappedService(DymerEntryService dymerEntryService) {
		_dymerEntryService = dymerEntryService;
	}

	private DymerEntryService _dymerEntryService;

}