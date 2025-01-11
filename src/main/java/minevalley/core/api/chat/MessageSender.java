package minevalley.core.api.chat;

import minevalley.core.api.chat.clickable.ChatMenu;
import minevalley.core.api.chat.clickable.ClickableOption;
import minevalley.core.api.chat.instruction.Instruction;
import minevalley.core.api.utils.ClickableMessage;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface MessageSender {

    /**
     * Sends a message to a receiver.
     *
     * @param receiver receiver to send the message to
     * @param message  message to send
     * @throws IllegalArgumentException if the receiver or message is null
     */
    void send(@Nonnull MessageReceiver receiver, @Nonnull ComponentLike message) throws IllegalArgumentException;

    /**
     * Sends a message to a receiver with an instruction.
     *
     * @param receiver    receiver to send the message to
     * @param message     message to send
     * @param instruction instruction to send
     * @throws IllegalArgumentException if the receiver, message or instruction is null
     */
    void send(@Nonnull MessageReceiver receiver, @Nonnull ComponentLike message, @Nonnull Instruction instruction) throws IllegalArgumentException;

    /**
     * Sends a message to a receiver with a menu.
     *
     * @param receiver receiver to send the message to
     * @param message  message to send
     * @param menu     menu to send
     * @return the chat menu
     * @throws IllegalArgumentException if the receiver, message or menu is null
     */
    @Nonnull
    @Contract("_, _, _ -> new")
    ChatMenu send(@Nonnull MessageReceiver receiver, @Nonnull ComponentLike message, @Nonnull ClickableOption... menu) throws IllegalArgumentException;

    /**
     * Sends a message to a receiver with an instruction and a menu.
     *
     * @param receiver    receiver to send the message to
     * @param message     message to send
     * @param instruction instruction to send
     * @param menu        menu to send
     * @return the chat menu
     * @throws IllegalArgumentException if the receiver, message, instruction or menu is null
     */
    @Nonnull
    @Contract("_, _, _, _ -> new")
    ChatMenu send(@Nonnull MessageReceiver receiver, @Nonnull ComponentLike message, @Nonnull Instruction instruction, @Nonnull ClickableMessage... menu) throws IllegalArgumentException;
}
