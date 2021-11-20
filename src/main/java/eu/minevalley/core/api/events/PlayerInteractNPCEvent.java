package eu.minevalley.core.api.events;

import eu.minevalley.core.api.utils.NPC;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * This event gets called, when a player interacts with an NPC. It's the equivalent to the PlayerInteractAtEntity-event.
 */
@Getter
public final class PlayerInteractNPCEvent extends PlayerEvent {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final NPC npc;

    private final ClickEnum clickEnum;

    public PlayerInteractNPCEvent(Player who, NPC npc, ClickEnum clickEnum) {
        super(who);

        this.npc = npc;
        this.clickEnum = clickEnum;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public enum ClickEnum {
        RIGHT_CLICK,
        LEFT_CLICK;
    }
}