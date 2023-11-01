package minevalley.core.api.utils.armorstand.properties;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.entity.Player;

import java.util.List;

public interface VisibilityModifier {

    void hideFromPlayers(OnlineUser... onlineUsers);
    void exposeToPlayers(OnlineUser... onlineUsers);

    List<OnlineUser> getVisibilityModifierPlayers();
}
