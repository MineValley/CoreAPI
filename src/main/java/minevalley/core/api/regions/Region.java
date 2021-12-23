package minevalley.core.api.regions;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;

import java.util.List;

public interface Region {

    /**
     * Gets a list of the areas that define this region.
     * @return list of areas
     */
    Area[] getAreas();

    /**
     * Gets this regions id.
     * @return id as integer
     */
    int getId();

    /**
     * Gets a list with the players that are currently in this region.
     * @return list of players
     */
    Player[] getPlayers();

    /**
     * Gets a list with the chunks that this region lies on.
     * @return list of chunks
     */
    Chunk[] getChunks();
}