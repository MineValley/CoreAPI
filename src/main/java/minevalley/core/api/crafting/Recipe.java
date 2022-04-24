package minevalley.core.api.crafting;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public class Recipe {

    private final ItemStack result;
    private final CraftingLine[] lines;

    public Recipe(ItemStack result, CraftingLine... lines) {
        this.result = result;
        this.lines = lines;
    }
}