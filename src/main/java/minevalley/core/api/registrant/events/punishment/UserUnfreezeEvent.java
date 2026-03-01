package minevalley.core.api.registrant.events.punishment;

import minevalley.core.api.registrant.User;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is unfreezed.
 */
@SuppressWarnings("unused")
public class UserUnfreezeEvent extends UserUpdateFreezeStateEvent {

    public UserUnfreezeEvent(@Nonnull User user) {
        super(user);
    }
}