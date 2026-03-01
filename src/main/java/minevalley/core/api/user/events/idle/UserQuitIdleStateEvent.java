package minevalley.core.api.user.events.idle;

import minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event gets called when a proxy user is no longer marked as idle (afk).
 */
@SuppressWarnings("unused")
public class UserQuitIdleStateEvent extends UserUpdateIdleStateEvent {

    public UserQuitIdleStateEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}