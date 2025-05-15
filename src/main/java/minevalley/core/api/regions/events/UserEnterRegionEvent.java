package minevalley.core.api.regions.events;

import lombok.Getter;
import lombok.Setter;
import minevalley.core.api.regions.Region;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.events.OnlineUserEvent;
import org.bukkit.event.Cancellable;

import javax.annotation.Nonnull;

/**
 * This event is called when a user enters a region.
 */
@Getter
public class UserEnterRegionEvent extends OnlineUserEvent implements Cancellable {

    @Setter
    private boolean cancelled = false;
    private final Region region;

    public UserEnterRegionEvent(@Nonnull OnlineUser user, @Nonnull Region region) {
        super(user);
        this.region = region;
    }
}