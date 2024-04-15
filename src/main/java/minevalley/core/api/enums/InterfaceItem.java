package minevalley.core.api.enums;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.core.api.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum InterfaceItem {

    /**
     * Hides the selected slot.
     */
    SPACER(1),

    /**
     * Hides the selected slot and the one underneath.
     */
    @Deprecated
    DOUBLE_SPACER(2),

    DOUBLE_SPACER_UP(36),

    DOUBLE_SPACER_DOWN(2),

    DOUBLE_SPACER_LEFT(32),

    DOUBLE_SPACER_RIGHT(33),

    /**
     * Hides the selected slot and highlights the item underneath.
     */
    HIGHLIGHTED_SPACER(3),

    /**
     * Hides the selected slot and the one underneath, but highlights the item under the selected slot.
     */
    HIGHLIGHTED_DOUBLE_SPACER(4),

    /**
     * Highlights the item under the selected slot without hiding its own slot.
     */
    HIGHLIGHTER(29),

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

    UP(34),

    DOWN(35),

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
     * Hides the selected slot and displays the background of a button underneath.
     */
    BUTTON(12),

    BUTTON_LEFT(30),

    BUTTON_RIGHT(31),

    /**
     * Hides the selected slot and displays a blue return button.
     */
    RETURN(15),

    DIGIT_0(16),

    DIGIT_1(17),

    DIGIT_2(18),

    DIGIT_3(19),

    DIGIT_4(20),

    DIGIT_5(21),

    DIGIT_6(22),

    DIGIT_7(23),

    DIGIT_8(24),

    DIGIT_9(25),

    COLON(26);


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

    public static InterfaceItem getDigit(int digit) {
        assert digit >= 0;
        assert digit <= 9;
        return Arrays.stream(InterfaceItem.values()).filter(interfaceItem -> interfaceItem.object instanceof Integer)
                .filter(interfaceItem -> (int) interfaceItem.object == 16 + digit).findFirst().orElse(null);
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