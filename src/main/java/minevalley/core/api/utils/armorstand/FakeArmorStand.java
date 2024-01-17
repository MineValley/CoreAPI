package minevalley.core.api.utils.armorstand;

import minevalley.core.api.utils.armorstand.modifiers.*;

public interface FakeArmorStand extends EquipmentModifier, LocationModifier, MetadataModifier, PassengerModifier,
        PoseModifier, VisibilityModifier {

    /**
     * get the custom id from the armorstand
     *
     * @return int
     */
    int getId();

    /**
     * Spawns the armorstand
     */
    void spawn();

    /**
     * Destroys/de-spawn the armorstand
     */
    void destroy();

    /**
     * Gets the visibility range of the armorstand
     *
     * @return range in blocks
     */
    int getVisibilityRange();

    /**
     * Sets the visibility range of the armorstand
     *
     * @param visibilityRange range in blocks
     */
    void setVisibilityRange(int visibilityRange);
}
