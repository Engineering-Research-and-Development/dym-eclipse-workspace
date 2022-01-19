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
 * This class is used by SOAP remote services, specifically {@link it.eng.rd.collaborativecreation.service.http.CategoryServiceSoap}.
 *
 * @author ENGRD
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CategorySoap implements Serializable {

	public static CategorySoap toSoapModel(Category model) {
		CategorySoap soapModel = new CategorySoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setChallengeId(model.getChallengeId());
		soapModel.setName(model.getName());
		soapModel.setAssetCategoryId(model.getAssetCategoryId());

		return soapModel;
	}

	public static CategorySoap[] toSoapModels(Category[] models) {
		CategorySoap[] soapModels = new CategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CategorySoap[][] toSoapModels(Category[][] models) {
		CategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CategorySoap[] toSoapModels(List<Category> models) {
		List<CategorySoap> soapModels = new ArrayList<CategorySoap>(
			models.size());

		for (Category model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CategorySoap[soapModels.size()]);
	}

	public CategorySoap() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
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

	public long getAssetCategoryId() {
		return _assetCategoryId;
	}

	public void setAssetCategoryId(long assetCategoryId) {
		_assetCategoryId = assetCategoryId;
	}

	private long _mvccVersion;
	private long _categoryId;
	private long _challengeId;
	private String _name;
	private long _assetCategoryId;

}