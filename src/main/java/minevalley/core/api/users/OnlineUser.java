package minevalley.core.api.users;

import minevalley.core.api.economy.AccountUser;
import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.regions.utils.PlayerLocation;
import minevalley.core.api.users.enums.Fraction;
import minevalley.core.api.users.enums.McVersion;
import minevalley.core.api.users.enums.TabListView;
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
public interface OnlineUser extends ProxyUser {

    /**
     * Gets the player object of this user.
     *
     * @return player object
     */
    @Nonnull
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
     * If he's only permissioned to transfer money from one account, he will not be asked (The callback will be called immediately with the account).
     *
     * @param callback            callback with the chosen bank account
     * @param requiredPermissions permissions that need to be granted to this user to let him choose the specific bank account
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

    enum ChatType {
        NORMAL,
        WHISPER,
        SHOUT,
        FRACTION_CHAT,
        ACTION
    }
}