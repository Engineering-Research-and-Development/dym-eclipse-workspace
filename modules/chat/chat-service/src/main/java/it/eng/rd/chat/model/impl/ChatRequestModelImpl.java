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
import com.liferay.portal.kernel.util.ProxyUtil;

import it.eng.rd.chat.model.ChatRequest;
import it.eng.rd.chat.model.ChatRequestModel;
import it.eng.rd.chat.model.ChatRequestSoap;

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
 * The base model implementation for the ChatRequest service. Represents a row in the &quot;dym_ChatRequest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ChatRequestModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChatRequestImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatRequestImpl
 * @generated
 */
@JSON(strict = true)
public class ChatRequestModelImpl
	extends BaseModelImpl<ChatRequest> implements ChatRequestModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a chat request model instance should use the <code>ChatRequest</code> interface instead.
	 */
	public static final String TABLE_NAME = "dym_ChatRequest";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"fromUserId", Types.BIGINT}, {"toUserId", Types.BIGINT},
		{"isAccepted", Types.BOOLEAN}, {"isRejected", Types.BOOLEAN},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fromUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("toUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("isAccepted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("isRejected", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dym_ChatRequest (uuid_ VARCHAR(75) null,id_ LONG not null primary key,fromUserId LONG,toUserId LONG,isAccepted BOOLEAN,isRejected BOOLEAN,createDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table dym_ChatRequest";

	public static final String ORDER_BY_JPQL = " ORDER BY chatRequest.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dym_ChatRequest.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ISACCEPTED_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 4L;

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
	public static ChatRequest toModel(ChatRequestSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ChatRequest model = new ChatRequestImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setFromUserId(soapModel.getFromUserId());
		model.setToUserId(soapModel.getToUserId());
		model.setIsAccepted(soapModel.isIsAccepted());
		model.setIsRejected(soapModel.isIsRejected());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

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
	public static List<ChatRequest> toModels(ChatRequestSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ChatRequest> models = new ArrayList<ChatRequest>(
			soapModels.length);

		for (ChatRequestSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ChatRequestModelImpl() {
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
		return ChatRequest.class;
	}

	@Override
	public String getModelClassName() {
		return ChatRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ChatRequest, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ChatRequest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChatRequest, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ChatRequest)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ChatRequest, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ChatRequest, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ChatRequest)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ChatRequest, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ChatRequest, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ChatRequest>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ChatRequest.class.getClassLoader(), ChatRequest.class,
			ModelWrapper.class);

		try {
			Constructor<ChatRequest> constructor =
				(Constructor<ChatRequest>)proxyClass.getConstructor(
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

	private static final Map<String, Function<ChatRequest, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ChatRequest, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ChatRequest, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ChatRequest, Object>>();
		Map<String, BiConsumer<ChatRequest, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ChatRequest, ?>>();

		attributeGetterFunctions.put("uuid", ChatRequest::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<ChatRequest, String>)ChatRequest::setUuid);
		attributeGetterFunctions.put("id", ChatRequest::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<ChatRequest, Long>)ChatRequest::setId);
		attributeGetterFunctions.put("fromUserId", ChatRequest::getFromUserId);
		attributeSetterBiConsumers.put(
			"fromUserId",
			(BiConsumer<ChatRequest, Long>)ChatRequest::setFromUserId);
		attributeGetterFunctions.put("toUserId", ChatRequest::getToUserId);
		attributeSetterBiConsumers.put(
			"toUserId",
			(BiConsumer<ChatRequest, Long>)ChatRequest::setToUserId);
		attributeGetterFunctions.put("isAccepted", ChatRequest::getIsAccepted);
		attributeSetterBiConsumers.put(
			"isAccepted",
			(BiConsumer<ChatRequest, Boolean>)ChatRequest::setIsAccepted);
		attributeGetterFunctions.put("isRejected", ChatRequest::getIsRejected);
		attributeSetterBiConsumers.put(
			"isRejected",
			(BiConsumer<ChatRequest, Boolean>)ChatRequest::setIsRejected);
		attributeGetterFunctions.put("createDate", ChatRequest::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ChatRequest, Date>)ChatRequest::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ChatRequest::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ChatRequest, Date>)ChatRequest::setModifiedDate);

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
	public long getFromUserId() {
		return _fromUserId;
	}

	@Override
	public void setFromUserId(long fromUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fromUserId = fromUserId;
	}

	@Override
	public String getFromUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getFromUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setFromUserUuid(String fromUserUuid) {
	}

	@JSON
	@Override
	public long getToUserId() {
		return _toUserId;
	}

	@Override
	public void setToUserId(long toUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_toUserId = toUserId;
	}

	@Override
	public String getToUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getToUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setToUserUuid(String toUserUuid) {
	}

	@JSON
	@Override
	public boolean getIsAccepted() {
		return _isAccepted;
	}

	@JSON
	@Override
	public boolean isIsAccepted() {
		return _isAccepted;
	}

	@Override
	public void setIsAccepted(boolean isAccepted) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isAccepted = isAccepted;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalIsAccepted() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("isAccepted"));
	}

	@JSON
	@Override
	public boolean getIsRejected() {
		return _isRejected;
	}

	@JSON
	@Override
	public boolean isIsRejected() {
		return _isRejected;
	}

	@Override
	public void setIsRejected(boolean isRejected) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isRejected = isRejected;
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
			0, ChatRequest.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ChatRequest toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ChatRequest>
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
		ChatRequestImpl chatRequestImpl = new ChatRequestImpl();

		chatRequestImpl.setUuid(getUuid());
		chatRequestImpl.setId(getId());
		chatRequestImpl.setFromUserId(getFromUserId());
		chatRequestImpl.setToUserId(getToUserId());
		chatRequestImpl.setIsAccepted(isIsAccepted());
		chatRequestImpl.setIsRejected(isIsRejected());
		chatRequestImpl.setCreateDate(getCreateDate());
		chatRequestImpl.setModifiedDate(getModifiedDate());

		chatRequestImpl.resetOriginalValues();

		return chatRequestImpl;
	}

	@Override
	public int compareTo(ChatRequest chatRequest) {
		int value = 0;

		if (getId() < chatRequest.getId()) {
			value = -1;
		}
		else if (getId() > chatRequest.getId()) {
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

		if (!(object instanceof ChatRequest)) {
			return false;
		}

		ChatRequest chatRequest = (ChatRequest)object;

		long primaryKey = chatRequest.getPrimaryKey();

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
	public CacheModel<ChatRequest> toCacheModel() {
		ChatRequestCacheModel chatRequestCacheModel =
			new ChatRequestCacheModel();

		chatRequestCacheModel.uuid = getUuid();

		String uuid = chatRequestCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			chatRequestCacheModel.uuid = null;
		}

		chatRequestCacheModel.id = getId();

		chatRequestCacheModel.fromUserId = getFromUserId();

		chatRequestCacheModel.toUserId = getToUserId();

		chatRequestCacheModel.isAccepted = isIsAccepted();

		chatRequestCacheModel.isRejected = isIsRejected();

		Date createDate = getCreateDate();

		if (createDate != null) {
			chatRequestCacheModel.createDate = createDate.getTime();
		}
		else {
			chatRequestCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			chatRequestCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			chatRequestCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return chatRequestCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ChatRequest, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ChatRequest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChatRequest, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ChatRequest)this));
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
		Map<String, Function<ChatRequest, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ChatRequest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChatRequest, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ChatRequest)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ChatRequest>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _id;
	private long _fromUserId;
	private long _toUserId;
	private boolean _isAccepted;
	private boolean _isRejected;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ChatRequest, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ChatRequest)this);
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
		_columnOriginalValues.put("fromUserId", _fromUserId);
		_columnOriginalValues.put("toUserId", _toUserId);
		_columnOriginalValues.put("isAccepted", _isAccepted);
		_columnOriginalValues.put("isRejected", _isRejected);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
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

		columnBitmasks.put("fromUserId", 4L);

		columnBitmasks.put("toUserId", 8L);

		columnBitmasks.put("isAccepted", 16L);

		columnBitmasks.put("isRejected", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ChatRequest _escapedModel;

}