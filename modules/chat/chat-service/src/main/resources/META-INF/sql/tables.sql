create table dym_ChatConfigure (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	enable BOOLEAN,
	headerColor VARCHAR(75) null,
	chatRightColor VARCHAR(75) null,
	chatLeftColor VARCHAR(75) null,
	headerTextColor VARCHAR(75) null,
	contentTextColor VARCHAR(75) null,
	backColor VARCHAR(75) null,
	chatRoleId VARCHAR(75) null,
	fontFamily VARCHAR(75) null,
	requestFeature BOOLEAN
);

create table dym_ChatMessage (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	fromUser LONG,
	toUser LONG,
	sentDate DATE null,
	readDate DATE null,
	message VARCHAR(75) null,
	readed BOOLEAN,
	deleted BOOLEAN,
	fileName VARCHAR(75) null,
	fileId LONG
);

create table dym_ChatRequest (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	fromUserId LONG,
	toUserId LONG,
	isAccepted BOOLEAN,
	isRejected BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);