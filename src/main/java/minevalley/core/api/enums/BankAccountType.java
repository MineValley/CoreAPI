package minevalley.core.api.enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BankAccountType {

    PERSONAL("DE 00"),
    SECONDARY("DE 01"),
    COMPANY("DE 02"),
    ORGANISATION("DE 03"),
    STATE("DE 04");

    @Getter
    private final String bankIdentification;

    public static BankAccountType getBankAccount(@NonNull final String bankIdentification) {
        for (BankAccountType bankAccount : values())
            if (bankAccount.getBankIdentification().equals(bankIdentification))
                return bankAccount;
        return null;
    }
}