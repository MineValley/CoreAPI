package minevalley.core.api.regions;

import org.bukkit.Location;

public interface Area {

    /**
     * Gets the first location that defines this area.
     * @return first location of this area
     */
    Location getFirstLocation();

    /**
     * Gets the second location that defines this area.
     * @return second location of this area
     */
    Location getSecondLocation();

}
