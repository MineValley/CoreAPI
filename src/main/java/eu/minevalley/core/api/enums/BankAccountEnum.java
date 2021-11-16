package eu.minevalley.core.api.enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BankAccountEnum {

    PERSONAL("DE 00"),
    SECONDARY("DE 01"),
    COMPANY("DE 02"),
    ORGANISATION("DE 03"),
    STATE("DE 04");

    @Getter
    private final String bankIdentification;

    public static BankAccountEnum getBankAccount(@NonNull final String bankIdentification) {
        for (BankAccountEnum bankAccountEnum : values())
            if (bankAccountEnum.getBankIdentification() == bankIdentification)
                return bankAccountEnum;
            return null;
    }
}