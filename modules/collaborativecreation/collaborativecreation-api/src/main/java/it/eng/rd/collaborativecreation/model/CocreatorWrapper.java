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
 * This class is a wrapper for {@link Cocreator}.
 * </p>
 *
 * @author ENGRD
 * @see Cocreator
 * @generated
 */
public class CocreatorWrapper
	extends BaseModelWrapper<Cocreator>
	implements Cocreator, ModelWrapper<Cocreator> {

	public CocreatorWrapper(Cocreator cocreator) {
		super(cocreator);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("cocreatorId", getCocreatorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("cocreationId", getCocreationId());

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

		Long cocreatorId = (Long)attributes.get("cocreatorId");

		if (cocreatorId != null) {
			setCocreatorId(cocreatorId);
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

		Long cocreationId = (Long)attributes.get("cocreationId");

		if (cocreationId != null) {
			setCocreationId(cocreationId);
		}
	}

	/**
	 * Returns the cocreation ID of this cocreator.
	 *
	 * @return the cocreation ID of this cocreator
	 */
	@Override
	public long getCocreationId() {
		return model.getCocreationId();
	}

	/**
	 * Returns the cocreator ID of this cocreator.
	 *
	 * @return the cocreator ID of this cocreator
	 */
	@Override
	public long getCocreatorId() {
		return model.getCocreatorId();
	}

	/**
	 * Returns the company ID of this cocreator.
	 *
	 * @return the company ID of this cocreator
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this cocreator.
	 *
	 * @return the group ID of this cocreator
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mvcc version of this cocreator.
	 *
	 * @return the mvcc version of this cocreator
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this cocreator.
	 *
	 * @return the primary key of this cocreator
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this cocreator.
	 *
	 * @return the user ID of this cocreator
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this cocreator.
	 *
	 * @return the user name of this cocreator
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this cocreator.
	 *
	 * @return the user uuid of this cocreator
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this cocreator.
	 *
	 * @return the uuid of this cocreator
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cocreation ID of this cocreator.
	 *
	 * @param cocreationId the cocreation ID of this cocreator
	 */
	@Override
	public void setCocreationId(long cocreationId) {
		model.setCocreationId(cocreationId);
	}

	/**
	 * Sets the cocreator ID of this cocreator.
	 *
	 * @param cocreatorId the cocreator ID of this cocreator
	 */
	@Override
	public void setCocreatorId(long cocreatorId) {
		model.setCocreatorId(cocreatorId);
	}

	/**
	 * Sets the company ID of this cocreator.
	 *
	 * @param companyId the company ID of this cocreator
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this cocreator.
	 *
	 * @param groupId the group ID of this cocreator
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mvcc version of this cocreator.
	 *
	 * @param mvccVersion the mvcc version of this cocreator
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this cocreator.
	 *
	 * @param primaryKey the primary key of this cocreator
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this cocreator.
	 *
	 * @param userId the user ID of this cocreator
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this cocreator.
	 *
	 * @param userName the user name of this cocreator
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this cocreator.
	 *
	 * @param userUuid the user uuid of this cocreator
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this cocreator.
	 *
	 * @param uuid the uuid of this cocreator
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CocreatorWrapper wrap(Cocreator cocreator) {
		return new CocreatorWrapper(cocreator);
	}

}