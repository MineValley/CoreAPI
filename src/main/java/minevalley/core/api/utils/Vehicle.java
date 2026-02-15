package minevalley.core.api.utils;

import org.jetbrains.annotations.Contract;

/**
 * Represents an entity that can act as a vehicle for a {@link Passenger}.
 */
@SuppressWarnings("unused")
public interface Vehicle {

    /**
     * Returns the entity id of the passenger.
     *
     * @return the entity id of the passenger.
     */
    @Contract(pure = true)
    int getEntityId();
}