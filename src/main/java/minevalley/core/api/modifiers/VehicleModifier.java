package minevalley.core.api.modifiers;

import minevalley.core.api.utils.Vehicle;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
     * Set the vehicle of the object by {@code Vehicle}
     *
     * <P><strong>Note:</strong> Assigning a vehicle by {@code Vehicle} is only reliable while the vehicle remains stationary</P>
     *
     * @param vehicle the vehicle to be set
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setVehicle(Vehicle vehicle);

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
     * Get the current vehicle
     *
     * @return the vehicle or null if no vehicle is assigned
     */
    @Nullable
    @Contract(pure = true)
    Vehicle getVehicle();
}