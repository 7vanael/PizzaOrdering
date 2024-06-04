BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO topping_tiers (topping_tier, tier_description, tier_price_modifier)
VALUES (0, 'Essentials', 0), (1, 'Need to haves', 1.25), (2, 'Premium', 2.25);


INSERT INTO toppings (topping, topping_tier, topping_type)
VALUES ('Pepperoni', 1, 'Meat'), ('Basil', 1, 'Veggie'), ('Italian Sausage', 2, 'Meat'), ('Mushrooms', 0, 'Veggie'),
 ('Onions', 0, 'Veggie'), ('Green Peppers', 0, 'Veggie'), ('Black Olives', 0, 'Veggie'), ('Green Olives', 0, 'Veggie'),
 ('Tomato slices', 1, 'Veggie'), ('Jalapenos', 1, 'Veggie'), ('Bacon', 2, 'Meat'), ('House Cheese Blend', 0, 'Cheese'),
 ('Fresh Mozzarella cheese', 2, 'Cheese'), ('BBQ chicken', 2, 'Meat'), ('Regular', 0, 'Crust'), ('Deep Dish', 0, 'Crust'),
 ('Thin', 0, 'Crust'), ('Cauliflower', 0, 'Crust'), ('Tomato', 0, 'Sauce'), ('Pesto', 0, 'Sauce'), ('Pineapple', 2, 'Veggie'),
 ('Alfredo', 0, 'Sauce'), ('BBQ', 0, 'Sauce'), ('Small', 0, 'Size'), ('Medium', 0, 'Size'), ('Large', 0, 'Size'),
 ('Banana Pepper', 1, 'Veggie');

INSERT INTO pizza_sizes (pizza_size, pizza_base_price) VALUES ('Small', 6.75), ('Medium', 9.75), ('Large', 12.25);

INSERT INTO crusts (crust_type, type_price_modifier) VALUES ('Regular', 0), ('Deep Dish', 4), ('Thin', 0), ('Cauliflower', 3.5);

INSERT INTO specialty_pizzas  (pizza_name, pizza_size, crust_type) VALUES ('Margarita', 'Large', 'Regular'),
('Pepperoni', 'Large', 'Regular'), ('Supreme', 'Large', 'Regular'), ('Create Your Own', 'Large', 'Regular');

INSERT INTO specialty_toppings (pizza_id, topping) VALUES (1, 'Basil'), (1, 'Tomato slices'), (2, 'Pepperoni'),
(3, 'Green Peppers'), (3, 'Black Olives'), 	(3, 'Bacon'), (3, 'Mushrooms'), (3, 'Italian Sausage'), (3, 'Onions'),
(1, 'House Cheese Blend'), (2, 'House Cheese Blend'), (3, 'House Cheese Blend'), (4, 'House Cheese Blend');

INSERT INTO orders (order_total, order_status, order_type, delivery_address) 
VALUES (12.25, 'Received', 'Pick-up', 'In-Store');

--INSERT INTO aggregate_items SELECT pizza_id, pizza_type FROM specialty_pizzas;
--INSERT INTO aggregate_items SELECT side_items, side_item_type FROM side_items;


COMMIT TRANSACTION;
