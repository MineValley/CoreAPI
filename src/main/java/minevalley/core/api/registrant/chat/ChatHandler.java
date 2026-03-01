package minevalley.core.api.registrant.chat;

import minevalley.core.api.Depends;
import minevalley.core.api.registrant.ProxyUser;

import javax.annotation.Nonnull;

@Depends("ChatLag")
public interface ChatHandler {

    void chat(@Nonnull ProxyUser user, @Nonnull ChatType type, @Nonnull String text) throws IllegalArgumentException;
}
