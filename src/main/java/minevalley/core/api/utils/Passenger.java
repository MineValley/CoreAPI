package minevalley.core.api.utils;

import org.jetbrains.annotations.Contract;

/**
 * Represents an entity that can act as a passenger of a {@link Vehicle}.
 */
@SuppressWarnings("unused")
public interface Passenger {

    /**
     * Returns the entity id of the passenger.
     *
     * @return the entity id of the passenger.
     */
    @Contract(pure = true)
    int getEntityId();
}