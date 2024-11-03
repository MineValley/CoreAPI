package minevalley.core.api.scoreboard;

import org.bukkit.ChatColor;

public interface ScoreboardTeamBuilder {

    /**
     * Set the display name of the team
     *
     * @param displayName display name
     * @return this
     */
    ScoreboardTeamBuilder setDisplayName(String displayName);

    /**
     * Set the prefix of the team
     *
     * @param prefix prefix
     * @return this
     */
    ScoreboardTeamBuilder setPrefix(String prefix);

    /**
     * Set the suffix of the team
     *
     * @param suffix suffix
     * @return this
     */
    ScoreboardTeamBuilder setSuffix(String suffix);

    /**
     * Set if friendly fire is allowed
     *
     * @param allowFriendlyFire friendly fire
     * @return this
     */
    ScoreboardTeamBuilder setAllowFriendlyFire(boolean allowFriendlyFire);

    /**
     * Set if the name tag is visible
     *
     * @param nameTagVisibility name tag visibility
     * @return this
     */
    ScoreboardTeamBuilder setNameTagVisibility(boolean nameTagVisibility);


    /**
     * Set the color of the team
     *
     * @param color color
     * @return this
     */
    ScoreboardTeamBuilder setColor(ChatColor color);

    ScoreboardTeam build();
}
