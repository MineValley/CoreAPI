package minevalley.core.api;

import lombok.Getter;
import minevalley.core.api.regions.RegionManager;

import java.util.Objects;

@Getter
public abstract class CoreModule {

    private final CoreServer server;
    private final Description description;

    public CoreModule(CoreServer server) {
        this.server = server;

        this.description = Objects.requireNonNull(getClass().getAnnotation(Description.class),
                "Description can not be null");
        new Core(server);
        new RegionManager(server);
    }


    public abstract void onEnable();

    public abstract void onDisable();
}