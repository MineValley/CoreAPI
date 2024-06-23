package minevalley.core.api.regions;

import lombok.NonNull;
import minevalley.core.api.Registrant;
import minevalley.core.api.economy.BankAccount;

public interface Apartment extends Residence {

    int getAppartmentNumber();

    boolean isPremiumOnly();

    Registrant getLandlord();

    void setLandlord(@NonNull Registrant landlord);

    BankAccount getLandLordBankAccount();

    void changeLandlordBankAccount(@NonNull BankAccount bankAccount);

    int getRent();

    void changeRent(int rent);

    /**
     * Is null, when this apartment is not part of an apartment block!
     *
     * @return this apartments apartment block, if existing.
     */
    ApartmentBlock getApartmentBlock();
}
