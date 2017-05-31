<%@include file="/html/init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Type type = (Type)row.getObject(); 
%>

<liferay-ui:icon-menu>
        <portlet:actionURL name="deleteType" var="deleteURL">
            <portlet:param name="typeId" value="<%= String.valueOf(type.getTypeId()) %>" />
        </portlet:actionURL>

        <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</liferay-ui:icon-menu>