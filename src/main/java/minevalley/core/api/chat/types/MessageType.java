package minevalley.core.api.chat.types;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.enums.CustomCharacter;

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

    INFO(" §f" + CustomCharacter.MV + " §8━ §7"),

    INFO_BW(" §f" + CustomCharacter.MV_BW + " §8━ §7"),

    WARNING(" §e§l! §8━ §7");

    private final String prefix;
}