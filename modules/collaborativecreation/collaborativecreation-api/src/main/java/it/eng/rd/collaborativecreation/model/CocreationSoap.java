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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.rd.collaborativecreation.service.http.CocreationServiceSoap}.
 *
 * @author ENGRD
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CocreationSoap implements Serializable {

	public static CocreationSoap toSoapModel(Cocreation model) {
		CocreationSoap soapModel = new CocreationSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setCocreationId(model.getCocreationId());
		soapModel.setChallengeId(model.getChallengeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setDlFolderName(model.getDlFolderName());
		soapModel.setLdFolderId(model.getLdFolderId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static CocreationSoap[] toSoapModels(Cocreation[] models) {
		CocreationSoap[] soapModels = new CocreationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CocreationSoap[][] toSoapModels(Cocreation[][] models) {
		CocreationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CocreationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CocreationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CocreationSoap[] toSoapModels(List<Cocreation> models) {
		List<CocreationSoap> soapModels = new ArrayList<CocreationSoap>(
			models.size());

		for (Cocreation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CocreationSoap[soapModels.size()]);
	}

	public CocreationSoap() {
	}

	public long getPrimaryKey() {
		return _cocreationId;
	}

	public void setPrimaryKey(long pk) {
		setCocreationId(pk);
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

	public long getCocreationId() {
		return _cocreationId;
	}

	public void setCocreationId(long cocreationId) {
		_cocreationId = cocreationId;
	}

	public long getChallengeId() {
		return _challengeId;
	}

	public void setChallengeId(long challengeId) {
		_challengeId = challengeId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getDlFolderName() {
		return _dlFolderName;
	}

	public void setDlFolderName(String dlFolderName) {
		_dlFolderName = dlFolderName;
	}

	public long getLdFolderId() {
		return _ldFolderId;
	}

	public void setLdFolderId(long ldFolderId) {
		_ldFolderId = ldFolderId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _cocreationId;
	private long _challengeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private String _dlFolderName;
	private long _ldFolderId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

}