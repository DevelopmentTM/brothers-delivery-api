create table _User (
    userId serial not null primary key,
    userName varchar(100) not null ,
    userEmail varchar(100) not null ,
    userPassword varchar(50) not null ,
    userPhone varchar(15) not null ,
    userCpf varchar(30)
);

create table Card (
    cardId serial not null primary key ,
    cardNumber integer not null ,
    cardCvv varchar(3) not null ,
    cardExpiration timestamp not null,
    userId integer not null ,
    foreign key (userId) references _User
);

create table Address (
    addressId serial not null primary key ,
    addressCity varchar(40) not null ,
    addressState varchar(20) not null ,
    addressStreet varchar(255) not null,
    addressComplement varchar(255) not null ,
    addressNumber integer not null,
    userId integer not null ,
    foreign key (userId) references _User
);

create table Role (
    roleId serial not null primary key ,
    roleName varchar(20) not null
);

create table user_roles (
    userId integer not null,
    roleId integer not null,
    foreign key (roleId) references Role,
    foreign key (userId) references _User,
    primary key (userId, roleId)
);

create table Refresh_Token (
    refreshTokenId integer not null PRIMARY KEY ,
    refreshToken varchar(200) not null,
    refreshTokenExpiryAt timestamp not null ,
    userId integer not null ,
    foreign key (userId) references _User
);

create table Reset_Code (
    resetCodeId integer not null ,
    resetCode integer not null ,
    resetCodeExpiryAt timestamp not null ,
    userId integer not null ,
    foreign key (userId) references _User
);

create table Category (
     categoryId serial not null primary key ,
     categoryName varchar(50) not null ,
     categoryDescription varchar(255)
);

create table Product (
        productId serial not null primary key ,
        ProductName varchar(50) not null ,
        productDescription varchar(255) not null ,
        productPrice double precision not null
);

create table product_category (
         productId integer not null ,
         categoryId integer not null ,
         foreign key (productId) references Category(categoryId),
         foreign key (categoryId) references Product(productId),
         primary key (productId, categoryId)
);

create table Segment (
        segmentId serial not null primary key ,
        segmentName varchar(50) not null ,
        segmentDescription varchar(255)
);

create table Store (
      storeId serial not null primary key ,
      storeName varchar(50) not null ,
      storeDescription varchar(255),
     segmentId integer,
     assessment integer,
     storeDeliveryStar timestamp not null ,
     storeDeliveryEnd timestamp not null ,
     foreign key (segmentId) references Segment(segmentId)
);

create table product_store(
          storeId integer not null ,
          productId integer not null ,
          foreign key (storeId) references Store(storeId),
          foreign key (productId) references Product(productId),
          primary key (storeId, productId)
);

create table _Order (
        orderId serial not null primary key,
        orderAddressId Bigint not null,
        order_UserId Bigint not null,
        orderStatus varchar(20) not null,
        storeId Bigint not null,
        foreign key (storeId) references Store
);

create table Delivery (
      deliveryId serial not null primary key,
      deliveryStart timestamp not null,
      deliveryEnd timestamp not null,
      orderId integer not null ,
      foreign key (orderId) references _Order
);

create table Occurrences (
        occurrenceId serial not null primary key,
        occurrenceDescription varchar(255) not null,
        occurrenceDate timestamp not null,
        deliveryId Bigint not null ,
        foreign key (deliveryId) references Delivery
);

create table Payment (
            paymentId serial not null primary key,
            paymentAmount double precision not null,
            orderId Bigint not null,
            foreign key (orderId) references _Order
);

create table order_items (
            orderId serial not null ,
            productId serial not null ,
            quantity Bigint not null,
            foreign key (orderId) references _Order,
            foreign key (productId) references Product,
            primary key (orderId, productId)
);

create table Favorites (
          userId serial not null ,
          storeId serial not null,
          foreign key (userId) references _User,
          foreign key (storeId) references Store,
          primary key (userId, storeId)
);
