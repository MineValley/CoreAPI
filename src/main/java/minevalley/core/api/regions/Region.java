package minevalley.core.api.regions;

import minevalley.core.api.regions.residences.Residence;
import minevalley.core.api.regions.utils.Area;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.Chunk;
import org.bukkit.Location;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public interface Region {

    /**
     * Gets this regions' id.
     *
     * @return id as integer
     */
    @Nonnegative
    int getId();

    /**
     * Gets a list of the areas that are included in the region.
     *
     * @return list of included areas
     */
    @Nonnull
    List<Area> getIncluded();

    /**
     * Gets a list of the areas that are excluded by the region.
     *
     * @return list of excluded areas
     */
    @Nonnull
    List<Area> getExcluded();

    /**
     * Gets a list with the chunks that this region lies in.
     *
     * @return list of chunks this region lies in
     */
    @Nonnull
    List<Chunk> getChunks();

    /**
     * Gets a stream of all the users that are currently in the region.
     *
     * @return stream of all users in the region
     */
    @Nonnull
    Stream<OnlineUser> getUsersInRegion();

    /**
     * Kicks a user out of the region.
     *
     * @param user   user to kick
     * @param target location to kick the user to
     * @throws IllegalStateException    if the user is offline or not inside the region.
     * @throws IllegalArgumentException if one of the arguments is null, or the target location is not in the same world as the region itself.
     */
    void kickUser(@Nonnull OnlineUser user, @Nonnull Location target) throws IllegalStateException, IllegalArgumentException;

    /**
     * Kicks all users out of this region.
     * <p>
     * <b>Note:</b> This
     *
     * @param target
     */
    default void kickAllUsers(@Nonnull Location target) {

    }

    void setAllowEnter(boolean allow);

    boolean isAllowedToEnter();

    /**
     * Gets the residence this region is used as, if existing.
     *
     * @return the residence this region is used as, if existing.
     */
    @Nullable
    Residence getResidence();

    void update(List<Area> included, List<Area> excluded);
}