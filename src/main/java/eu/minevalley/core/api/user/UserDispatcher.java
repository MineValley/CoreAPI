package eu.minevalley.core.api.user;

import eu.minevalley.proxima.api.user.ProxyUser;
import eu.minevalley.proxima.api.user.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public abstract class UserDispatcher {

    private final @Nonnull User user;

    /**
     * Gets executed if the given player is on this server.
     *
     * @param consumer callback to be called
     * @return this
     * @throws IllegalArgumentException if consumer is null
     */
    @Nonnull
    @Contract(value = "_ -> this", pure = true)
    public abstract UserDispatcher ifOnline(@Nonnull Consumer<OnlineUser> consumer) throws IllegalArgumentException;

    /**
     * Gets executed if the given player is on the proxy, ignoring whether he is on the server.
     * <p>
     * <b>Note:</b> this callback is called after {@link #ifOnline}.
     *
     * @param consumer callback to be called
     * @return this
     * @throws IllegalArgumentException if consumer is null
     */
    @Contract(value = "_ -> this", pure = true)
    public abstract UserDispatcher ifProxy(@Nonnull Consumer<ProxyUser> consumer) throws IllegalArgumentException;

    /**
     * Gets called every time!
     * <p>
     * <b>Note:</b> this callback is called after all other callbacks.
     *
     * @param consumer callback to be called
     * @return this
     * @throws IllegalArgumentException if consumer is null
     */
    @Contract(value = "_ -> this", pure = true)
    public abstract UserDispatcher orElse(@Nonnull Consumer<User> consumer) throws IllegalArgumentException;

    /**
     * Call this method to dispatch the decision process.
     * <p>
     * <b>Note:</b>
     * <ul>
     *     <li>
     *          This method must be called to execute the callbacks, otherwise nothing will happen!
     *     </li>
     *     <li>
     *         This method can be called multiple times and will always will decide on the current online state of the user
     *     </li>
     * </ul>
     */
    abstract void dispatch();
}