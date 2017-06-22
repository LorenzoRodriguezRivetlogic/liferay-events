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

<%
	ResultRow row = (ResultRow)request.getAttribute(com.liferay.portal.kernel.util.WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Event event = (Event)row.getObject();
%>
<portlet:actionURL name="deleteEvent" var="deleteEventUrl">
	<portlet:param name="<%=NotificationConstants.EVENT_ID%>" value="<%=String.valueOf(event.getEventId())%>"/>
</portlet:actionURL>
<portlet:renderURL var="editEvent">
	<portlet:param name="<%=WebKeys.MVC_PATH %>" value="/html/eventManagementPortlet/edit_event.jsp" />
	<portlet:param name="<%=EventPortletConstants.PARAMETER_RESOURCE_PRIMARY_KEY %>" value="<%=String.valueOf(event.getPrimaryKey())%>" />
</portlet:renderURL>
<portlet:actionURL name="sendReminder" var="sendReminderUrl">
	<portlet:param name="<%=NotificationConstants.EVENT_ID%>" value="<%=String.valueOf(event.getEventId())%>"/>
</portlet:actionURL>
<portlet:renderURL var="viewEventAttendees">
	<portlet:param name="<%=WebKeys.MVC_PATH %>" value="/html/eventManagementPortlet/view_attendees.jsp" />
	<portlet:param name="<%=EventPortletConstants.PARAMETER_RESOURCE_PRIMARY_KEY %>" value="<%=String.valueOf(event.getPrimaryKey())%>" />
</portlet:renderURL>


<liferay-ui:icon-menu>
	<%if(!event.isPast()){ %>
		<liferay-ui:icon image="edit" url="${editEvent}"/>
		<% if (event.getRegistrationRequired()) { %>
			<liferay-ui:icon image="page" url="${sendReminderUrl}" message="send-reminder"/>
		<% } %>	
	<%} %>
	<% if (event.getRegistrationRequired()) { %>
		<liferay-ui:icon image="view" message="event-attendees" url="${viewEventAttendees}"  />
	<% } %>
	<liferay-ui:icon-delete url="${deleteEventUrl}" />
</liferay-ui:icon-menu>
