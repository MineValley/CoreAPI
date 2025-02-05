package minevalley.core.api.utils;

import minevalley.core.api.modifiers.LocationModifier;
import minevalley.core.api.modifiers.VisibilityModifier;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public interface Hologram extends LocationModifier, VisibilityModifier {

    /**
     * Returns the lines of the hologram.
     *
     * @return the lines of the hologram.
     */
    @Nonnull
    @Contract(pure = true)
    String[] getLines();

    /**
     * Returns the line at the specified index.
     *
     * @param line the index of the line.
     * @return the line at the specified index.
     * @throws IndexOutOfBoundsException if the line is out of bounds.
     */
    @Contract(pure = true)
    default String getLine(@Nonnegative int line) throws IndexOutOfBoundsException {
        return getLines()[line];
    }

    /**
     * Adds a line to the hologram.
     *
     * @param text the text of the line.
     * @throws IllegalArgumentException if the text is null.
     */
    default void addLine(@Nonnull String text) throws IllegalArgumentException {
        if (text == null) throw new IllegalArgumentException("The text cannot be null.");
        addLineAfter(getLines().length - 1, text);
    }

    /**
     * Adds a line to the hologram at the specified index.
     *
     * @param line the index of the line.
     * @param text the text of the line.
     * @throws IndexOutOfBoundsException if the line is out of bounds.
     * @throws IllegalArgumentException  if the text is null.
     */
    void addLineAfter(@Nonnegative int line, @Nonnull String text) throws IndexOutOfBoundsException, IllegalArgumentException;

    /**
     * Changes the line at the specified index.
     *
     * @param line the index of the line.
     * @param text the new text of the line.
     * @throws IndexOutOfBoundsException if the line is out of bounds.
     * @throws IllegalArgumentException  if the text is null.
     */
    void changeLine(@Nonnegative int line, @Nonnull String text) throws IndexOutOfBoundsException, IllegalArgumentException;

    /**
     * Removes the line at the specified index.
     *
     * @param line the index of the line.
     * @throws IndexOutOfBoundsException if the line is out of bounds.
     */
    void removeLine(@Nonnegative int line) throws IndexOutOfBoundsException;
}