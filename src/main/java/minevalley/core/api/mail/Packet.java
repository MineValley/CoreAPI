package minevalley.core.api.mail;

import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public interface Packet extends Parcel {

    /**
     * Gets the contents of this packet.
     *
     * @return array of the contents.
     */
    ItemStack[] getContents();
}
