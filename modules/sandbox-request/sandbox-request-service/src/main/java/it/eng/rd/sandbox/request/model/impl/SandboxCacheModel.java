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

package it.eng.rd.sandbox.request.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.rd.sandbox.request.model.Sandbox;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Sandbox in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SandboxCacheModel implements CacheModel<Sandbox>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SandboxCacheModel)) {
			return false;
		}

		SandboxCacheModel sandboxCacheModel = (SandboxCacheModel)object;

		if (sandboxId == sandboxCacheModel.sandboxId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sandboxId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sandboxId=");
		sb.append(sandboxId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Sandbox toEntityModel() {
		SandboxImpl sandboxImpl = new SandboxImpl();

		if (uuid == null) {
			sandboxImpl.setUuid("");
		}
		else {
			sandboxImpl.setUuid(uuid);
		}

		sandboxImpl.setSandboxId(sandboxId);
		sandboxImpl.setGroupId(groupId);
		sandboxImpl.setCompanyId(companyId);
		sandboxImpl.setUserId(userId);

		if (userName == null) {
			sandboxImpl.setUserName("");
		}
		else {
			sandboxImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sandboxImpl.setCreateDate(null);
		}
		else {
			sandboxImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sandboxImpl.setModifiedDate(null);
		}
		else {
			sandboxImpl.setModifiedDate(new Date(modifiedDate));
		}

		sandboxImpl.resetOriginalValues();

		return sandboxImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		sandboxId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
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

		objectOutput.writeLong(sandboxId);

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
	}

	public String uuid;
	public long sandboxId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}