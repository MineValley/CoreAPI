package minevalley.core.api.crafting;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public interface Recipe {

    HashMap<Integer, RecipeItem> ingredients = new HashMap<>();

    /**
     * Set a recipe name
     * @return Recipe name
     */
    String recipeName();

    /**
     * Defines the target(output) item
     * @return Output Item
     */
    ItemStack outputItem();

    /**
     * Defines the ingredients of the recipe with an integer which is used to map the items on
     * @return list with ingredients
     */
    default HashMap<Integer, RecipeItem> ingredients() {return ingredients;}

    /**
     * Defines how many power levels the craft process should take
     */
    int powerConsumption();

    /**
     * Defines if the recipe can be crafted in a normal crafting table
     * @return isVanillaCraftable - standard = false due 5x5 crafting
     */
     default boolean isVanillaCraftable() {return false;}


}
