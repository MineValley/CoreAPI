package minevalley.core.api.modifiers;

import org.bukkit.Location;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface LocationModifier<T extends LocationModifier<T>> {

    /**
     * Get the location
     *
     * @return location
     */
    @Nonnull
    @Contract(pure = true)
    Location getLocation();

    /**
     * Sets the location
     * <br>
     * <b>Note:</b> This ignores the yaw and pitch values.
     *
     * @param location new location.
     * @return this
     * @throws IllegalArgumentException if the location is null or invalid.
     */
    @Nonnull
    @Contract("_ -> this")
    T setLocation(@Nonnull Location location) throws IllegalArgumentException;

    /**
     * Update the location
     */
    void updateLocation();
}
