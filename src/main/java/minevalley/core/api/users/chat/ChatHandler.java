package minevalley.core.api.users.chat;

import minevalley.core.api.Depends;
import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;

@Depends("ChatLag")
public interface ChatHandler {

    void chat(@Nonnull ProxyUser user, @Nonnull ChatType type, @Nonnull String text) throws IllegalArgumentException;
}
