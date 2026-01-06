package minevalley.core.api.armorstand;

import minevalley.core.api.armorstand.modifiers.MetadataModifier;
import minevalley.core.api.armorstand.modifiers.PassengerModifier;
import minevalley.core.api.armorstand.modifiers.PoseModifier;
import minevalley.core.api.armorstand.modifiers.RotationModifier;
import minevalley.core.api.modifiers.EquipmentModifier;
import minevalley.core.api.modifiers.InteractionModifier;
import minevalley.core.api.modifiers.LocationModifier;
import minevalley.core.api.modifiers.VisibilityModifier;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface FakeArmorStand extends MetadataModifier<FakeArmorStand>, PassengerModifier<FakeArmorStand>,
        PoseModifier<FakeArmorStand>, RotationModifier<FakeArmorStand>, EquipmentModifier<FakeArmorStand>,
        InteractionModifier<FakeArmorStand>, LocationModifier<FakeArmorStand>, VisibilityModifier<FakeArmorStand> {

    /**
     * Get the custom id from the armor stand
     *
     * @return id as int
     */
    @Contract(pure = true)
    int getId();

    /**
     * Spawns the armor stand
     */
    void spawn();

    /**
     * Destroys/de-spawn the armor stand
     * <br>
     * <b>Note:</b> Armor stand can be simply respawned with {@link #spawn()}
     */
    void destroy();

    /**
     * Gets the visibility range of the armor stand
     *
     * @return range in blocks
     */
    @Nonnegative
    int getVisibilityRange();

    /**
     * Sets the visibility range of the armor stand
     * <br>
     * <b>Default:</b> 50
     *
     * @param visibilityRange range in blocks
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setVisibilityRange(int visibilityRange);
}
