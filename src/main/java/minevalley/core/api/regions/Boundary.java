package minevalley.core.api.regions;

import lombok.NonNull;
import minevalley.core.api.User;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.function.Consumer;

public interface Boundary {

    /**
     * Gets the first location that defines this boundary.
     *
     * @return first location of this boundary
     */
    Location getFirstLocation();

    /**
     * Gets the second location that defines this boundary.
     *
     * @return second location of this boundary
     */
    Location getSecondLocation();

    /**
     * Updates the first location of this boundary.
     *
     * @param location first location
     */
    void updateFirstLocation(@NonNull Location location);

    /**
     * Updates the second location of this boundary.
     *
     * @param location second location
     */
    void updateSecondLocation(@NonNull Location location);

    /**
     * Moves this boundary in direction of the given boundary.
     *
     * @param vector vector to move this boundary
     */
    void move(@NonNull Vector vector);

    /**
     * Moves this boundary to a specific location (given location is used then as first location).
     *
     * @param location new first location
     */
    void move(@NonNull Location location);

    /**
     * Deactivates this boundary.
     */
    void deactivate();

    /**
     * Deactivates this boundary.
     */
    void activate();

    /**
     * Imitates a click by the given user and calls the callback.
     *
     * @param user user to call the callback with
     */
    void call(@NonNull User user);

    /**
     * Defines the callback, that is called, if a player clicks the boundary.
     * @param callback
     */
    void onCall(@NonNull Consumer<User> callback);

    /**
     * Gets whether this boundary is activated.
     * @return true, if this boundary is activated
     */
    boolean isActivated();

}
