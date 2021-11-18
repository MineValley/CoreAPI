package eu.minevalley.core.api;

import lombok.Getter;
import lombok.NonNull;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

@Getter
public abstract class CoreModule {

    private final CoreServer server;
    private final Description description;
    private final File configPath;

    public CoreModule(CoreServer server) {
        this.server = server;

        this.description = Objects.requireNonNull(
            getClass().getAnnotation(Description.class), "Description can not be null"
        );

        this.configPath = new File("./modules/" + getDescription().name() + "/");
    }


    public abstract void onEnable();

    public abstract void onDisable();


    @Retention(RetentionPolicy.RUNTIME)
    public @interface Description {

        String name();

        String version() default "1.0";

        String[] authors();
    }
}