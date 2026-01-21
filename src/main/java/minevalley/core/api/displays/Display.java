package minevalley.core.api.displays;

import minevalley.core.api.modifiers.*;
import org.bukkit.Location;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

public interface Display<T extends Display<T>> extends
        InteractionModifier<T>, LocationModifier<T>, MetadataModifier<T>, PassengerModifier<T>,
        RotationModifier<T>, ScaleModifier<T>, TranslationModifier<T>, VisibilityModifier<T> {

    /**
     * Set the location of the display
     *
     * <br>
     * <b>Note:</b> This does not ignore the yaw and pitch values.
     *
     * @param location the location
     * @return the current instance
     */
    @Override
    @Nonnull
    @Contract("_ -> this")
    T setLocation(@Nonnull Location location);
}
