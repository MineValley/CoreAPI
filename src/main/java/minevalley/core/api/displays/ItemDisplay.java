package minevalley.core.api.displays;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public interface ItemDisplay {

    /**
     * Set the item stack of the display
     *
     * @param itemStack the item stack
     * @return the current instance
     */
    ItemDisplay setItemStack(@Nonnull ItemStack itemStack);

    /**
     * Update the item stack of the display.
     */
    void updateItemStack();
}
