package minevalley.core.api.users;

import minevalley.core.api.banking.AccountUser;
import minevalley.core.api.banking.BankAccount;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public interface OnlineUser extends ProxyUser {

    /**
     * Gets the player object of this user.
     *
     * @return player object
     */
    @Nonnull
    @Contract(pure = true)
    Player player();

    /**
     * Closes the inventory of this user.
     */
    default void closeInventory() {
        player().closeInventory();
    }

    /**
     * Update the list of commands sent to the client.
     * <p>
     * Generally useful to ensure the client has a complete list of commands
     * after permission changes are done.
     * </p>
     */
    void updateCommands();

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
     * Asks the user which bank account he wants to use (e.g. to pay sth)
     * He can choose from every bank account he's permissioned to transfer money from.
     * If he chooses nothing, the callback isn't called.
     * If he's allowed to transfer money from only one account, he will not be asked
     * (The callback will be called immediately with the account).
     *
     * @param callback            callback with the chosen bank account
     * @param requiredPermissions permissions that need to be granted to this user to let him choose the specific bank account
     * @throws IllegalArgumentException if the callback or requiredPermissions are null
     */
    void askForBankAccount(@Nonnull Consumer<BankAccount> callback,
                           @Nonnull AccountUser.BankAccountUserPermission... requiredPermissions)
            throws IllegalArgumentException;

    /**
     * Sets the user's health to the maximum.
     *
     * @return the amount of half hearts the user was healed
     */
    @Nonnegative
    int heal();

    /**
     * Gets whether this user is allowed to break/place/use a block at the given position regarding the regions-system.
     *
     * @param block block to check
     * @return true, if this user is allowed to break/place/use a block here
     * @throws IllegalArgumentException if the block is null
     */
    @Contract(pure = true)
    boolean isAllowedToUse(@Nonnull Block block) throws IllegalArgumentException;

    /**
     * Send a sign change to this user.
     *
     * @param block sign to change
     * @param line1 first line
     * @param line2 second line
     * @param line3 third line
     * @param line4 fourth line
     * @throws IllegalArgumentException if the sign is null or not a sign.
     */
    void changeSign(@Nonnull Block block, @Nullable String line1, @Nullable String line2, @Nullable String line3,
                    @Nullable String line4) throws IllegalArgumentException;

    /**
     * Resets a previously changed sign to its original state.
     *
     * @param block sign to reset
     * @throws IllegalArgumentException if the sign is null or not a sign.
     */
    void resetSign(@Nonnull Block block) throws IllegalArgumentException;

    /**
     * Sets this users navigation target.
     *
     * @param location location to set the target to
     * @throws IllegalArgumentException if the location is null
     */
    void setNavigationTarget(@Nonnull Location location) throws IllegalArgumentException;

    /**
     * Resets the navigation target.
     */
    void resetNavigationTarget();

    /**
     * Sets the latest join to now.
     */
    void updateLatestJoin();

    /**
     * Checks whether the user is in a virtual box whose span in each direction is twice the specified range.
     * <br>
     * Use this method instead of the distance()-method. It is significantly faster, but not recommended for precise applications
     *
     * @param location location to check distance from
     * @param range    maximum range for the result to be true
     * @return true, if the user is in range
     * @throws IllegalArgumentException if location is null or range is negative
     */
    boolean isInCubicRange(@Nonnull Location location, @Nonnegative int range) throws IllegalArgumentException;

    /**
     * Checks whether the user is in a virtual sphere whose radius is the square root of the specified range.
     * <p>
     * <b>Note:</b> This method is significantly faster than the distance()-method. Especially when checking for constant distances.
     * </p>
     *
     * @param location     location to check distance from
     * @param rangeSquared maximum range for the result to be true
     * @return true, if the user is in range
     * @throws IllegalArgumentException if location is null or rangeSquared is negative
     */
    boolean isInSquaredRange(@Nonnull Location location, @Nonnegative int rangeSquared) throws IllegalArgumentException;

    /**
     * Checks whether the user is in a virtual sphere whose radius is the specified range.
     *
     * @param location location to check distance from
     * @param range    maximum range for the result to be true
     * @return true, if the user is in range
     * @throws IllegalArgumentException if location is null or range is negative
     */
    default boolean isInRange(@Nonnull Location location, @Nonnegative int range) throws IllegalArgumentException {
        if (location == null) throw new IllegalArgumentException("Location cannot be null");
        if (range < 0) throw new IllegalArgumentException("Range cannot be negative");
        return isInSquaredRange(location, range * range);
    }
}