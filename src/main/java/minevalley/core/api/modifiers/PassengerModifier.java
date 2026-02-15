package minevalley.core.api.modifiers;

import minevalley.core.api.utils.Passenger;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface PassengerModifier<T extends PassengerModifier<T>> {

    /**
     * Add a passenger to the object
     *
     * <P><strong>Note:</strong> Assigning a passenger via {@code Entity} is only reliable while the vehicle remains stationary</P>
     *
     * @param entity the entity to be added
     * @return this
     * @throws IllegalArgumentException if the entity is null
     */
    @Nonnull
    @Contract("_ -> this")
    T addPassenger(@Nonnull Entity entity) throws IllegalArgumentException;

        /**
        * Add a passenger to the object
        *
        * <P><strong>Note:</strong> Assigning a passenger via {@code Passenger} is only reliable while the vehicle remains stationary</P>
        *
        * @param passenger the passenger to be added
        * @return this
        */
    @Nonnull
    @Contract("_ -> this")
    T addPassenger(@Nonnull Passenger passenger) throws IllegalArgumentException;

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
     * Remove a passenger
     *
     * @param passenger the passenger to be removed
     * @return this
     * @throws IllegalArgumentException if the entity ID is invalid
     */
    T removePassenger(@Nonnull Passenger passenger) throws IllegalArgumentException;

    /**
     * Update the passengers
     */
    void updatePassengers();

    /**
     * Get the current passenger list
     *
     * @return a list with the passengers as entities
     */
    @Nonnull
    @Contract(pure = true)
    List<Entity> getPassengers();
}