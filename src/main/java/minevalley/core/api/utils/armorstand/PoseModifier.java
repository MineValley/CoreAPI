package minevalley.core.api.utils.armorstand;

import org.bukkit.util.EulerAngle;

public interface PoseModifier {

    PoseModifier queueHeadPose(float yaw, float pitch);

    PoseModifier queueHeadPose(EulerAngle headPose);

    PoseModifier queueLeftArmPose(EulerAngle leftArmPose);

    PoseModifier queueRightArmPose(EulerAngle rightArmPose);

    PoseModifier queueBodyPose(EulerAngle bodyPose);

    PoseModifier queueLeftLegPose(EulerAngle leftLegPose);

    PoseModifier queueRightLegPose(EulerAngle rightLegPose);

    void updatePose();
}