-- begin CREDIT_CREDIT_TYPE
alter table CREDIT_CREDIT_TYPE add constraint FK_CREDIT_TYPE_ON_BANK foreign key (BANK_ID) references DF_BANK(ID)^
create index IDX_CREDIT_TYPE_ON_BANK on CREDIT_CREDIT_TYPE (BANK_ID)^
-- end CREDIT_CREDIT_TYPE
-- begin CREDIT_CREDIT
alter table CREDIT_CREDIT add constraint FK_CREDIT_CREDIT_ON_GUARANTOR foreign key (GUARANTOR_ID) references DF_CORRESPONDENT(ID)^
alter table CREDIT_CREDIT add constraint FK_CREDIT_CREDIT_ON_CREDIT_TYPE foreign key (CREDIT_TYPE_ID) references CREDIT_CREDIT_TYPE(ID)^
alter table CREDIT_CREDIT add constraint FK_CREDIT_CREDIT_ON_BANK foreign key (BANK_ID) references DF_BANK(ID)^
alter table CREDIT_CREDIT add constraint FK_CREDIT_CREDIT_ON_CARD foreign key (CARD_ID) references WF_CARD(ID) on delete CASCADE^
create index IDX_CREDIT_CREDIT_ON_GUARANTOR on CREDIT_CREDIT (GUARANTOR_ID)^
create index IDX_CREDIT_CREDIT_ON_CREDIT_TYPE on CREDIT_CREDIT (CREDIT_TYPE_ID)^
create index IDX_CREDIT_CREDIT_ON_BANK on CREDIT_CREDIT (BANK_ID)^
-- end CREDIT_CREDIT
-- begin CREDIT_CREDIT_ORDER
alter table CREDIT_CREDIT_ORDER add constraint FK_CREDIT_ORDER_ON_CREDIT foreign key (CREDIT_ID) references CREDIT_CREDIT(CARD_ID)^
alter table CREDIT_CREDIT_ORDER add constraint FK_CREDIT_ORDER_ON_BORROWER foreign key (BORROWER_ID) references DF_CORRESPONDENT(ID)^
alter table CREDIT_CREDIT_ORDER add constraint FK_CREDIT_ORDER_ON_CARD foreign key (CARD_ID) references WF_CARD(ID) on delete CASCADE^
create index IDX_CREDIT_ORDER_ON_CREDIT on CREDIT_CREDIT_ORDER (CREDIT_ID)^
create index IDX_CREDIT_ORDER_ON_BORROWER on CREDIT_CREDIT_ORDER (BORROWER_ID)^
-- end CREDIT_CREDIT_ORDER
