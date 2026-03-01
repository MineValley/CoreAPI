package minevalley.core.api.registrant.events.punishment;

import minevalley.core.api.registrant.User;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is freezed.
 */
@SuppressWarnings("unused")
public class UserFreezeEvent extends UserUpdateFreezeStateEvent {

    public UserFreezeEvent(@Nonnull User user) {
        super(user);
    }
}