package minevalley.core.api.economy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.Registrant;

import java.util.List;

@SuppressWarnings("unused")
public interface AccountUser {

    Registrant getRegistrant();

    BankAccount getBankAccount();

    int getMaxPayoutPerDayInCents();

    void setMaxPayOutPerDayInCents(int maxPayout);

    int getRemainingDailyPayoutInCents();

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

    void updateFromDatabase();

    void remove();

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    enum BankAccountUserPermission {
        PAYOUT("allow_payout"),
        TRANSFER_MONEY("allow_transfers"),
        CREATE_NEW_CARDS("allow_create_new_bank_cars"),
        ADD_NEW_USERS("allow_adding_new_users"),
        REMOVE_USERS("allow_removing_other_users");

        private final String code;
    }
}
