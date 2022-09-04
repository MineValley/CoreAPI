package minevalley.core.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.enums.*;
import minevalley.core.api.enums.sounds.AmbientSound;
import minevalley.core.api.enums.sounds.Sound;
import minevalley.core.api.phone.Telephone;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public interface OnlineUser extends User {

    /**
     * Gets the player-object of this user.
     * Note: The player may be offline
     *
     * @return player-object of this user
     */
    Player getPlayer();

    User getUser();

    void closeInventory();

    /**
     * Gets whether this user is currently logged in via labymod.
     * <b>Note:</b> When joining, this boolean isn't set immediately. Make sure to use a delay, when using this method in a PlayerJoinListener!
     *
     * @return true, if this user is using labymod
     */
    boolean isUsingLabyMod();

    /**
     * Gets the version this user is currently playing with.
     *
     * @return current version
     */
    McVersion getVersion();

    // Messages

    /**
     * Plays a specific sound.
     *
     * @param sound sound to be played
     */
    void playSound(Sound sound);

    /**
     * Plays a specific sound.
     *
     * @param sound sound to be played
     */
    void playSound(String sound);

    /**
     * Plays a specific sound.
     *
     * @param sound    sound to be played
     * @param location location where the sound will be played
     * @param spatial  defines whether the sound should be spatial
     */
    void playSound(Sound sound, Location location, boolean spatial);


    /**
     * Plays a specific sound.
     *
     * @param sound    sound to be played
     * @param location location where the sound will be played
     * @param spatial  defines whether the sound should be spatial
     */
    void playSound(String sound, Location location, boolean spatial);

    /**
     * Gets the ambient this user is currently hearing
     *
     * @return ambient this user is hearing
     */
    AmbientSound getAmbient();

    /**
     * Sets the current ambient, the user will hear
     *
     * @param ambient ambient for the user to hear
     */
    void setAmbient(AmbientSound ambient);

    /**
     * Starts the credits sequence.
     */
    void sendCredits();

    /**
     * Sends a message to this user like the default player.sendMessage()-method. Without any prefix or color.
     *
     * @param message message to be send as string
     */
    void sendMessage(@NonNull String message);

    /**
     * Sends a message to this user like the default player.sendMessage()-method. Without any prefix or color.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param message message to be send as string
     * @param notice  notice that is sent to the user
     */
    void sendMessage(@NonNull String message, @NonNull Notice notice);

    /**
     * Sends a message to this user with a specific prefix.
     *
     * @param messageType type of prefix to be displayed in front of the message
     * @param message     message to be send as string
     */
    void sendMessage(@NonNull MessageType messageType, @NonNull String message);

    /**
     * Sends a message to this user with a specific prefix.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param messageType type of prefix to be displayed in front of the message
     * @param message     message to be send as string
     * @param notice      notice that is sent to the user
     */
    void sendMessage(@NonNull MessageType messageType, @NonNull String message, @NonNull Notice notice);

    /**
     * Sends a message to this user with a specific prefix, using ComponentBuilders.
     *
     * @param messageType   type of prefix to be displayed in front of the message
     * @param baseComponent message to be send as string
     */
    void sendMessage(@NonNull MessageType messageType, @NonNull BaseComponent[] baseComponent);

    /**
     * Sends a message to this user with a specific prefix, using ComponentBuilders.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param messageType   type of prefix to be displayed in front of the message
     * @param baseComponent message to be send as string
     * @param notice        notice that is sent to the user
     */
    void sendMessage(@NonNull MessageType messageType, @NonNull BaseComponent[] baseComponent, @NonNull Notice notice);

    /**
     * Sends a message to this user, with using ComponentBuilders. This way you can use hover and clickevents and can take advantage of the clickable messages.
     *
     * @param baseComponent base-component which can be created by "new ComponentBuilder().create()"
     */
    void sendMessage(@NonNull BaseComponent[] baseComponent);

    /**
     * Sends a message to this user, with using ComponentBuilders. This way you can use hover and clickevents and can take advantage of the clickable messages.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param baseComponent base-component which can be created by "new ComponentBuilder().create()"
     * @param notice        notice that is sent to the user
     */
    void sendMessage(@NonNull BaseComponent[] baseComponent, @NonNull Notice notice);


    /**
     * Sends a message to this user like the default player.sendMessage()-method. Without any prefix or color.
     *
     * @param message  message to be send as string
     * @param chatMenu menu to attach underneath the message
     */

    void sendMessage(@NonNull String message, ChatMenu chatMenu);

    /**
     * Sends a message to this user like the default player.sendMessage()-method. Without any prefix or color.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param message  message to be send as string
     * @param chatMenu menu to attach underneath the message
     * @param notice   notice that is sent to the user
     */
    void sendMessage(@NonNull String message, ChatMenu chatMenu, @NonNull Notice notice);

    /**
     * Sends a message to this user with a specific prefix.
     *
     * @param messageType type of prefix to be displayed in front of the message
     * @param message     message to be send as string
     * @param chatMenu    menu to attach underneath the message
     */
    void sendMessage(@NonNull MessageType messageType, @NonNull String message, ChatMenu chatMenu);

    /**
     * Sends a message to this user with a specific prefix.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param messageType type of prefix to be displayed in front of the message
     * @param message     message to be send as string
     * @param chatMenu    menu to attach underneath the message
     * @param notice      notice that is sent to the user
     */
    void sendMessage(@NonNull MessageType messageType, @NonNull String message, ChatMenu chatMenu, @NonNull Notice notice);

    /**
     * Sends a message to this user with a specific prefix, using ComponentBuilders.
     *
     * @param messageType   type of prefix to be displayed in front of the message
     * @param baseComponent message to be send as string
     * @param chatMenu      menu to attach underneath the message
     */
    void sendMessage(@NonNull MessageType messageType, @NonNull BaseComponent[] baseComponent, ChatMenu chatMenu);

    /**
     * Sends a message to this user with a specific prefix, using ComponentBuilders.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param messageType   type of prefix to be displayed in front of the message
     * @param baseComponent message to be send as string
     * @param chatMenu      menu to attach underneath the message
     * @param notice        notice that is sent to the user
     */
    void sendMessage(@NonNull MessageType messageType, @NonNull BaseComponent[] baseComponent, ChatMenu chatMenu, @NonNull Notice notice);

    /**
     * Sends a message to this user, with using ComponentBuilders. This way you can use hover and clickevents and can take advantage of the clickable messages.
     *
     * @param baseComponent base-component which can be created by "new ComponentBuilder().create()"
     * @param chatMenu      menu to attach underneath the message
     */
    void sendMessage(@NonNull BaseComponent[] baseComponent, ChatMenu chatMenu);

    /**
     * Sends a message to this user, with using ComponentBuilders. This way you can use hover and clickevents and can take advantage of the clickable messages.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param baseComponent base-component which can be created by "new ComponentBuilder().create()"
     * @param chatMenu      menu to attach underneath the message
     * @param notice        notice that is sent to the user
     */
    void sendMessage(@NonNull BaseComponent[] baseComponent, ChatMenu chatMenu, @NonNull Notice notice);

    /**
     * Sends a message to the user providing useful side information. The user can click a button so that the message will not be sent the next time.
     *
     * @param notice notice that is sent to the user
     */
    void sendMessage(@NonNull Notice notice);

    /**
     * Sends the usual "Unbekannter Befehl!"-error to the user. Mostly used when a player is trying to execute an command that they are not allowed to do.
     */
    void sendError();

    // ChatInterface

    /**
     * Asks the player for any type of input via a chat-interface. The player can leave this interface. If he writes something into this interface, the callback gets called.
     *
     * @param message  the message to be send to the player. Normally containing a question or a request to put in any data
     * @param callback the callback that is called when the player makes an entry in the chat-interface. The consumer contains a string of the sent message.
     */
    void input(@NonNull String message, @NonNull Consumer<String> callback);

    /**
     * Gets whether the user is currently in a chat-interface.
     *
     * @return true, if the user is in a chat-interface
     */
    boolean isInChatInterface();

    /**
     * Lets the user leave his current interface
     */
    void leaveInterface();

    /**
     * Asks the user which bank account he wants to use (e. g. to pay sth)
     * He can choose from every bank account he's permissioned to transfer money from.
     * If he chooses nothing, the callback isn't called.
     * If he's only permissioned to transfer money from one account, he will not be asked (The callback will be called immediately with the account).
     *
     * @param callback callback with the chosen bank account
     */
    void askForBankAccount(Consumer<BankAccount> callback);

    // FractionService

    /**
     * Gets the users fraction.
     * Note: The user must be in fraction-service, otherwise this is NONE
     *
     * @return users fraction
     */
    FractionService getFractionService();

    void enterFractionService(FractionService service);


    void leaveFractionService();

    // TeamRank

    /**
     * Gets if the player has any type of team-rank.
     *
     * @return true, if the user is part of the server-team (and in team-service)
     */
    boolean isTeamler();

    /**
     * Gets whether the player is team-member with the plus-rank.
     *
     * @return true, if the user is teamplus-member
     */
    boolean isTeamPlus();

    /**
     * Gets the team-rank of this user.
     *
     * @return users team-rank
     */
    TeamRank getTeamRank();

    /**
     * Gets the custom team rank name.
     * If no custom name is defined, this returns the name of the users team rank.
     *
     * @return [custom] team rank name
     */
    String getCustomTeamRankName();

    /**
     * Gets whether the user has any of the listed team-ranks.
     *
     * @param ranks list of team-ranks to be checked for
     * @return true, if the user has one of the ranks
     */
    boolean hasTeamRank(@NonNull TeamRank... ranks);

    /**
     * Gets whether the user is allowed to use a general-key
     *
     * @return true, if the player is allowed to use a general-key
     */
    boolean isAllowedToUseGeneralKey();

    /**
     * Gets whether the user is using a general-key at the moment, by checking the item in his hand. If he is using a general-key without the permission to do, his key gets removed automatically.
     *
     * @return true, if the player is using a general-key
     */
    boolean isUsingGeneralKey();

    /**
     * Lets the user enter the team-service. If the user isn't teamler, nothing happens.
     */
    void joinTeamService();

    /**
     * Lets the user leave the team-service.
     */
    void leaveTeamService();

    /**
     * Gets whether the user is allowed to enter the support-service.
     *
     * @return true, if the user is allowed to enter the support-service
     */
    boolean canEnterSupportService();

    /**
     * Lets the user enter the support-service. If the user isn't allowed to, nothing happens.
     */
    void joinSupportService();

    /**
     * Lets the user leave the support-service.
     */
    void leaveSupportService();

    /**
     * Gets whether the user is marked as server-operator (!= OP-permission)
     *
     * @return true, if the user is marked as server-operator
     */
    boolean isOperator();

    void heal();

    /**
     * Gets whether the user has reached the maximum idle time and is marked as afk.
     *
     * @return true, if the user reached the maximum idle time
     */
    boolean isIdle();

    /**
     * Gets whether this user is vanished (only team members can be vanished).
     *
     * @return true, if this user is vanished
     */
    boolean isVanish();

    /**
     * Defines whether this user is vanished.
     * <b>Note:</b> this method only changes the state (The user is still visible)
     *
     * @param vanish vanish state
     */
    void setVanish(boolean vanish);

    /**
     * Imprisons this user.
     *
     * @param duration duration in minutes
     */
    void imprison(int duration);

    /**
     * Releases this user from prison (im imprisoned).
     */
    void releaseFromPrison();

    /**
     * Gets whether the user has completed registration on our network.
     *
     * @return true, if the user is registered
     */
    boolean isRegistered();

    /**
     * Gets whether this user is allowed to break/place/use a block at the given position regarding to the regions-system.
     *
     * @param block block to check
     * @return true, if this user is allowed to break/place/use a block here
     */
    boolean isAllowedToUse(Block block);

    void changeSign(Block block, final String line1, final String line2, final String line3, final String line4);

    void resetSign(Block block);

    void setNavigationTarget(Location location);

    void resetNavigationTarget();

    @Getter
    @Setter
    @AllArgsConstructor
    class Notice {
        String id, message;
    }
}