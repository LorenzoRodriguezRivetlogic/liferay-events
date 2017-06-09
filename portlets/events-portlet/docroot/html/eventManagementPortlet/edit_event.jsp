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

Calendar valueEndDate = null;
String eventEndDate = StringPool.BLANK;

if (Validator.isNotNull(event.getEventDate())) {
	eventDate = dateFormatDate.format(event.getEventDate());
	valueDate = Calendar.getInstance();
	valueDate.setTime(event.getEventDate()); 
}
if (Validator.isNotNull(event.getEventEndDate())) {
	eventEndDate = dateFormatDate.format(event.getEventEndDate());
	valueEndDate = Calendar.getInstance();
	valueEndDate.setTime(event.getEventEndDate()); 
}

List<com.liferay.calendar.model.Calendar> manageableCalendars = CalendarServiceUtil.search(
		themeDisplay.getCompanyId(), null, null, null, true,
		QueryUtil.ALL_POS, QueryUtil.ALL_POS,
		new CalendarNameComparator(true),
		WebKeys.ACTION_KEY_MANAGE_BOOKINGS);

long calendarId = event.getCalendarId();
	
List<Location> locations = LocationLocalServiceUtil.getLocationsByGroupId(portletGroupId);
Long locationId = event.getLocationId();

List<Type> types = TypeLocalServiceUtil.getTypesByGroupId(portletGroupId);
Long typeId = event.getTypeId();

List<Target> targets = TargetLocalServiceUtil.getTargetsByGroupId(portletGroupId);
Long targetId = event.getTargetId();

String divStyle = event.getRegistrationRequired() ?  "block":"none";
String divStylePrivateEvent = event.getPrivateEvent()?  "block":"none";
%>

<liferay-ui:error key="event-save-error" message="event-save-error" />
<liferay-ui:error key="event-name-required" message="event-name-required" />
<liferay-ui:error key="event-location-required" message="event-location-required" />
<liferay-ui:error key="event-description-required" message="event-description-required" />
<liferay-ui:error key="event-start-date-required" message="event-start-date-required" />
<liferay-ui:error key="event-end-date-required" message="event-end-date-required" />
<liferay-ui:error key="event-invalid-start-date" message="event-invalid-start-date" />
<liferay-ui:error key="event-invalid-end-date" message="event-invalid-end-date" />
<liferay-ui:error key="start-date-before-start-date" message="start-date-before-start-date" />

<liferay-ui:error key="event-date-in-future" message="event-date-in-future" />
<liferay-ui:error key="event-start-hour-required" message="event-start-hour-required" />
<liferay-ui:error key="event-end-hour-required" message="event-end-hour-required" />
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

<portlet:renderURL var="dialogLocations" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/dialog/locations_dialog.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="dialogTypes" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/dialog/type_dialog.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="dialogTarget" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/dialog/target_dialog.jsp"/>
</portlet:renderURL>

