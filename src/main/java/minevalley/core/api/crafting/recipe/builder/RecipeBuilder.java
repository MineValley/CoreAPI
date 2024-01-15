package minevalley.core.api.crafting.recipe.builder;

import minevalley.core.api.crafting.recipe.Recipe;
import minevalley.core.api.crafting.recipe.RecipeItem;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public interface RecipeBuilder {

    /**
     * Set the recipe name
     *
     * @return this
     */
    RecipeBuilder setRecipeName(String name);

    /**
     * Set the item that's gonna crafted
     *
     * @return this
     */
    RecipeBuilder setOutputItem(ItemStack output);

    /**
     * Set the ingredients which are needed for the recipe
     * If the recipe is marked as "setShapeless(true)" this list is used for <Slot, Item> detection
     *
     * @param ingredients List of ingredients
     * @return this
     */
    RecipeBuilder setIngredients(Map<Integer, RecipeItem> ingredients);

    /**
     * Add a new ingredient which is needed for the recipe
     * If the recipe is marked as "setShapeless(true)" this list is used for &lt;Slot, Item&gt; detection
     * When you are using a shapeless recipe just count the slot+1 everytime you add a new ingredient
     *
     * @param slot Slot of the item
     * @param item RecipeItem Object
     * @return this
     */
    RecipeBuilder addIngredient(int slot, RecipeItem item);

    /**
     * Defines if the recipe is a shapeless or shaped recipe
     *
     * @param shapeless If the recipe is shapeless or not
     * @return this
     */
    RecipeBuilder setShapeless(boolean shapeless);

    /**
     * Set the recipe power craft costs
     *
     * @param powerConsumption as integer.
     * @return this
     */
    RecipeBuilder setPowerConsumption(int powerConsumption);

    /**
     * Creates the new instance out of the builder components
     *
     * @return The recipe instance object
     */
    Recipe build();
}
