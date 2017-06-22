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
long resourcePrimKey = ParamUtil.getLong(request, EventPortletConstants.PARAMETER_RESOURCE_PRIMARY_KEY);
Event event = EventLocalServiceUtil.getEvent(resourcePrimKey);
ThemeDisplay display = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
%>

<portlet:renderURL var="backURL">
	<portlet:param name="<%=WebKeys.MVC_PATH %>" value="/html/eventManagementPortlet/view.jsp" />
</portlet:renderURL>

<liferay-ui:header backURL="${backURL}" title='event-view-attendees'/>

<liferay-ui:search-container 
	emptyResultsMessage="participant-empty-results" delta="${prefBean.numRows}" deltaConfigurable="true">
	<liferay-ui:search-container-results 
		results="<%=ParticipantLocalServiceUtil.getParticipants(EventConstant.EVENT_STATUS_ACCEPTER, event.getEventId())%>"
		total="<%=ParticipantLocalServiceUtil.getParticipantsCount(EventConstant.EVENT_STATUS_ACCEPTER, event.getEventId())%>"
	/>
	
	<h4><liferay-ui:message key="participant-confirmed"/>&nbsp;(<%=ParticipantLocalServiceUtil.getParticipantsCount(EventConstant.EVENT_STATUS_ACCEPTER, event.getEventId())%>)</h4>
	
	<liferay-ui:search-container-row 
		className="com.rivetlogic.event.model.Participant" 
		keyProperty="participantId" modelVar="participant">
		
		<% if (event.getRequiredFullName()) { %>
			<liferay-ui:search-container-column-text name="participant-name" property="fullName" />
		<% } %>
		<liferay-ui:search-container-column-text name="participant-email" property="email" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>

<liferay-ui:search-container 
	emptyResultsMessage="participant-empty-results" delta="${prefBean.numRows}" deltaConfigurable="true">
	<liferay-ui:search-container-results 
		results="<%=ParticipantLocalServiceUtil.getParticipants(EventConstant.EVENT_STATUS_SENT,event.getEventId())%>"
		total="<%=ParticipantLocalServiceUtil.getParticipantsCount(EventConstant.EVENT_STATUS_SENT, event.getEventId())%>"
	/>
	
	<h4><liferay-ui:message key="participant-unconfirmed"/>&nbsp;(<%=ParticipantLocalServiceUtil.getParticipantsCount(EventConstant.EVENT_STATUS_SENT, event.getEventId())%>)</h4>
	
	<liferay-ui:search-container-row 
		className="com.rivetlogic.event.model.Participant" 
		keyProperty="participantId" modelVar="participant">
		<liferay-ui:search-container-column-text name="participant-name" property="fullName" />
		<liferay-ui:search-container-column-text name="participant-email" property="email" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>
