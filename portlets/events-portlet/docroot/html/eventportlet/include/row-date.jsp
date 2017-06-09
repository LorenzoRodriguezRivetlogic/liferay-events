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
	
	Date date = event.getEventDate();
	Date endDate = event.getEventEndDate();
	
	Calendar cal1 = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	cal1.setTime(date);
	cal2.setTime(endDate);
	
	boolean isSameDate = false;
	int compare = TimeIgnoringComparator.compare(cal1, cal2);
	if (compare == 0) {
		isSameDate = true;
	}
	
	String locationName = "";
	try {
		Location location = LocationLocalServiceUtil.getLocation(event.getLocationId());
		locationName = location.getName();
	} catch (Exception ex) {
		locationName = "";
	}
	
%>

<% if (isSameDate) { %>
	<p><%= NotificationConstants.SDFWD.format(event.getEventDate()) %></p>
	<p><%= NotificationConstants.SDFH.format(event.getEventDate()) %> - <%= NotificationConstants.SDFH.format(event.getEventEndDate()) %></p>
<% } else { %>
	<p><%= NotificationConstants.SDF.format(event.getEventDate()) %> -</p>
	<p><%= NotificationConstants.SDF.format(event.getEventEndDate()) %></p>
<% } %>
<p><%= locationName %><p>

