package minevalley.core.api;

import lombok.Getter;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;

@Getter
@SuppressWarnings("unused")
public abstract class CoreModule {

    private final Module moduleDescription;

    public CoreModule() {
        final Class<? extends CoreModule> clazz = getClass();
        if (!clazz.isAnnotationPresent(Module.class)) {
            throw new IllegalArgumentException("Module annotation is missing in module '" + clazz.getSimpleName() + "'");
        }
        this.moduleDescription = clazz.getAnnotation(Module.class);
    }

    /**
     * Is called when the module is enabled.
     */
    public void onEnable() {
        // do nothing
    }

    /**
     * Is called when the module is disabled.
     */
    public void onDisable() {
        // do nothing
    }

    public void onCleanup() {
        // do nothing
    }

    /**
     * Gets the version of this module.
     *
     * @return the version
     */
    @Nonnull
    @Contract(pure = true)
    public String getVersion() {
        return getClass().getPackage().getImplementationVersion();
    }

    @Nonnull
    @Contract(pure = true)
    public Developer[] getDevelopers() {
        throw new UnsupportedOperationException("getDevelopers is not implemented yet");
    }
}