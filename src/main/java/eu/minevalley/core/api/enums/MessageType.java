package eu.minevalley.core.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MessageType {

    SUCCESS("§a✔ §7"),
    ERROR(" §c§l!§8 ⋆ §7"),
    SYNTAX_ERROR(ERROR.getValue() + "Korrekte Verwendung: §e/"),
    INFO_TURQUOISE("§bℹ §7"),
    INFO_AQUA("§3ℹ §7"),
    INFO_YELLOW("§eℹ §7"),
    INFO_GOLD("§6ℹ §7"),
    INFO_RED("§cℹ §7"),
    INFO_PINK("§dℹ §7"),
    ACTION_BAR_SUCCESS("§2✔ §8– §a"),
    ACTION_BAR_ERROR("§4✘ §8– §c");

    @Getter
    private final String value;
}