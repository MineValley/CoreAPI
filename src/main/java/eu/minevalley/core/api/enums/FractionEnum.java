package eu.minevalley.core.api.enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum FractionEnum {

    NONE(0),
    POLICE(1),
    MEDIC(2),
    MAIL(-2),
    DISPOSAL(-1);

    @Getter
    private final int value;

    public static FractionEnum getFraction(@NonNull final int value) {
        for (FractionEnum fractionEnum : values())
            if (fractionEnum.getValue() == value)
                return fractionEnum;
            return null;
    }
}