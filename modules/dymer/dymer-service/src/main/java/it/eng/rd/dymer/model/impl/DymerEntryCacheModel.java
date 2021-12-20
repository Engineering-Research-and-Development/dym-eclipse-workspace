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

package it.eng.rd.dymer.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import it.eng.rd.dymer.model.DymerEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DymerEntry in entity cache.
 *
 * @author ENGRD
 * @generated
 */
public class DymerEntryCacheModel
	implements CacheModel<DymerEntry>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DymerEntryCacheModel)) {
			return false;
		}

		DymerEntryCacheModel dymerEntryCacheModel =
			(DymerEntryCacheModel)object;

		if ((entryId == dymerEntryCacheModel.entryId) &&
			(mvccVersion == dymerEntryCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, entryId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", entryId=");
		sb.append(entryId);
		sb.append(", index=");
		sb.append(index);
		sb.append(", type=");
		sb.append(type);
		sb.append(", id=");
		sb.append(id);
		sb.append(", title=");
		sb.append(title);
		sb.append(", extContent=");
		sb.append(extContent);
		sb.append(", url=");
		sb.append(url);
		sb.append(", dymerId=");
		sb.append(dymerId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DymerEntry toEntityModel() {
		DymerEntryImpl dymerEntryImpl = new DymerEntryImpl();

		dymerEntryImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			dymerEntryImpl.setUuid("");
		}
		else {
			dymerEntryImpl.setUuid(uuid);
		}

		dymerEntryImpl.setEntryId(entryId);

		if (index == null) {
			dymerEntryImpl.setIndex("");
		}
		else {
			dymerEntryImpl.setIndex(index);
		}

		if (type == null) {
			dymerEntryImpl.setType("");
		}
		else {
			dymerEntryImpl.setType(type);
		}

		if (id == null) {
			dymerEntryImpl.setId("");
		}
		else {
			dymerEntryImpl.setId(id);
		}

		if (title == null) {
			dymerEntryImpl.setTitle("");
		}
		else {
			dymerEntryImpl.setTitle(title);
		}

		if (extContent == null) {
			dymerEntryImpl.setExtContent("");
		}
		else {
			dymerEntryImpl.setExtContent(extContent);
		}

		if (url == null) {
			dymerEntryImpl.setUrl("");
		}
		else {
			dymerEntryImpl.setUrl(url);
		}

		dymerEntryImpl.setDymerId(dymerId);
		dymerEntryImpl.setGroupId(groupId);
		dymerEntryImpl.setCompanyId(companyId);
		dymerEntryImpl.setUserId(userId);

		if (userName == null) {
			dymerEntryImpl.setUserName("");
		}
		else {
			dymerEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dymerEntryImpl.setCreateDate(null);
		}
		else {
			dymerEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dymerEntryImpl.setModifiedDate(null);
		}
		else {
			dymerEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		dymerEntryImpl.setStatus(status);
		dymerEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dymerEntryImpl.setStatusByUserName("");
		}
		else {
			dymerEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dymerEntryImpl.setStatusDate(null);
		}
		else {
			dymerEntryImpl.setStatusDate(new Date(statusDate));
		}

		dymerEntryImpl.resetOriginalValues();

		return dymerEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		entryId = objectInput.readLong();
		index = objectInput.readUTF();
		type = objectInput.readUTF();
		id = objectInput.readUTF();
		title = objectInput.readUTF();
		extContent = (String)objectInput.readObject();
		url = objectInput.readUTF();

		dymerId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(entryId);

		if (index == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(index);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(id);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (extContent == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(extContent);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeLong(dymerId);

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

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long mvccVersion;
	public String uuid;
	public long entryId;
	public String index;
	public String type;
	public String id;
	public String title;
	public String extContent;
	public String url;
	public long dymerId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}