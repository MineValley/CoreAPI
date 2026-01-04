package minevalley.core.api.armorstand.modifiers;

import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface PassengerModifier<T extends PassengerModifier<T>> {

    /**
     * Get the current passenger list
     *
     * @return a list with the passengers as entities
     */
    @Nonnull
    @Contract(pure = true)
    List<Entity> getPassengers();

    /**
     * Add a passenger to the object
     *
     * @param entity the entity to be added
     * @return this
     * @throws IllegalArgumentException if the entity is null
     */
    @Nonnull
    @Contract("_ -> this")
    T addPassenger(@Nonnull Entity entity) throws IllegalArgumentException;

    /**
     * Remove a passenger
     *
     * @param entity the entity to be removed
     * @return this
     * @throws IllegalArgumentException if the entity is null
     */
    @Nonnull
    @Contract("_ -> this")
    T removePassenger(@Nonnull Entity entity) throws IllegalArgumentException;

    /**
     * Update the passengers
     */
    void updatePassengers();
}
