package eu.minevalley.core.api.gui;

import eu.minevalley.core.api.user.OnlineUser;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public interface InventoryGui {

    /**
     * Gets the underlying inventory of this GUI.
     *
     * @return the underlying inventory of this GUI
     */
    @Nonnull
    @Contract(pure = true)
    Inventory getInventory();

    /**
     * Sets the item in the specified slot.
     *
     * @param slot the slot to set the item in
     * @param item the item to set
     * @return this GUI
     * @throws IllegalArgumentException  if the item is null
     * @throws IndexOutOfBoundsException if the slot is out of bounds
     */
    @Nonnull
    @Contract("_, _ -> this")
    InventoryGui setItem(@Nonnegative int slot, @Nonnull ItemStack item)
            throws IllegalArgumentException, IndexOutOfBoundsException;

    /**
     * Sets the item in the specified slot.
     *
     * @param slot    the slot to set the item in
     * @param item    the item to set
     * @param onClick the consumer to run when the item is clicked
     * @return this GUI
     * @throws IllegalArgumentException  if the item or onClick is null
     * @throws IndexOutOfBoundsException if the slot is out of bounds
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    InventoryGui setItem(@Nonnegative int slot, @Nonnull ItemStack item, @Nonnull Consumer<GuiItemClick> onClick)
            throws IllegalArgumentException, IndexOutOfBoundsException;

    /**
     * Adds the specified item to the first available slot.
     *
     * @param item the item to add
     * @return this GUI
     * @throws IllegalArgumentException if the item is null
     * @throws IllegalStateException    if the inventory is full
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui addItem(@Nonnull ItemStack item) throws IllegalArgumentException, IllegalStateException;

    /**
     * Adds the specified item to the first available slot with a click handler.
     *
     * @param item    the item to add
     * @param onClick the consumer to run when the item is clicked
     * @return this GUI
     * @throws IllegalArgumentException if the item or onClick is null
     * @throws IllegalStateException    if the inventory is full
     */
    @Nonnull
    @Contract("_, _ -> this")
    InventoryGui addItem(@Nonnull ItemStack item, @Nonnull Consumer<GuiItemClick> onClick)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * Places a closer item in the top right slot (index 8).
     * The close-button graphic is rendered via the GUI font overlay.
     * When this slot is clicked, the GUI will be closed and the {@code onClose} / {@code onCloseButton} callbacks are called.
     *
     * @return this GUI
     */
    @Nonnull
    @Contract("-> this")
    InventoryGui addCloser();

    /**
     * Empties the specified slot.
     *
     * @param slot the slot to empty
     * @return this GUI
     * @throws IndexOutOfBoundsException if the slot is out of bounds
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui empty(@Nonnegative int slot) throws IndexOutOfBoundsException;

    /**
     * Gets the item in the specified slot.
     *
     * @param slot the slot to get the item from
     * @return the item in the specified slot, or null if the slot is empty
     * @throws IndexOutOfBoundsException if the slot is out of bounds
     */
    @Nullable
    ItemStack getItem(@Nonnegative int slot) throws IndexOutOfBoundsException;

    /**
     * Sets a callback to be called when the specified slot is clicked.
     * <p>
     * <b>Note:</b> The callback can be overwritten by setting another callback for the same slot or an item on this slot.
     *
     * @param slot    the slot to set the callback for
     * @param onClick the callback to call
     * @return this GUI
     * @throws IllegalArgumentException  if the onClick is null
     * @throws IndexOutOfBoundsException if the slot is out of bounds
     */
    @Nonnull
    InventoryGui onClickSlot(@Nonnegative int slot, @Nonnull Consumer<GuiItemClick> onClick)
            throws IllegalArgumentException, IndexOutOfBoundsException;

    /**
     * Removes the callback for the specified slot.
     *
     * @param slot the slot to remove the callback for
     * @return this GUI
     * @throws IndexOutOfBoundsException if the slot is out of bounds
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui removeSlotCallback(@Nonnegative int slot) throws IndexOutOfBoundsException;

    /**
     * Adds a callback to be called when this GUI is closed.
     *
     * @param callback the callback to call
     * @return this GUI
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui onClose(@Nullable Consumer<OnlineUser> callback);

    /**
     * Adds a callback to be called when the close button is clicked.
     *
     * @param callback the callback to call
     * @return this GUI
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui onCloseButton(@Nullable Consumer<OnlineUser> callback);

    /**
     * Places a return button at slot 7 via the GUI font overlay.
     * The return-button graphic is rendered in the inventory title.
     * <p><b>Note:</b> When the callback is null, the button overlay is removed.
     *
     * @param callback the callback to call when the return button is clicked
     * @return this GUI
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui onReturn(@Nullable Consumer<OnlineUser> callback);

    /**
     * Locks the specified slot, preventing items from being placed or removed.
     * <p><b>Note:</b> By default, all slots are locked.
     *
     * @param slot the slot to lock
     * @return this GUI
     * @throws IndexOutOfBoundsException if the slot is out of bounds
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui lockSlot(@Nonnegative int slot) throws IndexOutOfBoundsException;

    /**
     * Unlocks the specified slot, allowing items to be placed or removed.
     *
     * @param slot the slot to unlock
     * @return this GUI
     * @throws IndexOutOfBoundsException if the slot is out of bounds
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui unlockSlot(@Nonnegative int slot) throws IndexOutOfBoundsException;

    /**
     * Updates the title of this GUI.
     *
     * @param title the new title
     * @return this GUI
     * @throws IllegalArgumentException if the title is null
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui updateTitle(@Nonnull Component title) throws IllegalArgumentException;

    /**
     * Renders the specified overlay at the given slot via the GUI font.
     *
     * @param slot    the slot index (0-based, max 53 for a 6-row chest)
     * @param overlay the overlay type to render
     * @return this GUI
     * @throws IndexOutOfBoundsException if the slot is out of bounds
     * @throws IllegalArgumentException  if the overlay is null
     */
    @Nonnull
    @Contract("_, _ -> this")
    InventoryGui setOverlay(@Nonnegative int slot, @Nonnull GuiOverlay overlay)
            throws IndexOutOfBoundsException, IllegalArgumentException;

    /**
     * Renders a spacer overlay across all nine slots of the specified row via the GUI font.
     *
     * @param row the row to cover with the spacer
     * @return this GUI
     * @throws IllegalArgumentException if the row is null
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui setSpacer(@Nonnull GuiRow row) throws IllegalArgumentException;

    /**
     * Opens this GUI for the specified player.
     *
     * @param player the player to open the GUI for
     * @throws IllegalArgumentException if the player is null
     */
    void open(@Nonnull Player player) throws IllegalArgumentException;

    /**
     * Opens this GUI for the specified user.
     *
     * @param user the user to open the GUI for
     * @throws IllegalArgumentException if the user is null
     */
    void open(@Nonnull OnlineUser user) throws IllegalArgumentException;
}
