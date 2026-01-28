package minevalley.core.api.modifiers;

import org.bukkit.util.EulerAngle;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface PoseModifier<T extends PoseModifier<T>> {

    /**
     * Gets the head pose of the armor stand.
     *
     * @return The pose of the head.
     */
    @Nonnull
    @Contract(pure = true)
    EulerAngle getHeadPose();

    /**
     * Sets the head pose of the armor stand.
     *
     * @param yaw   The yaw of the head.
     * @param pitch The pitch of the head.
     * @return this
     */
    @Nonnull
    @Contract("_, _ -> this")
    T setHeadPose(float yaw, float pitch);

    /**
     * Sets the left arm pose of the armor stand.
     *
     * @param headPose The pose of the head.
     * @return this
     * @throws IllegalArgumentException if the headPose is null
     */
    @Nonnull
    @Contract("_ -> this")
    T setHeadPose(@Nonnull EulerAngle headPose) throws IllegalArgumentException;


    /**
     * Gets the left arm pose of the armor stand.
     *
     * @return The pose of the left arm.
     */
    @Nonnull
    @Contract(pure = true)
    EulerAngle getLeftArmPose();

    /**
     * Sets the left arm pose of the armor stand.
     *
     * @param leftArmPose The pose of the left arm.
     * @return this
     * @throws IllegalArgumentException if the leftArmPose is null
     */
    @Nonnull
    @Contract("_ -> this")
    T setLeftArmPose(@Nonnull EulerAngle leftArmPose) throws IllegalArgumentException;


    /**
     * Gets the right arm pose of the armor stand.
     *
     * @return The pose of the right arm.
     */
    @Nonnull
    @Contract(pure = true)
    EulerAngle getRightArmPose();

    /**
     * Sets the right arm pose of the armor stand.
     *
     * @param rightArmPose The pose of the right arm.
     * @return this
     * @throws IllegalArgumentException if the rightArmPose is null
     */
    @Nonnull
    @Contract("_ -> this")
    T setRightArmPose(@Nonnull EulerAngle rightArmPose) throws IllegalArgumentException;


    /**
     * Gets the left leg pose of the armor stand.
     *
     * @return The pose of the left leg.
     */
    @Nonnull
    @Contract(pure = true)
    EulerAngle getBodyPose();

    /**
     * Sets the body pose of the armor stand.
     *
     * @param bodyPose The pose of the body.
     * @return this
     * @throws IllegalArgumentException if the bodyPose is null
     */
    @Nonnull
    @Contract("_ -> this")
    T setBodyPose(@Nonnull EulerAngle bodyPose) throws IllegalArgumentException;


    /**
     * Gets the left leg pose of the armor stand.
     *
     * @return The pose of the left leg.
     */
    @Nonnull
    @Contract(pure = true)
    EulerAngle getLeftLegPose();

    /**
     * Sets the left leg pose of the armor stand.
     *
     * @param leftLegPose The pose of the left leg.
     * @return this
     * @throws IllegalArgumentException if the leftLegPose is null
     */
    @Nonnull
    @Contract("_ -> this")
    T setLeftLegPose(@Nonnull EulerAngle leftLegPose) throws IllegalArgumentException;


    /**
     * Gets the right leg pose of the armor stand.
     *
     * @return The pose of the right leg.
     */
    @Nonnull
    @Contract(pure = true)
    EulerAngle getRightLegPose();

    /**
     * Sets the right leg pose of the armor stand.
     *
     * @param rightLegPose The pose of the right leg.
     * @return this
     * @throws IllegalArgumentException if the rightLegPose is null
     */
    @Nonnull
    @Contract("_ -> this")
    T setRightLegPose(@Nonnull EulerAngle rightLegPose) throws IllegalArgumentException;

    /**
     * Updates the pose of the armor stand.
     */
    void updatePose();
}