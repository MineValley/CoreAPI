package minevalley.core.api.users.events.messaging.input;

import lombok.Getter;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;

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