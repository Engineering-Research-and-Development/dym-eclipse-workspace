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

package it.eng.rd.collaborativecreation.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import it.eng.rd.collaborativecreation.model.Cocreation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Cocreation in entity cache.
 *
 * @author ENGRD
 * @generated
 */
public class CocreationCacheModel
	implements CacheModel<Cocreation>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CocreationCacheModel)) {
			return false;
		}

		CocreationCacheModel cocreationCacheModel =
			(CocreationCacheModel)object;

		if ((cocreationId == cocreationCacheModel.cocreationId) &&
			(mvccVersion == cocreationCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, cocreationId);

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
		StringBundler sb = new StringBundler(45);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", cocreationId=");
		sb.append(cocreationId);
		sb.append(", challengeId=");
		sb.append(challengeId);
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
		sb.append(", completionDate=");
		sb.append(completionDate);
		sb.append(", request=");
		sb.append(request);
		sb.append(", message=");
		sb.append(message);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", dlFolderName=");
		sb.append(dlFolderName);
		sb.append(", ldFolderId=");
		sb.append(ldFolderId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", completed=");
		sb.append(completed);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cocreation toEntityModel() {
		CocreationImpl cocreationImpl = new CocreationImpl();

		cocreationImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			cocreationImpl.setUuid("");
		}
		else {
			cocreationImpl.setUuid(uuid);
		}

		cocreationImpl.setCocreationId(cocreationId);
		cocreationImpl.setChallengeId(challengeId);
		cocreationImpl.setGroupId(groupId);
		cocreationImpl.setCompanyId(companyId);
		cocreationImpl.setUserId(userId);

		if (userName == null) {
			cocreationImpl.setUserName("");
		}
		else {
			cocreationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cocreationImpl.setCreateDate(null);
		}
		else {
			cocreationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cocreationImpl.setModifiedDate(null);
		}
		else {
			cocreationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (completionDate == Long.MIN_VALUE) {
			cocreationImpl.setCompletionDate(null);
		}
		else {
			cocreationImpl.setCompletionDate(new Date(completionDate));
		}

		if (request == null) {
			cocreationImpl.setRequest("");
		}
		else {
			cocreationImpl.setRequest(request);
		}

		if (message == null) {
			cocreationImpl.setMessage("");
		}
		else {
			cocreationImpl.setMessage(message);
		}

		if (title == null) {
			cocreationImpl.setTitle("");
		}
		else {
			cocreationImpl.setTitle(title);
		}

		if (description == null) {
			cocreationImpl.setDescription("");
		}
		else {
			cocreationImpl.setDescription(description);
		}

		if (dlFolderName == null) {
			cocreationImpl.setDlFolderName("");
		}
		else {
			cocreationImpl.setDlFolderName(dlFolderName);
		}

		cocreationImpl.setLdFolderId(ldFolderId);
		cocreationImpl.setStatus(status);
		cocreationImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			cocreationImpl.setStatusByUserName("");
		}
		else {
			cocreationImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			cocreationImpl.setStatusDate(null);
		}
		else {
			cocreationImpl.setStatusDate(new Date(statusDate));
		}

		cocreationImpl.setCompleted(completed);

		cocreationImpl.resetOriginalValues();

		return cocreationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		cocreationId = objectInput.readLong();

		challengeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		completionDate = objectInput.readLong();
		request = (String)objectInput.readObject();
		message = (String)objectInput.readObject();
		title = (String)objectInput.readObject();
		description = (String)objectInput.readObject();
		dlFolderName = objectInput.readUTF();

		ldFolderId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		completed = objectInput.readBoolean();
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

		objectOutput.writeLong(cocreationId);

		objectOutput.writeLong(challengeId);

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
		objectOutput.writeLong(completionDate);

		if (request == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(request);
		}

		if (message == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(message);
		}

		if (title == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(title);
		}

		if (description == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(description);
		}

		if (dlFolderName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlFolderName);
		}

		objectOutput.writeLong(ldFolderId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeBoolean(completed);
	}

	public long mvccVersion;
	public String uuid;
	public long cocreationId;
	public long challengeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long completionDate;
	public String request;
	public String message;
	public String title;
	public String description;
	public String dlFolderName;
	public long ldFolderId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public boolean completed;

}