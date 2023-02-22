-- begin insert cardType for Credit
insert into TS_CARD_TYPE (ID, CREATE_TS, CREATED_BY, NAME, DISCRIMINATOR, FIELDS_XML)
       values ('adbdf03d-fc74-4a52-88a8-890966c066eb', now(), 'system', 'credit$Credit', '2000', '<?xml version="1.0" encoding="UTF-8"?>
<fields>
  <field name="number" inDocKind="false" required="false" visible="true" signed="false" />
  <field name="creditType" inDocKind="false" required="false" visible="true" signed="false" />
  <field name="bank" inDocKind="false" required="false" visible="true" signed="false" />
  <field name="creditDate" inDocKind="false" required="false" visible="true" signed="false" />
  <field name="sum" inDocKind="false" required="false" visible="true" signed="false" />
</fields>
')^
-- end insert cardType for Credit
