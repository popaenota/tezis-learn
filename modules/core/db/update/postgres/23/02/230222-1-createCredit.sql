create table CREDIT_CREDIT (
    CARD_ID uuid,
    --
    NUMBER_ varchar(50),
    GUARANTOR_ID uuid,
    CREDIT_TYPE_ID uuid,
    BANK_ID uuid,
    CREDIT_DATE date,
    SUM_ decimal(19, 2),
    --
    primary key (CARD_ID)
);