package minevalley.core.api.users.events.messaging.title;

import lombok.Getter;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;

import javax.annotation.Nonnull;

/**
 * This event is called when a title is to be sent to a user.
 */
@SuppressWarnings("unused")
public class UserPreReceiveTitleEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) Component title;
    private final @Getter(onMethod_ = @Nonnull) Component subtitle;
    private final @Getter(onMethod_ = @Nonnull) Title.Times timings;

    public UserPreReceiveTitleEvent(@Nonnull ProxyUser proxyUser, @Nonnull Component title, @Nonnull Component subtitle) {
        super(proxyUser);
        this.title = title;
        this.subtitle = subtitle;
        this.timings = Title.DEFAULT_TIMES;
    }

    public UserPreReceiveTitleEvent(@Nonnull ProxyUser proxyUser, @Nonnull Component title, @Nonnull Component subtitle, Title.Times timings) {
        super(proxyUser);
        this.title = title;
        this.subtitle = subtitle;
        this.timings = timings;
    }
}