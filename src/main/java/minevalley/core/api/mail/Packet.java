package minevalley.core.api.mail;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Packet extends Parcel {

    /**
     * Gets the contents of this packet.
     *
     * @return array of the contents.
     */
    @Nonnull
    @Contract(pure = true)
    ItemStack[] getContents();
}
