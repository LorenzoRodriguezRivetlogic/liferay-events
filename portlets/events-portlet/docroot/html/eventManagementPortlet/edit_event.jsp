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
Event event = (Event) renderRequest.getAttribute(WebKeys.EVENT_ENTRY);
    		
long resourcePrimKey = ParamUtil.getLong(request, EventPortletConstants.PARAMETER_RESOURCE_PRIMARY_KEY);

Format dateFormatDate = FastDateFormatFactoryUtil.getSimpleDateFormat("MM/dd/yyyy");
Calendar valueDate = null;
String eventDate = StringPool.BLANK;

if (Validator.isNotNull(event.getEventDate())) {
	eventDate = dateFormatDate.format(event.getEventDate());
	valueDate = Calendar.getInstance();
	valueDate.setTime(event.getEventDate()); 
}
%>

<liferay-ui:error key="event-save-error" message="event-save-error" />
<liferay-ui:error key="event-name-required" message="event-name-required" />
<liferay-ui:error key="event-location-required" message="event-location-required" />
<liferay-ui:error key="event-description-required" message="event-description-required" />
<liferay-ui:error key="event-date-required" message="event-date-required" />
<liferay-ui:error key="event-invalid-date" message="event-invalid-date" />
<liferay-ui:error key="event-date-in-future" message="event-date-in-future" />
<liferay-ui:error key="event-hour-required" message="event-hour-required" />
<liferay-ui:error key="error-processing-csv" message="error-processing-csv" />
<liferay-ui:error key="invalid-csv-file" message="invalid-csv-file" />
<liferay-ui:error key="no-such-event" message='<%=LanguageUtil.format(pageContext, "no-such-event", String.valueOf(resourcePrimKey)) %>' />

<c:forEach items="${repeatedEmails}" var="repeatedEmail">
	<liferay-ui:error key="participant-repeated-email-${repeatedEmail}" message='<%=LanguageUtil.format(pageContext, "participant-repeated-email-x", pageContext.getAttribute("repeatedEmail")) %>'/>
</c:forEach>

<c:forEach items="${invalidEmails}" var="invalidEmail">
	<liferay-ui:error key="participant-invalid-email-${invalidEmail}" message='<%=LanguageUtil.format(pageContext, "participant-invalid-email-x", pageContext.getAttribute("invalidEmail")) %>'/>
</c:forEach>

<liferay-ui:error key="participant-invalid-email" message="" />

<portlet:renderURL var="backURL">
	<portlet:param name="<%=WebKeys.MVC_PATH %>" value="/html/eventManagementPortlet/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addEditEvent" var="addEditEventURL" >
	<portlet:param name="<%=EventPortletConstants.PARAMETER_RESOURCE_PRIMARY_KEY %>" value="${event.eventId}" />
	<portlet:param name="<%=WebKeys.REDIRECT%>" value="${backURL}"/>
</portlet:actionURL>
 
