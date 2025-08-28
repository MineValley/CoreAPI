package minevalley.core.api.interaction;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public interface InteractionTrigger {

    /**
     * Gets the world this trigger is in.
     *
     * @return world of this trigger
     */
    @Nonnull
    @Contract(pure = true)
    World world();

    /**
     * Gets the minimum location that defines this trigger.
     *
     * @return minimum location of this trigger
     */
    @Nonnull
    @Contract(pure = true)
    Location minLocation();

    /**
     * Gets the maximum location that defines this trigger.
     *
     * @return maximum location of this trigger
     */
    @Nonnull
    @Contract(pure = true)
    Location maxLocation();

    /**
     * Gets the range of this trigger, defined as the longest distance this trigger can be clicked from.
     *
     * @return range of this trigger
     */
    @Nonnegative
    @Contract(pure = true)
    double range();

    /**
     * Updates the min location of this trigger.
     *
     * @param x x coordinate of the new min location
     * @param y y coordinate of the new min location
     * @param z z coordinate of the new min location
     */
    void updateMinLocation(double x, double y, double z);

    /**
     * Updates the max location of this trigger.
     *
     * @param x x coordinate of the new max location
     * @param y y coordinate of the new max location
     * @param z z coordinate of the new max location
     */
    void updateMaxLocation(double x, double y, double z);

    /**
     * Moves this trigger so that its min corner equals the given location without changing its dimensions.
     *
     * @param x x coordinate of the new min location
     * @param y y coordinate of the new min location
     * @param z z coordinate of the new min location
     */
    void move(double x, double y, double z);

    /**
     * Deactivates this trigger.
     */
    void deactivate();

    /**
     * Deactivates this trigger.
     */
    void activate();

    /**
     * Gets whether this trigger is activated.
     *
     * @return true, if this trigger is activated
     */
    boolean isActivated();

    /**
     * Defines the callback, that is called, if a player clicks the trigger.
     *
     * @param callback will be called when clicked
     */
    void onCall(@Nonnull Consumer<PlayerInteractEvent> callback);
}