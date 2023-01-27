create index IX_C31DD47D on dym_ChatConfigure (groupId);
create index IX_A4653F81 on dym_ChatConfigure (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1989B243 on dym_ChatConfigure (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4145B0C8 on dym_ChatMessage (toUser);
create index IX_895F6662 on dym_ChatMessage (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B6F21D64 on dym_ChatMessage (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_BA09349B on dym_ChatRequest (isAccepted);
create index IX_6F52247E on dym_ChatRequest (uuid_[$COLUMN_LENGTH:75$]);