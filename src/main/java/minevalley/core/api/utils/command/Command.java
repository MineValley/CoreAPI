package minevalley.core.api.utils.command;

import minevalley.core.api.User;

import java.util.List;

/**
 * This interface corresponds to the often used CommandExecutor-interface. It's used very similarly, but has some advantages.
 */
public interface Command {

    /**
     * This is the equivalent to the onCommand-method of the CommandExecutor-interface
     *
     * @param user user who executed this command
     * @param args array of arguments
     * @return response-enum that decides what is sent to the user
     */
    CommandResponse onCommand(User user, String[] args);

    /**
     * This method is used to define the completions displayed when the player presses TAB.
     *
     * @param user user who pressed TAB
     * @param args array of the arguments
     * @return list of the completions to display
     */
    List<String> onTabComplete(User user, String[] args);

    /**
     * This method is used to define whether a user is permissioned to execute/tab this command more precisly than the CommandOptions-Annotation is able to.
     * This is checked, when a user tabs or executes the command. This check will only be called, if the user has the permissions given by the CommandOptions-Annotation.
     * <p>
     * <b>Note:</b> This method should not have any side effects!
     *
     * @param user user who tries to execute/tab the command
     * @return true, if the user is permissioned - false, if he isn't (error-message will be sent automatically)
     */
    boolean isPermissioned(User user);

    enum CommandResponse {
        SUCCESS,
        ABUSE_WARNING,
        WRONG_SYNTAX,
        NO_PERMISSION,
        NONE
    }
}