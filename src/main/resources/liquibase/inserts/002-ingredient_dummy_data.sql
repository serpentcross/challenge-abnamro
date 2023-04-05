
-- FOR H2

-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), FALSE, 'Chicken');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), FALSE, 'Beef');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), FALSE, 'Salmon');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), FALSE, 'Tuna');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), FALSE, 'Pork');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), FALSE, 'Egg');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), FALSE, 'Cheese');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), FALSE, 'Noodles');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), TRUE, 'Mushrooms');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), TRUE, 'Potato');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), TRUE, 'Tomato');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), TRUE, 'Carrot');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), TRUE, 'Nuts');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), TRUE, 'Salad');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), TRUE, 'Cabbage');
-- INSERT INTO ingredient (id, vegetable, name) VALUES (RANDOM_UUID(), TRUE, 'Rice');

-- FOR POSTGRES

INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), FALSE, 'Chicken');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), FALSE, 'Beef');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), FALSE, 'Salmon');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), FALSE, 'Tuna');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), FALSE, 'Pork');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), FALSE, 'Egg');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), FALSE, 'Cheese');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), FALSE, 'Noodles');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), TRUE, 'Mushrooms');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), TRUE, 'Potato');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), TRUE, 'Tomato');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), TRUE, 'Carrot');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), TRUE, 'Nuts');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), TRUE, 'Salad');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), TRUE, 'Cabbage');
INSERT INTO ingredient (id, vegetable, name) VALUES (uuid_generate_v4(), TRUE, 'Rice');