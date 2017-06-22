<%@include file="/html/init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Target target = (Target)row.getObject(); 
%>

<liferay-ui:icon-menu>
        <portlet:actionURL name="deleteTarget" var="deleteURL">
            <portlet:param name="targetId" value="<%= String.valueOf(target.getTargetId()) %>" />
        </portlet:actionURL>

        <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</liferay-ui:icon-menu>