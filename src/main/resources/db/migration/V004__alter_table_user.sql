ALTER TABLE db_dev_brothers_delivery.public._user
    RENAME COLUMN  user_name TO user_first_name;

ALTER TABLE db_dev_brothers_delivery.public._user
    ADD COLUMN user_last_name varchar (100) not null;