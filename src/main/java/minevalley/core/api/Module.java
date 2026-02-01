package minevalley.core.api;

import minevalley.core.api.server.ServerType;

import javax.annotation.Nonnull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a class as a module.
 * This automatically registers the module on startup.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@SuppressWarnings("unused")
public @interface Module {

    /**
     * The name of the module.
     *
     * @return The module name.
     */
    @Nonnull String name();

    /**
     * Servers, this module should be loaded on.
     * If empty, the module is loaded on all server types.
     * <p>
     * <b>Usage:</b> This can be used to restrict a module to specific server types.
     *
     * @return The server types.
     */
    @Nonnull ServerType[] servers() default {};

    /**
     * The developers of the module.
     *
     * @return The developers.
     */
    @Nonnull Developer[] developers() default {};
}
