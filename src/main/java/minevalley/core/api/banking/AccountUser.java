package minevalley.core.api.banking;

import minevalley.core.api.Registrant;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

@SuppressWarnings("unused")
public interface AccountUser {

    /**
     * Gets the registrant of this account user.
     *
     * @return registrant of this account user
     */
    @Nonnull
    @Contract(pure = true)
    Registrant getRegistrant();

    /**
     * Gets the bank account this user has access to.
     *
     * @return bank account this user has access to
     */
    @Nonnull
    @Contract(pure = true)
    BankAccount getBankAccount();

    /**
     * Gets the maximum payout per day in cents for this user.
     *
     * @return maximum payout per day in cents, -1 if unlimited
     */
    @Contract(pure = true)
    int getMaxPayoutPerDayInCents();

    /**
     * Sets the maximum payout per day in cents for this user.
     *
     * @param maxPayoutInCents maximum payout per day in cents, -1 for unlimited
     * @throws IllegalArgumentException if maxPayoutInCents is less than -1
     */
    void setMaxPayoutPerDayInCents(int maxPayoutInCents) throws IllegalArgumentException;

    /**
     * Gets the remaining daily payout in cents for this user.
     *
     * @return remaining daily payout in cents
     */
    @Contract(pure = true)
    int getRemainingDailyPayoutInCents();

    /**
     * Resets the remaining daily payout to the maximum payout per day.
     */
    void resetDailyPayout();

    /**
     * Checks if this user has a maximum payout per day.
     *
     * @return true if this user has a maximum payout per day, false if unlimited
     */
    @Contract(pure = true)
    default boolean hasMaxPayoutPerDay() {
        return getMaxPayoutPerDayInCents() != -1;
    }

    /**
     * Gets the permissions of this bank account user.
     *
     * @return set of permissions of this bank account user
     */
    @Nonnull
    @Contract(pure = true)
    Set<BankAccountUserPermission> getPermissions();

    /**
     * Checks if this user has the specified permission.
     *
     * @param permission permission to check for
     * @return true if this user has the specified permission, false otherwise
     */
    @Contract(value = "null -> true", pure = true)
    default boolean hasPermission(@Nullable BankAccountUserPermission permission) {
        if (permission == null) return true;
        return getPermissions().contains(permission);
    }

    /**
     * Grants the specified permission to this bank account user.
     *
     * @param permission permission to grant
     * @throws IllegalArgumentException if the permission is null
     * @throws IllegalStateException    if the user already has the permission
     */
    void grantPermission(@Nonnull BankAccountUserPermission permission) throws IllegalArgumentException, IllegalStateException;

    /**
     * Revokes the specified permission from this bank account user.
     *
     * @param permission permission to revoke
     * @throws IllegalArgumentException if the permission is null
     * @throws IllegalStateException    if the user does not have the permission
     */
    void revokePermission(@Nonnull BankAccountUserPermission permission) throws IllegalArgumentException, IllegalStateException;

    /**
     * Removes this account user from the bank account.
     * <p>
     * <b>Note:</b> This revoked all access of the user to the bank account.
     */
    void remove();

    /**
     * Permissions that can be granted to bank account users.
     */
    enum BankAccountUserPermission {
        CREATE_NEW_BANKING_CARDS,
        ADD_NEW_USERS,
        REMOVE_USERS
    }
}
