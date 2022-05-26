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

package it.eng.rd.sandbox.request.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.rd.sandbox.request.service.http.SandboxServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SandboxSoap implements Serializable {

	public static SandboxSoap toSoapModel(Sandbox model) {
		SandboxSoap soapModel = new SandboxSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSandboxId(model.getSandboxId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SandboxSoap[] toSoapModels(Sandbox[] models) {
		SandboxSoap[] soapModels = new SandboxSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SandboxSoap[][] toSoapModels(Sandbox[][] models) {
		SandboxSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SandboxSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SandboxSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SandboxSoap[] toSoapModels(List<Sandbox> models) {
		List<SandboxSoap> soapModels = new ArrayList<SandboxSoap>(
			models.size());

		for (Sandbox model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SandboxSoap[soapModels.size()]);
	}

	public SandboxSoap() {
	}

	public long getPrimaryKey() {
		return _sandboxId;
	}

	public void setPrimaryKey(long pk) {
		setSandboxId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSandboxId() {
		return _sandboxId;
	}

	public void setSandboxId(long sandboxId) {
		_sandboxId = sandboxId;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _sandboxId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}