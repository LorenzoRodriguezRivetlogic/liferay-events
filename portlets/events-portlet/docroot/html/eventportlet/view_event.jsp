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
<%@page import="com.rivetlogic.event.util.Utils"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="java.util.StringTokenizer"%>
<%@include file="/html/init.jsp" %>

<%
long resourcePrimKey = ParamUtil.getLong(request, EventPortletConstants.PARAMETER_RESOURCE_PRIMARY_KEY);
Event event = (Event) renderRequest.getAttribute(WebKeys.EVENT_ENTRY);

if (Validator.isNotNull(event)){
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
	
	String currPageSocialLink = PortalUtil.getCanonicalURL((PortalUtil.getCurrentURL(request)), themeDisplay, layout);
%>

<liferay-ui:error key="participant-fullname-required" message="participant-fullname-required" />
<liferay-ui:error key="participant-email-required" message="participant-email-required" />
<liferay-ui:error key="participant-phone-required" message="participant-phone-required" />
<liferay-ui:error key="participant-phone-invalid" message="participant-phone-invalid" />
<liferay-ui:error key="participant-company-name-required" message="participant-company-name-required" />
<liferay-ui:error key="participant-save-error" message="participant-save-error" />


<c:forEach items="${repeatedEmails}" var="repeatedEmail">
	<liferay-ui:error key="participant-repeated-email-${repeatedEmail}" message='<%=LanguageUtil.format(pageContext, "participant-x-already-registered", pageContext.getAttribute("repeatedEmail")) %>'/>
</c:forEach>

<c:forEach items="${invalidEmails}" var="invalidEmail">
	<liferay-ui:error key="participant-invalid-email-${invalidEmail}" message='<%=LanguageUtil.format(pageContext, "participant-invalid-email-x", pageContext.getAttribute("invalidEmail")) %>'/>
</c:forEach>

<portlet:renderURL var="backURL">
	<portlet:param name="<%=WebKeys.MVC_PATH %>" value="/html/eventportlet/view.jsp"/>
</portlet:renderURL> 

<portlet:actionURL name="registerUserToEvent" var="registerUserToEventUrl">
	<portlet:param name="<%=NotificationConstants.EVENT_ID%>" value="<%=String.valueOf(event.getEventId())%>"/>
	<portlet:param name="<%=WebKeys.REDIRECT%>" value="${backURL}"/>
</portlet:actionURL>

<portlet:resourceURL  var="imageResourceURL">
	<portlet:param name="action" value="image"/>
	<portlet:param name="eventId" value="<%= String.valueOf(event.getEventId()) %>"/>
</portlet:resourceURL>

<portlet:resourceURL  var="icsResourceURL">
	<portlet:param name="action" value="ics"/>
	<portlet:param name="eventId" value="<%= String.valueOf(event.getEventId()) %>"/>
	<portlet:param name="resourceId" value="<%= event.getName() %>"/>
</portlet:resourceURL>

<div class="view-event">

	<liferay-ui:header backURL="${backURL}" title="event-information"/>
	
	<div class="container-fluid event-info">
		<div class="row">
			<div class="span5">
				<img width="100%" src="<%=imageResourceURL.toString()%>" alt="no Image"/>
			</div>
			<div class="span7 event-detail" >
				<div class="row">
					<div class="span6">
						<h2><%= event.getName() %></h2>
					</div>
					<div class="span6">
						<a href="<%= icsResourceURL.toString() %>">
							<i class="icon-calendar"></i>
							<liferay-ui:message key="add-to-your-calendar" />
						</a>  
					</div>
				</div>
				<div class="row">
					<div class="span6">
						<% if (isSameDate) { %>
							<h4><%= NotificationConstants.SDFWD.format(event.getEventDate()) %></h4>
							<h4><%= NotificationConstants.SDFH.format(event.getEventDate()) %> - <%= NotificationConstants.SDFH.format(event.getEventEndDate()) %></h4>
						<% } else { %>
							<h4><%= NotificationConstants.SDF.format(event.getEventDate()) %> - </h4>
							<h4><%= NotificationConstants.SDF.format(event.getEventEndDate()) %></h4>
						<% } %>
						<h4><%= locationName %></h4>
					</div>
					<div class="span6">
						<liferay-ui:message key="share-with-friends" /><br />
						<a href="<%= Utils.generateMailtoLink(event, currPageSocialLink) %>">
							<i class="icon-envelope"></i>
						</a>
						<a href="https://www.facebook.com/sharer/sharer.php?u=<%= Utils.formatUrlForShare(currPageSocialLink)  %>" 
							onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=400,width=600');return false;">
							<i class="icon-facebook-sign"></i>
						</a>
						<a href="http://www.twitter.com/share?url=<%= currPageSocialLink %>&text=<%= Utils.replaceSpace(event.getName()) %>" 
							onclick="javascript:window.open(this.href, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=400,width=600');return false;">
							
							<i class="icon-twitter-sign"></i>
						</a>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<%= event.getDescription() %>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<b><liferay-ui:message key="tags-label" />:</b>
						<%
							StringTokenizer st = new StringTokenizer(event.getTags(),",");  
							while (st.hasMoreTokens()) { 
								String token = st.nextToken();
						%>	
								<portlet:renderURL var="tagUrl" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
									<portlet:param name="<%=WebKeys.SEARCH_TAG %>" value="<%= token %>"/>
								</portlet:renderURL>
								<a href="<%= tagUrl.toString() %>"><%= token %></a>  
						<%
							}   
						%>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%
	if (event.getRegistrationRequired()) {
	%>
		<liferay-ui:header title="event-register"/>
		
		<aui:form name="register_event_fm" action="${registerUserToEventUrl}" method="post">
			
			<aui:fieldset>
				
				<% 
				if (event.getRequiredFullName()) {
				%>
					<aui:input name="<%=EventPortletConstants.PARAMETER_FULL_NAME%>" label="event-fullname" value="${participant.fullName}" type="text">
						<aui:validator name="required"/>
					</aui:input>
				<% 
				}
				%>
				
				<aui:input name="<%=EventPortletConstants.PARAMETER_EMAIL%>" label="event-email" value="${participant.email}" type="text">
					<aui:validator name="required"/>
					<aui:validator name="email"/>
				</aui:input>
				<% 

				if (event.getRequiredPhone()) {
				%>
					<aui:input name="<%=EventPortletConstants.PARAMETER_PHONE_NUMBER%>" label="event-phone-number" value="${participant.phoneNumber}" type="text">
						<aui:validator name="required"/>
					</aui:input>
				<% 
				}
				%>
				<aui:button-row>
					<aui:button name="registerEvent" label="event-register" type="submit" value='<%=LanguageUtil.get(pageContext, "event-register") %>'/>
					<aui:button name="cancel" type="cancel" onClick="${backURL}"/>
				</aui:button-row>
				
			</aui:fieldset>
		</aui:form>
	<%
	}
	%>
</div>

<%
} else {
%>
    <liferay-ui:error key="no-such-event" message='<%=LanguageUtil.format(pageContext, "no-such-event", String.valueOf(resourcePrimKey)) %>' />
    <liferay-ui:error key="event-must-be-public" message="event-must-be-public" />
    <liferay-ui:error key="event-is-in-past" message="event-is-in-past" />
<%
}%>