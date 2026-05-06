package eu.minevalley.core.api;

import eu.minevalley.core.api.server.Server;
import eu.minevalley.core.api.user.OnlineUser;
import eu.minevalley.proxima.api.AbstractModule;
import eu.minevalley.proxima.api.Developer;
import eu.minevalley.proxima.api.Proxy;
import eu.minevalley.proxima.api.command.Command;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@RequiredArgsConstructor
public abstract class CoreModule extends AbstractModule {

    private static @Nonnull Core core;
    private static @Nonnull Command<OnlineUser> command;

    /**
     * Gets this modules instance of the {@link Core}.
     *
     * @return this modules instance of the Core
     */
    @Nonnull
    @Contract(pure = true)
    public static Core core() {
        return core;
    }

    /**
     * Gets a shortcut to the proxy interface.
     *
     * @return shortcut to the proxy interface
     */
    @Nonnull
    @Contract(pure = true)
    public static Proxy proxy() {
        return core.proxy();
    }

    /**
     * Gets a shortcut to the server interface.
     *
     * @return shortcut to the server interface
     */
    @Nonnull
    @Contract(pure = true)
    public static Server server() {
        return core.server();
    }

    /**
     * Gets this modules instance of the {@link Command} registry.
     *
     * @return this modules instance of the Commands registry
     */
    @Nonnull
    @Contract(pure = true)
    public static Command<OnlineUser> command() {
        return command;
    }

    /**
     * Is called then the server starts with the cleanup flag.
     */
    public void onCleanup() {
        // override this method to add logic
    }

    /**
     * Gets the @{@link Module}-Annotation of this module.
     *
     * @return the annotation if present
     * @throws IllegalStateException if the class is missing its annotation.
     */
    @Nonnull
    @Contract(pure = true)
    public final Module annotation() throws IllegalStateException {
        final Class<? extends CoreModule> clazz = getClass();
        if (!clazz.isAnnotationPresent(Module.class)) {
            throw new IllegalStateException("Module annotation is missing in module '" + clazz.getSimpleName() + "'");
        }
        return clazz.getAnnotation(Module.class);
    }

    /**
     * Gets the version of this module.
     *
     * @return the version
     */
    @Nonnull
    @Contract(pure = true)
    public final String getVersion() {
        return core.getVersion(this);
    }

    /**
     * Gets an array of this module's developers, as to find in the {@code pom.xml}.
     *
     * @return array of developers
     */
    @Nonnull
    @Contract(pure = true)
    public final Developer[] getDevelopers() {
        return core.getDevelopers(this);
    }
}