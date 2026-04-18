package eu.minevalley.core.api.gui;

import eu.minevalley.core.api.Core;
import eu.minevalley.core.api.item.ItemBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum InterfaceItem {

    /**
     * Hides the selected slot.
     */
    SPACER("gui/spacer"),


    /**
     * Hides the selected slot and the one above.
     */
    DOUBLE_SPACER_UP("gui/double_spacer_up"),

    /**
     * Hides the selected slot and the one underneath.
     */
    DOUBLE_SPACER_DOWN("gui/double_spacer_down"),

    /**
     * Hides the selected slot and the one to the left.
     */
    DOUBLE_SPACER_LEFT("gui/double_spacer_left"),

    /**
     * Hides the selected slot and the one to the right.
     */
    DOUBLE_SPACER_RIGHT("gui/double_spacer_right"),


    /**
     * Hides the selected slot and highlights the item above.
     */
    HIGHLIGHTER_UP("gui/highlighter_up"),

    /**
     * Hides the selected slot and highlights the item underneath.
     */
    HIGHLIGHTER_DOWN("gui/highlighter_down"),

    /**
     * Hides the selected slot and highlights the item to the left.
     */
    HIGHLIGHTER_LEFT("gui/highlighter_left"),

    /**
     * Hides the selected slot and highlights the item to the right.
     */
    HIGHLIGHTER_RIGHT("gui/highlighter_right"),


    /**
     * Hides the selected slot and the one above, but highlights the item above the selected slot.
     */
    HIGHLIGHTED_DOUBLE_SPACER_UP("gui/highlighted_double_spacer_up"),

    /**
     * Hides the selected slot and the one underneath, but highlights the item under the selected slot.
     */
    HIGHLIGHTED_DOUBLE_SPACER_DOWN("gui/highlighted_double_spacer_down"),

    /**
     * Hides the selected slot and the one to the left, but highlights the item to the left of the selected slot.
     */
    HIGHLIGHTED_DOUBLE_SPACER_LEFT("gui/highlighted_double_spacer_left"),

    /**
     * Hides the selected slot and the one to the right, but highlights the item to the right of the selected slot.
     */
    HIGHLIGHTED_DOUBLE_SPACER_RIGHT("gui/highlighted_double_spacer_right"),


    /**
     * Hides the selected slot and displays a green hook.
     */
    CHECKMARK("gui/checkmark"),

    /**
     * Hides the selected slot and displays a red cross.
     */
    CROSS("gui/cross"),


    /**
     * Hides the selected slot and displays a blue return arrow.
     */
    RETURN("gui/return"),


    /**
     * Is used to scroll back a page in an inventory.
     */
    PAGINATION_LEFT("gui/pagination_left"),

    /**
     * Is used to scroll forward a page in an inventory.
     */
    PAGINATION_RIGHT("gui/pagination_right"),

    /**
     * Is used to scroll up in an inventory.
     */
    PAGINATION_UP("gui/pagination_up"),

    /**
     * Is used to scroll down in an inventory.
     */
    PAGINATION_DOWN("gui/pagination_down"),


    /**
     * Is used to signalize an empty power slot.
     */
    INACTIVE_CELL("gui/cell_inactive"),

    /**
     * Is used to signalize a full power slot.
     */
    ACTIVE_CELL("gui/cell_active"),


    /**
     * Hides the selected slot and displays an arrow on the slot above.
     */
    BUTTON_UP("gui/button_up"),

    /**
     * Hides the selected slot and displays an arrow on the slot underneath.
     */
    BUTTON_DOWN("gui/button_down"),

    /**
     * Hides the selected slot and displays an arrow on the slot to the left.
     */
    BUTTON_LEFT("gui/button_left"),

    /**
     * Hides the selected slot and displays an arrow on the slot to the right.
     */
    BUTTON_RIGHT("gui/button_right"),


    /**
     * Is used to display the digit 0.
     */
    DIGIT_0("gui/digit_0"),

    /**
     * Is used to display the digit 1.
     */
    DIGIT_1("gui/digit_1"),

    /**
     * Is used to display the digit 2.
     */
    DIGIT_2("gui/digit_2"),

    /**
     * Is used to display the digit 3.
     */
    DIGIT_3("gui/digit_3"),

    /**
     * Is used to display the digit 4.
     */
    DIGIT_4("gui/digit_4"),

    /**
     * Is used to display the digit 5.
     */
    DIGIT_5("gui/digit_5"),

    /**
     * Is used to display the digit 6.
     */
    DIGIT_6("gui/digit_6"),

    /**
     * Is used to display the digit 7.
     */
    DIGIT_7("gui/digit_7"),

    /**
     * Is used to display the digit 8.
     */
    DIGIT_8("gui/digit_8"),

    /**
     * Is used to display the digit 9.
     */
    DIGIT_9("gui/digit_9"),

    /**
     * Is used to display a colon.
     */
    COLON("gui/colon");

    private final String itemModel;

    /**
     * Gets the interface-item as an item-builder.
     *
     * @return interface-item as item-builder
     */
    public ItemBuilder getBuilder() {
        return Core.createItem(Material.GRAY_STAINED_GLASS_PANE)
                .setItemModel(new NamespacedKey("minevalley", itemModel))
                .setHideToolTip(true).setDisplayName(Component.empty());
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