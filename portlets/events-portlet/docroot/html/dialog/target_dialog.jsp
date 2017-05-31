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

<%@page import="com.rivetlogic.event.service.TargetLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>

<liferay-ui:error key="target-delete-error" message="target-delete-error" />
<liferay-ui:error key="target-save-error" message="target-save-error" />

<div class="targets">
	<liferay-ui:search-container emptyResultsMessage="type-empty-results" delta="${prefBean.numRows}" deltaConfigurable="true">
	
		<liferay-ui:search-container-results 
			results="<%=TargetLocalServiceUtil.getTargetsByGroupId(portletGroupId, searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=TargetLocalServiceUtil.getTargetsCountByGroupId(portletGroupId)%>"
		/>
		
		<liferay-ui:search-container-row className="com.rivetlogic.event.model.Target" 
			keyProperty="targetId" modelVar="target">

				<liferay-ui:search-container-column-text name="target-name" property="name" />
				
				<liferay-ui:search-container-column-jsp path="/html/eventManagementPortlet/include/target-actions.jsp" align="right" />
				
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
		
	</liferay-ui:search-container>
</div>

<div class="add-target">
	<h3 class="taglib-header" ><liferay-ui:message key="target-add" /></h3>
	
	<portlet:actionURL name="addTarget" var="addTargetURL"></portlet:actionURL>

	<aui:form action="<%= addTargetURL %>" name="<portlet:namespace />fm">

        <aui:fieldset>
            <aui:input name="name" required="true"/>
        </aui:fieldset>

        <aui:button-row>
            <aui:button type="submit"></aui:button>
        </aui:button-row>
	</aui:form>
</div> 