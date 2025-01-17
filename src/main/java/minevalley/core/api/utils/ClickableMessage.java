package minevalley.core.api.utils;

import minevalley.core.api.users.OnlineUser;

@SuppressWarnings("unused")
public interface ClickableMessage {

    /**
     * Disables this clickable message
     */
    void disable();

    /**
     * Defines if this clickable message gets disabled automatically when the player clicks it.
     *
     * @param isSelfCancelling boolean that defines if this clickable message is self cancelling
     * @return this clickable message
     */
    ClickableMessage selfCancelling(boolean isSelfCancelling);

    /**
     * Defines the callback which is called when the player clicks this message.
     *
     * @param runnable will be called if the player clicks the message
     * @return runnable
     */
    ClickableMessage setCallback(Runnable runnable);

    /**
     * Gets the command which executes the callback. Put this into the click-event of your component-builder.
     *
     * @return the command as string
     */
    String getCommand();

    OnlineUser getUser();
}