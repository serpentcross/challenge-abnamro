INSERT INTO ingredient (id, vegetable, name) VALUES ('ab02d219-5b8f-43c5-970e-3373f904423b', FALSE, 'Noodles');

INSERT INTO ingredient (id, vegetable, name) VALUES ('7b2bd50f-95b2-4674-97ff-7cc9349b95d4', FALSE, 'Yogurt');
INSERT INTO ingredient (id, vegetable, name) VALUES ('0ef0f4cf-1d80-427f-9669-715f69f00456', TRUE, 'Salad');
INSERT INTO ingredient (id, vegetable, name) VALUES ('3b96e46f-7038-4ab8-b0e1-b4c54e917eef', TRUE, 'Carrot');
INSERT INTO ingredient (id, vegetable, name) VALUES ('afe5e38d-6401-4ad3-8145-e9c537ae2fef', FALSE, 'Chicken');
INSERT INTO ingredient (id, vegetable, name) VALUES ('fa441a3d-db5b-4ac4-bffc-4d7596e3438b', TRUE, 'Potato');

INSERT INTO recipe (id, vegetarian, serving_amount, name, instruction) VALUES ('41fede65-f268-4acd-b29c-295442dbbe03', FALSE, 4, 'Chicken Salad', 'Potato, Carrot, Cabbage');
INSERT INTO recipe (id, vegetarian, serving_amount, name, instruction) VALUES ('0bc71e70-4ffe-4d9f-876c-b01600b30a49', TRUE, 6, 'Potato Soup', 'Rice, Tomato, Salad');
INSERT INTO recipe (id, vegetarian, serving_amount, name, instruction) VALUES ('4059517e-f174-4165-8c3e-481d17bb5bcd', TRUE, 8, 'Spaghetti with carrots', 'Prepare cold spaghetti and cut carrot with salad.');
INSERT INTO recipe (id, vegetarian, serving_amount, name, instruction) VALUES ('27d71d6f-9643-47a4-8fc6-70808265b6cf', TRUE, 8, 'Vegie cutlets with carrots', 'Warm up the stove, prepare potato.');

INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ('afe5e38d-6401-4ad3-8145-e9c537ae2fef', '41fede65-f268-4acd-b29c-295442dbbe03');
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ('0ef0f4cf-1d80-427f-9669-715f69f00456', '41fede65-f268-4acd-b29c-295442dbbe03');
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ('fa441a3d-db5b-4ac4-bffc-4d7596e3438b', '0bc71e70-4ffe-4d9f-876c-b01600b30a49');
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ('0ef0f4cf-1d80-427f-9669-715f69f00456', '0bc71e70-4ffe-4d9f-876c-b01600b30a49');

INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ('3b96e46f-7038-4ab8-b0e1-b4c54e917eef', '27d71d6f-9643-47a4-8fc6-70808265b6cf');
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ('0ef0f4cf-1d80-427f-9669-715f69f00456', '27d71d6f-9643-47a4-8fc6-70808265b6cf');
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ('fa441a3d-db5b-4ac4-bffc-4d7596e3438b', '27d71d6f-9643-47a4-8fc6-70808265b6cf');

INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ('3b96e46f-7038-4ab8-b0e1-b4c54e917eef', '4059517e-f174-4165-8c3e-481d17bb5bcd');
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ('0ef0f4cf-1d80-427f-9669-715f69f00456', '4059517e-f174-4165-8c3e-481d17bb5bcd');
INSERT INTO ingredient_recipe (ingredient, recipe) VALUES ('ab02d219-5b8f-43c5-970e-3373f904423b', '4059517e-f174-4165-8c3e-481d17bb5bcd');