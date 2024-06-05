BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS topping_tiers;
DROP TABLE IF EXISTS toppings;
DROP TABLE IF EXISTS pizza_sizes;
DROP TABLE IF EXISTS crusts;
DROP TABLE IF EXISTS specialty_pizzas;
DROP TABLE IF EXISTS specialty_toppings;
DROP TABLE IF EXISTS orders;
DROP TYPE IF EXISTS order_status_t;
DROP TYPE IF EXISTS order_type_t;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE topping_tiers (
	topping_tier int NOT NULL UNIQUE DEFAULT 0,
	tier_description varchar(50),
	tier_price_modifier NUMERIC(5, 2),
	CONSTRAINT PK_topping_tier PRIMARY KEY (topping_tier)
);
CREATE TYPE topping_type_t AS ENUM ('Cheese', 'Meat', 'Veggie', 'Crust', 'Sauce', 'Size');
CREATE TABLE toppings (
	topping varchar(50) NOT NULL UNIQUE,
	topping_tier int NOT NULL DEFAULT 0,
	topping_available BOOL DEFAULT TRUE,
	topping_type topping_type_t,
	topping_description varchar(100),
	CONSTRAINT PK_topping PRIMARY KEY (topping),	
	CONSTRAINT FK_topping_tier FOREIGN KEY (topping_tier) REFERENCES topping_tiers (topping_tier)
);
CREATE TABLE pizza_sizes (
	pizza_size varchar(50),
	pizza_base_price NUMERIC(6, 2),
	CONSTRAINT PK_pizza_size PRIMARY KEY (pizza_size)
);
CREATE TABLE crusts (
	crust_type varchar(50) NOT NULL UNIQUE DEFAULT 'Regular',
	type_price_modifier NUMERIC(3, 2),
	crust_description varchar(100) DEFAULT '',
	CONSTRAINT PK_crust_type PRIMARY KEY (crust_type)
);
CREATE TABLE specialty_pizzas (
	pizza_id SERIAL,
	pizza_name varchar(50) NOT NULL,
	pizza_size varchar(50),
	crust_type varchar(50),
	sauce_type varchar(50) DEFAULT 'Tomato',
	pizza_available BOOL DEFAULT TRUE,
	pizza_type varchar(50) DEFAULT 'Pizza',
	CONSTRAINT PK_pizza_id PRIMARY KEY (pizza_id)	
);

CREATE TABLE side_items (
    side_items SERIAL PRIMARY KEY,
    side_item_name varchar(50),
    side_item_price NUMERIC(6, 2),
    side_item_type varchar(50) DEFAULT 'Side'
);
ALTER SEQUENCE side_items_side_items_seq RESTART WITH 400;

--CREATE TABLE aggregate_items(
--    unnecessary_id SERIAL PRIMARY KEY,
--    combined_item_id int,
--    generic_item_type varchar(50)
----    CONSTRAINT PK_aggregate_items PRIMARY KEY (combined_item_id, generic_item_type)
--);
CREATE TABLE specialty_toppings (
	pizza_id int,
	topping varchar(50),
	CONSTRAINT PK_pizza_defaults PRIMARY KEY (pizza_id, topping),
	CONSTRAINT FK_pizza_id FOREIGN KEY(pizza_id) REFERENCES specialty_pizzas (pizza_id),
	CONSTRAINT FK_pizza_topping FOREIGN KEY(topping) REFERENCES toppings (topping)
);

CREATE TYPE order_type_t AS ENUM ('Pick-up', 'Delivery');
CREATE TYPE order_status_t AS ENUM ('Received', 'Ready', 'Out for Delivery', 'Completed', 'Canceled');
CREATE TABLE orders (
	order_id SERIAL,
	order_total NUMERIC(6, 2),
	order_status order_status_t DEFAULT 'Received',
	order_type order_type_t DEFAULT 'Pick-up',
	delivery_address varchar(50) DEFAULT 'In-store',
	CONSTRAINT PK_order_id PRIMARY KEY (order_id)
);
--
CREATE TABLE order_items(
    unique_item_id SERIAL,
    order_id int REFERENCES orders (order_id),
    item_id int,
--REFERENCES aggregate_items (combined_item_id),
    CONSTRAINT PK_item_id PRIMARY KEY (unique_item_id)
);

CREATE TABLE order_item_options(
    item_id int,
    item_option varchar(50)
);

COMMIT TRANSACTION;
