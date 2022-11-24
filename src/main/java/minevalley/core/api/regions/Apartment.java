package minevalley.core.api.regions;

import lombok.NonNull;
import minevalley.core.api.Registered;
import minevalley.core.api.User;
import minevalley.core.api.economy.BankAccount;

public interface Apartment extends Residence {

    boolean isPremiumOnly();

    Registered getLandLord();

    void setLandLord(@NonNull Registered registered, User user);

    BankAccount getLandLordBankAccount();

    void changeLandLordBankAccount(@NonNull BankAccount bankAccount, User user);

    int getRent();

    void changeRent(int rent);

    boolean isClearedWhenUnrented();

    Termination[] getTerminations();

    void terminate(@NonNull Termination termination);

    void removeTermination(Termination termination);

    void removeAllTerminations();
}
