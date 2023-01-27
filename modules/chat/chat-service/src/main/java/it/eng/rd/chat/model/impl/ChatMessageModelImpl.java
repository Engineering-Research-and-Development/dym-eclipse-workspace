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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import it.eng.rd.chat.model.ChatMessage;
import it.eng.rd.chat.model.ChatMessageModel;
import it.eng.rd.chat.model.ChatMessageSoap;

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
 * The base model implementation for the ChatMessage service. Represents a row in the &quot;dym_ChatMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ChatMessageModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChatMessageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChatMessageImpl
 * @generated
 */
@JSON(strict = true)
public class ChatMessageModelImpl
	extends BaseModelImpl<ChatMessage> implements ChatMessageModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a chat message model instance should use the <code>ChatMessage</code> interface instead.
	 */
	public static final String TABLE_NAME = "dym_ChatMessage";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"fromUser", Types.BIGINT}, {"toUser", Types.BIGINT},
		{"sentDate", Types.TIMESTAMP}, {"readDate", Types.TIMESTAMP},
		{"message", Types.VARCHAR}, {"readed", Types.BOOLEAN},
		{"deleted", Types.BOOLEAN}, {"fileName", Types.VARCHAR},
		{"fileId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fromUser", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("toUser", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("sentDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("readDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("message", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("readed", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("deleted", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("fileName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table dym_ChatMessage (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,fromUser LONG,toUser LONG,sentDate DATE null,readDate DATE null,message VARCHAR(75) null,readed BOOLEAN,deleted BOOLEAN,fileName VARCHAR(75) null,fileId LONG)";

	public static final String TABLE_SQL_DROP = "drop table dym_ChatMessage";

	public static final String ORDER_BY_JPQL = " ORDER BY chatMessage.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY dym_ChatMessage.id_ ASC";

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
	public static final long TOUSER_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 16L;

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
	public static ChatMessage toModel(ChatMessageSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ChatMessage model = new ChatMessageImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setFromUser(soapModel.getFromUser());
		model.setToUser(soapModel.getToUser());
		model.setSentDate(soapModel.getSentDate());
		model.setReadDate(soapModel.getReadDate());
		model.setMessage(soapModel.getMessage());
		model.setReaded(soapModel.isReaded());
		model.setDeleted(soapModel.isDeleted());
		model.setFileName(soapModel.getFileName());
		model.setFileId(soapModel.getFileId());

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
	public static List<ChatMessage> toModels(ChatMessageSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ChatMessage> models = new ArrayList<ChatMessage>(
			soapModels.length);

		for (ChatMessageSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ChatMessageModelImpl() {
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
		return ChatMessage.class;
	}

	@Override
	public String getModelClassName() {
		return ChatMessage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ChatMessage, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ChatMessage, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChatMessage, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ChatMessage)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ChatMessage, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ChatMessage, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ChatMessage)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ChatMessage, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ChatMessage, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ChatMessage>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ChatMessage.class.getClassLoader(), ChatMessage.class,
			ModelWrapper.class);

		try {
			Constructor<ChatMessage> constructor =
				(Constructor<ChatMessage>)proxyClass.getConstructor(
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

	private static final Map<String, Function<ChatMessage, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ChatMessage, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ChatMessage, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ChatMessage, Object>>();
		Map<String, BiConsumer<ChatMessage, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ChatMessage, ?>>();

		attributeGetterFunctions.put("uuid", ChatMessage::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<ChatMessage, String>)ChatMessage::setUuid);
		attributeGetterFunctions.put("id", ChatMessage::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<ChatMessage, Long>)ChatMessage::setId);
		attributeGetterFunctions.put("groupId", ChatMessage::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<ChatMessage, Long>)ChatMessage::setGroupId);
		attributeGetterFunctions.put("companyId", ChatMessage::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ChatMessage, Long>)ChatMessage::setCompanyId);
		attributeGetterFunctions.put("fromUser", ChatMessage::getFromUser);
		attributeSetterBiConsumers.put(
			"fromUser",
			(BiConsumer<ChatMessage, Long>)ChatMessage::setFromUser);
		attributeGetterFunctions.put("toUser", ChatMessage::getToUser);
		attributeSetterBiConsumers.put(
			"toUser", (BiConsumer<ChatMessage, Long>)ChatMessage::setToUser);
		attributeGetterFunctions.put("sentDate", ChatMessage::getSentDate);
		attributeSetterBiConsumers.put(
			"sentDate",
			(BiConsumer<ChatMessage, Date>)ChatMessage::setSentDate);
		attributeGetterFunctions.put("readDate", ChatMessage::getReadDate);
		attributeSetterBiConsumers.put(
			"readDate",
			(BiConsumer<ChatMessage, Date>)ChatMessage::setReadDate);
		attributeGetterFunctions.put("message", ChatMessage::getMessage);
		attributeSetterBiConsumers.put(
			"message",
			(BiConsumer<ChatMessage, String>)ChatMessage::setMessage);
		attributeGetterFunctions.put("readed", ChatMessage::getReaded);
		attributeSetterBiConsumers.put(
			"readed", (BiConsumer<ChatMessage, Boolean>)ChatMessage::setReaded);
		attributeGetterFunctions.put("deleted", ChatMessage::getDeleted);
		attributeSetterBiConsumers.put(
			"deleted",
			(BiConsumer<ChatMessage, Boolean>)ChatMessage::setDeleted);
		attributeGetterFunctions.put("fileName", ChatMessage::getFileName);
		attributeSetterBiConsumers.put(
			"fileName",
			(BiConsumer<ChatMessage, String>)ChatMessage::setFileName);
		attributeGetterFunctions.put("fileId", ChatMessage::getFileId);
		attributeSetterBiConsumers.put(
			"fileId", (BiConsumer<ChatMessage, Long>)ChatMessage::setFileId);

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
	public long getFromUser() {
		return _fromUser;
	}

	@Override
	public void setFromUser(long fromUser) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fromUser = fromUser;
	}

	@JSON
	@Override
	public long getToUser() {
		return _toUser;
	}

	@Override
	public void setToUser(long toUser) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_toUser = toUser;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalToUser() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("toUser"));
	}

	@JSON
	@Override
	public Date getSentDate() {
		return _sentDate;
	}

	@Override
	public void setSentDate(Date sentDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sentDate = sentDate;
	}

	@JSON
	@Override
	public Date getReadDate() {
		return _readDate;
	}

	@Override
	public void setReadDate(Date readDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_readDate = readDate;
	}

	@JSON
	@Override
	public String getMessage() {
		if (_message == null) {
			return "";
		}
		else {
			return _message;
		}
	}

	@Override
	public void setMessage(String message) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_message = message;
	}

	@JSON
	@Override
	public boolean getReaded() {
		return _readed;
	}

	@JSON
	@Override
	public boolean isReaded() {
		return _readed;
	}

	@Override
	public void setReaded(boolean readed) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_readed = readed;
	}

	@JSON
	@Override
	public boolean getDeleted() {
		return _deleted;
	}

	@JSON
	@Override
	public boolean isDeleted() {
		return _deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_deleted = deleted;
	}

	@JSON
	@Override
	public String getFileName() {
		if (_fileName == null) {
			return "";
		}
		else {
			return _fileName;
		}
	}

	@Override
	public void setFileName(String fileName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileName = fileName;
	}

	@JSON
	@Override
	public long getFileId() {
		return _fileId;
	}

	@Override
	public void setFileId(long fileId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fileId = fileId;
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
			getCompanyId(), ChatMessage.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ChatMessage toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ChatMessage>
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
		ChatMessageImpl chatMessageImpl = new ChatMessageImpl();

		chatMessageImpl.setUuid(getUuid());
		chatMessageImpl.setId(getId());
		chatMessageImpl.setGroupId(getGroupId());
		chatMessageImpl.setCompanyId(getCompanyId());
		chatMessageImpl.setFromUser(getFromUser());
		chatMessageImpl.setToUser(getToUser());
		chatMessageImpl.setSentDate(getSentDate());
		chatMessageImpl.setReadDate(getReadDate());
		chatMessageImpl.setMessage(getMessage());
		chatMessageImpl.setReaded(isReaded());
		chatMessageImpl.setDeleted(isDeleted());
		chatMessageImpl.setFileName(getFileName());
		chatMessageImpl.setFileId(getFileId());

		chatMessageImpl.resetOriginalValues();

		return chatMessageImpl;
	}

	@Override
	public int compareTo(ChatMessage chatMessage) {
		long primaryKey = chatMessage.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChatMessage)) {
			return false;
		}

		ChatMessage chatMessage = (ChatMessage)object;

		long primaryKey = chatMessage.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ChatMessage> toCacheModel() {
		ChatMessageCacheModel chatMessageCacheModel =
			new ChatMessageCacheModel();

		chatMessageCacheModel.uuid = getUuid();

		String uuid = chatMessageCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			chatMessageCacheModel.uuid = null;
		}

		chatMessageCacheModel.id = getId();

		chatMessageCacheModel.groupId = getGroupId();

		chatMessageCacheModel.companyId = getCompanyId();

		chatMessageCacheModel.fromUser = getFromUser();

		chatMessageCacheModel.toUser = getToUser();

		Date sentDate = getSentDate();

		if (sentDate != null) {
			chatMessageCacheModel.sentDate = sentDate.getTime();
		}
		else {
			chatMessageCacheModel.sentDate = Long.MIN_VALUE;
		}

		Date readDate = getReadDate();

		if (readDate != null) {
			chatMessageCacheModel.readDate = readDate.getTime();
		}
		else {
			chatMessageCacheModel.readDate = Long.MIN_VALUE;
		}

		chatMessageCacheModel.message = getMessage();

		String message = chatMessageCacheModel.message;

		if ((message != null) && (message.length() == 0)) {
			chatMessageCacheModel.message = null;
		}

		chatMessageCacheModel.readed = isReaded();

		chatMessageCacheModel.deleted = isDeleted();

		chatMessageCacheModel.fileName = getFileName();

		String fileName = chatMessageCacheModel.fileName;

		if ((fileName != null) && (fileName.length() == 0)) {
			chatMessageCacheModel.fileName = null;
		}

		chatMessageCacheModel.fileId = getFileId();

		return chatMessageCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ChatMessage, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ChatMessage, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChatMessage, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ChatMessage)this));
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
		Map<String, Function<ChatMessage, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ChatMessage, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ChatMessage, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ChatMessage)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ChatMessage>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _fromUser;
	private long _toUser;
	private Date _sentDate;
	private Date _readDate;
	private String _message;
	private boolean _readed;
	private boolean _deleted;
	private String _fileName;
	private long _fileId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ChatMessage, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ChatMessage)this);
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
		_columnOriginalValues.put("fromUser", _fromUser);
		_columnOriginalValues.put("toUser", _toUser);
		_columnOriginalValues.put("sentDate", _sentDate);
		_columnOriginalValues.put("readDate", _readDate);
		_columnOriginalValues.put("message", _message);
		_columnOriginalValues.put("readed", _readed);
		_columnOriginalValues.put("deleted", _deleted);
		_columnOriginalValues.put("fileName", _fileName);
		_columnOriginalValues.put("fileId", _fileId);
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

		columnBitmasks.put("fromUser", 16L);

		columnBitmasks.put("toUser", 32L);

		columnBitmasks.put("sentDate", 64L);

		columnBitmasks.put("readDate", 128L);

		columnBitmasks.put("message", 256L);

		columnBitmasks.put("readed", 512L);

		columnBitmasks.put("deleted", 1024L);

		columnBitmasks.put("fileName", 2048L);

		columnBitmasks.put("fileId", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ChatMessage _escapedModel;

}