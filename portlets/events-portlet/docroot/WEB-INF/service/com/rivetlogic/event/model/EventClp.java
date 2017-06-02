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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rivetlogic.event.service.ClpSerializer;
import com.rivetlogic.event.service.EventLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author juancarrillo
 */
public class EventClp extends BaseModelImpl<Event> implements Event {
	public EventClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Event.class;
	}

	@Override
	public String getModelClassName() {
		return Event.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventId", getEventId());
		attributes.put("calendarBookingId", getCalendarBookingId());
		attributes.put("calendarId", getCalendarId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("location", getLocation());
		attributes.put("description", getDescription());
		attributes.put("tags", getTags());
		attributes.put("eventDate", getEventDate());
		attributes.put("eventEndDate", getEventEndDate());
		attributes.put("privateEvent", getPrivateEvent());
		attributes.put("registrationRequired", getRegistrationRequired());
		attributes.put("requiredFullName", getRequiredFullName());
		attributes.put("requiredEmail", getRequiredEmail());
		attributes.put("requiredPhone", getRequiredPhone());
		attributes.put("locationId", getLocationId());
		attributes.put("targetId", getTargetId());
		attributes.put("typeId", getTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long calendarBookingId = (Long)attributes.get("calendarBookingId");

		if (calendarBookingId != null) {
			setCalendarBookingId(calendarBookingId);
		}

		Long calendarId = (Long)attributes.get("calendarId");

		if (calendarId != null) {
			setCalendarId(calendarId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}

		Date eventDate = (Date)attributes.get("eventDate");

		if (eventDate != null) {
			setEventDate(eventDate);
		}

		Date eventEndDate = (Date)attributes.get("eventEndDate");

		if (eventEndDate != null) {
			setEventEndDate(eventEndDate);
		}

		Boolean privateEvent = (Boolean)attributes.get("privateEvent");

		if (privateEvent != null) {
			setPrivateEvent(privateEvent);
		}

		Boolean registrationRequired = (Boolean)attributes.get(
				"registrationRequired");

		if (registrationRequired != null) {
			setRegistrationRequired(registrationRequired);
		}

		Boolean requiredFullName = (Boolean)attributes.get("requiredFullName");

		if (requiredFullName != null) {
			setRequiredFullName(requiredFullName);
		}

		Boolean requiredEmail = (Boolean)attributes.get("requiredEmail");

		if (requiredEmail != null) {
			setRequiredEmail(requiredEmail);
		}

		Boolean requiredPhone = (Boolean)attributes.get("requiredPhone");

		if (requiredPhone != null) {
			setRequiredPhone(requiredPhone);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long targetId = (Long)attributes.get("targetId");

		if (targetId != null) {
			setTargetId(targetId);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_eventRemoteModel, uuid);
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

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_eventRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCalendarBookingId() {
		return _calendarBookingId;
	}

	@Override
	public void setCalendarBookingId(long calendarBookingId) {
		_calendarBookingId = calendarBookingId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setCalendarBookingId",
						long.class);

				method.invoke(_eventRemoteModel, calendarBookingId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCalendarId() {
		return _calendarId;
	}

	@Override
	public void setCalendarId(long calendarId) {
		_calendarId = calendarId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setCalendarId", long.class);

				method.invoke(_eventRemoteModel, calendarId);
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

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_eventRemoteModel, groupId);
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

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eventRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_eventRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_eventRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocation() {
		return _location;
	}

	@Override
	public void setLocation(String location) {
		_location = location;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_eventRemoteModel, location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_eventRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTags() {
		return _tags;
	}

	@Override
	public void setTags(String tags) {
		_tags = tags;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setTags", String.class);

				method.invoke(_eventRemoteModel, tags);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEventDate() {
		return _eventDate;
	}

	@Override
	public void setEventDate(Date eventDate) {
		_eventDate = eventDate;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDate", Date.class);

				method.invoke(_eventRemoteModel, eventDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEventEndDate() {
		return _eventEndDate;
	}

	@Override
	public void setEventEndDate(Date eventEndDate) {
		_eventEndDate = eventEndDate;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventEndDate", Date.class);

				method.invoke(_eventRemoteModel, eventEndDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPrivateEvent() {
		return _privateEvent;
	}

	@Override
	public boolean isPrivateEvent() {
		return _privateEvent;
	}

	@Override
	public void setPrivateEvent(boolean privateEvent) {
		_privateEvent = privateEvent;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setPrivateEvent", boolean.class);

				method.invoke(_eventRemoteModel, privateEvent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRegistrationRequired() {
		return _registrationRequired;
	}

	@Override
	public boolean isRegistrationRequired() {
		return _registrationRequired;
	}

	@Override
	public void setRegistrationRequired(boolean registrationRequired) {
		_registrationRequired = registrationRequired;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setRegistrationRequired",
						boolean.class);

				method.invoke(_eventRemoteModel, registrationRequired);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRequiredFullName() {
		return _requiredFullName;
	}

	@Override
	public boolean isRequiredFullName() {
		return _requiredFullName;
	}

	@Override
	public void setRequiredFullName(boolean requiredFullName) {
		_requiredFullName = requiredFullName;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredFullName",
						boolean.class);

				method.invoke(_eventRemoteModel, requiredFullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRequiredEmail() {
		return _requiredEmail;
	}

	@Override
	public boolean isRequiredEmail() {
		return _requiredEmail;
	}

	@Override
	public void setRequiredEmail(boolean requiredEmail) {
		_requiredEmail = requiredEmail;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredEmail",
						boolean.class);

				method.invoke(_eventRemoteModel, requiredEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRequiredPhone() {
		return _requiredPhone;
	}

	@Override
	public boolean isRequiredPhone() {
		return _requiredPhone;
	}

	@Override
	public void setRequiredPhone(boolean requiredPhone) {
		_requiredPhone = requiredPhone;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredPhone",
						boolean.class);

				method.invoke(_eventRemoteModel, requiredPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLocationId() {
		return _locationId;
	}

	@Override
	public void setLocationId(long locationId) {
		_locationId = locationId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationId", long.class);

				method.invoke(_eventRemoteModel, locationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTargetId() {
		return _targetId;
	}

	@Override
	public void setTargetId(long targetId) {
		_targetId = targetId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetId", long.class);

				method.invoke(_eventRemoteModel, targetId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTypeId() {
		return _typeId;
	}

	@Override
	public void setTypeId(long typeId) {
		_typeId = typeId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeId", long.class);

				method.invoke(_eventRemoteModel, typeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.util.List<com.rivetlogic.event.model.Participant> getParticipants() {
		try {
			String methodName = "getParticipants";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<com.rivetlogic.event.model.Participant> returnObj = (java.util.List<com.rivetlogic.event.model.Participant>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<com.rivetlogic.event.model.Participant> getParticipants(
		int[] statuses) {
		try {
			String methodName = "getParticipants";

			Class<?>[] parameterTypes = new Class<?>[] { int.class };

			Object[] parameterValues = new Object[] { statuses };

			java.util.List<com.rivetlogic.event.model.Participant> returnObj = (java.util.List<com.rivetlogic.event.model.Participant>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isPast() {
		try {
			String methodName = "isPast";

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

	public BaseModel<?> getEventRemoteModel() {
		return _eventRemoteModel;
	}

	public void setEventRemoteModel(BaseModel<?> eventRemoteModel) {
		_eventRemoteModel = eventRemoteModel;
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

		Class<?> remoteModelClass = _eventRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventLocalServiceUtil.addEvent(this);
		}
		else {
			EventLocalServiceUtil.updateEvent(this);
		}
	}

	@Override
	public Event toEscapedModel() {
		return (Event)ProxyUtil.newProxyInstance(Event.class.getClassLoader(),
			new Class[] { Event.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventClp clone = new EventClp();

		clone.setUuid(getUuid());
		clone.setEventId(getEventId());
		clone.setCalendarBookingId(getCalendarBookingId());
		clone.setCalendarId(getCalendarId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setName(getName());
		clone.setLocation(getLocation());
		clone.setDescription(getDescription());
		clone.setTags(getTags());
		clone.setEventDate(getEventDate());
		clone.setEventEndDate(getEventEndDate());
		clone.setPrivateEvent(getPrivateEvent());
		clone.setRegistrationRequired(getRegistrationRequired());
		clone.setRequiredFullName(getRequiredFullName());
		clone.setRequiredEmail(getRequiredEmail());
		clone.setRequiredPhone(getRequiredPhone());
		clone.setLocationId(getLocationId());
		clone.setTargetId(getTargetId());
		clone.setTypeId(getTypeId());

		return clone;
	}

	@Override
	public int compareTo(Event event) {
		int value = 0;

		value = DateUtil.compareTo(getEventDate(), event.getEventDate());

		if (value != 0) {
			return value;
		}

		value = getName().compareToIgnoreCase(event.getName());

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

		if (!(obj instanceof EventClp)) {
			return false;
		}

		EventClp event = (EventClp)obj;

		long primaryKey = event.getPrimaryKey();

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
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append(", calendarBookingId=");
		sb.append(getCalendarBookingId());
		sb.append(", calendarId=");
		sb.append(getCalendarId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", tags=");
		sb.append(getTags());
		sb.append(", eventDate=");
		sb.append(getEventDate());
		sb.append(", eventEndDate=");
		sb.append(getEventEndDate());
		sb.append(", privateEvent=");
		sb.append(getPrivateEvent());
		sb.append(", registrationRequired=");
		sb.append(getRegistrationRequired());
		sb.append(", requiredFullName=");
		sb.append(getRequiredFullName());
		sb.append(", requiredEmail=");
		sb.append(getRequiredEmail());
		sb.append(", requiredPhone=");
		sb.append(getRequiredPhone());
		sb.append(", locationId=");
		sb.append(getLocationId());
		sb.append(", targetId=");
		sb.append(getTargetId());
		sb.append(", typeId=");
		sb.append(getTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.event.model.Event");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>calendarBookingId</column-name><column-value><![CDATA[");
		sb.append(getCalendarBookingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>calendarId</column-name><column-value><![CDATA[");
		sb.append(getCalendarId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tags</column-name><column-value><![CDATA[");
		sb.append(getTags());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDate</column-name><column-value><![CDATA[");
		sb.append(getEventDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventEndDate</column-name><column-value><![CDATA[");
		sb.append(getEventEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privateEvent</column-name><column-value><![CDATA[");
		sb.append(getPrivateEvent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registrationRequired</column-name><column-value><![CDATA[");
		sb.append(getRegistrationRequired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiredFullName</column-name><column-value><![CDATA[");
		sb.append(getRequiredFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiredEmail</column-name><column-value><![CDATA[");
		sb.append(getRequiredEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiredPhone</column-name><column-value><![CDATA[");
		sb.append(getRequiredPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetId</column-name><column-value><![CDATA[");
		sb.append(getTargetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _eventId;
	private long _calendarBookingId;
	private long _calendarId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _location;
	private String _description;
	private String _tags;
	private Date _eventDate;
	private Date _eventEndDate;
	private boolean _privateEvent;
	private boolean _registrationRequired;
	private boolean _requiredFullName;
	private boolean _requiredEmail;
	private boolean _requiredPhone;
	private long _locationId;
	private long _targetId;
	private long _typeId;
	private BaseModel<?> _eventRemoteModel;
	private Class<?> _clpSerializerClass = com.rivetlogic.event.service.ClpSerializer.class;
}