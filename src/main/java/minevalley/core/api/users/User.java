package minevalley.core.api.users;

import minevalley.core.api.Depends;
import minevalley.core.api.Registrant;
import minevalley.core.api.corporations.Member;
import minevalley.core.api.enums.DebugType;
import minevalley.core.api.phone.Telephone;
import minevalley.core.api.users.exceptions.UserNotOnlineException;
import minevalley.core.api.users.exceptions.UserNotPermittedException;
import minevalley.core.api.users.friends.FriendRequest;
import minevalley.core.api.users.friends.Friendship;
import minevalley.core.api.users.statistics.Statistics;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;
import java.util.UUID;

@SuppressWarnings("unused")
public interface User extends Registrant {

    /**
     * Gets the online user-object of this user.
     *
     * @return online user-object
     * @throws UserNotOnlineException if the user is not online
     */
    @Nonnull
    @Contract(pure = true)
    OnlineUser online() throws UserNotOnlineException;

    @Nonnull
    @Depends("UserStatistics")
    @Contract(value = "-> new", pure = true)
    default Statistics statistics() {
        return new Statistics(this);
    }

    /**
     * Gets whether this user is online.
     *
     * @return true, if the user is online
     */
    @Contract(pure = true)
    boolean isOnline();

    /**
     * Gets the unique id of this user.
     *
     * @return unique id as string
     */
    @Nonnull
    @Contract(pure = true)
    UUID getUniqueId();

    /**
     * Gets the name of this user.
     *
     * @return name of this user
     */
    @Nonnull
    @Contract(pure = true)
    String getName();

    /**
     * Gets the head of this user.
     *
     * @return player-head as itemstack
     */
    @Nonnull
    @Contract(pure = true)
    ItemStack getPlayerHead();

    /**
     * Removes the whole user-object and loads it again from the database.
     */
    void refresh();

    // Accounts and socials

    /**
     * Gets the users telephone
     *
     * @return telephone of this user
     */
    @Nonnull
    @Contract(pure = true)
    Telephone getTelephone();

    /**
     * Gets a set of the users friends.
     *
     * @return set of the users friends
     */
    @Nonnull
    @Contract(pure = true)
    Set<User> getFriends();

    /**
     * Gets a set of the user's friendships.
     *
     * @return set of the user's friendships
     */
    @Nonnull
    @Contract(pure = true)
    Set<Friendship> getFriendships();

    /**
     * Gets a set of the users received friend requests.
     *
     * @return set of the users received friend requests
     */
    @Nonnull
    @Contract(pure = true)
    Set<FriendRequest> getReceivedFriendRequests();

    /**
     * Gets a set of the users sent friend requests.
     *
     * @return set of the users sent friend requests
     */
    @Nonnull
    @Contract(pure = true)
    Set<FriendRequest> getPendingFriendRequests();

    /**
     * Adds a user to this users friend list and vice versa.
     *
     * @param user user to add to friend list
     * @throws IllegalArgumentException if the user is null or already a friend
     */
    void addFriend(@Nonnull User user) throws IllegalArgumentException;

    /**
     * Gets a list of the unique ids of this user's spouses
     *
     * @return list of the users spouses unique ids as strings
     */
    @Nullable
    @Contract(pure = true)
    Marriage getMarriage();

    /**
     * Gets a set of the blocked users.
     *
     * @return set of the users, which were at this users bell blacklist
     */
    @Nonnull
    @Contract(pure = true)
    Set<User> getBellBlacklist();

    /**
     * Adds the user to this users bell blacklist.
     *
     * @param user unique id of the user to block
     * @throws IllegalArgumentException if the user is null or not on the blacklist
     */
    void removeFromBellBlacklist(@Nonnull User user) throws IllegalArgumentException;

    /**
     * Removes the user with the specific unique id from this users bell blacklist.
     *
     * @param user user to block
     * @throws IllegalArgumentException if the user is null or already on the blacklist
     */
    void addToBellBlacklist(@Nonnull User user) throws IllegalArgumentException;

    /**
     * Gets a specific setting that the user can change.
     * <p>
     * <b>Note:</b> If the user did not provide a value, this will return null!
     *
     * @param key key of the setting
     * @return value of the setting
     * @throws IllegalArgumentException if the key is null or empty
     */
    @Nullable
    @Contract(pure = true)
    String getUserSetting(@Nonnull String key) throws IllegalArgumentException;

    /**
     * Gets a specific setting that the user can change.
     *
     * @param key          key of the setting
     * @param defaultValue value that is returned, if the setting is null
     * @return value of the settings
     * @throws IllegalArgumentException if the key is null or empty or the default value is null
     */
    @Nonnull
    @Contract(pure = true)
    String getUserSetting(@Nonnull String key, @Nonnull String defaultValue) throws IllegalArgumentException;

    /**
     * Updates the value of a specific setting.
     *
     * @param key      key of the setting
     * @param newValue new value of the setting
     * @throws IllegalArgumentException if the key or value is null or empty
     */
    void changeUserSetting(@Nonnull String key, @Nonnull String newValue) throws IllegalArgumentException;

    /**
     * Gets whether the user is allowed to join team service.
     *
     * @return true, if the user is allowed to join team service
     */
    @Contract(pure = true)
    boolean isTeamAuth();

    /**
     * Adds a debug to this user's debug list.
     *
     * @param debugType debug to add
     * @throws IllegalArgumentException  if the debug is null or already in the list
     * @throws UserNotPermittedException if the user is not allowed to receive debugs
     */
    void addDebug(@Nonnull DebugType debugType) throws IllegalArgumentException, UserNotPermittedException;

