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

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author juancarrillo
 * @generated
 */
public class EventSoap implements Serializable {
	public static EventSoap toSoapModel(Event model) {
		EventSoap soapModel = new EventSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEventId(model.getEventId());
		soapModel.setCalendarBookingId(model.getCalendarBookingId());
		soapModel.setCalendarId(model.getCalendarId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setName(model.getName());
		soapModel.setLocation(model.getLocation());
		soapModel.setDescription(model.getDescription());
		soapModel.setTags(model.getTags());
		soapModel.setEventDate(model.getEventDate());
		soapModel.setEventEndDate(model.getEventEndDate());
		soapModel.setPrivateEvent(model.getPrivateEvent());
		soapModel.setRegistrationRequired(model.getRegistrationRequired());
		soapModel.setRequiredFullName(model.getRequiredFullName());
		soapModel.setRequiredEmail(model.getRequiredEmail());
		soapModel.setRequiredPhone(model.getRequiredPhone());
		soapModel.setImage(model.getImage());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setTargetId(model.getTargetId());
		soapModel.setTypeId(model.getTypeId());

		return soapModel;
	}

	public static EventSoap[] toSoapModels(Event[] models) {
		EventSoap[] soapModels = new EventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[][] toSoapModels(Event[][] models) {
		EventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[] toSoapModels(List<Event> models) {
		List<EventSoap> soapModels = new ArrayList<EventSoap>(models.size());

		for (Event model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventSoap[soapModels.size()]);
	}

	public EventSoap() {
	}

	public long getPrimaryKey() {
		return _eventId;
	}

	public void setPrimaryKey(long pk) {
		setEventId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public long getCalendarBookingId() {
		return _calendarBookingId;
	}

	public void setCalendarBookingId(long calendarBookingId) {
		_calendarBookingId = calendarBookingId;
	}

	public long getCalendarId() {
		return _calendarId;
	}

	public void setCalendarId(long calendarId) {
		_calendarId = calendarId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getTags() {
		return _tags;
	}

	public void setTags(String tags) {
		_tags = tags;
	}

	public Date getEventDate() {
		return _eventDate;
	}

	public void setEventDate(Date eventDate) {
		_eventDate = eventDate;
	}

	public Date getEventEndDate() {
		return _eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		_eventEndDate = eventEndDate;
	}

	public boolean getPrivateEvent() {
		return _privateEvent;
	}

	public boolean isPrivateEvent() {
		return _privateEvent;
	}

	public void setPrivateEvent(boolean privateEvent) {
		_privateEvent = privateEvent;
	}

	public boolean getRegistrationRequired() {
		return _registrationRequired;
	}

	public boolean isRegistrationRequired() {
		return _registrationRequired;
	}

	public void setRegistrationRequired(boolean registrationRequired) {
		_registrationRequired = registrationRequired;
	}

	public boolean getRequiredFullName() {
		return _requiredFullName;
	}

	public boolean isRequiredFullName() {
		return _requiredFullName;
	}

	public void setRequiredFullName(boolean requiredFullName) {
		_requiredFullName = requiredFullName;
	}

	public boolean getRequiredEmail() {
		return _requiredEmail;
	}

	public boolean isRequiredEmail() {
		return _requiredEmail;
	}

	public void setRequiredEmail(boolean requiredEmail) {
		_requiredEmail = requiredEmail;
	}

	public boolean getRequiredPhone() {
		return _requiredPhone;
	}

	public boolean isRequiredPhone() {
		return _requiredPhone;
	}

	public void setRequiredPhone(boolean requiredPhone) {
		_requiredPhone = requiredPhone;
	}

	public Blob getImage() {
		return _image;
	}

	public void setImage(Blob image) {
		_image = image;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public long getTargetId() {
		return _targetId;
	}

	public void setTargetId(long targetId) {
		_targetId = targetId;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	private String _uuid;
	private long _eventId;
	private long _calendarBookingId;
	private long _calendarId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
	private Blob _image;
	private long _locationId;
	private long _targetId;
	private long _typeId;
}