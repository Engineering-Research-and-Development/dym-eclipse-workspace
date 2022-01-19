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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Cocreation}.
 * </p>
 *
 * @author ENGRD
 * @see Cocreation
 * @generated
 */
public class CocreationWrapper
	extends BaseModelWrapper<Cocreation>
	implements Cocreation, ModelWrapper<Cocreation> {

	public CocreationWrapper(Cocreation cocreation) {
		super(cocreation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("cocreationId", getCocreationId());
		attributes.put("challengeId", getChallengeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("dlFolderName", getDlFolderName());
		attributes.put("ldFolderId", getLdFolderId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long cocreationId = (Long)attributes.get("cocreationId");

		if (cocreationId != null) {
			setCocreationId(cocreationId);
		}

		Long challengeId = (Long)attributes.get("challengeId");

		if (challengeId != null) {
			setChallengeId(challengeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String dlFolderName = (String)attributes.get("dlFolderName");

		if (dlFolderName != null) {
			setDlFolderName(dlFolderName);
		}

		Long ldFolderId = (Long)attributes.get("ldFolderId");

		if (ldFolderId != null) {
			setLdFolderId(ldFolderId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	 * Returns the challenge ID of this cocreation.
	 *
	 * @return the challenge ID of this cocreation
	 */
	@Override
	public long getChallengeId() {
		return model.getChallengeId();
	}

	/**
	 * Returns the cocreation ID of this cocreation.
	 *
	 * @return the cocreation ID of this cocreation
	 */
	@Override
	public long getCocreationId() {
		return model.getCocreationId();
	}

	/**
	 * Returns the company ID of this cocreation.
	 *
	 * @return the company ID of this cocreation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this cocreation.
	 *
	 * @return the create date of this cocreation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this cocreation.
	 *
	 * @return the description of this cocreation
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the dl folder name of this cocreation.
	 *
	 * @return the dl folder name of this cocreation
	 */
	@Override
	public String getDlFolderName() {
		return model.getDlFolderName();
	}

	/**
	 * Returns the group ID of this cocreation.
	 *
	 * @return the group ID of this cocreation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ld folder ID of this cocreation.
	 *
	 * @return the ld folder ID of this cocreation
	 */
	@Override
	public long getLdFolderId() {
		return model.getLdFolderId();
	}

	/**
	 * Returns the modified date of this cocreation.
	 *
	 * @return the modified date of this cocreation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this cocreation.
	 *
	 * @return the mvcc version of this cocreation
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this cocreation.
	 *
	 * @return the primary key of this cocreation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this cocreation.
	 *
	 * @return the status of this cocreation
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this cocreation.
	 *
	 * @return the status by user ID of this cocreation
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this cocreation.
	 *
	 * @return the status by user name of this cocreation
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this cocreation.
	 *
	 * @return the status by user uuid of this cocreation
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this cocreation.
	 *
	 * @return the status date of this cocreation
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this cocreation.
	 *
	 * @return the title of this cocreation
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this cocreation.
	 *
	 * @return the user ID of this cocreation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this cocreation.
	 *
	 * @return the user name of this cocreation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this cocreation.
	 *
	 * @return the user uuid of this cocreation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this cocreation.
	 *
	 * @return the uuid of this cocreation
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this cocreation is approved.
	 *
	 * @return <code>true</code> if this cocreation is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this cocreation is denied.
	 *
	 * @return <code>true</code> if this cocreation is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this cocreation is a draft.
	 *
	 * @return <code>true</code> if this cocreation is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this cocreation is expired.
	 *
	 * @return <code>true</code> if this cocreation is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this cocreation is inactive.
	 *
	 * @return <code>true</code> if this cocreation is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this cocreation is incomplete.
	 *
	 * @return <code>true</code> if this cocreation is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this cocreation is pending.
	 *
	 * @return <code>true</code> if this cocreation is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this cocreation is scheduled.
	 *
	 * @return <code>true</code> if this cocreation is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the challenge ID of this cocreation.
	 *
	 * @param challengeId the challenge ID of this cocreation
	 */
	@Override
	public void setChallengeId(long challengeId) {
		model.setChallengeId(challengeId);
	}

	/**
	 * Sets the cocreation ID of this cocreation.
	 *
	 * @param cocreationId the cocreation ID of this cocreation
	 */
	@Override
	public void setCocreationId(long cocreationId) {
		model.setCocreationId(cocreationId);
	}

	/**
	 * Sets the company ID of this cocreation.
	 *
	 * @param companyId the company ID of this cocreation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this cocreation.
	 *
	 * @param createDate the create date of this cocreation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this cocreation.
	 *
	 * @param description the description of this cocreation
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the dl folder name of this cocreation.
	 *
	 * @param dlFolderName the dl folder name of this cocreation
	 */
	@Override
	public void setDlFolderName(String dlFolderName) {
		model.setDlFolderName(dlFolderName);
	}

	/**
	 * Sets the group ID of this cocreation.
	 *
	 * @param groupId the group ID of this cocreation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ld folder ID of this cocreation.
	 *
	 * @param ldFolderId the ld folder ID of this cocreation
	 */
	@Override
	public void setLdFolderId(long ldFolderId) {
		model.setLdFolderId(ldFolderId);
	}

	/**
	 * Sets the modified date of this cocreation.
	 *
	 * @param modifiedDate the modified date of this cocreation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this cocreation.
	 *
	 * @param mvccVersion the mvcc version of this cocreation
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this cocreation.
	 *
	 * @param primaryKey the primary key of this cocreation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this cocreation.
	 *
	 * @param status the status of this cocreation
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this cocreation.
	 *
	 * @param statusByUserId the status by user ID of this cocreation
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this cocreation.
	 *
	 * @param statusByUserName the status by user name of this cocreation
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this cocreation.
	 *
	 * @param statusByUserUuid the status by user uuid of this cocreation
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this cocreation.
	 *
	 * @param statusDate the status date of this cocreation
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this cocreation.
	 *
	 * @param title the title of this cocreation
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this cocreation.
	 *
	 * @param userId the user ID of this cocreation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this cocreation.
	 *
	 * @param userName the user name of this cocreation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this cocreation.
	 *
	 * @param userUuid the user uuid of this cocreation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this cocreation.
	 *
	 * @param uuid the uuid of this cocreation
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CocreationWrapper wrap(Cocreation cocreation) {
		return new CocreationWrapper(cocreation);
	}

}