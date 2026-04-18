package eu.minevalley.core.api.user.event.messaging.clickable;

import eu.minevalley.core.api.user.ProxyUser;
import eu.minevalley.core.api.user.event.ProxyUserEvent;
import lombok.Getter;

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