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

    /**
     * Used to display any information to the user. Uses a turquoise-colored "i"-letter.
     */
    @Deprecated
    INFO_TURQUOISE("§bℹ §7"),

    /**
     * Used to display any information to the user. Uses an aqua-colored "i"-letter.
     */
    @Deprecated
    INFO_AQUA("§3ℹ §7"),

    /**
     * Used to display any information to the user. Uses a yellow-colored "i"-letter.
     */
    @Deprecated
    INFO_YELLOW("§eℹ §7"),

    /**
     * Used to display any information to the user. Uses a gold-colored "i"-letter.
     */
    @Deprecated
    INFO_GOLD("§6ℹ §7"),

    /**
     * Used to display any information to the user. Uses a red-colored "i"-letter.
     */
    @Deprecated
    INFO_RED("§cℹ §7"),

    /**
     * Used to display any information to the user. Uses a pink-colored "i"-letter.
     */
    @Deprecated
    INFO_PINK("§dℹ §7"),

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