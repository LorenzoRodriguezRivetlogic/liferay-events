create table rivetlogic_event_Event (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	calendarBookingId LONG,
	calendarId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	name VARCHAR(400) null,
	location STRING null,
	description STRING null,
	tags VARCHAR(75) null,
	eventDate DATE null,
	eventEndDate DATE null,
	privateEvent BOOLEAN,
	registrationRequired BOOLEAN,
	requiredFullName BOOLEAN,
	requiredPhone BOOLEAN,
	recurrent BOOLEAN,
	image BLOB,
	locationId LONG,
	targetId LONG,
	typeId LONG
);

create table rivetlogic_event_Location (
	locationId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	userId LONG,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table rivetlogic_event_Participant (
	uuid_ VARCHAR(75) null,
	participantId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	eventId LONG,
	fullName VARCHAR(75) null,
	email VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	companyName VARCHAR(75) null,
	status INTEGER
);

create table rivetlogic_event_Target (
	targetId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table rivetlogic_event_Token (
	uuid_ VARCHAR(75) null,
	tokenId LONG not null primary key,
	participantId LONG,
	expiredDate DATE null
);

create table rivetlogic_event_Type (
	typeId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);