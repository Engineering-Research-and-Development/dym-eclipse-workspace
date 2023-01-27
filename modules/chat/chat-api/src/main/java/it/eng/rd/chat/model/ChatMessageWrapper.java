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
 * This class is a wrapper for {@link ChatMessage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatMessage
 * @generated
 */
public class ChatMessageWrapper
	extends BaseModelWrapper<ChatMessage>
	implements ChatMessage, ModelWrapper<ChatMessage> {

	public ChatMessageWrapper(ChatMessage chatMessage) {
		super(chatMessage);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("fromUser", getFromUser());
		attributes.put("toUser", getToUser());
		attributes.put("sentDate", getSentDate());
		attributes.put("readDate", getReadDate());
		attributes.put("message", getMessage());
		attributes.put("readed", isReaded());
		attributes.put("deleted", isDeleted());
		attributes.put("fileName", getFileName());
		attributes.put("fileId", getFileId());

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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long fromUser = (Long)attributes.get("fromUser");

		if (fromUser != null) {
			setFromUser(fromUser);
		}

		Long toUser = (Long)attributes.get("toUser");

		if (toUser != null) {
			setToUser(toUser);
		}

		Date sentDate = (Date)attributes.get("sentDate");

		if (sentDate != null) {
			setSentDate(sentDate);
		}

		Date readDate = (Date)attributes.get("readDate");

		if (readDate != null) {
			setReadDate(readDate);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Boolean readed = (Boolean)attributes.get("readed");

		if (readed != null) {
			setReaded(readed);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}
	}

	/**
	 * Returns the company ID of this chat message.
	 *
	 * @return the company ID of this chat message
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the deleted of this chat message.
	 *
	 * @return the deleted of this chat message
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the file ID of this chat message.
	 *
	 * @return the file ID of this chat message
	 */
	@Override
	public long getFileId() {
		return model.getFileId();
	}

	/**
	 * Returns the file name of this chat message.
	 *
	 * @return the file name of this chat message
	 */
	@Override
	public String getFileName() {
		return model.getFileName();
	}

	/**
	 * Returns the from user of this chat message.
	 *
	 * @return the from user of this chat message
	 */
	@Override
	public long getFromUser() {
		return model.getFromUser();
	}

	/**
	 * Returns the group ID of this chat message.
	 *
	 * @return the group ID of this chat message
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this chat message.
	 *
	 * @return the ID of this chat message
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the message of this chat message.
	 *
	 * @return the message of this chat message
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the primary key of this chat message.
	 *
	 * @return the primary key of this chat message
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the read date of this chat message.
	 *
	 * @return the read date of this chat message
	 */
	@Override
	public Date getReadDate() {
		return model.getReadDate();
	}

	/**
	 * Returns the readed of this chat message.
	 *
	 * @return the readed of this chat message
	 */
	@Override
	public boolean getReaded() {
		return model.getReaded();
	}

	/**
	 * Returns the sent date of this chat message.
	 *
	 * @return the sent date of this chat message
	 */
	@Override
	public Date getSentDate() {
		return model.getSentDate();
	}

	/**
	 * Returns the to user of this chat message.
	 *
	 * @return the to user of this chat message
	 */
	@Override
	public long getToUser() {
		return model.getToUser();
	}

	/**
	 * Returns the uuid of this chat message.
	 *
	 * @return the uuid of this chat message
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this chat message is deleted.
	 *
	 * @return <code>true</code> if this chat message is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	/**
	 * Returns <code>true</code> if this chat message is readed.
	 *
	 * @return <code>true</code> if this chat message is readed; <code>false</code> otherwise
	 */
	@Override
	public boolean isReaded() {
		return model.isReaded();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this chat message.
	 *
	 * @param companyId the company ID of this chat message
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets whether this chat message is deleted.
	 *
	 * @param deleted the deleted of this chat message
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the file ID of this chat message.
	 *
	 * @param fileId the file ID of this chat message
	 */
	@Override
	public void setFileId(long fileId) {
		model.setFileId(fileId);
	}

	/**
	 * Sets the file name of this chat message.
	 *
	 * @param fileName the file name of this chat message
	 */
	@Override
	public void setFileName(String fileName) {
		model.setFileName(fileName);
	}

	/**
	 * Sets the from user of this chat message.
	 *
	 * @param fromUser the from user of this chat message
	 */
	@Override
	public void setFromUser(long fromUser) {
		model.setFromUser(fromUser);
	}

	/**
	 * Sets the group ID of this chat message.
	 *
	 * @param groupId the group ID of this chat message
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this chat message.
	 *
	 * @param id the ID of this chat message
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the message of this chat message.
	 *
	 * @param message the message of this chat message
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the primary key of this chat message.
	 *
	 * @param primaryKey the primary key of this chat message
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the read date of this chat message.
	 *
	 * @param readDate the read date of this chat message
	 */
	@Override
	public void setReadDate(Date readDate) {
		model.setReadDate(readDate);
	}

	/**
	 * Sets whether this chat message is readed.
	 *
	 * @param readed the readed of this chat message
	 */
	@Override
	public void setReaded(boolean readed) {
		model.setReaded(readed);
	}

	/**
	 * Sets the sent date of this chat message.
	 *
	 * @param sentDate the sent date of this chat message
	 */
	@Override
	public void setSentDate(Date sentDate) {
		model.setSentDate(sentDate);
	}

	/**
	 * Sets the to user of this chat message.
	 *
	 * @param toUser the to user of this chat message
	 */
	@Override
	public void setToUser(long toUser) {
		model.setToUser(toUser);
	}

	/**
	 * Sets the uuid of this chat message.
	 *
	 * @param uuid the uuid of this chat message
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ChatMessageWrapper wrap(ChatMessage chatMessage) {
		return new ChatMessageWrapper(chatMessage);
	}

}