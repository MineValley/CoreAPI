package minevalley.core.api.crafting;

import lombok.Getter;

@Getter
public class CraftingLine {
    private final CraftingItem[] items;

    public CraftingLine(CraftingItem... items) {
        this.items = items;
    }
}