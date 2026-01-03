package minevalley.core.api.users.events.messaging.clickable;

import lombok.Getter;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;

import javax.annotation.Nonnull;

/**
 * This event is called when a user submits a clickable message choice.
 */
@SuppressWarnings("unused")
public class UserSubmitClickableMessageEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) String command;

    public UserSubmitClickableMessageEvent(@Nonnull ProxyUser user, @Nonnull String command) {
        super(user);
        this.command = command;
    }
}