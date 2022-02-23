package minevalley.core.api.utils.gui;

import minevalley.core.api.User;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface InventoryGui {

    InventoryGui open(Player player);

    InventoryGui open(User user);

    InventoryGui update();

    InventoryGui updateItem(GuiItem guiItem);

    InventoryGui updateItem(GuiItem guiItem, GuiItem updateItem);

    void clear();

    void fix();

    void addItem(int slot, GuiItem guiItem);

    void addItem(GuiItem guiItem);

    void removeItem(GuiItem guiItem);

    Inventory getInventory();

    GuiItem getItem(int slot);
}