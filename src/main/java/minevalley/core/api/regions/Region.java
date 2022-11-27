package minevalley.core.api.regions;

import minevalley.core.api.OnlineUser;
import org.bukkit.Chunk;
import org.bukkit.Location;

import java.util.List;

public interface Region {

    /**
     * Gets this regions id.
     *
     * @return id as integer
     */
    int getId();

    /**
     * Gets a list of the areas that define this region.
     *
     * @return list of areas
     */
    Area[] getAreas();

    /**
     * Gets this regions priority.
     * @return priority as integer
     */
    int getPriority();

    /**
     * Gets a list with the chunks that this region lies on.
     *
     * @return list of chunks
     */
    Chunk[] getChunks();

    List<OnlineUser> getUsersInRegion();

    void kickUser(OnlineUser user, Location target);

    void kickAllUsers(Location target);

    void allowEntering(boolean allow);

    boolean isAllowedToEnter();
}