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

import it.eng.rd.collaborativecreation.model.Category;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Category in entity cache.
 *
 * @author ENGRD
 * @generated
 */
public class CategoryCacheModel
	implements CacheModel<Category>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CategoryCacheModel)) {
			return false;
		}

		CategoryCacheModel categoryCacheModel = (CategoryCacheModel)object;

		if ((categoryId == categoryCacheModel.categoryId) &&
			(mvccVersion == categoryCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, categoryId);

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
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", challengeId=");
		sb.append(challengeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", assetCategoryId=");
		sb.append(assetCategoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Category toEntityModel() {
		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setMvccVersion(mvccVersion);
		categoryImpl.setCategoryId(categoryId);
		categoryImpl.setChallengeId(challengeId);

		if (name == null) {
			categoryImpl.setName("");
		}
		else {
			categoryImpl.setName(name);
		}

		categoryImpl.setAssetCategoryId(assetCategoryId);

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		categoryId = objectInput.readLong();

		challengeId = objectInput.readLong();
		name = objectInput.readUTF();

		assetCategoryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(categoryId);

		objectOutput.writeLong(challengeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(assetCategoryId);
	}

	public long mvccVersion;
	public long categoryId;
	public long challengeId;
	public String name;
	public long assetCategoryId;

}