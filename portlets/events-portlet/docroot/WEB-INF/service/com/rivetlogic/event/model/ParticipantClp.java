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
import com.rivetlogic.event.service.ParticipantLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author juancarrillo
 */
public class ParticipantClp extends BaseModelImpl<Participant>
	implements Participant {
	public ParticipantClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Participant.class;
	}

	@Override
	public String getModelClassName() {
		return Participant.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _participantId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setParticipantId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _participantId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("participantId", getParticipantId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("eventId", getEventId());
		attributes.put("fullName", getFullName());
		attributes.put("email", getEmail());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("companyName", getCompanyName());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long participantId = (Long)attributes.get("participantId");

		if (participantId != null) {
			setParticipantId(participantId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_participantRemoteModel != null) {
			try {
				Class<?> clazz = _participantRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_participantRemoteModel, uuid);
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

		if (_participantRemoteModel != null) {
			try {
				Class<?> clazz = _participantRemoteModel.getClass();

				Method method = clazz.getMethod("setParticipantId", long.class);

				method.invoke(_participantRemoteModel, participantId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_participantRemoteModel != null) {
			try {
				Class<?> clazz = _participantRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_participantRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_participantRemoteModel != null) {
			try {
				Class<?> clazz = _participantRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_participantRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;

		if (_participantRemoteModel != null) {
			try {
				Class<?> clazz = _participantRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_participantRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFullName() {
		return _fullName;
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;

		if (_participantRemoteModel != null) {
			try {
				Class<?> clazz = _participantRemoteModel.getClass();

				Method method = clazz.getMethod("setFullName", String.class);

				method.invoke(_participantRemoteModel, fullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_participantRemoteModel != null) {
			try {
				Class<?> clazz = _participantRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_participantRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhoneNumber() {
		return _phoneNumber;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;

		if (_participantRemoteModel != null) {
			try {
				Class<?> clazz = _participantRemoteModel.getClass();

				Method method = clazz.getMethod("setPhoneNumber", String.class);

				method.invoke(_participantRemoteModel, phoneNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyName() {
		return _companyName;
	}

	@Override
	public void setCompanyName(String companyName) {
		_companyName = companyName;

		if (_participantRemoteModel != null) {
			try {
				Class<?> clazz = _participantRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyName", String.class);

				method.invoke(_participantRemoteModel, companyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_participantRemoteModel != null) {
			try {
				Class<?> clazz = _participantRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_participantRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getParticipantRemoteModel() {
		return _participantRemoteModel;
	}

	public void setParticipantRemoteModel(BaseModel<?> participantRemoteModel) {
		_participantRemoteModel = participantRemoteModel;
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

		Class<?> remoteModelClass = _participantRemoteModel.getClass();

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

		Object returnValue = method.invoke(_participantRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ParticipantLocalServiceUtil.addParticipant(this);
		}
		else {
			ParticipantLocalServiceUtil.updateParticipant(this);
		}
	}

	@Override
	public Participant toEscapedModel() {
		return (Participant)ProxyUtil.newProxyInstance(Participant.class.getClassLoader(),
			new Class[] { Participant.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ParticipantClp clone = new ParticipantClp();

		clone.setUuid(getUuid());
		clone.setParticipantId(getParticipantId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setEventId(getEventId());
		clone.setFullName(getFullName());
		clone.setEmail(getEmail());
		clone.setPhoneNumber(getPhoneNumber());
		clone.setCompanyName(getCompanyName());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(Participant participant) {
		int value = 0;

		value = getFullName().compareToIgnoreCase(participant.getFullName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ParticipantClp)) {
			return false;
		}

		ParticipantClp participant = (ParticipantClp)obj;

		long primaryKey = participant.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", participantId=");
		sb.append(getParticipantId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.event.model.Participant");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>participantId</column-name><column-value><![CDATA[");
		sb.append(getParticipantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyName</column-name><column-value><![CDATA[");
		sb.append(getCompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _participantId;
	private long _companyId;
	private long _groupId;
	private long _eventId;
	private String _fullName;
	private String _email;
	private String _phoneNumber;
	private String _companyName;
	private int _status;
	private BaseModel<?> _participantRemoteModel;
	private Class<?> _clpSerializerClass = com.rivetlogic.event.service.ClpSerializer.class;
}