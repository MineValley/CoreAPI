package minevalley.core.api.economy;

import minevalley.core.api.Registrant;

import java.util.List;

public interface AccountUser {

    Registrant getRegistrant();

    int getMaxPayoutPerDayInCents();

    int getRemainingDailyPayout();

    void resetDailyPayout();

    default boolean hasMaxPayoutPerDay() {
        return getMaxPayoutPerDayInCents() != -1;
    }

    List<BankAccountUserPermission> getPermissions();

    default boolean hasPermission(BankAccountUserPermission permission) {
        return getPermissions().contains(permission);
    }

    void grantPermission(BankAccountUserPermission permission);

    void revokePermission(BankAccountUserPermission permission);
}

enum BankAccountUserPermission {
    PAYOUT,
    TRANSFER_MONEY,
    CREATE_NEW_CARDS,
    ADD_NEW_USERS,
    REMOVE_USERS;
}
