package minevalley.core.api.gui;

import minevalley.core.api.enums.InterfaceItem;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Deprecated
@SuppressWarnings("unused")
public interface GuiBuilder {

    GuiBuilder setTitle(String title);

    @Deprecated
    GuiBuilder setItem(int slot, GuiItem guiItem);

    GuiBuilder setItem(int slot, ItemStack itemStack);

    GuiBuilder setItem(int slot, InterfaceItem item);

    @Deprecated
    GuiBuilder addItem(GuiItem guiItem);

    GuiBuilder addItem(ItemStack itemStack);

    GuiBuilder addItem(InterfaceItem item);

    GuiBuilder addInterfaceItems(InterfaceItem item, int... slots);

    GuiBuilder addInterfaceItemsInRange(InterfaceItem item, int from, int to);

    GuiBuilder unlockSlots(int... slots);

    GuiBuilder addCloser();

    GuiBuilder onClose(Consumer<OnlineUser> callback);

    GuiBuilder onClose(BiConsumer<OnlineUser, Inventory> callback);

    GuiBuilder onCloseButton(Consumer<OnlineUser> callback);

    @Deprecated
    GuiItem getItem(int slot);

    int getSize();

    InventoryGui build();
}