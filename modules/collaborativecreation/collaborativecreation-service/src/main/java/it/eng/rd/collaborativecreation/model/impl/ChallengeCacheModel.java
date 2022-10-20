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

import it.eng.rd.collaborativecreation.model.Challenge;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Challenge in entity cache.
 *
 * @author ENGRD
 * @generated
 */
public class ChallengeCacheModel
	implements CacheModel<Challenge>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChallengeCacheModel)) {
			return false;
		}

		ChallengeCacheModel challengeCacheModel = (ChallengeCacheModel)object;

		if ((challengeId == challengeCacheModel.challengeId) &&
			(mvccVersion == challengeCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, challengeId);

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
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", desiredOutcome=");
		sb.append(desiredOutcome);
		sb.append(", additionalInformation=");
		sb.append(additionalInformation);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", dlFolderName=");
		sb.append(dlFolderName);
		sb.append(", dlFolderId=");
		sb.append(dlFolderId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Challenge toEntityModel() {
		ChallengeImpl challengeImpl = new ChallengeImpl();

		challengeImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			challengeImpl.setUuid("");
		}
		else {
			challengeImpl.setUuid(uuid);
		}

		challengeImpl.setChallengeId(challengeId);
		challengeImpl.setGroupId(groupId);
		challengeImpl.setCompanyId(companyId);
		challengeImpl.setUserId(userId);

		if (userName == null) {
			challengeImpl.setUserName("");
		}
		else {
			challengeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			challengeImpl.setCreateDate(null);
		}
		else {
			challengeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			challengeImpl.setModifiedDate(null);
		}
		else {
			challengeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			challengeImpl.setTitle("");
		}
		else {
			challengeImpl.setTitle(title);
		}

		if (description == null) {
			challengeImpl.setDescription("");
		}
		else {
			challengeImpl.setDescription(description);
		}

		if (desiredOutcome == null) {
			challengeImpl.setDesiredOutcome("");
		}
		else {
			challengeImpl.setDesiredOutcome(desiredOutcome);
		}

		if (additionalInformation == null) {
			challengeImpl.setAdditionalInformation("");
		}
		else {
			challengeImpl.setAdditionalInformation(additionalInformation);
		}

		if (startDate == Long.MIN_VALUE) {
			challengeImpl.setStartDate(null);
		}
		else {
			challengeImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			challengeImpl.setEndDate(null);
		}
		else {
			challengeImpl.setEndDate(new Date(endDate));
		}

		if (dlFolderName == null) {
			challengeImpl.setDlFolderName("");
		}
		else {
			challengeImpl.setDlFolderName(dlFolderName);
		}

		challengeImpl.setDlFolderId(dlFolderId);
		challengeImpl.setStatus(status);
		challengeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			challengeImpl.setStatusByUserName("");
		}
		else {
			challengeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			challengeImpl.setStatusDate(null);
		}
		else {
			challengeImpl.setStatusDate(new Date(statusDate));
		}

		challengeImpl.setActive(active);

		challengeImpl.resetOriginalValues();

		return challengeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		challengeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = (String)objectInput.readObject();
		description = (String)objectInput.readObject();
		desiredOutcome = (String)objectInput.readObject();
		additionalInformation = (String)objectInput.readObject();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		dlFolderName = objectInput.readUTF();

		dlFolderId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		active = objectInput.readBoolean();
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

		if (desiredOutcome == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(desiredOutcome);
		}

		if (additionalInformation == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(additionalInformation);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (dlFolderName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dlFolderName);
		}

		objectOutput.writeLong(dlFolderId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeBoolean(active);
	}

	public long mvccVersion;
	public String uuid;
	public long challengeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public String desiredOutcome;
	public String additionalInformation;
	public long startDate;
	public long endDate;
	public String dlFolderName;
	public long dlFolderId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public boolean active;

}