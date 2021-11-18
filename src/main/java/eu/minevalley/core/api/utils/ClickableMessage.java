package eu.minevalley.core.api.utils;

public interface ClickableMessage {

    void disable();

    ClickableMessage selfCancelling(boolean isSelfCancelling);

    ClickableMessage setCallback(Runnable runnable);

    String getCommand();
}