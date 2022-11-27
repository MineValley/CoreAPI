package minevalley.core.api.regions;

import lombok.NonNull;
import minevalley.core.api.Registered;
import minevalley.core.api.economy.BankAccount;

public interface Apartment extends Residence {

    boolean isPremiumOnly();

    Registered getLandlord();

    void setLandlord(@NonNull Registered landlord);

    BankAccount getLandLordBankAccount();

    void changeLandlordBankAccount(@NonNull BankAccount bankAccount);

    int getRent();

    void changeRent(int rent);

    boolean isClearedWhenUnrented();
}
