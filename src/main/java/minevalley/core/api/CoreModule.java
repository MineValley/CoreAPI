package minevalley.core.api;

public abstract class CoreModule {

    private final Description description;

    public CoreModule() {
        final Class<? extends CoreModule> clazz = getClass();
        if (!clazz.isAnnotationPresent(Description.class)) {
            throw new IllegalArgumentException("Description annotation is missing in module '" + clazz.getSimpleName() + "'");
        }
        this.description = clazz.getAnnotation(Description.class);
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