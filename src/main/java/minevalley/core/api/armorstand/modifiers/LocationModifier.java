package minevalley.core.api.armorstand.modifiers;

import org.bukkit.Location;

public interface LocationModifier {

    /**
     * Get the location of the armorstand
     *
     * @return location
     */
    Location getLocation();

    /**
     * Sets the armorstands location.
     * <br>
     * <b>Note:</b> This ignores the yaw and pitch values.
     *
     * @param location new location of the armorstand.
     */
    LocationModifier setLocation(Location location);

    /**
     * Update the location of the armorstand
     */
    void updateLocation();
}
