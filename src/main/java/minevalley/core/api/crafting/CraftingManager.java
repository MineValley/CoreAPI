package minevalley.core.api.crafting;

public class CraftingManager {

    private static CraftingManagerInterface craftingManager;

    public CraftingManager(CraftingManagerInterface craftingManager) {
        CraftingManager.craftingManager = craftingManager;
    }

    void registerShapedRecipe(Recipe recipe) {
        craftingManager.registerShapedRecipe(recipe);
    }

    void registerShapelessRecipe(Recipe recipe) {
        craftingManager.registerShapelessRecipe(recipe);
    }

    void registerCrafting(Crafting crafting) {
        craftingManager.registerCrafting(crafting);
    }
}