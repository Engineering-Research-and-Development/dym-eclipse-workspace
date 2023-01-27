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

package it.eng.rd.chat.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChatRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatRequest
 * @generated
 */
public class ChatRequestWrapper
	extends BaseModelWrapper<ChatRequest>
	implements ChatRequest, ModelWrapper<ChatRequest> {

	public ChatRequestWrapper(ChatRequest chatRequest) {
		super(chatRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("fromUserId", getFromUserId());
		attributes.put("toUserId", getToUserId());
		attributes.put("isAccepted", isIsAccepted());
		attributes.put("isRejected", isIsRejected());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long fromUserId = (Long)attributes.get("fromUserId");

		if (fromUserId != null) {
			setFromUserId(fromUserId);
		}

		Long toUserId = (Long)attributes.get("toUserId");

		if (toUserId != null) {
			setToUserId(toUserId);
		}

		Boolean isAccepted = (Boolean)attributes.get("isAccepted");

		if (isAccepted != null) {
			setIsAccepted(isAccepted);
		}

		Boolean isRejected = (Boolean)attributes.get("isRejected");

		if (isRejected != null) {
			setIsRejected(isRejected);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the create date of this chat request.
	 *
	 * @return the create date of this chat request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the from user ID of this chat request.
	 *
	 * @return the from user ID of this chat request
	 */
	@Override
	public long getFromUserId() {
		return model.getFromUserId();
	}

	/**
	 * Returns the from user uuid of this chat request.
	 *
	 * @return the from user uuid of this chat request
	 */
	@Override
	public String getFromUserUuid() {
		return model.getFromUserUuid();
	}

	/**
	 * Returns the ID of this chat request.
	 *
	 * @return the ID of this chat request
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the is accepted of this chat request.
	 *
	 * @return the is accepted of this chat request
	 */
	@Override
	public boolean getIsAccepted() {
		return model.getIsAccepted();
	}

	/**
	 * Returns the is rejected of this chat request.
	 *
	 * @return the is rejected of this chat request
	 */
	@Override
	public boolean getIsRejected() {
		return model.getIsRejected();
	}

	/**
	 * Returns the modified date of this chat request.
	 *
	 * @return the modified date of this chat request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this chat request.
	 *
	 * @return the primary key of this chat request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the to user ID of this chat request.
	 *
	 * @return the to user ID of this chat request
	 */
	@Override
	public long getToUserId() {
		return model.getToUserId();
	}

	/**
	 * Returns the to user uuid of this chat request.
	 *
	 * @return the to user uuid of this chat request
	 */
	@Override
	public String getToUserUuid() {
		return model.getToUserUuid();
	}

	/**
	 * Returns the uuid of this chat request.
	 *
	 * @return the uuid of this chat request
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this chat request is is accepted.
	 *
	 * @return <code>true</code> if this chat request is is accepted; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsAccepted() {
		return model.isIsAccepted();
	}

	/**
	 * Returns <code>true</code> if this chat request is is rejected.
	 *
	 * @return <code>true</code> if this chat request is is rejected; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsRejected() {
		return model.isIsRejected();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this chat request.
	 *
	 * @param createDate the create date of this chat request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the from user ID of this chat request.
	 *
	 * @param fromUserId the from user ID of this chat request
	 */
	@Override
	public void setFromUserId(long fromUserId) {
		model.setFromUserId(fromUserId);
	}

	/**
	 * Sets the from user uuid of this chat request.
	 *
	 * @param fromUserUuid the from user uuid of this chat request
	 */
	@Override
	public void setFromUserUuid(String fromUserUuid) {
		model.setFromUserUuid(fromUserUuid);
	}

	/**
	 * Sets the ID of this chat request.
	 *
	 * @param id the ID of this chat request
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets whether this chat request is is accepted.
	 *
	 * @param isAccepted the is accepted of this chat request
	 */
	@Override
	public void setIsAccepted(boolean isAccepted) {
		model.setIsAccepted(isAccepted);
	}

	/**
	 * Sets whether this chat request is is rejected.
	 *
	 * @param isRejected the is rejected of this chat request
	 */
	@Override
	public void setIsRejected(boolean isRejected) {
		model.setIsRejected(isRejected);
	}

	/**
	 * Sets the modified date of this chat request.
	 *
	 * @param modifiedDate the modified date of this chat request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this chat request.
	 *
	 * @param primaryKey the primary key of this chat request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the to user ID of this chat request.
	 *
	 * @param toUserId the to user ID of this chat request
	 */
	@Override
	public void setToUserId(long toUserId) {
		model.setToUserId(toUserId);
	}

	/**
	 * Sets the to user uuid of this chat request.
	 *
	 * @param toUserUuid the to user uuid of this chat request
	 */
	@Override
	public void setToUserUuid(String toUserUuid) {
		model.setToUserUuid(toUserUuid);
	}

	/**
	 * Sets the uuid of this chat request.
	 *
	 * @param uuid the uuid of this chat request
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ChatRequestWrapper wrap(ChatRequest chatRequest) {
		return new ChatRequestWrapper(chatRequest);
	}

}