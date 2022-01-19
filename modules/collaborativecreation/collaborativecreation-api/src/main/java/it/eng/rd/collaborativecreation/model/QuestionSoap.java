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
 * This class is used by SOAP remote services, specifically {@link it.eng.rd.collaborativecreation.service.http.QuestionServiceSoap}.
 *
 * @author ENGRD
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuestionSoap implements Serializable {

	public static QuestionSoap toSoapModel(Question model) {
		QuestionSoap soapModel = new QuestionSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setDescription(model.getDescription());
		soapModel.setCocreationId(model.getCocreationId());

		return soapModel;
	}

	public static QuestionSoap[] toSoapModels(Question[] models) {
		QuestionSoap[] soapModels = new QuestionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuestionSoap[][] toSoapModels(Question[][] models) {
		QuestionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuestionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuestionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuestionSoap[] toSoapModels(List<Question> models) {
		List<QuestionSoap> soapModels = new ArrayList<QuestionSoap>(
			models.size());

		for (Question model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuestionSoap[soapModels.size()]);
	}

	public QuestionSoap() {
	}

	public long getPrimaryKey() {
		return _questionId;
	}

	public void setPrimaryKey(long pk) {
		setQuestionId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getCocreationId() {
		return _cocreationId;
	}

	public void setCocreationId(long cocreationId) {
		_cocreationId = cocreationId;
	}

	private long _mvccVersion;
	private long _questionId;
	private String _description;
	private long _cocreationId;

}