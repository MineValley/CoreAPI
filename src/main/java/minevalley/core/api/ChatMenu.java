package minevalley.core.api;

import minevalley.core.api.utils.ClickableMessage;

public interface ChatMenu {

    /**
     * Disables every clickable message.
     */
    void disable();

    /**
     * Adds a new clickable message.
     * @param clickableMessage clickable message to add
     */
    void addClickableMessage(ClickableMessage clickableMessage);

    /**
     * Disables a specific clickable message.
     * @param index index of the clickable message to disable (counted from 0)
     */
    void disable(int index);
}