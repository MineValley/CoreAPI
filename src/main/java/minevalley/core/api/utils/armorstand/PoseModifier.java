package minevalley.core.api.utils.armorstand;

import org.bukkit.util.EulerAngle;

public interface PoseModifier {

    void setLeftArmPose(EulerAngle leftArmPose);

    void setRightArmPose(EulerAngle rightArmPose);

    void setLeftLegPose(EulerAngle leftLegPose);

    void setRightLegPose(EulerAngle rightLegPose);

    void setBodyPose(EulerAngle bodyPose);
}