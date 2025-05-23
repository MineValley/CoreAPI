package minevalley.core.api.messaging;

import minevalley.core.api.messaging.clickable.ChatMenu;
import minevalley.core.api.messaging.clickable.ClickableOption;
import minevalley.core.api.messaging.colors.CustomColor;
import minevalley.core.api.messaging.instruction.Instruction;
import minevalley.core.api.messaging.types.MessageType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public interface DialogReceiver {

    /**
     * Sends a message to the receiver.
     *
     * @param message the message to send
     * @param menu    the menu to send
     * @return the menu that was sent
     * @throws IllegalArgumentException if the message or menu is null
     */
    @Nonnull
    @Contract("_, _ -> new")
    ChatMenu sendMessage(@Nonnull ComponentLike message, @Nonnull ClickableOption... menu)
            throws IllegalArgumentException;

    /**
     * Sends a message to the receiver.
     *
     * @param message     the message to send
     * @param instruction the instruction to send
     * @param menu        the menu to send
     * @return the menu that was sent
     * @throws IllegalArgumentException if the message, instruction or menu is null
     */
    @Nonnull
    @Contract("_, _, _ -> new")
    ChatMenu sendMessage(@Nonnull ComponentLike message, @Nonnull Instruction instruction,
                         @Nonnull ClickableOption... menu) throws IllegalArgumentException;

    /**
     * Sends a message to the receiver.
     * <p>
     * <b>Note:</b> When using ComponentLike the MessageType-color is not applied and has to be added manually!
     * </p>
     *
     * @param type    the type of message
     * @param message the message to send
     * @param menu    the menu to send
     * @return the menu that was sent
     * @throws IllegalArgumentException if the type, message or menu is null
     * @see CustomColor
     */
    @Nonnull
    @Contract("_, _, _ -> new")
    ChatMenu sendMessage(@Nonnull MessageType type, @Nonnull ComponentLike message, @Nonnull ClickableOption... menu)
            throws IllegalArgumentException;

    /**
     * Sends a message to the receiver.
     * <p>
     * <b>Note:</b> When using Strings no color is needed/allowed!
     * </p>
     *
     * @param type    the type of message
     * @param message the message to send
     * @param menu    the menu to send
     * @return the menu that was sent
     * @throws IllegalArgumentException if the type, message or menu is null
     */
    @Nonnull
    @Contract("_, _, _ -> new")
    default ChatMenu sendMessage(@Nonnull MessageType type, @Nonnull String message, @Nonnull ClickableOption... menu)
            throws IllegalArgumentException {
        return sendMessage(type, Component.text(message, type.getMessageColor()), menu);
    }

    /**
     * Sends a message to the receiver.
     * <p>
     * <b>Note:</b> When using ComponentLike the MessageType-color is not applied and has to be added manually!
     * </p>
     *
     * @param type        the type of message
     * @param message     the message to send
     * @param instruction the instruction to send
     * @param menu        the menu to send
     * @return the menu that was sent
     * @throws IllegalArgumentException if the type, message, instruction or menu is null
     * @see CustomColor
     */
    @Nonnull
    @Contract("_, _, _, _ -> new")
    ChatMenu sendMessage(@Nonnull MessageType type, @Nonnull ComponentLike message, @Nonnull Instruction instruction,
                         @Nonnull ClickableOption... menu) throws IllegalArgumentException;

    /**
     * Sends a message to the receiver.
     * <p>
     * <b>Note:</b> When using Strings no color is needed/allowed!
     * </p>
     *
     * @param type        the type of message
     * @param message     the message to send
     * @param instruction the instruction to send
     * @param menu        the menu to send
     * @return the menu that was sent
     * @throws IllegalArgumentException if the type, message, instruction or menu is null
     */
    @Nonnull
    @Contract("_, _, _, _ -> new")
    default ChatMenu sendMessage(@Nonnull MessageType type, @Nonnull String message, @Nonnull Instruction instruction,
                                 @Nonnull ClickableOption... menu) throws IllegalArgumentException {
        return sendMessage(type, Component.text(message, type.getMessageColor()), instruction, menu);
    }

    /**
     * Sends a message to the receiver and waits for an input.
     * <p>
     * <b>Note:</b> When using Strings no color is needed/allowed!
     * </p>
     *
     * @param text     the text to send
     * @param callback the callback to call when the user inputs something
     * @throws IllegalArgumentException if the text or callback is null
     */
    void input(@Nonnull String text, @Nonnull Consumer<String> callback) throws IllegalArgumentException;

    /**
     * Sends a message to the receiver and waits for an input.
     * <p>
     * <b>Note:</b> When using Strings no color is needed/allowed!
     * </p>
     *
     * @param text        the text to send
     * @param instruction the instruction to send
     * @param callback    the callback to call when the user inputs something
     * @throws IllegalArgumentException if the text, instruction or callback is null
     */
    void input(@Nonnull String text, @Nonnull Instruction instruction, @Nonnull Consumer<String> callback)
            throws IllegalArgumentException;

    /**
     * Checks if the receiver is currently in a chat input.
     *
     * @return true if the receiver is in a chat input, false otherwise
     */
    @Contract(pure = true)
    boolean isInChatInput();

    /**
     * Leaves the current chat input.
     * <p>
     * If the receiver is not in a chat input, this method does nothing.
     */
    void leaveChatInput();
}
