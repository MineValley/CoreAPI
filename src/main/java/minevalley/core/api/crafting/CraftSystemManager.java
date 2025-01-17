package minevalley.core.api.crafting;

import minevalley.core.api.crafting.recipe.Recipe;
import minevalley.core.api.crafting.recipe.builder.RecipeBuilder;
import minevalley.core.api.crafting.recipe.builder.RecipeItemBuilder;

@SuppressWarnings("unused")
public interface CraftSystemManager {

    /**
     * Register a recipe
     *
     * @param recipe to be registered
     */
    void registerRecipe(Recipe recipe);

    /**
     * Unregister a recipe
     *
     * @param recipe to be unregistered
     */
    void unregisterRecipe(Recipe recipe);

    /**
     * Create a new {@link RecipeBuilder} with the {@link RecipeBuilder} Builder
     *
     * @return {@link RecipeBuilder}
     */
    RecipeBuilder createRecipe();

    /**
     * Create a new {@link RecipeItemBuilder} with the {@link RecipeItemBuilder} Builder
     *
     * @return {@link RecipeItemBuilder}
     */
    RecipeItemBuilder createRecipeItem();

}