    /**
     * Gets whether the user has the specific debug.
     *
     * @param debugType debug to check
     * @return true, if the user has the specific debug
     * @throws IllegalArgumentException if the debug is null
     */
    @Contract(pure = true)
    boolean hasDebug(@Nonnull DebugType debugType) throws IllegalArgumentException;

    /**
     * Gets a set of the user's debugs.
     * <p>
     * <b>Note:</b> If the user is not allowed to receive debugs, this will return an empty list!
     * </p>
     *
     * @return set of the user's debugs
     */
    @Nonnull
    @Contract(pure = true)
    Set<DebugType> getDebugs();

    /**
     * Removes a debug from this user's debug list.
     *
     * @param debugType debug to remove
     * @throws IllegalArgumentException if the debug is null or not in the list
     */
    void removeDebug(@Nonnull DebugType debugType) throws IllegalArgumentException;

    /**
     * Removes all debugs from this user's debug list.
     */
    void removeAllDebugs();

    /**
     * Gets a list of the user's education.
     *
     * @return set of users education
     */
    @Nonnull
    @Contract(pure = true)
    Set<Education> getEducation();

    /**
     * Gets whether the user is educated in a specific subject.
     *
     * @param subject subject to check
     * @return true, if the user is educated in the specific subject
     * @throws IllegalArgumentException if the subject is null
     */
    @Contract(pure = true)
    boolean isEducated(@Nonnull Education.Subject subject) throws IllegalArgumentException;

    /**
     * Gets whether the user has a driver's license.
     *
     * @return true, if the user has a driver's license
     */
    @Contract(pure = true)
    default boolean hasDriversLicense() {
        return isEducated(Education.Subject.DRIVERS_LICENSE);
    }

    /**
     * Gets a set of the active products, that this user bought.
     *
     * @return set of purchases
     */
    @Nonnull
    Set<Purchase> getPurchases();

    /**
     * Adds a purchase to this user's purchase list.
     *
     * @param purchase purchase to add
     * @throws IllegalArgumentException if purchase is null
     */
    void addPurchase(@Nonnull Purchase purchase) throws IllegalArgumentException;

    /**
     * Removes a purchase from this user's purchase list.
     *
     * @param purchase purchase to remove
     * @throws IllegalArgumentException if purchase is null
     */
    void removePurchase(@Nonnull Purchase purchase) throws IllegalArgumentException;

    /**
     * Gets whether the user has an active premium membership.
     *
     * @return true, if the user is premium
     */
    @Contract(pure = true)
    boolean isPremium();

    /**
     * Gets the current amount of cash in the user's wallet.
     *
     * @return the current amount of cash in the users wallet
     */
    @Contract(pure = true)
    int getCashInCents();

    /**
     * Removes a certain amount of cash of the user's wallet.
     *
     * @param amountInCents amount to remove
     * @return true, if the transaction was successful. If the user doesn't have enough money, this is false
     * @throws IllegalArgumentException if the amount is negative or zero
     */
    boolean payCash(@Nonnegative int amountInCents) throws IllegalArgumentException;

    /**
     * Gets whether the user is knocked out.
     *
     * @return true, if the user is knocked out
     */
    @Contract(pure = true)
    boolean isKnockedOut();

    /**
     * Gets whether the user is locked up in one of the state prisons.
     *
     * @return true, if the user is locked up in prison
     */
    @Contract(pure = true)
    boolean isImprisoned();

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
     * @throws IllegalArgumentException if the block is null
     */
    boolean isAllowedToUse(@Nonnull Block block) throws IllegalArgumentException;

    /**
     * Players can be frozen by a team member. This method gets whether this user is frozen.
     *
     * @return true, if the user is currently frozen
     */
    @Contract(pure = true)
    boolean isFrozen();

    /**
     * Freezes this user.
     */
    void freeze();

    /**
     * Unfreezes this user.
     */
    void unfreeze();

    /**
     * Gets the latest join of this user.
     *
     * @return latest join as timestamp (milliseconds since 1970)
     */
    @Contract(pure = true)
    long getLatestJoin();

    /**
     * Gets the latest join of this user, formatted as a readable string.
     *
     * @return latest join as a readable string
     */
    @Nonnull
    @Contract(pure = true)
    String getLatestJoinFormatted();

    /**
     * Gets the current tutorial step of this user.
     *
     * @return current tutorial step as int
     */
    @Contract(pure = true)
    int getTutorialStep();

    /**
     * Sets the current tutorial step of this user.
     *
     * @param step new tutorial step
     */
    void setTutorialStep(int step);

    /**
     * Gets whether this user is in the tutorial.
     *
     * @return true, if the user is in the tutorial
     */
    default boolean isInTutorial() {
        return getTutorialStep() != -1;
    }

    /**
     * Gets a list of the users installed smart apps.
     *
     * @return list of the users installed smart apps
     */
    @Nonnull
    @Contract(pure = true)
    Set<String> getInstalledSmartApps();

    /**
     * Installs a smart app this user's phone.
     *
     * @param systemName name of the smart app
     * @throws IllegalArgumentException if the system name is null or empty
     */
    void installSmartApp(@Nonnull String systemName) throws IllegalArgumentException;

    /**
     * Uninstalls a smart app from this user's phone.
     *
     * @param systemName name of the smart app
     * @throws IllegalArgumentException if the system name is null or empty or the app is not installed
     */
    void uninstallSmartApp(@Nonnull String systemName) throws IllegalArgumentException;

    /**
     * Gets a set of all the Member objects that are related to this user.
     *
     * @return set of all the Member objects that are related to this user
     */
    @Nonnull
    @Contract(pure = true)
    Set<Member> getRelatedGroupMembers();
}