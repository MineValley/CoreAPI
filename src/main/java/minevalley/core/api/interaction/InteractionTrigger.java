package minevalley.core.api.interaction;

import org.bukkit.World;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.xml.stream.Location;
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
     * Updates the min location of this trigger.
     *
     * @param location min location
     */
    void updateMinLocation(@Nonnull Location location);

    /**
     * Updates the max location of this trigger.
     *
     * @param location max location
     */
    void updateMaxLocation(@Nonnull Location location);

    /**
     * Moves this trigger so that its min corner equals the given location without changing its dimensions.
     *
     * @param minLocation new min location
     */
    void move(@Nonnull Location minLocation);

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