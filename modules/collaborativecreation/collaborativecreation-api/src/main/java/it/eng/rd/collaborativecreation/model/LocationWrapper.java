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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Location}.
 * </p>
 *
 * @author ENGRD
 * @see Location
 * @generated
 */
public class LocationWrapper
	extends BaseModelWrapper<Location>
	implements Location, ModelWrapper<Location> {

	public LocationWrapper(Location location) {
		super(location);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("locationId", getLocationId());
		attributes.put("challengeId", getChallengeId());
		attributes.put("name", getName());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long challengeId = (Long)attributes.get("challengeId");

		if (challengeId != null) {
			setChallengeId(challengeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}
	}

	/**
	 * Returns the challenge ID of this location.
	 *
	 * @return the challenge ID of this location
	 */
	@Override
	public long getChallengeId() {
		return model.getChallengeId();
	}

	/**
	 * Returns the latitude of this location.
	 *
	 * @return the latitude of this location
	 */
	@Override
	public String getLatitude() {
		return model.getLatitude();
	}

	/**
	 * Returns the location ID of this location.
	 *
	 * @return the location ID of this location
	 */
	@Override
	public long getLocationId() {
		return model.getLocationId();
	}

	/**
	 * Returns the longitude of this location.
	 *
	 * @return the longitude of this location
	 */
	@Override
	public String getLongitude() {
		return model.getLongitude();
	}

	/**
	 * Returns the mvcc version of this location.
	 *
	 * @return the mvcc version of this location
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this location.
	 *
	 * @return the name of this location
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this location.
	 *
	 * @return the primary key of this location
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the challenge ID of this location.
	 *
	 * @param challengeId the challenge ID of this location
	 */
	@Override
	public void setChallengeId(long challengeId) {
		model.setChallengeId(challengeId);
	}

	/**
	 * Sets the latitude of this location.
	 *
	 * @param latitude the latitude of this location
	 */
	@Override
	public void setLatitude(String latitude) {
		model.setLatitude(latitude);
	}

	/**
	 * Sets the location ID of this location.
	 *
	 * @param locationId the location ID of this location
	 */
	@Override
	public void setLocationId(long locationId) {
		model.setLocationId(locationId);
	}

	/**
	 * Sets the longitude of this location.
	 *
	 * @param longitude the longitude of this location
	 */
	@Override
	public void setLongitude(String longitude) {
		model.setLongitude(longitude);
	}

	/**
	 * Sets the mvcc version of this location.
	 *
	 * @param mvccVersion the mvcc version of this location
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this location.
	 *
	 * @param name the name of this location
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this location.
	 *
	 * @param primaryKey the primary key of this location
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected LocationWrapper wrap(Location location) {
		return new LocationWrapper(location);
	}

}