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

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.rivetlogic.event.service.LocationLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>

<%
	PortletURL itURL = renderResponse.createRenderURL();
	itURL.setParameter("jspPage", "/html/dialog/locations_dialog.jsp");
%>

<liferay-ui:error key="location-delete-error" message="location-delete-error" />
<liferay-ui:error key="location-save-error" message="location-save-error" />

<div class="locations">
	<liferay-ui:search-container emptyResultsMessage="locations-empty-results" delta="${prefBean.numRows}" deltaConfigurable="true" iteratorURL="<%= itURL %>">
	
		<liferay-ui:search-container-results 
			results="<%=LocationLocalServiceUtil.getLocationsByGroupId(portletGroupId, searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=LocationLocalServiceUtil.getLocationsCountByGroupId(portletGroupId)%>"
		/>
		
		<liferay-ui:search-container-row className="com.rivetlogic.event.model.Location" 
			keyProperty="locationId" modelVar="location">

				<liferay-ui:search-container-column-text name="location-name" property="name" />
				
				<liferay-ui:search-container-column-jsp path="/html/eventManagementPortlet/include/location-actions.jsp" align="right" />
				
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
		
	</liferay-ui:search-container>
</div>

<div class="add-location">
	<h3 class="taglib-header" ><liferay-ui:message key="locations-add" /></h3>
	
	<portlet:actionURL name="addLocation" var="addLocationURL"></portlet:actionURL>

	<aui:form action="<%= addLocationURL %>" name="<portlet:namespace />fm">

        <aui:fieldset>
            <aui:input name="name" required="true"/>
        </aui:fieldset>

        <aui:button-row>
            <aui:button type="submit"></aui:button>
        </aui:button-row>
	</aui:form>
</div> 