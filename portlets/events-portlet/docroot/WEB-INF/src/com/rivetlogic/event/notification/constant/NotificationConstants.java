/** 
* Copyright (C) 2005-2014 Rivet Logic Corporation. 
* 
* This program is free software; you can redistribute it and/or 
* modify it under the terms of the GNU General Public License 
* as published by the Free Software Foundation; version 3 
* of the License. 
* 
* This program is distributed in the hope that it will be useful, 
* but WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
* GNU General Public License for more details. 
* 
* You should have received a copy of the GNU General Public License 
* along with this program; if not, write to the Free Software 
* Foundation, Inc., 51 Franklin Street, Fifth Floor, 
* Boston, MA 02110-1301, USA. 
*/

package com.rivetlogic.event.notification.constant;

import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;

import java.text.Format;

/**
 * @author christopherjimenez
 */
public class NotificationConstants {

	public static final String CMD = "cmd";
	public static final String SEND_NOTIFICATION_DESTINATION = "send_notification";
	
	public static final String SUBJECT_TEMPLATE = "subject-template";
	public static final String BODY_TEMPLATE = "body-template";
	public static final String SENDER = "sender";
	public static final String SENDER_NAME = "sender-name";
	public static final String RECIPIENTS = "recipients";
	public static final String PUBLIC_URL = "public-url";
	public static final String PORTAL_URL = "portal-url";
	
	public static final String REGULAR_INVITATION = "regular-invitation";
	public static final String REMINDER_MESSAGE = "reminder-message";
	public static final String SINGLE_EVENT_UPDATE = "single-event-updated";
	public static final String SINGLE_CANCELLED_EVENT = "single-cancelled-event";
	public static final String MANUAL_EVENT_REGISTRATION = "manual-registration";
	public static final String EVENT_UPDATED = "event-updated";
	public static final String EVENT_CANCELLED = "event-cancelled";
	
	public static final String DONT_UPDATE_USER = "dont.update.user";
	
	
	public static final String EVENT = "event";
	public static final String EVENT_ID = "eventId";
	public static final String PARTICIPANT = "participant";
	public static final String PARTICIPANT_ID = "participantId";
	public static final String PARTICIPANTS = "participants";

	public static final String[] COMMON_VARIABLES = new String[] {
			"[$FROM_ADDRESS$]", "[$FROM_NAME$]", "[$EVENT_NAME$]", 
			"[$EVENT_DATE$]", "[$TO_NAME$]","[$TO_ADDRESS$]" ,
			"[$EVENT_LOCATION$]", "[$EVENT_DESCRIPTION$]",
			"[$PUBLIC_EVENTS_URL$]", "[$CONFIRMATION_URL$]",
			"[$REJECTION_URL$]","[$PORTAL_URL$]"  };

	
	public static Format SDF = 
			FastDateFormatFactoryUtil
				.getSimpleDateFormat("MMM d, yyyy hh:mm a");
	
	public static Format SDFWD = 
			FastDateFormatFactoryUtil
				.getSimpleDateFormat("MMM d, yyyy");
	
	public static Format SDFH = 
			FastDateFormatFactoryUtil
				.getSimpleDateFormat("hh:mm a");
	
	public static Format CDF = 
			FastDateFormatFactoryUtil
				.getSimpleDateFormat("EEE MMM d, yyyy hh:mm a");
	
}
