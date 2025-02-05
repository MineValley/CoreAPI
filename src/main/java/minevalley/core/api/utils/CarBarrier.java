package minevalley.core.api.utils;

@SuppressWarnings("unused")
public interface CarBarrier {

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

    /**
     * Removes the barrier.
     *
     * @throws IllegalStateException if the barrier is already removed.
     */
    void remove() throws IllegalStateException;
}