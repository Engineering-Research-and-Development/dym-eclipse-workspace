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
 * This class is used by SOAP remote services, specifically {@link it.eng.rd.collaborativecreation.service.http.CocreatorServiceSoap}.
 *
 * @author ENGRD
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CocreatorSoap implements Serializable {

	public static CocreatorSoap toSoapModel(Cocreator model) {
		CocreatorSoap soapModel = new CocreatorSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setCocreatorId(model.getCocreatorId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCocreationId(model.getCocreationId());
		soapModel.setActivityId(model.getActivityId());

		return soapModel;
	}

	public static CocreatorSoap[] toSoapModels(Cocreator[] models) {
		CocreatorSoap[] soapModels = new CocreatorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CocreatorSoap[][] toSoapModels(Cocreator[][] models) {
		CocreatorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CocreatorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CocreatorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CocreatorSoap[] toSoapModels(List<Cocreator> models) {
		List<CocreatorSoap> soapModels = new ArrayList<CocreatorSoap>(
			models.size());

		for (Cocreator model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CocreatorSoap[soapModels.size()]);
	}

	public CocreatorSoap() {
	}

	public long getPrimaryKey() {
		return _cocreatorId;
	}

	public void setPrimaryKey(long pk) {
		setCocreatorId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCocreatorId() {
		return _cocreatorId;
	}

	public void setCocreatorId(long cocreatorId) {
		_cocreatorId = cocreatorId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getCocreationId() {
		return _cocreationId;
	}

	public void setCocreationId(long cocreationId) {
		_cocreationId = cocreationId;
	}

	public long getActivityId() {
		return _activityId;
	}

	public void setActivityId(long activityId) {
		_activityId = activityId;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _cocreatorId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private long _cocreationId;
	private long _activityId;

}