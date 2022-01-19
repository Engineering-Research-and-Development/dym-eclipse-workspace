create index IX_92B4D097 on COCREATION_Category (name[$COLUMN_LENGTH:75$]);

create index IX_852DE254 on COCREATION_Challenge (active_);
create index IX_ACF87B2F on COCREATION_Challenge (groupId, userId);
create index IX_DB3B4D13 on COCREATION_Challenge (title[$COLUMN_LENGTH:75$]);
create index IX_1819309 on COCREATION_Challenge (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_333547CB on COCREATION_Challenge (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_2BFF8565 on COCREATION_Cocreation (groupId);
create index IX_7ACF8683 on COCREATION_Cocreation (title[$COLUMN_LENGTH:75$]);
create index IX_B955E36B on COCREATION_Cocreation (userId, groupId);
create index IX_88F81399 on COCREATION_Cocreation (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1472AC5B on COCREATION_Cocreation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_DCAEB1AC on COCREATION_Cocreator (cocreationId);
create index IX_9E3F452C on COCREATION_Cocreator (userId);
create index IX_1CB66866 on COCREATION_Cocreator (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_969D068 on COCREATION_Cocreator (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_DCAF69BD on COCREATION_Hashtag (name[$COLUMN_LENGTH:75$]);

create index IX_5BEB0C4E on COCREATION_Location (name[$COLUMN_LENGTH:75$]);