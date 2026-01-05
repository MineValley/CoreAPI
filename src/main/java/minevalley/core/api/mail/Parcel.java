package minevalley.core.api.mail;

import minevalley.core.api.Registrant;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Parcel {

    /**
     * Gets the sender of this parcel.
     *
     * @return this parcels sender as registrant.
     */
    @Nonnull
    @Contract(pure = true)
    Registrant getSender();

    /**
     * Gets this parcels intended addressee.
     *
     * @return this parcels target as registrant.
     */
    @Nonnull
    @Contract(pure = true)
    Registrant getTarget();

    /**
     * Starts the delivering process for this parcel.
     */
    void releaseForShipment();

    /**
     * Gets the minutes that remain, until this parcel is delivered to the mailbox of the target.
     * This is only an approximation. Parcels may be delivered up to five minutes earlier or later.
     *
     * @return minutes until this parcel is delivered.
     */
    @Contract(pure = true)
    int getRemainingMinutes();

    /**
     * Returns an item that represents this parcel and can be opened by team members and the addressee.
     *
     * @return this parcels item.
     */
    @Nonnull
    @Contract(value = "-> new", pure = true)
    ItemStack asItem();

    String toString();
}