package minevalley.core.api.scoreboard;

import minevalley.core.api.users.OnlineUser;
import org.bukkit.ChatColor;

public interface ScoreboardTeam {

    /**
     * Get the name of the team
     *
     * @return team name
     */
    String getDisplayName();

    /**
     * Set the name of the team
     *
     * @param displayName name to set
     */
    void setDisplayName(String displayName);

    /**
     * Get the prefix of the team
     *
     * @return prefix
     */
    String getPrefix();

    /**
     * Set the prefix of the team
     *
     * @param prefix prefix to set
     */
    void setPrefix(String prefix);

    /**
     * Get the suffix of the team
     *
     * @return suffix
     */
    String getSuffix();

    /**
     * Set the suffix of the team
     *
     * @param suffix suffix to set
     */
    void setSuffix(String suffix);

    /**
     * Check if friendly fire is allowed
     *
     * @return friendly fire
     */
    boolean isFriendlyFireAllowed();

    /**
     * Set if friendly fire is allowed
     *
     * @param allowFriendlyFire friendly fire
     */
    void setAllowFriendlyFire(boolean allowFriendlyFire);

    /**
     * Check if the name tag is visible
     *
     * @return name tag visibility
     */
    boolean isNameTagVisible();

    /**
     * Set if the name tag is visible
     *
     * @param nameTagVisibility name tag visibility
     */
    void setNameTagVisibility(boolean nameTagVisibility);

    /**
     * Get the color of the team
     *
     * @return color
     */
    ChatColor getColor();

    /**
     * Set the color of the team
     *
     * @param color color to set
     */
    void setColor(ChatColor color);

    /**
     * Check if the entity is a member of the team
     *
     * @param entity username of player or uuid of entity
     * @return is member
     */
    boolean isMember(String entity);

    /**
     * Add an entity to the team
     *
     * @param entity username of player or uuid of entity
     */
    void addMember(String entity);

    /**
     * Remove an entity from the team
     *
     * @param entity username of player or uuid of entity
     */
    void removeMember(String entity);

    /**
     * Check if the user is a viewer of the team
     *
     * @param user user
     * @return is viewer
     */
    boolean isViewer(OnlineUser user);

    /**
     * Add a user to the team as a viewer
     *
     * @param user user
     */
    void addViewer(OnlineUser user);

    /**
     * Remove a user from the team as a viewer
     *
     * @param user user
     */
    void removeViewer(OnlineUser user);

    /**
     * Update the team information
     */
    void updateInfo();

    /**
     * Update the team members
     */
    void updateMembers();

    /**
     * Update the team viewers
     */
    void updateVisibility();

    /**
     * Remove the team
     */
    void remove();
}
