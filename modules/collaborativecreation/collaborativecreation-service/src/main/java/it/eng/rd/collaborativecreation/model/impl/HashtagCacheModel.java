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

import it.eng.rd.collaborativecreation.model.Hashtag;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Hashtag in entity cache.
 *
 * @author ENGRD
 * @generated
 */
public class HashtagCacheModel
	implements CacheModel<Hashtag>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HashtagCacheModel)) {
			return false;
		}

		HashtagCacheModel hashtagCacheModel = (HashtagCacheModel)object;

		if ((hashtagId == hashtagCacheModel.hashtagId) &&
			(mvccVersion == hashtagCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, hashtagId);

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
		StringBundler sb = new StringBundler(11);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", hashtagId=");
		sb.append(hashtagId);
		sb.append(", challengeId=");
		sb.append(challengeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", assetTagId=");
		sb.append(assetTagId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Hashtag toEntityModel() {
		HashtagImpl hashtagImpl = new HashtagImpl();

		hashtagImpl.setMvccVersion(mvccVersion);
		hashtagImpl.setHashtagId(hashtagId);
		hashtagImpl.setChallengeId(challengeId);

		if (name == null) {
			hashtagImpl.setName("");
		}
		else {
			hashtagImpl.setName(name);
		}

		hashtagImpl.setAssetTagId(assetTagId);

		hashtagImpl.resetOriginalValues();

		return hashtagImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		hashtagId = objectInput.readLong();

		challengeId = objectInput.readLong();
		name = objectInput.readUTF();

		assetTagId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(hashtagId);

		objectOutput.writeLong(challengeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(assetTagId);
	}

	public long mvccVersion;
	public long hashtagId;
	public long challengeId;
	public String name;
	public long assetTagId;

}