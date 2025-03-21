package minevalley.core.api.displays;

import javax.annotation.Nonnull;

public interface TextDisplay {

    /**
     * Set the text of the display
     *
     * @param text the text
     * @return the current instance
     */
    TextDisplay setText(@Nonnull String text);

    /**
     * Update the text of the display.
     */
    void updateText();
}
