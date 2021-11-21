package minevalley.core.api.utils.command;

import lombok.Getter;
import minevalley.core.api.Core;

import java.util.Objects;

@Getter
public abstract class PlayerCommand implements Command {

    private final CommandOptions description;

    public PlayerCommand() {
        this.description = Objects.requireNonNull(
                getClass().getAnnotation(CommandOptions.class), "Descriptions is null");

        Core.getEventHelper().registerCommand(this);
    }
}