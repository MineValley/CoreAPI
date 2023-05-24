package minevalley.core.api.crafting;

import org.bukkit.inventory.ItemStack;

public interface RecipeItem {

    /**
     * Gets the item
     * @return ItemStack
     */
    ItemStack getItem();

    /**
     * Toggle if the items should match with the needed metadata
     * @return boolean
     */
    boolean ignoreMetadata();

}
