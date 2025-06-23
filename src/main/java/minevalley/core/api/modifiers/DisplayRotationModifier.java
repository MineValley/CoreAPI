package minevalley.core.api.modifiers;

import org.joml.AxisAngle4f;

@SuppressWarnings("unused")
public interface DisplayRotationModifier {

    /**
     * Set the rotation left
     *
     * @param leftRotation the rotation left
     * @return the current instance
     */
    DisplayRotationModifier setLeftRotation(AxisAngle4f leftRotation);

    /**
     * Set the rotation right
     *
     * @param rightRotation the rotation right
     * @return the current instance
     */
    DisplayRotationModifier setRightRotation(AxisAngle4f rightRotation);

    /**
     * Update the rotation
     */
    void updateRotation();
}
