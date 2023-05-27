package minevalley.core.api.crafting.recipe.builder;

import org.bukkit.inventory.ItemStack;

public interface RecipeItemBuilder {

    /**
     * Sets the Item
     *
     * @param item the craft component
     */
    RecipeItemBuilder setItem(ItemStack item);

    /**
     * Set if the craft component needs to match with the metadata from the inserted item (displayname, amount, meta)
     * Notice: If there is a specific amount of items needed: Please get the amount from the item above!
     *
     * @param ignoreMetadata boolean if meta is important
     */
    RecipeItemBuilder setIgnoreMetadata(boolean ignoreMetadata);

}
