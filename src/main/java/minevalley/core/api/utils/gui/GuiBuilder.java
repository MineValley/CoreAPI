package minevalley.core.api.utils.gui;

import minevalley.core.api.enums.InterfaceItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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

    GuiBuilder addCloser();

    GuiBuilder onClose(Consumer<Player> callback);

    GuiItem getItem(int slot);

    int getSize();

    InventoryGui build();
}