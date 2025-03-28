package minevalley.core.api.messaging.types;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.messaging.characters.CustomCharacter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;

import javax.annotation.Nonnull;

import static minevalley.core.api.messaging.characters.CustomCharacter.*;
import static minevalley.core.api.messaging.colors.CustomColor.*;
import static net.kyori.adventure.text.format.NamedTextColor.*;

@Getter(onMethod_ = @Nonnull)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MessageType {

    /**
     * Used to signal a warning.
     */
    WARNING(EXCLAMATION_MARK, YELLOW, CHAT_WARNING),

    /**
     * Used to signal the failure of a process or an action.
     */
    ERROR(CROSS, RED, CHAT_ERROR),

    /**
     * Used to signal the success of a process or action.
     */
    SUCCESS(CHECKMARK, GREEN, CHAT_SUCCESS),

    /**
     * Used to signal an information.
     */
    INFO(MV, WHITE, GRAY),

    /**
     * Used to signal an information in black and white.
     */
    INFO_BW(MV_BW, WHITE, GRAY);

    private final CustomCharacter symbol;
    private final TextColor prefixColor, messageColor;

    @SuppressWarnings("unused")
    public @Nonnull TextComponent getPrefix() {
        return Component.space()
                .append(Component.text(symbol.getChar(), prefixColor))
                .append(Component.text(" ━ ", DARK_GRAY));
    }
}