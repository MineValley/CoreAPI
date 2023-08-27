package minevalley.core.api.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.users.OnlineUser;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@RequiredArgsConstructor
@Getter
public final class UserServiceSwitchEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    private final OnlineUser user;
    private final ServiceSwitch serviceSwitch;

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public enum ServiceSwitch {
        JOIN_TEAM_SERVICE,
        LEAVE_TEAM_SERVICE,
        JOIN_SUPPORT_SERVICE,
        LEAVE_SUPPORT_SERVICE,
        JOIN_MEDIC_SERVICE,
        LEAVE_MEDIC_SERVICE,
        JOIN_POLICE_SERVICE,
        LEAVE_POLICE_SERVICE,
        JOIN_MAIL_SERVICE,
        LEAVE_MAIL_SERVICE,
        JOIN_DISPOSAL_SERVICE,
        LEAVE_DISPOSAL_SERVICE
    }
}