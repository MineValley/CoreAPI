package minevalley.core.api.modifiers;

import org.bukkit.util.Vector;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface ScaleModifier<T extends ScaleModifier<T>> {

    /**
     * Set the scale
     *
     * @param x x scale
     * @param y y scale
     * @param z z scale
     * @return the current instance
     */
    @Nonnull
    @Contract("_, _, _ -> this")
    T setScale(float x, float y, float z);

    /**
     * Set the scale
     *
     * @param scale the scale, default is (x: 1.0, y: 1.0, z: 1.0)
     * @return the current instance
     * @throws IllegalArgumentException if the scale is null
     */
    @Nonnull
    @Contract("_ -> this")
    T setScale(@Nonnull Vector scale) throws IllegalArgumentException;

    /**
     * Update the scale.
     */
    void updateScale();
}
