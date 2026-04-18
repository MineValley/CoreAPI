package eu.minevalley.core.api.user.event.messaging.actionbar;

import eu.minevalley.core.api.user.ProxyUser;
import eu.minevalley.core.api.user.event.ProxyUserEvent;
import lombok.Getter;
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