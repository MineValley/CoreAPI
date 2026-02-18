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
     * Checks if the armor stand has a baseplate
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @return true if the armor stand has a baseplate
     */
    @Deprecated
    @Contract(pure = true)
    boolean hasBasePlate();

    /**
     * Sets if the armor stand has a baseplate
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @param basePlate true if the armor stand has a baseplate
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setBasePlate(boolean basePlate);

    /**
     * Checks if the armor stand is small
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @return true if the armor stand is small
     */
    @Contract(pure = true)
    boolean isSmall();

    /**
     * Sets if the armor stand is small
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
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
     * <p>
     *     <b>Note:</b>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @return true if the armor stand has arms
     */
    @Contract(pure = true)
    boolean hasArms();

    /**
     * Sets if the armor stand has arms
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @param arms true if the armor stand should have arms
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setArms(boolean arms);

    /**
     * Checks if the armor stand is a marker
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @return true if the armor stand is a marker
     */
    boolean isMarker();

    /**
     * Sets if the armor stand is a marker
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @param marker true if the armor stand should be a marker
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setMarker(boolean marker);

    /**
     * Checks if the armor stand is on fire
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This only affects the visual effect, not actual fire damage. This can only be changed via {@link #setOnFire(boolean)} not by setting the 'entity' on fire.</li>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @return true if the armor stand is on fire
     */
    @Contract(pure = true)
    boolean isOnFire();

    /**
     * Sets if the armor stand is on fire
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This only affects the visual effect, not actual fire damage. This can only be changed via {@link #setOnFire(boolean)} not by setting the 'entity' on fire.</li>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @param onFire true if the armor stand should be on fire
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setOnFire(boolean onFire);

    /**
     * Checks if the armor stand is invisible
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This only affects the visual effect, not actual visibility to players as in {@link VisibilityModifier}</li>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @return true if the armor stand is invisible
     */
    boolean isInvisible();

    /**
     * Sets if the armor stand is visible
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This only affects the visual effect, not actual visibility to players as in {@link VisibilityModifier}</li>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @param invisible true if the armor stand should be visible
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    FakeArmorStand setInvisible(boolean invisible);

    /**
     * Checks if the armor stand is glowing
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
     *
     * @return true if the armor stand is glowing
     */
    boolean isGlowing();

    /**
     * Sets if the armor stand is glowing
     *
     * <p>
     *     <b>Note:</b>
     *     <li>This setting is part of the metadata and is only applied when metadata is updated via {@link MetadataModifier}.</li>
     * </p>
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
