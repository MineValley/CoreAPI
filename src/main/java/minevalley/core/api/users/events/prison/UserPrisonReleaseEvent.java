package minevalley.core.api.users.events.prison;

import lombok.Getter;
import minevalley.core.api.users.User;
import minevalley.core.api.users.events.UserEvent;

/**
 * This event gets called when a user is released from prison.
 */
@Getter
public class UserPrisonReleaseEvent extends UserEvent {

    public UserPrisonReleaseEvent(User user) {
        super(user);
    }
}