package minevalley.core.api.chat.clickable;

import minevalley.core.api.chat.MessageReceiver;
import minevalley.core.api.users.OnlineUser;
import net.kyori.adventure.text.ComponentLike;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

/**
 * The {@code ClickableOption} is a record that represents a clickable option in a chat menu.
 * It contains the text to be displayed, the hover text, a flag indicating if it is a single-use option, and a callback function that is executed when the option is clicked.
 * If the option is single-use, not only the option itself is disabled, but also the entire {@link ChatMenu} is.
 *
 * @param text      text that is displayed in the chat menu and can be clicked (use color to make it distinguish it from normal text)
 * @param hoverText text that is displayed when the mouse hovers over the option
 * @param singleUse if true, the option can only be used once (and the entire {@link ChatMenu} is disabled when this specific option is clicked)
 * @param callback  function that is executed when the option is clicked
 * @see MessageReceiver
 * @see ChatMenu
 */
public record ClickableOption(@Nonnull ComponentLike text, @Nonnull String hoverText, boolean singleUse,
                              @Nonnull Consumer<OnlineUser> callback) {

    public ClickableOption {
        if (text == null) {
            throw new IllegalArgumentException("text must not be null");
        }
        if (hoverText == null) {
            throw new IllegalArgumentException("hoverText must not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
    }
}