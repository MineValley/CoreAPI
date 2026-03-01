package minevalley.core.api.registrant.events.prison;

import minevalley.core.api.registrant.ProxyUser;

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