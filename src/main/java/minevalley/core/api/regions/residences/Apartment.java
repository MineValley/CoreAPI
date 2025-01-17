package minevalley.core.api.regions.residences;

import minevalley.core.api.Registrant;
import minevalley.core.api.economy.BankAccount;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Apartment extends Residence {

    int getApartmentNumber();

    boolean isPremiumOnly();

    Registrant getLandlord();

    void setLandlord(@Nonnull Registrant landlord);

    BankAccount getLandLordBankAccount();

    void changeLandlordBankAccount(@Nonnull BankAccount bankAccount);

    int getRent();

    void changeRent(int rent);

    /**
     * Is null, when this apartment is not part of an apartment block!
     *
     * @return this apartments apartment block, if existing.
     */
    ApartmentBlock getApartmentBlock();
}
