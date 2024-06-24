package minevalley.core.api.armorstand;

import minevalley.core.api.armorstand.modifiers.*;
import minevalley.core.api.users.OnlineUser;

import java.util.function.BiConsumer;
import java.util.function.Function;

public interface FakeArmorStand extends EquipmentModifier, LocationModifier, MetadataModifier, PassengerModifier,
        PoseModifier, RotationModifier {

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

    /**
     * Defines the action when a player interacts with the armorstand
     *
     * @param consumer is called whenever a user interacts with the armorstand
     */
    void onClick(BiConsumer<OnlineUser, InteractType> consumer);

    /**
     * Defines which users can see the armorstand
     * <br>
     * <b>Default:</b> Everyone can see the armorstand
     *
     * @param function defines whether a specific user can see the armorstand
     */
    void isSeeing(Function<OnlineUser, Boolean> function);

    enum InteractType {
        LEFT_CLICK, RIGHT_CLICK
    }
}
