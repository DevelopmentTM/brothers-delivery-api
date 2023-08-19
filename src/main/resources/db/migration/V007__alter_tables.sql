CREATE SEQUENCE db_dev_brothers_delivery.public.refresh_token_refresh_token_seq;

ALTER TABLE db_dev_brothers_delivery.public.refresh_token
    ALTER COLUMN refresh_token_id SET DEFAULT nextval('refresh_token_refresh_token_seq');


CREATE SEQUENCE db_dev_brothers_delivery.public.reset_code_reset_code_seq;

ALTER TABLE db_dev_brothers_delivery.public.reset_code
    ALTER COLUMN reset_code_id SET DEFAULT nextval('reset_code_reset_code_seq');

ALTER TABLE db_dev_brothers_delivery.public.reset_code
    ADD CONSTRAINT reset_code_pkey PRIMARY KEY (reset_code_id);