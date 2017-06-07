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

package com.rivetlogic.event.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.event.NoSuchEventException;
import com.rivetlogic.event.beans.EventsPrefsBean;
import com.rivetlogic.event.model.Event;
import com.rivetlogic.event.model.Participant;
import com.rivetlogic.event.model.Token;
import com.rivetlogic.event.model.impl.ParticipantImpl;
import com.rivetlogic.event.notification.constant.EventPortletConstants;
import com.rivetlogic.event.notification.constant.NotificationConstants;
import com.rivetlogic.event.notification.constant.PreferencesConstants;
import com.rivetlogic.event.service.EventLocalServiceUtil;
import com.rivetlogic.event.service.ParticipantLocalServiceUtil;
import com.rivetlogic.event.service.TokenLocalServiceUtil;
import com.rivetlogic.event.util.EventActionUtil;
import com.rivetlogic.event.util.EventConstant;
import com.rivetlogic.event.util.EventValidator;
import com.rivetlogic.event.util.WebKeys;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

/**
 * @author charlesrodriguez
 * @author christopherjimenez
 * @author juancarrillo
 * @author lorenzorodriguez
 */
public class EventPortlet extends MVCPortlet {
    
    public void changePreferences(ActionRequest request, ActionResponse response) {
        
        try {
            EventsPrefsBean prefBean = new EventsPrefsBean(request);
            prefBean.save(request);
            request.setAttribute(WebKeys.PREF_BEAN, prefBean);
        } catch (ReadOnlyException roe) {
            _log.error(PreferencesConstants.ERROR_LOAD_PREFERENCES, roe);
            SessionErrors.add(request, PreferencesConstants.ERROR_LOAD_PREFERENCES);
        } catch (ValidatorException ve) {
            _log.error(PreferencesConstants.ERROR_WRITE_PERFERENCES, ve);
            SessionErrors.add(request, PreferencesConstants.ERROR_WRITE_PERFERENCES);
        } catch (IOException ioe) {
            _log.error(PreferencesConstants.ERROR_IO_PREFERENCES, ioe);
            SessionErrors.add(request, PreferencesConstants.ERROR_IO_PREFERENCES);
        }
    }
    
    @Override
    public void doEdit(RenderRequest request, RenderResponse response) throws IOException, PortletException {
        
        String selectedTab = ParamUtil.getString(request, WebKeys.SELECTED_TAB, PreferencesConstants.DISPLAY_EMAIL_FROM);
        
        request.setAttribute(WebKeys.PREF_BEAN, new EventsPrefsBean(request));
        request.setAttribute(WebKeys.SELECTED_TAB, selectedTab);
        
        super.doEdit(request, response);
    }
    
    @Override
    public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
        String jspPage = getInitParameter(VIEW_TEMPLATE);
        EventsPrefsBean prefBean = new EventsPrefsBean(request);
        
        Long eventId = ParamUtil.getLong(request, NotificationConstants.EVENT_ID, EventPortletConstants.INVALID_ID);
        
        if (eventId != EventPortletConstants.INVALID_ID) {
            jspPage = getInitParameter(CONFIRMATION_TEMPLATE);
            processConfirmation(request, eventId, prefBean);
        }
        
