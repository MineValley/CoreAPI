package minevalley.core.api.events;

import lombok.RequiredArgsConstructor;
import minevalley.core.api.database.DatabaseEntry;
import minevalley.core.api.database.Value;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@RequiredArgsConstructor
@SuppressWarnings("unused")
public class StatisticCreateEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final DatabaseEntry entry;

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public void setStatistic(String key, double value) {
        entry.changeValue(new Value(key, value));
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}