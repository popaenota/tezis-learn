create table CREDIT_CREDIT_ORDER (
    CARD_ID uuid,
    --
    CREDIT_ID uuid not null,
    BORROWER_ID uuid not null,
    --
    primary key (CARD_ID)
);