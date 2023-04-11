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
    Area[] getIncluded();

    Area[] getExcluded();

    /**
     * Gets a list with the chunks that this region lies on.
     *
     * @return list of chunks
     */
    Chunk[] getChunks();

    List<OnlineUser> getUsersInRegion();

    void kickUser(OnlineUser user, Location target);

    void kickAllUsers(Location target);

    void setAllowEnter(boolean allow);

    boolean isAllowedToEnter();

    /**
     * Could be null!
     */
    Residence getResidence();
}