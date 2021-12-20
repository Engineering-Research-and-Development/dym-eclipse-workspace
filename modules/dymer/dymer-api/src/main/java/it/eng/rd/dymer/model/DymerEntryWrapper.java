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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DymerEntry}.
 * </p>
 *
 * @author ENGRD
 * @see DymerEntry
 * @generated
 */
public class DymerEntryWrapper
	extends BaseModelWrapper<DymerEntry>
	implements DymerEntry, ModelWrapper<DymerEntry> {

	public DymerEntryWrapper(DymerEntry dymerEntry) {
		super(dymerEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("entryId", getEntryId());
		attributes.put("index", getIndex());
		attributes.put("type", getType());
		attributes.put("id", getId());
		attributes.put("title", getTitle());
		attributes.put("extContent", getExtContent());
		attributes.put("url", getUrl());
		attributes.put("dymerId", getDymerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
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

		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		String index = (String)attributes.get("index");

		if (index != null) {
			setIndex(index);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String extContent = (String)attributes.get("extContent");

		if (extContent != null) {
			setExtContent(extContent);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Long dymerId = (Long)attributes.get("dymerId");

		if (dymerId != null) {
			setDymerId(dymerId);
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
	 * Returns the company ID of this dymer entry.
	 *
	 * @return the company ID of this dymer entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this dymer entry.
	 *
	 * @return the create date of this dymer entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dymer ID of this dymer entry.
	 *
	 * @return the dymer ID of this dymer entry
	 */
	@Override
	public long getDymerId() {
		return model.getDymerId();
	}

	/**
	 * Returns the entry ID of this dymer entry.
	 *
	 * @return the entry ID of this dymer entry
	 */
	@Override
	public long getEntryId() {
		return model.getEntryId();
	}

	/**
	 * Returns the ext content of this dymer entry.
	 *
	 * @return the ext content of this dymer entry
	 */
	@Override
	public String getExtContent() {
		return model.getExtContent();
	}

	/**
	 * Returns the group ID of this dymer entry.
	 *
	 * @return the group ID of this dymer entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this dymer entry.
	 *
	 * @return the ID of this dymer entry
	 */
	@Override
	public String getId() {
		return model.getId();
	}

	/**
	 * Returns the index of this dymer entry.
	 *
	 * @return the index of this dymer entry
	 */
	@Override
	public String getIndex() {
		return model.getIndex();
	}

	/**
	 * Returns the modified date of this dymer entry.
	 *
	 * @return the modified date of this dymer entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this dymer entry.
	 *
	 * @return the mvcc version of this dymer entry
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this dymer entry.
	 *
	 * @return the primary key of this dymer entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this dymer entry.
	 *
	 * @return the status of this dymer entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this dymer entry.
	 *
	 * @return the status by user ID of this dymer entry
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this dymer entry.
	 *
	 * @return the status by user name of this dymer entry
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this dymer entry.
	 *
	 * @return the status by user uuid of this dymer entry
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this dymer entry.
	 *
	 * @return the status date of this dymer entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this dymer entry.
	 *
	 * @return the title of this dymer entry
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the type of this dymer entry.
	 *
	 * @return the type of this dymer entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the url of this dymer entry.
	 *
	 * @return the url of this dymer entry
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this dymer entry.
	 *
	 * @return the user ID of this dymer entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this dymer entry.
	 *
	 * @return the user name of this dymer entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this dymer entry.
	 *
	 * @return the user uuid of this dymer entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this dymer entry.
	 *
	 * @return the uuid of this dymer entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this dymer entry is approved.
	 *
	 * @return <code>true</code> if this dymer entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this dymer entry is denied.
	 *
	 * @return <code>true</code> if this dymer entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this dymer entry is a draft.
	 *
	 * @return <code>true</code> if this dymer entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this dymer entry is expired.
	 *
	 * @return <code>true</code> if this dymer entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this dymer entry is inactive.
	 *
	 * @return <code>true</code> if this dymer entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this dymer entry is incomplete.
	 *
	 * @return <code>true</code> if this dymer entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this dymer entry is pending.
	 *
	 * @return <code>true</code> if this dymer entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this dymer entry is scheduled.
	 *
	 * @return <code>true</code> if this dymer entry is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this dymer entry.
	 *
	 * @param companyId the company ID of this dymer entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this dymer entry.
	 *
	 * @param createDate the create date of this dymer entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dymer ID of this dymer entry.
	 *
	 * @param dymerId the dymer ID of this dymer entry
	 */
	@Override
	public void setDymerId(long dymerId) {
		model.setDymerId(dymerId);
	}

	/**
	 * Sets the entry ID of this dymer entry.
	 *
	 * @param entryId the entry ID of this dymer entry
	 */
	@Override
	public void setEntryId(long entryId) {
		model.setEntryId(entryId);
	}

	/**
	 * Sets the ext content of this dymer entry.
	 *
	 * @param extContent the ext content of this dymer entry
	 */
	@Override
	public void setExtContent(String extContent) {
		model.setExtContent(extContent);
	}

	/**
	 * Sets the group ID of this dymer entry.
	 *
	 * @param groupId the group ID of this dymer entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this dymer entry.
	 *
	 * @param id the ID of this dymer entry
	 */
	@Override
	public void setId(String id) {
		model.setId(id);
	}

	/**
	 * Sets the index of this dymer entry.
	 *
	 * @param index the index of this dymer entry
	 */
	@Override
	public void setIndex(String index) {
		model.setIndex(index);
	}

	/**
	 * Sets the modified date of this dymer entry.
	 *
	 * @param modifiedDate the modified date of this dymer entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this dymer entry.
	 *
	 * @param mvccVersion the mvcc version of this dymer entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this dymer entry.
	 *
	 * @param primaryKey the primary key of this dymer entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this dymer entry.
	 *
	 * @param status the status of this dymer entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this dymer entry.
	 *
	 * @param statusByUserId the status by user ID of this dymer entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this dymer entry.
	 *
	 * @param statusByUserName the status by user name of this dymer entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this dymer entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this dymer entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this dymer entry.
	 *
	 * @param statusDate the status date of this dymer entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this dymer entry.
	 *
	 * @param title the title of this dymer entry
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type of this dymer entry.
	 *
	 * @param type the type of this dymer entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the url of this dymer entry.
	 *
	 * @param url the url of this dymer entry
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this dymer entry.
	 *
	 * @param userId the user ID of this dymer entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this dymer entry.
	 *
	 * @param userName the user name of this dymer entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this dymer entry.
	 *
	 * @param userUuid the user uuid of this dymer entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this dymer entry.
	 *
	 * @param uuid the uuid of this dymer entry
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
	protected DymerEntryWrapper wrap(DymerEntry dymerEntry) {
		return new DymerEntryWrapper(dymerEntry);
	}

}