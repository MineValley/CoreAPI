package minevalley.core.api.enums;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.core.api.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum InterfaceItem {

    /**
     * Hides the selected slot.
     */
    SPACER(1),

    /**
     * Hides the selected slot and the one underneath.
     */
    DOUBLE_SPACER(2),

    /**
     * Hides the selected slot and highlights the item underneath.
     */
    HIGHLIGHTED_SPACER(3),

    /**
     * Hides the selected slot and the one underneath, but highlights the item under the selected slot.
     */
    HIGHLIGHTED_DOUBLE_SPACER(4),

    /**
     * Hides the selected slot and displays a green hook.
     * <p>
     * <b>Deprecated!</b> use CHECKMARK instead!
     * </p>
     */
    @Deprecated
    HOOK(5),

    /**
     * Hides the selected slot and displays a green hook.
     */
    CHECKMARK(5),

    /**
     * Hides the selected slot and displays a red cross.
     */
    CROSS(6),

    /**
     * Hides the selected slot and displays a red cross. Mostly used on the eighth slot of an inventory to symbolize a close-button.
     */
    CLOSE(CROSS.getBuilder().setDisplayName("§c§lSchließen")),

    /**
     * Is used to scroll back a page in an inventory.
     */
    PREVIOUS(7),

    /**
     * Is used to scroll forward a page in an inventory.
     */
    NEXT(8),

    /**
     * Is used to signalize an empty power slot.
     */
    INACTIVE_CELL(9),

    /**
     * Is used to signalize a full power slot.
     */
    ACTIVE_CELL(10),

    /**
     * Hides the selected slot and displays two small arrows pointing to the right side.
     */
    ARROWS(11),

    /**
     * Hides the selected slot and displays the background of an button underneath.
     */
    BUTTON(12),

    /**
     * Hides the selected slot and displays a blue return button.
     */
    RETURN(15);


    private final Object object;

    /**
     * Gets the interface-item as an item-builder.
     *
     * @return interface-item as item-builder
     */
    public ItemBuilder getBuilder() {
        return object instanceof ItemBuilder ? (ItemBuilder) object : Core.createItem(Material.WOOD_SWORD)
                .setDurability((int) object).hideAttributes().setDisplayName(" ");
    }

    /**
     * Gets the itemstack of the interface-item.
     *
     * @return interface-item as itemstack
     */
    public ItemStack toItemStack() {
        return getBuilder().build();
    }
}