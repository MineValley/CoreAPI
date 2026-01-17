package minevalley.core.api.users.events.messaging.actionbar;

import lombok.Getter;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;
import net.kyori.adventure.text.Component;

import javax.annotation.Nonnull;

/**
 * This event is called when an action bar message is to be sent to a user.
 */
@SuppressWarnings("unused")
public class UserPreReceiveActionBarEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) Component message;

    public UserPreReceiveActionBarEvent(@Nonnull ProxyUser user, @Nonnull Component message) {
        super(user);
        this.message = message;
    }
}