package de.jxson.craftingplus.core.recipe;

import java.util.HashMap;

public abstract class ShapeRecipe implements Recipe {

    public HashMap<Integer, RecipeItem> shapeMap = new HashMap<>();

    /**
     * Defines the shape of the craftable item
     * @return Hashmap with the given slots and items
     */
    public abstract HashMap<Integer, RecipeItem> shape();

    @Override
    public HashMap<Integer, RecipeItem> ingredients() {
        return Recipe.super.ingredients();
    }
}
