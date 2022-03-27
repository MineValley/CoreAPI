package minevalley.core.api.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Education {

    NONE(0),
    MEDICAL(1),
    BOOKKEEPING(2);

    private final int value;

    public static Education getEducation(int value) {
        return Arrays.stream(values()).filter(education -> education.getValue() == value).findFirst().orElse(null);
    }
}