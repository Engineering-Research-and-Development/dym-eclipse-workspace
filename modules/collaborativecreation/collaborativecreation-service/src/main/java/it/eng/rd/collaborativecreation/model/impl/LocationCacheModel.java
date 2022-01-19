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

import it.eng.rd.collaborativecreation.model.Location;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Location in entity cache.
 *
 * @author ENGRD
 * @generated
 */
public class LocationCacheModel
	implements CacheModel<Location>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LocationCacheModel)) {
			return false;
		}

		LocationCacheModel locationCacheModel = (LocationCacheModel)object;

		if ((locatoinId == locationCacheModel.locatoinId) &&
			(mvccVersion == locationCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, locatoinId);

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
		StringBundler sb = new StringBundler(13);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", locatoinId=");
		sb.append(locatoinId);
		sb.append(", challengeId=");
		sb.append(challengeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Location toEntityModel() {
		LocationImpl locationImpl = new LocationImpl();

		locationImpl.setMvccVersion(mvccVersion);
		locationImpl.setLocatoinId(locatoinId);
		locationImpl.setChallengeId(challengeId);

		if (name == null) {
			locationImpl.setName("");
		}
		else {
			locationImpl.setName(name);
		}

		if (latitude == null) {
			locationImpl.setLatitude("");
		}
		else {
			locationImpl.setLatitude(latitude);
		}

		if (longitude == null) {
			locationImpl.setLongitude("");
		}
		else {
			locationImpl.setLongitude(longitude);
		}

		locationImpl.resetOriginalValues();

		return locationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		locatoinId = objectInput.readLong();

		challengeId = objectInput.readLong();
		name = objectInput.readUTF();
		latitude = objectInput.readUTF();
		longitude = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(locatoinId);

		objectOutput.writeLong(challengeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (latitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(latitude);
		}

		if (longitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(longitude);
		}
	}

	public long mvccVersion;
	public long locatoinId;
	public long challengeId;
	public String name;
	public String latitude;
	public String longitude;

}