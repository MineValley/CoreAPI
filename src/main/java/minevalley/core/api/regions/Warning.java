package minevalley.core.api.regions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import minevalley.core.api.User;

@Getter
@AllArgsConstructor
public class Warning {

    /**
     * date - timestamp of creation
     * <br>
     * expiration - timestamp of expiration of this warning.
     * <p>
     *     If the expiration-date is reached, there is a message sent to the team, to check whether the warning is still justified.
     *     If necessary, the residence will be reset.
     * </p>
     */
    private final long date, expiration;

    /**
     * Each warning consists of a text explaining what has to be changed.
     */
    private final String text;

    /**
     * Teamler that created this warning.
     */
    private final User teamler;
}