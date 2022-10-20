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

package it.eng.rd.collaborativecreation.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.eng.rd.collaborativecreation.exception.NoSuchCategoryException;
import it.eng.rd.collaborativecreation.exception.NoSuchLocationException;
import it.eng.rd.collaborativecreation.model.Category;
import it.eng.rd.collaborativecreation.model.Cocreation;
import it.eng.rd.collaborativecreation.model.Location;
import it.eng.rd.collaborativecreation.service.base.LocationLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the location local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.rd.collaborativecreation.service.LocationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ENGRD
 * @see LocationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=it.eng.rd.collaborativecreation.model.Location",
	service = AopService.class
)
public class LocationLocalServiceImpl extends LocationLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public Location addLocation(
			long challengeId,
			String name,
			String latitude,
			String longitude,
			ServiceContext serviceContext
	)
		throws PortalException {
		
		_log.info("LocationLocalServiceImpl - addLocation method");

		
		long locationId = counterLocalService.increment();

		Location location = locationPersistence.create(locationId);

		location.setLocationId(locationId);
		location.setChallengeId(challengeId);
		location.setName(name);
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		
		_log.info("challengeId: " +challengeId);
		_log.info("name: " +name);
		_log.info("latitude: " +latitude);
		_log.info("longitude: " +longitude);
		
		location = locationPersistence.update(location);
		
		return location;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Location updateLocation(
			long challengeId,
			String name,
			String latitude,
			String longitude,
			ServiceContext serviceContext
	)
		throws PortalException, SystemException {
		
		_log.info("LocationLocalServiceImpl - updateLocation method");

		Location location = locationPersistence.findByChallenge(challengeId);
		
		location.setName(name);
		location.setLatitude(latitude);
		location.setLongitude(longitude);
		
		_log.info("challengeId: " +challengeId);
		_log.info("name: " +name);
		_log.info("latitude: " +latitude);
		_log.info("longitude: " +longitude);
		
		location = locationPersistence.update(location);
	
		return location;
	}
	
	public Location getLocation(long challengeId, String name) throws PortalException {
    	_log.info("LocationLocalServiceImpl - getLocationByName method");
		_log.info("challengeId "+challengeId);
		_log.info("name "+name);
		
		try {
			return locationPersistence.findByName(challengeId, name);
		} catch (NoSuchLocationException e) {
			return null;
		}
    }
	
	public Location getLocationByChallengeId(long challengeId) throws PortalException {
    	_log.info("LocationLocalServiceImpl - getLocationByChallengeId method");
		_log.info("challengeId "+challengeId);
		
		return locationPersistence.findByChallenge(challengeId);
    }
	
	public void deleteLocationByChallengeId(long challengeId) throws PortalException {
    	_log.info("LocationLocalServiceImpl - deleteLocationByChallengeId method");
		_log.info("challengeId "+challengeId);
		
		locationPersistence.removeByChallenge(challengeId);
    }
	
	private static final Log _log = LogFactoryUtil.getLog(LocationLocalServiceImpl.class);
}