<portlet:resourceURL var="resourceURL"/>

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
				<!-- aui:validator name="required"/-->
			</aui:input>
			<div>
				<aui:select id="locations" name="locations" label="locations" showEmptyOption="true" inlineField="<%=true%>">
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
				<aui:button style="display:inline-block" name="dialog-locations"  id="dialog-locations" value="event-add-location" inlineField="<%=true%>"></aui:button>
			</div>
    	</aui:fieldset>
    	
    	<aui:fieldset label="event-start-date">
    	
	        <aui:input name="<%=EventPortletConstants.PARAMETER_EVENT_DATE%>" label="" value="<%=eventDate%>" type="text" inlineField="<%=true%>">
	        	<!--aui:validator name="required"/-->
	        </aui:input>
			<span class="control-group">
				<c:choose>
					<c:when test="<%= Validator.isNotNull(valueDate) %>">
						<liferay-ui:input-time
							name="startTime"
							amPmParam="startAmpm" 
							hourParam="startHour" 
							minuteParam="startMin" 
							minuteInterval="30"
							hourValue="<%=valueDate.get(Calendar.HOUR)%>" 
							minuteValue="<%=valueDate.get(Calendar.MINUTE)%>"
							amPmValue="<%=valueDate.get(Calendar.AM_PM)%>"
							cssClass="event-hour"
						/>
					</c:when>
					<c:otherwise>
						<liferay-ui:input-time 
							name="startTime"
							amPmParam="startAmpm" 
							hourParam="startHour" 
							minuteParam="startMin" 
							minuteInterval="30"
							cssClass="event-hour"
						/>
					</c:otherwise>
				</c:choose>
			</span>

		</aui:fieldset>
    	
    	<aui:fieldset label="event-end-date">
    	
	        <aui:input name="<%=EventPortletConstants.PARAMETER_EVENT_END_DATE%>" label="" value="<%=eventEndDate%>" type="text" inlineField="<%=true%>">
	        	<!--aui:validator name="required"/-->
	        </aui:input>
		
			<span class="control-group">
				<c:choose>
					<c:when test="<%= Validator.isNotNull(valueEndDate) %>">
						<liferay-ui:input-time
							name="endTime"
							amPmParam="endAmpm" 
							hourParam="endHour" 
							minuteParam="endMin" 
							minuteInterval="30"
							hourValue="<%=valueEndDate.get(Calendar.HOUR)%>" 
							minuteValue="<%=valueEndDate.get(Calendar.MINUTE)%>"
							amPmValue="<%=valueEndDate.get(Calendar.AM_PM)%>"
							cssClass="event-hour"
						/>
					</c:when>
					<c:otherwise>
						<liferay-ui:input-time
							name="endTime" 
							amPmParam="endAmpm" 
							hourParam="endHour" 
							minuteParam="endMin" 
							minuteInterval="30"
							cssClass="event-hour"
						/>
					</c:otherwise>
				</c:choose>
			</span>

		</aui:fieldset>
		
		<aui:fieldset label="event-description">
			<aui:field-wrapper>
				<aui:input name="<%=EventPortletConstants.PARAMETER_DESCRIPTION%>" label="" type="hidden" value="${event.description}">
					<!-- aui:validator name="required"/-->
				</aui:input>
				<liferay-ui:input-editor toolbarSet="liferay"/>
			</aui:field-wrapper>
		</aui:fieldset>
		
		<aui:fieldset label="event-image">
			<p><liferay-ui:message key="event-photo-info"/></p>
			<aui:input  name="photo" value="" type="file" label="event-upload-file">
				<aui:validator name="required"/>
			</aui:input>
		</aui:fieldset>
		
		<aui:fieldset label="event-categorization">
			<div>
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
				<aui:button name="dialog-types"  id="dialog-types" value="event-new" inlineField="<%=true%>"> </aui:button>
			</div>
			<div>
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
				<aui:button name="dialog-targets"  id="dialog-targets" value="event-new" inlineField="<%=true%>"> </aui:button>
			</div>
			
			<liferay-ui:asset-tags-selector curTags="<%= event.getTags() %>"/>
		</aui:fieldset>
		
		<aui:fieldset label="calendar">
			<aui:select label="" name="calendarId">
				<%
				for (com.liferay.calendar.model.Calendar curCalendar : manageableCalendars) {
				%>
					<aui:option selected="<%= curCalendar.getCalendarId() == calendarId %>" value="<%= curCalendar.getCalendarId() %>"><%= HtmlUtil.escape(curCalendar.getName(locale)) %></aui:option>
	
				<%
				}
				%>
	
			</aui:select>
		</aui:fieldset>
		
		<div id="hiddenParticipants" style="display: <%= divStylePrivateEvent %>">
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
		</div>	
		
		<aui:fieldset label="event-registration">
			<aui:field-wrapper>
				<aui:input name="registrationRequired" id="registrationRequired" type="checkbox"  value="${event.registrationRequired}"></aui:input>
			</aui:field-wrapper>
			
			<div id="hiddenInfo" style="display: <%= divStyle %>">
				<span class="title-text" ><liferay-ui:message key="event-registration-information" /></span>
				<div class="accordion-inner">
					<aui:field-wrapper inlineField="<%=true%>">
						<aui:input name="<%=EventPortletConstants.PARAMETER_REGISTRATION_FULL_NAME%>" label="event-registration-full-name" type="checkbox" value="${event.requiredFullName}"/>
					</aui:field-wrapper>
					<aui:field-wrapper inlineField="<%=true%>">
						<aui:input name="<%=EventPortletConstants.PARAMETER_REGISTRATION_TELEPHONE%>" label="event-registration-telephone" type="checkbox" value="${event.requiredPhone}"/>
					</aui:field-wrapper>
				</div>
			</div>
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
<aui:script>
AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window','aui-dialog-iframe-deprecated',function(A) {
	A.one('#<portlet:namespace />dialog-locations').on('click', function(event){
		Liferay.Util.openWindow({
	    	dialog: {
	        	width: 400,                        
	         	modal: true,
	         	constrain: true,
	         	destroyOnClose: true,
	         	destroyOnHide: true,
	         	cache: false,
	        	on: {
	            	destroy: function() { 
	            		reloadLocations();             
	            	}
	        	}
	    	},
   			uri: '<%=dialogLocations.toString()%>',
    		id: 'locationPopup',
    		title: 'Locations'
		});
	});
	
	
	A.one('#<portlet:namespace />dialog-types').on('click', function(event){
		Liferay.Util.openWindow({
	    	dialog: {
	        	width: 400,                        
	         	modal: true,
	         	constrain: true,
	         	destroyOnClose: true,
	         	destroyOnHide: true,
	         	cache: false,
	        	on: {
	            	destroy: function() { 
	            		reloadTypes();           
	            	}
	        	}
	    	},
   			uri: '<%=dialogTypes.toString()%>',
    		id: 'typesPopup',
    		title: 'Types'
		});
	});
	
	A.one('#<portlet:namespace />dialog-targets').on('click', function(event){
		Liferay.Util.openWindow({
	    	dialog: {
	        	width: 400,                        
	         	modal: true,
	         	constrain: true,
	         	destroyOnClose: true,
	         	destroyOnHide: true,
	         	cache: false,
	        	on: {
	            	destroy: function() { 
	            		reloadTargets();
	            	}
	        	}
	    	},
   			uri: '<%=dialogTarget.toString()%>',
    		id: 'targetsPopup',
    		title: 'Target'
		});
	});
});

