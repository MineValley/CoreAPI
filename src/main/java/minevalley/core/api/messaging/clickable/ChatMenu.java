package minevalley.core.api.messaging.clickable;

import minevalley.core.api.messaging.MessageReceiver;
import org.jetbrains.annotations.Contract;

/**
 * The {@code ChatMenu} is an interface that represents a chat menu that was sent to a {@link MessageReceiver}.
 * It is used to determine if the menu is still enabled or not and to disable it manually. Doing so prevents unwanted inputs and is therefor recommended when the menu is no longer needed.
 */
@SuppressWarnings("unused")
public interface ChatMenu {

    /**
     * Checks if the menu is still enabled.
     * <p>
     * <b>Note:</b> ChatMenus will only be disabled if a {@link ClickableOption} was clicked that is marked as single-use or {@link #disable()} is called on this menu.
     *
     * @return true if the menu is still enabled, false otherwise
     * @see #disable()
     */
    @Contract(pure = true)
    boolean isEnabled();

    /**
     * Disables the menu. This prevents any further input from the user.
     * <p>
     * <b>Note:</b> After disabling the menu, it is not possible to re-enable it. If menu is disabled, this method will do nothing.
     *
     * @see #isEnabled()
     */
    void disable();
}
