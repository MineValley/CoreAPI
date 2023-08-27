package minevalley.core.api.regions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import minevalley.core.api.users.User;

@Getter
@AllArgsConstructor
public class Termination {

    /**
     * The date defines the day, this termination will <b>expire</b>. This should always be at least 14 days after the termination itself.
     * There is no need to specify the day of the termination.
     */
    private final long date;

    /**
     * Defines whether this termination is made by the landlord (only available with apartments) or is set up by the system (e.g. by a team member).
     */
    private final Type type;

    /**
     * Specific reason/description.
     */
    private final String reason;

    /**
     * User who was responsible for this termination. This might be null, if the termination was set up by the system.
     */
    private final User user;

    enum Type {
        LANDLORD,
        STATE
    }
}