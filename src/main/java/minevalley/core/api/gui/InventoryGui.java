package minevalley.core.api.gui;

import minevalley.core.api.enums.InterfaceItem;
import minevalley.core.api.users.OnlineUser;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.BiConsumer;
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
     * @throws IllegalArgumentException if the slot is out of bounds, or the item is null
     */
    @Nonnull
    @Contract("_, _ -> this")
    InventoryGui setItem(@Nonnegative int slot, @Nonnull ItemStack item) throws IllegalArgumentException;

    /**
     * Sets the interface item in the specified slot.
     *
     * @param slot the slot to set the item in
     * @param item the interface item to set
     * @return this GUI
     * @throws IllegalArgumentException if the slot is out of bounds, or the interface item is null
     */
    @Nonnull
    @Contract("_, _ -> this")
    default InventoryGui setItem(@Nonnegative int slot, @Nonnull InterfaceItem item) throws IllegalArgumentException {
        return setItem(slot, item.toItemStack());
    }

    /**
     * Sets the item in the specified slot.
     *
     * @param slot    the slot to set the item in
     * @param item    the item to set
     * @param onClick the consumer to run when the item is clicked
     * @return this GUI
     * @throws IllegalArgumentException if the slot is out of bounds, or the item or onClick is null
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    InventoryGui setItem(@Nonnegative int slot, @Nonnull ItemStack item, @Nonnull Consumer<OnlineUser> onClick) throws IllegalArgumentException;

    /**
     * Sets the interface item in the specified slot.
     *
     * @param slot    the slot to set the interface item in
     * @param item    the item to set
     * @param onClick the consumer to run when the item is clicked
     * @return this GUI
     * @throws IllegalArgumentException if the slot is out of bounds, or the interface item or onClick is null
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    default InventoryGui setItem(@Nonnegative int slot, @Nonnull InterfaceItem item, @Nonnull Consumer<OnlineUser> onClick) throws IllegalArgumentException {
        return setItem(slot, item.toItemStack(), onClick);
    }

    /**
     * Sets the item in the specified slot.
     *
     * @param slot    the slot to set the item in
     * @param item    the item to set
     * @param onClick the consumer to run when the item is clicked
     * @return this GUI
     * @throws IllegalArgumentException if the slot is out of bounds, or the item or onClick is null
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    InventoryGui setItem(@Nonnegative int slot, @Nonnull ItemStack item, @Nonnull BiConsumer<OnlineUser, InventoryClickEvent> onClick) throws IllegalArgumentException;

    /**
     * Sets the interface item in the specified slot.
     *
     * @param slot    the slot to set the interface item in
     * @param item    the item to set
     * @param onClick the consumer to run when the item is clicked
     * @return this GUI
     * @throws IllegalArgumentException if the slot is out of bounds, or the interface item or onClick is null
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    default InventoryGui setItem(@Nonnegative int slot, @Nonnull InterfaceItem item, @Nonnull BiConsumer<OnlineUser, InventoryClickEvent> onClick) throws IllegalArgumentException {
        return setItem(slot, item.toItemStack(), onClick);
    }

    /**
     * Placed the specified interface item in the specified slots.
     *
     * @param item  the item to place
     * @param slots the slots to place the item in
     * @return this GUI
     * @throws IllegalArgumentException if the item is null, or any of the slots are out of bounds
     */
    @Nonnull
    @Contract("_, _ -> this")
    InventoryGui setInterfaceItems(@Nonnull InterfaceItem item, @Nonnegative int... slots) throws IllegalArgumentException;

    /**
     * Placed the specified interface item in the specified range of slots.
     *
     * @param item the item to place
     * @param from the start of the range (inclusively)
     * @param to   the end of the range (exclusively)
     * @return this GUI
     * @throws IllegalArgumentException if the item is null, or any of the slots are out of bounds
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    InventoryGui setInterfaceItemsInRange(@Nonnull InterfaceItem item, @Nonnegative int from, @Nonnegative int to) throws IllegalArgumentException;

    /**
     * Places a closer item in the top right slot of the inventory (index 8).
     * When this item is clicked, the GUI will be closed and the {@code onClose} and {@code onButtonClose} callback will be called.
     *
     * @return this GUI
     */
    @Nonnull
    InventoryGui addCloser();

    /**
     * Gets the item in the specified slot.
     *
     * @param slot the slot to get the item from
     * @return the item in the specified slot, or null if the slot is empty
     * @throws IllegalArgumentException if the slot is out of bounds
     */
    @Nullable
    ItemStack getItem(@Nonnegative int slot) throws IllegalArgumentException;

    /**
     * Sets a callback to be called when the specified slot is clicked.
     * <p>
     * <b>Note:</b> The callback can be overwritten by setting another callback for the same slot or an item on this slot.
     *
     * @param slot    the slot to set the callback for
     * @param onClick the callback to call
     * @return this GUI
     * @throws IllegalArgumentException if the slot is out of bounds, or the onClick is null
     */
    @Nonnull
    InventoryGui onClickSlot(@Nonnegative int slot, @Nonnull Consumer<OnlineUser> onClick) throws IllegalArgumentException;

    /**
     * Sets a callback to be called when the specified slot is clicked.
     * <p>
     * <b>Note:</b> The callback can be overwritten by setting another callback for the same slot or an item on this slot.
     *
     * @param slot    the slot to set the callback for
     * @param onClick the callback to call
     * @return this GUI
     * @throws IllegalArgumentException if the slot is out of bounds, or the onClick is null
     */
    @Nonnull
    InventoryGui onClickSlot(@Nonnegative int slot, @Nonnull BiConsumer<OnlineUser, InventoryClickEvent> onClick) throws IllegalArgumentException;

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
     * Adds a callback to be called when this GUI is closed.
     *
     * @param callback the callback to call
     * @return this GUI
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui onClose(@Nullable BiConsumer<OnlineUser, Inventory> callback);

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
     * Locks the specified slot, preventing items from being placed or removed.
     * <p>
     * <b>Note:</b> By default, all slots are locked.
     *
     * @param slot the slot to lock
     * @return this GUI
     * @throws IllegalArgumentException if the slot is out of bounds
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui lockSlot(@Nonnegative int slot) throws IllegalArgumentException;

    /**
     * Unlocks the specified slot, allowing items to be placed or removed.
     *
     * @param slot the slot to unlock
     * @return this GUI
     * @throws IllegalArgumentException if the slot is out of bounds
     */
    @Nonnull
    @Contract("_ -> this")
    InventoryGui unlockSlot(@Nonnegative int slot) throws IllegalArgumentException;

    /**
     * Updates the title of this GUI.
     *
     * @param title the new title
     * @return this GUI
     * @throws IllegalArgumentException if the title is null
     */
    @Contract(pure = true)
    InventoryGui updateTitle(@Nonnull Component title) throws IllegalArgumentException;

    /**
     * Opens this GUI for the specified player.
     *
     * @param player the player to open the GUI for
     * @throws IllegalArgumentException if the player is null
     */
    @Contract(pure = true)
    void open(@Nonnull Player player) throws IllegalArgumentException;

    /**
     * Opens this GUI for the specified user.
     *
     * @param user the user to open the GUI for
     * @throws IllegalArgumentException if the user is null
     */
    @Contract(pure = true)
    void open(@Nonnull OnlineUser user) throws IllegalArgumentException;
}