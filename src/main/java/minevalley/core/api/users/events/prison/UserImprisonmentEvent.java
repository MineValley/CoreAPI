package minevalley.core.api.users.events.prison;

import lombok.Getter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.OnlineUserEvent;

/**
 * This event gets called when a user is getting imprisoned.
 */
@Getter
public class UserImprisonmentEvent extends OnlineUserEvent {

    public UserImprisonmentEvent(OnlineUser user) {
        super(user);
    }
}