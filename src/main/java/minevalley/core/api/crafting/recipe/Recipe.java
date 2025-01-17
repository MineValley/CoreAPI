package minevalley.core.api.crafting.recipe;

import org.bukkit.inventory.ItemStack;

import java.util.Map;

@SuppressWarnings("unused")
public interface Recipe {

    /**
     * Gets the recipe name
     *
     * @return Recipe name
     */
    String getRecipeName();

    /**
     * Get the output Item
     *
     * @return Output ItemStack
     */
    ItemStack getOutputItem();

    /**
     * Get the needed recipe ingredients
     * If the recipe is marked as "setShapeless(true)" this list is used for &lt;Slot, Item&gt; detection
     *
     * @return Map with ingredients and slots
     */
    Map<Integer, RecipeItem> getRecipeIngredients();

    /**
     * Checks if the recipe is shapeless
     *
     * @return if recipe is shapeless or shaped
     */
    boolean isShapeless();

    /**
     * Checks how many power levels the craft process needs
     *
     * @return Craft costs level
     */
    int getCraftPowerConsumption();

}
