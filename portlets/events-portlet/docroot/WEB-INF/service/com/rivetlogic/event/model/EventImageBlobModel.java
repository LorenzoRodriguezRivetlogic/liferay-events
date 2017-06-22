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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the image column in Event.
 *
 * @author juancarrillo
 * @see Event
 * @generated
 */
public class EventImageBlobModel {
	public EventImageBlobModel() {
	}

	public EventImageBlobModel(long eventId) {
		_eventId = eventId;
	}

	public EventImageBlobModel(long eventId, Blob imageBlob) {
		_eventId = eventId;
		_imageBlob = imageBlob;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public Blob getImageBlob() {
		return _imageBlob;
	}

	public void setImageBlob(Blob imageBlob) {
		_imageBlob = imageBlob;
	}

	private long _eventId;
	private Blob _imageBlob;
}