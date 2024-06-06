BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO topping_tiers (topping_tier, tier_description, tier_price_modifier)
VALUES (0, 'Essentials', 0), (1, 'Need to haves', 1.25), (2, 'Premium', 2.25);


INSERT INTO toppings (topping, topping_tier, topping_type, topping_description)
VALUES ('Pepperoni', 1, 'Meat', ''), ('Basil', 1, 'Veggie', ''), ('Italian Sausage', 2, 'Meat', ''), ('Mushrooms', 0, 'Veggie', ''),
 ('Onions', 0, 'Veggie', ''), ('Green Peppers', 0, 'Veggie', ''), ('Black Olives', 0, 'Veggie', ''), ('Green Olives', 0, 'Veggie', ''),
 ('Tomato slices', 1, 'Veggie', ''), ('Jalapenos', 1, 'Veggie', ''), ('Bacon', 2, 'Meat', ''), ('House Cheese Blend', 0, 'Cheese', ''),
 ('Fresh Mozzarella cheese', 2, 'Cheese', ''), ('BBQ chicken', 2, 'Meat', ''), ('Regular', 0, 'Crust', 'Garlic seasoned crust with a rich, buttery taste'),
 ('Deep Dish', 0, 'Crust', 'Chicago-style deep dish crust with a buttery, flaky exterior'),
 ('Thin', 0, 'Crust', 'Thin enough for optimum crispy to crunchy ratio'), ('Cauliflower', 0, 'Crust', 'Gluten-free cauliflower crust with a buttery flaky exterior'),
 ('Tomato', 0, 'Sauce', ''), ('Pesto', 0, 'Sauce', ''), ('Pineapple', 2, 'Veggie', ''),
 ('Alfredo', 0, 'Sauce', ''), ('BBQ', 0, 'Sauce', ''), ('Small', 0, 'Size', ''), ('Medium', 0, 'Size', ''), ('Large', 0, 'Size', ''),
 ('Banana Peppers', 1, 'Veggie', ''), ('Olive Oil Drizzle', 0, 'Veggie',''), ('Garlic', 0, 'Veggie', '');

 INSERT INTO toppings (topping, topping_tier, topping_type, topping_available)
 VALUES ('Goat cheese', 0, 'Cheese', FALSE);

INSERT INTO pizza_sizes (pizza_size, pizza_base_price) VALUES ('Small', 6.75), ('Medium', 9.75), ('Large', 12.25);

INSERT INTO crusts (crust_type, type_price_modifier, crust_description) VALUES ('Regular', 0, 'Garlic seasoned crust with a rich, buttery taste'),
('Deep Dish', 4, 'Chicago-style deep dish crust with a buttery, flaky exterior'), ('Thin', 0, 'Thin enough for optimum crispy to crunchy ratio'),
 ('Cauliflower', 3.5, 'Gluten-free cauliflower crust with a buttery flaky exterior');

INSERT INTO specialty_pizzas  (pizza_name, pizza_size, crust_type, pizza_description) VALUES
('Margarita', 'Large', 'Regular', 'Fresh Mozzarella, fresh basil, fresh tomato slices.. The cutting edge in classic Pizza-ing'),
('Pepperoni', 'Large', 'Regular', 'If there is no pepperoni, then it might as well be flat bread!'),
('Supreme', 'Large', 'Regular', 'The works! It has it all! Maybe even too much. Customize to your delight!'),
('The Polymorph', 'Large', 'Regular', 'Design your pizza YOUR way!'),
('The Constructor', 'Large', 'Regular', 'A Classic cheese pizza. Add some Jalapenos to spicy up your night!'),
('The Back-End', 'Large', 'Regular', 'BBQ sauce, BBQ chicken, onions, and tons of cheese'),
('The Front-End', 'Large', 'Regular', 'Sliced tomatoes, mozzarella cheese, garlic, fresh basil, and extra-virgin olive oil'),
('The Debugger', 'Large', 'Regular', 'Pesto sauce with shredded mozzarella cheese and topped with fresh green peppers, black olives, onions, mushrooms, and fresh basil leaves'),
('The Framework', 'Large', 'Regular', 'Served with crumbled Italian sausage, bacon, and pepperoni'),
('The Full-Stack', 'Large', 'Regular', 'Delicious pepperoni, sausage, onions, banana peppers, mushrooms, and olives');

INSERT INTO specialty_toppings (pizza_id, topping) VALUES
(1, 'Basil'), (1, 'Tomato slices'), (1, 'Fresh Mozzarella cheese'),
(2, 'Pepperoni'), (2, 'House Cheese Blend'),
(3, 'Green Peppers'), (3, 'Black Olives'), 	(3, 'Bacon'), (3, 'Mushrooms'), (3, 'Italian Sausage'), (3, 'Onions'), (3, 'House Cheese Blend'),  (3, 'Olive Oil Drizzle'), (3, 'Garlic'),
(4, 'House Cheese Blend'),
(5, 'House Cheese Blend'),(5, 'BBQ chicken'),(5, 'BBQ'), (5, 'Onions'),
(6, 'Fresh Mozzarella cheese'), (6, 'Basil'), (6, 'Olive Oil Drizzle'), (6, 'Garlic'),
(7, 'Fresh Mozzarella cheese'), (7, 'Pesto'), (7, 'Green Peppers'), (7, 'Black Olives'), (7, 'Onions'), (7, 'Mushrooms'), (7, 'Basil'),
(8, 'House Cheese Blend'), (8, 'Italian Sausage'), (8, 'Bacon'), (8, 'Pepperoni'),
(9, 'House Cheese Blend'), (9, 'Pepperoni'), (9, 'Italian Sausage'), (9, 'Onions'), (9, 'Mushrooms'), (9, 'Green Olives'), (9, 'Banana Peppers')
;

INSERT INTO orders (order_total, order_status, order_type)
VALUES (12.25, 'Received', 'Pick-up');

--INSERT INTO aggregate_items SELECT pizza_id, pizza_type FROM specialty_pizzas;
--INSERT INTO aggregate_items SELECT side_items, side_item_type FROM side_items;


COMMIT TRANSACTION;
