package minevalley.core.api.modifiers;

import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.List;

@SuppressWarnings("unused")
public interface PassengerModifier<T extends PassengerModifier<T>> {

    /**
     * Set the vehicle of the object
     *
     * @param entity the entity to be set as vehicle
     * @return this
     * @throws IllegalArgumentException if the entity is null
     */
    @Nonnull
    @Contract("_ -> this")
    T setVehicle(@Nonnull Entity entity) throws IllegalArgumentException;

    /**
     * Set the vehicle of the object by entity ID
     *
     * <P><strong>Note:</strong> Assigning a vehicle by entity ID is only reliable while the vehicle remains stationary</P>
     *
     * @param entityId the entity ID to be set as vehicle
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setVehicle(int entityId);

    /**
     * Exit the current vehicle
     *
     * @return this
     */
    @Nonnull
    T exitVehicle();

    /**
     * Update the vehicle
     */
    void updateVehicle();

    /**
     * Get the current vehicle ID
     *
     * @return the vehicle entity ID, or -1 if no vehicle is set
     */
    int getVehicleId();

    /**
     * Add a passenger to the object
     *
     * <P><strong>Note:</strong> Assigning a vehicle by entity ID is only reliable while the vehicle remains stationary</P>
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
     * Get the current passenger list
     *
     * @return a list with the passengers as entities
     */
    @Nonnull
    @Contract(pure = true)
    List<Entity> getPassengers();

    /**
     * Update the passengers
     */
    void updatePassengers();
}