package minevalley.core.api.regions;

import org.bukkit.block.Block;

public interface Area {

    /**
     * Gets the first location that defines this area.
     *
     * @return first location of this area
     */
    Block getFirstLocation();

    /**
     * Gets the second location that defines this area.
     *
     * @return second location of this area
     */
    Block getSecondLocation();

}
