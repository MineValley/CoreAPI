package minevalley.core.api.modifiers;

import minevalley.core.api.users.OnlineUser;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.function.Function;

@SuppressWarnings("unused")
public interface VisibilityModifier {

    /**
     * Shows this object to everyone who can see it.
     * <p>
     * <b>Note:</b>
     * <ul>
     *     <li>Objects are by default visible when created (no need to call this method, if the object was not hidden actively before)</li>
     *     <li>Hidden objects can be modified (lines of holograms, name of npc, ...). Changes will be visible after calling show()</li>
     * </ul>
     *
     * @throws IllegalStateException if the object is already visible
     * @see #isVisible()
     */
    @Nonnull
    @Contract(" -> this")
    VisibilityModifier show() throws IllegalStateException;

    /**
     * Hide this object from everyone who can see it.
     * <p>
     * <b>Note:</b>
     * <ul>
     *     <li>Hiding objects removes them completely and for everyone from the map</li>
     *     <li>Hiding is not permanent: Objects can be made visible again by calling {@link #show()}</li>
     *     <li>Hidden objects can be modified (lines of holograms, name of npc, ...). Changes will be visible after calling show()</li>
     * </ul>
     *
     * @throws IllegalStateException if the object is already hidden
     * @see #isVisible()
     */
    @Nonnull
    @Contract(" -> this")
    VisibilityModifier hide() throws IllegalStateException;

    /**
     * Returns whether this object is visible
     *
     * @return true if this object is visible, false otherwise
     */
    @Contract(pure = true)
    boolean isVisible();

    /**
     * Defines who can see this object.
     * <p>
     * <b>Note:</b>
     * <ul>
     *     <li>Setting the visibility replaces the previous visibility function</li>
     *     <li>Objects are only visible if {@link #isVisible()} is true (which is the default state)</li>
     * </ul>
     * <br>
     * <b>Default:</b> Everyone can see this object
     *
     * @param visibility defines whether a specific user can see this object
     * @throws IllegalArgumentException if visibility is null
     * @see #isVisible()
     */
    @Nonnull
    @Contract("_ -> this")
    VisibilityModifier setVisibility(@Nonnull Function<OnlineUser, Boolean> visibility) throws IllegalArgumentException;

    /**
     * Sets the visibility of this object to everyone.
     */
    @Nonnull
    @Contract(" -> this")
    default VisibilityModifier setVisibleToEveryone() {
        return setVisibility(user -> true);
    }

    /**
     * Updates the visibility of this object
     * <p>
     * <b>Note:</b> This simply calls the function defined in {@link #setVisibility(Function)} for every user that this object is or could be visible to
     */
    void updateVisibility();

    /**
     * Updates the visibility of this object for a specific user
     * <p>
     * <b>Note:</b> This simply calls the function defined in {@link #setVisibility(Function)} for this user
     *
     * @param user to update the visibility for
     * @throws IllegalArgumentException if user is null
     */
    void updateVisibility(@Nonnull OnlineUser user) throws IllegalArgumentException;
}
