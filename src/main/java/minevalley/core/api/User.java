package minevalley.core.api;

import minevalley.core.api.enums.DebugType;
import minevalley.core.api.enums.Education;
import minevalley.core.api.enums.Purchase;
import minevalley.core.api.phone.Telephone;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface User extends Registered {

    OnlineUser getOnlineUser();

    boolean isOnline();

    /**
     * Gets the unique id of this user.
     *
     * @return unique id as string
     */
    String getUniqueId();

    /**
     * Gets the id of this user.
     *
     * @return id as string
     */
    String getId();

    String getName();

    /**
     * Gets the head of this user.
     *
     * @return player-head as itemstack
     */
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
    Telephone getTelephone();

    /**
     * Gets a list of the users friends.
     *
     * @return list of the users friends
     */
    List<User> getFriends();

    /**
     * Adds a user to this users friend list and vice versa.
     *
     * @param user user to add to friend list
     */
    void addFriend(User user);

    /**
     * Removes a user from this users friend list and vice versa.
     *
     * @param user user to remove from friend list
     */
    void removeFriend(User user);

    /**
     * Gets a list of the unique ids of this users spouses
     *
     * @return list of the users spouses unique ids as strings
     */
    List<User> getMarriage();

    void addToMarriage(User user);

    void leaveMarriage();

    /**
     * Gets a list of the blocked users.
     *
     * @return list of the users, which were at this users bell blacklist
     */
    List<User> getBellBlacklist();

    /**
     * Adds the user to this users bell blacklist.
     *
     * @param user unique id of the user to block
     */
    void removeFromBellBlacklist(User user);

    /**
     * Removes the user with the specific unique id from this users bell blacklist.
     *
     * @param user user to block
     */
    void addToBellBlacklist(User user);

    /**
     * Gets a specific setting that the user can change.
     * <p>
     * <b>Note:</b> If the user did not provide a value, this will return null!
     *
     * @param key key of the setting
     * @return value of the setting
     */
    String getUserSetting(String key);

    /**
     * Gets a specific setting that the user can change.
     *
     * @param key          key of the setting
     * @param defaultValue value that is returned, if the setting is null
     * @return value of the setting
     */
    String getUserSetting(String key, String defaultValue);

    /**
     * Updates the value of a specific setting.
     * <p>
     * <b>Note:</b> Neither the key nor the value must not contain non alphabetic characters! Otherwise the this method will not work properly...
     *
     * @param key      key of the setting
     * @param newValue new value of the setting
     */
    void changeUserSetting(String key, String newValue);

    // TeamRank

    /**
     * Gets whether the user is allowed to join team service.
     *
     * @return true, if the user is allowed to join team service
     */
    boolean isTeamAuth();

    void addDebug(DebugType debugType);

    boolean hasDebug(DebugType debugType);

    List<DebugType> getDebugs();

    void removeDebug(DebugType debugType);

    void removeAllDebugs();

    // Education

    /**
     * Gets a list of the users education.
     *
     * @return list of users education
     */
    Education[] getEducation();

    /**
     * Gets a list of the active products, that this user bought.
     *
     * @return list of purchases
     */
    Purchase[] getPurchased();

    /**
     * Checks whether this user purchases the specific product.
     *
     * @param purchase product to check
     * @return true, if this user purchases the specific product.
     */
    boolean purchased(Purchase purchase);

    /**
     * Gets whether the user has the specific education.
     *
     * @return true, if the user has the specific education
     */
    boolean hasEducation(Education education);

    /**
     * Gets whether the user has a drivers license.
     *
     * @return true, if the user has a drivers license
     */
    boolean hasDriversLicense();

    /**
     * Gets the level of the users gun license.
     *
     * @return level of users gun license (0 -> no license)
     */
    int getGunLicense();

    // Cash

    /**
     * Gets the current amount of cash in the users wallet.
     *
     * @return the current amount of cash in the users wallet
     */
    double getCash();

    /**
     * Removes a certain amount of cash of the users wallet.
     *
     * @param amount amout to remove
     * @return true, if the transaction was successful. If the user doesn't have enough money, this is false
     */
    boolean payCash(double amount);

    /**
     * Updates the users cash from the database
     */
    void updateCash();

    // WantedLevel & KnockOut

    /**
     * Gets the wanted-level of the user.
     *
     * @return wanted-level of the user. 0 if the player isn't wanted
     */
    int getWantedLevel();

    /**
     * Sets the wanted-level of the user
     *
     * @param level new wanted-level
     */
    void setWantedLevel(int level);

    /**
     * Gets whether the user is knocked out.
     *
     * @return true, if the user is knocked out
     */
    boolean isKnockedOut();

    /**
     * Gets whether the user is locked up in one of the state prisons.
     *
     * @return true, if the user is locked up in prison
     */
    boolean isImprisoned();

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

    /**
     * Players can be freezed by a team member. This method gets wether this user is freezed.
     *
     * @return true, if the user is currently freezed
     */
    boolean isFrozen();

    /**
     * Freezes this user.
     */
    void freeze();

    /**
     * Unfreezes this user.
     */
    void unfreeze();

    long getLatestJoin();

    String getLatestJoinFormatted();
}