package eu.minevalley.core.api.utils.gui;

import org.bukkit.inventory.ItemStack;

public interface GuiItem {

    /**
     * Defines the itemstack of this gui-item
     * @param itemStack new itemstack
     */
    void setItemStack(ItemStack itemStack);

    ItemStack getItemStack();
}