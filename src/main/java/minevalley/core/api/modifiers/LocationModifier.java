package minevalley.core.api.modifiers;

import org.bukkit.Location;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface LocationModifier {

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
     * @throws IllegalArgumentException if the location is null or invalid.
     */
    @Nonnull
    @Contract("_ -> this")
    LocationModifier setLocation(@Nonnull Location location) throws IllegalArgumentException;

    /**
     * Update the location
     */
    void updateLocation();
}
