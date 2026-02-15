package minevalley.core.api.modifiers;

import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface VehicleModifier<T extends PassengerModifier<T>> {

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
}