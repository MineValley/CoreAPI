package minevalley.core.api.fraction;

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

    @SuppressWarnings("unused")
    public static Fraction getFraction(int value) throws IndexOutOfBoundsException {
        return values()[value];
    }
}