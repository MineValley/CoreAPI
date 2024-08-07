package minevalley.core.api.command;

import lombok.Getter;
import minevalley.core.api.users.OnlineUser;

import java.util.List;

@Getter
@SuppressWarnings("unused")
public abstract class PlayerCommand {

    private final Command description;

    public PlayerCommand() {
        final Class<? extends PlayerCommand> clazz = getClass();
        if (!clazz.isAnnotationPresent(Command.class)) {
            throw new IllegalArgumentException("CommandOptions annotation is missing in " + clazz.getSimpleName());
        }
        this.description = clazz.getAnnotation(Command.class);
    }

    /**
     * This is the equivalent to the onCommand-method of the CommandExecutor-interface
     *
     * @param user user who executed this command
     * @param args array of arguments
     * @return response-enum that decides what is sent to the user
     */
    public abstract CommandResponse onCommand(OnlineUser user, String[] args);

    /**
     * This method is used to define the completions displayed when the player presses TAB.
     *
     * @param user user who pressed TAB
     * @param args array of the arguments
     * @return list of the completions to display
     */
    public List<String> onTabComplete(OnlineUser user, String[] args) {
        return null;
    }

    /**
     * This method is used to define whether a user is permissioned to execute/tab this command.
     * This is checked, when a user tabs or executes the command.
     * <p>
     * <b>Note:</b> This method should not have any side effects!
     *
     * @param user user who tries to execute/tab the command
     * @return true, if the user is permissioned - false, if he isn't (error-message will be sent automatically)
     */
    public boolean isPermissioned(OnlineUser user) {
        return true;
    }

    public enum CommandResponse {
        SUCCESS,
        ABUSE_WARNING,
        WRONG_SYNTAX,
        NO_PERMISSION,
        NONE
    }
}