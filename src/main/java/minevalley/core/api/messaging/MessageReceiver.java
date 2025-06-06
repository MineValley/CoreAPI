package minevalley.core.api.messaging;

import minevalley.core.api.messaging.clickable.ChatMenu;
import minevalley.core.api.messaging.clickable.ClickableOption;
import minevalley.core.api.messaging.colors.CustomColor;
import minevalley.core.api.messaging.instruction.Instruction;
import minevalley.core.api.messaging.types.ActionBarType;
import minevalley.core.api.messaging.types.MessageType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;

import javax.annotation.Nonnull;
import java.time.Duration;

/**
 * This interface is meant to simplify and standardize the way messages are sent to players.
 * It's extended by other interfaces representing one or a group of users. This way a lot of boilerplate code (e.g. for-loops, streams and if-clauses) is omitted.
 * <p>
 * Using the {@link ComponentLike} object enables a lot of features given by the Adventure API as used in Paper.
 * While having a lot of features, most of the messages (that were formally sent as {@link String} objects) can be sent as a {@link TextComponent} via:
 * <pre>
 *     {@code
 *     receiver.sendMessage(Component.text("Hello World!"));
 *     }
 * </pre>
 * There is a great documentation covering everything you need to know about {@link Component}, {@link TextComponent} and {@link ComponentLike} in the <a href="https://docs.advntr.dev/text.html">Adventure API documentation</a>.
 * <p>
 * The {@link Instruction} object is used to send instructions to the user. It can be sent in two ways:
 * <ul>
 *     <li>It can be sent without any additional information resulting in the user receiving a message in the chat containing the text specified in the instruction.</li>
 *     <li>It can also be added to other messages (see {@link #sendMessage(ComponentLike, Instruction)}). The instruction then shows up as a little question mark that prints the instruction text when clicked.</li>
 * </ul>
 * In both cases the user is able to hide the instruction by clicking a button that is added automatically.
 * Doing so, the instruction will not show up in any circumstance (neither as question mark nor as a message in the chat).
 * <p>
 * <b>Note:</b> The instruction id has to be unique (consider adding the feature- oder module name as a prefix to the id to prevent duplicates) and should not be changed afterward.
 * <p>
 * Another addition to chat messages are {@link ClickableOption} objects. They are used to create menus that can be displayed to the user.
 * Those are displayed underneath the message and can be used to trigger actions. They are displayed as buttons and can be used to trigger actions.
 * <p>
 * Always give the user a clear description of what the buttons do. The user should be able to understand what happens when clicking a button without having to click it first. A useful hover text can enhance the user experience.
 * <p>
 * <b>Note:</b> The {@link ClickableOption} allows to enable single use. This means that the user can only use the button once.
 * This does not only mean that the user can only use the button once, but also that if the button was clicked once, all buttons of that message (including the clicked one) are disabled.
 * <p>
 * All methods accepting {@link ClickableOption} objects return a {@link ChatMenu} object that can be used to disable the menu manually.
 *
 * @see Instruction
 * @see ClickableOption
 * @see Component
 * @see TextComponent
 * @see ComponentLike
 */
@SuppressWarnings("unused")
public interface MessageReceiver {

    /**
     * Displays the given message in the receivers action bar.
     *
     * @param message the message to send
     * @throws IllegalArgumentException if the message is null
     */
    void sendActionBar(@Nonnull ComponentLike message) throws IllegalArgumentException;

    /**
     * Displays the given message in the receivers action bar.
     *
     * @param type    the type of message (defines the prefix)
     * @param message the message to send
     * @throws IllegalArgumentException if the type or message is null
     */
    void sendActionBar(@Nonnull ActionBarType type, @Nonnull ComponentLike message) throws IllegalArgumentException;

    /**
     * Displays the given message in the receivers action bar.
     * <p>
     * <b>Note:</b> When using Strings no color is needed/allowed!
     * </p>
     *
     * @param type    the type of message (defines the prefix)
     * @param message the message to send
     * @throws IllegalArgumentException if the type or message is null
     */
    default void sendActionBar(@Nonnull ActionBarType type, @Nonnull String message) throws IllegalArgumentException {
        sendActionBar(type, Component.text(message, NamedTextColor.GRAY));
    }

    /**
     * Sends an instruction to the receiver.
     *
     * @param instruction the instruction to send
     * @throws IllegalArgumentException if the instruction is null
     */
    void sendInstruction(@Nonnull Instruction instruction) throws IllegalArgumentException;

    /**
     * Sends a message to the receiver.
     *
     * @param message the message to send
     * @throws IllegalArgumentException if the message is null
     */
    void sendMessage(@Nonnull ComponentLike message) throws IllegalArgumentException;

    /**
     * Sends a message to the receiver.
     *
     * @param message     the message to send
     * @param instruction the instruction to send
     * @throws IllegalArgumentException if the message or instruction is null
     */
    void sendMessage(@Nonnull ComponentLike message, @Nonnull Instruction instruction) throws IllegalArgumentException;

    /**
     * Sends a message to the receiver.
     * <p>
     * <b>Note:</b> When using ComponentLike the MessageType-color is not applied and has to be added manually!
     * </p>
     *
     * @param type    the type of message
     * @param message the message to send
     * @throws IllegalArgumentException if the type or message is null
     * @see CustomColor
     */
    void sendMessage(@Nonnull MessageType type, @Nonnull ComponentLike message) throws IllegalArgumentException;

    /**
     * Sends a message to the receiver.
     * <p>
     * <b>Note:</b> When using Strings no color is needed/allowed!
     * </p>
     *
     * @param type    the type of message
     * @param message the message to send
     * @throws IllegalArgumentException if the type or message is null
     */
    default void sendMessage(@Nonnull MessageType type, @Nonnull String message) throws IllegalArgumentException {
        sendMessage(type, Component.text(message, type.getMessageColor()));
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
     * @throws IllegalArgumentException if the type, message or instruction is null
     * @see CustomColor
     */
    void sendMessage(@Nonnull MessageType type, @Nonnull ComponentLike message, @Nonnull Instruction instruction)
            throws IllegalArgumentException;

    /**
     * Sends a message to the receiver.
     * <p>
     * <b>Note:</b> When using Strings no color is needed/allowed!
     * </p>
     *
     * @param type        the type of message
     * @param message     the message to send
     * @param instruction the instruction to send
     * @throws IllegalArgumentException if the type, message or instruction is null
     */
    default void sendMessage(@Nonnull MessageType type, @Nonnull String message, @Nonnull Instruction instruction)
            throws IllegalArgumentException {
        sendMessage(type, Component.text(message, type.getMessageColor()), instruction);
    }

    /**
     * Shows a title to the receiver.
     *
     * @param title    the title to show
     * @param subtitle the subtitle to show
     * @throws IllegalArgumentException if the title or subtitle is null
     */
    void showTitle(@Nonnull Component title, @Nonnull Component subtitle) throws IllegalArgumentException;

    /**
     * Shows a title to the receiver.
     *
     * @param title    the title to show
     * @param subtitle the subtitle to show
     * @param fadeIn   the time in ticks for the title to fade in
     * @param stay     the time in ticks for the title to stay
     * @param fadeOut  the time in ticks for the title to fade out
     * @throws IllegalArgumentException if the title or subtitle is null
     */
    void showTitle(@Nonnull Component title, @Nonnull Component subtitle, @Nonnull Duration fadeIn,
                   @Nonnull Duration stay, @Nonnull Duration fadeOut) throws IllegalArgumentException;
}
