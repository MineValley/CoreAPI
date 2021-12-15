package minevalley.core.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NotificationSound {

    /**
     * Used to get the users attention.
     */
    INFO("notification_info"),

    /**
     * Used to signal the success of a relevant process.
     */
    SUCCESS("notification_success"),

    /**
     * Used to signal the failure of a process the user tried to perform.
     */
    ERROR("notification_error");

    private final String value;
}