package minevalley.core.api.utils.armorstand.modifiers;

import org.bukkit.util.EulerAngle;

public interface PoseModifier {

    /**
     * Sets the head pose of the armor stand.
     *
     * @param yaw   The yaw of the head.
     * @param pitch The pitch of the head.
     * @return The pose modifier.
     */
    PoseModifier queueHeadPose(float yaw, float pitch);

    /**
     * Sets the left arm pose of the armor stand.
     *
     * @param headPose The pose of the head.
     * @return The pose modifier.
     */
    PoseModifier queueHeadPose(EulerAngle headPose);

    /**
     * Sets the left arm pose of the armor stand.
     *
     * @param leftArmPose The pose of the left arm.
     * @return The pose modifier.
     */
    PoseModifier queueLeftArmPose(EulerAngle leftArmPose);

    /**
     * Sets the right arm pose of the armor stand.
     *
     * @param rightArmPose The pose of the right arm.
     * @return The pose modifier.
     */
    PoseModifier queueRightArmPose(EulerAngle rightArmPose);

    /**
     * Sets the body pose of the armor stand.
     *
     * @param bodyPose The pose of the body.
     * @return The pose modifier.
     */
    PoseModifier queueBodyPose(EulerAngle bodyPose);

    /**
     * Sets the left leg pose of the armor stand.
     *
     * @param leftLegPose The pose of the left leg.
     * @return The pose modifier.
     */
    PoseModifier queueLeftLegPose(EulerAngle leftLegPose);

    /**
     * Sets the right leg pose of the armor stand.
     *
     * @param rightLegPose The pose of the right leg.
     * @return The pose modifier.
     */
    PoseModifier queueRightLegPose(EulerAngle rightLegPose);

    /**
     * Updates the pose of the armor stand.
     */
    void updatePose();
}