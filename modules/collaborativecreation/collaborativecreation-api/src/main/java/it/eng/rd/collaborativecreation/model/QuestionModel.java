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
 * The base model interface for the Question service. Represents a row in the &quot;COCREATION_Question&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.rd.collaborativecreation.model.impl.QuestionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.rd.collaborativecreation.model.impl.QuestionImpl</code>.
 * </p>
 *
 * @author ENGRD
 * @see Question
 * @generated
 */
@ProviderType
public interface QuestionModel extends BaseModel<Question>, MVCCModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a question model instance should use the {@link Question} interface instead.
	 */

	/**
	 * Returns the primary key of this question.
	 *
	 * @return the primary key of this question
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this question.
	 *
	 * @param primaryKey the primary key of this question
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this question.
	 *
	 * @return the mvcc version of this question
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this question.
	 *
	 * @param mvccVersion the mvcc version of this question
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the question ID of this question.
	 *
	 * @return the question ID of this question
	 */
	public long getQuestionId();

	/**
	 * Sets the question ID of this question.
	 *
	 * @param questionId the question ID of this question
	 */
	public void setQuestionId(long questionId);

	/**
	 * Returns the description of this question.
	 *
	 * @return the description of this question
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this question.
	 *
	 * @param description the description of this question
	 */
	public void setDescription(String description);

	/**
	 * Returns the cocreation ID of this question.
	 *
	 * @return the cocreation ID of this question
	 */
	public long getCocreationId();

	/**
	 * Sets the cocreation ID of this question.
	 *
	 * @param cocreationId the cocreation ID of this question
	 */
	public void setCocreationId(long cocreationId);

}