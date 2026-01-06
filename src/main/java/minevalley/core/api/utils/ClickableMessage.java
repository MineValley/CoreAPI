package minevalley.core.api.utils;

import minevalley.core.api.users.ProxyUser;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface ClickableMessage {

    /**
     * Defines if this clickable message gets disabled automatically when the player clicks it.
     *
     * @param isSelfCancelling boolean that defines if this clickable message is self cancelling
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    ClickableMessage selfCancelling(boolean isSelfCancelling);

    /**
     * Defines the callback which is called when the player clicks this message.
     *
     * @param callback will be called if the player clicks the message
     * @return this
     */
    @Nonnull
    @Contract("_ -> this")
    ClickableMessage setCallback(@Nonnull Runnable callback) throws IllegalArgumentException;

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
    @Contract(pure = true)
    String getCommand();

    /**
     * Gets the user who this clickable message is made for.
     *
     * @return the user who this clickable message is made for
     */
    @Nonnull
    @Contract(pure = true)
    ProxyUser getUser();
}