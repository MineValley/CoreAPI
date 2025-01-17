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

    void setMaxPayoutPerDayInCents(int maxPayoutInCents);

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

    void remove();

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    enum BankAccountUserPermission {
        CREATE_NEW_CARDS("allowed_to_create_new_bank_cards"),
        ADD_NEW_USERS("allowed_to_add_new_users"),
        REMOVE_USERS("allowed_to_remove_other_users");

        private final String code;
    }
}
