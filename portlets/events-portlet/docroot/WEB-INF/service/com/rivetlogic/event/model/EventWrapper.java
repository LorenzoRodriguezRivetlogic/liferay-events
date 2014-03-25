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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Event}.
 * </p>
 *
 * @author juancarrillo
 * @see Event
 * @generated
 */
public class EventWrapper implements Event, ModelWrapper<Event> {
	public EventWrapper(Event event) {
		_event = event;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventId", getEventId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("location", getLocation());
		attributes.put("description", getDescription());
		attributes.put("eventDate", getEventDate());
		attributes.put("privateEvent", getPrivateEvent());

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

		Date eventDate = (Date)attributes.get("eventDate");

		if (eventDate != null) {
			setEventDate(eventDate);
		}

		Boolean privateEvent = (Boolean)attributes.get("privateEvent");

		if (privateEvent != null) {
			setPrivateEvent(privateEvent);
		}
	}

	/**
	* Returns the primary key of this event.
	*
	* @return the primary key of this event
	*/
	@Override
	public long getPrimaryKey() {
		return _event.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event.
	*
	* @param primaryKey the primary key of this event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_event.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this event.
	*
	* @return the uuid of this event
	*/
	@Override
	public java.lang.String getUuid() {
		return _event.getUuid();
	}

	/**
	* Sets the uuid of this event.
	*
	* @param uuid the uuid of this event
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_event.setUuid(uuid);
	}

	/**
	* Returns the event ID of this event.
	*
	* @return the event ID of this event
	*/
	@Override
	public long getEventId() {
		return _event.getEventId();
	}

	/**
	* Sets the event ID of this event.
	*
	* @param eventId the event ID of this event
	*/
	@Override
	public void setEventId(long eventId) {
		_event.setEventId(eventId);
	}

	/**
	* Returns the group ID of this event.
	*
	* @return the group ID of this event
	*/
	@Override
	public long getGroupId() {
		return _event.getGroupId();
	}

	/**
	* Sets the group ID of this event.
	*
	* @param groupId the group ID of this event
	*/
	@Override
	public void setGroupId(long groupId) {
		_event.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this event.
	*
	* @return the company ID of this event
	*/
	@Override
	public long getCompanyId() {
		return _event.getCompanyId();
	}

	/**
	* Sets the company ID of this event.
	*
	* @param companyId the company ID of this event
	*/
	@Override
	public void setCompanyId(long companyId) {
		_event.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this event.
	*
	* @return the user ID of this event
	*/
	@Override
	public long getUserId() {
		return _event.getUserId();
	}

	/**
	* Sets the user ID of this event.
	*
	* @param userId the user ID of this event
	*/
	@Override
	public void setUserId(long userId) {
		_event.setUserId(userId);
	}

	/**
	* Returns the user uuid of this event.
	*
	* @return the user uuid of this event
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _event.getUserUuid();
	}

	/**
	* Sets the user uuid of this event.
	*
	* @param userUuid the user uuid of this event
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_event.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this event.
	*
	* @return the name of this event
	*/
	@Override
	public java.lang.String getName() {
		return _event.getName();
	}

	/**
	* Sets the name of this event.
	*
	* @param name the name of this event
	*/
	@Override
	public void setName(java.lang.String name) {
		_event.setName(name);
	}

	/**
	* Returns the location of this event.
	*
	* @return the location of this event
	*/
	@Override
	public java.lang.String getLocation() {
		return _event.getLocation();
	}

	/**
	* Sets the location of this event.
	*
	* @param location the location of this event
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_event.setLocation(location);
	}

	/**
	* Returns the description of this event.
	*
	* @return the description of this event
	*/
	@Override
	public java.lang.String getDescription() {
		return _event.getDescription();
	}

	/**
	* Sets the description of this event.
	*
	* @param description the description of this event
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_event.setDescription(description);
	}

	/**
	* Returns the event date of this event.
	*
	* @return the event date of this event
	*/
	@Override
	public java.util.Date getEventDate() {
		return _event.getEventDate();
	}

	/**
	* Sets the event date of this event.
	*
	* @param eventDate the event date of this event
	*/
	@Override
	public void setEventDate(java.util.Date eventDate) {
		_event.setEventDate(eventDate);
	}

	/**
	* Returns the private event of this event.
	*
	* @return the private event of this event
	*/
	@Override
	public boolean getPrivateEvent() {
		return _event.getPrivateEvent();
	}

	/**
	* Returns <code>true</code> if this event is private event.
	*
	* @return <code>true</code> if this event is private event; <code>false</code> otherwise
	*/
	@Override
	public boolean isPrivateEvent() {
		return _event.isPrivateEvent();
	}

	/**
	* Sets whether this event is private event.
	*
	* @param privateEvent the private event of this event
	*/
	@Override
	public void setPrivateEvent(boolean privateEvent) {
		_event.setPrivateEvent(privateEvent);
	}

	@Override
	public boolean isNew() {
		return _event.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_event.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _event.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_event.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _event.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _event.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_event.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _event.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_event.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_event.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_event.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventWrapper((Event)_event.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.event.model.Event event) {
		return _event.compareTo(event);
	}

	@Override
	public int hashCode() {
		return _event.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.event.model.Event> toCacheModel() {
		return _event.toCacheModel();
	}

	@Override
	public com.rivetlogic.event.model.Event toEscapedModel() {
		return new EventWrapper(_event.toEscapedModel());
	}

	@Override
	public com.rivetlogic.event.model.Event toUnescapedModel() {
		return new EventWrapper(_event.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _event.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _event.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_event.persist();
	}

	@Override
	public boolean isPast() {
		return _event.isPast();
	}

	@Override
	public java.util.List<com.rivetlogic.event.model.Participant> getParticipants() {
		return _event.getParticipants();
	}

	@Override
	public java.util.List<com.rivetlogic.event.model.Participant> getParticipants(
		int[] statuses) {
		return _event.getParticipants(statuses);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventWrapper)) {
			return false;
		}

		EventWrapper eventWrapper = (EventWrapper)obj;

		if (Validator.equals(_event, eventWrapper._event)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Event getWrappedEvent() {
		return _event;
	}

	@Override
	public Event getWrappedModel() {
		return _event;
	}

	@Override
	public void resetOriginalValues() {
		_event.resetOriginalValues();
	}

	private Event _event;
}