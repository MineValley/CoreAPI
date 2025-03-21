package minevalley.core.api.displays;

import minevalley.core.api.modifiers.InteractionModifier;
import minevalley.core.api.modifiers.LocationModifier;
import minevalley.core.api.modifiers.ScaleModifier;
import minevalley.core.api.modifiers.VisibilityModifier;
import org.bukkit.Location;

import javax.annotation.Nonnull;

public interface Display extends InteractionModifier, LocationModifier, ScaleModifier, VisibilityModifier  {

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
    LocationModifier setLocation(@Nonnull Location location);
}
