package minevalley.core.api.localization;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface PlayerLocation {

    /**
     * Gets the name of this player location, that may be used to be displayed in the user's tab list.
     *
     * @return name as string
     */
    @Nonnull
    String toString();
}