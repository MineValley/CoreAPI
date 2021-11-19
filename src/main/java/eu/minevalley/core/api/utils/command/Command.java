package eu.minevalley.core.api.utils.command;

import eu.minevalley.core.api.User;
import java.util.List;

public interface Command {

    CommandResponse onCommand(User user, String[] args);

    List<String> onTabComplete(User user, String[] args);

    enum CommandResponse {
        SUCCESS,
        ABUSE_WARNING,
        WRONG_SYNTAX,
        NO_PERMISSIONS
    }
}