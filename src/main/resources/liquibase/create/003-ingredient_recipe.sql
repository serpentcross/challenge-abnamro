CREATE TABLE IF NOT EXISTS ingredient_recipe (
    ingredient UUID NOT NULL CONSTRAINT "FK_ingredient_recipe_ingredient" REFERENCES ingredient,
    recipe     UUID NOT NULL CONSTRAINT "FK_ingredient_recipe_recipe" REFERENCES recipe
);

CREATE UNIQUE INDEX "IX_ingredient_recipe" ON ingredient_recipe (ingredient, recipe);