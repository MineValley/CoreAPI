package minevalley.core.api.users;

import lombok.NonNull;
import minevalley.core.api.chat.MessageReceiver;
import minevalley.core.api.chat.types.MessageType;
import minevalley.core.api.economy.AccountUser;
import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.enums.sounds.AmbientSound;
import minevalley.core.api.enums.sounds.Sound;
import minevalley.core.api.regions.utils.PlayerLocation;
import minevalley.core.api.users.enums.Fraction;
import minevalley.core.api.users.enums.McVersion;
import minevalley.core.api.users.enums.TabListView;
import minevalley.core.api.users.enums.TeamRank;
import minevalley.core.api.users.exceptions.UserNotPermittedException;
import minevalley.core.api.utils.ChatHandler;
import minevalley.core.api.utils.ClickableMessage;
import minevalley.core.api.vehicles.LoadedVehicle;
import minevalley.core.api.vehicles.VehicleManager;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public interface OnlineUser extends User, MessageReceiver {

    /**
     * Gets the player object of this user.
     *
     * @return player object
     */
    @Nonnull
    Player getPlayer();

    /**
     * Closes the inventory of this user.
     */
    default void closeInventory() {
        getPlayer().closeInventory();
    }

    /**
     * Gets whether this user is currently logged in via labymod.
     * <br>
     * <b>Note:</b> When joining, this boolean isn't set immediately. Make sure to use a delay, when using this method in a PlayerJoinListener!
     *
     * @return true, if this user is using labymod
     */
    @Contract(pure = true)
    boolean isUsingLabyMod();

    /**
     * Gets the version of the client this user is using.
     *
     * @return client version
     */
    @Nonnull
    @Contract(pure = true)
    McVersion getVersion();

    // Sounds

    /**
     * Plays a specific sound.
     *
     * @param sound sound to be played
     * @throws IllegalArgumentException if sound is null or an empty string
     */
    void playSound(@Nonnull String sound) throws IllegalArgumentException;

    /**
     * Plays a specific sound.
     *
     * @param sound sound to be played
     * @throws IllegalArgumentException if sound is null
     */
    void playSound(@Nonnull Sound sound) throws IllegalArgumentException;

    /**
     * Plays a specific sound.
     *
     * @param sound    sound to be played
     * @param location location where the sound will be played
     * @param spatial  defines whether the sound should be spatial
     * @throws IllegalArgumentException if sound or location is null, or the location is not in the same world as the user
     */
    void playSound(@Nonnull Sound sound, @Nonnull Location location, boolean spatial) throws IllegalArgumentException;

    /**
     * Plays a specific sound.
     *
     * @param sound    sound to be played
     * @param location location where the sound will be played
     * @param spatial  defines whether the sound should be spatial
     * @throws IllegalArgumentException if sound or location is null, or the location is not in the same world as the user
     */
    void playSound(@Nonnull String sound, @Nonnull Location location, boolean spatial) throws IllegalArgumentException;

    /**
     * Gets the ambient this user is currently hearing
     *
     * @return ambient this user is hearing
     */
    @Nonnull
    @Contract(pure = true)
    AmbientSound getAmbient();

    /**
     * Sets the ambient this user is hearing
     *
     * @param ambient ambient to be set
     * @throws IllegalArgumentException if ambient is null
     */
    void setAmbient(@Nonnull AmbientSound ambient) throws IllegalArgumentException;

    /**
     * Starts the credits sequence.
     */
    void sendCredits();

    // Messages

    /**
     * Sends a message to the user that is displayed in the action bar.
     *
     * @param message message to be sent
     * @throws IllegalArgumentException if message is null or an empty string
     */
    @Deprecated(forRemoval = true)
    void sendActionBar(@Nonnull String message) throws IllegalArgumentException;

    /**
     * Sets the tab-list view of this user.
     *
     * @param view tab-list view to be set
     * @throws IllegalArgumentException if view is null
     */
    void setTabListView(@Nonnull TabListView view) throws IllegalArgumentException;

    /**
     * Gets the current tab-list view of this user.
     *
     * @return current tab-list view
     */
    @Nonnull
    @Contract(pure = true)
    TabListView getTabListView();

    /**
     * Sends a message to this user like the default player.sendMessage()-method. Without any prefix or color.
     *
     * @param message message to be sent as string
     */
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull String message);

    /**
     * Sends a message to this user like the default player.sendMessage()-method. Without any prefix or color.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param message message to be sent as string
     * @param notice  notice that is sent to the user
     */
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull String message, @NonNull Notice notice);

    /**
     * Sends a message to this user with a specific prefix.
     *
     * @param messageType type of prefix to be displayed in front of the message
     * @param message     message to be sent as string
     */
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull MessageType messageType, @NonNull String message);

    /**
     * Sends a message to this user with a specific prefix.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param messageType type of prefix to be displayed in front of the message
     * @param message     message to be sent as string
     * @param notice      notice that is sent to the user
     */
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull MessageType messageType, @NonNull String message, @NonNull Notice notice);

    /**
     * Sends a message to this user with a specific prefix, using ComponentBuilders.
     *
     * @param messageType   type of prefix to be displayed in front of the message
     * @param baseComponent message to be sent as string
     */
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull MessageType messageType, @NonNull BaseComponent[] baseComponent);

    /**
     * Sends a message to this user with a specific prefix, using ComponentBuilders.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param messageType   type of prefix to be displayed in front of the message
     * @param baseComponent message to be sent as string
     * @param notice        notice that is sent to the user
     */
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull MessageType messageType, @NonNull BaseComponent[] baseComponent, @NonNull Notice notice);

    /**
     * Sends a message to this user, with using ComponentBuilders. This way you can use hover and click-events and can take advantage of the clickable messages.
     *
     * @param baseComponent base-component which can be created by "new ComponentBuilder().create()"
     */
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull BaseComponent[] baseComponent);

    /**
     * Sends a message to this user, with using ComponentBuilders. This way you can use hover and click-events and can take advantage of the clickable messages.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param baseComponent base-component which can be created by "new ComponentBuilder().create()"
     * @param notice        notice that is sent to the user
     */
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull BaseComponent[] baseComponent, @NonNull Notice notice);


    /**
     * Sends a message to this user like the default player.sendMessage()-method. Without any prefix or color.
     *
     * @param message  message to be sent as string
     * @param chatMenu menu to attach underneath the message
     */
    @SuppressWarnings("removal")
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull String message, minevalley.core.api.ChatMenu chatMenu);

    /**
     * Sends a message to this user like the default player.sendMessage()-method. Without any prefix or color.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param message  message to be sent as string
     * @param chatMenu menu to attach underneath the message
     * @param notice   notice that is sent to the user
     */
    @SuppressWarnings("removal")
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull String message, minevalley.core.api.ChatMenu chatMenu, @NonNull Notice notice);

    /**
     * Sends a message to this user with a specific prefix.
     *
     * @param messageType type of prefix to be displayed in front of the message
     * @param message     message to be sent as string
     * @param chatMenu    menu to attach underneath the message
     */
    @SuppressWarnings("removal")
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull MessageType messageType, @NonNull String message, minevalley.core.api.ChatMenu chatMenu);

    /**
     * Sends a message to this user with a specific prefix.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param messageType type of prefix to be displayed in front of the message
     * @param message     message to be sent as string
     * @param chatMenu    menu to attach underneath the message
     * @param notice      notice that is sent to the user
     */
    @SuppressWarnings("removal")
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull MessageType messageType, @NonNull String message, minevalley.core.api.ChatMenu chatMenu, @NonNull Notice notice);

    /**
     * Sends a message to this user with a specific prefix, using ComponentBuilders.
     *
     * @param messageType   type of prefix to be displayed in front of the message
     * @param baseComponent message to be sent as string
     * @param chatMenu      menu to attach underneath the message
     */
    @SuppressWarnings("removal")
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull MessageType messageType, @NonNull BaseComponent[] baseComponent, minevalley.core.api.ChatMenu chatMenu);

    /**
     * Sends a message to this user with a specific prefix, using ComponentBuilders.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param messageType   type of prefix to be displayed in front of the message
     * @param baseComponent message to be sent as string
     * @param chatMenu      menu to attach underneath the message
     * @param notice        notice that is sent to the user
     */
    @SuppressWarnings("removal")
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull MessageType messageType, @NonNull BaseComponent[] baseComponent, minevalley.core.api.ChatMenu chatMenu, @NonNull Notice notice);

    /**
     * Sends a message to this user, with using ComponentBuilders. This way you can use hover and click-events and can take advantage of the clickable messages.
     *
     * @param baseComponent base-component which can be created by "new ComponentBuilder().create()"
     * @param chatMenu      menu to attach underneath the message
     */
    @SuppressWarnings("removal")
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull BaseComponent[] baseComponent, minevalley.core.api.ChatMenu chatMenu);

    /**
     * Sends a message to this user, with using ComponentBuilders. This way you can use hover and click-events and can take advantage of the clickable messages.
     * The message includes a notice that the user can click to get more information about the message.
     *
     * @param baseComponent base-component which can be created by "new ComponentBuilder().create()"
     * @param chatMenu      menu to attach underneath the message
     * @param notice        notice that is sent to the user
     */
    @SuppressWarnings("removal")
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull BaseComponent[] baseComponent, minevalley.core.api.ChatMenu chatMenu, @NonNull Notice notice);

    /**
     * Sends a message to the user providing useful side information. The user can click a button so that the message will not be sent the next time.
     *
     * @param notice notice that is sent to the user
     */
    @Deprecated(forRemoval = true)
    void sendMessage(@NonNull Notice notice);

    /**
     * Sends the usual "Unbekannter Befehl!"-error to the user. Mostly used when a player is trying to execute a command that they are not allowed to do.
     */
    @Deprecated(forRemoval = true)
    void sendError();

    // ChatInput

    /**
     * Asks the player for any type of input via a chat-interface. The player can leave this interface. If he writes something into this interface, the callback gets called.
     *
     * @param message  the message to be sent to the player. Normally containing a question or a request to put in any data
     * @param callback the callback that is called when the player makes an entry in the chat-interface. The consumer contains a string of the message.
     */
    @Deprecated(forRemoval = true)
    void input(@NonNull String message, @NonNull Consumer<String> callback);

    /**
     * Gets whether the user is currently in a chat input.
     *
     * @return true, if the user is in a chat input
     */
    @Deprecated(forRemoval = true)
    @Contract(pure = true)
    boolean isInChatInput();

    /**
     * Lets the user leave his current chat input
     */
    @Deprecated(forRemoval = true)
    void leaveChatInput();

    /**
     * Asks the user which bank account he wants to use (e.g. to pay sth)
     * He can choose from every bank account he's permissioned to transfer money from.
     * If he chooses nothing, the callback isn't called.
     * If he's only permissioned to transfer money from one account, he will not be asked (The callback will be called immediately with the account).
     *
     * @param callback            callback with the chosen bank account
     * @param requiredPermissions permissions that need to be granted to this user to let him choose the specific bank account
     */
    void askForBankAccount(@Nonnull Consumer<BankAccount> callback, @Nonnull AccountUser.BankAccountUserPermission... requiredPermissions) throws IllegalArgumentException;

    // FractionService

    /**
     * Gets the user's fraction.
     * Note: The user must be in fraction-service, otherwise this is NONE
     *
     * @return users fraction
     */
    @Contract(pure = true)
    Fraction getFractionService();

    void enterFractionService(@Nonnull Fraction service) throws IllegalArgumentException;

    void leaveFractionService();

    // TeamRank

    /**
     * Gets the team-member object of this user.
     *
     * @return team-member object
     * @throws UserNotPermittedException if the user is no team-member
     */
    @Nonnull
    TeamMember team() throws UserNotPermittedException;

    /**
     * Gets if the player has any type of team-rank.
     *
     * @return true, if the user is part of the server-team (and in team-service)
     */
    @Contract(pure = true)
    boolean isTeamler();

    /**
     * Gets whether the player is team-member with the plus-rank.
     *
     * @return true, if the user is team-plus-member
     */
    @Deprecated(forRemoval = true)
    @Contract(pure = true)
    boolean isTeamPlus();

    /**
     * Gets the team-rank of this user.
     *
     * @return users team-rank
     */
    @Deprecated(forRemoval = true)
    @Nonnull
    @Contract(pure = true)
    TeamRank getTeamRank();

    /**
     * Gets the custom team rank name.
     * If no custom name is defined, this returns the name of the users team rank.
     *
     * @return [custom] team rank name
     */
    @Deprecated(forRemoval = true)
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
    @Deprecated(forRemoval = true)
    @Contract(pure = true)
    boolean isDisplayedAsTeamler();

    /**
     * Gets whether the user has any of the listed team-ranks.
     *
     * @param ranks list of team-ranks to be checked for
     * @return true, if the user has one of the ranks
     */
    @Deprecated(forRemoval = true)
    @Contract(pure = true)
    boolean hasTeamRank(@Nonnull TeamRank... ranks);

    /**
     * Gets whether the user is allowed to use a general-key
     *
     * @return true, if the player is allowed to use a general-key
     */
    @Deprecated(forRemoval = true)
    @Contract(pure = true)
    boolean isAllowedToUseGeneralKey();

    /**
     * Gets whether the user is using a general-key at the moment, by checking the item in his hand. If he is using a general-key without the permission to do, his key gets removed automatically.
     *
     * @return true, if the player is using a general-key
     */
    @Deprecated(forRemoval = true)
    @Contract(pure = true)
    boolean isUsingGeneralKey();

    /**
     * Lets the user enter the team-service. If the user isn't teamler, nothing happens.
     */
    void joinTeamService() throws UnsupportedOperationException, IllegalStateException;

    /**
     * Lets the user leave the team-service.
     */
    @Deprecated(forRemoval = true)
    void leaveTeamService() throws IllegalStateException;

    /**
     * Gets whether the user is allowed to enter the support-service.
     *
     * @return true, if the user is allowed to enter the support-service
     */
    @Deprecated(forRemoval = true)
    @Contract(pure = true)
    boolean canEnterSupportService();

    /**
     * Lets the user enter the support-service. If the user isn't allowed to, nothing happens.
     */
    @Deprecated(forRemoval = true)
    void joinSupportService() throws UnsupportedOperationException, IllegalStateException;

    /**
     * Lets the user leave the support-service.
     */
    @Deprecated(forRemoval = true)
    void leaveSupportService() throws IllegalStateException;

    /**
     * Gets whether the user is marked as server-operator (!= OP-permission)
     *
     * @return true, if the user is marked as server-operator
     */
    @Deprecated(forRemoval = true)
    @Contract(pure = true)
    boolean isOperator();

    /**
     * Gets whether the user is in support-service
     *
     * @return true, if the user is in support-service
     */
    @Deprecated(forRemoval = true)
    @Contract(pure = true)
    boolean isInSupportService();

    void heal();

    void revive() throws IllegalStateException;

    /**
     * Gets whether the user has reached the maximum idle time and is marked as afk.
     *
     * @return true, if the user reached the maximum idle time
     */
    @Contract(pure = true)
    boolean isIdle();

    /**
     * Gets whether this user is vanished (only team members can be vanished).
     *
     * @return true, if this user is vanished
     */
    @Contract(pure = true)
    boolean isVanish();

    /**
     * Defines whether this user is vanished.
     * <b>Note:</b> this method only changes the state (The user is still visible)
     *
     * @param vanish vanish state
     */
    void setVanish(boolean vanish) throws UnsupportedOperationException;

    /**
     * Imprisons this user.
     *
     * @param duration duration in minutes
     */
    void imprison(int duration) throws UnsupportedOperationException, IllegalStateException;

    /**
     * Releases this user from prison (im imprisoned).
     */
    void releaseFromPrison() throws IllegalStateException;

    /**
     * Gets whether the user has completed registration on our network.
     *
     * @return true, if the user is registered
     */
    @Contract(pure = true)
    boolean isRegistered();

    /**
     * Gets whether this user is allowed to break/place/use a block at the given position regarding the regions-system.
     *
     * @param block block to check
     * @return true, if this user is allowed to break/place/use a block here
     */
    @Contract(pure = true)
    boolean isAllowedToUse(Block block);

    void changeSign(@Nonnull Block block, @Nonnull String line1, @Nonnull String line2, @Nonnull String line3, @Nonnull String line4) throws IllegalArgumentException;

    void resetSign(@Nonnull Block block) throws IllegalArgumentException;

    void setNavigationTarget(@Nonnull Location location) throws IllegalArgumentException;

    void resetNavigationTarget();

    void updateLatestJoin();

    @Contract(pure = true)
    default LoadedVehicle getVehicle() {
        final Entity vehicle = getPlayer().getVehicle();
        if (vehicle == null) return null;
        if (!(vehicle instanceof ArmorStand)) return null;
        return VehicleManager.getVehicle((ArmorStand) vehicle);
    }

    void checkRegistration();

    default void chat(@Nonnull ChatType type, @Nonnull String message) throws IllegalArgumentException {
        ChatHandler.chat(this, type, message);
    }

    default void chat(@Nonnull String message) throws IllegalArgumentException {
        ChatHandler.chat(this, ChatType.NORMAL, message);
    }

    void performCommand(@Nonnull String command) throws IllegalArgumentException;

    boolean addItem(@Nonnull ItemStack item) throws IllegalArgumentException;

    @Contract(pure = true)
    int getAmountOfFreeInventorySlots();

    @Contract(pure = true)
    default boolean hasFreeInventorySlot() {
        return getAmountOfFreeInventorySlots() != 0;
    }

    @Contract(pure = true)
    @Nonnull
    PlayerLocation getLocation();

    /**
     * Creates a clickable message without any specifications.
     *
     * @return new clickable message
     */
    ClickableMessage createClickableMessage();

    /**
     * Creates a clickable message that executes the given callback.
     *
     * @param callback callback to be executed if player clicks the message
     * @return new clickable message
     */
    ClickableMessage createClickableMessage(Runnable callback);

    /**
     * Creates a clickable message that executes the given callback, and is only clickable once (if selfCancelling is true).
     *
     * @param selfCancelling defines if the message is clickable multiple times
     * @param callback       callback to be executed if player clicks the message
     * @return new clickable message
     */
    ClickableMessage createClickableMessage(boolean selfCancelling, Runnable callback);

    @Deprecated(forRemoval = true)
    ClickEvent createClickEvent(boolean selfCancelling, Runnable callback);

    /**
     * Checks whether the user is in a virtual box whose span in each direction is twice the specified range.
     * <br>
     * Use this method instead of the distance()-method. It is significantly faster, but not recommended for precise applications
     *
     * @param location location to check distance from
     * @param range    maximum range for the result to be true
     * @return true, if user is in range
     */
    boolean isInCubicRange(@Nonnull Location location, int range) throws IllegalArgumentException;

    /**
     * Checks whether the user is in a virtual sphere whose radius is the square root of specified range.
     * <p>
     * <b>Note:</b> This method is significantly faster than the distance()-method. Especially when checking for constant distances.
     * </p>
     *
     * @param location     location to check distance from
     * @param rangeSquared maximum range for the result to be true
     * @return true, if user is in range
     */
    boolean isInSquaredRange(@Nonnull Location location, int rangeSquared) throws IllegalArgumentException;

    /**
     * Checks whether the user is in a virtual sphere whose radius is the specified range.
     *
     * @param location location to check distance from
     * @param range    maximum range for the result to be true
     * @return true, if user is in range
     */
    default boolean isInRange(@Nonnull Location location, int range) throws IllegalArgumentException {
        return isInSquaredRange(location, range * range);
    }

    record Notice(@Nonnull String id, @Nonnull String message) {
    }

    enum ChatType {
        NORMAL,
        WHISPER,
        SHOUT,
        FRACTION_CHAT,
        ACTION
    }
}