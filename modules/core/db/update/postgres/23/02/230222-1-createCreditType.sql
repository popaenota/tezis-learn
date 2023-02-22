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
);