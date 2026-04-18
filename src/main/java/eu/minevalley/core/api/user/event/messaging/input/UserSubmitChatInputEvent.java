package eu.minevalley.core.api.user.event.messaging.input;

import eu.minevalley.core.api.user.ProxyUser;
import eu.minevalley.core.api.user.event.ProxyUserEvent;
import lombok.Getter;

import javax.annotation.Nonnull;

/**
 * This event is called when a user submits a chat input.
 */
@SuppressWarnings("unused")
public class UserSubmitChatInputEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) String input;

    public UserSubmitChatInputEvent(@Nonnull ProxyUser user, @Nonnull String input) {
        super(user);
        this.input = input;
    }
}