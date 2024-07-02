package minevalley.core.api;

public abstract class CoreModule {

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