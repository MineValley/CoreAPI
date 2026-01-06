package minevalley.core.api.displays;

import net.kyori.adventure.text.ComponentLike;
import org.bukkit.Color;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface TextDisplay extends Display<TextDisplay> {

    /**
     * Set the text of the display
     *
     * @param text the text
     * @return this
     * @throws IllegalArgumentException if the text is null
     */
    @Nonnull
    @Contract("_ -> this")
    TextDisplay setText(@Nonnull ComponentLike text) throws IllegalArgumentException;

    /**
     * Set the background color of the text
     *
     * @param color the color
     * @return this
     * @throws IllegalArgumentException if the color is null
     */
    @Nonnull
    @Contract("_ -> this")
    TextDisplay setBackgroundColor(@Nonnull Color color) throws IllegalArgumentException;

    /**
     * Update the text of the display.
     */
    void updateText();
}
