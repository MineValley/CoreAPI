package eu.minevalley.core.api.user;

import eu.minevalley.core.api.CoreModule;
import eu.minevalley.proxima.api.user.ProxyUser;
import eu.minevalley.proxima.api.user.User;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public class UserDispatcher {

    private final @Nonnull User user;
    private @Nonnull Consumer<OnlineUser> onlineUserConsumer = user -> {
    };
    private @Nonnull Consumer<ProxyUser> proxyUserConsumer = user -> {
    };
    private @Nonnull Consumer<User> userConsumer = user -> {
    };

    /**
     * Gets executed if the user is on this server.
     *
     * @param consumer callback to be called
     * @return this
     * @throws IllegalArgumentException if consumer is null
     */
    @Nonnull
    @Contract(value = "_ -> this", pure = true)
    public UserDispatcher ifOnline(@Nonnull Consumer<OnlineUser> consumer) throws IllegalArgumentException {
        if (consumer == null) throw new IllegalArgumentException("consumer cannot be null");
        onlineUserConsumer = onlineUserConsumer.andThen(consumer);
        return this;
    }

    /**
     * Gets executed if the user is connected to the proxy but not to the server.
     *
     * @param consumer callback to be called
     * @return this
     * @throws IllegalArgumentException if consumer is null
     */
    @Contract(value = "_ -> this", pure = true)
    public UserDispatcher ifProxy(@Nonnull Consumer<ProxyUser> consumer) throws IllegalArgumentException {
        if (consumer == null) throw new IllegalArgumentException("consumer cannot be null");
        proxyUserConsumer = proxyUserConsumer.andThen(consumer);
        return this;
    }

    /**
     * Gets executed if the user is not connected to the proxy.
     *
     * @param consumer callback to be called
     * @return this
     * @throws IllegalArgumentException if consumer is null
     */
    @Contract(value = "_ -> this", pure = true)
    public UserDispatcher orElse(@Nonnull Consumer<User> consumer) throws IllegalArgumentException {
        if (consumer == null) throw new IllegalArgumentException("consumer cannot be null");
        userConsumer = userConsumer.andThen(consumer);
        return this;
    }

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
    public void dispatch() {
        userConsumer.accept(user);
        if (user.isConnected()) {
            final ProxyUser pUser = CoreModule.proxy().getProxyUser(user.getUniqueId());
            proxyUserConsumer.accept(pUser);
            final OnlineUser oUser = CoreModule.server().getOnlineUser(user);
            if (oUser != null) {
                onlineUserConsumer.accept(oUser);
            }
        }
    }
}