-- begin update procCardType for CreditOrder
update wf_proc set card_types = regexp_replace(card_types, ',credit\\$CreditOrder', '') where code in ('Endorsement', 'Resolution', 'Acquaintance', 'Registration')^
update wf_proc set updated_by='system', card_types = card_types || 'credit$CreditOrder,' where code in ('Endorsement', 'Resolution', 'Acquaintance', 'Registration')^
-- end update procCardType for CreditOrder
