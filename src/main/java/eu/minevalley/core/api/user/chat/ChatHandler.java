package eu.minevalley.core.api.user.chat;

import eu.minevalley.core.api.Depends;
import eu.minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

@Depends("ChatLag")
public interface ChatHandler {

    void chat(@Nonnull ProxyUser user, @Nonnull ChatType type, @Nonnull String text) throws IllegalArgumentException;
}
