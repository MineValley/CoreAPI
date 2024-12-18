package minevalley.core.api.weather;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public record Weather(Type type, int temperature) {

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Type {
        SUN,
        RAIN,
        THUNDER
    }
}

