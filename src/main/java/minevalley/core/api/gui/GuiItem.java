package minevalley.core.api.gui;

import org.bukkit.inventory.ItemStack;

@Deprecated
public interface GuiItem {

    /**
     * Defines the itemstack of this gui-item
     *
     * @param itemStack new itemstack
     */
    void setItemStack(ItemStack itemStack);

    ItemStack getItemStack();
}