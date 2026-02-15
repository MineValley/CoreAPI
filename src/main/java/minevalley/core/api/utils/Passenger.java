package minevalley.core.api.utils;

/**
 * Represents an entity that can act as a passenger of another entity.
 */
@SuppressWarnings("unused")
public interface Passenger {

    /**
     * Returns the entity id of the passenger.
     *
     * @return the entity id of the passenger.
     */
    int getEntityId();
}