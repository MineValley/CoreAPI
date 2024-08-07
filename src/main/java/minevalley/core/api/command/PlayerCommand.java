package minevalley.core.api.command;

import lombok.Getter;
import minevalley.core.api.users.OnlineUser;

import java.util.List;

@Getter
public abstract class PlayerCommand implements Command {

    private final CommandOptions description;

    public PlayerCommand() {
        final Class<? extends PlayerCommand> clazz = getClass();
        if (!clazz.isAnnotationPresent(CommandOptions.class)) {
            throw new IllegalArgumentException("CommandOptions annotation is missing in " + clazz.getSimpleName());
        }
        this.description = clazz.getAnnotation(CommandOptions.class);
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