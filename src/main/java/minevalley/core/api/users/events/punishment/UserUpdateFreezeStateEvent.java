package minevalley.core.api.users.events.punishment;

import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateFreezeStateEvent extends UserEvent {

    public UserUpdateFreezeStateEvent(@Nonnull User user) {
        super(user);
    }
}