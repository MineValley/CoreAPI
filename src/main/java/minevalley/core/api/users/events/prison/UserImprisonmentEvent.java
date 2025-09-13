package minevalley.core.api.users.events.prison;

import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is getting imprisoned.
 */
@SuppressWarnings("unused")
public class UserImprisonmentEvent extends UserUpdatePrisonStateEvent {

    public UserImprisonmentEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}