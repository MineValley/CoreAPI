package minevalley.core.api.regions.utils;

import minevalley.core.api.users.OnlineUser;

import java.util.function.Function;

public interface FakeBlock {

    /**
     * Defines which users can see the fake block
     * <br>
     * <b>Default:</b> Everyone can see the fake block
     *
     * @param function defines whether a specific user can see the fake block
     */
    void setVisibility(Function<OnlineUser, Boolean> function);

    /**
     * Updates the visibility of the fake block
     * <br>
     * <b>Note:</b> This simply calls the function defined in {@link #setVisibility(Function)} for every user that the fake block is or could be visible to
     */
    void updateVisibility();

    /**
     * Updates the visibility of the fake block for a specific user
     * <br>
     * <b>Note:</b> This simply calls the function defined in {@link #setVisibility(Function)} for this user
     *
     * @param user to update the visibility for
     */
    void updateVisibility(OnlineUser user);
}