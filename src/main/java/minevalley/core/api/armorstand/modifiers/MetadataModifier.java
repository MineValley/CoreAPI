package minevalley.core.api.armorstand.modifiers;

import minevalley.core.api.modifiers.VisibilityModifier;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
public interface MetadataModifier<T extends MetadataModifier<T>> {

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
    T setBasePlate(boolean baseplate);

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
    T setSmall(boolean small);

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
    T setArms(boolean arms);

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
    T setMarker(boolean marker);

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
    T setOnFire(boolean onFire);

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
    T setVisible(boolean visible);

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
    T setGlowing(boolean glowing);

    /**
     * Checks if the armor stand is affected by gravity
     *
     * @return true if the armor stand is affected by gravity
     */
    boolean hasGravity();

    /**
     * Sets if the armor stand is affected by gravity
     *
     * @param gravity true if the armor stand should be affected by gravity
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setGravity(boolean gravity);

    /**
     * Gets the custom name of the armor stand, if existing
     *
     * @return custom name of the armor stand
     */
    @Nullable
    String getCustomName();

    /**
     * Sets the custom name of the armor stand
     *
     * @param customName custom name of the armor stand
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setCustomName(@Nullable String customName);

    /**
     * Checks if the custom name is visible
     *
     * @return true if the custom name is visible
     */
    boolean isCustomNameVisible();

    /**
     * Sets if the custom name is visible
     *
     * @param customNameVisible true if the custom name should be visible
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setCustomNameVisible(boolean customNameVisible);

    /**
     * Checks if the armor stand is silent
     *
     * @return true if the armor stand is silent
     */
    boolean isSilent();

    /**
     * Sets if the armor stand is silent
     *
     * @param silent true if the armor stand should be silent
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setSilent(boolean silent);

    /**
     * Updates the metadata of the armor stand
     */
    void updateMetadata();
}
