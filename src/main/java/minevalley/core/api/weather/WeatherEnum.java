package minevalley.core.api.weather;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class WeatherEnum {

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