<div id="${pns}edit-event" class="event-portlet">

	<c:choose>
		<c:when test="<%=Validator.isNotNull(event.getEventId()) %>">
			<liferay-ui:header backURL="<%= backURL %>" title='<%= LanguageUtil.format(pageContext, "event-edit", event.getName()) %>'/>
		</c:when>
		<c:otherwise>
			<liferay-ui:header backURL="<%= backURL %>" title='new-event'/>
		</c:otherwise>
	</c:choose>

	<aui:form name="fm_edit_event" action="${addEditEventURL}" method="POST" enctype="multipart/form-data">
		
		<aui:fieldset label="event-information">
			<aui:field-wrapper>
				<aui:input name="<%=EventPortletConstants.PARAMETER_EVENT%>" label="event-private-question" type="checkbox" value="${event.privateEvent}"/>
			</aui:field-wrapper>
			<aui:input name="<%=EventPortletConstants.PARAMETER_NAME%>" label="participant-name" type="text" value="${event.name}">
				<aui:validator name="required"/>
			</aui:input>
			<aui:input name="<%=EventPortletConstants.PARAMETER_LOCATION%>" label="event-location" type="textarea" value="${event.location}">
				<aui:validator name="required"/>
			</aui:input>
    	</aui:fieldset>
    	
    	<aui:fieldset label="event-date">
    	
	        <aui:input name="<%=EventPortletConstants.PARAMETER_EVENT_DATE%>" label="" value="<%=eventDate%>" type="text" inlineField="<%=true%>">
	        	<aui:validator name="required"/>
	        </aui:input>
		
			<c:choose>
				<c:when test="<%= Validator.isNotNull(valueDate) %>">
					<liferay-ui:input-time 
						amPmParam="ampm" 
						hourParam="hour" 
						minuteParam="min" 
						minuteInterval="30"
						hourValue="<%=valueDate.get(Calendar.HOUR)%>" 
						minuteValue="<%=valueDate.get(Calendar.MINUTE)%>"
						amPmValue="<%=valueDate.get(Calendar.AM_PM)%>"
						cssClass="event-hour"
					/>
				</c:when>
				<c:otherwise>
					<liferay-ui:input-time 
						amPmParam="ampm" 
						hourParam="hour" 
						minuteParam="min" 
						minuteInterval="30"
						cssClass="event-hour"
					/>
				</c:otherwise>
			</c:choose>		

		</aui:fieldset>
		
		<aui:fieldset label="event-description">
			<aui:field-wrapper>
				<aui:input name="<%=EventPortletConstants.PARAMETER_DESCRIPTION%>" label="" type="hidden" value="${event.description}">
					<aui:validator name="required"/>
				</aui:input>
				<liferay-ui:input-editor toolbarSet="liferay"/>
			</aui:field-wrapper>
		</aui:fieldset>
		
		<aui:fieldset label="label-participants">
			<div id="${pns}upload">
		    	<aui:fieldset>
		        	<p><liferay-ui:message key="message-upload-participants"/></p>
		            <div>
		            	<aui:input type="file" name="<%=EventPortletConstants.PARAMETER_FILE%>" value="upload-file">
			            	<aui:validator name="acceptFiles">'.csv'</aui:validator>
		            	</aui:input>
		            </div>
		    	</aui:fieldset>
			</div>
		</aui:fieldset>
		
		<c:if test="<%=event != null%>">
		
			<liferay-ui:search-container 
					emptyResultsMessage="participant-empty-results" delta="${prefBean.numRows}" deltaConfigurable="true">
					<liferay-ui:search-container-results 
						results="<%=ParticipantLocalServiceUtil.getParticipants(event.getEventId())%>"
						total="<%=ParticipantLocalServiceUtil.getParticipantsCount(event.getEventId())%>"
					/>
				<liferay-ui:search-container-row 
					className="com.rivetlogic.event.model.Participant" 
					keyProperty="participantId" modelVar="participant">
					<%
						String statusLabel = LanguageUtil.get(pageContext, "participant-status-"+participant.getStatus());
					%>
					<liferay-ui:search-container-column-text name="participant-status" value="<%=statusLabel %>" />
					<liferay-ui:search-container-column-text name="participant-name" property="fullName" />
					<liferay-ui:search-container-column-text name="participant-email" property="email" />
					<liferay-ui:search-container-column-jsp path="/html/eventManagementPortlet/include/edit-event-actions.jsp"/>
				</liferay-ui:search-container-row>
		
				<liferay-ui:search-iterator />
		
			</liferay-ui:search-container>
			
		</c:if>
		
		<aui:fieldset id="add-participants">
			<div class="participant-info">
				<div class="div-table-row">
					<div class="div-table-col">
			    		<liferay-ui:message key="participant-fullname"/>
					</div>
					<div class="div-table-col">
					    <liferay-ui:message key="participant-email"/>
					</div>
				</div>
				<c:set var="paramFullName" value="<%=EventPortletConstants.PARAMETER_PARTICIPANT_FULL_NAME%>" />
				<c:set var="paramEmail" value="<%=EventPortletConstants.PARAMETER_PARTICIPANT_EMAIL%>" />
				<c:choose>
					<c:when test="${not empty participants}">
						<c:forEach items="${participants}" var="participant" varStatus="loop">
							<div class="lfr-form-row" >
						    	<div class="row-fields">
						    		<aui:input name="${paramFullName}${loop.count}" label="" value="${participant.fullName}" type="text" inlineField="<%= true %>"/>
						    		<aui:input name="${paramEmail}${loop.count}" label="" value="${participant.email}" type="text" inlineField="<%= true %>">
						    			<aui:validator name="email"/>
						    		</aui:input>
						    	</div>
						    </div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="lfr-form-row" >
					    	<div class="row-fields">
					    		<aui:input name="${paramFullName}1" label="" type="text" inlineField="<%= true %>"/>
					    		<aui:input name="${paramEmail}1" label="" type="text" inlineField="<%= true %>">
					    			<aui:validator name="email"/>
					    		</aui:input>
					    	</div>
					    </div>
					</c:otherwise>
				</c:choose>
			</div>
		   	<aui:input name="<%=WebKeys.PARTICIPANT_INDEXES%>" type="hidden"/>
		</aui:fieldset>	
		
		<aui:fieldset>
			<aui:button-row>
				<aui:button name="saveButton" type="submit" cssClass="event-button" value="save"  />
				<aui:button type="cancel" value="Cancel" cssClass="event-button" onClick="${backURL}" />
    		</aui:button-row>
		</aui:fieldset>	
		
	</aui:form>
</div>	

<aui:script use="event-management-plugin">
	Liferay.EventManagement.init(
		{
			namespace: '<portlet:namespace/>',
			container: A.one("#<portlet:namespace/>edit-event"),
		}
	);

</aui:script>	
<aui:script>
	function <portlet:namespace/>initEditor() {
		return document.<portlet:namespace/>fm_edit_event.<portlet:namespace/>description.value; 
	}
</aui:script>

