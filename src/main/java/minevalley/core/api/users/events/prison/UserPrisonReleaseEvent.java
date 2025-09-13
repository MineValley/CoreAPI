package minevalley.core.api.users.events.prison;

import lombok.Getter;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is released from prison.
 */
@Getter
@SuppressWarnings("unused")
public class UserPrisonReleaseEvent extends ProxyUserEvent {

    public UserPrisonReleaseEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}