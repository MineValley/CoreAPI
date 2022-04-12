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

    /**
     * This method is called when someone tries to deactivate the maintenance mode.
     * Sometimes modules have special modes which should be deactivated, when players are able to join.
     * If there should be a conflict with leaving the maintenance-mode just return a string with a message that explains the issue.
     *
     * @return string with a message that explains the conflict. null if there isn't a conflict.
     * @deprecated Will be removed in upcoming versions! Use MaintenanceSwitchEvent instead!
     */
    @Deprecated
    public String onLeaveMaintenance() {
        return null;
    }
}