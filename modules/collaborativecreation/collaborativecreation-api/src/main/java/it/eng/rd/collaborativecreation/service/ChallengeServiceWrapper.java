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

package it.eng.rd.collaborativecreation.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ChallengeService}.
 *
 * @author ENGRD
 * @see ChallengeService
 * @generated
 */
public class ChallengeServiceWrapper
	implements ChallengeService, ServiceWrapper<ChallengeService> {

	public ChallengeServiceWrapper(ChallengeService challengeService) {
		_challengeService = challengeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _challengeService.getOSGiServiceIdentifier();
	}

	@Override
	public ChallengeService getWrappedService() {
		return _challengeService;
	}

	@Override
	public void setWrappedService(ChallengeService challengeService) {
		_challengeService = challengeService;
	}

	private ChallengeService _challengeService;

}