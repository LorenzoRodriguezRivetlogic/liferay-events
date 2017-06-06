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
<liferay-ui:error message="participant-already-registered" key="participant-already-registered"/>

<liferay-ui:header title="event-upcoming-events"/>

<liferay-ui:search-container 
	emptyResultsMessage="event-empty-results" delta="${prefBean.numRows}" deltaConfigurable="true">
	<liferay-ui:search-container-results>
		<%
		total = EventLocalServiceUtil.getPublicEventsCount();
		results = EventLocalServiceUtil.getPublicEvents(searchContainer.getStart(), searchContainer.getEnd());
		pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row 
		className="com.rivetlogic.event.model.Event" 
		keyProperty="eventId" modelVar="event">
		
		<portlet:renderURL var="rowURL">
			<portlet:param name="<%=WebKeys.MVC_PATH %>" value="/html/eventportlet/view_event.jsp" />
			<portlet:param name="<%=EventPortletConstants.PARAMETER_RESOURCE_PRIMARY_KEY %>" value="<%=String.valueOf(event.getPrimaryKey())%>" />
		</portlet:renderURL>
		
		<liferay-ui:search-container-column-jsp path="/html/eventportlet/include/row-date.jsp"/>
		<liferay-ui:search-container-column-jsp path="/html/eventportlet/include/row-info.jsp"/>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>