function reloadLocations(){
	AUI().use('aui-base', function(A){
		A.io.request('<%=resourceURL.toString()%>', {
			method: 'post',
			data: {
				<portlet:namespace />action: 'getLocations',
			},
			dataType: 'json',
			on: {
				success: function() {
			     	var result = this.get('responseData');
			     	var select = A.one('#<portlet:namespace/>locations');
			     	removeOptions(select);
			     	var optionT = A.Node.create('<option value=\"\"></option>');
	     	        select.append(optionT);
			     	for(var k in result){
			     	    if ({}.hasOwnProperty.call(result, k)){
			     	        var option = A.Node.create('<option value=\"'+k+'\">'+result[k]+'</option>');
			     	        select.append(option);
			     	    }
			     	}    
			    }
			}
		});
	});
}

function reloadTypes(){
	AUI().use('aui-base', function(A){
		A.io.request('<%=resourceURL.toString()%>', {
			method: 'post',
			data: {
				<portlet:namespace />action: 'getTypes',
			},
			dataType: 'json',
			on: {
				success: function() {
			     	var result = this.get('responseData');
			     	var select = A.one('#<portlet:namespace/>types');
			     	removeOptions(select);
			     	var optionT = A.Node.create('<option value=\"\"></option>');
	     	        select.append(optionT);
			     	for(var k in result){
			     	    if ({}.hasOwnProperty.call(result, k)){
			     	        var option = A.Node.create('<option value=\"'+k+'\">'+result[k]+'</option>');
			     	        select.append(option);
			     	    }
			     	}    
			    }
			}
		});
	});
}

function reloadTargets(){
	AUI().use('aui-base', function(A){
		A.io.request('<%=resourceURL.toString()%>', {
			method: 'post',
			data: {
				<portlet:namespace />action: 'getTargets',
			},
			dataType: 'json',
			on: {
				success: function() {
			     	var result = this.get('responseData');
			     	var select = A.one('#<portlet:namespace/>targets');
			     	removeOptions(select);
			     	var optionT = A.Node.create('<option value=\"\"></option>');
	     	        select.append(optionT);
			     	for(var k in result){
			     	    if ({}.hasOwnProperty.call(result, k)){
			     	        var option = A.Node.create('<option value=\"'+k+'\">'+result[k]+'</option>');
			     	        select.append(option);
			     	    }
			     	}    
			    }
			}
		});
	});
}

function removeOptions(comboBox){
	comboBox.all('option').each(function() {
		this.remove();
	});
}

AUI().ready('aui-base','event','node', function(A){
   	if(A.one("#<portlet:namespace />registrationRequiredCheckbox")){
		A.one('#<portlet:namespace/>registrationRequiredCheckbox').on('click',function(e){ 
			var visible = (A.one("#<portlet:namespace/>registrationRequired").attr('value') == 'true');
			var div = document.getElementById('hiddenInfo');
			if (visible) {
				div.style.display = 'block';
			} else {
				div.style.display = 'none';
				var checkboxFullname = A.one("#<portlet:namespace />registrationFullNameCheckbox");
				var checkboxEmail = A.one("#<portlet:namespace />registrationEmailCheckbox");
				var checkboxTelephone = A.one("#<portlet:namespace />registrationTelephoneCheckbox");
				checkboxFullname.set('checked', false);
				checkboxEmail.set('checked', false);
				checkboxTelephone.set('checked', false);
				Liferay.Util.updateCheckboxValue(checkboxFullname);
				Liferay.Util.updateCheckboxValue(checkboxEmail);
				Liferay.Util.updateCheckboxValue(checkboxTelephone);
			}
	    });
	}
   	
   	if(A.one("#<portlet:namespace />eventCheckbox")){
		A.one('#<portlet:namespace/>eventCheckbox').on('click',function(e){ 
			var visible = (A.one("#<portlet:namespace/>event").attr('value') == 'true');
			console.log(visible);
			var div = document.getElementById('hiddenParticipants');
			if (visible) {
				div.style.display = 'block';
			} else {
				div.style.display = 'none';
			}
		});
   	}
});
</aui:script>