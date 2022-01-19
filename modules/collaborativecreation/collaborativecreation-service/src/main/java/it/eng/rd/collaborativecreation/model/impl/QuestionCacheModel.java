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

import it.eng.rd.collaborativecreation.model.Question;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Question in entity cache.
 *
 * @author ENGRD
 * @generated
 */
public class QuestionCacheModel
	implements CacheModel<Question>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuestionCacheModel)) {
			return false;
		}

		QuestionCacheModel questionCacheModel = (QuestionCacheModel)object;

		if ((questionId == questionCacheModel.questionId) &&
			(mvccVersion == questionCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, questionId);

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
		StringBundler sb = new StringBundler(9);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", cocreationId=");
		sb.append(cocreationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Question toEntityModel() {
		QuestionImpl questionImpl = new QuestionImpl();

		questionImpl.setMvccVersion(mvccVersion);
		questionImpl.setQuestionId(questionId);

		if (description == null) {
			questionImpl.setDescription("");
		}
		else {
			questionImpl.setDescription(description);
		}

		questionImpl.setCocreationId(cocreationId);

		questionImpl.resetOriginalValues();

		return questionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		questionId = objectInput.readLong();
		description = objectInput.readUTF();

		cocreationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(questionId);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(cocreationId);
	}

	public long mvccVersion;
	public long questionId;
	public String description;
	public long cocreationId;

}