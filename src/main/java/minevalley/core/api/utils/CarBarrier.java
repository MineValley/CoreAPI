package minevalley.core.api.utils;

import minevalley.core.api.modifiers.VisibilityModifier;

@SuppressWarnings("unused")
public interface CarBarrier extends VisibilityModifier {

    /**
     * Opens the barrier.
     *
     * @throws IllegalStateException if the barrier is already open or removed.
     */
    void open() throws IllegalStateException;

    /**
     * Closes the barrier.
     *
     * @throws IllegalStateException if the barrier is already closed or removed.
     */
    void close() throws IllegalStateException;
}