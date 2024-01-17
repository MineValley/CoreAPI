package minevalley.core.api.utils.armorstand.modifiers;

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

    /**
     * Adds the given users to the viewers list.
     *
     * @param onlineUsers users to add
     * @return this
     */
    VisibilityModifier addToViewersList(OnlineUser... onlineUsers);

    /**
     * Removes the given users from the viewers list.
     *
     * @param onlineUsers users to remove
     * @return this
     */
    VisibilityModifier removeFromViewersList(OnlineUser... onlineUsers);

    /**
     * Empties the viewers list.
     * <b>Emptying this list results in everyone seeing the armorstand (If not part of hide list)</b>
     *
     * @return this
     */
    VisibilityModifier emptyViewersList();

    /**
     * The armorstand will explicitly hide from the players in this list, even if the viewers list contains them (or is empty)!
     *
     * @return list of users to hide this armorstand from.
     */
    List<OnlineUser> getHideList();

    /**
     * Adds the given users to the hide list.
     *
     * @param onlineUsers users to add
     * @return this
     */
    VisibilityModifier addToHideList(OnlineUser... onlineUsers);

    /**
     * Removes the given users from the hide list.
     *
     * @param onlineUsers users to remove
     * @return this
     */
    VisibilityModifier removeFromHideList(OnlineUser... onlineUsers);

    /**
     * Empties the hide list.
     *
     * @return this
     */
    VisibilityModifier emptyHideList();
}
