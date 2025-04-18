package minevalley.core.api.enums;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.core.api.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum InterfaceItem {

    /**
     * Hides the selected slot.
     */
    SPACER(1),


    /**
     * Hides the selected slot and the one above.
     */
    DOUBLE_SPACER_UP(2),

    /**
     * Hides the selected slot and the one underneath.
     */
    DOUBLE_SPACER_DOWN(3),

    /**
     * Hides the selected slot and the one to the left.
     */
    DOUBLE_SPACER_LEFT(4),

    /**
     * Hides the selected slot and the one to the right.
     */
    DOUBLE_SPACER_RIGHT(5),


    /**
     * Hides the selected slot and highlights the item above.
     */
    HIGHLIGHTER_UP(6),

    /**
     * Hides the selected slot and highlights the item underneath.
     */
    HIGHLIGHTER_DOWN(7),

    /**
     * Hides the selected slot and highlights the item to the left.
     */
    HIGHLIGHTER_LEFT(8),

    /**
     * Hides the selected slot and highlights the item to the right.
     */
    HIGHLIGHTER_RIGHT(9),


    /**
     * Hides the selected slot and the one above, but highlights the item above the selected slot.
     */
    HIGHLIGHTED_DOUBLE_SPACER_UP(10),

    /**
     * Hides the selected slot and the one underneath, but highlights the item under the selected slot.
     */
    HIGHLIGHTED_DOUBLE_SPACER_DOWN(11),

    /**
     * Hides the selected slot and the one to the left, but highlights the item to the left of the selected slot.
     */
    HIGHLIGHTED_DOUBLE_SPACER_LEFT(12),

    /**
     * Hides the selected slot and the one to the right, but highlights the item to the right of the selected slot.
     */
    HIGHLIGHTED_DOUBLE_SPACER_RIGHT(13),


    /**
     * Hides the selected slot and displays a green hook.
     */
    CHECKMARK(14),

    /**
     * Hides the selected slot and displays a red cross.
     */
    CROSS(15),


    /**
     * Hides the selected slot and displays a blue return arrow.
     */
    RETURN(16),


    /**
     * Is used to scroll back a page in an inventory.
     */
    PREVIOUS(17),

    /**
     * Is used to scroll forward a page in an inventory.
     */
    NEXT(18),

    /**
     * Is used to scroll up in an inventory.
     */
    UP(19),

    /**
     * Is used to scroll down in an inventory.
     */
    DOWN(20),

    /**
     * Is used to scroll back a page in an inventory.
     */
    PREVIOUS_CLICKED(21),

    /**
     * Is used to scroll forward a page in an inventory.
     */
    NEXT_CLICKED(22),

    /**
     * Is used to scroll up in an inventory.
     */
    UP_CLICKED(23),

    /**
     * Is used to scroll down in an inventory.
     */
    DOWN_CLICKED(24),


    /**
     * Is used to signalize an empty power slot.
     */
    INACTIVE_CELL(25),

    /**
     * Is used to signalize a full power slot.
     */
    ACTIVE_CELL(26),


    /**
     * Hides the selected slot and displays an arrow on the slot above.
     */
    BUTTON_UP(27),

    /**
     * Hides the selected slot and displays an arrow on the slot underneath.
     */
    BUTTON_DOWN(28),

    /**
     * Hides the selected slot and displays an arrow on the slot to the left.
     */
    BUTTON_LEFT(29),

    /**
     * Hides the selected slot and displays an arrow on the slot to the right.
     */
    BUTTON_RIGHT(30),


    /**
     * Is used to display the digit 0.
     */
    DIGIT_0(31),

    /**
     * Is used to display the digit 1.
     */
    DIGIT_1(32),

    /**
     * Is used to display the digit 2.
     */
    DIGIT_2(33),

    /**
     * Is used to display the digit 3.
     */
    DIGIT_3(34),

    /**
     * Is used to display the digit 4.
     */
    DIGIT_4(35),

    /**
     * Is used to display the digit 5.
     */
    DIGIT_5(36),

    /**
     * Is used to display the digit 6.
     */
    DIGIT_6(37),

    /**
     * Is used to display the digit 7.
     */
    DIGIT_7(38),

    /**
     * Is used to display the digit 8.
     */
    DIGIT_8(39),

    /**
     * Is used to display the digit 9.
     */
    DIGIT_9(40),

    /**
     * Is used to display a colon.
     */
    COLON(41);

    private final int customModelData;

    /**
     * Gets the interface-item as an item-builder.
     *
     * @return interface-item as item-builder
     */
    public ItemBuilder getBuilder() {
        return Core.createItem(Material.PAPER).setCustomModelData(customModelData).setDisplayName(Component.empty());
    }

    @Nonnull
    public static InterfaceItem getDigit(int digit) throws IllegalArgumentException {
        if (digit < 0) throw new IllegalArgumentException("Digit must be greater than or equal to 0.");
        if (digit > 9) throw new IllegalArgumentException("Digit must be less than or equal to 9.");
        return values()[27 + digit];
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