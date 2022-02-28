package minevalley.core.api;

import minevalley.core.api.utils.ClickableMessage;

public interface ChatMenu {

    /**
     * Disables every clickable message.
     */
    void disable();

    /**
     * Enables every clickable message.
     */
    void enable();

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

    /**
     * Enables a specific clickable message.
     * @param index index of the clickable message to enable (counted from 0)
     */
    void enable(int index);
}