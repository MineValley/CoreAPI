package minevalley.core.api.phone;

import java.time.Instant;

public interface Call {

    /**
     * Ends the current call.
     */
    void end();

    /**
     * Gets the phone, that started the call.
     *
     * @return phone-object of caller
     */
    Phone getCaller();

    /**
     * Gets the phone, that got called.
     *
     * @return phone-object of called player
     */
    Phone getPartner();

    /**
     * Gets the time at which the call was started.
     *
     * @return time as instant-object
     */
    Instant getBegin();
}