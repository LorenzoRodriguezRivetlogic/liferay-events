/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.rivetlogic.event.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rivetlogic.event.service.ClpSerializer;
import com.rivetlogic.event.service.TokenLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author juancarrillo
 */
public class TokenClp extends BaseModelImpl<Token> implements Token {
	public TokenClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Token.class;
	}

	@Override
	public String getModelClassName() {
		return Token.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tokenId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTokenId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tokenId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("tokenId", getTokenId());
		attributes.put("participantId", getParticipantId());
		attributes.put("expiredDate", getExpiredDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long tokenId = (Long)attributes.get("tokenId");

		if (tokenId != null) {
			setTokenId(tokenId);
		}

		Long participantId = (Long)attributes.get("participantId");

		if (participantId != null) {
			setParticipantId(participantId);
		}

		Date expiredDate = (Date)attributes.get("expiredDate");

		if (expiredDate != null) {
			setExpiredDate(expiredDate);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_tokenRemoteModel != null) {
			try {
				Class<?> clazz = _tokenRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_tokenRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTokenId() {
		return _tokenId;
	}

	@Override
	public void setTokenId(long tokenId) {
		_tokenId = tokenId;

		if (_tokenRemoteModel != null) {
			try {
				Class<?> clazz = _tokenRemoteModel.getClass();

				Method method = clazz.getMethod("setTokenId", long.class);

				method.invoke(_tokenRemoteModel, tokenId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParticipantId() {
		return _participantId;
	}

	@Override
	public void setParticipantId(long participantId) {
		_participantId = participantId;

		if (_tokenRemoteModel != null) {
			try {
				Class<?> clazz = _tokenRemoteModel.getClass();

				Method method = clazz.getMethod("setParticipantId", long.class);

				method.invoke(_tokenRemoteModel, participantId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpiredDate() {
		return _expiredDate;
	}

	@Override
	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;

		if (_tokenRemoteModel != null) {
			try {
				Class<?> clazz = _tokenRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiredDate", Date.class);

				method.invoke(_tokenRemoteModel, expiredDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean isExpired() {
		try {
			String methodName = "isExpired";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getTokenRemoteModel() {
		return _tokenRemoteModel;
	}

	public void setTokenRemoteModel(BaseModel<?> tokenRemoteModel) {
		_tokenRemoteModel = tokenRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _tokenRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_tokenRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TokenLocalServiceUtil.addToken(this);
		}
		else {
			TokenLocalServiceUtil.updateToken(this);
		}
	}

	@Override
	public Token toEscapedModel() {
		return (Token)ProxyUtil.newProxyInstance(Token.class.getClassLoader(),
			new Class[] { Token.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TokenClp clone = new TokenClp();

		clone.setUuid(getUuid());
		clone.setTokenId(getTokenId());
		clone.setParticipantId(getParticipantId());
		clone.setExpiredDate(getExpiredDate());

		return clone;
	}

	@Override
	public int compareTo(Token token) {
		long primaryKey = token.getPrimaryKey();

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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TokenClp)) {
			return false;
		}

		TokenClp token = (TokenClp)obj;

		long primaryKey = token.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", tokenId=");
		sb.append(getTokenId());
		sb.append(", participantId=");
		sb.append(getParticipantId());
		sb.append(", expiredDate=");
		sb.append(getExpiredDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.event.model.Token");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tokenId</column-name><column-value><![CDATA[");
		sb.append(getTokenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>participantId</column-name><column-value><![CDATA[");
		sb.append(getParticipantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredDate</column-name><column-value><![CDATA[");
		sb.append(getExpiredDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _tokenId;
	private long _participantId;
	private Date _expiredDate;
	private BaseModel<?> _tokenRemoteModel;
	private Class<?> _clpSerializerClass = com.rivetlogic.event.service.ClpSerializer.class;
}