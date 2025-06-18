package minevalley.core.api.localization;

import org.bukkit.Location;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Address {

    /**
     * Gets the location associated with this address.
     *
     * @return this address' location
     */
    @Nonnull
    @Contract(pure = true)
    Location getLocation();

    /**
     * Converts this Address to a readable string.
     *
     * @return address as string
     */
    @Nonnull
    @Override
    @Contract(pure = true)
    String toString();
}
