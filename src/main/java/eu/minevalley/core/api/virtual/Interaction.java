package eu.minevalley.core.api.virtual;

import eu.minevalley.core.api.virtual.modifier.InteractionModifier;
import eu.minevalley.core.api.virtual.modifier.LocationModifier;
import eu.minevalley.core.api.virtual.modifier.VisibilityModifier;
import org.bukkit.Location;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Interaction extends InteractionModifier<Interaction>, LocationModifier<Interaction>,
        VisibilityModifier<Interaction> {

    /**
     * Get the width
     *
     * @return width
     */
    @Contract(pure = true)
    float getWidth();

    /**
     * Set the width
     *
     * @param width the width, default is 1.0
     * @return this
     */
    @Nonnull
    @Contract(pure = true)
    Interaction setWidth(float width);

    /**
     * Get the height
     *
     * @return height
     */
    @Contract(pure = true)
    float getHeight();

    /**
     * Set the height
     *
     * @param height the height, default is 1.0
     * @return this
     */
    @Nonnull
    @Contract(pure = true)
    Interaction setHeight(float height);

    /**
     * Update the dimensions
     */
    void updateDimensions();

    /**
     * Sets the location
     * <br>
     * <b>Note:</b> This does not ignore the yaw and pitch values.
     *
     * @param location new location.
     * @return this
     * @throws IllegalArgumentException if the location is null or invalid.
     */
    @Nonnull
    @Contract("_ -> this")
    Interaction setLocation(@Nonnull Location location) throws IllegalArgumentException;
}
