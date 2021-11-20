package minevalley.core.api.enums;

import minevalley.core.api.Core;
import minevalley.core.api.utils.ItemBuilder;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public enum InterfaceItem {

    /**
     * Hides the selected slot and the one underneath, but highlights the item under the selected slot.
     */
    HIGHLIGHTED_DOUBLE_SPACER(1),

    /**
     * Hides the selected slot and displays a green hook.
     */
    HOOK(2),

    /**
     * Hides the selected slot and displays a red cross.
     */
    CROSS(3),

    /**
     * Hides the selected slot and displays a red cross. Mostly used on the eighth slot of an inventory to symbolize a close-button.
     */
    CLOSE(CROSS.getBuilder().setDisplayName("§c§lSchließen")),

    /**
     * Hides the selected slot and the one underneath.
     */
    DOUBLE_SPACER(4),

    /**
     * Hides the selected slot and displays two small arrows pointing to the right side.
     */
    ARROWS(5),

    /**
     * Hides the selected slot and highlights the item underneath.
     */
    HIGHLIGHTED_SPACER(6),

    /**
     * Hides the selected slot.
     */
    SPACER(7);

    private final Object object;

    /**
     * Gets the interface-item as an item-builder.
     * @return interface-item as item-builder
     */
    public ItemBuilder getBuilder() {
        return (object instanceof ItemBuilder) ? (ItemBuilder) object : Core.createItem(Material.WOOD_SWORD)
                .setDurability((short) object).hideDurability().setDisplayName(" ");
    }

    /**
     * Gets the itemstack of the interface-item.
     * @return interface-item as itemstack
     */
    public ItemStack toItemStack() {
        return getBuilder().build();
    }
}