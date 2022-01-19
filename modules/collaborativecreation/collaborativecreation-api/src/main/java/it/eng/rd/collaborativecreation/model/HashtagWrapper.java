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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Hashtag}.
 * </p>
 *
 * @author ENGRD
 * @see Hashtag
 * @generated
 */
public class HashtagWrapper
	extends BaseModelWrapper<Hashtag>
	implements Hashtag, ModelWrapper<Hashtag> {

	public HashtagWrapper(Hashtag hashtag) {
		super(hashtag);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("hashtagId", getHashtagId());
		attributes.put("challengeId", getChallengeId());
		attributes.put("name", getName());
		attributes.put("assetTagId", getAssetTagId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long hashtagId = (Long)attributes.get("hashtagId");

		if (hashtagId != null) {
			setHashtagId(hashtagId);
		}

		Long challengeId = (Long)attributes.get("challengeId");

		if (challengeId != null) {
			setChallengeId(challengeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long assetTagId = (Long)attributes.get("assetTagId");

		if (assetTagId != null) {
			setAssetTagId(assetTagId);
		}
	}

	/**
	 * Returns the asset tag ID of this hashtag.
	 *
	 * @return the asset tag ID of this hashtag
	 */
	@Override
	public long getAssetTagId() {
		return model.getAssetTagId();
	}

	/**
	 * Returns the challenge ID of this hashtag.
	 *
	 * @return the challenge ID of this hashtag
	 */
	@Override
	public long getChallengeId() {
		return model.getChallengeId();
	}

	/**
	 * Returns the hashtag ID of this hashtag.
	 *
	 * @return the hashtag ID of this hashtag
	 */
	@Override
	public long getHashtagId() {
		return model.getHashtagId();
	}

	/**
	 * Returns the mvcc version of this hashtag.
	 *
	 * @return the mvcc version of this hashtag
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this hashtag.
	 *
	 * @return the name of this hashtag
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this hashtag.
	 *
	 * @return the primary key of this hashtag
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the asset tag ID of this hashtag.
	 *
	 * @param assetTagId the asset tag ID of this hashtag
	 */
	@Override
	public void setAssetTagId(long assetTagId) {
		model.setAssetTagId(assetTagId);
	}

	/**
	 * Sets the challenge ID of this hashtag.
	 *
	 * @param challengeId the challenge ID of this hashtag
	 */
	@Override
	public void setChallengeId(long challengeId) {
		model.setChallengeId(challengeId);
	}

	/**
	 * Sets the hashtag ID of this hashtag.
	 *
	 * @param hashtagId the hashtag ID of this hashtag
	 */
	@Override
	public void setHashtagId(long hashtagId) {
		model.setHashtagId(hashtagId);
	}

	/**
	 * Sets the mvcc version of this hashtag.
	 *
	 * @param mvccVersion the mvcc version of this hashtag
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this hashtag.
	 *
	 * @param name the name of this hashtag
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this hashtag.
	 *
	 * @param primaryKey the primary key of this hashtag
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected HashtagWrapper wrap(Hashtag hashtag) {
		return new HashtagWrapper(hashtag);
	}

}