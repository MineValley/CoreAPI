package minevalley.core.api.users;

import minevalley.core.api.audio.SoundReceiver;
import minevalley.core.api.localization.PlayerLocation;
import minevalley.core.api.messaging.DialogReceiver;
import minevalley.core.api.messaging.MessageReceiver;
import minevalley.core.api.users.chat.ChatProvider;
import minevalley.core.api.users.chat.ChatType;
import minevalley.core.api.users.enums.Fraction;
import minevalley.core.api.users.enums.McVersion;
import minevalley.core.api.users.enums.TabListView;
import minevalley.core.api.users.exceptions.UserNotPermittedException;
import minevalley.core.api.utils.ClickableMessage;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Duration;
import java.util.function.BiConsumer;

@SuppressWarnings("unused")
public interface ProxyUser extends User, DialogReceiver, MessageReceiver, SoundReceiver {

    /**
     * Gets the team-member object of this user.
     *
     * @return team-member object
     * @throws UserNotPermittedException if the user is no team-member
     * @see #isTeamler()
     */
    @Nonnull
    @Contract(pure = true)
    TeamMember team() throws UserNotPermittedException;

    /**
     * Joins the team-service.
     *
     * @throws UnsupportedOperationException if the user is not allowed to join the team-service
     * @throws IllegalStateException         if the user is already in a service
     */
    void joinTeamService() throws UnsupportedOperationException, IllegalStateException;

    /**
     * Gets if the player has any type of team-rank.
     *
     * @return true, if the user is part of the server-team (and in team-service)
     */
    @Contract(pure = true)
    boolean isTeamler();

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
     * Gets the user's fraction.
     * Note: The user must be in fraction-service, otherwise this is NONE
     *
     * @return users fraction
     */
    @Nullable
    @Contract(pure = true)
    Fraction getFractionService();

    /**
     * Sets the user's current fraction service.
     *
     * @param service fraction to enter service
     * @throws IllegalArgumentException  if the service is null
     * @throws UserNotPermittedException if the user is not allowed to enter the service
     * @throws IllegalStateException     if the user is already in a service
     */
    void enterFractionService(@Nonnull Fraction service) throws IllegalArgumentException, UserNotPermittedException,
            IllegalStateException;

    /**
     * Lets the user leave the fraction-service.
     *
     * @throws IllegalStateException if the user is not in a service
     */
    void leaveFractionService() throws IllegalStateException;

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
     * Sets whether this user is vanished.
     *
     * @param vanish true, if this user should be vanished
     * @throws UnsupportedOperationException if the user is not allowed to vanish
     */
    void setVanish(boolean vanish) throws UnsupportedOperationException;

    /**
     * Revives the user if he's dead.
     *
     * @throws IllegalStateException if the user is not dead
     */
    void revive() throws IllegalStateException;

    /**
     * Imprisons this user for the given duration.
     *
     * @param duration duration of the imprisonment
     * @throws UnsupportedOperationException if the user cannot be imprisoned (e.g. because he's a team-member)
     * @throws IllegalStateException         if the user is already in prison
     */
    void imprison(@Nonnull Duration duration) throws UnsupportedOperationException, IllegalStateException;

    /**
     * Releases this user from prison.
     *
     * @throws IllegalStateException if the user is not in prison
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
     * Clears the registration cache of this user and checks if he is now registered.
     */
    void checkRegistration();

    /**
     * Adds an item to the users inventory.
     *
     * @param item     item to add
     * @param callback callback to be executed after the item was added
     * @throws IllegalArgumentException if the item is null
     */
    void addItem(@Nonnull ItemStack item, @Nonnull BiConsumer<ProxyUser, Boolean> callback) throws IllegalArgumentException;

    /**
     * Gets the amount of free slots in the users inventory (equipment slots not included).
     *
     * @param callback callback to be executed after the amount was calculated
     */
    @Nonnegative
    @Contract(pure = true)
    void getAmountOfFreeInventorySlots(@Nonnull BiConsumer<ProxyUser, Integer> callback);

    /**
     * Checks for any free slots in the users inventory (equipment slots not included)
     *
     * @param callback callback to be executed after the check
     */
    @Contract(pure = true)
    default void hasFreeInventorySlot(@Nonnull BiConsumer<ProxyUser, Boolean> callback) {
        getAmountOfFreeInventorySlots((user, amount) -> {
            if (amount > 0) callback.accept(user, true);
            else callback.accept(user, false);
        });
    }

    /**
     * Gets this users player location.
     *
     * @param callback callback to be executed after the location was retrieved
     */
    @Contract(pure = true)
    void getLocation(@Nonnull BiConsumer<ProxyUser, PlayerLocation> callback);

    /**
     * Sends a chat message as the specified user.
     *
     * @param type    type of the chat message
     * @param message message to send
     * @throws IllegalArgumentException if either the type or message is null, or if the message is empty
     */
    default void chat(@Nonnull ChatType type, @Nonnull String message) throws IllegalArgumentException {
        ChatProvider.chat(this, type, message);
    }

    /**
     * Sends a normal chat message as the specified user.
     *
     * @param message message to send
     * @throws IllegalArgumentException if the message is null or empty
     */
    default void chat(@Nonnull String message) throws IllegalArgumentException {
        ChatProvider.chat(this, ChatType.NORMAL, message);
    }

    /**
     * Performs a command in the name of the user
     *
     * @param command command with the slash
     * @throws IllegalArgumentException if the command is null, or does not start with a slash
     */
    void performCommand(@Nonnull String command) throws IllegalArgumentException;

    /**
     * Creates a clickable message that executes the given callback, and is only clickable once (if selfCancelling is true).
     *
     * @param selfCancelling defines if the message is clickable multiple times
     * @return new clickable message
     */
    @Nonnull
    @Contract("_ -> new")
    ClickableMessage createClickableMessage(boolean selfCancelling);

    /**
     * Creates a clickable message that executes the given callback, and is only clickable once (if selfCancelling is true).
     *
     * @param selfCancelling defines if the message is clickable multiple times
     * @param callback       callback to be executed if player clicks the message
     * @return new clickable message
     */
    @Nonnull
    @Contract("_, _ -> new")
    ClickableMessage createClickableMessage(boolean selfCancelling, @Nonnull Runnable callback);
}