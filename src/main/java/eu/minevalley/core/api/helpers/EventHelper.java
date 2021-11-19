package eu.minevalley.core.api.helpers;

import eu.minevalley.core.api.utils.EventListener;
import eu.minevalley.core.api.utils.command.PlayerCommand;
import org.bukkit.event.Event;

public interface EventHelper {

    void registerEvent(Class<? extends Event> cls, EventListener listener);

    void unregisterEvent(Class<? extends Event> cls, EventListener listener);

    void registerCommand(PlayerCommand command);
}