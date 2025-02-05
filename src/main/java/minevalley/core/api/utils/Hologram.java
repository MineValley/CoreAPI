package minevalley.core.api.utils;

import minevalley.core.api.modifiers.LocationModifier;
import minevalley.core.api.modifiers.VisibilityModifier;

@SuppressWarnings("unused")
public interface Hologram extends LocationModifier, VisibilityModifier {

    /**
     * Returns the lines of the hologram.
     *
     * @return the lines of the hologram.
     */
    String[] getLines();

    /**
     * Returns the line at the specified index.
     *
     * @param line the index of the line.
     * @return the line at the specified index.
     */
    default String getLine(int line) {
        return getLines()[line];
    }

    /**
     * Adds a line to the hologram.
     *
     * @param text the text of the line.
     */
    default void addLine(String text) {
        addLineAfter(getLines().length - 1, text);
    }

    /**
     * Adds a line to the hologram at the specified index.
     *
     * @param line the index of the line.
     * @param text the text of the line.
     */
    void addLineAfter(int line, String text);

    /**
     * Changes the line at the specified index.
     *
     * @param line the index of the line.
     * @param text the new text of the line.
     */
    void changeLine(int line, String text);

    /**
     * Removes the line at the specified index.
     *
     * @param line the index of the line.
     */
    void removeLine(int line);

    /**
     * Removes the hologram.
     */
    void delete();
}