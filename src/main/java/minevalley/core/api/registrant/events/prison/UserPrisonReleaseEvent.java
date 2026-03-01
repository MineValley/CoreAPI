package minevalley.core.api.registrant.events.prison;

import minevalley.core.api.registrant.ProxyUser;

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