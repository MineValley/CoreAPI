package minevalley.core.api.economy;

import minevalley.core.api.Registered;
import minevalley.core.api.User;

import java.util.List;

public interface BankAccount {

    /**
     * Gets the holder of this bank account.
     *
     * @return holder of this bank account
     */
    Registered getHolder();

    /**
     * Gets this accounts banking id.
     * <b>Note:</b> the IBAN already contains the prefix (DE00/01/02/03)
     * @return this accounts banking id
     */
    String getIban();

    /**
     * Gets the amount of money in this bank account.
     *
     * @return amount of money in this bank account
     */
    double getAmount();

    /**
     * Gets a list of the registered that are permissioned to use this bank account.
     *
     * @return list of registered
     */
    List<Registered> getPermissioned();

    /**
     * Gets whether the specific user is permissioned to use this bank account.
     *
     * @param user user who could be permissioned
     * @return true, if the specific user is permissioned to use this bank account
     */
    boolean isPermissioned(User user);

    /**
     * Transfers an amount to another bank account.
     * <p>
     * <b>Note:</b> This method only accepts positive amounts!
     *
     * @param target bank account to which the money is transfered to
     * @param amount amount of money to be transfered
     * @param usage  usage as string
     * @return true, if the transfer was successful (false, if account does not have enough money)
     */
    boolean transfer(BankAccount target, double amount, String usage);
}