package eu.minevalley.core.api.virtual.modifier;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface InterpolationModifier<T extends InterpolationModifier<T>> {

    /**
     * Set the transformation interpolation
     *
     * @param duration duration in ticks
     * @return the current instance
     */
    @Nonnull
    @Contract("_ -> this")
    T setTransformationInterpolation(int duration);

    /**
     * Set the position/rotation interpolation
     *
     * @param duration duration in ticks
     * @return the current instance
     */
    @Nonnull
    @Contract("_ -> this")
    T setPositionRotationInterpolation(int duration);

    /**
     * Update the translation.
     */
    void updateInterpolation();
}
