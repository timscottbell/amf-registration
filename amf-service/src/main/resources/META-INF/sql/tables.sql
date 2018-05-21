create table AMFEvent (
	amfEventId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createTime LONG,
	type_ INTEGER,
	ipAddress VARCHAR(75) null
);

create table AMF_AMFEvent (
	amfEventId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createTime LONG,
	type_ INTEGER,
	ipAddress VARCHAR(75) null
);