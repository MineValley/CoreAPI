package minevalley.core.api.modifiers;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface RotationModifier<T extends RotationModifier<T>> {

    /**
     * Set the rotation
     *
     * @param yaw   yaw rotation
     * @param pitch pitch rotation
     * @param roll  roll rotation
     * @return this
     */
    @Nonnull
    @Contract(pure = true)
    T setRotation(float yaw, float pitch, float roll);

    /**
     * Get yaw
     *
     * @return yaw
     */
    float getYaw();

    /**
     * Set yaw
     *
     * @param yaw the yaw to set
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setYaw(float yaw);

    /**
     * Get pitch
     *
     * @return pitch
     */
    float getPitch();

    /**
     * Set pitch
     *
     * @param pitch the pitch to set
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setPitch(float pitch);

    /**
     * Get roll
     *
     * @return roll
     */
    float getRoll();

    /**
     * Set roll
     *
     * @param roll the roll to set
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setRoll(float roll);

    /**
     * Update the rotation
     */
    void updateRotation();
}
