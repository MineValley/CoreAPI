package minevalley.core.api.utils.armorstand;

import minevalley.core.api.users.OnlineUser;

import java.util.List;

public interface VisibilityModifier {

    /**
     * The armorstand will only be visible to players in this list.
     * <br>
     * <b>Note 1:</b> If list is empty, armorstand is visible to everyone!
     * <br>
     * <b>Note 2:</b> The viewers list can be overwritten by the hide list!
     *
     * @return List of all users this armorstand is shown to.
     */
    List<OnlineUser> getViewersList();

    VisibilityModifier addToViewersList(OnlineUser... onlineUsers);

    VisibilityModifier removeFromViewersList(OnlineUser... onlineUsers);

    /**
     * <b>Emptying this list results in everyone seeing the armorstand (If not part of hide list)</b>
     */
    VisibilityModifier emptyViewersList();

    /**
     * The armorstand will explicitly hide from the players in this list, even if the viewers list contains them (or is empty)!
     *
     * @return list of users to hide this armorstand from.
     */
    List<OnlineUser> getHideList();

    VisibilityModifier addToHideList(OnlineUser... onlineUsers);

    VisibilityModifier removeFromHideList(OnlineUser... onlineUsers);

    VisibilityModifier emptyHideList();

    void updateVisibility();
}
