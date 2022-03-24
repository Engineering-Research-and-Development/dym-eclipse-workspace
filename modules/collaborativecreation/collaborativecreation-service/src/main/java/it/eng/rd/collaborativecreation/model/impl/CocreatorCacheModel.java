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

import it.eng.rd.collaborativecreation.model.Cocreator;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Cocreator in entity cache.
 *
 * @author ENGRD
 * @generated
 */
public class CocreatorCacheModel
	implements CacheModel<Cocreator>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CocreatorCacheModel)) {
			return false;
		}

		CocreatorCacheModel cocreatorCacheModel = (CocreatorCacheModel)object;

		if ((cocreatorId == cocreatorCacheModel.cocreatorId) &&
			(mvccVersion == cocreatorCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, cocreatorId);

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
		StringBundler sb = new StringBundler(19);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", cocreatorId=");
		sb.append(cocreatorId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", cocreationId=");
		sb.append(cocreationId);
		sb.append(", activityId=");
		sb.append(activityId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cocreator toEntityModel() {
		CocreatorImpl cocreatorImpl = new CocreatorImpl();

		cocreatorImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			cocreatorImpl.setUuid("");
		}
		else {
			cocreatorImpl.setUuid(uuid);
		}

		cocreatorImpl.setCocreatorId(cocreatorId);
		cocreatorImpl.setGroupId(groupId);
		cocreatorImpl.setCompanyId(companyId);
		cocreatorImpl.setUserId(userId);

		if (userName == null) {
			cocreatorImpl.setUserName("");
		}
		else {
			cocreatorImpl.setUserName(userName);
		}

		cocreatorImpl.setCocreationId(cocreationId);
		cocreatorImpl.setActivityId(activityId);

		cocreatorImpl.resetOriginalValues();

		return cocreatorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		cocreatorId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		cocreationId = objectInput.readLong();

		activityId = objectInput.readLong();
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

		objectOutput.writeLong(cocreatorId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(cocreationId);

		objectOutput.writeLong(activityId);
	}

	public long mvccVersion;
	public String uuid;
	public long cocreatorId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long cocreationId;
	public long activityId;

}