        request.setAttribute(WebKeys.PREF_BEAN, prefBean);
        include(jspPage, request, response);
    }
    
    public void registerUserToEvent(ActionRequest request, ActionResponse response) throws IOException {
        Participant participant = EventActionUtil.getParticipantFromRequest(request);
        
        List<String> errors = new ArrayList<String>();
        List<String> invalidEmails = new ArrayList<String>();
        List<String> repeatedEmails = new ArrayList<String>();
        
        String redirect = ParamUtil.getString(request, WebKeys.REDIRECT);
        
        if (EventValidator.validateRegisteredParticipant(participant, null, errors, repeatedEmails, invalidEmails)) {
            saveParticipant(request, response, participant, redirect);
            
        } else {
            EventActionUtil.setErrors(errors, request);
        }
        
        if (!SessionErrors.isEmpty(request)) {
            request.setAttribute(WebKeys.PARTICIPANT_ENTRY, participant);
            request.setAttribute(WebKeys.REPEATED_EMAILS, repeatedEmails);
            request.setAttribute(WebKeys.INVALID_EMAILS, invalidEmails);
            
            response.setRenderParameter(WebKeys.MVC_PATH, WebKeys.EVENT_VIEW_PAGE);
            
            response.setRenderParameter(WebKeys.REDIRECT, redirect);
            
            response.setRenderParameter(EventPortletConstants.PARAMETER_RESOURCE_PRIMARY_KEY,
                    ParamUtil.getString(request, NotificationConstants.EVENT_ID));
        }
    }
    
    @Override
    public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        
        String mvcPath = ParamUtil.getString(request, WebKeys.MVC_PATH);
        if (mvcPath.equals(WebKeys.EVENT_VIEW_PAGE)) {
        	ThemeDisplay themeDisplay  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
        	User user = themeDisplay.getUser();
        	if(themeDisplay.isSignedIn()){
				Participant participant = new ParticipantImpl();
				participant.setFullName(user.getFullName());
				participant.setEmail(user.getEmailAddress());
	
				try {
					List<Phone> phones = user.getPhones();
					if (phones.size() > 0) {
						Phone phone = phones.get(0);
						String phoneNumber = phone.getNumber();
						if (phone.getExtension() != null
								&& phone.getExtension().length() > 0) {
							phoneNumber += " " + PHONE_EXTENSION_PREFIX + phone.getExtension();
						}
						participant.setPhoneNumber(phoneNumber);
					}
				} catch (SystemException e) {
					_log.error(e.getMessage());
				}
				
				request.setAttribute(WebKeys.PARTICIPANT_ENTRY, participant);
        	}

            try {
				EventActionUtil.loadEvent(request, true);
			} catch (SystemException e) {
				_log.error("Unable to load event");
				_log.debug(e);
			}
            // Remove default error message
            SessionMessages.add(request, PortalUtil.getPortletId(request)
                    + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }
        
        super.render(request, response);
    }
    
    private void processConfirmation(PortletRequest request, long eventId, EventsPrefsBean eventPrefsBean) {
        String uuid = ParamUtil.getString(request, EventPortletConstants.PARAMETER_TOKEN, null);
        String[] data = null;
        try {
            Token token = TokenLocalServiceUtil.getTokenByUuid(uuid);
            if (!token.isExpired()) {
                Participant participant = ParticipantLocalServiceUtil.getParticipant(token.getParticipantId());

                if (participant.getEventId() == eventId) {
                    Event event = EventLocalServiceUtil.getEvent(eventId);
                    Boolean isGoing = EventConstant.STATUS_GOING.equals(ParamUtil.getString(request, PARAMETER_STATUS));
                    participant.setStatus(isGoing ? EventConstant.EVENT_STATUS_ACCEPTER
                            : EventConstant.EVENT_STATUS_REJECTED);
                    
                    TokenLocalServiceUtil.expireToken(token);
                    ParticipantLocalServiceUtil.updateParticipant(participant);
                    
                    request.setAttribute(WebKeys.IS_GOING, isGoing);
                    request.setAttribute(WebKeys.EVENT_ENTRY, event);
                    data = new String[] { eventPrefsBean.getEmailFrom(), eventPrefsBean.getNameFrom(), event.getName(),
                            NotificationConstants.CDF.format(event.getEventDate()), participant.getFullName(),
                            participant.getEmail(), event.getLocation(), event.getDescription(), StringPool.BLANK,
                            StringPool.BLANK, StringPool.BLANK, PortalUtil.getPortalURL(request) };
                } else {
                    data = new String[] { eventPrefsBean.getEmailFrom(), eventPrefsBean.getNameFrom(),
                            StringPool.BLANK, StringPool.BLANK, participant.getFullName(), participant.getEmail(),
                            StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
                            PortalUtil.getPortalURL(request) };
                    request.setAttribute(WebKeys.INVALID, true);
                }
            } else {
                
                request.setAttribute(WebKeys.EXPIRED_TOKEN, true);
            }
            
        } catch (Exception e) {
            data = new String[] { eventPrefsBean.getEmailFrom(), eventPrefsBean.getNameFrom(), StringPool.BLANK,
                    StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
                    StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, PortalUtil.getPortalURL(request) };
            request.setAttribute(WebKeys.INVALID, true);
            _log.error(e.getMessage());
        } 
        eventPrefsBean.processTemplates(data);
    }
    
    private void saveParticipant(ActionRequest request, ActionResponse response, Participant participant,
            String redirect) {
        
        verifyEvent(request, participant.getEventId());
        
        if (SessionErrors.isEmpty(request)) {
            try {
                participant.setStatus(EventConstant.EVENT_STATUS_ACCEPTER);
                participant = ParticipantLocalServiceUtil.addParticipant(participant);
                
                sendNotification(request, participant);
                SessionMessages.add(request, MESSAGE_REGISTRATION_SUCCESS);
                SessionMessages.add(request, MESSAGE_REGISTRATION_EMAIL);
                response.sendRedirect(redirect);
            } catch (Exception e) {
                _log.error(e);
                SessionErrors.add(request, ERROR_SAVING_PARTICIPANT);
            }
        }
    }
    
    private void sendNotification(PortletRequest request, Participant participant) {
        
        EventsPrefsBean prefBean = new EventsPrefsBean(request);
     
        // Events URL
        ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
        Layout layout = themeDisplay.getLayout();
        String publicURL = themeDisplay.getPathFriendlyURLPublic() + themeDisplay.getScopeGroup().getFriendlyURL() + layout.getFriendlyURL();
        prefBean.setPublicEventsURL(publicURL);
        
        Message message = new Message();
        message.put(NotificationConstants.CMD, NotificationConstants.MANUAL_EVENT_REGISTRATION);
        
        message.put(NotificationConstants.SENDER, prefBean.getEmailFrom());
        message.put(NotificationConstants.SENDER_NAME, prefBean.getNameFrom());
        message.put(NotificationConstants.RECIPIENTS, participant.getEmail());
        message.put(NotificationConstants.BODY_TEMPLATE, prefBean.getRegularInvitationBody());
        message.put(NotificationConstants.SUBJECT_TEMPLATE, prefBean.getRegularInvitationSubject());
        message.put(NotificationConstants.PUBLIC_URL, prefBean.getPublicEventsURL());
        message.put(NotificationConstants.PORTAL_URL, PortalUtil.getPortalURL(request));
        message.put(NotificationConstants.PARTICIPANT, participant);
        
        MessageBusUtil.sendMessage(NotificationConstants.SEND_NOTIFICATION_DESTINATION, message);
    }
    
    private void verifyEvent(PortletRequest request, long resourcePrimKey) {
        try {
            EventLocalServiceUtil.getEvent(resourcePrimKey);
            
        } catch (Exception e) {
            SessionErrors.add(request, ERROR_SAVING_PARTICIPANT);
            if (!(e instanceof NoSuchEventException)) {
                _log.error(e);
            }
        }
    }
    
    public void searchEvents(ActionRequest request, ActionResponse response) throws IOException {
    	String searchText = ParamUtil.getString(request, WebKeys.SEARCH_TEXT);
		Long locationId = ParamUtil.getLong(request, WebKeys.LOCATION);
		Long typeId = ParamUtil.getLong(request, WebKeys.TYPE);
		Long targetId = ParamUtil.getLong(request, WebKeys.TARGET);

		response.setRenderParameter(WebKeys.SEARCH_TEXT, searchText);
	    response.setRenderParameter(WebKeys.LOCATION, String.valueOf(locationId));
	    response.setRenderParameter(WebKeys.TYPE, String.valueOf(typeId));
	    response.setRenderParameter(WebKeys.TARGET, String.valueOf(targetId));
	    
	    disableNotifications(request);
    }
    
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
    		throws  IOException, PortletException {

		try {
			long eventId=ParamUtil.getLong(resourceRequest,"eventId");
			Event event=  EventLocalServiceUtil.getEvent(eventId);
			if(event != null){
				Blob image = event.getImage();
				byte[ ] imgData = image.getBytes(1,(int)image.length());
				resourceResponse.setContentType("image/jpg");
				OutputStream o = resourceResponse.getPortletOutputStream();
				o.write(imgData);
				o.flush();
				o.close();
			}    
		} catch (Exception e) {
		}
    }
    
    private void disableNotifications(ActionRequest request) {
		PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
        LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
        SessionMessages.add(request, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
   
    private static final Log _log = LogFactoryUtil.getLog(EventPortlet.class);
    
    private static final String ERROR_SAVING_PARTICIPANT = "participant-save-error";
    private static final String MESSAGE_REGISTRATION_EMAIL = "participant-registration-email";
    private static final String MESSAGE_REGISTRATION_SUCCESS = "participant-registration-success";
    private static final String VIEW_TEMPLATE = "view-template";
    private static final String PARAMETER_STATUS = "status";
    private static final String CONFIRMATION_TEMPLATE = "confirmation-jsp";
    private static final String PHONE_EXTENSION_PREFIX = "Ext.";
}
