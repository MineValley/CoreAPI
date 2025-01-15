package minevalley.core.api.users.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("unused")
public enum Fraction {

    POLICE("Polizei"),
    MEDIC("Rettungsdienst"),
    MAIL("Post"),
    DISPOSAL("Müllabfuhr");

    private final String name;

    public static Fraction getFraction(int value) {
        if (value >= values().length || value < 0) return null;
        return values()[value];
    }
}