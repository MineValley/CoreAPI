package minevalley.core.api.regions.utils;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.List;

@SuppressWarnings("unused")
public interface Area {

    /**
     * Gets the first location that defines this area.
     *
     * @return first location of this area
     */
    @Deprecated
    Block getFirstLocation();

    Block getMinBlock();

    /**
     * Gets the second location that defines this area.
     *
     * @return second location of this area
     */
    @Deprecated
    Block getSecondLocation();

    Block getMaxBlock();

    List<Block> getBlocks();

    boolean contains(Block block);

    default boolean contains(Location location) {
        return contains(location.getBlock());
    }

    /**
     * Converts this area to a string
     *
     * @return string that represents this area
     */
    @Deprecated
    String toString();
}
