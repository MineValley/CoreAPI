package eu.minevalley.core.api.virtual.riding;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

/**
 * Represents an entity that can act as a passenger of a {@link Vehicle}.
 */
@SuppressWarnings("unused")
public interface Passenger {

    /**
     * Gets the name of the passenger.
     *
     * @return name of the passenger
     */
    @Nonnull
    @Contract(pure = true)
    String getName();

    /**
     * Gets the entity id of the passenger.
     *
     * @return the entity id of the passenger.
     */
    @Contract(pure = true)
    int getEntityId();
}