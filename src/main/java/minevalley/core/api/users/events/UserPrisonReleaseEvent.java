package minevalley.core.api.users.events;

import lombok.Getter;
import minevalley.core.api.users.User;

/**
 * This event gets called when a user is released from prison.
 */
@Getter
public class UserPrisonReleaseEvent extends UserEvent {

    public UserPrisonReleaseEvent(User user) {
        super(user);
    }
}