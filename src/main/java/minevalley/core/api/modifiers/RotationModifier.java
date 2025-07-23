package minevalley.core.api.modifiers;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface RotationModifier {

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
    RotationModifier setRotation(float yaw, float pitch, float roll);

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
    RotationModifier setYaw(float yaw);

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
    RotationModifier setPitch(float pitch);

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
    RotationModifier setRoll(float roll);

    /**
     * Update the rotation
     */
    void updateRotation();
}
