CREATE TABLE customer
(
    customer_id     bigserial  NOT NULL,
    customer_name   varchar(300) NOT NULL,
    customer_addres varchar(300) NOT NULL,
    customer_dui  	varchar(30) NOT NULL,
    customer_number varchar(20) NOT NULL,
    CONSTRAINT pk_customer PRIMARY KEY ( customer_id )
);



CREATE TABLE product
(
    product_id          bigint NOT NULL,
	product_title       varchar(200) NULL,
    product_price       double precision NOT NULL,
	product_description varchar(500),
    product_category    varchar(200),
    product_image       varchar(300),
    CONSTRAINT pk_product PRIMARY KEY ( product_id )
);




CREATE TABLE customer_order
(
    customer_order_id    bigserial NOT NULL,
	customer_order_date  date NULL,
    customer_order_price double precision NOT NULL,
	customer_id          bigint NOT NULL,

    CONSTRAINT pk_customer_order PRIMARY KEY ( customer_order_id ),
    CONSTRAINT fk_customer_orders FOREIGN KEY ( customer_id ) REFERENCES customer ( customer_id ) ON DELETE NO ACTION
);


CREATE TABLE order_detail
(
    order_detail_id         bigserial NOT NULL,
    order_detail_quantity   int not null,
	product_id              bigint NOT NULL,
	customer_order_id       bigint NOT NULL,


    CONSTRAINT pk_order_detail PRIMARY KEY ( order_detail_id ),
    CONSTRAINT fk_order_detail_product FOREIGN KEY ( product_id ) REFERENCES product ( product_id ) ON DELETE NO ACTION,
    CONSTRAINT fk_order_detail_customer_order FOREIGN KEY ( customer_order_id ) REFERENCES customer_order ( customer_order_id ) ON DELETE NO ACTION

);






