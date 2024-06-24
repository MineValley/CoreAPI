package minevalley.core.api.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MessageType {

    /**
     * Used to signal the success of a process or action.
     */
    SUCCESS(" §a✔§8 ━ §7"),

    /**
     * Used to signal the failure of a process or an action.
     */
    ERROR(" §c§l!§8 ━ §7"),

    /**
     * Used to signal a misspelled command.
     */
    SYNTAX_ERROR(ERROR.getValue() + "Korrekte Verwendung: §e/"),

    INFO(" §f" + CustomCharacter.MV + " §8━ §7"),

    INFO_BW(" §f" + CustomCharacter.MV_BW + " §8━ §7"),

    /**
     * Used to signal the success of a process or action, by using the action-bar.
     */
    ACTION_BAR_SUCCESS("§a✔§8 ━ §7"),

    /**
     * Used to signal the failure of a process or action, by using the action-bar.
     */
    ACTION_BAR_ERROR("§c✘§8 ━ §7");

    private final String value;
}