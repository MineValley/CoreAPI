package minevalley.core.api.utils;

import lombok.Setter;
import minevalley.core.api.users.OnlineUser;

public final class ChatHandler {

    @Setter
    private static Manager manager;

    public static void chat(OnlineUser user, OnlineUser.ChatType chatType, String text) {
        manager.chat(user, chatType, text);
    }

    public interface Manager {
        void chat(OnlineUser user, OnlineUser.ChatType chatType, String text);
    }
}