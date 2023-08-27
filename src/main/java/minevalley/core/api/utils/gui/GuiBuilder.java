package minevalley.core.api.utils.gui;

import minevalley.core.api.enums.InterfaceItem;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface GuiBuilder {

    /**
     * <b>%i</b> will be replaced with the current page number
     */
    GuiBuilder setTitle(String title);

    GuiBuilder setItem(int slot, GuiItem guiItem);

    GuiBuilder setItem(int slot, ItemStack itemStack);

    GuiBuilder setItem(int slot, InterfaceItem item);

    GuiBuilder addItem(GuiItem guiItem);

    GuiBuilder addItem(ItemStack itemStack);

    GuiBuilder addItem(InterfaceItem item);

    GuiBuilder addInterfaceItems(InterfaceItem item, int... slots);

    GuiBuilder addInterfaceItemsInRange(InterfaceItem item, int from, int to);

    GuiBuilder unlockSlots(int... slots);

    GuiBuilder addFillSlots(int... slots);

    GuiBuilder removeFillSlots(int... slots);

    GuiBuilder fillWith(List<GuiItem> guiItems);

    GuiBuilder setNextItemSlot(int slot);

    GuiBuilder setPreviousItemSlot(int slot);

    GuiBuilder setNextItem(ItemStack itemStack);

    GuiBuilder setPreviousItem(ItemStack itemStack);

    GuiBuilder setNextItem(int slot, ItemStack itemStack);

    GuiBuilder setPreviousItem(int slot, ItemStack itemStack);

    GuiBuilder addCloser();

    GuiBuilder onClose(Consumer<OnlineUser> callback);

    GuiBuilder onClose(BiConsumer<OnlineUser, Inventory> callback);

    GuiBuilder onCloseButton(Consumer<OnlineUser> callback);

    GuiItem getItem(int slot);

    int getSize();

    InventoryGui build();
}