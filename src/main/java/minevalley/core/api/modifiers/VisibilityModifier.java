package minevalley.core.api.modifiers;

import minevalley.core.api.users.OnlineUser;

import java.util.function.Function;

@SuppressWarnings("unused")
public interface VisibilityModifier {

    /**
     * Defines who can see this object
     * <br>
     * <b>Default:</b> Everyone can see this object
     *
     * @param function defines whether a specific user can see this object
     */
    void setVisibility(Function<OnlineUser, Boolean> function);

    /**
     * Updates the visibility of this object
     * <br>
     * <b>Note:</b> This simply calls the function defined in {@link #setVisibility(Function)} for every user that this object is or could be visible to
     */
    void updateVisibility();

    /**
     * Updates the visibility of this object for a specific user
     * <br>
     * <b>Note:</b> This simply calls the function defined in {@link #setVisibility(Function)} for this user
     *
     * @param user to update the visibility for
     */
    void updateVisibility(OnlineUser user);
}
