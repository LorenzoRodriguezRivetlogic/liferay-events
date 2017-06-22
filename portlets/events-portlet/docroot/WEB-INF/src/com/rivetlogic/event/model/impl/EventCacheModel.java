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

package com.rivetlogic.event.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.event.model.Event;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Event in entity cache.
 *
 * @author juancarrillo
 * @see Event
 * @generated
 */
public class EventCacheModel implements CacheModel<Event>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", calendarBookingId=");
		sb.append(calendarBookingId);
		sb.append(", calendarId=");
		sb.append(calendarId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", location=");
		sb.append(location);
		sb.append(", description=");
		sb.append(description);
		sb.append(", tags=");
		sb.append(tags);
		sb.append(", eventDate=");
		sb.append(eventDate);
		sb.append(", eventEndDate=");
		sb.append(eventEndDate);
		sb.append(", privateEvent=");
		sb.append(privateEvent);
		sb.append(", registrationRequired=");
		sb.append(registrationRequired);
		sb.append(", requiredFullName=");
		sb.append(requiredFullName);
		sb.append(", requiredPhone=");
		sb.append(requiredPhone);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", targetId=");
		sb.append(targetId);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Event toEntityModel() {
		EventImpl eventImpl = new EventImpl();

		if (uuid == null) {
			eventImpl.setUuid(StringPool.BLANK);
		}
		else {
			eventImpl.setUuid(uuid);
		}

		eventImpl.setEventId(eventId);
		eventImpl.setCalendarBookingId(calendarBookingId);
		eventImpl.setCalendarId(calendarId);
		eventImpl.setGroupId(groupId);
		eventImpl.setCompanyId(companyId);
		eventImpl.setUserId(userId);

		if (name == null) {
			eventImpl.setName(StringPool.BLANK);
		}
		else {
			eventImpl.setName(name);
		}

		if (location == null) {
			eventImpl.setLocation(StringPool.BLANK);
		}
		else {
			eventImpl.setLocation(location);
		}

		if (description == null) {
			eventImpl.setDescription(StringPool.BLANK);
		}
		else {
			eventImpl.setDescription(description);
		}

		if (tags == null) {
			eventImpl.setTags(StringPool.BLANK);
		}
		else {
			eventImpl.setTags(tags);
		}

		if (eventDate == Long.MIN_VALUE) {
			eventImpl.setEventDate(null);
		}
		else {
			eventImpl.setEventDate(new Date(eventDate));
		}

		if (eventEndDate == Long.MIN_VALUE) {
			eventImpl.setEventEndDate(null);
		}
		else {
			eventImpl.setEventEndDate(new Date(eventEndDate));
		}

		eventImpl.setPrivateEvent(privateEvent);
		eventImpl.setRegistrationRequired(registrationRequired);
		eventImpl.setRequiredFullName(requiredFullName);
		eventImpl.setRequiredPhone(requiredPhone);
		eventImpl.setLocationId(locationId);
		eventImpl.setTargetId(targetId);
		eventImpl.setTypeId(typeId);

		eventImpl.resetOriginalValues();

		return eventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		eventId = objectInput.readLong();
		calendarBookingId = objectInput.readLong();
		calendarId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		name = objectInput.readUTF();
		location = objectInput.readUTF();
		description = objectInput.readUTF();
		tags = objectInput.readUTF();
		eventDate = objectInput.readLong();
		eventEndDate = objectInput.readLong();
		privateEvent = objectInput.readBoolean();
		registrationRequired = objectInput.readBoolean();
		requiredFullName = objectInput.readBoolean();
		requiredPhone = objectInput.readBoolean();
		locationId = objectInput.readLong();
		targetId = objectInput.readLong();
		typeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(eventId);
		objectOutput.writeLong(calendarBookingId);
		objectOutput.writeLong(calendarId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (tags == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tags);
		}

		objectOutput.writeLong(eventDate);
		objectOutput.writeLong(eventEndDate);
		objectOutput.writeBoolean(privateEvent);
		objectOutput.writeBoolean(registrationRequired);
		objectOutput.writeBoolean(requiredFullName);
		objectOutput.writeBoolean(requiredPhone);
		objectOutput.writeLong(locationId);
		objectOutput.writeLong(targetId);
		objectOutput.writeLong(typeId);
	}

	public String uuid;
	public long eventId;
	public long calendarBookingId;
	public long calendarId;
	public long groupId;
	public long companyId;
	public long userId;
	public String name;
	public String location;
	public String description;
	public String tags;
	public long eventDate;
	public long eventEndDate;
	public boolean privateEvent;
	public boolean registrationRequired;
	public boolean requiredFullName;
	public boolean requiredPhone;
	public long locationId;
	public long targetId;
	public long typeId;
}