package minevalley.core.api.modifiers;

@SuppressWarnings("unused")
public interface DisplayRotationModifier {

    /**
     * Set the rotation
     *
     * @param yaw   yaw rotation
     * @param pitch pitch rotation
     * @param roll  roll rotation
     * @return this
     */
    DisplayRotationModifier setRotation(float yaw, float pitch, float roll);

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
    DisplayRotationModifier setYaw(float yaw);

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
    DisplayRotationModifier setPitch(float pitch);

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
    DisplayRotationModifier setRoll(float roll);

    /**
     * Update the rotation
     */
    void updateRotation();
}
