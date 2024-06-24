package minevalley.core.api.armorstand.modifiers;

import org.bukkit.util.EulerAngle;

public interface PoseModifier {

    /**
     * Gets the head pose of the armor stand.
     *
     * @return The pose of the head.
     */
    EulerAngle getHeadPose();

    /**
     * Sets the head pose of the armor stand.
     *
     * @param yaw   The yaw of the head.
     * @param pitch The pitch of the head.
     * @return The pose modifier.
     */
    PoseModifier setHeadPose(float yaw, float pitch);

    /**
     * Sets the left arm pose of the armor stand.
     *
     * @param headPose The pose of the head.
     * @return The pose modifier.
     */
    PoseModifier setHeadPose(EulerAngle headPose);


    /**
     * Gets the left arm pose of the armor stand.
     *
     * @return The pose of the left arm.
     */
    EulerAngle getLeftArmPose();

    /**
     * Sets the left arm pose of the armor stand.
     *
     * @param leftArmPose The pose of the left arm.
     * @return The pose modifier.
     */
    PoseModifier setLeftArmPose(EulerAngle leftArmPose);


    /**
     * Gets the right arm pose of the armor stand.
     *
     * @return The pose of the right arm.
     */
    EulerAngle getRightArmPose();

    /**
     * Sets the right arm pose of the armor stand.
     *
     * @param rightArmPose The pose of the right arm.
     * @return The pose modifier.
     */
    PoseModifier setRightArmPose(EulerAngle rightArmPose);


    /**
     * Gets the left leg pose of the armor stand.
     *
     * @return The pose of the left leg.
     */
    EulerAngle getBodyPose();

    /**
     * Sets the body pose of the armor stand.
     *
     * @param bodyPose The pose of the body.
     * @return The pose modifier.
     */
    PoseModifier setBodyPose(EulerAngle bodyPose);


    /**
     * Gets the left leg pose of the armor stand.
     *
     * @return The pose of the left leg.
     */
    EulerAngle getLeftLegPose();

    /**
     * Sets the left leg pose of the armor stand.
     *
     * @param leftLegPose The pose of the left leg.
     * @return The pose modifier.
     */
    PoseModifier setLeftLegPose(EulerAngle leftLegPose);


    /**
     * Gets the right leg pose of the armor stand.
     *
     * @return The pose of the right leg.
     */
    EulerAngle getRightLegPose();

    /**
     * Sets the right leg pose of the armor stand.
     *
     * @param rightLegPose The pose of the right leg.
     * @return The pose modifier.
     */
    PoseModifier setRightLegPose(EulerAngle rightLegPose);


    /**
     * Updates the pose of the armor stand.
     */
    void updatePose();
}