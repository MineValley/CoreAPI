package minevalley.core.api.armorstand.modifiers;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface RotationModifier<T extends RotationModifier<T>> {

    /**
     * Sets the rotation of the armor stand
     *
     * @param rotation rotation in degrees
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setRotation(float rotation);

    /**
     * Gets the rotation of the armor stand in degrees
     *
     * @return the rotation of the armor stand
     */
    @Contract(pure = true)
    float getRotation();

    /**
     * Updates the rotation of the armor stand
     */
    void updateRotation();
}
