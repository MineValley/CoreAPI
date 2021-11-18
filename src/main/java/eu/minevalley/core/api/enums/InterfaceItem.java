package eu.minevalley.core.api.enums;

import eu.minevalley.core.api.Core;
import eu.minevalley.core.api.utils.ItemBuilder;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public enum InterfaceItem {

    HIGHLIGHTED_DOUBLE_SPACER(1),
    HOOK(2),
    CROSS(3),
    CLOSE(CROSS.getBuilder().setDisplayName("§c§lSchließen")),
    DOUBLE_SPACER(4),
    ARROWS(5),
    HIGHLIGHTED_SPACER(6),
    SPACER(7);

    private final Object object;

    public ItemBuilder getBuilder() {
        return (object instanceof ItemBuilder) ? (ItemBuilder) object : Core.createItem(Material.WOOD_SWORD)
                .setDurability((short) object).hideDurability().setDisplayName(" ");
    }

    public ItemStack toItemStack() {
        return getBuilder().build();
    }
}