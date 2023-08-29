package minevalley.core.api.users;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public class Education {

    private final Subject subject;
    private final long graduationDate;

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public enum Subject {

        MEDICAL(0),
        BOOKKEEPING(1);

        private final int code;

        public static Subject getEducation(int value) {
            return Arrays.stream(values()).filter(education -> education.getCode() == value).findAny().orElse(null);
        }
    }
}