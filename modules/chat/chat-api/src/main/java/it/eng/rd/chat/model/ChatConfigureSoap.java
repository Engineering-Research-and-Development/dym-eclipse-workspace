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
 * This class is used by SOAP remote services, specifically {@link it.eng.rd.chat.service.http.ChatConfigureServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ChatConfigureSoap implements Serializable {

	public static ChatConfigureSoap toSoapModel(ChatConfigure model) {
		ChatConfigureSoap soapModel = new ChatConfigureSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEnable(model.isEnable());
		soapModel.setHeaderColor(model.getHeaderColor());
		soapModel.setChatRightColor(model.getChatRightColor());
		soapModel.setChatLeftColor(model.getChatLeftColor());
		soapModel.setHeaderTextColor(model.getHeaderTextColor());
		soapModel.setContentTextColor(model.getContentTextColor());
		soapModel.setBackColor(model.getBackColor());
		soapModel.setChatRoleId(model.getChatRoleId());
		soapModel.setFontFamily(model.getFontFamily());
		soapModel.setRequestFeature(model.isRequestFeature());

		return soapModel;
	}

	public static ChatConfigureSoap[] toSoapModels(ChatConfigure[] models) {
		ChatConfigureSoap[] soapModels = new ChatConfigureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChatConfigureSoap[][] toSoapModels(ChatConfigure[][] models) {
		ChatConfigureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChatConfigureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChatConfigureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChatConfigureSoap[] toSoapModels(List<ChatConfigure> models) {
		List<ChatConfigureSoap> soapModels = new ArrayList<ChatConfigureSoap>(
			models.size());

		for (ChatConfigure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChatConfigureSoap[soapModels.size()]);
	}

	public ChatConfigureSoap() {
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public boolean getEnable() {
		return _enable;
	}

	public boolean isEnable() {
		return _enable;
	}

	public void setEnable(boolean enable) {
		_enable = enable;
	}

	public String getHeaderColor() {
		return _headerColor;
	}

	public void setHeaderColor(String headerColor) {
		_headerColor = headerColor;
	}

	public String getChatRightColor() {
		return _chatRightColor;
	}

	public void setChatRightColor(String chatRightColor) {
		_chatRightColor = chatRightColor;
	}

	public String getChatLeftColor() {
		return _chatLeftColor;
	}

	public void setChatLeftColor(String chatLeftColor) {
		_chatLeftColor = chatLeftColor;
	}

	public String getHeaderTextColor() {
		return _headerTextColor;
	}

	public void setHeaderTextColor(String headerTextColor) {
		_headerTextColor = headerTextColor;
	}

	public String getContentTextColor() {
		return _contentTextColor;
	}

	public void setContentTextColor(String contentTextColor) {
		_contentTextColor = contentTextColor;
	}

	public String getBackColor() {
		return _backColor;
	}

	public void setBackColor(String backColor) {
		_backColor = backColor;
	}

	public String getChatRoleId() {
		return _chatRoleId;
	}

	public void setChatRoleId(String chatRoleId) {
		_chatRoleId = chatRoleId;
	}

	public String getFontFamily() {
		return _fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		_fontFamily = fontFamily;
	}

	public boolean getRequestFeature() {
		return _requestFeature;
	}

	public boolean isRequestFeature() {
		return _requestFeature;
	}

	public void setRequestFeature(boolean requestFeature) {
		_requestFeature = requestFeature;
	}

	private String _uuid;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _enable;
	private String _headerColor;
	private String _chatRightColor;
	private String _chatLeftColor;
	private String _headerTextColor;
	private String _contentTextColor;
	private String _backColor;
	private String _chatRoleId;
	private String _fontFamily;
	private boolean _requestFeature;

}