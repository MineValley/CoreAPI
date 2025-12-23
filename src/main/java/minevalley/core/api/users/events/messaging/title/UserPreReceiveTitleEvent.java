package minevalley.core.api.users.events.messaging.title;

import lombok.Getter;
import minevalley.core.api.users.ProxyUser;
import minevalley.core.api.users.events.ProxyUserEvent;
import net.kyori.adventure.text.Component;

import javax.annotation.Nonnull;

/**
 * This event is called when a title is to be sent to a user.
 */
@SuppressWarnings("unused")
public class UserPreReceiveTitleEvent extends ProxyUserEvent {

    private final @Getter(onMethod_ = @Nonnull) Component title;
    private final @Getter(onMethod_ = @Nonnull) Component subtitle;
    private final long[] timings = {10, 70, 20};

    public UserPreReceiveTitleEvent(@Nonnull ProxyUser proxyUser, @Nonnull Component title, @Nonnull Component subtitle) {
        super(proxyUser);
        this.title = title;
        this.subtitle = subtitle;
    }

    public UserPreReceiveTitleEvent(@Nonnull ProxyUser proxyUser, @Nonnull Component title, @Nonnull Component subtitle, long fadeIn, long stay, long fadeOut) {
        super(proxyUser);
        this.title = title;
        this.subtitle = subtitle;
        this.timings[0] = fadeIn;
        this.timings[1] = stay;
        this.timings[2] = fadeOut;
    }

    public long getFadeIn() {
        return timings[0];
    }

    public long getStay() {
        return timings[1];
    }

    public long getFadeOut() {
        return timings[2];
    }
}