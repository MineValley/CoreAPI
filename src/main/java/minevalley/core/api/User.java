package minevalley.core.api;

import minevalley.core.api.enums.Fraction;
import minevalley.core.api.enums.MessageType;
import minevalley.core.api.enums.PlayerRank;
import minevalley.core.api.enums.TeamRank;
import minevalley.core.api.phone.Phone;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public interface User {

    /**
     * Removes the whole user-object and loads it again from the database.
     */
    void refresh();

    /**
     * Lets the user enter the team-service. If the user isn't teamler, nothing happens.
     */
    void joinTeamService();

    /**
     * Lets the user leave the team-service.
     */
    void leaveTeamService();

    /**
     * Sends a message to this user like the default player.sendMessage()-method. Without any prefix or color.
     * @param message message to be send as string
     */
    void sendMessage(String message);

    /**
     * Sends a message to this user with a specific prefix.
     * @param messageType type of prefix to be displayed in front of the message
     * @param message message to be send as string
     */
    void sendMessage(MessageType messageType, String message);

    /**
     * Sends a message to this user, with using ComponentBuilders. This way you can use hover and clickevents and can take advantage of the clickable messages.
     * @param baseComponent base-component which can be created by "new ComponentBuilder().create()"
     */
    void sendMessage(BaseComponent baseComponent);

    /**
     * Sends the usual "Unbekannter Befehl!"-error to the user. Mostly used when a player is trying to execute an command that they are not allowed to do.
     */
    void sendError();

    /**
     * Asks the player for any type of input via a chat-interface. The player can leave this interface. If he writes something into this interface, the callback gets called.
     * @param message the message to be send to the player. Normally containing a question or a request to put in any data
     * @param callback the callback that is called when the player makes an entry in the chat-interface. The consumer contains a string of the sent message.
     */
    void input(String message, Consumer<String> callback);

    /**
     * Lets the user leave his current interface
     */
    void leaveInterface();

    /**
     * Updates the users cash from the database
     */
    void updateCash();

    /**
     * Gets whether the user has any of the listed player-ranks
     * @param ranks list of player-ranks to be checked for
     * @return is true, if the user has one of the ranks
     */
    boolean hasPlayerRank(PlayerRank... ranks);

    /**
     * Gets whether the user has any of the listed team-ranks.
     * @param ranks list of team-ranks to be checked for
     * @return is true, if the user has one of the ranks
     */
    boolean hasTeamRank(TeamRank... ranks);

    /**
     * Gets if the player has any type of team-rank.
     * @return is true, if the user is part of the server-team (and in team-service)
     */
    boolean isTeamler();

    /**
     * Removes a certain amount of cash of the users wallet.
     * @param amount amout to remove
     * @return true, if the transaction was successful. If the user doesn't have enough money, this is false
     */
    boolean payCash(double amount);

    /**
     * Gets the current amount of cash in the users wallet.
     * @return
     */
    double getCash();

    /**
     * Gets the wanted-level of the user.
     * @return wanted-level of the user. 0 if the player isn't wanted
     */
    int getWantedLevel();

    /**
     * Sets the wanted-level of the user
     * @param level new wanted-level
     */
    void setWantedLevel(int level);

    /**
     * Gets whether the user is allowed to use a general-key
     * @return true, if the player is allowed to use a general-key
     */
    boolean isAllowedToUseGeneralKey();

    /**
     * Gets whether the user is using a general-key at the moment, by checking the item in his hand. If he is using a general-key without the permission to do, his key gets removed automatically.
     * @return true, if the player is using a general-key
     */
    boolean isUsingGeneralKey();

    /**
     * Gets whether the user is allowed to enter the support-service.
     * @return true, if the user is allowed to enter the support-service
     */
    boolean canEnterSupportService();

    /**
     * Gets whether the user is in support-service
     * @return true, if the user is in support-service
     */
    boolean isInSupportService();

    /**
     * Gets whether the user is knocked out.
     * @return true, if the user is knocked out
     */
    boolean isKnockedOut();

    /**
     * Gets the head of this user.
     * @return player-head as itemstack
     */
    ItemStack getPlayerHead();

    /**
     * Gets the unique id of this user.
     * @return unique id as string
     */
    String getUniqueId();

    /**
     * Gets the id of this user.
     * @return id as string
     */
    String getId();

    /**
     * Gets the player-object of this user.
     * Note: The player may be offline
     * @return player-object of this user
     */
    Player getPlayer();

    /**
     * Gets the users phone
     * @return phone of this user
     */
    Phone getPhone();

    // BankAccount getBankAccount(); !?

    /**
     * Gets the users fraction.
     * Note: The user must be in fraction-service, otherwise this is NONE
     * @return users fraction
     */
    Fraction getFraction();

    /**
     * Gets the team-rank of this user.
     * @return users team-rank
     */
    TeamRank getTeamRank();

    /**
     * Gets the player-rank of this user.
     * @return users player-rank
     */
    PlayerRank getPlayerRank();
}