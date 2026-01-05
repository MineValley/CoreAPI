package minevalley.core.api.displays;

import minevalley.core.api.modifiers.*;
import org.bukkit.Location;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

public interface Display extends InteractionModifier, LocationModifier, RotationModifier, ScaleModifier, TranslationModifier, VisibilityModifier  {

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
    LocationModifier setLocation(@Nonnull Location location);
}
