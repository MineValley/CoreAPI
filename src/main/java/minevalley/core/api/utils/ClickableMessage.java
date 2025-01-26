package minevalley.core.api.utils;

import minevalley.core.api.users.OnlineUser;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface ClickableMessage {

    /**
     * Defines if this clickable message gets disabled automatically when the player clicks it.
     *
     * @param isSelfCancelling boolean that defines if this clickable message is self cancelling
     * @return this clickable message
     */
    @Nonnull
    @Contract("_ -> this")
    ClickableMessage selfCancelling(boolean isSelfCancelling);

    /**
     * Defines the callback which is called when the player clicks this message.
     *
     * @param runnable will be called if the player clicks the message
     * @return runnable
     */
    @Nonnull
    @Contract("_ -> this")
    ClickableMessage setCallback(@Nonnull Runnable callback);

    /**
     * Disables this clickable message
     */
    void disable();

    /**
     * Gets the command which executes the callback. Put this into the click-event of your component-builder.
     *
     * @return the command as string
     */
    @Nonnull
    String getCommand();

    /**
     * Gets the user who this clickable message is made for.
     *
     * @return the user who this clickable message is made for
     */
    @Nonnull
    OnlineUser getUser();
}