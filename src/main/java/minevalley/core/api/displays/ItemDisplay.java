package minevalley.core.api.displays;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface ItemDisplay extends Display {

    /**
     * Set the item stack of the display
     *
     * @param itemStack the item stack
     * @return this
     * @throws IllegalArgumentException if the item stack is null
     */
    @Nonnull
    @Contract("_ -> this")
    ItemDisplay setItemStack(@Nonnull ItemStack itemStack) throws IllegalArgumentException;

    /**
     * Update the item stack of the display.
     */
    void updateItemStack();
}
