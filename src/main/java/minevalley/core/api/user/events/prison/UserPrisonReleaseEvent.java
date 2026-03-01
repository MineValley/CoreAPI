package minevalley.core.api.user.events.prison;

import minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is released from prison.
 */
@SuppressWarnings("unused")
public class UserPrisonReleaseEvent extends UserUpdatePrisonStateEvent {

    public UserPrisonReleaseEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}