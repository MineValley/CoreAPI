package minevalley.core.api.users.events.idle;

import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event gets called when a proxy user is marked as idle (afk).
 */
@SuppressWarnings("unused")
public class UserEnterIdleStateEvent extends UserUpdateIdleStateEvent {

    public UserEnterIdleStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}