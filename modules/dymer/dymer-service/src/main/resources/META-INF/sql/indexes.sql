create index IX_F432316C on DYM_Dymer (groupId, status);
create index IX_777FEF8A on DYM_Dymer (status);
create index IX_2FE2B598 on DYM_Dymer (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_8D4BC21A on DYM_Dymer (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F2ADA9E0 on DYM_DymerEntry (groupId, dymerId);
create index IX_1E1B356 on DYM_DymerEntry (groupId, status);
create index IX_A0E8441A on DYM_DymerEntry (index_[$COLUMN_LENGTH:75$], type_[$COLUMN_LENGTH:75$], id_[$COLUMN_LENGTH:75$]);
create index IX_BBBCBE60 on DYM_DymerEntry (status);
create index IX_D82370EE on DYM_DymerEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D80F5AF0 on DYM_DymerEntry (uuid_[$COLUMN_LENGTH:75$], groupId);