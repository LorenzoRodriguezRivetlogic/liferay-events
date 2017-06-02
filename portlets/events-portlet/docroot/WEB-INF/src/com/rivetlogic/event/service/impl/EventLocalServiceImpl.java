/**
 * Copyright (C) 2014 Rivet Logic Corporation. All rights reserved.
 */

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

package com.rivetlogic.event.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarBookingServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.calendar.service.CalendarResourceLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.rivetlogic.event.NoSuchParticipantException;
import com.rivetlogic.event.model.Event;
import com.rivetlogic.event.service.base.EventLocalServiceBaseImpl;


/**
 * The implementation of the event local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rivetlogic.event.service.EventLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author juancarrillo
 * @see com.rivetlogic.event.service.base.EventLocalServiceBaseImpl
 * @see com.rivetlogic.event.service.EventLocalServiceUtil
 */
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     * 
     * Never reference this interface directly. Always use {@link
     * com.rivetlogic.event.service.EventLocalServiceUtil} to access the event
     * local service.
     */
    
    @Override
    public Event addEvent(Event newEvent, ServiceContext serviceContext) throws SystemException, PortalException {
        
    	CalendarBooking booking = null;
    	try {
    		booking = createCalendarBooking(newEvent, serviceContext);
    	} catch(PortalException ex) {
    		_log.debug("Current user doesn't have permission to add CalendarBooking");
    	}
    	
        Event event = eventPersistence.create(counterLocalService.increment(Event.class.getName()));
        newEvent.setEventId(event.getEventId());
		if (booking != null) {
			newEvent.setCalendarBookingId(booking.getCalendarBookingId());
		}
        event.setModelAttributes(newEvent.getModelAttributes());
        
        return eventPersistence.update(event);
    }

	public Calendar getUserCalendar(long userId,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		String servletContextName = "calendar-portlet";
		ClassLoader classLoader = (ClassLoader) com.liferay.portal.kernel.bean.PortletBeanLocatorUtil
				.locate(servletContextName, "portletClassLoader");
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
				Calendar.class, classLoader);
		dynamicQuery.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil
				.forName("userId").eq(userId));
		User user = null;
		CalendarResource calendarResource = null;
		Calendar calendar = null;
		List<Calendar> calendars = CalendarLocalServiceUtil
				.dynamicQuery(dynamicQuery);
		
		if (calendars.isEmpty()) {
			_log.debug("No calendar found for user with ID: "
					+ userId);

			user = userLocalService.getUser(userId);
			Map<Locale, String> nameMap = new HashMap<Locale, String>();
			nameMap.put(serviceContext.getLocale(), user.getFullName());

			_log.debug("Creating calendarResource for user with ID: " + userId);
			calendarResource = CalendarResourceLocalServiceUtil
					.addCalendarResource(user.getUserId(), user.getGroupId(),
							PortalUtil.getClassNameId(User.class),
							user.getUserId(), "", "", nameMap, null, true,
							serviceContext);

			calendars = CalendarLocalServiceUtil.getCalendarResourceCalendars(
					user.getGroupId(),
					calendarResource.getCalendarResourceId(), true);
			if (calendars.isEmpty()) {
				_log.debug("Creating Calendar for user with ID: " + userId
						+ ". CalendarResourceId: "
						+ calendarResource.getCalendarResourceId());
				calendar = CalendarLocalServiceUtil.addCalendar(
						user.getUserId(), user.getGroupId(),
						calendarResource.getCalendarResourceId(), nameMap,
						null, 0, true, false, false, serviceContext);
			} else {
				calendar = calendars.get(0);
			}
		} else {
			calendar = calendars.get(0);
		}
		return calendar;
	}

	private CalendarBooking createCalendarBooking(Event newEvent,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		_log.debug("Adding CalendarBooking to calendar");
		long calendarId = newEvent.getCalendarId();

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();

		titleMap.put(serviceContext.getLocale(), newEvent.getName());
		descriptionMap.put(serviceContext.getLocale(),
				newEvent.getDescription());

		return CalendarBookingLocalServiceUtil.addCalendarBooking(newEvent.getUserId(),
				calendarId, new long[]{}, 0l, titleMap, descriptionMap,
				newEvent.getLocation(), newEvent.getEventDate().getTime(),
				newEvent.getEventEndDate().getTime(), false, "", 0l, "", 0l, "",
				serviceContext);
	}
    
    public Event updateEvent(Event event, ServiceContext serviceContext) throws SystemException {
    	if(event.getCalendarBookingId() > 0) {
    		try {
				CalendarBooking booking = CalendarBookingServiceUtil.fetchCalendarBooking(event.getCalendarBookingId());
				if(booking != null) {
					Calendar calendar = CalendarLocalServiceUtil.getCalendar(event.getCalendarId());
					
					Map<Locale, String> titleMap = new HashMap<Locale, String>();
					Map<Locale, String> descriptionMap = new HashMap<Locale, String>();

					titleMap.put(serviceContext.getLocale(), event.getName());
					descriptionMap.put(serviceContext.getLocale(),
							event.getDescription());
					
					booking.setTitleMap(titleMap);
					booking.setDescriptionMap(descriptionMap);
					booking.setCalendarId(event.getCalendarId());
					booking.setCalendarResourceId(calendar.getCalendarResourceId());
					booking.setStartTime(event.getEventDate().getTime());
					booking.setEndTime(event.getEventEndDate().getTime());

					CalendarBookingLocalServiceUtil.updateCalendarBooking(booking);
				}
			} catch (PortalException e) {
				_log.debug("Unable to update calendarBooking with id: " + event.getCalendarBookingId());
			}
    	}
    	
        return eventPersistence.update(event);
    }
    
    public Event deleteEvent(Event event) throws SystemException {
		try {
			participantLocalService.clearParticipantsByEventId(event
					.getEventId());
		} catch (NoSuchParticipantException e1) {
			_log.debug("Unable to delete participants for event with id: "
					+ event.getEventId());
		}

		if (event.getCalendarBookingId() > 0) {
			try {
				CalendarBookingServiceUtil.deleteCalendarBooking(event
						.getCalendarBookingId());
			} catch (PortalException e) {
				_log.debug(String
						.format("Unable to delete calendarBooking with id: %d. When deleting event with id: %d",
								event.getCalendarBookingId(),
								event.getEventId()));
			}
		}
    	
        return eventPersistence.remove(event);
        
    }
    
    public Event deleteEvent(long eventId) throws SystemException, PortalException {
        return deleteEvent(getEvent(eventId));
    }
    
    private DynamicQuery getEventsDynamicQuery(Criterion criterion, boolean useOrder) {
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Event.class);
        dynamicQuery.add(criterion);
        if(useOrder) {
        	Order order = OrderFactoryUtil.asc(EVENT_DATE_COLUMN);
        	dynamicQuery.addOrder(order);
        }
        return dynamicQuery;
    }
    
    private DynamicQuery getPastEventsDynamicQuery(boolean useOrder, long userId) {
        Date currentDate = new Date();
        Criterion criterion = RestrictionsFactoryUtil.le(EVENT_DATE_COLUMN, currentDate);
        criterion = RestrictionsFactoryUtil.and(criterion, getOwnerOrPublicEventsCriterion(userId));
        return getEventsDynamicQuery(criterion, useOrder);
    }
    
    @SuppressWarnings("unchecked")
    public List<Event> getPastEvents(int start, int end, long userId) {
        
        List<Event> pastEvents = new ArrayList<Event>();
        
        DynamicQuery dynamicQuery = getPastEventsDynamicQuery(true, userId);
        
        try {
            pastEvents = (List<Event>) eventPersistence.findWithDynamicQuery(dynamicQuery, start, end);
        } catch (SystemException e) {
            _log.error(e);
        }
        
        return pastEvents;
    }
    
    public int getPastEventsCount(long userId) {
        int result = 0;
        DynamicQuery dynamicQuery = getPastEventsDynamicQuery(false, userId);
        try {
            result = (int) eventPersistence.countWithDynamicQuery(dynamicQuery);
        } catch (SystemException e) {
            _log.error(e);
        }
        return result;
    }

	private Criterion getOwnerOrPublicEventsCriterion(long userId) {
		Criterion result = null;
		Criterion publicEvent = RestrictionsFactoryUtil.eq(
				EVENT_PRIVATE_COLUMN, false);

		if (userId <= 0) {
			result = publicEvent;
		} else {
			Criterion userEvents = RestrictionsFactoryUtil.eq(EVENT_USER_ID, userId);
			result = RestrictionsFactoryUtil.or(userEvents, publicEvent);
		}

		return result;
	}
    
    private DynamicQuery getUpcomingEventsDynamicQuery(boolean useOrder, long userId) {
        Date currentDate = new Date();
        Criterion criterion = RestrictionsFactoryUtil.ge(EVENT_DATE_COLUMN, currentDate);
        criterion = RestrictionsFactoryUtil.and(criterion, getOwnerOrPublicEventsCriterion(userId));
        return getEventsDynamicQuery(criterion, useOrder);
    }
    
    @SuppressWarnings("unchecked")
    public List<Event> getUpcomingEvents(int start, int end, long userId) {
        
        List<Event> upcomingEvents = new ArrayList<Event>();
        
        DynamicQuery dynamicQuery = getUpcomingEventsDynamicQuery(true, userId);
        
        try {
            upcomingEvents = (List<Event>) eventPersistence.findWithDynamicQuery(dynamicQuery, start, end);
        } catch (SystemException e) {
            _log.error(e);
        }
        
        return upcomingEvents;
    }
    
    public int getUpcomingEventsCount(long userId) {
        int result = 0;
        DynamicQuery dynamicQuery = getUpcomingEventsDynamicQuery(false, userId);
        try {
            result = (int) eventPersistence.countWithDynamicQuery(dynamicQuery);
        } catch (SystemException e) {
            _log.error(e);
        }
        return result;
    }
    
    private DynamicQuery getPublicUpcomingEventsDynamicQuery(boolean useOrder, long userId) {
        DynamicQuery dynamicQuery = getUpcomingEventsDynamicQuery(useOrder, userId);
        Criterion criterion = RestrictionsFactoryUtil.eq(EVENT_PRIVATE_COLUMN, false);
        dynamicQuery.add(criterion);
        return dynamicQuery;
    }
    
    @SuppressWarnings("unchecked")
    public List<Event> getPublicEvents(int start, int end) {
        
        List<Event> publicEvents = new ArrayList<Event>();
        
        DynamicQuery dynamicQuery = getPublicUpcomingEventsDynamicQuery(true, 0);
        
        try {
            publicEvents = (List<Event>) eventPersistence.findWithDynamicQuery(dynamicQuery, start, end);
        } catch (SystemException e) {
            _log.error(e);
        }
        
        return publicEvents;
    }
    
    public int getPublicEventsCount() {
        
        int result = 0;
        DynamicQuery dynamicQuery = getPublicUpcomingEventsDynamicQuery(false, 0);
        try {
            result = (int) eventPersistence.countWithDynamicQuery(dynamicQuery);
        } catch (SystemException e) {
            _log.error(e);
        }
        return result;
    }
    
    private static final String EVENT_DATE_COLUMN = "eventDate";
    private static final String EVENT_PRIVATE_COLUMN = "privateEvent";
    private static final String EVENT_USER_ID = "userId";
    private static Log _log = LogFactoryUtil.getLog(EventLocalServiceImpl.class);
}