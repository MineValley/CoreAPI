package minevalley.core.api.enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum BankAccountType {

    PERSONAL("DE 00"),
    SECONDARY("DE 01"),
    COMPANY("DE 02"),
    ORGANISATION("DE 03"),
    STATE("DE 04");

    private final String bankIdentification;

    public static BankAccountType getBankAccount(@NonNull final String bankIdentification) {
        return Arrays.stream(values()).filter(bankAccount -> bankAccount.getBankIdentification()
                .equals(bankIdentification)).findFirst().orElse(null);
    }
}