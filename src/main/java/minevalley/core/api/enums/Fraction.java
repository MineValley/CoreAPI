package minevalley.core.api.enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Fraction {

    NONE(0),
    POLICE(1),
    MEDIC(2),
    MAIL(-2),
    DISPOSAL(-1);

    @Getter
    private final int value;

    public static Fraction getFraction(@NonNull final int value) {
        for (Fraction fraction : values())
            if (fraction.getValue() == value)
                return fraction;
        return null;
    }
}