package minevalley.core.api.utils;

import lombok.Setter;
import minevalley.core.api.users.OnlineUser;

import javax.annotation.Nonnull;

public final class ChatHandler {

    @Setter
    private static Manager manager;

    public static void chat(@Nonnull OnlineUser user, @Nonnull OnlineUser.ChatType chatType, @Nonnull String text) throws IllegalArgumentException {
        manager.chat(user, chatType, text);
    }

    public interface Manager {
        void chat(@Nonnull OnlineUser user, @Nonnull OnlineUser.ChatType chatType, @Nonnull String text) throws IllegalArgumentException;
    }
}