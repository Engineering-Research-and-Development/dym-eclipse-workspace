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
 * The base model interface for the Category service. Represents a row in the &quot;COCREATION_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.rd.collaborativecreation.model.impl.CategoryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.rd.collaborativecreation.model.impl.CategoryImpl</code>.
 * </p>
 *
 * @author ENGRD
 * @see Category
 * @generated
 */
@ProviderType
public interface CategoryModel extends BaseModel<Category>, MVCCModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a category model instance should use the {@link Category} interface instead.
	 */

	/**
	 * Returns the primary key of this category.
	 *
	 * @return the primary key of this category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this category.
	 *
	 * @param primaryKey the primary key of this category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this category.
	 *
	 * @return the mvcc version of this category
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this category.
	 *
	 * @param mvccVersion the mvcc version of this category
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the category ID of this category.
	 *
	 * @return the category ID of this category
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this category.
	 *
	 * @param categoryId the category ID of this category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the challenge ID of this category.
	 *
	 * @return the challenge ID of this category
	 */
	public long getChallengeId();

	/**
	 * Sets the challenge ID of this category.
	 *
	 * @param challengeId the challenge ID of this category
	 */
	public void setChallengeId(long challengeId);

	/**
	 * Returns the name of this category.
	 *
	 * @return the name of this category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this category.
	 *
	 * @param name the name of this category
	 */
	public void setName(String name);

	/**
	 * Returns the asset category ID of this category.
	 *
	 * @return the asset category ID of this category
	 */
	public long getAssetCategoryId();

	/**
	 * Sets the asset category ID of this category.
	 *
	 * @param assetCategoryId the asset category ID of this category
	 */
	public void setAssetCategoryId(long assetCategoryId);

}