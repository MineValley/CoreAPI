package minevalley.core.api.utils.armorstand.properties;

import minevalley.core.api.users.OnlineUser;

import java.util.List;

public interface VisibilityModifier {

    /**
     * The armorstand will only be visible to players in this list.
     * <br>
     * <b>Note 1:</b> If list is empty, armorstand is visible to everyone!
     * <br>
     * <b>Note 2:</b> The viewers list can be overwritten by the hide list!
     */
    List<OnlineUser> getViewersList();

    void addToViewersList(OnlineUser... onlineUsers);

    void removeFromViewersList(OnlineUser... onlineUsers);

    /**
     * <b>Emptying this list results in everyone seeing the armorstand (If not part of hide list)</b>
     */
    void emptyViewersList();

    /**
     * The armorstand will explicitly hide from the players in this list, even if the viewers list contains them (or is empty)!
     */
    List<OnlineUser> getHideList();

    void addToHideList(OnlineUser... onlineUsers);

    void removeFromHideList(OnlineUser... onlineUsers);

    void emptyHideList();

}
