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

package com.rivetlogic.event.util;

import com.liferay.portal.kernel.util.Validator;
import com.rivetlogic.event.model.Event;
import com.rivetlogic.event.model.Participant;
import com.rivetlogic.event.service.ParticipantLocalServiceUtil;

import java.util.List;

public class EventValidator {
    
    private static final String EVENT_NAME_REQUIRED = "event-name-required";
    private static final String EVENT_DESCRIPTION_REQUIRED = "event-description-required";
    private static final String EVENT_LOCATION_REQUIRED = "event-location-required";
    private static final String EVENT_DATETIME_REQUIRED = "event-date-time-required";
    private static final String PARTICIPANT_FULL_NAME_REQUIRED = "participant-fullname-required";
    private static final String PARTICIPANT_PHONE_REQUIRED = "participant-phone-required";
    private static final String PARTICIPANT_PHONE_INVALID = "participant-phone-invalid";
    private static final String PARTICIPANT_EMAIL_REQUIRED = "participant-email-required";
    private static final String PARTICIPANT_INVALID_EMAIL = "participant-invalid-email-";
    private static final String PARTICIPANT_REPEATED_EMAIL = "participant-repeated-email-";
    
    public static boolean validateEvent(Event event, List<String> errors) {
        
        boolean isValid = false;
        
        if (Validator.isNull(event.getName())) {
            errors.add(EVENT_NAME_REQUIRED);
        }
        
        if (Validator.isNull(event.getDescription())) {
            errors.add(EVENT_DESCRIPTION_REQUIRED);
        }
        
        if (Validator.isNull(event.getLocationId())) {
            errors.add(EVENT_LOCATION_REQUIRED);
        }
        
        if (Validator.isNull(event.getEventDate())) {
            errors.add(EVENT_DATETIME_REQUIRED);
        }
        
        if (errors.isEmpty()) {
            isValid = true;
        }
        
        return isValid;
    }
    
    public static boolean validateParticipantInfo(Participant participant, List<Participant> participants,
            List<String> errors, List<String> repeatedEmails, List<String> invalidEmails, Event event) {
        
        boolean isValid = false;
        
        if (event.getRequiredFullName()) {
        	if (Validator.isNull(participant.getFullName())) {
                errors.add(PARTICIPANT_FULL_NAME_REQUIRED);
            }
        }
        
        if (event.getRequiredPhone()) {
        	if (Validator.isNull(participant.getPhoneNumber())) {
                errors.add(PARTICIPANT_PHONE_REQUIRED);
            } else if (!Validator.isPhoneNumber(participant.getPhoneNumber())) {
                errors.add(PARTICIPANT_PHONE_INVALID);
            }
        }
        
    	String participantEmail = participant.getEmail();
        
        if (Validator.isNull(participantEmail)) {
            errors.add(PARTICIPANT_EMAIL_REQUIRED);
            
        } else if (!Validator.isEmailAddress(participantEmail)) {
            errors.add(PARTICIPANT_INVALID_EMAIL + participantEmail);
            
            if (!invalidEmails.contains(participantEmail)) {
                invalidEmails.add(participantEmail);
            }
            
        } else {
            
            if (Validator.isNotNull(participants)) {
                
                for (int i = 0; i < participants.size(); ++i) {
                    
                    if (participants.get(i).getEmail().equals(participantEmail)) {
                        errors.add(PARTICIPANT_REPEATED_EMAIL + participantEmail);
                        if (!repeatedEmails.contains(participantEmail)) {
                            repeatedEmails.add(participantEmail);
                        }
                    }
                }
                
            }
        }

        if (errors.isEmpty()) {
            isValid = true;
        }
        
        return isValid;
    }
    
    public static boolean validateParticipantInfo(Participant participant, List<Participant> participants,
            List<String> errors, List<String> repeatedEmails, List<String> invalidEmails) {
        
        boolean isValid = false;

    	if (Validator.isNull(participant.getFullName())) {
            errors.add(PARTICIPANT_FULL_NAME_REQUIRED);
        }
        
    	if (Validator.isNull(participant.getPhoneNumber())) {
            errors.add(PARTICIPANT_PHONE_REQUIRED);
        } else if (!Validator.isPhoneNumber(participant.getPhoneNumber())) {
            errors.add(PARTICIPANT_PHONE_INVALID);
        }
        
    	String participantEmail = participant.getEmail();
        
        if (Validator.isNull(participantEmail)) {
            errors.add(PARTICIPANT_EMAIL_REQUIRED);
            
        } else if (!Validator.isEmailAddress(participantEmail)) {
            errors.add(PARTICIPANT_INVALID_EMAIL + participantEmail);
            
            if (!invalidEmails.contains(participantEmail)) {
                invalidEmails.add(participantEmail);
            }
            
        } else {
            
            if (Validator.isNotNull(participants)) {
                
                for (int i = 0; i < participants.size(); ++i) {
                    
                    if (participants.get(i).getEmail().equals(participantEmail)) {
                        errors.add(PARTICIPANT_REPEATED_EMAIL + participantEmail);
                        if (!repeatedEmails.contains(participantEmail)) {
                            repeatedEmails.add(participantEmail);
                        }
                    }
                }
                
            }
        }

        if (errors.isEmpty()) {
            isValid = true;
        }
        
        return isValid;
    }
    
    public static boolean validateRegisteredParticipant(Participant participant, List<Participant> participants,
            List<String> errors, List<String> repeatedEmails, List<String> invalidEmails, Event event) {
        
        boolean isValid = false;
        
        validateParticipantInfo(participant, participants, errors, repeatedEmails, invalidEmails, event);
        
        String participantEmail = participant.getEmail();
        
        if (!ParticipantLocalServiceUtil.findParticipantByEventIdAndEmail(participant.getEventId(), participantEmail)
                .isEmpty()) {
            errors.add(PARTICIPANT_REPEATED_EMAIL + participantEmail);
            if (!repeatedEmails.contains(participantEmail)) {
                repeatedEmails.add(participantEmail);
            }
        }
        
        if (errors.isEmpty()) {
            isValid = true;
        }
        
        return isValid;
    }
    
    public static boolean validateRegisteredParticipant(Participant participant, List<Participant> participants,
            List<String> errors, List<String> repeatedEmails, List<String> invalidEmails) {
        
        boolean isValid = false;
        
        validateParticipantInfo(participant, participants, errors, repeatedEmails, invalidEmails);
        
        String participantEmail = participant.getEmail();
        
        if (!ParticipantLocalServiceUtil.findParticipantByEventIdAndEmail(participant.getEventId(), participantEmail)
                .isEmpty()) {
            errors.add(PARTICIPANT_REPEATED_EMAIL + participantEmail);
            if (!repeatedEmails.contains(participantEmail)) {
                repeatedEmails.add(participantEmail);
            }
        }
        
        if (errors.isEmpty()) {
            isValid = true;
        }
        
        return isValid;
    }
    
}
