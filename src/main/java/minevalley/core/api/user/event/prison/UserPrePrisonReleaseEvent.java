package minevalley.core.api.user.event.prison;

import minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is requested to be released from prison, before the release is processed.
 */
@SuppressWarnings("unused")
public class UserPrePrisonReleaseEvent extends UserUpdatePrisonStateEvent {

    public UserPrePrisonReleaseEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}