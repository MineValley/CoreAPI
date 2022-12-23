package minevalley.core.api.mail;

import minevalley.core.api.Registered;
import org.bukkit.inventory.ItemStack;

public interface Parcel {

    /**
     * Gets the sender of this parcel.
     */
    Registered getSender();

    /**
     * Gets this parcels intended addressee.
     */
    Registered getTarget();

    /**
     * Starts the delivering process for this parcel.
     */
    void releaseForShipment();

    /**
     * Gets the minutes that remain, until this parcel is delivered to the mailbox of the target.
     * This is only an approximation. Parcels may be delivered up to five minutes earlier or later.
     */
    int getRemainingMinutes();

    /**
     * Returns an item that represents this parcel and can be opened by team members and the addressee.
     */
    ItemStack asItem();

    String toString();
}