package minevalley.core.api.events;

import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@RequiredArgsConstructor
public class StatisticCreateEvent extends Event {

    // TODO 29.12.2024: recently removed DatabaseEntry object due to rework of database util might not work anymore (StatisticCreateEvent)

    public static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}