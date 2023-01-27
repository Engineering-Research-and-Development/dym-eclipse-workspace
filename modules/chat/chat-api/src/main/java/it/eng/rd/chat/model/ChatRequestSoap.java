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
 * This class is used by SOAP remote services, specifically {@link it.eng.rd.chat.service.http.ChatRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ChatRequestSoap implements Serializable {

	public static ChatRequestSoap toSoapModel(ChatRequest model) {
		ChatRequestSoap soapModel = new ChatRequestSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setFromUserId(model.getFromUserId());
		soapModel.setToUserId(model.getToUserId());
		soapModel.setIsAccepted(model.isIsAccepted());
		soapModel.setIsRejected(model.isIsRejected());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ChatRequestSoap[] toSoapModels(ChatRequest[] models) {
		ChatRequestSoap[] soapModels = new ChatRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChatRequestSoap[][] toSoapModels(ChatRequest[][] models) {
		ChatRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChatRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChatRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChatRequestSoap[] toSoapModels(List<ChatRequest> models) {
		List<ChatRequestSoap> soapModels = new ArrayList<ChatRequestSoap>(
			models.size());

		for (ChatRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChatRequestSoap[soapModels.size()]);
	}

	public ChatRequestSoap() {
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

	public long getFromUserId() {
		return _fromUserId;
	}

	public void setFromUserId(long fromUserId) {
		_fromUserId = fromUserId;
	}

	public long getToUserId() {
		return _toUserId;
	}

	public void setToUserId(long toUserId) {
		_toUserId = toUserId;
	}

	public boolean getIsAccepted() {
		return _isAccepted;
	}

	public boolean isIsAccepted() {
		return _isAccepted;
	}

	public void setIsAccepted(boolean isAccepted) {
		_isAccepted = isAccepted;
	}

	public boolean getIsRejected() {
		return _isRejected;
	}

	public boolean isIsRejected() {
		return _isRejected;
	}

	public void setIsRejected(boolean isRejected) {
		_isRejected = isRejected;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _id;
	private long _fromUserId;
	private long _toUserId;
	private boolean _isAccepted;
	private boolean _isRejected;
	private Date _createDate;
	private Date _modifiedDate;

}