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
 * This class is a wrapper for {@link Challenge}.
 * </p>
 *
 * @author ENGRD
 * @see Challenge
 * @generated
 */
public class ChallengeWrapper
	extends BaseModelWrapper<Challenge>
	implements Challenge, ModelWrapper<Challenge> {

	public ChallengeWrapper(Challenge challenge) {
		super(challenge);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("challengeId", getChallengeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("desiredOutcome", getDesiredOutcome());
		attributes.put("additionalInformation", getAdditionalInformation());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("dlFolderName", getDlFolderName());
		attributes.put("dlFolderId", getDlFolderId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("active", isActive());

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

		String desiredOutcome = (String)attributes.get("desiredOutcome");

		if (desiredOutcome != null) {
			setDesiredOutcome(desiredOutcome);
		}

		String additionalInformation = (String)attributes.get(
			"additionalInformation");

		if (additionalInformation != null) {
			setAdditionalInformation(additionalInformation);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String dlFolderName = (String)attributes.get("dlFolderName");

		if (dlFolderName != null) {
			setDlFolderName(dlFolderName);
		}

		Long dlFolderId = (Long)attributes.get("dlFolderId");

		if (dlFolderId != null) {
			setDlFolderId(dlFolderId);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the active of this challenge.
	 *
	 * @return the active of this challenge
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the additional information of this challenge.
	 *
	 * @return the additional information of this challenge
	 */
	@Override
	public String getAdditionalInformation() {
		return model.getAdditionalInformation();
	}

	/**
	 * Returns the challenge ID of this challenge.
	 *
	 * @return the challenge ID of this challenge
	 */
	@Override
	public long getChallengeId() {
		return model.getChallengeId();
	}

	/**
	 * Returns the company ID of this challenge.
	 *
	 * @return the company ID of this challenge
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this challenge.
	 *
	 * @return the create date of this challenge
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this challenge.
	 *
	 * @return the description of this challenge
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the desired outcome of this challenge.
	 *
	 * @return the desired outcome of this challenge
	 */
	@Override
	public String getDesiredOutcome() {
		return model.getDesiredOutcome();
	}

	/**
	 * Returns the dl folder ID of this challenge.
	 *
	 * @return the dl folder ID of this challenge
	 */
	@Override
	public long getDlFolderId() {
		return model.getDlFolderId();
	}

	/**
	 * Returns the dl folder name of this challenge.
	 *
	 * @return the dl folder name of this challenge
	 */
	@Override
	public String getDlFolderName() {
		return model.getDlFolderName();
	}

	/**
	 * Returns the end date of this challenge.
	 *
	 * @return the end date of this challenge
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this challenge.
	 *
	 * @return the group ID of this challenge
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this challenge.
	 *
	 * @return the modified date of this challenge
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this challenge.
	 *
	 * @return the mvcc version of this challenge
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this challenge.
	 *
	 * @return the primary key of this challenge
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this challenge.
	 *
	 * @return the start date of this challenge
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this challenge.
	 *
	 * @return the status of this challenge
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this challenge.
	 *
	 * @return the status by user ID of this challenge
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this challenge.
	 *
	 * @return the status by user name of this challenge
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this challenge.
	 *
	 * @return the status by user uuid of this challenge
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this challenge.
	 *
	 * @return the status date of this challenge
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this challenge.
	 *
	 * @return the title of this challenge
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this challenge.
	 *
	 * @return the user ID of this challenge
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this challenge.
	 *
	 * @return the user name of this challenge
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this challenge.
	 *
	 * @return the user uuid of this challenge
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this challenge.
	 *
	 * @return the uuid of this challenge
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this challenge is active.
	 *
	 * @return <code>true</code> if this challenge is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	/**
	 * Returns <code>true</code> if this challenge is approved.
	 *
	 * @return <code>true</code> if this challenge is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this challenge is denied.
	 *
	 * @return <code>true</code> if this challenge is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this challenge is a draft.
	 *
	 * @return <code>true</code> if this challenge is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this challenge is expired.
	 *
	 * @return <code>true</code> if this challenge is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this challenge is inactive.
	 *
	 * @return <code>true</code> if this challenge is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this challenge is incomplete.
	 *
	 * @return <code>true</code> if this challenge is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this challenge is pending.
	 *
	 * @return <code>true</code> if this challenge is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this challenge is scheduled.
	 *
	 * @return <code>true</code> if this challenge is scheduled; <code>false</code> otherwise
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
	 * Sets whether this challenge is active.
	 *
	 * @param active the active of this challenge
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the additional information of this challenge.
	 *
	 * @param additionalInformation the additional information of this challenge
	 */
	@Override
	public void setAdditionalInformation(String additionalInformation) {
		model.setAdditionalInformation(additionalInformation);
	}

	/**
	 * Sets the challenge ID of this challenge.
	 *
	 * @param challengeId the challenge ID of this challenge
	 */
	@Override
	public void setChallengeId(long challengeId) {
		model.setChallengeId(challengeId);
	}

	/**
	 * Sets the company ID of this challenge.
	 *
	 * @param companyId the company ID of this challenge
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this challenge.
	 *
	 * @param createDate the create date of this challenge
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this challenge.
	 *
	 * @param description the description of this challenge
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the desired outcome of this challenge.
	 *
	 * @param desiredOutcome the desired outcome of this challenge
	 */
	@Override
	public void setDesiredOutcome(String desiredOutcome) {
		model.setDesiredOutcome(desiredOutcome);
	}

	/**
	 * Sets the dl folder ID of this challenge.
	 *
	 * @param dlFolderId the dl folder ID of this challenge
	 */
	@Override
	public void setDlFolderId(long dlFolderId) {
		model.setDlFolderId(dlFolderId);
	}

	/**
	 * Sets the dl folder name of this challenge.
	 *
	 * @param dlFolderName the dl folder name of this challenge
	 */
	@Override
	public void setDlFolderName(String dlFolderName) {
		model.setDlFolderName(dlFolderName);
	}

	/**
	 * Sets the end date of this challenge.
	 *
	 * @param endDate the end date of this challenge
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this challenge.
	 *
	 * @param groupId the group ID of this challenge
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this challenge.
	 *
	 * @param modifiedDate the modified date of this challenge
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this challenge.
	 *
	 * @param mvccVersion the mvcc version of this challenge
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this challenge.
	 *
	 * @param primaryKey the primary key of this challenge
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this challenge.
	 *
	 * @param startDate the start date of this challenge
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this challenge.
	 *
	 * @param status the status of this challenge
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this challenge.
	 *
	 * @param statusByUserId the status by user ID of this challenge
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this challenge.
	 *
	 * @param statusByUserName the status by user name of this challenge
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this challenge.
	 *
	 * @param statusByUserUuid the status by user uuid of this challenge
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this challenge.
	 *
	 * @param statusDate the status date of this challenge
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this challenge.
	 *
	 * @param title the title of this challenge
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this challenge.
	 *
	 * @param userId the user ID of this challenge
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this challenge.
	 *
	 * @param userName the user name of this challenge
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this challenge.
	 *
	 * @param userUuid the user uuid of this challenge
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this challenge.
	 *
	 * @param uuid the uuid of this challenge
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
	protected ChallengeWrapper wrap(Challenge challenge) {
		return new ChallengeWrapper(challenge);
	}

}