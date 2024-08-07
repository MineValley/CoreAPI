package minevalley.core.api;

import lombok.Getter;

@Getter
@SuppressWarnings("unused")
public abstract class CoreModule {

    private final Module description;

    public CoreModule() {
        final Class<? extends CoreModule> clazz = getClass();
        if (!clazz.isAnnotationPresent(Module.class)) {
            throw new IllegalArgumentException("Description annotation is missing in module '" + clazz.getSimpleName() + "'");
        }
        this.description = clazz.getAnnotation(Module.class);
    }

    /**
     * Is called when the module is enabled.
     */
    public abstract void onEnable();

    /**
     * Is called when the module is disabled.
     */
    public void onDisable() {

    }

    public void onCleanup() {

    }
}