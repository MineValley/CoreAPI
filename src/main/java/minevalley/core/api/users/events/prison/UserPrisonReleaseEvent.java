package minevalley.core.api.users.events.prison;

import lombok.Getter;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.OnlineUserEvent;

/**
 * This event gets called when a user is released from prison.
 */
@Getter
public class UserPrisonReleaseEvent extends OnlineUserEvent {

    public UserPrisonReleaseEvent(OnlineUser user) {
        super(user);
    }
}