package minevalley.core.api.gui;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("unused")
public interface MultiPageGui extends InventoryGui {

    /**
     * Adds the specified slots to the fill slots.
     *
     * @param slots the slots to add to the fill slots
     * @return this GUI
     * @throws IllegalArgumentException if any of the slots are out of bounds
     */
    @Nonnull
    @Contract("_ -> this")
    MultiPageGui addFillSlots(@Nonnegative int... slots) throws IllegalArgumentException;

    /**
     * Removes the specified slots from the fill slots.
     *
     * @param slots the slots to remove from the fill slots
     * @return this GUI
     * @throws IllegalArgumentException if any of the slots are out of bounds
     */
    @Nonnull
    @Contract("_ -> this")
    MultiPageGui removeFillSlots(@Nonnegative int... slots) throws IllegalArgumentException;

    /**
     * Gets a copy of the fill slots list of this GUI.
     *
     * @return copy the fill slots list of this GUI
     */
    @Nonnull
    @Contract(pure = true)
    List<Integer> getFillSlots();

    /**
     * Places the specified page-dependant item on all pages of this GUI.
     *
     * @param slot             the slot to place the item in
     * @param itemProvider     the function to provide the item for the slot depending on the page it is on
     * @param callbackProvider the function to provide the callback for the item depending on the page it is on
     * @return this GUI
     * @throws IllegalArgumentException if the slot is out of bounds, or the itemProvider or callbackProvider is null
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    MultiPageGui setPageDependantItem(@Nonnegative int slot, @Nonnull Function<Integer, ItemStack> itemProvider,
                                      @Nonnull Function<Integer, Consumer<GuiItemClick>> callbackProvider) throws IllegalArgumentException;

    /**
     * Get the amount of pages in this GUI.
     *
     * @return the amount of pages in this GUI
     */
    @Nonnegative
    @Contract(pure = true)
    int getPageAmount();

    /**
     * Gets the inventory of the specified page.
     * <br>
     * <b>Note:</b> The inventory is created on the fly and is not cached.
     *
     * @param page the page to get the inventory of
     * @return the inventory of the specified page
     * @throws IllegalArgumentException if the page is out of bounds
     */
    @Nonnull
    Inventory getInventory(@Nonnegative int page) throws IllegalArgumentException;

    /**
     * Opens this GUI for the specified player on the specified page.
     * <br>
     * <b>Note:</b> The inventory is created on the fly and is not cached.
     *
     * @param player the player to open the GUI for
     * @param page   the page to open the GUI on
     * @throws IllegalArgumentException if the player is null, or the page is out of bounds
     */
    void open(@Nonnull Player player, @Nonnegative int page) throws IllegalArgumentException;

    /**
     * Opens this GUI for the specified user on the specified page.
     * <br>
     * <b>Note:</b> The inventory is created on the fly and is not cached.
     *
     * @param user the user to open the GUI for
     * @param page the page to open the GUI on
     * @throws IllegalArgumentException if the user is null, or the page is out of bounds
     */
    void open(@Nonnull OnlineUser user, @Nonnegative int page) throws IllegalArgumentException;

    /**
     * Gets a copy of the underlying inventory of this GUI.
     * <br>
     * <b>Note:</b> The inventory is created on the fly and is not cached.
     *
     * @return a copy of the underlying inventory of this GUI
     */
    @Override
    default @Nonnull Inventory getInventory() {
        return getInventory(0);
    }

    /**
     * Opens this GUI for the specified player on the first page.
     *
     * @param player the player to open the GUI for
     * @throws IllegalArgumentException if the player is null
     */
    @Override
    default void open(@Nonnull Player player) {
        open(player, 0);
    }

    /**
     * Opens this GUI for the specified user on the first page.
     *
     * @param user the user to open the GUI for
     * @throws IllegalArgumentException if the user is null
     */
    @Override
    default void open(@Nonnull OnlineUser user) {
        open(user, 0);
    }
}