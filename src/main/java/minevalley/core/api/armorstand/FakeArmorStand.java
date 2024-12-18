package minevalley.core.api.armorstand;

import minevalley.core.api.armorstand.modifiers.MetadataModifier;
import minevalley.core.api.armorstand.modifiers.PassengerModifier;
import minevalley.core.api.armorstand.modifiers.PoseModifier;
import minevalley.core.api.armorstand.modifiers.RotationModifier;
import minevalley.core.api.modifiers.EquipmentModifier;
import minevalley.core.api.modifiers.InteractionModifier;
import minevalley.core.api.modifiers.LocationModifier;
import minevalley.core.api.modifiers.VisibilityModifier;

public interface FakeArmorStand extends MetadataModifier, PassengerModifier, PoseModifier, RotationModifier,
        EquipmentModifier, InteractionModifier, LocationModifier, VisibilityModifier {

    /**
     * Get the custom id from the armorstand
     *
     * @return id as int
     */
    int getId();

    /**
     * Spawns the armorstand
     */
    void spawn();

    /**
     * Destroys/de-spawn the armorstand
     * <br>
     * <b>Note:</b> Armorstand can be simply respawned with {@link #spawn()}
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
     * <br>
     * <b>Default:</b> 50
     *
     * @param visibilityRange range in blocks
     */
    void setVisibilityRange(int visibilityRange);
}
