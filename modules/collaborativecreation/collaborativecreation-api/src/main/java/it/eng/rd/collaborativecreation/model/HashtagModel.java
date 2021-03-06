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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Hashtag service. Represents a row in the &quot;COCREATION_Hashtag&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.rd.collaborativecreation.model.impl.HashtagModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.rd.collaborativecreation.model.impl.HashtagImpl</code>.
 * </p>
 *
 * @author ENGRD
 * @see Hashtag
 * @generated
 */
@ProviderType
public interface HashtagModel extends BaseModel<Hashtag>, MVCCModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a hashtag model instance should use the {@link Hashtag} interface instead.
	 */

	/**
	 * Returns the primary key of this hashtag.
	 *
	 * @return the primary key of this hashtag
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this hashtag.
	 *
	 * @param primaryKey the primary key of this hashtag
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this hashtag.
	 *
	 * @return the mvcc version of this hashtag
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this hashtag.
	 *
	 * @param mvccVersion the mvcc version of this hashtag
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the hashtag ID of this hashtag.
	 *
	 * @return the hashtag ID of this hashtag
	 */
	public long getHashtagId();

	/**
	 * Sets the hashtag ID of this hashtag.
	 *
	 * @param hashtagId the hashtag ID of this hashtag
	 */
	public void setHashtagId(long hashtagId);

	/**
	 * Returns the challenge ID of this hashtag.
	 *
	 * @return the challenge ID of this hashtag
	 */
	public long getChallengeId();

	/**
	 * Sets the challenge ID of this hashtag.
	 *
	 * @param challengeId the challenge ID of this hashtag
	 */
	public void setChallengeId(long challengeId);

	/**
	 * Returns the name of this hashtag.
	 *
	 * @return the name of this hashtag
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this hashtag.
	 *
	 * @param name the name of this hashtag
	 */
	public void setName(String name);

	/**
	 * Returns the asset tag ID of this hashtag.
	 *
	 * @return the asset tag ID of this hashtag
	 */
	public long getAssetTagId();

	/**
	 * Sets the asset tag ID of this hashtag.
	 *
	 * @param assetTagId the asset tag ID of this hashtag
	 */
	public void setAssetTagId(long assetTagId);

}