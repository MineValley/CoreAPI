package minevalley.core.api.command;

import lombok.Getter;
import minevalley.core.api.users.OnlineUser;

import java.util.List;
import java.util.Objects;

@Getter
public abstract class PlayerCommand implements Command {

    private final CommandOptions description;

    public PlayerCommand() {
        this.description = Objects.requireNonNull(
                getClass().getAnnotation(CommandOptions.class), "CommandOptions-Annotation is missing!");
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