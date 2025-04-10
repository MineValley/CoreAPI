package minevalley.core.api.commands;

import lombok.Getter;
import minevalley.core.api.gui.InventoryGui;
import minevalley.core.api.messaging.types.MessageType;
import minevalley.core.api.users.OnlineUser;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

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

    private final Consumer<OnlineUser> response;

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
        response = user -> user.sendMessage(type, message);
    }

    /**
     * Creates a new command response.
     *
     * @param type    The type of message to send.
     * @param message The message to send (no color codes needed/allowed).
     * @throws IllegalArgumentException if type or message is null
     */
    public CommandResponse(@Nonnull MessageType type, @Nonnull String message) throws IllegalArgumentException {
        this(type, Component.text(message, type.getMessageColor()));
    }

    /**
     * Creates a new command response.
     *
     * @param gui The GUI to open.
     * @throws IllegalArgumentException if gui is null
     */
    public CommandResponse(@Nonnull InventoryGui gui) throws IllegalArgumentException {
        if (gui == null) throw new IllegalArgumentException("GUI cannot be null");
        this.response = gui::open;
    }
}