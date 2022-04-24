package minevalley.core.api.crafting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class CraftingItem {

    private final Material material;
    private int durability, subId;
}