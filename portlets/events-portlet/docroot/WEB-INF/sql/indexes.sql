create index IX_D896DD7C on rivetlogic_event_Event (companyId);
create index IX_4BF092FE on rivetlogic_event_Event (groupId);
create index IX_E2C76750 on rivetlogic_event_Event (locationId);
create index IX_736ACD08 on rivetlogic_event_Event (uuid_);
create index IX_82CA4220 on rivetlogic_event_Event (uuid_, companyId);
create unique index IX_D83CD0A2 on rivetlogic_event_Event (uuid_, groupId);

create index IX_5CC6261B on rivetlogic_event_Location (groupId);

create index IX_17A3EC60 on rivetlogic_event_Participant (eventId);
create index IX_8B36D2EC on rivetlogic_event_Participant (eventId, email);
create index IX_B112358F on rivetlogic_event_Participant (uuid_);
create index IX_40A00F39 on rivetlogic_event_Participant (uuid_, companyId);
create unique index IX_AF250FFB on rivetlogic_event_Participant (uuid_, groupId);

create index IX_3B86B5BF on rivetlogic_event_Target (groupId);

create index IX_7E6C8EB3 on rivetlogic_event_Token (participantId);
create index IX_623B6089 on rivetlogic_event_Token (uuid_);

create index IX_C1EF4776 on rivetlogic_event_Type (groupId);