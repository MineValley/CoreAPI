package minevalley.core.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.mail.Parcel;
import minevalley.core.api.phone.Telephone;
import minevalley.core.api.regions.Residence;

import java.util.List;

public interface Registered {

    /**
     * Gets the registerNumber of this registered.
     * <p>
     * <b>User:</b> user's unique id
     * <p>
     * <b>Company:</b> company's id
     * <p>
     * <b>Organization:</b> organization's id
     * <p>
     * <b>Department (of company/organization):</b> department's id
     */
    String getRegisterNumber();

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
     * Checks whether a user is represented by this registered (in case it represents only one user),
     * or whether the user is part of the group / department, that this registered represents.
     *
     * @param user user to check
     * @return true, if the user is represented by this registered or is a part of the group / department that this registered represents
     */
    boolean contains(User user);

    /**
     * Gets the type of this registered.
     *
     * @return registered's type
     */
    Type getType();

    /**
     * Gets the bank account that is associated with this registered.
     * Departments may not have their own bank account. If this registered is a department without its own bank account,
     * this method will return the bank account of the departments company/organisation.
     */
    BankAccount getBankAccount();

    /**
     * Gets the address of this registered.
     * <br>
     * This might be null!
     * <br>
     * If this registered is a department without its own address, this will return the groups address.
     * If this registered is a group without its own address, this will return the address of the owner.
     */
    Residence getAddress();

    Telephone getTelephone();

    /**
     * Delivers the given parcel securely. If this registered doesn't have an address, it is sent to...
     * <br>
     * if registered is a department: to the associated group.
     * <br>
     * if registered is a group: to the group's owner.
     * <br>
     * if registered is a user: to a parcel shop.
     */
    void deliverParcel(Parcel parcel);

    List<Property> getProperties();

    List<Property> getProperties(Property.Type type);

    boolean ownsProperty(int id, Property.Type type);

    boolean ownsProperty(Property property);

    void addProperty(Property property);

    void removeProperty(int id, Property.Type type);

    void removeProperty(Property property);

    /**
     * Converts this registered to a string.
     *
     * @return registered as string
     */
    String toString();

    @Getter
    @RequiredArgsConstructor
    enum Type {
        USER("U"),
        GROUP("G"),
        DEPARTMENT("D");

        private final String mark;
    }
}
