package minevalley.core.api.messaging.types;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ActionBarType {

    /**
     * Used to signal the success of a process or action, by using the action-bar.
     */
    SUCCESS("§a✔§8 ━ §7"),

    /**
     * Used to signal the failure of a process or action, by using the action-bar.
     */
    ERROR("§c✘§8 ━ §7");

    private final String prefix;
}