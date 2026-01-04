package minevalley.core.api.banking;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.Registrant;
import minevalley.core.api.users.User;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@SuppressWarnings("unused")
public interface BankAccount {

    /**
     * Gets the holder of this bank account.
     *
     * @return holder of this bank account
     */
    Registrant getHolder();

    /**
     * Gets this accounts banking id.
     * <b>Note:</b> the IBAN already contains the prefix (DE00/01/02/03)
     *
     * @return this accounts banking id
     */
    String getIban();

    /**
     * Gets the amount of money in this bank account.
     *
     * @return amount of money in cents as integer.
     */
    int getAmountInCents();

    /**
     * Gets a list of the registrant that are permissioned to use this bank account.
     *
     * @return list of permissioned registrants and their maximum payout per day (-1 if unlimited)
     */
    List<AccountUser> getAccountUsers();

    default AccountUser getAccountUser(Registrant registrant) {
        return getAccountUsers().stream()
                .filter(accountUser -> accountUser.getRegistrant().equals(registrant)).findFirst().orElse(null);
    }

    /**
     * Gets whether the specific user is permissioned to use this bank account.
     *
     * @param user user who could be permissioned
     * @return true, if the specific user is permissioned to use this bank account
     */
    boolean isPermissioned(User user);

    /**
     * Gets the type of this bank account.
     *
     * @return type of this bank account
     */
    AccountType getType();

    /**
     * Transfers an amount to another bank account.
     * <p>
     * <b>Note:</b> This method only accepts positive amounts!
     *
     * @param target        bank account to which the money is transferred to
     * @param accountUser   accountUser making the transfer
     * @param amountInCents amount of money to be transferred
     * @param usage         usage as string
     * @return true, if the transfer was successful (false, if account does not have enough money)
     */
    TransferResult transfer(BankAccount target, AccountUser accountUser, int amountInCents, String usage);

    /**
     * Transfers an amount to another bank account.
     * <p>
     * <b>Note:</b> This method only accepts positive amounts!
     *
     * @param target        bank account to which the money is transferred to
     * @param amountInCents amount of money to be transferred
     * @param usage         usage as string
     * @return true, if the transfer was successful (false, if account does not have enough money)
     */
    TransferResult transfer(BankAccount target, int amountInCents, String usage);

    /**
     * Gets the bank card item of this account.
     *
     * @return the bank card item as ItemStack
     */
    ItemStack getBankCard();

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    enum AccountType {
        USER("DE00-"),
        SECOND_ACCOUNT("DE01-"),
        COMPANY("DE02-"),
        ASSOCIATION("DE03-");

        private final String prefix;

        public static AccountType getAccountType(String iban) {
            return switch (iban.split("-")[0]) {
                case "DE00" -> USER;
                case "DE01" -> SECOND_ACCOUNT;
                case "DE02" -> COMPANY;
                case "DE03" -> ASSOCIATION;
                default -> null;
            };
        }
    }

    enum TransferResult {
        SUCCESS,
        NO_PERMISSION,
        NOT_ENOUGH_MONEY,
        MAX_PAYOUT_REACHED
    }
}