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

package it.eng.rd.collaborativecreation.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.rd.collaborativecreation.service.http.HashtagServiceSoap}.
 *
 * @author ENGRD
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class HashtagSoap implements Serializable {

	public static HashtagSoap toSoapModel(Hashtag model) {
		HashtagSoap soapModel = new HashtagSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setHashtagId(model.getHashtagId());
		soapModel.setChallengeId(model.getChallengeId());
		soapModel.setName(model.getName());
		soapModel.setAssetTagId(model.getAssetTagId());

		return soapModel;
	}

	public static HashtagSoap[] toSoapModels(Hashtag[] models) {
		HashtagSoap[] soapModels = new HashtagSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HashtagSoap[][] toSoapModels(Hashtag[][] models) {
		HashtagSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HashtagSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HashtagSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HashtagSoap[] toSoapModels(List<Hashtag> models) {
		List<HashtagSoap> soapModels = new ArrayList<HashtagSoap>(
			models.size());

		for (Hashtag model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HashtagSoap[soapModels.size()]);
	}

	public HashtagSoap() {
	}

	public long getPrimaryKey() {
		return _hashtagId;
	}

	public void setPrimaryKey(long pk) {
		setHashtagId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getHashtagId() {
		return _hashtagId;
	}

	public void setHashtagId(long hashtagId) {
		_hashtagId = hashtagId;
	}

	public long getChallengeId() {
		return _challengeId;
	}

	public void setChallengeId(long challengeId) {
		_challengeId = challengeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getAssetTagId() {
		return _assetTagId;
	}

	public void setAssetTagId(long assetTagId) {
		_assetTagId = assetTagId;
	}

	private long _mvccVersion;
	private long _hashtagId;
	private long _challengeId;
	private String _name;
	private long _assetTagId;

}