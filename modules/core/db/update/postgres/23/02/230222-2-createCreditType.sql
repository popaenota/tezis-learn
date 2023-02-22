alter table CREDIT_CREDIT_TYPE add constraint FK_CREDIT_TYPE_ON_BANK foreign key (BANK_ID) references DF_BANK(ID);
create index IDX_CREDIT_TYPE_ON_BANK on CREDIT_CREDIT_TYPE (BANK_ID);
