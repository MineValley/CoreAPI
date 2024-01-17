package minevalley.core.api.utils.armorstand;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.utils.armorstand.modifiers.*;

import java.util.function.BiConsumer;

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
