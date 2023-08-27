package minevalley.core.api.utils.gui;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.enums.InterfaceItem;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface GuiBuilder {

    GuiBuilder setTitle(String title);

    GuiBuilder setItem(int slot, GuiItem guiItem);

    GuiBuilder setItem(int slot, ItemStack itemStack);

    GuiBuilder setItem(int slot, InterfaceItem item);

    GuiBuilder addItem(GuiItem guiItem);

    GuiBuilder addItem(ItemStack itemStack);

    GuiBuilder addItem(InterfaceItem item);

    GuiBuilder addInterfaceItems(InterfaceItem item, int... slots);

    GuiBuilder addInterfaceItemsInRange(InterfaceItem item, int from, int to);

    GuiBuilder unlockSlot(int slot);

    GuiBuilder unlockSlots(int... slots);

    GuiBuilder addCloser();

    GuiBuilder onClose(Consumer<OnlineUser> callback);

    GuiBuilder onClose(BiConsumer<OnlineUser, Inventory> callback);

    GuiBuilder onCloseButton(Consumer<OnlineUser> callback);

    GuiItem getItem(int slot);

    int getSize();

    InventoryGui build();
}