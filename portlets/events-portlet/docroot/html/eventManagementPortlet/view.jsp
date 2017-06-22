<%--
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
--%>

<%@include file="/html/init.jsp" %>

<liferay-ui:success key="participant-registration-success" message="participant-registration-success" />
<liferay-ui:success key="participant-registration-email" message="participant-registration-email" />

<portlet:renderURL var="addEvent">
	<portlet:param name="<%=WebKeys.MVC_PATH %>" value="/html/eventManagementPortlet/edit_event.jsp" />
</portlet:renderURL>

<portlet:renderURL var="showPastEvents">
	<portlet:param name="<%=WebKeys.MVC_PATH %>" value="/html/eventManagementPortlet/past_events.jsp" />
</portlet:renderURL>

<div class="event-management">

	<liferay-ui:header title="event-my-upcoming-events"/>
	
	<aui:button-row>
		<aui:button value="add-new-event"  href="${addEvent}" />
	</aui:button-row>
	
	<liferay-ui:search-container 
		emptyResultsMessage="event-empty-results" delta="${prefBean.numRows}" deltaConfigurable="true">
		
		<liferay-ui:search-container-results 
			results="<%=EventLocalServiceUtil.getUpcomingEvents(searchContainer.getStart(), searchContainer.getEnd(), user.getUserId())%>"
			total="<%=EventLocalServiceUtil.getUpcomingEventsCount(user.getUserId())%>"
		/>
	
		<liferay-ui:search-container-row 
			className="com.rivetlogic.event.model.Event" 
			keyProperty="eventId" modelVar="event">
			
				<portlet:renderURL var="editEvent">
					<portlet:param name="<%=WebKeys.MVC_PATH %>" value="/html/eventManagementPortlet/edit_event.jsp" />
					<portlet:param name="<%=EventPortletConstants.PARAMETER_RESOURCE_PRIMARY_KEY %>" value="<%=String.valueOf(event.getPrimaryKey())%>" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="event-name" property="name" href="${editEvent}" />
				
				<liferay-ui:search-container-column-text name="event-date" buffer="buffer">
					<% 
						buffer.append(NotificationConstants.SDF.format(event.getEventDate()));
						if(Validator.isNotNull(event.getEventEndDate())) {
							buffer.append(EventPortletConstants.START_END_DATES_SEPARATOR).append(NotificationConstants.SDF.format(event.getEventEndDate()));
						}
					%>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-jsp path="/html/eventManagementPortlet/include/events-actions.jsp"/>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
		
	</liferay-ui:search-container>
</div>

<div class="past-events">
	<liferay-ui:header title="event-my-past-events" />
	
	<liferay-ui:search-container emptyResultsMessage="event-empty-results" 
		delta="${prefBean.numRows}" deltaConfigurable="true">
		
		<liferay-ui:search-container-results 
			results="<%=EventLocalServiceUtil.getPastEvents(searchContainer.getStart(), searchContainer.getEnd(), user.getUserId())%>"
			total="<%=EventLocalServiceUtil.getPastEventsCount(user.getUserId())%>"
		/>
	
		<liferay-ui:search-container-row 
			className="com.rivetlogic.event.model.Event" 
			keyProperty="eventId" modelVar="event">
				<liferay-ui:search-container-column-text name="event-date" buffer="buffer">
					<% buffer.append(NotificationConstants.SDF.format(event.getEventDate())); %>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="event-name" value="${event.name}" />
				<liferay-ui:search-container-column-jsp path="/html/eventManagementPortlet/include/events-actions.jsp"/>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
		
	</liferay-ui:search-container>
</div> 

