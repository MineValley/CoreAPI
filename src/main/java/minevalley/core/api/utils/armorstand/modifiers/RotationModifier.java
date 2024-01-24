package minevalley.core.api.utils.armorstand.modifiers;

public interface RotationModifier {

    /**
     * Sets the rotation of the armor stand
     *
     * @param rotation rotation in degrees
     * @return the rotation modifier
     */
    RotationModifier setRotation(float rotation);

    /**
     * Gets the rotation of the armor stand in degrees
     *
     * @return the rotation of the armor stand
     */
    float getRotation();

    /**
     * Updates the rotation of the armor stand
     */
    void updateRotation();
}
