package minevalley.core.api.smart;

import lombok.Getter;

@Getter
public abstract class SmartApp {

    private final App appDescription;

    public SmartApp() {
        final Class<? extends SmartApp> clazz = getClass();
        if (!clazz.isAnnotationPresent(App.class)) {
            throw new IllegalArgumentException("Module annotation is missing in module '" + clazz.getSimpleName() + "'");
        }
        this.appDescription = clazz.getAnnotation(App.class);
    }

    /**
     * Is called whenever this app is opened by any user.
     *
     * @param session new created session
     */
    public abstract void onSessionCreate(Session session);
}