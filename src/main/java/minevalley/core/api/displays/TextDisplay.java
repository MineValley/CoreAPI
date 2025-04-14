package minevalley.core.api.displays;

import org.bukkit.Color;

import javax.annotation.Nonnull;

public interface TextDisplay extends Display {

    /**
     * Set the text of the display
     *
     * @param text the text
     * @return the current instance
     */
    TextDisplay setText(@Nonnull String text);

    /**
     * Set the background color of the text
     *
     * @param color the color
     * @return the current instance
     */
    TextDisplay setBackgroundColor(@Nonnull Color color);

    /**
     * Update the text of the display.
     */
    void updateText();
}
