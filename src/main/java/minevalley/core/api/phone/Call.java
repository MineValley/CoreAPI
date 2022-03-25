package minevalley.core.api.phone;

import java.time.Instant;

public interface Call {

    /**
     * Ends the current call.
     */
    void end();

    /**
     * Gets the telephone, that started the call.
     *
     * @return thelephone that called the partner
     */
    Telephone getCaller();

    /**
     * Gets the telephone, that got called.
     *
     * @return telephone that was called by caller
     */
    Telephone getPartner();

    /**
     * Gets the time at which the call was started.
     *
     * @return time as instant-object
     */
    Instant getBegin();
}