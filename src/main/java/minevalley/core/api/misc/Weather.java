package minevalley.core.api.misc;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Weather {

    private final Type type;
    private final int temperature;

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Type {
        SUN,
        RAIN,
        THUNDER
    }
}

