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
	String eventId = String.valueOf(event.getEventId());
%>

<portlet:renderURL var="viewEventURL">
	<portlet:param name="<%=WebKeys.MVC_PATH %>" value="/html/eventportlet/view_event.jsp" />
	<portlet:param name="<%=EventPortletConstants.PARAMETER_RESOURCE_PRIMARY_KEY %>" value="<%=String.valueOf(event.getPrimaryKey())%>" />
</portlet:renderURL>

<portlet:resourceURL  var="imageResourceURL">
	<portlet:param name="action" value="image"/>
	<portlet:param name="eventId" value="<%= eventId %>"/>
</portlet:resourceURL>

<table>
	<tr>
		<td rowspan="2">
			<img width="175" height="117" src="<%=imageResourceURL.toString()%>" alt="no Image"/>
		</td>
		<td><h4><%= event.getName() %></h4></td>
	</tr>
	<tr>
		<td>
			<liferay-ui:icon-menu>
				<liferay-ui:icon image="view" message="event-view-read-more" url="${viewEventURL}"  />
			</liferay-ui:icon-menu>
		</td>
	</tr>
</table>

