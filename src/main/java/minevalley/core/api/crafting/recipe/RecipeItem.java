package minevalley.core.api.crafting.recipe;

import minevalley.core.api.crafting.recipe.requirements.Requirement;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@SuppressWarnings("unused")
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

    /**
     * Get the Requirements of the Item which are needed to "allow" the crafting
     *
     * @return List with the Requirements
     */
    List<Requirement> getRequirements();

}
