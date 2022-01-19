create table COCREATION_Activity (
	mvccVersion LONG default 0 not null,
	activityId LONG not null primary key,
	description VARCHAR(75) null,
	cocreationId LONG
);

create table COCREATION_Category (
	mvccVersion LONG default 0 not null,
	categoryId LONG not null primary key,
	challengeId LONG,
	name VARCHAR(75) null,
	assetCategoryId LONG
);

create table COCREATION_Challenge (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	challengeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description TEXT null,
	startDate DATE null,
	endDate DATE null,
	dlFolderName VARCHAR(75) null,
	dlFolderId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	active_ BOOLEAN
);

create table COCREATION_Cocreation (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	cocreationId LONG not null primary key,
	challengeId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description TEXT null,
	dlFolderName VARCHAR(75) null,
	ldFolderId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table COCREATION_Cocreator (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	cocreatorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	cocreationId LONG
);

create table COCREATION_Hashtag (
	mvccVersion LONG default 0 not null,
	hashtagId LONG not null primary key,
	challengeId LONG,
	name VARCHAR(75) null,
	assetTagId LONG
);

create table COCREATION_Location (
	mvccVersion LONG default 0 not null,
	locatoinId LONG not null primary key,
	challengeId LONG,
	name VARCHAR(75) null,
	latitude VARCHAR(75) null,
	longitude VARCHAR(75) null
);

create table COCREATION_Question (
	mvccVersion LONG default 0 not null,
	questionId LONG not null primary key,
	description VARCHAR(75) null,
	cocreationId LONG
);

create table COCREATION_Task (
	mvccVersion LONG default 0 not null,
	taskId LONG not null primary key,
	description VARCHAR(75) null,
	cocreationId LONG
);