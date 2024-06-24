package minevalley.core.api.armorstand;

import minevalley.core.api.armorstand.modifiers.*;
import minevalley.core.api.users.OnlineUser;

import java.util.function.BiConsumer;

public interface FakeArmorStand extends EquipmentModifier, LocationModifier, MetadataModifier, PassengerModifier,
        PoseModifier, RotationModifier, VisibilityModifier {

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
     * <br>
     * <b>Default:</b> 50
     *
     * @param visibilityRange range in blocks
     */
    void setVisibilityRange(int visibilityRange);

    void onClick(BiConsumer<OnlineUser, InteractType> consumer);

    enum InteractType {
        LEFT_CLICK, RIGHT_CLICK;
    }
}
