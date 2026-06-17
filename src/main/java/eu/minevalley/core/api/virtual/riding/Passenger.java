package eu.minevalley.core.api.virtual.riding;

import eu.minevalley.core.api.virtual.modifier.LocationModifier;
import org.jetbrains.annotations.Contract;

/**
 * Represents an entity that can act as a passenger of a {@link Vehicle}.
 */
@SuppressWarnings("unused")
public interface Passenger<T extends LocationModifier<T>> {

    /**
     * Gets the entity id of the passenger.
     *
     * @return the entity id of the passenger.
     */
    @Contract(pure = true)
    int getEntityId();
}