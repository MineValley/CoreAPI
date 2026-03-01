package minevalley.core.api.registrant.events.punishment;

import minevalley.core.api.registrant.User;
import minevalley.core.api.registrant.events.UserEvent;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public abstract class UserUpdateFreezeStateEvent extends UserEvent {

    public UserUpdateFreezeStateEvent(@Nonnull User user) {
        super(user);
    }
}