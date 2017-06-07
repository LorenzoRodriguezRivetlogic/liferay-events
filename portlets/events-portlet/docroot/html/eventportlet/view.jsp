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

<%
String searchText = ParamUtil.getString(request, WebKeys.SEARCH_TEXT);
String searchTag = ParamUtil.getString(request, WebKeys.SEARCH_TAG);
Long locationId = ParamUtil.getLong(request, WebKeys.LOCATION);
Long typeId = ParamUtil.getLong(request, WebKeys.TYPE);
Long targetId = ParamUtil.getLong(request, WebKeys.TARGET);

List<Location> locations = LocationLocalServiceUtil.getLocationsByGroupId(portletGroupId);
List<Type> types = TypeLocalServiceUtil.getTypesByGroupId(portletGroupId);
List<Target> targets = TargetLocalServiceUtil.getTargetsByGroupId(portletGroupId);
%>

<portlet:actionURL name="searchEvents" var="searchEventsURL">
</portlet:actionURL>

<liferay-ui:header title="event-upcoming-events"/>

<aui:form action="<%= searchEventsURL %>" method="post" name="fm">
	<aui:button-row>
		<aui:select id="locations" name="locations" label="locations" showEmptyOption="true" inlineField="<%=true%>" >
			<% 
			for (Location locationSel : locations) {
			%>
				<aui:option value="<%=locationSel.getLocationId()%>"  selected="<%= locationId == locationSel.getLocationId() %>">
				<liferay-ui:message key="<%=locationSel.getName()%>" />
				</aui:option>
			<% 
			}
			%>
		</aui:select>
		<aui:select id="types" name="types" label="types" showEmptyOption="true" inlineField="<%=true%>" >
			<% 
			for (Type typeSel : types) {
			%>
				<aui:option value="<%=typeSel.getTypeId()%>"  selected="<%= typeId == typeSel.getTypeId() %>">
				<liferay-ui:message key="<%=typeSel.getName()%>" />
				</aui:option>
			<% 
			}
			%>
		</aui:select>
		<aui:select id="targets" name="targets" label="targets" showEmptyOption="true" inlineField="<%=true%>">
			<% 
			for (Target targetSel : targets) {
			%>
				<aui:option value="<%=targetSel.getTargetId()%>"  selected="<%= targetId == targetSel.getTargetId() %>">
				<liferay-ui:message key="<%=targetSel.getName()%>" />
				</aui:option>
			<% 
			}
			%>
		</aui:select>
		<aui:input name="searchText" label="search-text" type="text" inlineField="<%=true%>" >
		</aui:input>
		<aui:button name="searchButton" type="submit" cssClass="event-button" value="search-label"  inlineField="<%=true%>" />
	</aui:button-row>
</aui:form> 

<liferay-ui:search-container 
	emptyResultsMessage="event-empty-results" delta="${prefBean.numRows}" deltaConfigurable="true">
	<liferay-ui:search-container-results>
		<%
		total = EventLocalServiceUtil.getPublicEventsCount(locationId, typeId, targetId, searchText, searchTag);
		results = EventLocalServiceUtil.getPublicEvents(searchContainer.getStart(), searchContainer.getEnd(), locationId, typeId, targetId, searchText, searchTag);
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