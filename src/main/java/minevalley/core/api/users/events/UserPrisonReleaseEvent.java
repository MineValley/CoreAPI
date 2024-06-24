package minevalley.core.api.users.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event gets called when a user is released from prison.
 */
@Getter
public class UserPrisonReleaseEvent extends UserEvent {

    public UserPrisonReleaseEvent(User user) {
        super(user);
    }
}