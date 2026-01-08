package minevalley.core.api;

import minevalley.core.api.banking.AccountUser;
import minevalley.core.api.banking.BankAccount;
import minevalley.core.api.corporations.companies.Aktiengesellschaft;
import minevalley.core.api.corporations.companies.Kapitalgesellschaft;
import minevalley.core.api.localization.Address;
import minevalley.core.api.mail.Parcel;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.User;
import minevalley.core.api.weapons.Weapon;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("unused")
public interface Registrant {

    @Nonnull
    @Contract(pure = true)
    String getId();

    /**
     * Gets the name to display on signs etc.
     * <p>
     * <b>Department:</b> "name of department - name of company/association"
     * <p>
     * <b>Note:</b> department names may be longer than 16 characters and can therefore not been put onto signs!
     *
     * @return this registrants name as string.
     */
    @Nonnull
    @Contract(pure = true)
    String getName();

    /**
     * Takes the registrant's name, but truncates it if it's longer than 16 characters.
     *
     * @return this registrants name cropped to have a maximum length of 16 characters.
     */
    @Nonnull
    @Contract(pure = true)
    default String getCroppedName() {
        final String name = getName();
        if (name.length() <= 16) return name;
        return name.substring(0, 13) + "...";
    }

    /**
     * Checks whether a user is represented by this registrant (in case it represents only one user),
     * or whether the user is part of the group / department, that this registrant represents.
     *
     * @param user user to check
     * @return true, if the user is represented by this registrant or is a part of the group / department that this registrant represents
     */
    @Contract(value = "null -> false", pure = true)
    boolean contains(@Nullable User user);

    @Nonnull
    @Contract(pure = true)
    List<OnlineUser> getOnlineUsers();

    /**
     * Gets the address of this registrant.
     * If this registrant is a department without its own address, this will return the groups address.
     * If this registrant is a group without its own address, this will return the address of the owner.
     *
     * @return this registrants address as residence
     */
    @Nullable
    @Contract(pure = true)
    Address getAddress();

    /**
     * Gets the bank account that is associated with this registrant.
     * Departments may not have their own bank account. If this registrant is a department without its own bank account,
     * this method will return the bank account of the department's company/organization.
     *
     * @return the bank account that is associated with this registrant.
     */
    @Nonnull
    @Contract(pure = true)
    BankAccount getBankAccount();

    @Nonnull
    @Contract(pure = true)
    List<AccountUser> getRelatedAccountUsers();

    @Nonnull
    @Contract(pure = true)
    List<Aktiengesellschaft.Stockholder> getRelatedStockholders();

    @Nonnull
    @Contract(pure = true)
    List<Kapitalgesellschaft.Shareholder> getRelatedShareholders();

    /**
     * Delivers the given parcel securely. If this registrant doesn't have an address, it is sent to...
     * <br>
     * if registrant is a department: to the associated group.
     * <br>
     * if registrant is a group: to the group's owner.
     * <br>
     * if registrant is a user: to a parcel shop.
     *
     * @param parcel parcel to deliver
     */
    void deliverParcel(@Nonnull Parcel parcel) throws IllegalArgumentException;

    @Nonnull
    @Contract(pure = true)
    List<Weapon> getWeapons();
}
