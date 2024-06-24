package minevalley.core.api.regions;

import minevalley.core.api.regions.residences.Residence;
import minevalley.core.api.regions.utils.Area;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.Chunk;
import org.bukkit.Location;

import java.util.List;

public interface Region {

    /**
     * Gets this regions' id.
     *
     * @return id as integer
     */
    int getId();

    /**
     * Gets a list of the areas that define this region.
     *
     * @return array of areas
     */
    Area[] getIncluded();

    Area[] getExcluded();

    /**
     * Gets an array with the chunks that this region lies on.
     *
     * @return array of chunks
     */
    Chunk[] getChunks();

    List<OnlineUser> getUsersInRegion();

    void kickUser(OnlineUser user, Location target);

    void kickAllUsers(Location target);

    void setAllowEnter(boolean allow);

    boolean isAllowedToEnter();

    /**
     * <b>Note:</b> This could be null!
     *
     * @return the residence this region is connected to, if existing.
     */
    Residence getResidence();

    void update(List<Area> included, List<Area> excluded);
}