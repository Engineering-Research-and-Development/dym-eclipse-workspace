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

package it.eng.rd.chat.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChatConfigure}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatConfigure
 * @generated
 */
public class ChatConfigureWrapper
	extends BaseModelWrapper<ChatConfigure>
	implements ChatConfigure, ModelWrapper<ChatConfigure> {

	public ChatConfigureWrapper(ChatConfigure chatConfigure) {
		super(chatConfigure);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("enable", isEnable());
		attributes.put("headerColor", getHeaderColor());
		attributes.put("chatRightColor", getChatRightColor());
		attributes.put("chatLeftColor", getChatLeftColor());
		attributes.put("headerTextColor", getHeaderTextColor());
		attributes.put("contentTextColor", getContentTextColor());
		attributes.put("backColor", getBackColor());
		attributes.put("chatRoleId", getChatRoleId());
		attributes.put("fontFamily", getFontFamily());
		attributes.put("requestFeature", isRequestFeature());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean enable = (Boolean)attributes.get("enable");

		if (enable != null) {
			setEnable(enable);
		}

		String headerColor = (String)attributes.get("headerColor");

		if (headerColor != null) {
			setHeaderColor(headerColor);
		}

		String chatRightColor = (String)attributes.get("chatRightColor");

		if (chatRightColor != null) {
			setChatRightColor(chatRightColor);
		}

		String chatLeftColor = (String)attributes.get("chatLeftColor");

		if (chatLeftColor != null) {
			setChatLeftColor(chatLeftColor);
		}

		String headerTextColor = (String)attributes.get("headerTextColor");

		if (headerTextColor != null) {
			setHeaderTextColor(headerTextColor);
		}

		String contentTextColor = (String)attributes.get("contentTextColor");

		if (contentTextColor != null) {
			setContentTextColor(contentTextColor);
		}

		String backColor = (String)attributes.get("backColor");

		if (backColor != null) {
			setBackColor(backColor);
		}

		String chatRoleId = (String)attributes.get("chatRoleId");

		if (chatRoleId != null) {
			setChatRoleId(chatRoleId);
		}

		String fontFamily = (String)attributes.get("fontFamily");

		if (fontFamily != null) {
			setFontFamily(fontFamily);
		}

		Boolean requestFeature = (Boolean)attributes.get("requestFeature");

		if (requestFeature != null) {
			setRequestFeature(requestFeature);
		}
	}

	/**
	 * Returns the back color of this chat configure.
	 *
	 * @return the back color of this chat configure
	 */
	@Override
	public String getBackColor() {
		return model.getBackColor();
	}

	/**
	 * Returns the chat left color of this chat configure.
	 *
	 * @return the chat left color of this chat configure
	 */
	@Override
	public String getChatLeftColor() {
		return model.getChatLeftColor();
	}

	/**
	 * Returns the chat right color of this chat configure.
	 *
	 * @return the chat right color of this chat configure
	 */
	@Override
	public String getChatRightColor() {
		return model.getChatRightColor();
	}

	/**
	 * Returns the chat role ID of this chat configure.
	 *
	 * @return the chat role ID of this chat configure
	 */
	@Override
	public String getChatRoleId() {
		return model.getChatRoleId();
	}

	/**
	 * Returns the company ID of this chat configure.
	 *
	 * @return the company ID of this chat configure
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content text color of this chat configure.
	 *
	 * @return the content text color of this chat configure
	 */
	@Override
	public String getContentTextColor() {
		return model.getContentTextColor();
	}

	/**
	 * Returns the create date of this chat configure.
	 *
	 * @return the create date of this chat configure
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the enable of this chat configure.
	 *
	 * @return the enable of this chat configure
	 */
	@Override
	public boolean getEnable() {
		return model.getEnable();
	}

	/**
	 * Returns the font family of this chat configure.
	 *
	 * @return the font family of this chat configure
	 */
	@Override
	public String getFontFamily() {
		return model.getFontFamily();
	}

	/**
	 * Returns the group ID of this chat configure.
	 *
	 * @return the group ID of this chat configure
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the header color of this chat configure.
	 *
	 * @return the header color of this chat configure
	 */
	@Override
	public String getHeaderColor() {
		return model.getHeaderColor();
	}

	/**
	 * Returns the header text color of this chat configure.
	 *
	 * @return the header text color of this chat configure
	 */
	@Override
	public String getHeaderTextColor() {
		return model.getHeaderTextColor();
	}

	/**
	 * Returns the ID of this chat configure.
	 *
	 * @return the ID of this chat configure
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this chat configure.
	 *
	 * @return the modified date of this chat configure
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this chat configure.
	 *
	 * @return the primary key of this chat configure
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the request feature of this chat configure.
	 *
	 * @return the request feature of this chat configure
	 */
	@Override
	public boolean getRequestFeature() {
		return model.getRequestFeature();
	}

	/**
	 * Returns the user ID of this chat configure.
	 *
	 * @return the user ID of this chat configure
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this chat configure.
	 *
	 * @return the user name of this chat configure
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this chat configure.
	 *
	 * @return the user uuid of this chat configure
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this chat configure.
	 *
	 * @return the uuid of this chat configure
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this chat configure is enable.
	 *
	 * @return <code>true</code> if this chat configure is enable; <code>false</code> otherwise
	 */
	@Override
	public boolean isEnable() {
		return model.isEnable();
	}

	/**
	 * Returns <code>true</code> if this chat configure is request feature.
	 *
	 * @return <code>true</code> if this chat configure is request feature; <code>false</code> otherwise
	 */
	@Override
	public boolean isRequestFeature() {
		return model.isRequestFeature();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the back color of this chat configure.
	 *
	 * @param backColor the back color of this chat configure
	 */
	@Override
	public void setBackColor(String backColor) {
		model.setBackColor(backColor);
	}

	/**
	 * Sets the chat left color of this chat configure.
	 *
	 * @param chatLeftColor the chat left color of this chat configure
	 */
	@Override
	public void setChatLeftColor(String chatLeftColor) {
		model.setChatLeftColor(chatLeftColor);
	}

	/**
	 * Sets the chat right color of this chat configure.
	 *
	 * @param chatRightColor the chat right color of this chat configure
	 */
	@Override
	public void setChatRightColor(String chatRightColor) {
		model.setChatRightColor(chatRightColor);
	}

	/**
	 * Sets the chat role ID of this chat configure.
	 *
	 * @param chatRoleId the chat role ID of this chat configure
	 */
	@Override
	public void setChatRoleId(String chatRoleId) {
		model.setChatRoleId(chatRoleId);
	}

	/**
	 * Sets the company ID of this chat configure.
	 *
	 * @param companyId the company ID of this chat configure
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content text color of this chat configure.
	 *
	 * @param contentTextColor the content text color of this chat configure
	 */
	@Override
	public void setContentTextColor(String contentTextColor) {
		model.setContentTextColor(contentTextColor);
	}

	/**
	 * Sets the create date of this chat configure.
	 *
	 * @param createDate the create date of this chat configure
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this chat configure is enable.
	 *
	 * @param enable the enable of this chat configure
	 */
	@Override
	public void setEnable(boolean enable) {
		model.setEnable(enable);
	}

	/**
	 * Sets the font family of this chat configure.
	 *
	 * @param fontFamily the font family of this chat configure
	 */
	@Override
	public void setFontFamily(String fontFamily) {
		model.setFontFamily(fontFamily);
	}

	/**
	 * Sets the group ID of this chat configure.
	 *
	 * @param groupId the group ID of this chat configure
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the header color of this chat configure.
	 *
	 * @param headerColor the header color of this chat configure
	 */
	@Override
	public void setHeaderColor(String headerColor) {
		model.setHeaderColor(headerColor);
	}

	/**
	 * Sets the header text color of this chat configure.
	 *
	 * @param headerTextColor the header text color of this chat configure
	 */
	@Override
	public void setHeaderTextColor(String headerTextColor) {
		model.setHeaderTextColor(headerTextColor);
	}

	/**
	 * Sets the ID of this chat configure.
	 *
	 * @param id the ID of this chat configure
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified date of this chat configure.
	 *
	 * @param modifiedDate the modified date of this chat configure
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this chat configure.
	 *
	 * @param primaryKey the primary key of this chat configure
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this chat configure is request feature.
	 *
	 * @param requestFeature the request feature of this chat configure
	 */
	@Override
	public void setRequestFeature(boolean requestFeature) {
		model.setRequestFeature(requestFeature);
	}

	/**
	 * Sets the user ID of this chat configure.
	 *
	 * @param userId the user ID of this chat configure
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this chat configure.
	 *
	 * @param userName the user name of this chat configure
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this chat configure.
	 *
	 * @param userUuid the user uuid of this chat configure
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this chat configure.
	 *
	 * @param uuid the uuid of this chat configure
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ChatConfigureWrapper wrap(ChatConfigure chatConfigure) {
		return new ChatConfigureWrapper(chatConfigure);
	}

}