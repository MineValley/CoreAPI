package minevalley.core.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Education {

    NONE(0),
    MEDICAL(1),
    BOOKKEEPING(2);

    private final int value;

    public static Education getEducation(int value) {
        return Arrays.stream(values()).filter(education -> education.getValue() == value).findFirst().orElse(null);
    }
}