package minevalley.core.api.regions;

import minevalley.core.api.Registrant;
import minevalley.core.api.economy.BankAccount;

@SuppressWarnings("unused")
public interface ApartmentBlock {

    int getId();

    Registrant getOwner();

    void transfer(Registrant registrant);

    BankAccount getOwnersBankAccount();

    void setOwnersBankAccount(BankAccount account);

    Apartment[] getApartments();

    Apartment[] getApartments(int floor);

    Mailbox getMailbox();

    void addFloor();

    void addConstructionFloor();

    void removeFloor();

    /**
     * <b>Note:</b> The lowest floor is always 0. If there are basement floors, the index of the first floor can be above 0
     *
     * @return amount of floors as integer.
     */
    int getFloors();

    int getMaxFloors();

    int getDefaultFloor();

    // setup-method
    void setMaxFloor(int maxFloor);

    // setup-method
    void setFirstStackingFloor();

    int getFloor(Apartment apartment);

    void remove();
}
