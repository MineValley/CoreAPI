package minevalley.core.api.banking;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.Core;
import minevalley.core.api.Registrant;
import minevalley.core.api.users.User;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public interface BankAccount {

    /**
     * Gets the holder of this bank account.
     *
     * @return holder of this bank account
     */
    @Nonnull
    @Contract(pure = true)
    Registrant getHolder();

    /**
     * Gets this accounts banking id.
     * <b>Note:</b> the IBAN already contains the prefix (DE00/01/02/03)
     *
     * @return this accounts banking id
     */
    @Nonnull
    @Contract(pure = true)
    String getIban();

    /**
     * Gets the amount of money in this bank account.
     *
     * @return amount of money in cents as integer.
     */
    @Nonnegative
    @Contract(pure = true)
    int getAmountInCents();

    /**
     * Gets a set of all account users associated with this account.
     *
     * @return set of all account users.
     */
    @Nonnull
    @Contract(pure = true)
    Set<AccountUser> getAccountUsers();

    /**
     * @param registrant registrant to get account user from
     * @return account user that is associated with the given registrant and this bank account, if existing.
     */
    @Nullable
    @Contract(value = "null -> null", pure = true)
    AccountUser getAccountUser(@Nullable Registrant registrant);

    /**
     * Gets whether the specific user has the permission to use this bank account.
     *
     * @param user user to check
     * @return true, if the specific user has the permission to use this bank account
     */
    @Contract(value = "null->false", pure = true)
    boolean hasPermission(@Nullable User user);

    /**
     * Gets the type of this bank account.
     *
     * @return type of this bank account
     */
    @Nonnull
    @Contract(pure = true)
    AccountType getType();

    /**
     * Transfers the given amount of money to another bank account.
     * <p>
     * <b>Note:</b> Always check the transfer result!
     *
     * @param target        account to transfer the money to
     * @param accountUser   user who initiated the transfer
     * @param amountInCents amount of money to transfer in cents
     * @param usage         a small text that describes the context of the transferal
     * @param callback      logic that will be executed after the transferal was executed
     * @throws IllegalArgumentException if the target, the account user or the callback is null, or the amount in cents are negative
     */
    void transfer(@Nonnull BankAccount target, @Nonnull AccountUser accountUser, int amountInCents,
                  @Nullable String usage, @Nonnull Consumer<TransferResult> callback) throws IllegalArgumentException;

    /**
     * Transfers the given amount of money to another bank account.
     * <p>
     * <b>Note:</b> Always check the transfer result!
     *
     * @param target        account to transfer the money to
     * @param amountInCents amount of money to transfer in cents
     * @param usage         a small text that describes the context of the transferal
     * @param callback      logic that will be executed after the transferal was executed
     * @throws IllegalArgumentException if the target, the account user or the callback is null, or the amount in cents are negative
     */
    void transfer(@Nonnull BankAccount target, int amountInCents, @Nullable String usage,
                  @Nonnull Consumer<TransferResult> callback) throws IllegalArgumentException;

    /**
     * Gets the bank card item of this account.
     *
     * @return the bank card item as ItemStack
     */
    @Nonnull
    @Contract(pure = true)
    ItemStack getBankCard();

    /**
     * The type of bank account: Whether it is a main or second account of a player, or the bank account of a company or an association
     */
    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    enum AccountType {
        USER_MAIN_ACCOUNT("DE00-"),
        USER_SECOND_ACCOUNT("DE01-"),
        COMPANY_ACCOUNT("DE02-"),
        ASSOCIATION_ACCOUNT("DE03-");

        private final String prefix;

        /**
         * Gets the associated account type to the iban
         * <p>
         * <b>Note:</b> This method neither checks the iban for correctness, nor if there is a bank account associated with it.
         *
         * @param iban iban to get account type of
         * @return account type
         * @throws IllegalArgumentException if iban is null, or malformatted
         * @see Core#getBankAccount(String)
         */
        @Nonnull
        @Contract(pure = true)
        public static AccountType getAccountType(@Nonnull String iban) throws IllegalArgumentException {
            //noinspection ConstantValue
            if (iban == null) {
                throw new IllegalArgumentException("iban is null");
            }
            return switch (iban.charAt(3)) {
                case '0' -> USER_MAIN_ACCOUNT;
                case '1' -> USER_SECOND_ACCOUNT;
                case '2' -> COMPANY_ACCOUNT;
                case '3' -> ASSOCIATION_ACCOUNT;
                default -> throw new IllegalArgumentException("Given string does not match the required iban standard");
            };
        }
    }
}