package minevalley.core.api.utils;

import minevalley.core.api.modifiers.LocationModifier;
import minevalley.core.api.modifiers.VisibilityModifier;

@SuppressWarnings("unused")
public interface Hologram extends LocationModifier, VisibilityModifier {

    String[] getLines();

    default String getLine(int line) {
        return getLines()[line];
    }

    default void addLine(String text) {
        addLineAfter(getLines().length - 1, text);
    }

    void addLineAfter(int line, String text);

    void changeLine(int line, String text);

    void removeLine(int line);

    void delete();
}