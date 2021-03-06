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

package it.eng.rd.dymer.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Dymer service. Represents a row in the &quot;DYM_Dymer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.rd.dymer.model.impl.DymerModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.rd.dymer.model.impl.DymerImpl</code>.
 * </p>
 *
 * @author ENGRD
 * @see Dymer
 * @generated
 */
@ProviderType
public interface DymerModel
	extends BaseModel<Dymer>, GroupedModel, MVCCModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dymer model instance should use the {@link Dymer} interface instead.
	 */

	/**
	 * Returns the primary key of this dymer.
	 *
	 * @return the primary key of this dymer
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dymer.
	 *
	 * @param primaryKey the primary key of this dymer
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this dymer.
	 *
	 * @return the mvcc version of this dymer
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this dymer.
	 *
	 * @param mvccVersion the mvcc version of this dymer
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this dymer.
	 *
	 * @return the uuid of this dymer
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this dymer.
	 *
	 * @param uuid the uuid of this dymer
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the dymer ID of this dymer.
	 *
	 * @return the dymer ID of this dymer
	 */
	public long getDymerId();

	/**
	 * Sets the dymer ID of this dymer.
	 *
	 * @param dymerId the dymer ID of this dymer
	 */
	public void setDymerId(long dymerId);

	/**
	 * Returns the name of this dymer.
	 *
	 * @return the name of this dymer
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this dymer.
	 *
	 * @param name the name of this dymer
	 */
	public void setName(String name);

	/**
	 * Returns the group ID of this dymer.
	 *
	 * @return the group ID of this dymer
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this dymer.
	 *
	 * @param groupId the group ID of this dymer
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this dymer.
	 *
	 * @return the company ID of this dymer
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this dymer.
	 *
	 * @param companyId the company ID of this dymer
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this dymer.
	 *
	 * @return the user ID of this dymer
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this dymer.
	 *
	 * @param userId the user ID of this dymer
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dymer.
	 *
	 * @return the user uuid of this dymer
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dymer.
	 *
	 * @param userUuid the user uuid of this dymer
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dymer.
	 *
	 * @return the user name of this dymer
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this dymer.
	 *
	 * @param userName the user name of this dymer
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dymer.
	 *
	 * @return the create date of this dymer
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this dymer.
	 *
	 * @param createDate the create date of this dymer
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dymer.
	 *
	 * @return the modified date of this dymer
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dymer.
	 *
	 * @param modifiedDate the modified date of this dymer
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this dymer.
	 *
	 * @return the status of this dymer
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this dymer.
	 *
	 * @param status the status of this dymer
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this dymer.
	 *
	 * @return the status by user ID of this dymer
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this dymer.
	 *
	 * @param statusByUserId the status by user ID of this dymer
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this dymer.
	 *
	 * @return the status by user uuid of this dymer
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this dymer.
	 *
	 * @param statusByUserUuid the status by user uuid of this dymer
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this dymer.
	 *
	 * @return the status by user name of this dymer
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this dymer.
	 *
	 * @param statusByUserName the status by user name of this dymer
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this dymer.
	 *
	 * @return the status date of this dymer
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this dymer.
	 *
	 * @param statusDate the status date of this dymer
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this dymer is approved.
	 *
	 * @return <code>true</code> if this dymer is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this dymer is denied.
	 *
	 * @return <code>true</code> if this dymer is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this dymer is a draft.
	 *
	 * @return <code>true</code> if this dymer is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this dymer is expired.
	 *
	 * @return <code>true</code> if this dymer is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this dymer is inactive.
	 *
	 * @return <code>true</code> if this dymer is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this dymer is incomplete.
	 *
	 * @return <code>true</code> if this dymer is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this dymer is pending.
	 *
	 * @return <code>true</code> if this dymer is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this dymer is scheduled.
	 *
	 * @return <code>true</code> if this dymer is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

}