package minevalley.core.api.modifiers;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.Vector;

@SuppressWarnings("unused")
public interface ScaleModifier<T extends ScaleModifier<T>> {

    /**
     * Set the scale
     *
     * @param scale the scale, default is (1.0, 1.0, 1.0)
     * @return the current instance
     * @throws IllegalArgumentException if the scale is null
     */
    @Nonnull
    @Contract("_ -> this")
    T setScale(@Nonnull Vector<Float> scale) throws IllegalArgumentException;

    /**
     * Update the scale.
     */
    void updateScale();
}
