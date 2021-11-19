package eu.minevalley.core.api.utils.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface GuiItem {

    /**
     * Defines the itemstack of this gui-item
     * @param itemStack new itemstack
     */
    void setItemStack(ItemStack itemStack);

    /**
     * Defines the inventory of this gui-item
     * @param inventory inventory of this item
     */
    void setInventory(InventoryGui inventory);

    /**
     * Gives this gui-item a special data
     * @param data new data
     */
    void setData(Object data);

    /**
     * Updates this gui-item
     */
    void update();

    /**
     * Runs the callback which is defined for this gui-item
     * @param player clicking player
     */
    void click(Player player);

    /**
     * Checks if the given itemstack is the same as the gui-item
     * @param itemStack itemstack to check
     * @return true if itemstack and guititem are similar
     */
    boolean compareItem(ItemStack itemStack);

    /**
     * Gets the itemstack of this gui-item
     * @return itemstack
     */
    ItemStack getItemStack();

    /**
     * Gets the defined data for this gui-item
     * @return defined data as object
     */
    Object getData();
}