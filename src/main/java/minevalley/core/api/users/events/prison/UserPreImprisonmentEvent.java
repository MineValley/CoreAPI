package minevalley.core.api.users.events.prison;

import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;

/**
 * This event is called when a user is requested to be imprisoned, before the imprisonment is processed.
 */
@SuppressWarnings("unused")
public class UserPreImprisonmentEvent extends UserUpdatePrisonStateEvent {

    public UserPreImprisonmentEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}