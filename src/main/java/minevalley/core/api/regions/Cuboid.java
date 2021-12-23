package minevalley.core.api.regions;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;

public interface Cuboid {

    /**
     * Gets the chuck that defines this cuboid.
     * @return chunk that this cuboid lies on
     */
    Chunk getChunk();

    /**
     * Gets a list with the players that are currently in this region.
     * @return list of players
     */
    Player[] getPlayers();

    /**
     * Gets a list of the regions that a located in this cuboid.
     * <p>
     * <b>Note:</b> most of the regions are located over multiple cuboids!
     * @return list of regions
     */
    Region[] getRegions();

    /**
     * Gets the locality that this cuboid belongs to.
     * @return locality that this cuboid belongs to
     */
    Locality getLocality();
}
