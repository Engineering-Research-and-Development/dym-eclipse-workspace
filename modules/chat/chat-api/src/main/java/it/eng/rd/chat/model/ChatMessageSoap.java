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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.rd.chat.service.http.ChatMessageServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ChatMessageSoap implements Serializable {

	public static ChatMessageSoap toSoapModel(ChatMessage model) {
		ChatMessageSoap soapModel = new ChatMessageSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setFromUser(model.getFromUser());
		soapModel.setToUser(model.getToUser());
		soapModel.setSentDate(model.getSentDate());
		soapModel.setReadDate(model.getReadDate());
		soapModel.setMessage(model.getMessage());
		soapModel.setReaded(model.isReaded());
		soapModel.setDeleted(model.isDeleted());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileId(model.getFileId());

		return soapModel;
	}

	public static ChatMessageSoap[] toSoapModels(ChatMessage[] models) {
		ChatMessageSoap[] soapModels = new ChatMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChatMessageSoap[][] toSoapModels(ChatMessage[][] models) {
		ChatMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChatMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChatMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChatMessageSoap[] toSoapModels(List<ChatMessage> models) {
		List<ChatMessageSoap> soapModels = new ArrayList<ChatMessageSoap>(
			models.size());

		for (ChatMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChatMessageSoap[soapModels.size()]);
	}

	public ChatMessageSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getFromUser() {
		return _fromUser;
	}

	public void setFromUser(long fromUser) {
		_fromUser = fromUser;
	}

	public long getToUser() {
		return _toUser;
	}

	public void setToUser(long toUser) {
		_toUser = toUser;
	}

	public Date getSentDate() {
		return _sentDate;
	}

	public void setSentDate(Date sentDate) {
		_sentDate = sentDate;
	}

	public Date getReadDate() {
		return _readDate;
	}

	public void setReadDate(Date readDate) {
		_readDate = readDate;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public boolean getReaded() {
		return _readed;
	}

	public boolean isReaded() {
		return _readed;
	}

	public void setReaded(boolean readed) {
		_readed = readed;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	private String _uuid;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _fromUser;
	private long _toUser;
	private Date _sentDate;
	private Date _readDate;
	private String _message;
	private boolean _readed;
	private boolean _deleted;
	private String _fileName;
	private long _fileId;

}