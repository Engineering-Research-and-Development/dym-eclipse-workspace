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

import it.eng.rd.chat.model.ChatRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChatRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChatRequestCacheModel
	implements CacheModel<ChatRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChatRequestCacheModel)) {
			return false;
		}

		ChatRequestCacheModel chatRequestCacheModel =
			(ChatRequestCacheModel)object;

		if (id == chatRequestCacheModel.id) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", fromUserId=");
		sb.append(fromUserId);
		sb.append(", toUserId=");
		sb.append(toUserId);
		sb.append(", isAccepted=");
		sb.append(isAccepted);
		sb.append(", isRejected=");
		sb.append(isRejected);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChatRequest toEntityModel() {
		ChatRequestImpl chatRequestImpl = new ChatRequestImpl();

		if (uuid == null) {
			chatRequestImpl.setUuid("");
		}
		else {
			chatRequestImpl.setUuid(uuid);
		}

		chatRequestImpl.setId(id);
		chatRequestImpl.setFromUserId(fromUserId);
		chatRequestImpl.setToUserId(toUserId);
		chatRequestImpl.setIsAccepted(isAccepted);
		chatRequestImpl.setIsRejected(isRejected);

		if (createDate == Long.MIN_VALUE) {
			chatRequestImpl.setCreateDate(null);
		}
		else {
			chatRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			chatRequestImpl.setModifiedDate(null);
		}
		else {
			chatRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		chatRequestImpl.resetOriginalValues();

		return chatRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		fromUserId = objectInput.readLong();

		toUserId = objectInput.readLong();

		isAccepted = objectInput.readBoolean();

		isRejected = objectInput.readBoolean();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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

		objectOutput.writeLong(fromUserId);

		objectOutput.writeLong(toUserId);

		objectOutput.writeBoolean(isAccepted);

		objectOutput.writeBoolean(isRejected);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long id;
	public long fromUserId;
	public long toUserId;
	public boolean isAccepted;
	public boolean isRejected;
	public long createDate;
	public long modifiedDate;

}