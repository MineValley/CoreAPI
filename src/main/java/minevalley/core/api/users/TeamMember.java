package minevalley.core.api.users;

import minevalley.core.api.users.enums.TeamRank;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings("unused")
public interface TeamMember extends OnlineUser {

    /**
     * Gets whether the player is team-member with the plus-rank.
     *
     * @return true, if the user is team-plus-member
     */
    @Contract(pure = true)
    boolean isTeamPlus();

    /**
     * Gets the team-rank of this user.
     *
     * @return users team-rank
     */
    @Nonnull
    @Contract(pure = true)
    TeamRank getTeamRank();

    /**
     * Gets the custom team rank name.
     * If no custom name is defined, this returns the name of the users team rank.
     *
     * @return [custom] team rank name
     */
    @Nullable
    @Contract(pure = true)
    String getCustomTeamRankName();

    /**
     * Sometimes a player is assigned a team rank to grant them permission or access.
     * Because team members are highlighted in the chat and tab list,
     * they appear representative of the project and players may assume they have the permission and knowledge
     * to guide other players. Therefore, the rank assigned to the player can be hidden.
     *
     * @return true, if this user is displayed as team member in chat, tab list, etc.
     */
    @Contract(pure = true)
    boolean isDisplayedAsTeamler();

    /**
     * Gets whether the user is allowed to use a general-key
     *
     * @return true, if the player is allowed to use a general-key
     */
    @Contract(pure = true)
    boolean isAllowedToUseGeneralKey();

    /**
     * Gets whether the user is using a general-key at the moment, by checking the item in his hand. If he is using a general-key without the permission to do, his key gets removed automatically.
     *
     * @return true, if the player is using a general-key
     */
    @Contract(pure = true)
    boolean isUsingGeneralKey();

    /**
     * Lets the user leave the team-service.
     */
    void leaveTeamService() throws IllegalStateException;

    /**
     * Gets whether the user is allowed to enter the support-service.
     *
     * @return true, if the user is allowed to enter the support-service
     */
    @Contract(pure = true)
    boolean canEnterSupportService();

    /**
     * Lets the user enter the support-service. If the user isn't allowed to, nothing happens.
     */
    void joinSupportService() throws UnsupportedOperationException, IllegalStateException;

    /**
     * Lets the user leave the support-service.
     */
    void leaveSupportService() throws IllegalStateException;

    /**
     * Gets whether the user is marked as server-operator (!= OP-permission)
     *
     * @return true, if the user is marked as server-operator
     */
    @Contract(pure = true)
    boolean isOperator();

    /**
     * Gets whether the user is in support-service
     *
     * @return true, if the user is in support-service
     */
    @Contract(pure = true)
    boolean isInSupportService();
}
