package minevalley.core.api;

import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.mail.Parcel;
import minevalley.core.api.phone.Telephone;
import minevalley.core.api.regions.Residence;

import java.util.List;

public interface Registrant {


    String getId();

    /**
     * Gets the name to display on signs etc.
     * <p>
     * <b>User:</b> user's name
     * <p>
     * <b>Company:</b> company's name
     * <p>
     * <b>Organization:</b> organizsation's name
     * <p>
     * <b>Department (of company/organization):</b> name of department - name of company/organisation
     * <p>
     * <p>
     * <b>Note:</b> department names may be longer than 16 characters and can therefore not been put onto signs!
     */
    String getRegisterName();

    /**
     * Takes the registrant's name, but truncates it if it's longer than 16 characters.
     */
    String getRegisterNameCropped();

    /**
     * Checks whether a user is represented by this registrant (in case it represents only one user),
     * or whether the user is part of the group / department, that this registrant represents.
     *
     * @param user user to check
     * @return true, if the user is represented by this registrant or is a part of the group / department that this registrant represents
     */
    boolean contains(User user);

    /**
     * Gets the bank account that is associated with this registrant.
     * Departments may not have their own bank account. If this registrant is a department without its own bank account,
     * this method will return the bank account of the departments company/organisation.
     */
    BankAccount getBankAccount();

    /**
     * Gets the address of this registrant.
     * <br>
     * This might be null!
     * <br>
     * If this registrant is a department without its own address, this will return the groups address.
     * If this registrant is a group without its own address, this will return the address of the owner.
     */
    Residence getAddress();

    Telephone getTelephone();

    /**
     * Delivers the given parcel securely. If this registrant doesn't have an address, it is sent to...
     * <br>
     * if registrant is a department: to the associated group.
     * <br>
     * if registrant is a group: to the group's owner.
     * <br>
     * if registrant is a user: to a parcel shop.
     */
    void deliverParcel(Parcel parcel);

    List<Property> getProperties();

    List<Property> getProperties(Property.Type type);

    boolean ownsProperty(int id, Property.Type type);

    boolean ownsProperty(Property property);

    void addProperty(Property property);

    void removeProperty(int id, Property.Type type);

    void removeProperty(Property property);

}
