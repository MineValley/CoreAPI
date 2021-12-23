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
     * Gets the locality that this cuboid belongs to.
     * @return locality that this cuboid belongs to
     */
    Locality getLocality();
}
