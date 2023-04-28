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

package it.eng.rd.chat.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import it.eng.rd.chat.model.ChatConfigure;
import it.eng.rd.chat.model.ChatConfigureModel;
import it.eng.rd.chat.model.ChatConfigureSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ChatConfigure service. Represents a row in the &quot;dym_ChatConfigure&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ChatConfigureModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChatConfigureImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatConfigureImpl
 * @generated
 */
@JSON(strict = true)
public class ChatConfigureModelImpl
	extends BaseModelImpl<ChatConfigure> implements ChatConfigureModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a chat configure model instance should use the <code>ChatConfigure</code> interface instead.
	 */
	public static final String TABLE_NAME = "dym_ChatConfigure";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"enable", Types.BOOLEAN}, {"headerColor", Types.VARCHAR},
		{"chatRightColor", Types.VARCHAR}, {"chatLeftColor", Types.VARCHAR},
		{"headerTextColor", Types.VARCHAR}, {"contentTextColor", Types.VARCHAR},
		{"backColor", Types.VARCHAR}, {"chatRoleId", Types.VARCHAR},
		{"fontFamily", Types.VARCHAR}, {"requestFeature", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("enable", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("headerColor", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("chatRightColor", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("chatLeftColor", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("headerTextColor", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contentTextColor", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("backColor", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("chatRoleId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fontFamily", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("requestFeature", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dym_ChatConfigure (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,enable BOOLEAN,headerColor VARCHAR(75) null,chatRightColor VARCHAR(75) null,chatLeftColor VARCHAR(75) null,headerTextColor VARCHAR(75) null,contentTextColor VARCHAR(75) null,backColor VARCHAR(75) null,chatRoleId VARCHAR(75) null,fontFamily VARCHAR(75) null,requestFeature BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table dym_ChatConfigure";

	public static final String ORDER_BY_JPQL = " ORDER BY chatConfigure.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dym_ChatConfigure.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static ChatConfigure toModel(ChatConfigureSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ChatConfigure model = new ChatConfigureImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setEnable(soapModel.isEnable());
		model.setHeaderColor(soapModel.getHeaderColor());
		model.setChatRightColor(soapModel.getChatRightColor());
		model.setChatLeftColor(soapModel.getChatLeftColor());
		model.setHeaderTextColor(soapModel.getHeaderTextColor());
		model.setContentTextColor(soapModel.getContentTextColor());
		model.setBackColor(soapModel.getBackColor());
		model.setChatRoleId(soapModel.getChatRoleId());
		model.setFontFamily(soapModel.getFontFamily());
		model.setRequestFeature(soapModel.isRequestFeature());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<ChatConfigure> toModels(ChatConfigureSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ChatConfigure> models = new ArrayList<ChatConfigure>(
			soapModels.length);

		for (ChatConfigureSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ChatConfigureModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ChatConfigure.class;
	}

	@Override
	public String getModelClassName() {
		return ChatConfigure.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ChatConfigure, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ChatConfigure, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChatConfigure, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ChatConfigure)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ChatConfigure, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ChatConfigure, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ChatConfigure)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ChatConfigure, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ChatConfigure, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ChatConfigure>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ChatConfigure.class.getClassLoader(), ChatConfigure.class,
			ModelWrapper.class);

		try {
			Constructor<ChatConfigure> constructor =
				(Constructor<ChatConfigure>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<ChatConfigure, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ChatConfigure, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ChatConfigure, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ChatConfigure, Object>>();
		Map<String, BiConsumer<ChatConfigure, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ChatConfigure, ?>>();

		attributeGetterFunctions.put("uuid", ChatConfigure::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<ChatConfigure, String>)ChatConfigure::setUuid);
		attributeGetterFunctions.put("id", ChatConfigure::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<ChatConfigure, Long>)ChatConfigure::setId);
		attributeGetterFunctions.put("groupId", ChatConfigure::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ChatConfigure, Long>)ChatConfigure::setGroupId);
		attributeGetterFunctions.put("companyId", ChatConfigure::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ChatConfigure, Long>)ChatConfigure::setCompanyId);
		attributeGetterFunctions.put("userId", ChatConfigure::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ChatConfigure, Long>)ChatConfigure::setUserId);
		attributeGetterFunctions.put("userName", ChatConfigure::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ChatConfigure, String>)ChatConfigure::setUserName);
		attributeGetterFunctions.put(
			"createDate", ChatConfigure::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ChatConfigure, Date>)ChatConfigure::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ChatConfigure::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ChatConfigure, Date>)ChatConfigure::setModifiedDate);
		attributeGetterFunctions.put("enable", ChatConfigure::getEnable);
		attributeSetterBiConsumers.put(
			"enable",
			(BiConsumer<ChatConfigure, Boolean>)ChatConfigure::setEnable);
		attributeGetterFunctions.put(
			"headerColor", ChatConfigure::getHeaderColor);
		attributeSetterBiConsumers.put(
			"headerColor",
			(BiConsumer<ChatConfigure, String>)ChatConfigure::setHeaderColor);
		attributeGetterFunctions.put(
			"chatRightColor", ChatConfigure::getChatRightColor);
		attributeSetterBiConsumers.put(
			"chatRightColor",
			(BiConsumer<ChatConfigure, String>)
				ChatConfigure::setChatRightColor);
		attributeGetterFunctions.put(
			"chatLeftColor", ChatConfigure::getChatLeftColor);
		attributeSetterBiConsumers.put(
			"chatLeftColor",
			(BiConsumer<ChatConfigure, String>)ChatConfigure::setChatLeftColor);
		attributeGetterFunctions.put(
			"headerTextColor", ChatConfigure::getHeaderTextColor);
		attributeSetterBiConsumers.put(
			"headerTextColor",
			(BiConsumer<ChatConfigure, String>)
				ChatConfigure::setHeaderTextColor);
		attributeGetterFunctions.put(
			"contentTextColor", ChatConfigure::getContentTextColor);
		attributeSetterBiConsumers.put(
			"contentTextColor",
			(BiConsumer<ChatConfigure, String>)
				ChatConfigure::setContentTextColor);
		attributeGetterFunctions.put("backColor", ChatConfigure::getBackColor);
		attributeSetterBiConsumers.put(
			"backColor",
			(BiConsumer<ChatConfigure, String>)ChatConfigure::setBackColor);
		attributeGetterFunctions.put(
			"chatRoleId", ChatConfigure::getChatRoleId);
		attributeSetterBiConsumers.put(
			"chatRoleId",
			(BiConsumer<ChatConfigure, String>)ChatConfigure::setChatRoleId);
		attributeGetterFunctions.put(
			"fontFamily", ChatConfigure::getFontFamily);
		attributeSetterBiConsumers.put(
			"fontFamily",
			(BiConsumer<ChatConfigure, String>)ChatConfigure::setFontFamily);
		attributeGetterFunctions.put(
			"requestFeature", ChatConfigure::getRequestFeature);
		attributeSetterBiConsumers.put(
			"requestFeature",
			(BiConsumer<ChatConfigure, Boolean>)
				ChatConfigure::setRequestFeature);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public boolean getEnable() {
		return _enable;
	}

	@JSON
	@Override
	public boolean isEnable() {
		return _enable;
	}

	@Override
	public void setEnable(boolean enable) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_enable = enable;
	}

	@JSON
	@Override
	public String getHeaderColor() {
		if (_headerColor == null) {
			return "";
		}
		else {
			return _headerColor;
		}
	}

	@Override
	public void setHeaderColor(String headerColor) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_headerColor = headerColor;
	}

	@JSON
	@Override
	public String getChatRightColor() {
		if (_chatRightColor == null) {
			return "";
		}
		else {
			return _chatRightColor;
		}
	}

	@Override
	public void setChatRightColor(String chatRightColor) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_chatRightColor = chatRightColor;
	}

	@JSON
	@Override
	public String getChatLeftColor() {
		if (_chatLeftColor == null) {
			return "";
		}
		else {
			return _chatLeftColor;
		}
	}

	@Override
	public void setChatLeftColor(String chatLeftColor) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_chatLeftColor = chatLeftColor;
	}

	@JSON
	@Override
	public String getHeaderTextColor() {
		if (_headerTextColor == null) {
			return "";
		}
		else {
			return _headerTextColor;
		}
	}

	@Override
	public void setHeaderTextColor(String headerTextColor) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_headerTextColor = headerTextColor;
	}

	@JSON
	@Override
	public String getContentTextColor() {
		if (_contentTextColor == null) {
			return "";
		}
		else {
			return _contentTextColor;
		}
	}

	@Override
	public void setContentTextColor(String contentTextColor) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_contentTextColor = contentTextColor;
	}

	@JSON
	@Override
	public String getBackColor() {
		if (_backColor == null) {
			return "";
		}
		else {
			return _backColor;
		}
	}

	@Override
	public void setBackColor(String backColor) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_backColor = backColor;
	}

	@JSON
	@Override
	public String getChatRoleId() {
		if (_chatRoleId == null) {
			return "";
		}
		else {
			return _chatRoleId;
		}
	}

	@Override
	public void setChatRoleId(String chatRoleId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_chatRoleId = chatRoleId;
	}

	@JSON
	@Override
	public String getFontFamily() {
		if (_fontFamily == null) {
			return "";
		}
		else {
			return _fontFamily;
		}
	}

	@Override
	public void setFontFamily(String fontFamily) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fontFamily = fontFamily;
	}

	@JSON
	@Override
	public boolean getRequestFeature() {
		return _requestFeature;
	}

	@JSON
	@Override
	public boolean isRequestFeature() {
		return _requestFeature;
	}

	@Override
	public void setRequestFeature(boolean requestFeature) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_requestFeature = requestFeature;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ChatConfigure.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ChatConfigure.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ChatConfigure toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ChatConfigure>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ChatConfigureImpl chatConfigureImpl = new ChatConfigureImpl();

		chatConfigureImpl.setUuid(getUuid());
		chatConfigureImpl.setId(getId());
		chatConfigureImpl.setGroupId(getGroupId());
		chatConfigureImpl.setCompanyId(getCompanyId());
		chatConfigureImpl.setUserId(getUserId());
		chatConfigureImpl.setUserName(getUserName());
		chatConfigureImpl.setCreateDate(getCreateDate());
		chatConfigureImpl.setModifiedDate(getModifiedDate());
		chatConfigureImpl.setEnable(isEnable());
		chatConfigureImpl.setHeaderColor(getHeaderColor());
		chatConfigureImpl.setChatRightColor(getChatRightColor());
		chatConfigureImpl.setChatLeftColor(getChatLeftColor());
		chatConfigureImpl.setHeaderTextColor(getHeaderTextColor());
		chatConfigureImpl.setContentTextColor(getContentTextColor());
		chatConfigureImpl.setBackColor(getBackColor());
		chatConfigureImpl.setChatRoleId(getChatRoleId());
		chatConfigureImpl.setFontFamily(getFontFamily());
		chatConfigureImpl.setRequestFeature(isRequestFeature());

		chatConfigureImpl.resetOriginalValues();

		return chatConfigureImpl;
	}

	@Override
	public int compareTo(ChatConfigure chatConfigure) {
		int value = 0;

		if (getId() < chatConfigure.getId()) {
			value = -1;
		}
		else if (getId() > chatConfigure.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChatConfigure)) {
			return false;
		}

		ChatConfigure chatConfigure = (ChatConfigure)object;

		long primaryKey = chatConfigure.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ChatConfigure> toCacheModel() {
		ChatConfigureCacheModel chatConfigureCacheModel =
			new ChatConfigureCacheModel();

		chatConfigureCacheModel.uuid = getUuid();

		String uuid = chatConfigureCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			chatConfigureCacheModel.uuid = null;
		}

		chatConfigureCacheModel.id = getId();

		chatConfigureCacheModel.groupId = getGroupId();

		chatConfigureCacheModel.companyId = getCompanyId();

		chatConfigureCacheModel.userId = getUserId();

		chatConfigureCacheModel.userName = getUserName();

		String userName = chatConfigureCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			chatConfigureCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			chatConfigureCacheModel.createDate = createDate.getTime();
		}
		else {
			chatConfigureCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			chatConfigureCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			chatConfigureCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		chatConfigureCacheModel.enable = isEnable();

		chatConfigureCacheModel.headerColor = getHeaderColor();

		String headerColor = chatConfigureCacheModel.headerColor;

		if ((headerColor != null) && (headerColor.length() == 0)) {
			chatConfigureCacheModel.headerColor = null;
		}

		chatConfigureCacheModel.chatRightColor = getChatRightColor();

		String chatRightColor = chatConfigureCacheModel.chatRightColor;

		if ((chatRightColor != null) && (chatRightColor.length() == 0)) {
			chatConfigureCacheModel.chatRightColor = null;
		}

		chatConfigureCacheModel.chatLeftColor = getChatLeftColor();

		String chatLeftColor = chatConfigureCacheModel.chatLeftColor;

		if ((chatLeftColor != null) && (chatLeftColor.length() == 0)) {
			chatConfigureCacheModel.chatLeftColor = null;
		}

		chatConfigureCacheModel.headerTextColor = getHeaderTextColor();

		String headerTextColor = chatConfigureCacheModel.headerTextColor;

		if ((headerTextColor != null) && (headerTextColor.length() == 0)) {
			chatConfigureCacheModel.headerTextColor = null;
		}

		chatConfigureCacheModel.contentTextColor = getContentTextColor();

		String contentTextColor = chatConfigureCacheModel.contentTextColor;

		if ((contentTextColor != null) && (contentTextColor.length() == 0)) {
			chatConfigureCacheModel.contentTextColor = null;
		}

		chatConfigureCacheModel.backColor = getBackColor();

		String backColor = chatConfigureCacheModel.backColor;

		if ((backColor != null) && (backColor.length() == 0)) {
			chatConfigureCacheModel.backColor = null;
		}

		chatConfigureCacheModel.chatRoleId = getChatRoleId();

		String chatRoleId = chatConfigureCacheModel.chatRoleId;

		if ((chatRoleId != null) && (chatRoleId.length() == 0)) {
			chatConfigureCacheModel.chatRoleId = null;
		}

		chatConfigureCacheModel.fontFamily = getFontFamily();

		String fontFamily = chatConfigureCacheModel.fontFamily;

		if ((fontFamily != null) && (fontFamily.length() == 0)) {
			chatConfigureCacheModel.fontFamily = null;
		}

		chatConfigureCacheModel.requestFeature = isRequestFeature();

		return chatConfigureCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ChatConfigure, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ChatConfigure, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChatConfigure, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ChatConfigure)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ChatConfigure, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ChatConfigure, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChatConfigure, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ChatConfigure)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ChatConfigure>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _enable;
	private String _headerColor;
	private String _chatRightColor;
	private String _chatLeftColor;
	private String _headerTextColor;
	private String _contentTextColor;
	private String _backColor;
	private String _chatRoleId;
	private String _fontFamily;
	private boolean _requestFeature;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ChatConfigure, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ChatConfigure)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("id_", _id);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("enable", _enable);
		_columnOriginalValues.put("headerColor", _headerColor);
		_columnOriginalValues.put("chatRightColor", _chatRightColor);
		_columnOriginalValues.put("chatLeftColor", _chatLeftColor);
		_columnOriginalValues.put("headerTextColor", _headerTextColor);
		_columnOriginalValues.put("contentTextColor", _contentTextColor);
		_columnOriginalValues.put("backColor", _backColor);
		_columnOriginalValues.put("chatRoleId", _chatRoleId);
		_columnOriginalValues.put("fontFamily", _fontFamily);
		_columnOriginalValues.put("requestFeature", _requestFeature);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("id_", "id");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("id_", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("enable", 256L);

		columnBitmasks.put("headerColor", 512L);

		columnBitmasks.put("chatRightColor", 1024L);

		columnBitmasks.put("chatLeftColor", 2048L);

		columnBitmasks.put("headerTextColor", 4096L);

		columnBitmasks.put("contentTextColor", 8192L);

		columnBitmasks.put("backColor", 16384L);

		columnBitmasks.put("chatRoleId", 32768L);

		columnBitmasks.put("fontFamily", 65536L);

		columnBitmasks.put("requestFeature", 131072L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ChatConfigure _escapedModel;

}