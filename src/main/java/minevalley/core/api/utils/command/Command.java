package minevalley.core.api.utils.command;

import lombok.NonNull;
import minevalley.core.api.User;

import java.util.List;

/**
 * This interface corresponds to the often used CommandExecutor-interface. It's used very similarly, but has some advantages.
 */
public interface Command {

    /**
     * This is the equivalent to the onCommand-method of the CommandExecutor-interface
     * @param user user who executed this command
     * @param args array of arguments
     * @return response-enum that decides what is sent to the user
     */
    @NonNull
    CommandResponse onCommand(User user, String[] args);

    /**
     * This method is used to define the completions displayed when the player presses TAB.
     * @param user user who pressed TAB
     * @param args array of the arguments
     * @return list of the completions to display
     */
    List<String> onTabComplete(User user, String[] args);

    enum CommandResponse {
        SUCCESS,
        ABUSE_WARNING,
        WRONG_SYNTAX,
        NO_PERMISSIONS
    }
}