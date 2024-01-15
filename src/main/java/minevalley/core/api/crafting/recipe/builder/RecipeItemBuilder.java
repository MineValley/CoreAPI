package minevalley.core.api.crafting.recipe.builder;

import minevalley.core.api.crafting.recipe.RecipeItem;
import minevalley.core.api.crafting.recipe.requirements.Requirement;
import org.bukkit.inventory.ItemStack;

public interface RecipeItemBuilder {

    /**
     * Sets the Item
     *
     * @param item the craft component
     * @return this
     */
    RecipeItemBuilder setItem(ItemStack item);

    /**
     * Set if the craft component needs to match with the metadata from the inserted item (displayname, amount, meta)
     * Notice: If there is a specific amount of items needed: Please get the amount from the item above!
     *
     * @param ignoreMetadata boolean if meta is important
     * @return this
     */
    RecipeItemBuilder setIgnoreMetadata(boolean ignoreMetadata);


    /**
     * Add a new Requirement to the current item
     *
     * @param requirement requirement which data the item needs to match
     * @return this
     */
    RecipeItemBuilder addRequirement(Requirement requirement);

    /**
     * Replace the item after the craft-process
     *
     * @param item the replaced item
     * @return this
     */
    RecipeItemBuilder replaceItemAfterCrafting(ItemStack item);

    /**
     * Creates the new instance out of the builder components
     *
     * @return The RecipeItem instance object
     */
    RecipeItem build();

}
