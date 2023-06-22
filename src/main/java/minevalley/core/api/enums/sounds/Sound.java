package minevalley.core.api.enums.sounds;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Sound {

    /**
     * Used to get the user's attention.
     */
    NOTIFICATION_INFO("notification_info"),

    /**
     * Used to signal the success of a relevant process.
     */
    NOTIFICATION_SUCCESS("notification_success"),

    /**
     * Used to signal the failure of a process the user tried to perform.
     */
    NOTIFICATION_ERROR("notification_error");

    private final String name;
}