INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Chicken'), (SELECT id FROM recipe WHERE name LIKE 'Caesar Salad'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Cabbage'), (SELECT id FROM recipe WHERE name LIKE 'Caesar Salad'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Salad'), (SELECT id FROM recipe WHERE name LIKE 'Caesar Salad'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Cheese'), (SELECT id FROM recipe WHERE name LIKE 'Caesar Salad'));

INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Beef'), (SELECT id FROM recipe WHERE name = 'Meatballs Spaghetti'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Noodles'), (SELECT id FROM recipe WHERE name = 'Meatballs Spaghetti'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Tomato'), (SELECT id FROM recipe WHERE name = 'Meatballs Spaghetti'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Cheese'), (SELECT id FROM recipe WHERE name = 'Meatballs Spaghetti'));

INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Pork'), (SELECT id FROM recipe WHERE name = 'Eggs with bacon'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Egg'), (SELECT id FROM recipe WHERE name = 'Eggs with bacon'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Cheese'), (SELECT id FROM recipe WHERE name = 'Eggs with bacon'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Mushrooms'), (SELECT id FROM recipe WHERE name = 'Eggs with bacon'));

INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Carrot'), (SELECT id FROM recipe WHERE name = 'Vitamin salad'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Potato'), (SELECT id FROM recipe WHERE name = 'Vitamin salad'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Tomato'), (SELECT id FROM recipe WHERE name = 'Vitamin salad'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Cabbage'), (SELECT id FROM recipe WHERE name = 'Vitamin salad'));

INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Potato'), (SELECT id FROM recipe WHERE name = 'Boiled potato'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Carrot'), (SELECT id FROM recipe WHERE name = 'Boiled potato'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Cabbage'), (SELECT id FROM recipe WHERE name = 'Boiled potato'));

INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Rice'), (SELECT id FROM recipe WHERE name = 'Fried rice'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Tomato'), (SELECT id FROM recipe WHERE name = 'Fried rice'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Salad'), (SELECT id FROM recipe WHERE name = 'Fried rice'));

INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Tomato'), (SELECT id FROM recipe WHERE name = 'Vegetarian cutlets'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Cabbage'), (SELECT id FROM recipe WHERE name = 'Vegetarian cutlets'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Nuts'), (SELECT id FROM recipe WHERE name = 'Vegetarian cutlets'));

INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Potato'), (SELECT id FROM recipe WHERE name = 'Grilled salmon'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Salmon'), (SELECT id FROM recipe WHERE name = 'Grilled salmon'));
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ((SELECT id FROM ingredient WHERE name = 'Tomato'), (SELECT id FROM recipe WHERE name = 'Grilled salmon'));