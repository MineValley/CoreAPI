package minevalley.core.api.crafting.recipe;

import org.bukkit.inventory.ItemStack;

public interface RecipeItem {

    /**
     * Gets the item
     *
     * @return ItemStack of the RecipeItem
     */
    ItemStack getItem();

    /**
     * Check if the items needs to match the ItemMeta or ignore it
     *
     * @return boolean
     */
    boolean isIgnoringMetadata();

    /**
     * Get the amount of the craft component
     *
     * @return Amount of craft components needed
     */
    int getAmount();

}
