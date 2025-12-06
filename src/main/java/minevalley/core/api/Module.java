package minevalley.core.api;

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
}
