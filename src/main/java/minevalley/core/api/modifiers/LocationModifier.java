package minevalley.core.api.modifiers;

import org.bukkit.Location;

@SuppressWarnings("unused")
public interface LocationModifier {

    /**
     * Get the location
     *
     * @return location
     */
    Location getLocation();

    /**
     * Sets the location
     * <br>
     * <b>Note:</b> This ignores the yaw and pitch values.
     *
     * @param location new location.
     */
    LocationModifier setLocation(Location location);

    /**
     * Update the location
     */
    void updateLocation();
}
