package minevalley.core.api.packet.modifiers;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
public interface MetadataModifier<T extends MetadataModifier<T>> {

    /**
     * Checks if the object is affected by gravity
     *
     * @return true if the object is affected by gravity
     */
    @Contract(pure = true)
    boolean hasGravity();

    /**
     * Sets if the object is affected by gravity
     *
     * @param gravity true if the object should be affected by gravity
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setGravity(boolean gravity);

    /**
     * Gets the custom name of the object, if existing
     *
     * @return custom name of the object
     */
    @Nullable
    @Contract(pure = true)
    Component getCustomName();

    /**
     * Sets the custom name of the object
     *
     * @param customName object of the armor stand
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setCustomName(@Nullable Component customName);

    /**
     * Checks if the custom name is visible
     *
     * @return true if the custom name is visible
     */
    @Contract(pure = true)
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
     * Checks if the object is silent
     *
     * @return true if the armor stand is silent
     */
    @Contract(pure = true)
    boolean isSilent();

    /**
     * Sets if the object is silent
     *
     * @param silent true if the object should be silent
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    T setSilent(boolean silent);

    /**
     * Updates the metadata of the object
     */
    void updateMetadata();
}
