create table DYM_Dymer (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	dymerId LONG not null primary key,
	name VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table DYM_DymerEntry (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	entryId LONG not null primary key,
	index_ VARCHAR(75) null,
	type_ VARCHAR(75) null,
	id_ VARCHAR(75) null,
	title VARCHAR(255) null,
	extContent TEXT null,
	url VARCHAR(75) null,
	dymerId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);