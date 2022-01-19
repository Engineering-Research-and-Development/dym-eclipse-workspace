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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Activity service. Represents a row in the &quot;COCREATION_Activity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.rd.collaborativecreation.model.impl.ActivityModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.rd.collaborativecreation.model.impl.ActivityImpl</code>.
 * </p>
 *
 * @author ENGRD
 * @see Activity
 * @generated
 */
@ProviderType
public interface ActivityModel extends BaseModel<Activity>, MVCCModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a activity model instance should use the {@link Activity} interface instead.
	 */

	/**
	 * Returns the primary key of this activity.
	 *
	 * @return the primary key of this activity
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this activity.
	 *
	 * @param primaryKey the primary key of this activity
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this activity.
	 *
	 * @return the mvcc version of this activity
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this activity.
	 *
	 * @param mvccVersion the mvcc version of this activity
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the activity ID of this activity.
	 *
	 * @return the activity ID of this activity
	 */
	public long getActivityId();

	/**
	 * Sets the activity ID of this activity.
	 *
	 * @param activityId the activity ID of this activity
	 */
	public void setActivityId(long activityId);

	/**
	 * Returns the description of this activity.
	 *
	 * @return the description of this activity
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this activity.
	 *
	 * @param description the description of this activity
	 */
	public void setDescription(String description);

	/**
	 * Returns the cocreation ID of this activity.
	 *
	 * @return the cocreation ID of this activity
	 */
	public long getCocreationId();

	/**
	 * Sets the cocreation ID of this activity.
	 *
	 * @param cocreationId the cocreation ID of this activity
	 */
	public void setCocreationId(long cocreationId);

}