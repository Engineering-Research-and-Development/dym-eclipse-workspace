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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Activity}.
 * </p>
 *
 * @author ENGRD
 * @see Activity
 * @generated
 */
public class ActivityWrapper
	extends BaseModelWrapper<Activity>
	implements Activity, ModelWrapper<Activity> {

	public ActivityWrapper(Activity activity) {
		super(activity);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("activityId", getActivityId());
		attributes.put("description", getDescription());
		attributes.put("cocreationId", getCocreationId());
		attributes.put("expirationDate", getExpirationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long cocreationId = (Long)attributes.get("cocreationId");

		if (cocreationId != null) {
			setCocreationId(cocreationId);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}
	}

	/**
	 * Returns the activity ID of this activity.
	 *
	 * @return the activity ID of this activity
	 */
	@Override
	public long getActivityId() {
		return model.getActivityId();
	}

	/**
	 * Returns the cocreation ID of this activity.
	 *
	 * @return the cocreation ID of this activity
	 */
	@Override
	public long getCocreationId() {
		return model.getCocreationId();
	}

	/**
	 * Returns the description of this activity.
	 *
	 * @return the description of this activity
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the expiration date of this activity.
	 *
	 * @return the expiration date of this activity
	 */
	@Override
	public Date getExpirationDate() {
		return model.getExpirationDate();
	}

	/**
	 * Returns the mvcc version of this activity.
	 *
	 * @return the mvcc version of this activity
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this activity.
	 *
	 * @return the primary key of this activity
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
	 * Sets the activity ID of this activity.
	 *
	 * @param activityId the activity ID of this activity
	 */
	@Override
	public void setActivityId(long activityId) {
		model.setActivityId(activityId);
	}

	/**
	 * Sets the cocreation ID of this activity.
	 *
	 * @param cocreationId the cocreation ID of this activity
	 */
	@Override
	public void setCocreationId(long cocreationId) {
		model.setCocreationId(cocreationId);
	}

	/**
	 * Sets the description of this activity.
	 *
	 * @param description the description of this activity
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the expiration date of this activity.
	 *
	 * @param expirationDate the expiration date of this activity
	 */
	@Override
	public void setExpirationDate(Date expirationDate) {
		model.setExpirationDate(expirationDate);
	}

	/**
	 * Sets the mvcc version of this activity.
	 *
	 * @param mvccVersion the mvcc version of this activity
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this activity.
	 *
	 * @param primaryKey the primary key of this activity
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ActivityWrapper wrap(Activity activity) {
		return new ActivityWrapper(activity);
	}

}