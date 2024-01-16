package minevalley.core.api.utils.armorstand;

import org.bukkit.util.EulerAngle;

public interface PoseModifier {

    void queueLeftArmPose(EulerAngle leftArmPose);

    void queueRightArmPose(EulerAngle rightArmPose);

    void queueLeftLegPose(EulerAngle leftLegPose);

    void queueRightLegPose(EulerAngle rightLegPose);

    void queueBodyPose(EulerAngle bodyPose);

    void updatePose();
}