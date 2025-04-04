package minevalley.core.api.command;

import lombok.Getter;
import minevalley.core.api.messaging.colors.CustomColor;
import minevalley.core.api.messaging.types.MessageType;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.Nonnull;

/**
 * Represents a response to a command.
 * <p>
 * This is used to send a message back to the user who executed the command.
 * There is no way not to send a message, this is designed so the user always gets feedback for their action.
 * </p>
 */
@Getter
@ApiStatus.NonExtendable
@SuppressWarnings("unused")
public final class CommandResponse {

    /**
     * The type of message to send.
     * <p>
     * Most of the time this will either be {@link MessageType#SUCCESS} or {@link MessageType#ERROR}.
     * </p>
     *
     * @see MessageType
     */
    public final @Nonnull MessageType type;

    /**
     * The message to send.
     * <p>
     * <b>Note:</b> When using styling, keep in mind to use the default chat colors {@link CustomColor#CHAT_SUCCESS} and {@link CustomColor#CHAT_ERROR} for success and error messages respectively.
     * </p>
     *
     * @see CustomColor
     */
    public final @Nonnull Component message;

    /**
     * Creates a new command response.
     *
     * @param type    The type of message to send.
     * @param message The message to send (Use chat colors respectively).
     * @throws IllegalArgumentException if type or message is null
     */
    public CommandResponse(@Nonnull MessageType type, @Nonnull Component message) throws IllegalArgumentException {
        if (type == null) throw new IllegalArgumentException("MessageType cannot be null");
        if (message == null) throw new IllegalArgumentException("Message cannot be null");
        this.type = type;
        this.message = message;
    }

    /**
     * Creates a new command response.
     *
     * @param type    The type of message to send.
     * @param message The message to send (no color codes needed/allowed).
     * @throws IllegalArgumentException if type or message is null
     */
    public CommandResponse(@Nonnull MessageType type, @Nonnull String message) throws IllegalArgumentException {
        this(type, Component.text(message));
    }
}