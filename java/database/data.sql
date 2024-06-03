BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO topping_tiers (topping_tier, tier_description, tier_price_modifier)
VALUES (0, 'Essentials', 0), (1, 'Need to haves', 1.25), (2, 'Premium', 2.25);

INSERT INTO toppings (topping, topping_tier)
VALUES ('Pepperoni', 1), ('Basil', 1), ('Italian Sausage', 2), ('Mushrooms', 0), ('Onions', 0), ('Green Peppers', 0),
('Black Olives', 0), ('Green Olives', 0), ('Tomato slices', 1), ('Jalapenos', 1), ('Bacon', 2),
('House Cheese Blend', 0), ('Fresh Mozzarella cheese', 2), ('BBQ chicken', 2);

INSERT INTO pizza_sizes (pizza_size, pizza_base_price) VALUES ('Small', 6.75), ('Medium', 9.75), ('Large', 12.25);

INSERT INTO crusts (crust_type, type_price_modifier) VALUES ('Regular', 0), ('Deep Dish', 4), ('Thin', 0), ('Cauliflower', 3.5);

INSERT INTO specialty_pizzas  (pizza_name, pizza_size, crust_type) VALUES ('Margarita', 'Medium', 'Regular'),
('Pepperoni', 'Large', 'Regular'), ('Supreme', 'Large', 'Thin'), ('Create your Own', 'Large', 'Regular');

INSERT INTO specialty_toppings (pizza_id, topping) VALUES (1, 'Basil'), (1, 'Tomato slices'), (2, 'Pepperoni'),
(3, 'Green Peppers'), (3, 'Black Olives'), 	(3, 'Bacon'), (3, 'Mushrooms'), (3, 'Italian Sausage'), (3, 'Onions'),
(1, 'House Cheese Blend'), (2, 'House Cheese Blend'), (3, 'House Cheese Blend'), (4, 'House Cheese Blend');

INSERT INTO orders (order_total, order_status, order_type, delivery_address) 
VALUES (12.25, 'Received', 'Pick-up', 'In-Store');


COMMIT TRANSACTION;
