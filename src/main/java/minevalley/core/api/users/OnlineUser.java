package minevalley.core.api.users;

import minevalley.core.api.audio.SoundReceiver;
import minevalley.core.api.economy.AccountUser;
import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.messaging.DialogReceiver;
import minevalley.core.api.messaging.MessageReceiver;
import minevalley.core.api.messaging.instruction.Instruction;
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
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Duration;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public interface OnlineUser extends User, DialogReceiver, MessageReceiver, SoundReceiver {

    /**
     * Gets the player object of this user.
     *
     * @return player object
     */
    @Nonnull
    Player player();

    /**
     * Gets if the player has any type of team-rank.
     *
     * @return true, if the user is part of the server-team (and in team-service)
     */
    @Contract(pure = true)
    boolean isTeamler();

    /**
     * Gets whether the user has any of the listed team-ranks.
     *
     * @param ranks list of team-ranks to be checked for
     * @return true, if the user has one of the ranks
     */
    @Contract(pure = true)
    boolean hasTeamRank(@Nonnull TeamRank... ranks);

    /**
     * Gets the team-member object of this user.
     *
     * @return team-member object
     * @throws UserNotPermittedException if the user is no team-member
     * @see #isTeamler()
     */
    @Nonnull
    TeamMember team() throws UserNotPermittedException;

    /**
     * Joins the team-service.
     *
     * @throws UnsupportedOperationException if the user is not allowed to join the team-service
     * @throws IllegalStateException         if the user is already in a service
     */
    void joinTeamService() throws UnsupportedOperationException, IllegalStateException;

    /**
     * Closes the inventory of this user.
     */
    default void closeInventory() {
        player().closeInventory();
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

    /**
     * Gets the ambient this user is currently hearing
     *
     * @return ambient this user is hearing
     */
    @Nonnull
    @Contract(pure = true)
    Ambient getAmbient();

    /**
     * Sets the ambient this user is hearing
     *
     * @param ambient ambient to be set
     * @throws IllegalArgumentException if ambient is null
     */
    void setAmbient(@Nonnull Ambient ambient) throws IllegalArgumentException;

    /**
     * Starts the credits sequence.
     */
    void sendCredits();

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
     * Asks the user which bank account he wants to use (e.g. to pay sth)
     * He can choose from every bank account he's permissioned to transfer money from.
     * If he chooses nothing, the callback isn't called.
     * If he's only permissioned to transfer money from one account, he will not be asked (The callback will be called immediately with the account).
     *
     * @param callback            callback with the chosen bank account
     * @param requiredPermissions permissions that need to be granted to this user to let him choose the specific bank account
     */
    void askForBankAccount(@Nonnull Consumer<BankAccount> callback,
                           @Nonnull AccountUser.BankAccountUserPermission... requiredPermissions)
            throws IllegalArgumentException;

    // FractionService

    /**
     * Gets the user's fraction.
     * Note: The user must be in fraction-service, otherwise this is NONE
     *
     * @return users fraction
     */
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
     * Sets the user's health to the maximum.
     *
     * @return the amount of half hearts the user was healed
     */
    @Nonnegative
    int heal();

    /**
     * Revives the user if he's dead.
     *
     * @throws IllegalStateException if the user is not dead
     */
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
     * Sets whether this user is vanished.
     *
     * @param vanish true, if this user should be vanished
     * @throws UnsupportedOperationException if the user is not allowed to vanish
     */
    void setVanish(boolean vanish) throws UnsupportedOperationException;

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
     * Gets whether this user is allowed to break/place/use a block at the given position regarding the regions-system.
     *
     * @param block block to check
     * @return true, if this user is allowed to break/place/use a block here
     */
    @Contract(pure = true)
    boolean isAllowedToUse(Block block);

    void changeSign(@Nonnull Block block, @Nullable String line1, @Nullable String line2, @Nullable String line3,
                    @Nullable String line4) throws IllegalArgumentException;

    void resetSign(@Nonnull Block block) throws IllegalArgumentException;

    void setNavigationTarget(@Nonnull Location location) throws IllegalArgumentException;

    void resetNavigationTarget();

    void updateLatestJoin();

    @Contract(pure = true)
    default LoadedVehicle getVehicle() {
        final Entity vehicle = player().getVehicle();
        if (vehicle == null) return null;
        if (!(vehicle instanceof ArmorStand)) return null;
        return VehicleManager.getVehicle((ArmorStand) vehicle);
    }

    void checkRegistration();

    default void chat(@Nonnull ChatType type, @Nonnull String message) throws IllegalArgumentException {
        if (type == null) throw new IllegalArgumentException("Type cannot be null");
        ChatHandler.chat(this, type, message);
    }

    default void chat(@Nonnull String message) throws IllegalArgumentException {
        if (message == null) throw new IllegalArgumentException("Message cannot be null");
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

    @Nonnull
    @Contract(pure = true)
    PlayerLocation getLocation();

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

    /**
     * Checks whether the user is in a virtual box whose span in each direction is twice the specified range.
     * <br>
     * Use this method instead of the distance()-method. It is significantly faster, but not recommended for precise applications
     *
     * @param location location to check distance from
     * @param range    maximum range for the result to be true
     * @return true, if user is in range
     */
    boolean isInCubicRange(@Nonnull Location location, @Nonnegative int range) throws IllegalArgumentException;

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
    boolean isInSquaredRange(@Nonnull Location location, @Nonnegative int rangeSquared) throws IllegalArgumentException;

    /**
     * Checks whether the user is in a virtual sphere whose radius is the specified range.
     *
     * @param location location to check distance from
     * @param range    maximum range for the result to be true
     * @return true, if user is in range
     */
    default boolean isInRange(@Nonnull Location location, @Nonnegative int range) throws IllegalArgumentException {
        if (location == null) throw new IllegalArgumentException("Location cannot be null");
        if (range < 0) throw new IllegalArgumentException("Range cannot be negative");
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