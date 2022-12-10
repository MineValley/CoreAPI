package minevalley.core.api.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.regions.Region;
import minevalley.core.api.vehicles.Vehicle;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event is called when a vehicle enters a region, no matter what type of region it is.
 */
@RequiredArgsConstructor
@Getter
public class VehicleEnterRegionEvent extends Event implements Cancellable {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final Vehicle vehicle;
    private final Region region;
    private boolean cancelled = false;

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}