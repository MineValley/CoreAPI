package minevalley.core.api.crafting.recipe.builder;

import minevalley.core.api.crafting.recipe.Recipe;
import minevalley.core.api.crafting.recipe.RecipeItem;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public interface RecipeBuilder {

    /**
     * Set the recipe name
     *
     */
    RecipeBuilder setRecipeName(String name);

    /**
     * Set the item that's gonna crafted
     *
     */
    RecipeBuilder setOutputItem(ItemStack output);

    /**
     * Set the ingredients which are needed for the recipe
     * If the recipe is marked as "setShapeless(true)" this list is used for <Slot, Item> detection
     *
     * @param ingredients List of ingredients
     */
    RecipeBuilder setIngredients(Map<Integer, RecipeItem> ingredients);

    /**
     * Defines if the recipe is a shapeless or shaped recipe
     *
     * @param shapeless If the recipe is shapeless or not
     */
    RecipeBuilder setShapeless(boolean shapeless);

    /**
     * Set the recipe power craft costs
     *
     */
    RecipeBuilder setPowerConsumption(int powerConsumption);

    /**
     * Creates the new instance out of the builder components
     *
     * @return The recipe instance object
     */
    Recipe build();
}
