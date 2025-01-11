package minevalley.core.api;

import minevalley.core.api.utils.ClickableMessage;

@Deprecated(forRemoval = true)
public interface ChatMenu {

    /**
     * Disables every clickable message.
     */
    void disable();

    /**
     * Adds a new option.
     *
     * @param option option to add
     */
    void addOption(Option option);

    /**
     * Disables a specific clickable message.
     *
     * @param index index of the clickable message to disable (counted from 0)
     */
    void disable(int index);

    record Option(String name, String hover, ClickableMessage clickableMessage) {
    }
}