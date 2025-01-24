package minevalley.core.api.messaging.types;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.messaging.characters.CustomCharacter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;

import javax.annotation.Nonnull;

import static minevalley.core.api.messaging.characters.CustomCharacter.*;
import static net.kyori.adventure.text.format.NamedTextColor.*;

@Getter(onMethod_ = @Nonnull)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MessageType {

    /**
     * Used to signal a warning.
     */
    WARNING(EXCLAMATION_MARK, YELLOW),

    /**
     * Used to signal the failure of a process or an action.
     */
    ERROR(CROSS, RED),

    /**
     * Used to signal the success of a process or action.
     */
    SUCCESS(CHECKMARK, GREEN),

    /**
     * Used to signal an information.
     */
    INFO(MV, WHITE),

    /**
     * Used to signal an information in black and white.
     */
    INFO_BW(MV_BW, WHITE);

    private final CustomCharacter symbol;
    private final NamedTextColor color;

    @SuppressWarnings("unused")
    public TextComponent getPrefix() {
        return Component.space()
                .append(Component.text(symbol.getChar(), color))
                .append(Component.text(" ━ ", DARK_GRAY));
    }
}