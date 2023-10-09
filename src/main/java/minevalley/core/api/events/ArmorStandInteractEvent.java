package minevalley.core.api.events;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.utils.armorstand.FakeArmorStand;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ArmorStandInteractEvent extends Event {

    private FakeArmorStand armorStand;
    private OnlineUser user;

    /**
     * 0: interact
     * 1: attack
     * 2: interact at
     */
    private int interactionType;

    private static final HandlerList HANDLERS = new HandlerList();

    public ArmorStandInteractEvent(OnlineUser user, FakeArmorStand armorStand, int interactionType)
    {
        this.user = user;
        this.armorStand = armorStand;
        this.interactionType = interactionType;
    }

    public int getInteractionType() {
        return interactionType;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public FakeArmorStand getArmorStand() {
        return armorStand;
    }

    public OnlineUser getUser() {
        return user;
    }
}
