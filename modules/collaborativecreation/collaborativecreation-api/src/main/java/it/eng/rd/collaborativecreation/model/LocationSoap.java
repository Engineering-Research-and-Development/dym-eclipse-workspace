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

package it.eng.rd.collaborativecreation.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.rd.collaborativecreation.service.http.LocationServiceSoap}.
 *
 * @author ENGRD
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class LocationSoap implements Serializable {

	public static LocationSoap toSoapModel(Location model) {
		LocationSoap soapModel = new LocationSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setChallengeId(model.getChallengeId());
		soapModel.setName(model.getName());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());

		return soapModel;
	}

	public static LocationSoap[] toSoapModels(Location[] models) {
		LocationSoap[] soapModels = new LocationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LocationSoap[][] toSoapModels(Location[][] models) {
		LocationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LocationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LocationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LocationSoap[] toSoapModels(List<Location> models) {
		List<LocationSoap> soapModels = new ArrayList<LocationSoap>(
			models.size());

		for (Location model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LocationSoap[soapModels.size()]);
	}

	public LocationSoap() {
	}

	public long getPrimaryKey() {
		return _locationId;
	}

	public void setPrimaryKey(long pk) {
		setLocationId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public long getChallengeId() {
		return _challengeId;
	}

	public void setChallengeId(long challengeId) {
		_challengeId = challengeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getLatitude() {
		return _latitude;
	}

	public void setLatitude(String latitude) {
		_latitude = latitude;
	}

	public String getLongitude() {
		return _longitude;
	}

	public void setLongitude(String longitude) {
		_longitude = longitude;
	}

	private long _mvccVersion;
	private long _locationId;
	private long _challengeId;
	private String _name;
	private String _latitude;
	private String _longitude;

}