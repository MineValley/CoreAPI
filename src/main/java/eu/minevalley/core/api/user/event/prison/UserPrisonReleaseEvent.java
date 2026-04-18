package eu.minevalley.core.api.user.event.prison;

import eu.minevalley.core.api.user.ProxyUser;

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