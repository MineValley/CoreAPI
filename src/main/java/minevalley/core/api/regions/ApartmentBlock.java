package minevalley.core.api.regions;

import minevalley.core.api.Registered;
import minevalley.core.api.economy.BankAccount;

public interface ApartmentBlock {

    Registered getOwner();

    void transfer(Registered registered);

    BankAccount getOwnersBankAccount();

    void setOwnersBankAccount(BankAccount account);

    Apartment[] getApartments();

    Mailbox getMailbox();

    void addFloor();

    void addConstructionFloor();

    void removeFloor();

    int getFloors();

    int getMaxFloors();

    int getFloor(Apartment apartment);
}
