package minevalley.core.api.armorstand;

import minevalley.core.api.modifiers.*;
import minevalley.core.api.utils.Passenger;
import minevalley.core.api.utils.Vehicle;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface FakeArmorStand extends
        Passenger, Vehicle, MetadataModifier<FakeArmorStand>, PassengerModifier<FakeArmorStand>,
        PoseModifier<FakeArmorStand>, EquipmentModifier<FakeArmorStand>, InteractionModifier<FakeArmorStand>,
        LocationModifier<FakeArmorStand>, VehicleModifier<FakeArmorStand>, VisibilityModifier<FakeArmorStand> {

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

    /**
     * Checks if the armor stand has a baseplate
     *
     * @return true if the armor stand has a baseplate
     * @see #hasBaseplate()
     */
    @Deprecated
    @Contract(pure = true)
    boolean hasBasePlate();

    /**
     * Checks if the armor stand has a baseplate
     *
     * @return true if the armor stand has a baseplate
     */
    @Contract(pure = true)
    boolean hasBaseplate();

    /**
     * Sets if the armor stand has a baseplate
     *
     * @param baseplate true if the armor stand has a baseplate
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setBasePlate(boolean baseplate);

    /**
     * Checks if the armor stand is small
     *
     * @return true if the armor stand is small
     */
    @Contract(pure = true)
    boolean isSmall();

    /**
     * Sets if the armor stand is small
     *
     * @param small true if the armor stand should be small
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setSmall(boolean small);

    /**
     * Checks if the armor stand has arms
     *
     * @return true if the armor stand has arms
     */
    @Contract(pure = true)
    boolean hasArms();

    /**
     * @param arms true if the armor stand should have arms
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setArms(boolean arms);

    /**
     * Checks if the armor stand is a marker
     *
     * @return true if the armor stand is a marker
     */
    boolean isMarker();

    /**
     * Sets if the armor stand is a marker
     *
     * @param marker true if the armor stand should be a marker
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setMarker(boolean marker);

    /**
     * Checks if the armor stand is on fire
     * <p>
     * <b>Note:</b> This only affects the visual effect, not actual fire damage. This can only be changed via {@link #setOnFire(boolean)} not by setting the 'entity' on fire.
     *
     * @return true if the armor stand is on fire
     */
    @Contract(pure = true)
    boolean isOnFire();

    /**
     * Sets if the armor stand is on fire
     *
     * @param onFire true if the armor stand should be on fire
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setOnFire(boolean onFire);

    /**
     * Checks if the armor stand is visible
     * <p>
     * <b>Note:</b> This only affects the visual effect, not actual visibility to players as in {@link VisibilityModifier}
     *
     * @return true if the armor stand is visible
     */
    boolean isVisible();

    /**
     * Sets if the armor stand is visible
     * <p>
     * <b>Note:</b> This only affects the visual effect, not actual visibility to players as in {@link VisibilityModifier}
     *
     * @param visible true if the armor stand should be visible
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setVisible(boolean visible);

    /**
     * Checks if the armor stand is glowing
     *
     * @return true if the armor stand is glowing
     */
    boolean isGlowing();

    /**
     * Sets if the armor stand is glowing
     *
     * @param glowing true if the armor stand should be glowing
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setGlowing(boolean glowing);

    /**
     * Gets the rotation of the armor stand in degrees
     *
     * @return the rotation of the armor stand
     */
    @Contract(pure = true)
    float getRotation();

    /**
     * Sets the rotation of the armor stand
     *
     * @param rotation rotation in degrees
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setRotation(float rotation);

    /**
     * Updates the rotation of the armor stand
     */
    void updateRotation();
}
