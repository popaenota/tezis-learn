-- begin CREDIT_CREDIT_TYPE
create table CREDIT_CREDIT_TYPE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(50),
    BANK_ID uuid,
    NAME varchar(255) not null,
    NOTE text,
    --
    primary key (ID)
)^
-- end CREDIT_CREDIT_TYPE
-- begin CREDIT_CREDIT
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
)^
-- end CREDIT_CREDIT
-- begin CREDIT_CREDIT_ORDER
create table CREDIT_CREDIT_ORDER (
    CARD_ID uuid,
    --
    CREDIT_ID uuid not null,
    BORROWER_ID uuid not null,
    --
    primary key (CARD_ID)
)^
-- end CREDIT_CREDIT_ORDER
