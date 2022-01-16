package minevalley.core.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum FractionService {

    NONE(0),
    POLICE(1),
    MEDIC(2),
    MAIL(-2),
    DISPOSAL(-1);

    private final int value;

    public static FractionService getFraction(int value) {
        return Arrays.stream(values()).filter(fraction -> fraction.getValue() == value).findFirst().orElse(null);
    }
}