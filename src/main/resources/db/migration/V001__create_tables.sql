create table _user (
    user_id serial not null primary key,
    user_name varchar(100) not null ,
    user_email varchar(100) not null ,
    user_password varchar(50) not null ,
    user_phone varchar(15) not null ,
    user_cpf varchar(30)
);

create table card (
    card_id serial not null primary key ,
    card_number integer not null ,
    card_cvv varchar(3) not null ,
    card_expiration timestamp not null,
    user_id integer not null ,
    foreign key (user_id) references _user
);

create table address (
    address_id serial not null primary key ,
    address_city varchar(40) not null ,
    address_state varchar(20) not null ,
    address_street varchar(255) not null,
    address_complement varchar(255) not null ,
    address_number integer not null,
    user_id integer not null ,
    foreign key (user_id) references _user
);

create table role (
    role_id serial not null primary key ,
    role_name varchar(20) not null
);

create table user_roles (
    user_id integer not null,
    role_id integer not null,
    foreign key (role_id) references role,
    foreign key (user_id) references _user,
    primary key (user_id, role_id)
);

create table refresh_token (
    refresh_token_id integer not null PRIMARY KEY ,
    refresh_token varchar(200) not null,
    refresh_token_expiry_at timestamp not null ,
    user_id integer not null ,
    foreign key (user_id) references _user
);

create table reset_Code (
    reset_code_id integer not null ,
    reset_code integer not null ,
    reset_code_expiry_at timestamp not null ,
    user_id integer not null ,
    foreign key (user_id) references _user
);


create table category (
     category_id serial not null primary key ,
     category_name varchar(50) not null ,
     category_description varchar(255)
);

create table product (
        product_id serial not null primary key ,
        Product_name varchar(50) not null ,
        product_description varchar(255) not null ,
        product_price double precision not null
);

create table product_category (
         product_id integer not null ,
         category_id integer not null ,
         foreign key (product_id) references category(category_id),
         foreign key (category_id) references product(product_id),
         primary key (product_id, category_id)
);

create table segment (
        segment_id serial not null primary key ,
        segment_name varchar(50) not null ,
        segment_description varchar(255)
);

create table store (
        store_id serial not null primary key ,
        store_name varchar(50) not null ,
        store_description varchar(255),
        segment_id integer,
        store_assessment integer,
        store_delivery_start timestamp not null ,
        store_delivery_end timestamp not null ,
        foreign key (segment_id) references segment(segment_id)
);

create table product_store(
          store_id integer not null ,
          product_id integer not null ,
          foreign key (store_id) references store(store_id),
          foreign key (product_id) references product(product_id),
          primary key (store_id, product_id)
);

create table _order (
        order_id serial not null primary key,
        order_address_id Bigint not null,
        order_user_id Bigint not null,
        order_status varchar(20) not null,
        store_id Bigint not null,
        foreign key (store_id) references store
);

create table delivery (
      delivery_id serial not null primary key,
      delivery_start timestamp not null,
      delivery_end timestamp not null,
      order_id integer not null ,
      foreign key (order_id) references _order
);

create table occurrences (
        occurrence_id serial not null primary key,
        occurrence_description varchar(255) not null,
        occurrence_date timestamp not null,
        delivery_id Bigint not null ,
        foreign key (delivery_id) references delivery
);

create table payment (
            payment_id serial not null primary key,
            payment_amount double precision not null,
            order_id Bigint not null,
            foreign key (order_id) references _order
);

create table order_items (
            order_id serial not null ,
            product_id serial not null ,
            quantity Bigint not null,
            foreign key (order_id) references _order,
            foreign key (product_id) references product,
            primary key (order_id, product_id)
);

create table favorites (
          user_id serial not null ,
          store_id serial not null,
          foreign key (user_id) references _user,
          foreign key (store_id) references store,
          primary key (user_id, store_id)
);
