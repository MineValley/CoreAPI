package eu.minevalley.core.api.utils.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface GuiItem {

    void setItemStack(ItemStack itemStack);

    void setInventory(InventoryGui inventory);

    void setData(Object data);

    void update();

    void click(Player player);

    boolean compareItem(ItemStack itemStack);

    ItemStack getItemStack();

    Object getData();
}