package minevalley.core.api;

import lombok.Getter;
import minevalley.core.api.regions.RegionManager;

import java.util.Objects;

@Getter
public abstract class CoreModule {

    @Getter
    private static CoreServer server;
    private final Description description;

    public CoreModule(CoreServer coreServer) {
        server = coreServer;
        this.description = Objects.requireNonNull(getClass().getAnnotation(Description.class),
                "Description-Annotation nicht vorhanden!");
        new Core(server);
        new RegionManager(server);
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