package minevalley.core.api.users.events.prison;

import lombok.Getter;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;

import javax.annotation.Nonnull;

/**
 * This event gets called when a user is getting imprisoned.
 */
@Getter
@SuppressWarnings("unused")
public class UserImprisonmentEvent extends ProxyUserEvent {

    public UserImprisonmentEvent(@Nonnull ProxyUser user) {
        super(user);
    }
}