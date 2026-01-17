package minevalley.core.api.users.chat;

import lombok.Setter;
import minevalley.core.api.Depends;
import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;

@Depends("ChatLag")
public final class ChatProvider {

    @Setter
    private static volatile ChatHandler handler;

    /**
     * Sends a chat message as the specified user.
     *
     * @param user user sending the message
     * @param type type of the chat message
     * @param text message to send
     * @throws IllegalArgumentException if either the user, type or message is null, or if the message is empty
     */
    public static void chat(@Nonnull ProxyUser user, @Nonnull ChatType type, @Nonnull String text)
            throws IllegalArgumentException {
        handler.chat(user, type, text);
    }
}