package minevalley.core.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import minevalley.core.api.utils.ClickableMessage;

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
    void addClickableMessage(Option option);

    /**
     * Disables a specific clickable message.
     *
     * @param index index of the clickable message to disable (counted from 0)
     */
    void disable(int index);

    @AllArgsConstructor
    @Getter
    class Option {

        final String name, hover;
        final ClickableMessage clickableMessage;
    }
}