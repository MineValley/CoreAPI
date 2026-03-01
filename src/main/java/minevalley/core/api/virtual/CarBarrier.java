package minevalley.core.api.virtual;

import minevalley.core.api.virtual.modifiers.VisibilityModifier;

@SuppressWarnings("unused")
public interface CarBarrier extends VisibilityModifier<CarBarrier> {

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