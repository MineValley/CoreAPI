package minevalley.core.api;

import minevalley.core.api.corporations.companies.Aktiengesellschaft;
import minevalley.core.api.corporations.companies.Kapitalgesellschaft;
import minevalley.core.api.economy.AccountUser;
import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.mail.Parcel;
import minevalley.core.api.regions.residences.Address;
import minevalley.core.api.regions.residences.Residence;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.User;
import minevalley.core.api.vehicles.Vehicle;
import minevalley.core.api.weapons.Weapon;

import java.util.List;

@SuppressWarnings("unused")
public interface Registrant {

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
    String getName();

    /**
     * Takes the registrant's name, but truncates it if it's longer than 16 characters.
     *
     * @return this registrants name cropped to have a maximum length of 16 characters.
     */
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
    boolean contains(User user);

    List<OnlineUser> getOnlineUsers();

    /**
     * Gets the bank account that is associated with this registrant.
     * Departments may not have their own bank account. If this registrant is a department without its own bank account,
     * this method will return the bank account of the departments company/organisation.
     *
     * @return the bank account that is associated with this registrant.
     */
    BankAccount getBankAccount();

    List<AccountUser> getRelatedAccountUsers();

    List<Aktiengesellschaft.Stockholder> getRelatedStockholders();

    List<Kapitalgesellschaft.Shareholder> getRelatedShareholders();

    /**
     * Gets the address of this registrant.
     * <br>
     * This might be null!
     * <br>
     * If this registrant is a department without its own address, this will return the groups address.
     * If this registrant is a group without its own address, this will return the address of the owner.
     *
     * @return this registrants address as residence
     */
    Address getAddress();

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
    void deliverParcel(Parcel parcel);

    List<Vehicle> getVehicles();

    List<Weapon> getWeapons();

    List<Residence> getResidences();

}
