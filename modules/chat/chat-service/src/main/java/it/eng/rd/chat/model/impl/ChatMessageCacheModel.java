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

import it.eng.rd.chat.model.ChatMessage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChatMessage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChatMessageCacheModel
	implements CacheModel<ChatMessage>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChatMessageCacheModel)) {
			return false;
		}

		ChatMessageCacheModel chatMessageCacheModel =
			(ChatMessageCacheModel)object;

		if (id == chatMessageCacheModel.id) {
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
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", fromUser=");
		sb.append(fromUser);
		sb.append(", toUser=");
		sb.append(toUser);
		sb.append(", sentDate=");
		sb.append(sentDate);
		sb.append(", readDate=");
		sb.append(readDate);
		sb.append(", message=");
		sb.append(message);
		sb.append(", readed=");
		sb.append(readed);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChatMessage toEntityModel() {
		ChatMessageImpl chatMessageImpl = new ChatMessageImpl();

		if (uuid == null) {
			chatMessageImpl.setUuid("");
		}
		else {
			chatMessageImpl.setUuid(uuid);
		}

		chatMessageImpl.setId(id);
		chatMessageImpl.setGroupId(groupId);
		chatMessageImpl.setCompanyId(companyId);
		chatMessageImpl.setFromUser(fromUser);
		chatMessageImpl.setToUser(toUser);

		if (sentDate == Long.MIN_VALUE) {
			chatMessageImpl.setSentDate(null);
		}
		else {
			chatMessageImpl.setSentDate(new Date(sentDate));
		}

		if (readDate == Long.MIN_VALUE) {
			chatMessageImpl.setReadDate(null);
		}
		else {
			chatMessageImpl.setReadDate(new Date(readDate));
		}

		if (message == null) {
			chatMessageImpl.setMessage("");
		}
		else {
			chatMessageImpl.setMessage(message);
		}

		chatMessageImpl.setReaded(readed);
		chatMessageImpl.setDeleted(deleted);

		if (fileName == null) {
			chatMessageImpl.setFileName("");
		}
		else {
			chatMessageImpl.setFileName(fileName);
		}

		chatMessageImpl.setFileId(fileId);

		chatMessageImpl.resetOriginalValues();

		return chatMessageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		fromUser = objectInput.readLong();

		toUser = objectInput.readLong();
		sentDate = objectInput.readLong();
		readDate = objectInput.readLong();
		message = objectInput.readUTF();

		readed = objectInput.readBoolean();

		deleted = objectInput.readBoolean();
		fileName = objectInput.readUTF();

		fileId = objectInput.readLong();
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

		objectOutput.writeLong(fromUser);

		objectOutput.writeLong(toUser);
		objectOutput.writeLong(sentDate);
		objectOutput.writeLong(readDate);

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		objectOutput.writeBoolean(readed);

		objectOutput.writeBoolean(deleted);

		if (fileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		objectOutput.writeLong(fileId);
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long fromUser;
	public long toUser;
	public long sentDate;
	public long readDate;
	public String message;
	public boolean readed;
	public boolean deleted;
	public String fileName;
	public long fileId;

}