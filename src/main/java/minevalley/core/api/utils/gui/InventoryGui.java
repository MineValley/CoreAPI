package minevalley.core.api.utils.gui;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface InventoryGui {

    InventoryGui open(Player player);

    InventoryGui open(OnlineUser user);

    void updateTitle(String title);

    InventoryGui unlockSlot(int slot);

    void clear();

    void addItem(int slot, GuiItem guiItem);

    void addItem(GuiItem guiItem);

    void removeItem(GuiItem guiItem);

    Inventory getInventory();

    GuiItem getItem(int slot);
}