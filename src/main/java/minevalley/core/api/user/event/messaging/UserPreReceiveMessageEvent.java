package minevalley.core.api.user.event.messaging;

import lombok.Getter;
import minevalley.core.api.user.ProxyUser;
import minevalley.core.api.user.event.ProxyUserEvent;
import net.kyori.adventure.text.Component;

import javax.annotation.Nonnull;

/**
 * This event is called when a message is to be sent to a user.
 */
@SuppressWarnings("unused")
public class UserPreReceiveMessageEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) Component message;

    public UserPreReceiveMessageEvent(@Nonnull ProxyUser user, @Nonnull Component message) {
        super(user);
        this.message = message;
    }
}