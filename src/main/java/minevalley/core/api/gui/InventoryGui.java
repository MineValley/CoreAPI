package minevalley.core.api.gui;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface InventoryGui {

    void open(Player player);

    void open(OnlineUser user);

    void updateTitle(String title);

    InventoryGui unlockSlot(int slot);

    GuiItem getItem(int slot);

    Inventory getInventory();

    void setItem(int slot, GuiItem item);
}