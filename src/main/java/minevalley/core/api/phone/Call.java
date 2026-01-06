package minevalley.core.api.phone;

import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.time.Instant;

@SuppressWarnings("unused")
public interface Call {

    /**
     * Gets the telephone, that started the call.
     *
     * @return telephone that called the partner
     */
    @Nonnull
    @Contract(pure = true)
    Telephone getCaller();

    /**
     * Gets the telephone, that got called.
     *
     * @return telephone that was called by caller
     */
    @Nonnull
    @Contract(pure = true)
    Telephone getPartner();

    /**
     * Gets the time at which the call was started.
     *
     * @return time as instant-object
     */
    @Nonnull
    @Contract(pure = true)
    Instant getBegin();

    /**
     * Ends the current call.
     */
    void end();
}