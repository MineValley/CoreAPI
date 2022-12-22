package minevalley.core.api.regions;

import minevalley.core.api.Registered;
import minevalley.core.api.economy.BankAccount;

public interface ApartmentBlock {

    Registered getOwner();

    void transfer(Registered registered);

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
