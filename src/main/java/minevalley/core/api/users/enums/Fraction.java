package minevalley.core.api.users.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Fraction {

    POLICE("Polizei"),
    MEDIC("Rettungsdienst"),
    MAIL("Post"),
    DISPOSAL("Müllabfuhr");

    private final String name;

    public static Fraction getFraction(int value) {
        return value >= values().length ? null : values()[value];
    }
}