<%@include file="/html/init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Location location = (Location)row.getObject(); 

int uses = EventLocalServiceUtil.getEventsCountByLocation(location.getLocationId());
%>

<liferay-ui:icon-menu>
        <portlet:actionURL name="deleteLocation" var="deleteURL">
            <portlet:param name="locationId" value="<%= String.valueOf(location.getLocationId()) %>" />
        </portlet:actionURL>

		<% if (uses == 0) { %>
        	<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
        <% } %>
</liferay-ui:icon-menu>