package minevalley.core.api.utils.command;

import minevalley.core.api.Core;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class PlayerCommand implements Command {

    private final CommandOptions description;

    public PlayerCommand() {
        this.description = Objects.requireNonNull(
            getClass().getAnnotation(CommandOptions.class), "Descriptions is null"
        );

        Core.getEventHelper().registerCommand(this);
    }
}