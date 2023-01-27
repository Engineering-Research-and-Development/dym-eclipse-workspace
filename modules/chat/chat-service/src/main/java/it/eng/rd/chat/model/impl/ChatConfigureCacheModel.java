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

package it.eng.rd.chat.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.rd.chat.model.ChatConfigure;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChatConfigure in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChatConfigureCacheModel
	implements CacheModel<ChatConfigure>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChatConfigureCacheModel)) {
			return false;
		}

		ChatConfigureCacheModel chatConfigureCacheModel =
			(ChatConfigureCacheModel)object;

		if (id == chatConfigureCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", enable=");
		sb.append(enable);
		sb.append(", headerColor=");
		sb.append(headerColor);
		sb.append(", chatRightColor=");
		sb.append(chatRightColor);
		sb.append(", chatLeftColor=");
		sb.append(chatLeftColor);
		sb.append(", headerTextColor=");
		sb.append(headerTextColor);
		sb.append(", contentTextColor=");
		sb.append(contentTextColor);
		sb.append(", backColor=");
		sb.append(backColor);
		sb.append(", chatRoleId=");
		sb.append(chatRoleId);
		sb.append(", fontFamily=");
		sb.append(fontFamily);
		sb.append(", requestFeature=");
		sb.append(requestFeature);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChatConfigure toEntityModel() {
		ChatConfigureImpl chatConfigureImpl = new ChatConfigureImpl();

		if (uuid == null) {
			chatConfigureImpl.setUuid("");
		}
		else {
			chatConfigureImpl.setUuid(uuid);
		}

		chatConfigureImpl.setId(id);
		chatConfigureImpl.setGroupId(groupId);
		chatConfigureImpl.setCompanyId(companyId);
		chatConfigureImpl.setUserId(userId);

		if (userName == null) {
			chatConfigureImpl.setUserName("");
		}
		else {
			chatConfigureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			chatConfigureImpl.setCreateDate(null);
		}
		else {
			chatConfigureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			chatConfigureImpl.setModifiedDate(null);
		}
		else {
			chatConfigureImpl.setModifiedDate(new Date(modifiedDate));
		}

		chatConfigureImpl.setEnable(enable);

		if (headerColor == null) {
			chatConfigureImpl.setHeaderColor("");
		}
		else {
			chatConfigureImpl.setHeaderColor(headerColor);
		}

		if (chatRightColor == null) {
			chatConfigureImpl.setChatRightColor("");
		}
		else {
			chatConfigureImpl.setChatRightColor(chatRightColor);
		}

		if (chatLeftColor == null) {
			chatConfigureImpl.setChatLeftColor("");
		}
		else {
			chatConfigureImpl.setChatLeftColor(chatLeftColor);
		}

		if (headerTextColor == null) {
			chatConfigureImpl.setHeaderTextColor("");
		}
		else {
			chatConfigureImpl.setHeaderTextColor(headerTextColor);
		}

		if (contentTextColor == null) {
			chatConfigureImpl.setContentTextColor("");
		}
		else {
			chatConfigureImpl.setContentTextColor(contentTextColor);
		}

		if (backColor == null) {
			chatConfigureImpl.setBackColor("");
		}
		else {
			chatConfigureImpl.setBackColor(backColor);
		}

		if (chatRoleId == null) {
			chatConfigureImpl.setChatRoleId("");
		}
		else {
			chatConfigureImpl.setChatRoleId(chatRoleId);
		}

		if (fontFamily == null) {
			chatConfigureImpl.setFontFamily("");
		}
		else {
			chatConfigureImpl.setFontFamily(fontFamily);
		}

		chatConfigureImpl.setRequestFeature(requestFeature);

		chatConfigureImpl.resetOriginalValues();

		return chatConfigureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		enable = objectInput.readBoolean();
		headerColor = objectInput.readUTF();
		chatRightColor = objectInput.readUTF();
		chatLeftColor = objectInput.readUTF();
		headerTextColor = objectInput.readUTF();
		contentTextColor = objectInput.readUTF();
		backColor = objectInput.readUTF();
		chatRoleId = objectInput.readUTF();
		fontFamily = objectInput.readUTF();

		requestFeature = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(enable);

		if (headerColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(headerColor);
		}

		if (chatRightColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chatRightColor);
		}

		if (chatLeftColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chatLeftColor);
		}

		if (headerTextColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(headerTextColor);
		}

		if (contentTextColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contentTextColor);
		}

		if (backColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(backColor);
		}

		if (chatRoleId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chatRoleId);
		}

		if (fontFamily == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fontFamily);
		}

		objectOutput.writeBoolean(requestFeature);
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean enable;
	public String headerColor;
	public String chatRightColor;
	public String chatLeftColor;
	public String headerTextColor;
	public String contentTextColor;
	public String backColor;
	public String chatRoleId;
	public String fontFamily;
	public boolean requestFeature;

}