package minevalley.core.api.utils.command;

import lombok.Getter;
import minevalley.core.api.Core;
import minevalley.core.api.OnlineUser;

import java.util.List;
import java.util.Objects;

@Getter
public abstract class PlayerCommand implements Command {

    private final CommandOptions description;

    public PlayerCommand() {
        this.description = Objects.requireNonNull(
                getClass().getAnnotation(CommandOptions.class), "CommandOptions-Annotation is missing!");
        Core.registerCommand(this);
    }

    @Override
    public List<String> onTabComplete(OnlineUser user, String[] args) {
        return null;
    }

    @Override
    public boolean isPermissioned(OnlineUser user) {
        return true;
    }
}