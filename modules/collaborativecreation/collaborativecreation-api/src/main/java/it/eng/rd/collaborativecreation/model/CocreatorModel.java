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
import com.liferay.portal.kernel.model.ShardedModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Cocreator service. Represents a row in the &quot;COCREATION_Cocreator&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.rd.collaborativecreation.model.impl.CocreatorModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.rd.collaborativecreation.model.impl.CocreatorImpl</code>.
 * </p>
 *
 * @author ENGRD
 * @see Cocreator
 * @generated
 */
@ProviderType
public interface CocreatorModel
	extends BaseModel<Cocreator>, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cocreator model instance should use the {@link Cocreator} interface instead.
	 */

	/**
	 * Returns the primary key of this cocreator.
	 *
	 * @return the primary key of this cocreator
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cocreator.
	 *
	 * @param primaryKey the primary key of this cocreator
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this cocreator.
	 *
	 * @return the mvcc version of this cocreator
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this cocreator.
	 *
	 * @param mvccVersion the mvcc version of this cocreator
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this cocreator.
	 *
	 * @return the uuid of this cocreator
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this cocreator.
	 *
	 * @param uuid the uuid of this cocreator
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the cocreator ID of this cocreator.
	 *
	 * @return the cocreator ID of this cocreator
	 */
	public long getCocreatorId();

	/**
	 * Sets the cocreator ID of this cocreator.
	 *
	 * @param cocreatorId the cocreator ID of this cocreator
	 */
	public void setCocreatorId(long cocreatorId);

	/**
	 * Returns the group ID of this cocreator.
	 *
	 * @return the group ID of this cocreator
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this cocreator.
	 *
	 * @param groupId the group ID of this cocreator
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this cocreator.
	 *
	 * @return the company ID of this cocreator
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this cocreator.
	 *
	 * @param companyId the company ID of this cocreator
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this cocreator.
	 *
	 * @return the user ID of this cocreator
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this cocreator.
	 *
	 * @param userId the user ID of this cocreator
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this cocreator.
	 *
	 * @return the user uuid of this cocreator
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this cocreator.
	 *
	 * @param userUuid the user uuid of this cocreator
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this cocreator.
	 *
	 * @return the user name of this cocreator
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this cocreator.
	 *
	 * @param userName the user name of this cocreator
	 */
	public void setUserName(String userName);

	/**
	 * Returns the cocreation ID of this cocreator.
	 *
	 * @return the cocreation ID of this cocreator
	 */
	public long getCocreationId();

	/**
	 * Sets the cocreation ID of this cocreator.
	 *
	 * @param cocreationId the cocreation ID of this cocreator
	 */
	public void setCocreationId(long cocreationId);

	/**
	 * Returns the activity ID of this cocreator.
	 *
	 * @return the activity ID of this cocreator
	 */
	public long getActivityId();

	/**
	 * Sets the activity ID of this cocreator.
	 *
	 * @param activityId the activity ID of this cocreator
	 */
	public void setActivityId(long activityId);

}