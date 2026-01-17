package minevalley.core.api.utils;

import org.bukkit.event.Event;

public interface EventListener<T extends Event> {

    /**
     * Called when the event is fired
     *
     * @param event the event
     */
    void on(T event);
}