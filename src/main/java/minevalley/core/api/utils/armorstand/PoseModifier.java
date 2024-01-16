package minevalley.core.api.utils.armorstand;

import org.bukkit.util.EulerAngle;

public interface PoseModifier {

    void queueHeadPose(float yaw, float pitch);

    void queueHeadPose(EulerAngle headPose);

    void queueLeftArmPose(EulerAngle leftArmPose);

    void queueRightArmPose(EulerAngle rightArmPose);

    void queueBodyPose(EulerAngle bodyPose);

    void queueLeftLegPose(EulerAngle leftLegPose);

    void queueRightLegPose(EulerAngle rightLegPose);

    void updatePose();
}