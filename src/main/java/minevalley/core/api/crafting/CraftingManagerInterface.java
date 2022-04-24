package minevalley.core.api.crafting;

public interface CraftingManagerInterface {

    void registerShapedRecipe(Recipe recipe);

    void registerShapelessRecipe(Recipe recipe);

    void registerCrafting(Crafting crafting);
}