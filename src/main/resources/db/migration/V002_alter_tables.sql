ALTER TABLE db_dev_brothers_delivery.public.reset_code
    ADD CONSTRAINT unique_reset_code UNIQUE (reset_code);

ALTER TABLE db_dev_brothers_delivery.public.refresh_token
    ADD CONSTRAINT unique_reset_token UNIQUE (refresh_token);

ALTER TABLE db_dev_brothers_delivery.public.reset_code
    ADD COLUMN reset_code_active BOOLEAN NOT NULL DEFAULT FALSE;